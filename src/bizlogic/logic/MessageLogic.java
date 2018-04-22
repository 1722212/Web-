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
	public List<MessageEntity> selectAllMessages() throws SQLException {

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
	 * AND検索するメソッド
	 *
	 * @param searchKeyBean
	 * @return
	 * @throws SQLException
	 */
	public List<MessageEntity> selectMessagesByAndSearch(SearchKeyBean searchKeyBean) throws SQLException {

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
	 * ホスト名を全件検索するメソッド
	 *
	 * @return
	 * @throws SQLException
	 */
	public List<String> selectHostName() throws SQLException {
		// ホスト名を格納するリスト
		List<String> hostNameList = new ArrayList<>();

		// DB接続
		try (Connection con = ConnectionUtil.getConnection()) {

			// DAO生成
			MessageDAO messageDAO = new MessageDAO();
			// ホスト名取得
			hostNameList = messageDAO.selectHostName(con);
		}
		return hostNameList;
	}

}
