package presentation.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bizlogic.logic.MessageLogic;
import dataaccess.entity.MessageEntity;
import presentation.util.Constance;

/**
 * エラーメッセージ編集画面を表示するサーブレット
 */
@WebServlet("/ShowModifyErrorSamaryServlet")
public class ShowModifyErrorSamaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 編集するエラーサマリのインシデント番号を取得
		String incidentNumber = (String) request.getAttribute("selectIncidentNumber");

		// ロジック取得
		MessageLogic messageLogic = new MessageLogic();

		// エラーメッセージリスト生成
		List<MessageEntity> messageEntityList = new ArrayList<>();

		// インシデント番号でエラーサマリを検索
		try {
			messageEntityList = messageLogic.searchMessageByIncidentNumber(incidentNumber);
		} catch (SQLException e) {
			// エラーメッセージをリクエストに登録
			String errorMessage = e.getMessage();
			request.setAttribute("errorMessage", errorMessage);
			// エラーサマリ表示画面へフォワード
			request.getRequestDispatcher(Constance.SHOW_ERROR_MESSAGES_JSP).forward(request, response);

			return;
		}

		// 取得したエラーサマリ情報をリクエストに登録
		request.setAttribute("messageEntityList", messageEntityList);

		// フォワード
		request.getRequestDispatcher(Constance.SHOW_MODIFY_MESSAGE_JSP).forward(request, response);

	}

}
