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
<title>エラーサマリ登録画面</title>
</head>
<body>
	<div class="container">
		<%-- エラーメッセージ --%>
		<span style="color: #ff0000;"><c:out
				value="${requestScope.errorMessage }" /></span>


		<h3>エラーサマリ登録画面</h3>
		<form action="ConfirmErrorSamaryServlet" method="post">
			<div class="table-responsive">
				<table border="1"
					class="table table-striped table-hover table-condensed">
					<tr>
						<th class="info col-xs-3">インシデント番号</th>
						<td class="col-xs-9"><input type="text" name="incidentNumber"
							value="<c:out value="${sessionScope.messageEntity.incidentNumber }" />"
							required></td>
					</tr>
					<tr>
						<th class="info col-xs-3">ステータス</th>
						<td class="col-xs-9"><input type="text" name="status"
							value="${sessionScope.messageEntity.status }" required></td>
					</tr>
					<tr>
						<th class="info col-xs-3">担当</th>
						<td class="col-xs-9"><input type="text" name="cherger"
							value="${sessionScope.messageEntity.cherger }" required></td>
					</tr>
					<tr>
						<th class="info col-xs-3">発生日/報告受領日</th>
						<td class="col-xs-9"><input type="date" name="incidentDate"
							value="${sessionScope.messageEntity.incidentDate }"></td>
					</tr>
					<tr>
						<th class="info col-xs-3">曜日</th>
						<td class="col-xs-9"><input type="text" name="day"
							value="${sessionScope.messageEntity.day }" required></td>
					</tr>
					<tr>
						<th class="info col-xs-3">詳細内容</th>
						<td class="col-xs-9"><input type="text" name="detail"
							value="${sessionScope.messageEntity.detail }" required></td>
					</tr>
					<tr>
						<th class="info col-xs-3">TEC通知</th>
						<td class="col-xs-9"><input type="text" name="tecAlert"
							value="${sessionScope.messageEntity.tecAlert }" required></td>
					</tr>
					<tr>
						<th class="info col-xs-3">発生時刻</th>
						<td class="col-xs-9"><input type="time" name="incidentTime"
							value="${sessionScope.messageEntity.incidentTime }"></td>
					</tr>
					<tr>
						<th class="info col-xs-3">発生ノード/系列</th>
						<td class="col-xs-9"><input type="text" name="nodeName"
							value="${sessionScope.messageEntity.nodeName }" required></td>
					</tr>
					<tr>
						<th class="info col-xs-3">プロダクト名/モジュール名</th>
						<td class="col-xs-9"><input type="text" name="productName"
							value="${sessionScope.messageEntity.productName }" required></td>
					</tr>
					<tr>
						<th class="info col-xs-3">初動対応</th>
						<td class="col-xs-9"><input type="text" name="content"
							value="${sessionScope.messageEntity.content }" required></td>
					</tr>
					<tr>

						<th class="info col-xs-3">稼働確認結果</th>
						<td class="col-xs-9"><input type="text" name="confirmResult"
							value="${sessionScope.messageEntity.confirmResult }" required></td>
					</tr>
					<tr>
						<th class="info col-xs-3">取引確認結果</th>
						<td class="col-xs-9"><input type="text"
							name="transactionConfirm"
							value="${sessionScope.messageEntity.transactionConfirm }"
							required></td>
					</tr>
					<tr>
						<th class="info col-xs-3">ユーザ影響有無</th>
						<td class="col-xs-9"><input type="text" name="userHermress"
							value="${sessionScope.messageEntity.userHermress }" required></td>
					</tr>
					<tr>
						<th class="info col-xs-3">HWエラー有無</th>
						<td class="col-xs-9"><input type="text" name="hwError"
							value="${sessionScope.messageEntity.hwError }" required></td>
					</tr>
					<tr>
						<th class="info col-xs-3">原因/トレース状況</th>
						<td class="col-xs-9"><input type="text" name="cause"
							value="${sessionScope.messageEntity.cause }" required></td>
					</tr>
					<tr>
						<th class="info col-xs-3">復旧確認時刻</th>
						<td class="col-xs-9"><input type="time" name="recoverTime"
							value="${sessionScope.messageEntity.recoverTime }"></td>
					</tr>
					<tr>
						<th class="info col-xs-3">暫定対応</th>
						<td class="col-xs-9"><input type="text" name="coverContent"
							value="${sessionScope.messageEntity.coverContent }" required></td>
					</tr>
					<tr>
						<th class="info col-xs-3">運用向け報告<br>①問題有無②対応状況③手順書修正
						</th>
						<td class="col-xs-9"><input type="text" name="reportForRun"
							value="${sessionScope.messageEntity.reportForRun }" required></td>
					</tr>
					<tr>
						<th class="info col-xs-3">本格対応</th>
						<td class="col-xs-9"><input type="text" name="coverPlan"
							value="${sessionScope.messageEntity.coverPlan }" required></td>
					</tr>
					<tr>
						<th class="info col-xs-3">対応予定日/リリース予定日</th>
						<td class="col-xs-9"><input type="date" name="coverPlanDate"
							value="${sessionScope.messageEntity.coverPlanDate }"></td>
					</tr>

				</table>
			</div>
			<br>
			<button type="submit" value="確認画面へ" class="btn btn-lg btn-primary">確認画面へ</button>
			<br> <br> <a href="ShowErrorSamary">一覧画面へ</a><br> <a
				href="ShowMenuServlet">メニューへ</a>
		</form>
	</div>

</body>
</html>