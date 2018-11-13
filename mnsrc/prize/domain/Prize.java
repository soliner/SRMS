package cn.mnsrc.prize.domain;

public class Prize {
	private String id;
	private String 获奖名称;
	private String 姓名;
	private String 工号;
	private String 颁奖单位;
	private String 获奖级别;
	private String 获奖时间;
	private String 剩余获奖人;
	private String 备注;
	@Override
	public String toString() {
		return "Prize [id=" + id + ", 获奖名称=" + 获奖名称 + ", 姓名=" + 姓名 + ", 工号=" + 工号 + ", 颁奖单位=" + 颁奖单位 + ", 获奖级别=" + 获奖级别
				+ ", 获奖时间=" + 获奖时间 + ", 剩余获奖人=" + 剩余获奖人 + ", 备注=" + 备注 + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String get获奖名称() {
		return 获奖名称;
	}
	public void set获奖名称(String 获奖名称) {
		this.获奖名称 = 获奖名称;
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
	public String get颁奖单位() {
		return 颁奖单位;
	}
	public void set颁奖单位(String 颁奖单位) {
		this.颁奖单位 = 颁奖单位;
	}
	public String get获奖级别() {
		return 获奖级别;
	}
	public void set获奖级别(String 获奖级别) {
		this.获奖级别 = 获奖级别;
	}
	public String get获奖时间() {
		return 获奖时间;
	}
	public void set获奖时间(String 获奖时间) {
		this.获奖时间 = 获奖时间;
	}
	public String get剩余获奖人() {
		return 剩余获奖人;
	}
	public void set剩余获奖人(String 剩余获奖人) {
		this.剩余获奖人 = 剩余获奖人;
	}
	public String get备注() {
		return 备注;
	}
	public void set备注(String 备注) {
		this.备注 = 备注;
	}

}
