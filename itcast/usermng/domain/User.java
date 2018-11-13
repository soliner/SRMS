package cn.itcast.usermng.domain;

import java.sql.Date;

/**
 * 领域对象 对应数据库和表单页面
 * 
 * @author cxf
 * 
 */
public class User {
	/*
	 * 对应数据库
	 */
	private String username;
	private String password;
	private int age;
	private String gender;
	
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
	private String 婚姻状况;
	private int 联系方式;
	private String 电子邮箱;
	private int 总共登录次数;
	private String 管理员;
	
	/*
	 * 对应表单
	 * * 登录：用户名和密码
	 * * 注册：用户名、密码、确认密码、年龄、性别、验证码
	 */
	private String repassword;//确认密码
	private String verifyCode;//验证码

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getVerifyCode() {
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", age=" + age + ", gender=" + gender + ", 姓名="
				+ 姓名 + ", 工号=" + 工号 + ", 性别=" + 性别 + ", 出生年月=" + 出生年月 + ", 政治面貌=" + 政治面貌 + ", 民族=" + 民族 + ", 籍贯=" + 籍贯
				+ ", 身份证号=" + 身份证号 + ", 密码=" + 密码 + ", 学历=" + 学历 + ", 参加工作时间=" + 参加工作时间 + ", 职称=" + 职称 + ", 婚姻状况="
				+ 婚姻状况 + ", 联系方式=" + 联系方式 + ", 电子邮箱=" + 电子邮箱 + ", 总共登录次数=" + 总共登录次数 + ", 管理员=" + 管理员 + ", repassword="
				+ repassword + ", verifyCode=" + verifyCode + "]";
	}

	public String get姓名() {
		return 姓名;
	}

	public void set姓名(String 姓名) {
		this.姓名 = 姓名;
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

	public String get婚姻状况() {
		return 婚姻状况;
	}

	public void set婚姻状况(String 婚姻状况) {
		this.婚姻状况 = 婚姻状况;
	}

	public int get联系方式() {
		return 联系方式;
	}

	public void set联系方式(int 联系方式) {
		this.联系方式 = 联系方式;
	}

	public String get电子邮箱() {
		return 电子邮箱;
	}

	public void set电子邮箱(String 电子邮箱) {
		this.电子邮箱 = 电子邮箱;
	}

	public int get总共登录次数() {
		return 总共登录次数;
	}

	public void set总共登录次数(int 总共登录次数) {
		this.总共登录次数 = 总共登录次数;
	}

	public String get管理员() {
		return 管理员;
	}

	public void set管理员(String 管理员) {
		this.管理员 = 管理员;
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

	public String get性别() {
		return 性别;
	}

	public void set性别(String 性别) {
		this.性别 = 性别;
	}

	public String get工号() {
		return 工号;
	}

	public void set工号(String 工号) {
		this.工号 = 工号;
	}
}
