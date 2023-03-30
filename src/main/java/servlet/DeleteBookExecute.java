package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdminBookDAO;
import dto.Book;

/**
 * Servlet implementation class DeleteBookExecute
 */
@WebServlet("/DeleteBookExecute")
public class DeleteBookExecute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBookExecute() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		// フォーム入力内容の取得
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
		
		// 入力された情報を元にインスタンスを生成
		Book bo = new Book(-1, isbn, genre_id, title, author, publisher, new_old, title_kana, author_kana);
		
		// SQL実行
		int result = AdminBookDAO.deleteBook(bo);
		
		String view = "";
		if(result == 1) {
			view = "WEB-INF/view/BookDeleteSuccess.jsp";
		} else {
			// 失敗した場合はパラメータ付きで登録画面に戻す
			view = "WEB-INF/view/BookDeleteForm.jsp?error=1";
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
