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
<title>詳細エラーサマリ</title>
</head>
<body>
	<%-- エラーメッセージ --%>
	<span style="color: #ff0000;"><c:out
			value="${requestScope.errorMessage }" /></span>

	<h3>詳細メッセージ一覧</h3>
	<div class="container">
		<div class="table-responsive">
			<table border="1" class="table table-striped">
				<c:forEach var="message" items="${requestScope.messageEntityList }">

					<tr>
						<th>インシデント番号</th>
						<td><c:out value="${message.incidentNumber }" /></td>
					</tr>
					<tr>
						<th>ステータス</th>
						<td><c:out value="${message.status }" /></td>
					</tr>
					<tr>
						<th>担当</th>
						<td><c:out value="${message.cherger }" /></td>
					</tr>
					<tr>
						<th>発生日/報告受領日</th>
						<td><c:out value="${message.incidentDate }" /></td>
					</tr>
					<tr>
						<th>曜日</th>
						<td><c:out value="${message.day }" /></td>
					</tr>
					<tr>
						<th>詳細内容</th>
						<td><c:out value="${message.detail }" /></td>
					</tr>
					<tr>
						<th>TEC通知</th>
						<td><c:out value="${message.tecAlert }" /></td>
					</tr>
					<tr>
						<th>発生時刻</th>
						<td><c:out value="${message.incidentTime }" /></td>
					</tr>
					<tr>
						<th>発生ノード/系列</th>
						<td><c:out value="${message.nodeName }" /></td>
					</tr>
					<tr>
						<th>プロダクト名/モジュール名</th>
						<td><c:out value="${message.productName }" /></td>
					</tr>
					<tr>
						<th>初動対応</th>
						<td><c:out value="${message.content }" /></td>
					</tr>
					<tr>

						<th>稼働確認結果</th>
						<td><c:out value="${message.confirmResult }" /></td>
					</tr>
					<tr>
						<th>取引確認結果</th>
						<td><c:out value="${message.transactionConfirm }" /></td>
					</tr>
					<tr>
						<th>ユーザ影響有無</th>
						<td><c:out value="${message.userHermress }" /></td>
					</tr>
					<tr>
						<th>HWエラー有無</th>
						<td><c:out value="${message.hwError }" /></td>
					</tr>
					<tr>
						<th>原因/トレース状況</th>
						<td><c:out value="${message.cause }" /></td>
					</tr>
					<tr>
						<th>復旧確認時刻</th>
						<td><c:out value="${message.recoverTime }" /></td>
					</tr>
					<tr>
						<th>暫定対応</th>
						<td><c:out value="${message.coverContent }" /></td>
					</tr>
					<tr>
						<th>運用向け報告<br>①問題有無②対応状況③手順書修正
						</th>
						<td><c:out value="${message.reportForRun }" /></td>
					</tr>
					<tr>
						<th>本格対応</th>
						<td><c:out value="${message.coverPlan }" /></td>
					</tr>
					<tr>
						<th>対応予定日/リリース予定日</th>
						<td><c:out value="${message.coverPlanDate }" /></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
	<br>
	<br>
	<a href="ShowErrorSamary">一覧画面へ</a>
	<br>
	<a href="ShowMenuServlet">メニューへ戻る</a>

</body>
</html>