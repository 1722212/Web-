package presentation.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bizlogic.logic.MessageLogic;
import dataaccess.entity.MessageEntity;
import presentation.util.Constance;

/**
 * エラーサマリを登録するサーブレット
 */
@WebServlet("/RegistErrorSamaryServlet")
public class RegistErrorSamaryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// セッション取得
		HttpSession session = request.getSession();
		// 入力内容をセッションから取得
		MessageEntity messageEntity = new MessageEntity();
		messageEntity = (MessageEntity) session.getAttribute("messageEntity");

		// ロジック取得
		MessageLogic messageLogic = new MessageLogic();
		try {
			messageLogic.registMessage(messageEntity);

		} catch (SQLException e) {
			// エラーメッセージをリクエストに登録
			String errorMessage = e.getMessage();
			request.setAttribute("errorMessage", errorMessage);

			// 一意性制約違反
			if (e.getErrorCode() == 1) {
				request.setAttribute("errorMessage", "入力したインシデント番号はすでに存在します");
				// エラーサマリ表示画面へフォワード
				request.getRequestDispatcher(Constance.SHOW_INPUT_ERROR_SAMARY_JSP).forward(request, response);
				e.printStackTrace();
				return;

			} // 文字数エラー
			else if (e.getErrorCode() == 12899) {
				request.setAttribute("errorMessage", "文字数が不正です。入力文字数を確認してください");
				// エラーサマリ表示画面へフォワード
				request.getRequestDispatcher(Constance.SHOW_INPUT_ERROR_SAMARY_JSP).forward(request, response);
				e.printStackTrace();
				return;

			} else {
				// エラーサマリ表示画面へフォワード
				request.getRequestDispatcher(Constance.SHOW_INPUT_ERROR_SAMARY_JSP).forward(request, response);
				e.printStackTrace();
				return;
			}
		}

		// 入力内容をセッションから削除
		session.removeAttribute("messageEntity");

		// 登録完了画面へフォワード
		request.getRequestDispatcher(Constance.COMPLETE_ERROR_SAMARY_JSP).forward(request, response);

	}

}
