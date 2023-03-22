package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AdminDAO;
import dto.Account;

/**
 * Servlet implementation class AdminExecute
 */
@WebServlet("/AdminExecute")
public class AdminExecute extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminExecute() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		// 入力データの取得
		Account account = (Account)session.getAttribute("Admin");
		
		// 登録処理
		int result = AdminDAO.registerAccount(account);
		
		String path = "";
		if(result == 1) {
			// 登録に成功したので、sessionのデータを削除
			session.removeAttribute("Admin");
			
			path = "WEB-INF/view/AdminSuccess.jsp";
		} else {
			// 失敗した場合はパラメータ付きで登録画面に戻す
			path = "WEB-INF/view/AdminRegister.jsp?error=1";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
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
