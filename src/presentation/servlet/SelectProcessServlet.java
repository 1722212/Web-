package presentation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import presentation.util.Constance;

/**
 * エラーメッセージ一覧画面にて選択された処理を判断するサーブレット
 */
@WebServlet("/SelectProcessServlet")
public class SelectProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストパラメタを取得
		String selectIncidentNumber = request.getParameter("selectIncidentNumber");
		String detail = request.getParameter("detail");
		String modify = request.getParameter("modify");
		String delete = request.getParameter("delete");
		String regist = request.getParameter("regist");

		// 取得したインシデント番号をリクエストに登録
		request.setAttribute("selectIncidentNumber", selectIncidentNumber);

		// どのボタンが選択されたかを判断
		if (detail != null) {
			// 詳細画面へフォワード
			request.getRequestDispatcher("ShowDetailErrorSamary").forward(request, response);
			return;

		} else if (modify != null) {
			// 編集画面へフォワード
			request.getRequestDispatcher("ShowModifyErrorSamaryServlet").forward(request, response);
			return;
		} else if (delete != null) {
			// 削除画面へフォワード
			request.getRequestDispatcher("ShowDeleteErrorSamaryServlet").forward(request, response);
			return;
		} else if (regist != null) {
			// 新規登録画面へフォワード
			request.getRequestDispatcher("ShowInputErrorSamaryServlet").forward(request, response);
			return;
		} else {
			// エラーサマリ一覧画面へフォワード
			request.getRequestDispatcher(Constance.SHOW_ERROR_MESSAGES_JSP).forward(request, response);
			return;

		}

	}

}
