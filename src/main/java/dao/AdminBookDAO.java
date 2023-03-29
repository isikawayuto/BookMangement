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

import dto.Book;

public class AdminBookDAO {
	private static Connection getConnection() throws URISyntaxException, SQLException {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    URI dbUri = new URI(System.getenv("DATABASE_URL"));

	    String username = dbUri.getUserInfo().split(":")[0];
	    String password = dbUri.getUserInfo().split(":")[1];
	    String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

	    return DriverManager.getConnection(dbUrl, username, password);
	}
	
	public static int registerBook(Book bo) {
		String sql = "INSERT INTO book VALUES(default, ?, ?, ?, ?, ?, ?, ?, ?)";
		int result = 0;
				
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, bo.getIsbn());
			pstmt.setInt(2, bo.getGenre_id());
			pstmt.setString(3, bo.getTitle());
			pstmt.setString(4, bo.getAuthor());
			pstmt.setString(5, bo.getPublisher());
			pstmt.setBoolean(6, bo.getNew_old());
			pstmt.setString(7, bo.getTitle_kana());
			pstmt.setString(8, bo.getAuthor_kana());
			

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件更新しました。");
		}
		return result;
	}

	public static int deleteBook(Book bo) {
		
		String sql = "DELETE FROM book WHERE book_id = ? AND isbn = ?";

		// return用の変数
		int result = 0;
		
		try (
				Connection con = getConnection();	// DB接続
				PreparedStatement pstmt = con.prepareStatement(sql);			// 構文解析
				){

			pstmt.setInt(1, bo.getBook_id());
			pstmt.setString(2, bo.getIsbn());
		
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		} finally {
			System.out.println(result + "件削除しました。");
		}
		return result;
	}
	public static List<Book> selectBook() {
		
		// 返却用変数
		List<Book> result = new ArrayList<>();

		String sql = "SELECT * FROM book";
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			try (ResultSet rs = pstmt.executeQuery()){
				while(rs.next()) {
					String isbn = rs.getString("isbn");
					int genre_id = rs.getInt("genre_id");
					String title = rs.getString("title");
					String author = rs.getString("author");
					String publisher = rs.getString("publisher");
					boolean new_old = rs.getBoolean("new_old");
					String title_kana = rs.getString("title_kana");
					String author_kana = rs.getString("author_kana");
					Book book = new Book(-1, isbn, genre_id, title, author, publisher, new_old, title_kana, author_kana);
					
					result.add(book);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Throwable e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

		// Listを返却する。0件の場合は空のListが返却される。
		return result;
	}
	
}
