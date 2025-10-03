package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.MemberDao;
import exception.MembershipException;
import model.MemberInformation;

/**
 * 会員情報編集画面のサーブレットクラス
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 画面に入力された会員情報を取得
		request.setCharacterEncoding("UTF-8");
		String userid = request.getParameter("user_id");
		String username = request.getParameter("user_name");
		String usermail = request.getParameter("mail");
		String usertel = request.getParameter("tel");
		String useraddress = request.getParameter("address");
		String userbirthday = request.getParameter("birthday");
		String userjob = request.getParameter("job");
		String userpassword = request.getParameter("password");
		
		String message = null; // 処理後に画面に表示するメッセージ
		try {

			MemberDao memberDao = new MemberDao();

			// DAOクラスに渡すために会員情報クラスに値を格納
			MemberInformation memberInfo = new MemberInformation(userid, username, usermail, usertel,
					useraddress, userbirthday, userjob, userpassword);

			// 会員情報編集
			memberDao.editMember(memberInfo);
			message = "会員情報を更新しました";

		} catch (MembershipException e) {
			message = e.getMessage();
			request.setAttribute("error", "true");
			e.printStackTrace();
		}
		
		request.setAttribute("message", message);
		// 変更箇所のユーザーIDをリクエストスコープにセット
		request.setAttribute("userid", userid);
		// 次の画面に遷移
		request.getRequestDispatcher("list.jsp").forward(request, response);

	}

	/**
	 * "編集"ボタン押下で処理を行う。(param userid)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nextPage = null;

		try {

			String user_name = null;
			String user_id = request.getParameter("user_id");
			
			// 会員情報の取得
			MemberDao memberDao = new MemberDao();
			List<MemberInformation> memberList = memberDao.findMember(user_id, user_name);

			// 取得した編集情報をリクエストスコープにセット
			request.setAttribute("memberList", memberList);
			
			// 一覧画面を表示する準備
			nextPage = "Edit.jsp";

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