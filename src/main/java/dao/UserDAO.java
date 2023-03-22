package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.Account;
import util.GenerateHashedPw;
import util.GenerateSalt;

public class UserDAO {
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
	
	public static int registerAccount(Account ac){
		String sql = "INSERT INTO users VALUES(?, ?, ?, ?)";
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
		String sql = "SELECT salt FROM users WHERE mail = ?";
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
	public static Account login(String mail, String hashedPw) {
		String sql = "SELECT * FROM users WHERE mail = ? AND password = ?";
		
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
					
					return new Account(mail, name, salt, hashedPw);
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
		
		String sql = "DELETE FROM users WHERE mail = ?";
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
	
}
