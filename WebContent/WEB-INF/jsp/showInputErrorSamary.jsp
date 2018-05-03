<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link>
<title>エラーサマリ登録画面</title>
</head>
<body>
	<%-- エラーメッセージ --%>
	<span style="color: #ff0000;"><c:out
			value="${requestScope.errorMessage }" /></span>


	<h3>エラーサマリ登録画面</h3>
	<form action="ConfirmErrorSamaryServlet" method="post">
		<table border="1">
			<tr>
				<th>インシデント番号</th>
				<td><input type="text" name="incidentNumber"
					value="<c:out value="${sessionScope.messageEntity.incidentNumber }" />" required></td>
			</tr>
			<tr>
				<th>ステータス</th>
				<td><input type="text" name="status"
					value="${sessionScope.messageEntity.status }" required></td>
			</tr>
			<tr>
				<th>担当</th>
				<td><input type="text" name="cherger"
					value="${sessionScope.messageEntity.cherger }" required></td>
			</tr>
			<tr>
				<th>発生日/報告受領日</th>
				<td><input type="text" name="incidentDate"
					value="${sessionScope.messageEntity.incidentDate }" required></td>
			</tr>
			<tr>
				<th>曜日</th>
				<td><input type="text" name="day"
					value="${sessionScope.messageEntity.day }" required></td>
			</tr>
			<tr>
				<th>詳細内容</th>
				<td><input type="text" name="detail"
					value="${sessionScope.messageEntity.detail }" required></td>
			</tr>
			<tr>
				<th>TEC通知</th>
				<td><input type="text" name="tecAlert"
					value="${sessionScope.messageEntity.tecAlert }" required></td>
			</tr>
			<tr>
				<th>発生時刻</th>
				<td><input type="text" name="incidentTime"
					value="${sessionScope.messageEntity.incidentTime }" required></td>
			</tr>
			<tr>
				<th>発生ノード/系列</th>
				<td><input type="text" name="nodeName"
					value="${sessionScope.messageEntity.nodeName }" required></td>
			</tr>
			<tr>
				<th>プロダクト名/モジュール名</th>
				<td><input type="text" name="productName"
					value="${sessionScope.messageEntity.productName }" required></td>
			</tr>
			<tr>
				<th>初動対応</th>
				<td><input type="text" name="content"
					value="${sessionScope.messageEntity.content }" required></td>
			</tr>
			<tr>

				<th>稼働確認結果</th>
				<td><input type="text" name="confirmResult"
					value="${sessionScope.messageEntity.confirmResult }" required></td>
			</tr>
			<tr>
				<th>取引確認結果</th>
				<td><input type="text" name="transactionConfirm"
					value="${sessionScope.messageEntity.transactionConfirm }" required></td>
			</tr>
			<tr>
				<th>ユーザ影響有無</th>
				<td><input type="text" name="userHermress"
					value="${sessionScope.messageEntity.userHermress }" required></td>
			</tr>
			<tr>
				<th>HWエラー有無</th>
				<td><input type="text" name="hwError"
					value="${sessionScope.messageEntity.hwError }" required></td>
			</tr>
			<tr>
				<th>原因/トレース状況</th>
				<td><input type="text" name="cause"
					value="${sessionScope.messageEntity.cause }" required></td>
			</tr>
			<tr>
				<th>復旧確認時刻</th>
				<td><input type="text" name="recoverTime"
					value="${sessionScope.messageEntity.recoverTime }" required></td>
			</tr>
			<tr>
				<th>暫定対応</th>
				<td><input type="text" name="coverContent"
					value="${sessionScope.messageEntity.coverContent }" required></td>
			</tr>
			<tr>
				<th>運用向け報告<br>①問題有無②対応状況③手順書修正
				</th>
				<td><input type="text" name="reportForRun"
					value="${sessionScope.messageEntity.reportForRun }" required></td>
			</tr>
			<tr>
				<th>本格対応</th>
				<td><input type="text" name="coverPlan"
					value="${sessionScope.messageEntity.coverPlan }" required></td>
			</tr>
			<tr>
				<th>対応予定日/リリース予定日</th>
				<td><input type="text" name="coverPlanDate"
					value="${sessionScope.messageEntity.coverPlanDate }" required></td>
			</tr>

		</table>
		<br> <input type="submit" value="確認画面へ"><br> <a href="ShowErrorSamary">一覧画面へ</a><br><a
			href="ShowMenuServlet">メニューへ</a>
	</form>


</body>
</html>