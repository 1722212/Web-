package presentation.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		// メニュー画面へフォワード
		request.getRequestDispatcher("/WEB-INF/jsp/showMenu.jsp").forward(request, response);

	}
}
