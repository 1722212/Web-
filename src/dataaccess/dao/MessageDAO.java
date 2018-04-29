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
		String sql = "SELECT * FROM MESSAGE ORDER BY INCIDENT_NUMBER ASC";

		try (PreparedStatement ps = con.prepareStatement(sql)) {

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {

					// メッセージエンティティ生成
					MessageEntity messageEntity = new MessageEntity();

					messageEntity.setIncidentNumber(rs.getString("INCIDENT_NUMBER"));
					messageEntity.setStatus(rs.getString("STATUS"));
					messageEntity.setCherger(rs.getString("CHERGER"));
					messageEntity.setIncidentDate(rs.getString("INCIDENT_DATE"));
					messageEntity.setDay(rs.getString("DAY"));
					messageEntity.setDetail(rs.getString("DETAIL"));
					messageEntity.setTecAlert(rs.getString("TEC_ALERT"));
					messageEntity.setIncidentTime(rs.getString("INCIDENT_TIME"));
					messageEntity.setNodeName(rs.getString("NODE_NAME"));
					messageEntity.setProductName(rs.getString("PRODUCT_NAME"));
					messageEntity.setContent(rs.getString("CONTENT"));
					messageEntity.setConfirmResult(rs.getString("CONFIRM_RESULT"));
					messageEntity.setTransactionConfirm(rs.getString("TRANSACTION_CONFIRM"));
					messageEntity.setUserHermress(rs.getString("USER_HARMRESS"));
					messageEntity.setHwError(rs.getString("HW_ERROR"));
					messageEntity.setCause(rs.getString("CAUSE"));
					messageEntity.setRecoverTime(rs.getString("RECOVER_TIME"));
					messageEntity.setCoverContent(rs.getString("COVER_CONTENT"));
					messageEntity.setReportForRun(rs.getString("REPORT_FOR_RUN"));
					messageEntity.setCoverPlan(rs.getString("COVER_PLAN"));
					messageEntity.setCoverPlanDate(rs.getString("COVER_PLAN_DATE"));

					// リストに追加
					messageList.add(messageEntity);
				}
			}
		}

		return messageList;
	}

	/**
	 * メッセージをインシデント番号で検索するDAO
	 *
	 * @param con
	 * @param incidentId
	 * @return
	 * @throws SQLException
	 */
	public List<MessageEntity> selectByIncidentNo(Connection con, String incidectNo) throws SQLException {

		// SQL
		String sql = "SELECT * FROM MESSAGE WHERE INCIDENT_NUMBER = ?";
		// メッセージエンティティを格納するリスト
		List<MessageEntity> messageList = new ArrayList<MessageEntity>();

		try (PreparedStatement ps = con.prepareStatement(sql)) {

			// クエリをセット
			ps.setString(1, incidectNo);

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {

					// メッセージエンティティ生成
					MessageEntity messageEntity = new MessageEntity();

					messageEntity.setIncidentNumber(rs.getString("INCIDENT_NUMBER"));
					messageEntity.setStatus(rs.getString("STATUS"));
					messageEntity.setCherger(rs.getString("CHERGER"));
					messageEntity.setIncidentDate(rs.getString("INCIDENT_DATE"));
					messageEntity.setDay(rs.getString("DAY"));
					messageEntity.setDetail(rs.getString("DETAIL"));
					messageEntity.setTecAlert(rs.getString("TEC_ALERT"));
					messageEntity.setIncidentTime(rs.getString("INCIDENT_TIME"));
					messageEntity.setNodeName(rs.getString("NODE_NAME"));
					messageEntity.setProductName(rs.getString("PRODUCT_NAME"));
					messageEntity.setContent(rs.getString("CONTENT"));
					messageEntity.setConfirmResult(rs.getString("CONFIRM_RESULT"));
					messageEntity.setTransactionConfirm(rs.getString("TRANSACTION_CONFIRM"));
					messageEntity.setUserHermress(rs.getString("USER_HARMRESS"));
					messageEntity.setHwError(rs.getString("HW_ERROR"));
					messageEntity.setCause(rs.getString("CAUSE"));
					messageEntity.setRecoverTime(rs.getString("RECOVER_TIME"));
					messageEntity.setCoverContent(rs.getString("COVER_CONTENT"));
					messageEntity.setReportForRun(rs.getString("REPORT_FOR_RUN"));
					messageEntity.setCoverPlan(rs.getString("COVER_PLAN"));
					messageEntity.setCoverPlanDate(rs.getString("COVER_PLAN_DATE"));

					// リストに追加
					messageList.add(messageEntity);
				}
			}
		}
		return messageList;
	}

	/**
	 * 発生ノード/系列であいまい検索するメソッド
	 *
	 * @throws SQLException
	 */
	public List<MessageEntity> selectByNode(Connection con, String nodeName) throws SQLException {

		// SQL
		String sql = "SELECT * FROM MESSAGE WHERE NODE_NAME LIKE ?";

		// メッセージエンティティを格納するリスト
		List<MessageEntity> messageList = new ArrayList<MessageEntity>();

		try (PreparedStatement ps = con.prepareStatement(sql)) {

			// クエリをセット
			ps.setString(1, "%" + nodeName + "%");

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {

					// メッセージエンティティ生成
					MessageEntity messageEntity = new MessageEntity();

					messageEntity.setIncidentNumber(rs.getString("INCIDENT_NUMBER"));
					messageEntity.setStatus(rs.getString("STATUS"));
					messageEntity.setCherger(rs.getString("CHERGER"));
					messageEntity.setIncidentDate(rs.getString("INCIDENT_DATE"));
					messageEntity.setDay(rs.getString("DAY"));
					messageEntity.setDetail(rs.getString("DETAIL"));
					messageEntity.setTecAlert(rs.getString("TEC_ALERT"));
					messageEntity.setIncidentTime(rs.getString("INCIDENT_TIME"));
					messageEntity.setNodeName(rs.getString("NODE_NAME"));
					messageEntity.setProductName(rs.getString("PRODUCT_NAME"));
					messageEntity.setContent(rs.getString("CONTENT"));
					messageEntity.setConfirmResult(rs.getString("CONFIRM_RESULT"));
					messageEntity.setTransactionConfirm(rs.getString("TRANSACTION_CONFIRM"));
					messageEntity.setUserHermress(rs.getString("USER_HARMRESS"));
					messageEntity.setHwError(rs.getString("HW_ERROR"));
					messageEntity.setCause(rs.getString("CAUSE"));
					messageEntity.setRecoverTime(rs.getString("RECOVER_TIME"));
					messageEntity.setCoverContent(rs.getString("COVER_CONTENT"));
					messageEntity.setReportForRun(rs.getString("REPORT_FOR_RUN"));
					messageEntity.setCoverPlan(rs.getString("COVER_PLAN"));
					messageEntity.setCoverPlanDate(rs.getString("COVER_PLAN_DATE"));

					// リストに追加
					messageList.add(messageEntity);
				}
			}
		}
		return messageList;

	}

	/**
	 * プロダクト名/モジュール名で検索するメソッド
	 *
	 * @throws SQLException
	 */
	public List<MessageEntity> selectByProduct(Connection con, String productName) throws SQLException {

		// SQL
		String sql = "SELECT * FROM MESSAGE WHERE PRODUCT_NAME LIKE ?";

		// メッセージエンティティを格納するリスト
		List<MessageEntity> messageList = new ArrayList<MessageEntity>();

		try (PreparedStatement ps = con.prepareStatement(sql)) {

			// クエリをセット
			ps.setString(1, "%" + productName + "%");

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {

					// メッセージエンティティ生成
					MessageEntity messageEntity = new MessageEntity();

					messageEntity.setIncidentNumber(rs.getString("INCIDENT_NUMBER"));
					messageEntity.setStatus(rs.getString("STATUS"));
					messageEntity.setCherger(rs.getString("CHERGER"));
					messageEntity.setIncidentDate(rs.getString("INCIDENT_DATE"));
					messageEntity.setDay(rs.getString("DAY"));
					messageEntity.setDetail(rs.getString("DETAIL"));
					messageEntity.setTecAlert(rs.getString("TEC_ALERT"));
					messageEntity.setIncidentTime(rs.getString("INCIDENT_TIME"));
					messageEntity.setNodeName(rs.getString("NODE_NAME"));
					messageEntity.setProductName(rs.getString("PRODUCT_NAME"));
					messageEntity.setContent(rs.getString("CONTENT"));
					messageEntity.setConfirmResult(rs.getString("CONFIRM_RESULT"));
					messageEntity.setTransactionConfirm(rs.getString("TRANSACTION_CONFIRM"));
					messageEntity.setUserHermress(rs.getString("USER_HARMRESS"));
					messageEntity.setHwError(rs.getString("HW_ERROR"));
					messageEntity.setCause(rs.getString("CAUSE"));
					messageEntity.setRecoverTime(rs.getString("RECOVER_TIME"));
					messageEntity.setCoverContent(rs.getString("COVER_CONTENT"));
					messageEntity.setReportForRun(rs.getString("REPORT_FOR_RUN"));
					messageEntity.setCoverPlan(rs.getString("COVER_PLAN"));
					messageEntity.setCoverPlanDate(rs.getString("COVER_PLAN_DATE"));

					// リストに追加
					messageList.add(messageEntity);
				}
			}
		}
		return messageList;
	}

	/**
	 * 詳細内容（エラーメッセージ）で検索するメソッド
	 *
	 * @throws SQLException
	 */
	public List<MessageEntity> selectByContent(Connection con, String detail) throws SQLException {

		// SQL
		String sql = "SELECT * FROM MESSAGE WHERE CONTENT LIKE ?";

		// メッセージエンティティを格納するリスト
		List<MessageEntity> messageList = new ArrayList<MessageEntity>();

		try (PreparedStatement ps = con.prepareStatement(sql)) {

			// クエリをセット
			ps.setString(1, "%" + detail + "%");

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {

					// メッセージエンティティ生成
					MessageEntity messageEntity = new MessageEntity();

					messageEntity.setIncidentNumber(rs.getString("INCIDENT_NUMBER"));
					messageEntity.setStatus(rs.getString("STATUS"));
					messageEntity.setCherger(rs.getString("CHERGER"));
					messageEntity.setIncidentDate(rs.getString("INCIDENT_DATE"));
					messageEntity.setDay(rs.getString("DAY"));
					messageEntity.setDetail(rs.getString("DETAIL"));
					messageEntity.setTecAlert(rs.getString("TEC_ALERT"));
					messageEntity.setIncidentTime(rs.getString("INCIDENT_TIME"));
					messageEntity.setNodeName(rs.getString("NODE_NAME"));
					messageEntity.setProductName(rs.getString("PRODUCT_NAME"));
					messageEntity.setContent(rs.getString("CONTENT"));
					messageEntity.setConfirmResult(rs.getString("CONFIRM_RESULT"));
					messageEntity.setTransactionConfirm(rs.getString("TRANSACTION_CONFIRM"));
					messageEntity.setUserHermress(rs.getString("USER_HARMRESS"));
					messageEntity.setHwError(rs.getString("HW_ERROR"));
					messageEntity.setCause(rs.getString("CAUSE"));
					messageEntity.setRecoverTime(rs.getString("RECOVER_TIME"));
					messageEntity.setCoverContent(rs.getString("COVER_CONTENT"));
					messageEntity.setReportForRun(rs.getString("REPORT_FOR_RUN"));
					messageEntity.setCoverPlan(rs.getString("COVER_PLAN"));
					messageEntity.setCoverPlanDate(rs.getString("COVER_PLAN_DATE"));

					// リストに追加
					messageList.add(messageEntity);
				}
			}
		}
		return messageList;
	}

	/**
	 * AND検索するDAO
	 *
	 * 指定できるキーは ①発生ノード/系列 ②プロダクト名/モジュール名 ③詳細内容
	 *
	 * @param con
	 * @param searchKeyBean
	 * @return
	 * @throws SQLException
	 */
	public List<MessageEntity> selectBySearchKey(Connection con, SearchKeyBean searchKeyBean) throws SQLException {

		// SQL
		String sql = "SELECT * FROM MESSAGE " + "WHERE NODE_NAME LIKE ? " + "AND PRODUCT_NAME LIKE ? AND DETAIL LIKE ?";

		// メッセージエンティティリストの生成
		List<MessageEntity> messageEntityList = new ArrayList<>();

		try (PreparedStatement ps = con.prepareStatement(sql)) {

			// クエリをセット
			ps.setString(1, "%" + searchKeyBean.getNodeName() + "%");
			ps.setString(2, "%" + searchKeyBean.getProductName() + "%");
			ps.setString(3, "%" + searchKeyBean.getDetail() + "%");

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {

					// メッセージエンティティ生成
					MessageEntity messageEntity = new MessageEntity();

					messageEntity.setIncidentNumber(rs.getString("INCIDENT_NUMBER"));
					messageEntity.setStatus(rs.getString("STATUS"));
					messageEntity.setCherger(rs.getString("CHERGER"));
					messageEntity.setIncidentDate(rs.getString("INCIDENT_DATE"));
					messageEntity.setDay(rs.getString("DAY"));
					messageEntity.setDetail(rs.getString("DETAIL"));
					messageEntity.setTecAlert(rs.getString("TEC_ALERT"));
					messageEntity.setIncidentTime(rs.getString("INCIDENT_TIME"));
					messageEntity.setNodeName(rs.getString("NODE_NAME"));
					messageEntity.setProductName(rs.getString("PRODUCT_NAME"));
					messageEntity.setContent(rs.getString("CONTENT"));
					messageEntity.setConfirmResult(rs.getString("CONFIRM_RESULT"));
					messageEntity.setTransactionConfirm(rs.getString("TRANSACTION_CONFIRM"));
					messageEntity.setUserHermress(rs.getString("USER_HARMRESS"));
					messageEntity.setHwError(rs.getString("HW_ERROR"));
					messageEntity.setCause(rs.getString("CAUSE"));
					messageEntity.setRecoverTime(rs.getString("RECOVER_TIME"));
					messageEntity.setCoverContent(rs.getString("COVER_CONTENT"));
					messageEntity.setReportForRun(rs.getString("REPORT_FOR_RUN"));
					messageEntity.setCoverPlan(rs.getString("COVER_PLAN"));
					messageEntity.setCoverPlanDate(rs.getString("COVER_PLAN_DATE"));

					// リストに追加
					messageEntityList.add(messageEntity);
				}
			}
		}
		return messageEntityList;
	}

	/**
	 * 発生ノード/モジュール名を全件検索するDAO
	 *
	 * @param con
	 * @return
	 * @throws SQLException
	 */
	public List<String> selectAllNodeName(Connection con) throws SQLException {
		// SQL
		String sql = "SELECT DISTINCT NODE_NAME FROM MESSAGE";
		// ホスト名のリスト
		List<String> nodeNameList = new ArrayList<>();

		try (PreparedStatement ps = con.prepareStatement(sql)) {

			try (ResultSet rs = ps.executeQuery()) {

				while (rs.next()) {

					// 検索しリストに追加
					nodeNameList.add(rs.getString("NODE_NAME"));
				}
			}
		}
		return nodeNameList;
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
		String sql = "INSERT INTO MESSAGE (" + "INCIDENT_NUMBER, " + "STATUS, " + "CHERGER, " + "INCIDENT_DATE, "
				+ "DAY, " + "DETAIL, " + "TEC_ALERT, " + "INCIDENT_TIME, " + "NODE_NAME, " + "PRODUCT_NAME, "
				+ "CONTENT, " + "CONFIRM_RESULT, " + "TRANSACTION_CONFIRM, " + "USER_HARMRESS, " + "HW_ERROR, "
				+ "CAUSE, " + "RECOVER_TIME, " + "COVER_CONTENT, " + "REPORT_FOR_RUN, " + "COVER_PLAN, "
				+ "COVER_PLAN_DATE" + ") VALUES (I" + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?" + ");";

		try (PreparedStatement ps = con.prepareStatement(sql);) {

			// クエリをセット
			ps.setString(1, "INCIDENT_NUMBER");
			ps.setString(2, "STATUS");
			ps.setString(3, "CHERGER");
			ps.setString(4, "INCIDENT_DATE");
			ps.setString(5, "DAY");
			ps.setString(6, "DETAIL");
			ps.setString(7, "TEC_ALERT");
			ps.setString(8, "INCIDENT_TIME");
			ps.setString(9, "NODE_NAME");
			ps.setString(10, "PRODUCT_NAME");
			ps.setString(11, "CONTENT");
			ps.setString(12, "CONFIRM_RESULT");
			ps.setString(13, "TRANSACTION_CONFIRM");
			ps.setString(14, "USER_HARMRESS");
			ps.setString(15, "HW_ERROR");
			ps.setString(16, "CAUSE");
			ps.setString(17, "RECOVER_TIME");
			ps.setString(18, "COVER_CONTENT");
			ps.setString(19, "REPORT_FOR_RUN");
			ps.setString(20, "COVER_PLAN");
			ps.setString(21, "COVER_PLAN_DATE");

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
	public int update(Connection con, MessageEntity messageEntity, String incidentNumber) throws SQLException {

		// 変更件数
		int cnt = 0;
		// SQL
		String sql = "UPDATE MESSAGE SET " + "INCIDENT_NUMBER = ?, " + "STATUS = ?, " + "CHERGER = ?, "
				+ "INCIDENT_DATE = ?, " + "DAY = ?, " + "DETAIL = ?, " + "TEC_ALERT = ?, " + "INCIDENT_TIME = ?, "
				+ "NODE_NAME = ?, " + "PRODUCT_NAME = ?, " + "CONTENT = ?, " + "CONFIRM_RESULT = ?, "
				+ "TRANSACTION_CONFIRM = ?, " + "USER_HARMRESS = ?, " + "HW_ERROR = ?, " + "CAUSE = ?, "
				+ "RECOVER_TIME = ?, " + "COVER_CONTENT = ?, " + "REPORT_FOR_RUN = ?, " + "COVER_PLAN = ?, "
				+ "COVER_PLAN_DATE = ? " + "WHERE INCIDENT_NUMBER = ?";

		try (PreparedStatement ps = con.prepareStatement(sql);) {

			// クエリをセット
			ps.setString(1, messageEntity.getIncidentNumber());
			ps.setString(2, messageEntity.getStatus());
			ps.setString(3, messageEntity.getCherger());
			ps.setString(4, messageEntity.getIncidentDate());
			ps.setString(5, messageEntity.getDay());
			ps.setString(6, messageEntity.getDetail());
			ps.setString(7, messageEntity.getTecAlert());
			ps.setString(8, messageEntity.getIncidentTime());
			ps.setString(9, messageEntity.getNodeName());
			ps.setString(10, messageEntity.getProductName());
			ps.setString(11, messageEntity.getContent());
			ps.setString(12, messageEntity.getConfirmResult());
			ps.setString(13, messageEntity.getTransactionConfirm());
			ps.setString(14, messageEntity.getUserHermress());
			ps.setString(15, messageEntity.getHwError());
			ps.setString(16, messageEntity.getCause());
			ps.setString(17, messageEntity.getRecoverTime());
			ps.setString(18, messageEntity.getCoverContent());
			ps.setString(19, messageEntity.getReportForRun());
			ps.setString(20, messageEntity.getCoverPlan());
			ps.setString(21, messageEntity.getCoverPlanDate());

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
	public int delete(Connection con, String incidectNo) throws SQLException {

		// 削除件数
		int cnt = 0;
		// SQL
		String sql = "DELETE FROM MESSAGE WHERE INCIDENT_NUMBER = ?";

		try (PreparedStatement ps = con.prepareStatement(sql)) {

			// クエリをセット
			ps.setString(1, incidectNo);
			// 実行
			cnt = ps.executeUpdate();
			System.out.println(cnt + "件削除しました");
		}

		return cnt;
	}

}
