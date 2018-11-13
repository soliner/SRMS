package cn.mnsrc.studentcontest.domain;

public class StudentContest {
	private String id;
	private String 姓名;
	private String 学号;
	private String 时间;
	private String 参加竞赛名称;
	private String 获奖级别;
	private String 全部获奖人;
	private String 备注;
	@Override
	public String toString() {
		return "StudentContest [id=" + id + ", 姓名=" + 姓名 + ", 学号=" + 学号 + ", 时间=" + 时间 + ", 参见竞赛名称=" + 参加竞赛名称
				+ ", 获奖级别=" + 获奖级别 + ", 全部获奖人=" + 全部获奖人 + ", 备注=" + 备注 + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String get姓名() {
		return 姓名;
	}
	public void set姓名(String 姓名) {
		this.姓名 = 姓名;
	}
	public String get学号() {
		return 学号;
	}
	public void set学号(String 学号) {
		this.学号 = 学号;
	}
	public String get时间() {
		return 时间;
	}
	public void set时间(String 时间) {
		this.时间 = 时间;
	}
	public String get参加竞赛名称() {
		return 参加竞赛名称;
	}
	public void set参见竞赛名称(String 参加竞赛名称) {
		this.参加竞赛名称 = 参加竞赛名称;
	}
	public String get获奖级别() {
		return 获奖级别;
	}
	public void set获奖级别(String 获奖级别) {
		this.获奖级别 = 获奖级别;
	}
	public String get全部获奖人() {
		return 全部获奖人;
	}
	public void set全部获奖人(String 全部获奖人) {
		this.全部获奖人 = 全部获奖人;
	}
	public String get备注() {
		return 备注;
	}
	public void set备注(String 备注) {
		this.备注 = 备注;
	}

}
