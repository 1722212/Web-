<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>入力内容確認画面</title>
</head>
<body>
	<%-- エラーメッセージ --%>
	<span style="color: #ff0000;"><c:out
			value="${requestScope.errorMessage }" /></span>

	<h3>入力内容確認画面</h3>

	<form action="RegistErrorSamaryServlet" method="post">
		<table border="1" class="table table-striped">
			<tr>
				<th>インシデント番号</th>
				<td><c:out
						value="${sessionScope.messageEntity.incidentNumber }" /></td>
			</tr>
			<tr>
				<th>ステータス</th>
				<td><c:out value="${sessionScope.messageEntity.status }" /></td>
			</tr>
			<tr>
				<th>担当</th>
				<td><c:out value="${sessionScope.messageEntity.cherger }" /></td>
			</tr>
			<tr>
				<th>発生日/報告受領日</th>
				<td><c:out value="${sessionScope.messageEntity.incidentDate }" /></td>
			</tr>
			<tr>
				<th>曜日</th>
				<td><c:out value="${sessionScope.messageEntity.day }" /></td>
			</tr>
			<tr>
				<th>詳細内容</th>
				<td><c:out value="${sessionScope.messageEntity.detail }" /></td>
			</tr>
			<tr>
				<th>TEC通知</th>
				<td><c:out value="${sessionScope.messageEntity.tecAlert }" /></td>
			</tr>
			<tr>
				<th>発生時刻</th>
				<td><c:out value="${sessionScope.messageEntity.incidentTime }" /></td>
			</tr>
			<tr>
				<th>発生ノード/系列</th>
				<td><c:out value="${sessionScope.messageEntity.nodeName }" /></td>
			</tr>
			<tr>
				<th>プロダクト名/モジュール名</th>
				<td><c:out value="${sessionScope.messageEntity.productName }" /></td>
			</tr>
			<tr>
				<th>初動対応</th>
				<td><c:out value="${sessionScope.messageEntity.coverContent }" /></td>
			</tr>
			<tr>

				<th>稼働確認結果</th>
				<td><c:out value="${sessionScope.messageEntity.confirmResult }" /></td>
			</tr>
			<tr>
				<th>取引確認結果</th>
				<td><c:out
						value="${sessionScope.messageEntity.transactionConfirm }" /></td>
			</tr>
			<tr>
				<th>ユーザ影響有無</th>
				<td><c:out value="${sessionScope.messageEntity.userHermress }" /></td>
			</tr>
			<tr>
				<th>HWエラー有無</th>
				<td><c:out value="${sessionScope.messageEntity.hwError }" /></td>
			</tr>
			<tr>
				<th>原因/トレース状況</th>
				<td><c:out value="${sessionScope.messageEntity.cause }" /></td>
			</tr>
			<tr>
				<th>復旧確認時刻</th>
				<td><c:out value="${sessionScope.messageEntity.recoverTime }" /></td>
			</tr>
			<tr>
				<th>暫定対応</th>
				<td><c:out value="${sessionScope.messageEntity.coverContent }" /></td>
			</tr>
			<tr>
				<th>運用向け報告<br>①問題有無②対応状況③手順書修正
				</th>
				<td><c:out value="${sessionScope.messageEntity.reportForRun }" /></td>
			</tr>
			<tr>
				<th>本格対応</th>
				<td><c:out value="${sessionScope.messageEntity.coverPlan }" /></td>
			</tr>
			<tr>
				<th>対応予定日/リリース予定日</th>
				<td><c:out value="${sessionScope.messageEntity.coverPlanDate }" /></td>
			</tr>

		</table>

		<input type="submit" value="登録"><br> <a
			href="ShowInputErrorSamaryServlet">入力画面へ戻る</a>

	</form>

</body>
</html>