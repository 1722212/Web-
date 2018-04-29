package presentation.form;

/**
 * 検索条件のフォーム
 *
 * @author Takayama
 *
 */
public class SearchKeyForm {

	/**
	 * 発生ノード/系列
	 */
	private String nodeName;

	/**
	 * プロダクト名/モジュール名
	 */
	private String productName;

	/**
	 * 詳細内容
	 */
	private String detail;

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

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SearchKeyBean [nodeName=");
		builder.append(nodeName);
		builder.append(", productName=");
		builder.append(productName);
		builder.append(", detail=");
		builder.append(detail);
		builder.append("]");
		return builder.toString();
	}

}
