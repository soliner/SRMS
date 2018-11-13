package cn.mnsrc.joinacademicconference.domain;

public class JoinAcademicConference {
	private String 姓名;
	private String 时间;
	private String 会议名称;
	private String 会议级别;
	private String 地点;
	private String 参会形式;
	private String 分会报告;
	private String 参与会议相关材料;
	private String 备注;
	@Override
	public String toString() {
		return "JoinAcademicConference [姓名=" + 姓名 + ", 时间=" + 时间 + ", 会议名称=" + 会议名称 + ", 会议级别=" + 会议级别 + ", 地点=" + 地点
				+ ", 参会形式=" + 参会形式 + ", 分会报告=" + 分会报告 + ", 参与会议相关材料=" + 参与会议相关材料 + ", 备注=" + 备注 + "]";
	}
	public String get姓名() {
		return 姓名;
	}
	public void set姓名(String 姓名) {
		this.姓名 = 姓名;
	}
	public String get时间() {
		return 时间;
	}
	public void set时间(String 时间) {
		this.时间 = 时间;
	}
	public String get会议名称() {
		return 会议名称;
	}
	public void set会议名称(String 会议名称) {
		this.会议名称 = 会议名称;
	}
	public String get会议级别() {
		return 会议级别;
	}
	public void set会议级别(String 会议级别) {
		this.会议级别 = 会议级别;
	}
	public String get地点() {
		return 地点;
	}
	public void set地点(String 地点) {
		this.地点 = 地点;
	}
	public String get参会形式() {
		return 参会形式;
	}
	public void set参会形式(String 参会形式) {
		this.参会形式 = 参会形式;
	}
	public String get分会报告() {
		return 分会报告;
	}
	public void set分会报告(String 分会报告) {
		this.分会报告 = 分会报告;
	}
	public String get参与会议相关材料() {
		return 参与会议相关材料;
	}
	public void set参与会议相关材料(String 参与会议相关材料) {
		this.参与会议相关材料 = 参与会议相关材料;
	}
	public String get备注() {
		return 备注;
	}
	public void set备注(String 备注) {
		this.备注 = 备注;
	}
	

}
