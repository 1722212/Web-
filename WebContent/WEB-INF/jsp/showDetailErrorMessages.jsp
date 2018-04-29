<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>詳細エラーサマリ</title>
</head>
<body>

	<h3>詳細メッセージ一覧</h3>
	<table border="1">
		<tr>
			<th>インシデント番号</th>
			<th>ステータス</th>
			<th>担当</th>
			<th>発生日/報告受領日</th>
			<th>曜日</th>
			<th>詳細内容</th>
			<th>TEC通知</th>
			<th>発生時刻</th>
			<th>発生ノード/系列</th>
			<th>プロダクト名/モジュール名</th>
			<th>内容</th>
			<th>稼働確認結果</th>
			<th>取引確認結果</th>
			<th>ユーザ影響有無</th>
			<th>HWエラー有無</th>
			<th>原因/トレース状況</th>
			<th>復旧確認時刻</th>
			<th>対応内容</th>
			<th>運用向け報告①問題有無②対応状況③手順書修正</th>
			<th>対応内容（予定含む）</th>
			<th>対応予定日/リリース予定日</th>
		</tr>
		<c:forEach var="message" items="${requestScope.messageEntityList }">
			<tr>
				<td><c:out value="${message.incidentNumber }" /></td>
				<td><c:out value="${message.status }" /></td>
				<td><c:out value="${message.cherger }" /></td>
				<td><c:out value="${message.incidentDate }" /></td>
				<td><c:out value="${message.day }" /></td>
				<td><c:out value="${message.detail }" /></td>
				<td><c:out value="${message.tecAlert }" /></td>
				<td><c:out value="${message.incidentTime }" /></td>
				<td><c:out value="${message.nodeName }" /></td>
				<td><c:out value="${message.productName }" /></td>
				<td><c:out value="${message.content }" /></td>
				<td><c:out value="${message.confirmResult }" /></td>
				<td><c:out value="${message.transactionConfirm }" /></td>
				<td><c:out value="${message.userHermress }" /></td>
				<td><c:out value="${message.hwError }" /></td>
				<td><c:out value="${message.cause }" /></td>
				<td><c:out value="${message.recoverTime }" /></td>
				<td><c:out value="${message.coverContent }" /></td>
				<td><c:out value="${message.reportForRun }" /></td>
				<td><c:out value="${message.coverPlan }" /></td>
				<td><c:out value="${message.coverPlanDate }" /></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	<a href="ShowMenuServlet">メニューへ戻る</a>

</body>
</html>