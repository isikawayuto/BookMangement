package servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RentalConfirmationDAO;
import dto.BookDTO;
import dto.Lending;
import dto.Users;

/**
 * Servlet implementation class Certification
 */
@WebServlet("/ReturnConfirmation")
public class ReturnConfirmaton extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnConfirmaton() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String isbn = request.getParameter("isbn");
		String book_id = request.getParameter("book_id");
		
		
		BookDTO book = RentalConfirmationDAO.Booklogin(book_id,isbn);
		
		LocalDate date_now = LocalDate.now();
		LocalDate deadline;
		if(book.getNew_old() == false) {
			deadline = date_now.plusDays(14);
		}else {
			deadline = date_now.plusDays(7);
		}
		
		
		
		HttpSession session = request.getSession();
		HttpSession session2 = request.getSession();
		
		Users users = (Users) session2.getAttribute("user");
		HttpSession session3 = request.getSession();
		
		Lending len = new Lending(-1, users.getMail(), book.getBook_id(), date_now, deadline, null);
		
		session.setAttribute("book_Date", book);
		
		session2.setAttribute("user", users);
		
		session3.setAttribute("len", len);
		
		String view = "WEB-INF/view/ReturnConfirmation.jsp";
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
