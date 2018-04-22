package dataaccess.entity;

import java.sql.Timestamp;

/**
 * メッセージのエンティティクラス
 *
 * @author Takayama
 *
 */
public class MessageEntity {

	/**
	 * インシデントID
	 */
	private String incidentId;

	/**
	 * インシデント発生時刻
	 */
	private Timestamp incidentTime;

	/**
	 * ステータス 1:OPEN 2:CLOSE
	 */
	private int status;

	/**
	 * ホスト名
	 */
	private String hostName;

	/**
	 * エラーメッセージID
	 */
	private String errorMessageId;

	/**
	 * エラーメッセージ
	 */
	private String errorMessage;

	/**
	 * 進捗状況
	 */
	private String progress;

	/**
	 * 原因
	 */
	private String cause;

	public String getIncidentId() {
		return incidentId;
	}

	public void setIncidentId(String incidentId) {
		this.incidentId = incidentId;
	}

	public Timestamp getIncidentTime() {
		return incidentTime;
	}

	public void setIncidentTime(Timestamp incidentTime) {
		this.incidentTime = incidentTime;
	}

	/**
	 * １：OPEN	２：CLOSE
	 * @param status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * １：OPEN	２：CLOSE
	 * @param status
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getErrorMessageId() {
		return errorMessageId;
	}

	public void setErrorMessageId(String errorMessageId) {
		this.errorMessageId = errorMessageId;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getProgress() {
		return progress;
	}

	public void setProgress(String progress) {
		this.progress = progress;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MessageEntity [incidentId=");
		builder.append(incidentId);
		builder.append(", incidentTime=");
		builder.append(incidentTime);
		builder.append(", status=");
		builder.append(status);
		builder.append(", hostName=");
		builder.append(hostName);
		builder.append(", errorMessageId=");
		builder.append(errorMessageId);
		builder.append(", errorMessage=");
		builder.append(errorMessage);
		builder.append(", progress=");
		builder.append(progress);
		builder.append(", cause=");
		builder.append(cause);
		builder.append("]");
		return builder.toString();
	}

}
