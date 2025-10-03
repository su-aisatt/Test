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
 * 会員情報一覧画面のサーブレットクラス
 */
@WebServlet("/MemberServlet")
public class MemberServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nextPage = null;
		try {
			// 会員情報一覧の取得
			MemberDao memberDao = new MemberDao();
			List<MemberInformation> memberList = memberDao.findAllMember();

			// 取得した会員情報一覧をリクエストスコープにセット
			request.setAttribute("memberList", memberList);

			// 一覧表示画面を表示する準備
			nextPage = "list.jsp";

		} catch (MembershipException e) {
			// 一覧処理中に例外が発生した場合はログイン画面に遷移させる
			// 一覧が表示できない可能性があるため
			String message = e.getMessage();
			request.setAttribute("message", message);
			request.setAttribute("error", "true");

			// 登録画面を表示する準備
			nextPage = "Register.jsp";
		}

		// 次の画面に遷移
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(nextPage);
		requestDispatcher.forward(request, response);
	}

}