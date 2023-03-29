package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDAO;
import dto.BookDTO;

/**
 * Servlet implementation class Certification
 */
@WebServlet("/RentalScrean")
public class RentalScrean extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RentalScrean() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String ISBN = request.getParameter("isbn");
		String title = request.getParameter("title");
		String Publisher = request.getParameter("Publisher");
		String Author = request.getParameter("Author");
		int genre = Integer.parseInt(request.getParameter("genre"));
		boolean judge = Boolean.valueOf(request.getParameter("judge"));
		
		List<BookDTO> select = BookDAO.selectBook(ISBN, title, Publisher, Author, genre, judge);
		
		HttpSession session = request.getSession();
		session.setAttribute("select", select);
		
		String genre_name = BookDAO.selectGenre(genre);
		HttpSession session2 = request.getSession();
		session2.setAttribute("genre_name", genre_name);
		
		String view = "WEB-INF/view/RentalScrean.jsp";
		RequestDispatcher dispatcher = request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
