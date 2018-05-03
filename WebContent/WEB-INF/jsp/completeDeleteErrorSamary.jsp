<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%-- IEブラウザ依存処理 --%>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%-- レスポンシブデザインに対応 --%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- BootstrapのCSS読み込み -->
<link href="/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery読み込み -->
<script src="/js/jquery-3.3.1.min.js"></script>
<!-- BootstrapのJS読み込み -->
<script src="/js/bootstrap.min.js"></script>
<title>メッセージ削除完了画面</title>
</head>
<body>
	<%-- エラーメッセージ --%>
	<span style="color: #ff0000;"><c:out
			value="${requestScope.errorMessage }" /></span>

	<h3>メッセージ削除完了</h3>
	<div class="container">削除が完了しました</div>
	<br>
	<br>
	<a href="ShowErrorSamary">一覧画面へ</a>
	<br>
	<a href="ShowMenuServlet">メニューへ戻る</a>

</body>
</html>