package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminBookDAO;
import dto.Book;

/**
 * Servlet implementation class RegisterBook
 */
@WebServlet("/RegisterBook")
public class RegisterBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//処理の始めにログイン状態のチェックを行う。
				HttpSession session = request.getSession();
				Book book = (Book)session.getAttribute("admin");

				if(book == null){
				//セッションの中身がnullであれば不正アクセスと判断し
				//ログイン画面へ戻る
				String view = "./";
				RequestDispatcher dispatcher = request.getRequestDispatcher(view);
				dispatcher.forward(request, response);
				return;
				}
						
				// 入力されたパラメータの取得
				request.setCharacterEncoding("UTF-8");
				String genre_idStr = request.getParameter("genre_id");	
				String title = request.getParameter("title");
				String author = request.getParameter("author");
				String isbn = request.getParameter("isbn");
				String publisher = request.getParameter("publisher");
				String new_old = request.getParameter("new_old");
				int no = Integer.parseInt(new_old);	
				String new_oldStr = no == 0 ? "新書" : "旧書";
				String title_kana = request.getParameter("title_kana");
				String author_kana = request.getParameter("author_kana");
						
				int genre_id = Integer.parseInt(genre_idStr);
						
				Book bo = new Book(-1, isbn, genre_id, title, author, publisher, new_oldStr, title_kana, author_kana);
						
				int result = AdminBookDAO.registerBook(bo);

				String view = "";
				if(result==0) {
					view = "WEB-INF/view/BookRegisterForm.jsp?error=1";
				} else {
					view = "WEB-INF/view/BookRegisterConfirm.jsp";
				}
						
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
