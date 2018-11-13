package cn.mnsrc.resultadoption.domain;

public class ResultAdoption {
	private String 报告名称;
	private String 姓名;
	private String 工号;
	private String 参与人;
	private String 报告类型;
	private String 报告级别;
	private String 提交日期;
	private String 电子附件;
	public String get报告名称() {
		return 报告名称;
	}
	public void set报告名称(String 报告名称) {
		this.报告名称 = 报告名称;
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
	public String get参与人() {
		return 参与人;
	}
	public void set参与人(String 参与人) {
		this.参与人 = 参与人;
	}
	public String get报告类型() {
		return 报告类型;
	}
	public void set报告类型(String 报告类型) {
		this.报告类型 = 报告类型;
	}
	public String get报告级别() {
		return 报告级别;
	}
	public void set报告级别(String 报告级别) {
		this.报告级别 = 报告级别;
	}
	public String get提交日期() {
		return 提交日期;
	}
	public void set提交日期(String 提交日期) {
		this.提交日期 = 提交日期;
	}
	public String get电子附件() {
		return 电子附件;
	}
	public void set电子附件(String 电子附件) {
		this.电子附件 = 电子附件;
	}
	@Override
	public String toString() {
		return "ResultAdoption [报告名称=" + 报告名称 + ", 姓名=" + 姓名 + ", 工号=" + 工号 + ", 参与人=" + 参与人 + ", 报告类型=" + 报告类型
				+ ", 报告级别=" + 报告级别 + ", 提交日期=" + 提交日期 + ", 电子附件=" + 电子附件 + "]";
	}
	

}
