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
	<h3>エラーサマリ</h3>

	<h2>検索</h2>
	<form action="ShowErrorSamary" method="post">
		<table>
			<tr>
				<th>ホスト名</th>
				<td><select name="hostName">
						<option value="" selected>---</option>
						<c:forEach var="host" items="${sessionScope.hostNameList }">
							<option value="${pageScope.host }">
								<c:out value="${pageScope.host }" />
							</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<th>ステータス</th>
				<td><input type="radio" name="status" value="1" checked>OPEN<input
					type="radio" name="status" value="2">CLOSE</td>
			</tr>
			<tr>
				<th>エラーメッセージ</th>
				<td><input type="text" name="errorMessage"></td>
			</tr>
			<tr>
				<th>原因</th>
				<td><input type="text" name="cause"></td>
			</tr>

		</table>
		<br> <input type="submit" value="検索"><br> <a
			href="ShowErrorSamary">全件検索</a>
	</form>

	<h3>PC版</h3>
	<table border="1">
		<tr>
			<th>インシデントID</th>
			<th>発生時刻</th>
			<th>ステータス</th>
			<th>ホスト名</th>
			<th>エラーメッセージID</th>
			<th>エラーメッセージ</th>
			<th>進捗状況</th>
			<th>原因</th>
		</tr>
		<c:forEach var="message" items="${sessionScope.messageEntityList }">
			<tr>
				<th><c:out value="${message.incidentId }" /></th>
				<th><fmt:formatDate value="${message.incidentTime }"
						pattern="yyyy/MM/dd HH:mm:ss" /></th>
				<th><c:choose>
						<c:when test="${message.status == 1}">OPEN</c:when>
						<c:when test="${message.status == 2}">CLOSE</c:when>
					</c:choose></th>
				<th><c:out value="${message.hostName }" /></th>
				<th><c:out value="${message.errorMessageId }" /></th>
				<th><c:out value="${message.errorMessage }" /></th>
				<th><c:out value="${message.progress }" /></th>
				<th><c:out value="${message.cause }" /></th>
			</tr>
		</c:forEach>
	</table>
	<br>

	<h3>ブラウザ版</h3>
	<table border="1">
		<tr>
			<th>発生時刻</th>
			<th>ホスト名</th>
			<th>エラーメッセージ</th>
			<th>原因</th>
		</tr>
		<c:forEach var="message" items="${sessionScope.messageEntityList }">
			<tr>
				<th><fmt:formatDate value="${message.incidentTime }"
						pattern="yyyy/MM/dd HH:mm:ss" /></th>
				<th><c:out value="${message.hostName }" /></th>
				<th><c:out value="${message.errorMessage }" /></th>
				<th><c:out value="${message.cause }" /></th>
			</tr>
		</c:forEach>
	</table>

	<a href="ShowMenuServlet">メニューへ戻る</a>

</body>
</html>