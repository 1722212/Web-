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
<title>入力内容確認画面</title>
</head>
<body>
	<div class="container">

		<h3>入力内容確認画面</h3>
		<%-- エラーメッセージ --%>
		<span style="color: #ff0000;"><c:out
				value="${requestScope.errorMessage }" /></span>

		<form action="RegistErrorSamaryServlet" method="post">
			<table border="1" class="table table-striped">
				<tr>
					<th class="info col-xs-3">インシデント番号</th>
					<td class="col-xs-9"><c:out
							value="${sessionScope.messageEntity.incidentNumber }" /></td>
				</tr>
				<tr>
					<th class="info col-xs-3">ステータス</th>
					<td class="col-xs-9"><c:out
							value="${sessionScope.messageEntity.status }" /></td>
				</tr>
				<tr>
					<th class="info col-xs-3">担当</th>
					<td class="col-xs-9"><c:out
							value="${sessionScope.messageEntity.cherger }" /></td>
				</tr>
				<tr>
					<th class="info col-xs-3">発生日/報告受領日</th>
					<td class="col-xs-9"><c:out
							value="${sessionScope.messageEntity.incidentDate }" /></td>
				</tr>
				<tr>
					<th class="info col-xs-3">曜日</th>
					<td class="col-xs-9"><c:out
							value="${sessionScope.messageEntity.day }" /></td>
				</tr>
				<tr>
					<th class="info col-xs-3">詳細内容</th>
					<td class="col-xs-9"><c:out
							value="${sessionScope.messageEntity.detail }" /></td>
				</tr>
				<tr>
					<th class="info col-xs-3">TEC通知</th>
					<td class="col-xs-9"><c:out
							value="${sessionScope.messageEntity.tecAlert }" /></td>
				</tr>
				<tr>
					<th class="info col-xs-3">発生時刻</th>
					<td class="col-xs-9"><c:out
							value="${sessionScope.messageEntity.incidentTime }" /></td>
				</tr>
				<tr>
					<th class="info col-xs-3">発生ノード/系列</th>
					<td class="col-xs-9"><c:out
							value="${sessionScope.messageEntity.nodeName }" /></td>
				</tr>
				<tr>
					<th class="info col-xs-3">プロダクト名/モジュール名</th>
					<td class="col-xs-9"><c:out
							value="${sessionScope.messageEntity.productName }" /></td>
				</tr>
				<tr>
					<th class="info col-xs-3">初動対応</th>
					<td class="col-xs-9"><c:out
							value="${sessionScope.messageEntity.coverContent }" /></td>
				</tr>
				<tr>

					<th class="info col-xs-3">稼働確認結果</th>
					<td class="col-xs-9"><c:out
							value="${sessionScope.messageEntity.confirmResult }" /></td>
				</tr>
				<tr>
					<th class="info col-xs-3">取引確認結果</th>
					<td class="col-xs-9"><c:out
							value="${sessionScope.messageEntity.transactionConfirm }" /></td>
				</tr>
				<tr>
					<th class="info col-xs-3">ユーザ影響有無</th>
					<td class="col-xs-9"><c:out
							value="${sessionScope.messageEntity.userHermress }" /></td>
				</tr>
				<tr>
					<th class="info col-xs-3">HWエラー有無</th>
					<td class="col-xs-9"><c:out
							value="${sessionScope.messageEntity.hwError }" /></td>
				</tr>
				<tr>
					<th class="info col-xs-3">原因/トレース状況</th>
					<td class="col-xs-9"><c:out
							value="${sessionScope.messageEntity.cause }" /></td>
				</tr>
				<tr>
					<th class="info col-xs-3">復旧確認時刻</th>
					<td class="col-xs-9"><c:out
							value="${sessionScope.messageEntity.recoverTime }" /></td>
				</tr>
				<tr>
					<th class="info col-xs-3">暫定対応</th>
					<td class="col-xs-9"><c:out
							value="${sessionScope.messageEntity.coverContent }" /></td>
				</tr>
				<tr>
					<th class="info col-xs-3">運用向け報告<br>①問題有無②対応状況③手順書修正
					</th>
					<td class="col-xs-9"><c:out
							value="${sessionScope.messageEntity.reportForRun }" /></td>
				</tr>
				<tr>
					<th class="info col-xs-3">本格対応</th>
					<td class="col-xs-9"><c:out
							value="${sessionScope.messageEntity.coverPlan }" /></td>
				</tr>
				<tr>
					<th class="info col-xs-3">対応予定日/リリース予定日</th>
					<td class="col-xs-9"><c:out
							value="${sessionScope.messageEntity.coverPlanDate }" /></td>
				</tr>

			</table>

			<button type="submit" value="登録" class="btn btn-lg btn-primary">登録する</button>
			<br>
			<br> <a href="ShowInputErrorSamaryServlet">入力画面へ戻る</a>

		</form>
	</div>
</body>
</html>