package cn.mnsrc.scipaper.domain;

import java.util.Date;

public class SCIPaper {
	private String 序号;
	private String 姓名;
	private String 工号;
	private String 论文名称;
	private Date 发表时间;
	private String 作者;
	private String 是否是第一完成单位;
	private String 收录号;
	@Override
	public String toString() {
		return "SCIPaper [序号=" + 序号 + ", 姓名=" + 姓名 + ", 工号=" + 工号 + ", 论文名称=" + 论文名称 + ", 发表时间=" + 发表时间 + ", 作者=" + 作者
				+ ", 是否是第一完成单位=" + 是否是第一完成单位 + ", 收录号=" + 收录号 + ", 分区=" + 分区 + ", 他引次数=" + 他引次数 + ", 备注=" + 备注 + "]";
	}
	public String get序号() {
		return 序号;
	}
	public void set序号(String 序号) {
		this.序号 = 序号;
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
	public String get论文名称() {
		return 论文名称;
	}
	public void set论文名称(String 论文名称) {
		this.论文名称 = 论文名称;
	}
	public Date get发表时间() {
		return 发表时间;
	}
	public void set发表时间(Date 发表时间) {
		this.发表时间 = 发表时间;
	}
	public String get作者() {
		return 作者;
	}
	public void set作者(String 作者) {
		this.作者 = 作者;
	}
	public String get是否是第一完成单位() {
		return 是否是第一完成单位;
	}
	public void set是否是第一完成单位(String 是否是第一完成单位) {
		this.是否是第一完成单位 = 是否是第一完成单位;
	}
	public String get收录号() {
		return 收录号;
	}
	public void set收录号(String 收录号) {
		this.收录号 = 收录号;
	}
	public String get分区() {
		return 分区;
	}
	public void set分区(String 分区) {
		this.分区 = 分区;
	}
	public String get他引次数() {
		return 他引次数;
	}
	public void set他引次数(String 他引次数) {
		this.他引次数 = 他引次数;
	}
	public String get备注() {
		return 备注;
	}
	public void set备注(String 备注) {
		this.备注 = 备注;
	}
	private String 分区;
	private String 他引次数;
	private String 备注;
	
}
