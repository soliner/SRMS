package cn.mnsrc.resultidentification.domain;

public class ResultIdentification {
	private String id;
	private String 成果名称;
	private String 姓名;
	private String 工号;
	private String 参与人员;
	private String 鉴定验收单位;
	private String 鉴定日期;
	private String 鉴定结论;
	private String 电子附件;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String get成果名称() {
		return 成果名称;
	}
	public void set成果名称(String 成果名称) {
		this.成果名称 = 成果名称;
	}
	public String get姓名() {
		return 姓名;
	}
	public void set姓名(String 姓名) {
		this.姓名 = 姓名;
	}
	public String get工号() {
		return 工号;
	}
	public void set工号(String 工号) {
		this.工号 = 工号;
	}
	public String get参与人员() {
		return 参与人员;
	}
	public void set参与人员(String 参与人员) {
		this.参与人员 = 参与人员;
	}
	public String get鉴定验收单位() {
		return 鉴定验收单位;
	}
	public void set鉴定验收单位(String 鉴定验收单位) {
		this.鉴定验收单位 = 鉴定验收单位;
	}
	public String get鉴定日期() {
		return 鉴定日期;
	}
	public void set鉴定日期(String 鉴定日期) {
		this.鉴定日期 = 鉴定日期;
	}
	public String get鉴定结论() {
		return 鉴定结论;
	}
	public void set鉴定结论(String 鉴定结论) {
		this.鉴定结论 = 鉴定结论;
	}
	public String get电子附件() {
		return 电子附件;
	}
	public void set电子附件(String 电子附件) {
		this.电子附件 = 电子附件;
	}
	@Override
	public String toString() {
		return "ResultIdentification [id=" + id + ", 成果名称=" + 成果名称 + ", 姓名=" + 姓名 + ", 工号=" + 工号 + ", 参与人员=" + 参与人员
				+ ", 鉴定验收单位=" + 鉴定验收单位 + ", 鉴定日期=" + 鉴定日期 + ", 鉴定结论=" + 鉴定结论 + ", 电子附件=" + 电子附件 + "]";
	}
	

}
