<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="model.MemberInformation"%>
<!DOCTYPE html>
<html>
<!-- 共通パーツ（ヘッダー） -->
<jsp:include page="common/header.jsp" />
<body>
	<!-- 共通パーツ（ナビ） -->
	<jsp:include page="common/navi.jsp" />
	<div class="align-items-center py-5">
		<div class="container">
			<div class="row">
				<div class="col-md-9 col-lg-8 mx-auto">
					<h3 class="login-heading my-4">会員検索</h3>
					<form action="SearchServlet" method="post">
						<!-- ユーザーID -->
						<div class="form-label-group">
							<input type="text" id="id" name="user_id" class="form-control">
							<label for="id">ユーザーID</label>
						</div>
						<!-- ユーザー名 -->
						<div class="form-label-group">
							<input type="password" id="password" name="user_name"
								class="form-control"> <label for="passowrd">ユーザー名</label>
						</div>
						<button
							class="btn btn-lg btn-primary btn-block btn-login font-weight-bold mb-2"
							type="submit">検索</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="align-items-center py-5">
	<div class="container">
	<h3>検索結果</h3>
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
			</tr>
		</thead>
		<!-- 一覧部分 -->
		<!-- データベースから取得した会員情報一覧をリクエストスコープから取得 -->
		<tbody>
			<%
			List<MemberInformation> memberList = (List<MemberInformation>) request.getAttribute("memberList");
			%>
			<%
			if (memberList != null) {
					//拡張for文
					for (MemberInformation memberinfo : memberList) {
			%>
			<tr>
				<td><%=memberinfo.getUserId()%></td>
				<td><%=memberinfo.getUserName()%></td>
				<td><%=memberinfo.getUserMail()%></td>
				<td><%=memberinfo.getUserTel()%></td>
				<td><%=memberinfo.getUserAddress()%></td>
				<td><%=memberinfo.getUserBirthday()%></td>
				<td><%=memberinfo.getUserJob()%></td>
				<td><%=memberinfo.getUser_Created_Datetime()%></td>
				<td><%=memberinfo.getUser_Updated_Datetime()%></td>
			</tr>
			<%
			     }
			}
			%>
		</tbody>
	</table>
	</div>
	</div>
	<!-- 共通パーツ（フッター） -->
	<jsp:include page="common/footer.jsp" />
</body>
</html>