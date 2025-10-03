<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.MemberInformation"%>
<%@ page import="dao.MemberDao"%>
<%@ page import="controller.RegisterServlet"%>
<%@ page import="controller.MemberServlet"%>
<%@ page import="controller.DeleteServlet"%>
<!DOCTYPE html>
<html>
<!-- 共通パーツ（ヘッダー） -->
<jsp:include page="common/header.jsp" />
<body>
	<!-- 共通パーツ（ナビ） -->
	<jsp:include page="common/navi.jsp" />
	<!-- 一覧表示 -->
	<section class="py-5">
		<div class="container">
			<h1 class="my-4">会員一覧</h1>
			<%
			String message = (String) request.getAttribute("message");
			%>
			<%
			if (message != null) {
			%>
			<div class="alert alert-success" role="alert">
				<%=message%>
			</div>
			<%
			}
			%>
			<!-- 会員一覧 -->
			<table class="table table-hover">
				<!-- 見出し部分 -->
				<thead class="thead-dark">
					<tr>
						<th scope="col">ユーザーID</th>
						<th scope="col">ユーザー名</th>
						<th scope="col">メールアドレス</th>
						<th scope="col">電話番号</th>
						<th scope="col">住所</th>
						<th scope="col">生年月日</th>
						<th scope="col">職業</th>
						<th scope="col">登録日</th>
						<th scope="col">更新日</th>
						<th scope="col"></th>
						<th scope="col"></th>
					</tr>
				</thead>
				<!-- 一覧部分 -->
				<!-- データベースから取得した会員情報一覧をリクエストスコープから取得 -->
				<tbody>
					<%
					MemberDao memberDao = new MemberDao();
					List<MemberInformation> memberList = memberDao.findAllMember();
					%>
					<%
					//拡張for文
					for (MemberInformation memberinfo : memberList) {
					%>
					<tr>
						<!-- 編集したレコードのユーザーIDをリクエストスコープから取得 -->
						<%
						if (request.getAttribute("userid") != null) {

							String user_id = memberinfo.getUserId();
							String userid = (String) request.getAttribute("userid");

							// 編集したレコードの場合は色を付ける。
							if (user_id.equals(userid)) {
						%>
					
					<tr style="background-color: yellow; color: black;">
						<%
						    }
						}
						%>
						<td><%=memberinfo.getUserId()%></td>
						<td><%=memberinfo.getUserName()%></td>
						<td><%=memberinfo.getUserMail()%></td>
						<td><%=memberinfo.getUserTel()%></td>
						<td><%=memberinfo.getUserAddress()%></td>
						<td><%=memberinfo.getUserBirthday()%></td>
						<td><%=memberinfo.getUserJob()%></td>
						<td><%=memberinfo.getUser_Created_Datetime()%></td>
						<td><%=memberinfo.getUser_Updated_Datetime()%></td>
						<td><a class="btn btn-primary"
							href="EditServlet?user_id=<%=memberinfo.getUserId()%>">編集</a></td>
						<td><a class="btn btn-danger"
							href="DeleteServlet?user_id=<%=memberinfo.getUserId()%>">削除</a></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>
		</div>
	</section>
	<!-- 共通パーツ（フッター） -->
	<jsp:include page="common/footer.jsp" />
</body>
</html>