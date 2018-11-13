package cn.itcast.usermng.domain;

import java.util.Date;

public class Teacher {
	private String 姓名;
	private String 工号;
	private String 性别;
	private Date 出生年月;
	private String 政治面貌;
	private String 民族;
	private String 籍贯;
	private String 身份证号;
	private String 密码;
	private String 学历;
	private Date 参加工作时间;
	private String 职称;
	private String 婚姻状态;
	private String 联系方式;
	private String 电子邮箱;
	private String 家庭住址;
	private String 总共登录次数;
	private boolean 管理员;
	@Override
	public String toString() {
		return "Teacher [姓名=" + 姓名 + ", 工号=" + 工号 + ", 性别=" + 性别 + ", 出生年月=" + 出生年月 + ", 政治面貌=" + 政治面貌 + ", 民族=" + 民族
				+ ", 籍贯=" + 籍贯 + ", 身份证号=" + 身份证号 + ", 密码=" + 密码 + ", 学历=" + 学历 + ", 参加工作时间=" + 参加工作时间 + ", 职称=" + 职称
				+ ", 婚姻状态=" + 婚姻状态 + ", 联系方式=" + 联系方式 + ", 电子邮箱=" + 电子邮箱 + ", 家庭住址=" + 家庭住址 + ", 总共登录次数=" + 总共登录次数
				+ ", 管理员=" + 管理员 + "]";
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
	public String get性别() {
		return 性别;
	}
	public void set性别(String 性别) {
		this.性别 = 性别;
	}
	public Date get出生年月() {
		return 出生年月;
	}
	public void set出生年月(Date 出生年月) {
		this.出生年月 = 出生年月;
	}
	public String get政治面貌() {
		return 政治面貌;
	}
	public void set政治面貌(String 政治面貌) {
		this.政治面貌 = 政治面貌;
	}
	public String get民族() {
		return 民族;
	}
	public void set民族(String 民族) {
		this.民族 = 民族;
	}
	public String get籍贯() {
		return 籍贯;
	}
	public void set籍贯(String 籍贯) {
		this.籍贯 = 籍贯;
	}
	public String get身份证号() {
		return 身份证号;
	}
	public void set身份证号(String 身份证号) {
		this.身份证号 = 身份证号;
	}
	public String get密码() {
		return 密码;
	}
	public void set密码(String 密码) {
		this.密码 = 密码;
	}
	public String get学历() {
		return 学历;
	}
	public void set学历(String 学历) {
		this.学历 = 学历;
	}
	public Date get参加工作时间() {
		return 参加工作时间;
	}
	public void set参加工作时间(Date 参加工作时间) {
		this.参加工作时间 = 参加工作时间;
	}
	public String get职称() {
		return 职称;
	}
	public void set职称(String 职称) {
		this.职称 = 职称;
	}
	public String get婚姻状态() {
		return 婚姻状态;
	}
	public void set婚姻状态(String 婚姻状态) {
		this.婚姻状态 = 婚姻状态;
	}
	public String get联系方式() {
		return 联系方式;
	}
	public void set联系方式(String 联系方式) {
		this.联系方式 = 联系方式;
	}
	public String get电子邮箱() {
		return 电子邮箱;
	}
	public void set电子邮箱(String 电子邮箱) {
		this.电子邮箱 = 电子邮箱;
	}
	public String get家庭住址() {
		return 家庭住址;
	}
	public void set家庭住址(String 家庭住址) {
		this.家庭住址 = 家庭住址;
	}
	public String get总共登录次数() {
		return 总共登录次数;
	}
	public void set总共登录次数(String 总共登录次数) {
		this.总共登录次数 = 总共登录次数;
	}
	public boolean is管理员() {
		return 管理员;
	}
	public void set管理员(boolean 管理员) {
		this.管理员 = 管理员;
	}
	

}
