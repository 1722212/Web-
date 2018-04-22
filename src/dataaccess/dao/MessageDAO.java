package dataaccess.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bizlogic.bean.SearchKeyBean;
import dataaccess.entity.MessageEntity;

/**
 * メッセージエンティティのDAO
 *
 * @author Takayama
 *
 */
public class MessageDAO {

	/**
	 * メッセージを全件検索するDAO
	 *
	 * @param con
	 * @return messageEntity
	 * @throws SQLException
	 */
	public List<MessageEntity> selectAll(Connection con) throws SQLException {

		// メッセージエンティティを格納するリスト
		List<MessageEntity> messageList = new ArrayList<MessageEntity>();

		// SQL
		String sql = "SELECT * FROM MESSAGE";

		try (PreparedStatement ps = con.prepareStatement(sql)) {

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {

					// メッセージエンティティ生成
					MessageEntity messageEntity = new MessageEntity();

					messageEntity.setIncidentId(rs.getString("INCIDENT_ID"));
					messageEntity.setIncidentTime(rs.getTimestamp("INCIDENT_TIME"));
					messageEntity.setStatus(rs.getInt("STATUS"));
					messageEntity.setHostName(rs.getString("HOST_NAME"));
					messageEntity.setErrorMessageId(rs.getString("ERROR_MESSAGE_ID"));
					messageEntity.setErrorMessage(rs.getString("ERROR_MESSAGE"));
					messageEntity.setProgress(rs.getString("PROGRESS"));
					messageEntity.setCause(rs.getString("CAUSE"));

					// リストに追加
					messageList.add(messageEntity);
				}
			}
		}

