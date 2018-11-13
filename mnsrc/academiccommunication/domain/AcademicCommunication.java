package cn.mnsrc.academiccommunication.domain;

import java.util.Date;

public class AcademicCommunication {
	private String 访问人;
	private Date 时间;
	private String 地点;
	private String 经费来源;
	private String 访问任务;
	private String 备注;
	@Override
	public String toString() {
		return "AcademicCommunication [访问人=" + 访问人 + ", 时间=" + 时间 + ", 地点=" + 地点 + ", 经费来源=" + 经费来源 + ", 访问任务=" + 访问任务
				+ ", 备注=" + 备注 + "]";
	}
	public String get访问人() {
		return 访问人;
	}
	public void set访问人(String 访问人) {
		this.访问人 = 访问人;
	}
	public Date get时间() {
		return 时间;
	}
	public void set时间(Date 时间) {
		this.时间 = 时间;
	}
	public String get地点() {
		return 地点;
	}
	public void set地点(String 地点) {
		this.地点 = 地点;
	}
	public String get经费来源() {
		return 经费来源;
	}
	public void set经费来源(String 经费来源) {
		this.经费来源 = 经费来源;
	}
	public String get访问任务() {
		return 访问任务;
	}
	public void set访问任务(String 访问任务) {
		this.访问任务 = 访问任务;
	}
	public String get备注() {
		return 备注;
	}
	public void set备注(String 备注) {
		this.备注 = 备注;
	}
	
}
