package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.MemberDao;
import exception.MembershipException;
import model.MemberInformation;

/**
 * 会員情報登録画面のサーブレットクラス
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	/**
	 * 会員情報の登録・更新処理
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 画面に入力された会員情報を取得
		request.setCharacterEncoding("UTF-8");
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
			MemberInformation memberInfo = new MemberInformation(username, usermail, usertel,
					useraddress, userbirthday, userjob, userpassword);

			// 新規登録
			memberDao.insertMember(memberInfo);
			message = "会員情報を登録しました";


		} catch (MembershipException e) {
			message = e.getMessage();
			request.setAttribute("error", "true");
			e.printStackTrace();
		}
		// 次の画面に遷移
		request.setAttribute("message", message);
		request.getRequestDispatcher("Register.jsp").forward(request, response);
	}
}