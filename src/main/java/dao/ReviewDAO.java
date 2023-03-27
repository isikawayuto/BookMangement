package dao;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;

import dto.Review;

public class ReviewDAO {

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

    public static boolean createReview(Review review) {
        String sql = "INSERT INTO reviews (review_id, isbn, email, comment, point, view_flag, created_at) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, UUID.randomUUID().toString());
            pstmt.setString(2, review.getIsbn());
            pstmt.setString(3, review.getEmail());
            pstmt.setString(4, review.getComment());
            pstmt.setInt(5, review.getPoint());
            pstmt.setBoolean(6, review.isView_flag());
            pstmt.setObject(7, review.getCreated_at());

            int result = pstmt.executeUpdate();

            if (result == 1) {
                return true;
            }
        } catch (SQLException | URISyntaxException e) {
            e.printStackTrace();
        }
        return false;
    }

}