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
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery読み込み -->
<script src="js/jquery-3.3.1.min.js"></script>
<!-- BootstrapのJS読み込み -->
<script src="js/bootstrap.min.js"></script>
<title>エラーサマリ</title>
</head>
<body>
	<div class="container">
		<div class="container">
			<%-- エラーメッセージ --%>
			<span style="color: #ff0000;"><c:out
					value="${requestScope.errorMessage }" /></span>

			<h2>エラーサマリ</h2>
			<form action="ShowErrorSamary" method="post">

				<h3>検索ボックス</h3>
				<div class="table-responsive">
					<table class="table table-condensed">
						<tr>
							<td class="col-xs-3">発生ノード/系列</td>
							<td class="col-xs-9"><input type="text" name="nodeName"
								value="<c:out value="${requestScope.searchKeyBean.nodeName }" />"></td>
						</tr>
						<tr>
							<td class="col-xs-3">プロダクト名/モジュール名</td>
							<td class="col-xs-9"><input type="text" name="productName"
								value="<c:out value="${requestScope.searchKeyBean.productName }" />"></td>
						</tr>
						<tr>
							<td class="col-xs-3">詳細内容</td>
							<td class="col-xs-9"><input type="text" name="detail"
								value="<c:out value="${requestScope.searchKeyBean.detail }" />"></td>
						</tr>
					</table>
				</div>
				<br>
				<button type="submit" value="検索" class="btn btn-lg btn-primary">検索</button>
				<a href="ShowErrorSamary">全件表示する</a>
			</form>

			<form action="SelectProcessServlet" method="post">

				<h3>メッセージ一覧</h3>
				<div class="table-responsive">
					<table border="1"
						class="table table-striped table-hover table-condensed">
						<thead>
							<tr class="info">
								<th class="col-xs-1">選択</th>
								<th class="col-xs-1">発生日/報告受領日</th>
								<th class="col-xs-4">詳細内容</th>
								<th class="col-xs-1">発生時刻</th>
								<th class="col-xs-1">発生ノード<br>/系列
								</th>
								<th class="col-xs-1">プロダクト名<br>/モジュール名
								</th>
								<th class="col-xs-3">初動対応</th>

							</tr>
						</thead>
						<tbody>
							<c:forEach var="message"
								items="${sessionScope.messageEntityList }">
								<tr>
									<td><input type="radio" name="selectIncidentNumber"
										value="${message.incidentNumber }"></td>
									<td><c:out value="${message.incidentDate }" /></td>
									<td><c:out value="${message.detail }" /></td>
									<td><c:out value="${message.incidentTime }" /></td>
									<td><c:out value="${message.nodeName }" /></td>
									<td><c:out value="${message.productName }" /></td>
									<td><c:out value="${message.content }" /></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<br>
				<button type="submit" value="詳細" name="detail"
					class="btn btn-lg btn-primary">詳細</button>
				<br> <br>
				<button type="submit" value="編集" name="modify"
					class="btn btn-lg btn-success">編集</button>
				<button type="submit" value="削除" name="delete"
					class=" btn btn-lg btn-danger">削除</button>
				<button type="submit" value="新規登録" name="regist"
					class="btn btn-lg btn-warning">新規登録</button>
			</form>
			<br> <a href="ShowMenuServlet">メニューへ戻る</a>
		</div>
	</div>
</body>
</html>