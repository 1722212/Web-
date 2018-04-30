<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>エラーサマリ</title>
</head>
<body>
	<%-- エラーメッセージ --%>
	<c:out value="${requestScope.errorMessage }" />

	<h2>エラーサマリ</h2>
	<form action="ShowErrorSamary" method="post">

		<h3>検索ボックス</h3>
		<table>
			<tr>
				<td>発生ノード/系列</td>
				<td><input type="text" name="nodeName"
					value="<c:out value="${requestScope.searchKeyBean.nodeName }" />"></td>
			</tr>
			<tr>
				<td>プロダクト名/モジュール名</td>
				<td><input type="text" name="productName"
					value="<c:out value="${requestScope.searchKeyBean.productName }" />"></td>
			</tr>
			<tr>
				<td>詳細内容</td>
				<td><input type="text" name="detail"
					value="<c:out value="${requestScope.searchKeyBean.detail }" />"></td>
			</tr>
		</table>
		<br> <input type="submit" value="検索"> <a
			href="ShowErrorSamary">全件表示する</a>
	</form>

	<form action="ShowDetailErrorSamary" method="post">

		<h3>メッセージ一覧</h3>
		<table border="1">
			<tr>
				<th>選択</th>
				<th>発生日/報告受領日</th>
				<th>詳細内容</th>
				<th>発生時刻</th>
				<th>発生ノード/系列</th>
				<th>プロダクト名/モジュール名</th>
				<th>初動対応</th>

			</tr>
			<c:forEach var="message" items="${sessionScope.messageEntityList }">
				<tr>
					<td><input type="radio" name="selectIncidentNumber"
						value="${message.incidentNumber }" required></td>
					<td><c:out value="${message.incidentDate }" /></td>
					<td><c:out value="${message.detail }" /></td>
					<td><c:out value="${message.incidentTime }" /></td>
					<td><c:out value="${message.nodeName }" /></td>
					<td><c:out value="${message.productName }" /></td>
					<td><c:out value="${message.content }" /></td>
				</tr>
			</c:forEach>
		</table>
		<br> <input type="submit" value="メッセージ詳細へ">

	</form>
	<br>
	<a href="ShowMenuServlet">メニューへ戻る</a>
</body>
</html>