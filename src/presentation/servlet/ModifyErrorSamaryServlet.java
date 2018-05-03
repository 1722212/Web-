package presentation.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bizlogic.logic.MessageLogic;
import dataaccess.entity.MessageEntity;
import presentation.form.MessageForm;
import presentation.util.Constance;

/**
 * Servlet implementation class ModifyServlet
 */
@WebServlet("/ModifyErrorSamaryServlet")
public class ModifyErrorSamaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 入力内容を取得
		String incidentNumber = request.getParameter("incidentNumber");
		String status = request.getParameter("status");
		String cherger = request.getParameter("cherger");
		String incidentDate = request.getParameter("incidentDate");
		String day = request.getParameter("day");
		String detail = request.getParameter("detail");
		String tecAlert = request.getParameter("tecAlert");
		String incidentTime = request.getParameter("incidentTime");
		String nodeName = request.getParameter("nodeName");
		String productName = request.getParameter("productName");
		String content = request.getParameter("content");
		String confirmResult = request.getParameter("confirmResult");
		String transactionConfirm = request.getParameter("transactionConfirm");
		String userHermress = request.getParameter("userHermress");
		String hwError = request.getParameter("hwError");
		String cause = request.getParameter("cause");
		String recoverTime = request.getParameter("recoverTime");
		String coverContent = request.getParameter("coverContent");
		String reportForRun = request.getParameter("reportForRun");
		String coverPlan = request.getParameter("coverPlan");
		String coverPlanDate = request.getParameter("coverPlanDate");

		// Formにセット
		MessageForm messageForm = new MessageForm();

		messageForm.setIncidentNumber(incidentNumber);
		messageForm.setStatus(status);
		messageForm.setCherger(cherger);
		messageForm.setIncidentDate(incidentDate);
		messageForm.setDay(day);
		messageForm.setDetail(detail);
		messageForm.setTecAlert(tecAlert);
		messageForm.setIncidentTime(incidentTime);
		messageForm.setNodeName(nodeName);
		messageForm.setProductName(productName);
		messageForm.setContent(content);
		messageForm.setConfirmResult(confirmResult);
		messageForm.setTransactionConfirm(transactionConfirm);
		messageForm.setUserHermress(userHermress);
		messageForm.setHwError(hwError);
		messageForm.setCause(cause);
		messageForm.setRecoverTime(recoverTime);
		messageForm.setCoverContent(coverContent);
		messageForm.setReportForRun(reportForRun);
		messageForm.setCoverPlan(coverPlan);
		messageForm.setCoverPlanDate(coverPlanDate);

		// バリデート
		// // 不備があった場合は入力画面へフォワード
		// request.getRequestDispatcher(Constance.SHOW_INPUT_ERROR_SAMARY_JSP).forward(request,
		// response);
		// return;

		// Entityに詰め替え
		MessageEntity messageEntity = new MessageEntity();

		messageEntity.setIncidentNumber(incidentNumber);
		messageEntity.setStatus(status);
		messageEntity.setCherger(cherger);
		messageEntity.setIncidentDate(incidentDate);
		messageEntity.setDay(day);
		messageEntity.setDetail(detail);
		messageEntity.setTecAlert(tecAlert);
		messageEntity.setIncidentTime(incidentTime);
		messageEntity.setNodeName(nodeName);
		messageEntity.setProductName(productName);
		messageEntity.setContent(content);
		messageEntity.setConfirmResult(confirmResult);
		messageEntity.setTransactionConfirm(transactionConfirm);
		messageEntity.setUserHermress(userHermress);
		messageEntity.setHwError(hwError);
		messageEntity.setCause(cause);
		messageEntity.setRecoverTime(recoverTime);
		messageEntity.setCoverContent(coverContent);
		messageEntity.setReportForRun(reportForRun);
		messageEntity.setCoverPlan(coverPlan);
		messageEntity.setCoverPlanDate(coverPlanDate);

		// ロジック取得
		MessageLogic messageLogic = new MessageLogic();
		try {
			messageLogic.modifyMessage(messageEntity, incidentNumber);
		} catch (SQLException e) {
			// エラーメッセージをリクエストに登録
			String errorMessage = e.getMessage();
			request.setAttribute("errorMessage", errorMessage);
			// エラーサマリ編集画面へフォワード
			request.getRequestDispatcher(Constance.SHOW_MODIFY_MESSAGE_JSP).forward(request, response);
			e.printStackTrace();
			return;
		}

		// メッセージ編集完了画面へフォワード
		request.getRequestDispatcher(Constance.COMPLETE_MODIFY_ERROR_SAMARY_JSP).forward(request, response);

	}

}
