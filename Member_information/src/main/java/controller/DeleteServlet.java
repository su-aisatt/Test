package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.MemberDao;
import exception.MembershipException;

/**
 * 会員情報削除のサーブレットクラス
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {

	/**
	 * "削除"ボタン押下で処理を行う。(param userid)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nextPage = null;

		try {

			String user_id = request.getParameter("user_id");
			
			// 会員情報の取得
			MemberDao memberDao = new MemberDao();
			memberDao.deleteMember(user_id);
			
			// 一覧画面を表示する準備
			nextPage = "list.jsp";

		} catch (MembershipException e) {

			String message = e.getMessage();
			request.setAttribute("message", message);
			request.setAttribute("error", "true");

		}

		// 次の画面に遷移
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
		requestDispatcher.forward(request, response);

	}
}