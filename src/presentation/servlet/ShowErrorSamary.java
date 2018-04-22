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
import javax.servlet.http.HttpSession;

import bizlogic.bean.SearchKeyBean;
import bizlogic.logic.MessageLogic;
import dataaccess.entity.MessageEntity;
import presentation.form.SearchKeyForm;

/**
 * エラーサマリを表示するサーブレット
 */
@WebServlet("/ShowErrorSamary")
public class ShowErrorSamary extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ロジック取得
		MessageLogic messageLogic = new MessageLogic();
		// エラーメッセージリスト生成
		List<MessageEntity> messageEntityList = new ArrayList<>();
		// ホスト名のリスト
		List<String> hostNameList = new ArrayList<>();

		try {
			// エラーメッセージを全件取得
			messageEntityList = messageLogic.selectAllMessages();

			// ホスト名を全件取得
			hostNameList = messageLogic.selectHostName();

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return;
		}

		// エラーメッセージのリストをセッションに登録
		HttpSession session = request.getSession();
		session.setAttribute("hostNameList", hostNameList);
		session.setAttribute("messageEntityList", messageEntityList);

		// エラーサマリ表示画面へフォワード
		request.getRequestDispatcher("/WEB-INF/jsp/showErrorMessages.jsp").forward(request, response);

	}

	/**
	 * AND検索の場合はPOSTで実行
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 検索条件を取得
		String hostName = request.getParameter("hostName");
		String status = request.getParameter("status");
		String errorMessage = request.getParameter("errorMessage");
		String cause = request.getParameter("cause");

		// 検索条件フォーム生成
		SearchKeyForm searchKeyForm = new SearchKeyForm();
		searchKeyForm.setHostName(hostName);
		searchKeyForm.setStatus(status);
		searchKeyForm.setErrorMessage(errorMessage);
		searchKeyForm.setCause(cause);

		// バリデート

		// 検索条件をBeanに詰め替え
		SearchKeyBean searchKeyBean = new SearchKeyBean();
		searchKeyBean.setHostName(hostName);
		searchKeyBean.setStatus(Integer.parseInt(status));
		searchKeyBean.setErrorMessage(errorMessage);
		searchKeyBean.setCause(cause);

		// ロジック取得
		MessageLogic messageLogic = new MessageLogic();
		// エラーメッセージのリストを生成
		List<MessageEntity> messageEntityList = new ArrayList<>();
		try {
			// AND検索
			messageEntityList = messageLogic.selectMessagesByAndSearch(searchKeyBean);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return;
		}
		// エラーメッセージのリストをセッションに登録
		HttpSession session = request.getSession();
		session.setAttribute("messageEntityList", messageEntityList);
		// 選択したホスト名をリクエストスコープに登録
		request.setAttribute("selectedHostName", hostName);

		// エラーサマリ表示画面へフォワード
		request.getRequestDispatcher("/WEB-INF/jsp/showErrorMessages.jsp").forward(request, response);

	}

}
