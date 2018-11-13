package cn.mnsrc.researchproject.domain;

import java.util.Date;

public class ResearchProject {
	private int 项目序号;
	private String 姓名;
	private String 工号;
	private String 参与人;
	private String 项目来源;
	private String 项目来源1;
	private String 项目来源2;
	public String get项目来源1() {
		return 项目来源1;
	}
	public void set项目来源1(String 项目来源1) {
		this.项目来源1 = 项目来源1;
	}
	public String get项目来源2() {
		return 项目来源2;
	}
	public void set项目来源2(String 项目来源2) {
		this.项目来源2 = 项目来源2;
	}
	private String 项目编号;
	private String 项目名称;
	private Date 起始时间;
	private Date 结束时间;
	private float 合同经费;
	private float 进账总经费;
	private String 备注;
	public int get项目序号() {
		return 项目序号;
	}
	public void set项目序号(int 项目序号) {
		this.项目序号 = 项目序号;
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
	public String get项目来源() {
		return 项目来源;
	}
	public void set项目来源(String 项目来源) {
		this.项目来源 = 项目来源;
	}
	public String get项目编号() {
		return 项目编号;
	}
	public void set项目编号(String 项目编号) {
		this.项目编号 = 项目编号;
	}
	public String get项目名称() {
		return 项目名称;
	}
	public void set项目名称(String 项目名称) {
		this.项目名称 = 项目名称;
	}
	public Date get起始时间() {
		return 起始时间;
	}
	public void set起始时间(Date 起始时间) {
		this.起始时间 = 起始时间;
	}
	public Date get结束时间() {
		return 结束时间;
	}
	public void set结束时间(Date 结束时间) {
		this.结束时间 = 结束时间;
	}
	public float get合同经费() {
		return 合同经费;
	}
	public void set合同经费(float 合同经费) {
		this.合同经费 = 合同经费;
	}
	public float get进账总经费() {
		return 进账总经费;
	}
	public void set进账总经费(float 进账总经费) {
		this.进账总经费 = 进账总经费;
	}
	public String get备注() {
		return 备注;
	}
	public void set备注(String 备注) {
		this.备注 = 备注;
	}
	@Override
	public String toString() {
		return "ResearchProject [项目序号=" + 项目序号 + ", 姓名=" + 姓名 + ", 工号=" + 工号 + ", 参与人=" + 参与人 + ", 项目来源=" + 项目来源
				+ ", 项目编号=" + 项目编号 + ", 项目名称=" + 项目名称 + ", 起始时间=" + 起始时间 + ", 结束时间=" + 结束时间 + ", 合同经费=" + 合同经费
				+ ", 进账总经费=" + 进账总经费 + ", 备注=" + 备注 + "]";
	}
	

	

}