		return messageList;
	}

	/**
	 * メッセージをIDで検索するDAO
	 *
	 * @param con
	 * @param incidentId
	 * @return
	 * @throws SQLException
	 */
	public MessageEntity selectById(Connection con, String incidentId) throws SQLException {

		// SQL
		String sql = "SELECT * FROM MESSAGE WHERE INCIDENT_ID = ?";
		// メッセージエンティティ生成
		MessageEntity messageEntity = new MessageEntity();

		try (PreparedStatement ps = con.prepareStatement(sql)) {

			// クエリをセット
			ps.setString(1, incidentId);

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {

					messageEntity.setIncidentId(rs.getString("INCIDENT_ID"));
					messageEntity.setIncidentTime(rs.getTimestamp("INCIDENT_TIME"));
					messageEntity.setStatus(rs.getInt("STATUS"));
					messageEntity.setHostName(rs.getString("HOST_NAME"));
					messageEntity.setErrorMessageId(rs.getString("ERROR_MESSAGE_ID"));
					messageEntity.setErrorMessage(rs.getString("ERROR_MESSAGE"));
					messageEntity.setProgress(rs.getString("PROGRESS"));
					messageEntity.setCause(rs.getString("CAUSE"));
				}
			}
		}
		return messageEntity;
	}

	/**
	 * AND検索するDAO
	 *
	 * @param con
	 * @param searchKeyBean
	 * @return
	 * @throws SQLException
	 */
	public List<MessageEntity> selectBySearchKey(Connection con, SearchKeyBean searchKeyBean) throws SQLException {

		// SQL
		String sql = "SELECT * FROM MESSAGE WHERE HOST_NAME = ? AND STATUS = ?";
		// メッセージエンティティリストの生成
		List<MessageEntity> messageEntityList = new ArrayList<>();

		try (PreparedStatement ps = con.prepareStatement(sql)) {

			// クエリをセット
			ps.setString(1, searchKeyBean.getHostName());
			ps.setInt(2, searchKeyBean.getStatus());
			// ps.setString(3, searchKeyBean.getErrorMessage());
			// ps.setString(4, searchKeyBean.getCause());

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {

					// メッセージエンティティ生成
					MessageEntity messageEntity = new MessageEntity();

					messageEntity.setIncidentId(rs.getString("INCIDENT_ID"));
					messageEntity.setIncidentTime(rs.getTimestamp("INCIDENT_TIME"));
					messageEntity.setStatus(rs.getInt("STATUS"));
					messageEntity.setHostName(rs.getString("HOST_NAME"));
					messageEntity.setErrorMessageId(rs.getString("ERROR_MESSAGE_ID"));
					messageEntity.setErrorMessage(rs.getString("ERROR_MESSAGE"));
					messageEntity.setProgress(rs.getString("PROGRESS"));
					messageEntity.setCause(rs.getString("CAUSE"));

					// リストに追加
					messageEntityList.add(messageEntity);
				}
			}
		}
		return messageEntityList;
	}

	/**
	 * ホスト名を全件検索するDAO
	 *
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public List<String> selectHostName(Connection con) throws SQLException {
		// SQL
		String sql = "SELECT DISTINCT HOST_NAME FROM MESSAGE";
		// ホスト名のリスト
		List<String> hostNameList = new ArrayList<>();

		try (PreparedStatement ps = con.prepareStatement(sql)) {

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {

					// 検索しリストに追加
					hostNameList.add(rs.getString("HOST_NAME"));
				}
			}
		}
		return hostNameList;
	}

	/**
	 * メッセージを登録するDAO
	 *
	 * @param con
	 * @param messageEntity
	 * @return
	 * @throws SQLException
	 */
	public int insert(Connection con, MessageEntity messageEntity) throws SQLException {

		// 登録件数
		int cnt = 0;
		// SQL
		String sql = "INSERT INTO MESSAGE ("
				+ "INCIDENT_ID, INCIDENT_TIME, STATUS, HOST_NAME, ERROR_MESSAGE_ID, ERROR_MESSAGE, PROGRESS, CAUSE"
				+ ") VALUES (" + "?, ?, ?, ?, ?, ?, ?, ?" + ")";

		try (PreparedStatement ps = con.prepareStatement(sql);) {

			// クエリをセット
			ps.setString(1, messageEntity.getIncidentId());
			ps.setTimestamp(2, messageEntity.getIncidentTime());
			ps.setInt(3, messageEntity.getStatus());
			ps.setString(4, messageEntity.getHostName());
			ps.setString(5, messageEntity.getErrorMessageId());
			ps.setString(6, messageEntity.getErrorMessage());
			ps.setString(7, messageEntity.getProgress());
			ps.setString(8, messageEntity.getCause());
			// 実行
			cnt = ps.executeUpdate();
			System.out.println(cnt + "件登録しました");

		}
		return cnt;
	}

	/**
	 * メッセージを更新するDAO
	 *
	 * @param con
	 * @param messageEntity
	 * @param incidentId
	 * @return
	 * @throws SQLException
	 */
	public int update(Connection con, MessageEntity messageEntity, String incidentId) throws SQLException {

		// 変更件数
		int cnt = 0;
		// SQL
		String sql = "UPDATE MESSAGE SET " + "INCIDENT_ID = ?, " + "INCIDENT_TIME = ?, " + "STATUS = ?, "
				+ "HOST_NAME = ?, " + "ERROR_MESSAGE_ID = ?, " + "ERROR_MESSAGE = ?, " + "PROGRESS = ?, " + "CAUSE = ?"
				+ "WHERE INCIDENT_ID = ?";

		try (PreparedStatement ps = con.prepareStatement(sql);) {

			// クエリをセット
			ps.setString(1, messageEntity.getIncidentId());
			ps.setTimestamp(2, messageEntity.getIncidentTime());
			ps.setInt(3, messageEntity.getStatus());
			ps.setString(4, messageEntity.getHostName());
			ps.setString(5, messageEntity.getErrorMessageId());
			ps.setString(6, messageEntity.getErrorMessage());
			ps.setString(7, messageEntity.getProgress());
			ps.setString(8, messageEntity.getCause());
			ps.setString(9, incidentId);
			// 実行
			cnt = ps.executeUpdate();
			System.out.println(cnt + "件変更しました");
		}

		return cnt;
	}

	/**
	 * メッセージを削除するDAO
	 *
	 * @param con
	 * @param incidentId
	 * @return
	 * @throws SQLException
	 */
	public int delete(Connection con, String incidentId) throws SQLException {

		// 削除件数
		int cnt = 0;
		// SQL
		String sql = "DELETE FROM MESSAGE WHERE INCIDENT_ID = ?";

		try (PreparedStatement ps = con.prepareStatement(sql)) {

			// クエリをセット
			ps.setString(1, incidentId);
			// 実行
			cnt = ps.executeUpdate();
			System.out.println(cnt + "件削除しました");
		}

		return cnt;
	}

}
