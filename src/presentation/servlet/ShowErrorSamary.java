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
		// 発生ノード/系列名のリスト
		List<String> nodeNameList = new ArrayList<>();

		try {
			// エラーメッセージを全件取得
			messageEntityList = messageLogic.searchAllMessages();

			// 発生ノード/系列名を全件取得
			nodeNameList = messageLogic.searchAllNodeName();

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return;
		}

		// セッション取得
		HttpSession session = request.getSession();
		// 発生ノード/系列名をセッションに登録
		session.setAttribute("nodeNameList", nodeNameList);
		// エラーメッセージのリストをセッションに登録
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
		String nodeName = request.getParameter("nodeName");
		String productName = request.getParameter("productName");
		String detail = request.getParameter("detail");

		// 検索条件フォーム生成
		SearchKeyForm searchKeyForm = new SearchKeyForm();
		searchKeyForm.setNodeName(nodeName);
		searchKeyForm.setProductName(productName);
		searchKeyForm.setDetail(detail);

		// バリデート

		// 検索条件をBeanに詰め替え
		SearchKeyBean searchKeyBean = new SearchKeyBean();
		searchKeyBean.setNodeName(nodeName);
		searchKeyBean.setProductName(productName);
		searchKeyBean.setDetail(detail);

		// ロジック取得
		MessageLogic messageLogic = new MessageLogic();
		// エラーメッセージのリストを生成
		List<MessageEntity> messageEntityList = new ArrayList<>();
		try {
			// AND検索
			messageEntityList = messageLogic.searchMessagesByAndSearch(searchKeyBean);

		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return;
		}
		// エラーメッセージのリストをセッションに登録
		HttpSession session = request.getSession();
		session.setAttribute("messageEntityList", messageEntityList);

		// エラーサマリ表示画面へフォワード
		request.getRequestDispatcher("/WEB-INF/jsp/showErrorMessages.jsp").forward(request, response);

	}

}
