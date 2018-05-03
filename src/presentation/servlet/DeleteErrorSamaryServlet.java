package presentation.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bizlogic.logic.MessageLogic;
import presentation.util.Constance;

/**
 * エラーメッセージを削除するサーブレット
 */
@WebServlet("/DeleteErrorSamaryServlet")
public class DeleteErrorSamaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 削除するメッセージのインシデント番号を取得
		String incidentNumber = request.getParameter("incidentNumber");

		// ロジック取得
		MessageLogic messageLogic = new MessageLogic();
		try {
			messageLogic.deleteMessage(incidentNumber);
		} catch (SQLException e) {
			// エラーメッセージをリクエストに登録
			String errorMessage = e.getMessage();
			request.setAttribute("errorMessage", errorMessage);
			// エラーサマリ表示画面へフォワード
			request.getRequestDispatcher(Constance.SHOW_DELETE_ERROR_SAMARY_JSP).forward(request, response);
			e.printStackTrace();
			return;
		}

		// エラーメッセージ完了画面へフォワード
		request.getRequestDispatcher(Constance.COMPLETE_DELETE_ERROR_SAMARY_JSP).forward(request, response);

	}

}
