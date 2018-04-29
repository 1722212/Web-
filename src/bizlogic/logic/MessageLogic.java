package bizlogic.logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bizlogic.bean.SearchKeyBean;
import bizlogic.util.ConnectionUtil;
import dataaccess.dao.MessageDAO;
import dataaccess.entity.MessageEntity;

/**
 * エラーサマリのロジッククラス
 *
 * @author Takayama
 *
 */
public class MessageLogic {

	/**
	 * エラーサマリを全件取得するメソッド
	 *
	 * @return
	 * @throws SQLException
	 */
	public List<MessageEntity> searchAllMessages() throws SQLException {

		// メッセージのリストを生成
		List<MessageEntity> messageEntityList = new ArrayList<>();

		// DB接続
		try (Connection con = ConnectionUtil.getConnection();) {

			// DAO生成
			MessageDAO messageDAO = new MessageDAO();
			// 全件取得
			messageEntityList = messageDAO.selectAll(con);
		}

		return messageEntityList;
	}

	/**
	 * インシデント番号でエラーサマリを取得するメソッド
	 *
	 * @throws SQLException
	 */
	public List<MessageEntity> searchMessageByIncidentNumber(String incidentNumber) throws SQLException {

		// メッセージのリストを生成
		List<MessageEntity> messageEntityList = new ArrayList<>();

		// DB接続
		try (Connection con = ConnectionUtil.getConnection();) {

			// DAO生成
			MessageDAO messageDAO = new MessageDAO();

			// 取得
			messageEntityList = messageDAO.selectByIncidentNo(con, incidentNumber);
		}

		return messageEntityList;

	}

	/**
	 * 発生ノード/系列名であいまい検索するメソッド
	 *
	 * @throws SQLException
	 */
	public List<MessageEntity> searchByNodeName(String nodeName) throws SQLException {

		// メッセージのリストを生成
		List<MessageEntity> messageEntiyList = new ArrayList<>();
		// DB接続
		try (Connection con = ConnectionUtil.getConnection()) {

			// DAO生成
			MessageDAO messageDAO = new MessageDAO();

			// 取得
			messageEntiyList = messageDAO.selectByNode(con, nodeName);
		}

		return messageEntiyList;
	}

	/**
	 * AND検索するメソッド
	 *
	 * 指定できるキーは ①発生ノード/系列 ②プロダクト名/モジュール名 ③詳細内容
	 *
	 * @param searchKeyBean
	 * @return
	 * @throws SQLException
	 */
	public List<MessageEntity> searchMessagesByAndSearch(SearchKeyBean searchKeyBean) throws SQLException {

		// メッセージのリスト
		List<MessageEntity> messageEntityList = new ArrayList<>();

		// DB接続
		try (Connection con = ConnectionUtil.getConnection()) {

			// DAO生成
			MessageDAO messageDAO = new MessageDAO();
			// 取得
			messageEntityList = messageDAO.selectBySearchKey(con, searchKeyBean);
		}

		return messageEntityList;
	}

	/**
	 * 発生ノード/系列名を全件検索するメソッド
	 *
	 * @return
	 * @throws SQLException
	 */
	public List<String> searchAllNodeName() throws SQLException {
		// ホスト名を格納するリスト
		List<String> nodeNameList = new ArrayList<>();

		// DB接続
		try (Connection con = ConnectionUtil.getConnection()) {

			// DAO生成
			MessageDAO messageDAO = new MessageDAO();
			// ホスト名取得
			nodeNameList = messageDAO.selectAllNodeName(con);
		}
		return nodeNameList;
	}

}
