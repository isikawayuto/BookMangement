package servlet;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ReviewDAO;
import dto.Review;

@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        String isbn = request.getParameter("isbn");
        String email = request.getParameter("email");
        String comment = request.getParameter("comment");
        int point = Integer.parseInt(request.getParameter("point"));
        boolean viewFlag = Boolean.parseBoolean(request.getParameter("view_flag"));

        LocalDateTime createdAt = LocalDateTime.now();

        Review review = new Review(0, isbn, email, comment, point, viewFlag, createdAt);

        if (ReviewDAO.createReview(review)) {
            response.sendRedirect("reviewsuccess.jsp");
        } else {
            String view = "/WEB-INF/view/review.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(view);
            dispatcher.forward(request, response);
        }
    }
}