package dataaccess.entity;

/**
 * メッセージのエンティティクラス
 *
 * @author Takayama
 *
 */
public class MessageEntity {

	/**
	 * インシデント番号
	 */
	private String incidentNumber;

	/**
	 * ステータス
	 */
	private String status;

	/**
	 * 担当
	 */
	private String cherger;

	/**
	 * 発生日/報告受領日
	 */
	private String incidentDate;

	/**
	 * 曜日
	 */
	private String day;

	/**
	 * 詳細内容
	 */
	private String detail;

	/**
	 * TEC通知
	 */
	private String tecAlert;

	/**
	 * 発生時刻
	 */
	private String incidentTime;

	/**
	 * 発生ノード/系列
	 */
	private String nodeName;

	/**
	 * プロダクト名/モジュール名
	 */
	private String productName;

	/**
	 * 内容
	 */
	private String content;

	/**
	 * 稼働確認結果
	 */
	private String confirmResult;

	/**
	 * 取引確認
	 */
	private String transactionConfirm;

	/**
	 * ユーザ影響有無
	 */
	private String userHermress;

	/**
	 * HWエラー有無
	 */
	private String hwError;

	/**
	 * 原因/トレース状況
	 */
	private String cause;

	/**
	 * 復旧確認時刻
	 */
	private String recoverTime;

	/**
	 * 対応内容
	 */
	private String coverContent;

	/**
	 * 運用向け結果報告 ①問題有無 ②対応内容 ③手順書修正
	 */
	private String reportForRun;

	/**
	 * 対応内容（予定含む）
	 */
	private String coverPlan;

	/**
	 * 対応予定日/リリース予定日
	 */
	private String coverPlanDate;

	/**
	 * セッター/ゲッター
	 */
	public String getIncidentNumber() {
		return incidentNumber;
	}

	public void setIncidentNumber(String incidentNumber) {
		this.incidentNumber = incidentNumber;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCherger() {
		return cherger;
	}

	public void setCherger(String cherger) {
		this.cherger = cherger;
	}

	public String getIncidentDate() {
		return incidentDate;
	}

	public void setIncidentDate(String incidentDate) {
		this.incidentDate = incidentDate;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getTecAlert() {
		return tecAlert;
	}

	public void setTecAlert(String tecAlert) {
		this.tecAlert = tecAlert;
	}

	public String getIncidentTime() {
		return incidentTime;
	}

	public void setIncidentTime(String incidentTime) {
		this.incidentTime = incidentTime;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getConfirmResult() {
		return confirmResult;
	}

	public void setConfirmResult(String confirmResult) {
		this.confirmResult = confirmResult;
	}

	public String getTransactionConfirm() {
		return transactionConfirm;
	}

	public void setTransactionConfirm(String transactionConfirm) {
		this.transactionConfirm = transactionConfirm;
	}

	public String getUserHermress() {
		return userHermress;
	}

	public void setUserHermress(String userHermress) {
		this.userHermress = userHermress;
	}

	public String getHwError() {
		return hwError;
	}

	public void setHwError(String hwError) {
		this.hwError = hwError;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public String getRecoverTime() {
		return recoverTime;
	}

	public void setRecoverTime(String recoverTime) {
		this.recoverTime = recoverTime;
	}

	public String getCoverContent() {
		return coverContent;
	}

	public void setCoverContent(String coverContent) {
		this.coverContent = coverContent;
	}

	public String getReportForRun() {
		return reportForRun;
	}

	public void setReportForRun(String reportForRun) {
		this.reportForRun = reportForRun;
	}

	public String getCoverPlan() {
		return coverPlan;
	}

	public void setCoverPlan(String coverPlan) {
		this.coverPlan = coverPlan;
	}

	public String getCoverPlanDate() {
		return coverPlanDate;
	}

	public void setCoverPlanDate(String coverPlanDate) {
		this.coverPlanDate = coverPlanDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MessageEntity [incidentNumber=");
		builder.append(incidentNumber);
		builder.append(", status=");
		builder.append(status);
		builder.append(", cherger=");
		builder.append(cherger);
		builder.append(", incidentDate=");
		builder.append(incidentDate);
		builder.append(", day=");
		builder.append(day);
		builder.append(", detail=");
		builder.append(detail);
		builder.append(", tecAlert=");
		builder.append(tecAlert);
		builder.append(", incidentTime=");
		builder.append(incidentTime);
		builder.append(", nodeName=");
		builder.append(nodeName);
		builder.append(", productName=");
		builder.append(productName);
		builder.append(", content=");
		builder.append(content);
		builder.append(", confirmResult=");
		builder.append(confirmResult);
		builder.append(", transactionConfirm=");
		builder.append(transactionConfirm);
		builder.append(", userHermress=");
		builder.append(userHermress);
		builder.append(", hwError=");
		builder.append(hwError);
		builder.append(", cause=");
		builder.append(cause);
		builder.append(", recoverTime=");
		builder.append(recoverTime);
		builder.append(", coverContent=");
		builder.append(coverContent);
		builder.append(", reportForRun=");
		builder.append(reportForRun);
		builder.append(", coverPlan=");
		builder.append(coverPlan);
		builder.append(", coverPlanDate=");
		builder.append(coverPlanDate);
		builder.append("]");
		return builder.toString();
	}

}
