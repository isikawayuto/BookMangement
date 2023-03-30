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

import dto.Admin;
import dto.Book;
import dto.Genre;
import util.GenerateHashedPw;
import util.GenerateSalt;

public class AdminDAO {
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
	
	public static int registerAccount(Admin ac){
		String sql = "INSERT INTO admin VALUES(?, ?, ?, ?)";
		int result = 0;
		
		// ランダムなソルトの取得(今回は32桁で実装)
		String salt = GenerateSalt.getSalt(32);
		
		// 取得したソルトを使って平文PWをハッシュ
		String hashedPw = GenerateHashedPw.getSafetyPassword(ac.getPassword(), salt);
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				
				){
			pstmt.setString(1, ac.getMail());
			pstmt.setString(2, ac.getName());
			pstmt.setString(3, salt);
			pstmt.setString(4, hashedPw);

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件登録しました。");
		}
		return result;
	}
	
	// メールアドレスを元にソルトを取得
	public static String getSalt(String mail) {
		String sql = "SELECT salt FROM admin WHERE mail = ?";
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, mail);

			try (ResultSet rs = pstmt.executeQuery()){
				
				if(rs.next()) {
					String salt = rs.getString("salt");
					return salt;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// ログイン処理
	public static Admin login(String mail, String hashedPw) {
		String sql = "SELECT * FROM admin WHERE mail = ? AND password = ?";
		
		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			pstmt.setString(1, mail);
			pstmt.setString(2, hashedPw);

			try (ResultSet rs = pstmt.executeQuery()){
				
				if(rs.next()) {
					String name = rs.getString("name");
					String salt = rs.getString("salt");
					
					return new Admin(mail, name, salt, hashedPw);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static int DeleteAccount(String mail){
		
		String sql = "DELETE FROM admin WHERE mail = ?";
		int result = 0;

		try (
				Connection con = getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql);
				){
			
			pstmt.setString(1, mail);

			result = pstmt.executeUpdate();
		} catch (SQLException | URISyntaxException e) {
			e.printStackTrace();
		} finally {
			System.out.println(result + "件削除しました。");
		}
		return  result;
	}
	public static List<Book> getAllBooks() throws SQLException {
	    List<Book> bookList = new ArrayList<>();
	    String sql = "SELECT * FROM books";

	    try (Connection con = getConnection();
	         PreparedStatement ps = con.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {

	        while (rs.next()) {
	            Book book = new Book();
	            book.setid(rs.getInt("id"));
	            book.setTitle(rs.getString("title"));
	            book.setAuthor(rs.getString("author"));
	            book.setPublisher(rs.getString("publisher"));
	            book.setIsbn(rs.getString("isbn"));
	            bookList.add(book);
	        }
	    } catch (SQLException | URISyntaxException e) {
	        e.printStackTrace();
	    }

	    return bookList;

	}
	   public static boolean registerBook(Book book) throws SQLException {
		   boolean isSuccess = false;
	        String sql = "INSERT INTO book (isbn, id, genre_id, title, author, publisher, new_old, title_kana, author_kana) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	        try (Connection conn = getConnection();
	             PreparedStatement pstmt = conn.prepareStatement(sql)) {

	            pstmt.setString(1, book.getIsbn());
	            pstmt.setInt(2, book.getid());
	            pstmt.setInt(3, book.getGenre_id());
	            pstmt.setString(4, book.getTitle());
	            pstmt.setString(5, book.getAuthor());
	            pstmt.setString(6, book.getPublisher());
	            pstmt.setBoolean(7, book.getNew_old());
	            pstmt.setString(8, book.getTitle_kana());
	            pstmt.setString(9, book.getAuthor_kana());

	            pstmt.executeUpdate();
	        } catch (SQLException | URISyntaxException e) {
		        e.printStackTrace();
		    }
	        return isSuccess;
		}
	   public static List<Genre> getGenres() throws SQLException {
	        List<Genre> genres = new ArrayList<>();
	        String sql = "SELECT * FROM genre";
	        
	        try (Connection conn = getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	             
	            ResultSet rs = stmt.executeQuery();
	            
	            while (rs.next()) {
	                int id = rs.getInt("id");
	                String name = rs.getString("name");
	                Genre genre = new Genre(id, name);
	                genres.add(genre);
	            	}
	            } catch (SQLException | URISyntaxException e) {
			        e.printStackTrace();
			   }
	        
	        return genres;
	    }
	}

