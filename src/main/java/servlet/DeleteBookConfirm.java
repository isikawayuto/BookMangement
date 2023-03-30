package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Book;

/**
 * Servlet implementation class DeleteBookConfirm
 */
@WebServlet("/DeleteBookConfirm")
public class DeleteBookConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBookConfirm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String isbn = request.getParameter("isbn");
		String genre_idStr = request.getParameter("genre_id");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		String new_oldStr = request.getParameter("new_old");
		String title_kana = request.getParameter("title_kana");
		String author_kana = request.getParameter("author_kana");
		
		int genre_id = Integer.parseInt(genre_idStr);
		boolean new_old = Boolean.parseBoolean(new_oldStr);
		
		Book book = new Book(-1, isbn, genre_id, title, author, publisher, new_old, title_kana, author_kana);
		
		// セッションスコープのインスタンス取得
		HttpSession session = request.getSession();
		
		// セッションスコープに値の保存
		// 第1引数：キー
		// 第2引数：保存する値
		session.setAttribute("input_data", book);
		
		String view = "WEB-INF/view/BookDeleteConfirm.jsp";
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
