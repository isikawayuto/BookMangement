package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminDAO;
import dto.Book;
import dto.Genre;

@WebServlet("/BookRegistrationServlet")
public class BookRegistrationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public BookRegistrationServlet() {
        super();
    }
    @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            try {
                List<Genre> genres = AdminDAO.getGenres();
                request.setAttribute("genres", genres);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/view/Bookregister.jsp");
            dispatcher.forward(request, response);
        }
       
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // Get the parameters from the request
        String isbn = request.getParameter("isbn");
        String idParam = request.getParameter("id");
        if (idParam == null) {
        } else {
            int id = Integer.parseInt(idParam);
        int genre_id = Integer.parseInt(request.getParameter("genre_id"));
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String publisher = request.getParameter("publisher");
        String newOldParam = request.getParameter("new_old");
        boolean new_old = newOldParam != null && Boolean.parseBoolean(newOldParam);
        String title_kana = request.getParameter("title_kana");
        String author_kana = request.getParameter("author_kana");

        Book book = new Book(isbn, id, genre_id, title, author, publisher, new_old, title_kana, author_kana);
        try {
            boolean isSuccess = AdminDAO.registerBook(book);

            if (isSuccess) {
                response.sendRedirect("RegisterSuccessServlet");
            } else {
                response.sendRedirect("RegisterFailServlet?isbn=" + isbn + "&id=" + id + "&genre_id=" + genre_id + "&title=" + title + "&author=" + author + "&publisher=" + publisher + "&new_old=" + new_old + "&title_kana=" + title_kana + "&author_kana=" + author_kana);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, e.getMessage());
        	}
        }
    }
}
