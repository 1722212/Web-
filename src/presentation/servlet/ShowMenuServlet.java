package presentation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import presentation.util.Constance;

/**
 * メニュー画面を表示するサーブレット
 */
@WebServlet("/ShowMenuServlet")
public class ShowMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// セッション取得
		HttpSession session = request.getSession();

		// 入力内容をセッションから削除
		session.removeAttribute("messageEntity");

		// メニュー画面へフォワード
		request.getRequestDispatcher(Constance.SHOW_MENU_JSP).forward(request, response);

	}
}
