package cn.mnsrc.resultconversion.domain;

public class ResultConversion {
	private String id;
	private String 转化时间;
	private String 成果转化名称;
	private String 姓名;
	private String 工号;
	private String 参与人员;
	private String 经费;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String get转化时间() {
		return 转化时间;
	}
	public void set转化时间(String 转化时间) {
		this.转化时间 = 转化时间;
	}
	public String get成果转化名称() {
		return 成果转化名称;
	}
	public void set成果转化名称(String 成果转化名称) {
		this.成果转化名称 = 成果转化名称;
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
	public String get经费() {
		return 经费;
	}
	public void set经费(String 经费) {
		this.经费 = 经费;
	}
	@Override
	public String toString() {
		return "ResultConversion [id=" + id + ", 转化时间=" + 转化时间 + ", 成果转化名称=" + 成果转化名称 + ", 姓名=" + 姓名 + ", 工号=" + 工号
				+ ", 参与人员=" + 参与人员 + ", 经费=" + 经费 + "]";
	}
	
}
