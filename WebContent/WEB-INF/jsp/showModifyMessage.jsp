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
<title>メッセージ編集画面</title>
</head>
<body>
	<div class="container">
		<%-- エラーメッセージ --%>
		<span style="color: #ff0000;"><c:out
				value="${requestScope.errorMessage }" /></span>

		<h3>メッセージ編集</h3>
		<div class="table-responsive">
			<form action="ModifyErrorSamaryServlet" method="post">
				<table border="1"
					class="table table-striped table-hover table-condensed">
					<c:forEach var="message" items="${requestScope.messageEntityList }">

						<tr>
							<th class="info col-xs-3">インシデント番号</th>
							<td class=" col-xs-9"><c:out
									value="${message.incidentNumber }" /></td>
							<input type="hidden" name="incidentNumber"
								value="<c:out value="${message.incidentNumber }" />">
						</tr>
						<tr>
							<th class="info col-xs-3">ステータス</th>
							<td class=" col-xs-9"><input type="text" name="status"
								value="<c:out value="${message.status }" />"></td>
						</tr>
						<tr>
							<th class="info col-xs-3">担当</th>
							<td class=" col-xs-9"><input type="text" name="cherger"
								value="<c:out value="${message.cherger }" />"></td>
						</tr>
						<tr>
							<th class="info col-xs-3">発生日/報告受領日</th>
							<td class=" col-xs-9"><input type="date" name="incidentDate"
								value="<c:out value="${message.incidentDate }" />"></td>
						</tr>
						<tr>
							<th class="info col-xs-3">曜日</th>
							<td class=" col-xs-9"><input type="text" name="day"
								value="<c:out value="${message.day }" />"></td>
						</tr>
						<tr>
							<th class="info col-xs-3">詳細内容</th>
							<td class=" col-xs-9"><input type="text" name="detail"
								value="<c:out value="${message.detail }" />"></td>
						</tr>
						<tr>
							<th class="info col-xs-3">TEC通知</th>
							<td class=" col-xs-9"><input type="text" name="tecAlert"
								value="<c:out value="${message.tecAlert }" />"></td>
						</tr>
						<tr>
							<th class="info col-xs-3">発生時刻</th>
							<td class=" col-xs-9"><input type="time" name="incidentTime"
								value="<c:out value="${message.incidentTime }" />"></td>
						</tr>
						<tr>
							<th class="info col-xs-3">発生ノード/系列</th>
							<td class=" col-xs-9"><input type="text" name="nodeName"
								value="<c:out value="${message.nodeName }" />"></td>
						</tr>
						<tr>
							<th class="info col-xs-3">プロダクト名/モジュール名</th>
							<td class=" col-xs-9"><input type="text" name="productName"
								value="<c:out value="${message.productName }" />"></td>
						</tr>
						<tr>
							<th class="info col-xs-3">初動対応</th>
							<td class=" col-xs-9"><input type="text" name="content"
								value="<c:out value="${message.content }" />"></td>
						</tr>
						<tr>

							<th class="info col-xs-3">稼働確認結果</th>
							<td class=" col-xs-9"><input type="text"
								name="confirmResult"
								value="<c:out value="${message.confirmResult }" />"></td>
						</tr>
						<tr>
							<th class="info col-xs-3">取引確認結果</th>
							<td class=" col-xs-9"><input type="text"
								name="transactionConfirm"
								value="<c:out value="${message.transactionConfirm }" />"></td>
						</tr>
						<tr>
							<th class="info col-xs-3">ユーザ影響有無</th>
							<td class=" col-xs-9"><input type="text" name="userHermress"
								value="<c:out value="${message.userHermress }" />"></td>
						</tr>
						<tr>
							<th class="info col-xs-3">HWエラー有無</th>
							<td class=" col-xs-9"><input type="text" name="hwError"
								value="<c:out value="${message.hwError }" />"></td>
						</tr>
						<tr>
							<th class="info col-xs-3">原因/トレース状況</th>
							<td class=" col-xs-9"><input type="text" name="cause"
								value="<c:out value="${message.cause }" />"></td>
						</tr>
						<tr>
							<th class="info col-xs-3">復旧確認時刻</th>
							<td class=" col-xs-9"><input type="time" name="recoverTime"
								value="<c:out value="${message.recoverTime }" />"></td>
						</tr>
						<tr>
							<th class="info col-xs-3">暫定対応</th>
							<td class=" col-xs-9"><input type="text" name="coverContent"
								value="<c:out value="${message.coverContent }" />"></td>
						</tr>
						<tr>
							<th class="info col-xs-3">運用向け報告<br>①問題有無②対応状況③手順書修正
							</th>
							<td class=" col-xs-9"><input type="text" name="reportForRun"
								value="<c:out value="${message.reportForRun }" />"></td>
						</tr>
						<tr>
							<th class="info col-xs-3">本格対応</th>
							<td class=" col-xs-9"><input type="text" name="coverPlan"
								value="<c:out value="${message.coverPlan }" />"></td>
						</tr>
						<tr>
							<th class="info col-xs-3">対応予定日/リリース予定日</th>
							<td class=" col-xs-9"><input type="date"
								name="coverPlanDate"
								value="<c:out value="${message.coverPlanDate }" />"></td>
						</tr>
					</c:forEach>
				</table>

				<button type="submit" value="編集" class="btn btn-lg btn-primary">編集</button>
			</form>

		</div>
		<br> <br> <a href="ShowErrorSamary">一覧画面へ</a> <br> <a
			href="ShowMenuServlet">メニューへ戻る</a>
	</div>
</body>
</html>