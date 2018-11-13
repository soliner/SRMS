package cn.mnsrc.holdacademicconference.domain;

public class HoldAcademicConference {
	private String 负责人;
	private String 举办时间;
	private String 会议名称;
	private String 会议级别;
	private String 地点;
	private String 参会人数;
	private String 承办会议相关材料;
	private String 备注;
	@Override
	public String toString() {
		return "HoldAcademicConference [负责人=" + 负责人 + ", 举办时间=" + 举办时间 + ", 会议名称=" + 会议名称 + ", 会议级别=" + 会议级别 + ", 地点="
				+ 地点 + ", 参会人数=" + 参会人数 + ", 承办会议相关材料=" + 承办会议相关材料 + ", 备注=" + 备注 + "]";
	}
	public String get负责人() {
		return 负责人;
	}
	public void set负责人(String 负责人) {
		this.负责人 = 负责人;
	}
	public String get举办时间() {
		return 举办时间;
	}
	public void set举办时间(String 举办时间) {
		this.举办时间 = 举办时间;
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
	public String get参会人数() {
		return 参会人数;
	}
	public void set参会人数(String 参会人数) {
		this.参会人数 = 参会人数;
	}
	public String get承办会议相关材料() {
		return 承办会议相关材料;
	}
	public void set承办会议相关材料(String 承办会议相关材料) {
		this.承办会议相关材料 = 承办会议相关材料;
	}
	public String get备注() {
		return 备注;
	}
	public void set备注(String 备注) {
		this.备注 = 备注;
	}

}
