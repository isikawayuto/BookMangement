package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.BookDTO;

public class RentalConfirmationDAO {
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
	
	
	public static BookDTO Booklogin(String book_id, String isbn) {
		String sql = "SELECT * FROM Book WHERE book_id = ? AND isbn = ?";
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, book_id);
			pstmt.setString(2, isbn);

			try (ResultSet rs = pstmt.executeQuery()){
				
				if(rs.next()) {
					 book_id = rs.getString("book_id");
					 isbn = rs.getString("isbn");
					 int genre_id = rs.getInt("genre_id");
					 String title = rs.getString("title");
					 String author = rs.getString("author");
					 String publisher = rs.getString("publisher");
					 boolean new_old = rs.getBoolean("new_old");
					 String title_kana = rs.getString("title_kana");
					 String author_kana = rs.getString("author_kana");
					 
					 
					
					return new BookDTO(book_id,isbn,genre_id,title,author,publisher,new_old,title_kana,author_kana);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}


	}

	
