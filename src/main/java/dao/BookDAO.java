package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.BookDTO;

public class BookDAO {
	private static Connection getConnection() throws URISyntaxException, SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("OK");
		}
	    URI dbUri = new URI(System.getenv("DATABASE_URL"));

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

	    return DriverManager.getConnection(dbUrl, username, password);
	}
	public static List<BookDTO> selectBook(String isbn, String title, String Publisher, String Author, int genre, boolean judge){
		
		
		String sql = "SELECT * FROM book WHERE isbn = ? and title = ? and publisher = ? and Author= ? and genre = ? and new_old = ? ";
		List<BookDTO> result = new ArrayList<>();
				
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			
			pstmt.setString(1, isbn);
			pstmt.setString(2, title);
			pstmt.setString(3, Publisher);
			pstmt.setString(4, Author);
			pstmt.setInt(5, genre);
			pstmt.setBoolean(6, judge);
			
			
			try (ResultSet rs = pstmt.executeQuery()){
				
				while(rs.next()) {
					int id = rs.getInt("id");
					String get_isbn = rs.getString("isbn");
					int genre_id = rs.getInt("gnere_id");
					String get_title = rs.getString("title");
					String get_Author = rs.getString("author");
					String get_Publisher = rs.getString("publisher");
					boolean new_old = rs.getBoolean("new_old");
					String title_kana = rs.getString("title_kana");
					String Author_kana = rs.getString("author_kana");
					

					BookDTO b = new BookDTO(id, get_isbn, genre_id, get_title, get_Author,  get_Publisher, new_old, title_kana, Author_kana);
					
					result.add(b);
				}
			}
			
		} catch (SQLException | URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result.size() + "件ヒットしました。");
		}

		return result;
	}
	public static String selectGenre(int genre_id){
		
		
		String sql = "SELECT * FROM genre WHERE id = ? ";
				
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			
			pstmt.setInt(1, genre_id);
			
			
			try (ResultSet rs = pstmt.executeQuery()){
				
				if(rs.next()) {
					int id = rs.getInt("id");
					String name = rs.getString("name");
					
					return name;
				}
			}
			
		} catch (SQLException | URISyntaxException e) {
			e.printStackTrace();
		}
		return "error";
	}
}
