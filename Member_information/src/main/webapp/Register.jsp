<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会員情報登録</title>
</head>
<!-- 共通パーツ（ヘッダー） -->
<jsp:include page="common/header.jsp" />
<body>
	<div class="sidebar" />
	<!-- 共通パーツ（ナビ） -->
	<jsp:include page="common/navi.jsp" />
	</div>
	<!-- 詳細部分 -->
	<section class="py-5">
		<div class="row justify-content-center">
			<div class="media-container-column col-lg-8">
				<h1 class="my-4">会員登録</h1>
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
				<form action="RegisterServlet" method="post">
					<div class="row">
						<div class="col-md-12 form-group">
							<label class="form-control-label">ユーザー名</label> <input
								type="text" name="user_name" required="required"
								placeholder="山田太郎" minlength="5" maxlength="10"
								class="form-control">
						</div>
						<p id="validate_msg" style="color: red;"></p>
						<div class="col-md-12 form-group">
							<label class="form-control-label">メールアドレス</label> <input
								type="text" name="mail" placeholder="sample@sample.jp"
								maxlength="255" class="form-control">
						</div>
						<div class="col-md-12 form-group">
							<label class="form-control-label">電話番号</label> <input type="text"
								name="tel" required="required" placeholder="09012345678"
								pattern="0[1-9]0[0-9]{8}|0[1-9]{3}[0-9]{6}"
								oninput="value = NumberOnly(value)" title="ハイフンなしで入力してください。"
								class="form-control">
						</div>
						<div class="col-md-12 form-group">
							<label class="form-control-label">住所</label> <input type="text"
								name="address" placeholder="東京都千代田区霞が関" maxlength="50"
								class="form-control">
						</div>
						<div class="col-md-12 form-group">
							<label class="form-control-label">生年月日</label> <input type="date"
								name="birthday" required="required" class="form-control">
						</div>
						<div class="col-md-12 form-group">
							<label class="form-control-label">職業</label> <input type="text"
								name="job" placeholder="エンジニア" maxlength="50"
								class="form-control">
						</div>
						<div class="col-md-12 form-group">
							<label class="form-control-label">パスワード</label> <input
								type="password" name="password" required="required"
								minlength="5" maxlength="10" class="form-control">
						</div>
						<button class="btn btn-primary btn-form display-4" type="submit"
							onclick="return testCheck()">登録</button>
				</form>
			</div>
		</div>
	</section>
	<!-- 共通パーツ（フッター） -->
	<jsp:include page="common/footer.jsp" />
</body>
</html>