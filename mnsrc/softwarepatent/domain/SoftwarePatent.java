package cn.mnsrc.softwarepatent.domain;

import java.util.Date;

public class SoftwarePatent {
	private String id;
	private String 姓名;
	private String 工号;
	private Date 时间;
	private String 著作权名称;
	private String 授权号;
	private String 备注;
	@Override
	public String toString() {
		return "SoftwarePatent [id=" + id + ", 姓名=" + 姓名 + ", 工号=" + 工号 + ", 时间=" + 时间 + ", 著作权名称=" + 著作权名称 + ", 授权号="
				+ 授权号 + ", 备注=" + 备注 + "]";
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
	public String get工号() {
		return 工号;
	}
	public void set工号(String 工号) {
		this.工号 = 工号;
	}
	public Date get时间() {
		return 时间;
	}
	public void set时间(Date 时间) {
		this.时间 = 时间;
	}
	public String get著作权名称() {
		return 著作权名称;
	}
	public void set著作权名称(String 著作权名称) {
		this.著作权名称 = 著作权名称;
	}
	public String get授权号() {
		return 授权号;
	}
	public void set授权号(String 授权号) {
		this.授权号 = 授权号;
	}
	public String get备注() {
		return 备注;
	}
	public void set备注(String 备注) {
		this.备注 = 备注;
	}
	
	

}
