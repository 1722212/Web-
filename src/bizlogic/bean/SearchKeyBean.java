package bizlogic.bean;

/**
 * 検索条件のBean
 *
 * @author Takayama
 *
 */
public class SearchKeyBean {

	/**
	 * ホスト名
	 */
	private String hostName;

	/**
	 * ステータス
	 * １：OPEN	２：CLOSE
	 */
	private int status;

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
		builder.append("SeachKeyBean [hostName=");
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
