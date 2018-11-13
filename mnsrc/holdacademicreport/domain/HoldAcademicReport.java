package cn.mnsrc.holdacademicreport.domain;

public class HoldAcademicReport {
	private String 报告人姓名;
	private String 举办时间;
	private String 单位;
	private String 职务;
	private String 报告题目;
	private String 地点;
	private String 联系人;
	private String 备注;
	public String get报告人姓名() {
		return 报告人姓名;
	}
	public void set报告人姓名(String 报告人姓名) {
		this.报告人姓名 = 报告人姓名;
	}
	public String get举办时间() {
		return 举办时间;
	}
	public void set举办时间(String 举办时间) {
		this.举办时间 = 举办时间;
	}
	public String get单位() {
		return 单位;
	}
	public void set单位(String 单位) {
		this.单位 = 单位;
	}
	public String get职务() {
		return 职务;
	}
	public void set职务(String 职务) {
		this.职务 = 职务;
	}
	public String get报告题目() {
		return 报告题目;
	}
	public void set报告题目(String 报告题目) {
		this.报告题目 = 报告题目;
	}
	public String get地点() {
		return 地点;
	}
	public void set地点(String 地点) {
		this.地点 = 地点;
	}
	public String get联系人() {
		return 联系人;
	}
	public void set联系人(String 联系人) {
		this.联系人 = 联系人;
	}
	public String get备注() {
		return 备注;
	}
	public void set备注(String 备注) {
		this.备注 = 备注;
	}
	@Override
	public String toString() {
		return "HoldAcademicReport [报告人姓名=" + 报告人姓名 + ", 举办时间=" + 举办时间 + ", 单位=" + 单位 + ", 职务=" + 职务 + ", 报告题目=" + 报告题目
				+ ", 地点=" + 地点 + ", 联系人=" + 联系人 + ", 备注=" + 备注 + "]";
	}

}
