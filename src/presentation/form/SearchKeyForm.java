package presentation.form;

/**
 * 検索条件のフォーム
 *
 * @author Takayama
 *
 */
public class SearchKeyForm {

	/**
	 * ホスト名
	 */
	private String hostName;

	/**
	 * ステータス
	 */
	private String status;

	/**
	 * エラーメッセージ
	 */
	private String errorMessage;

	/**
	 * 原因
	 */
	private String cause;

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
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
		builder.append("SearchKeyForm [hostName=");
		builder.append(hostName);
		builder.append(", status=");
		builder.append(status);
		builder.append(", errorMessage=");
		builder.append(errorMessage);
		builder.append(", cause=");
		builder.append(cause);
		builder.append("]");
		return builder.toString();
	}

}
