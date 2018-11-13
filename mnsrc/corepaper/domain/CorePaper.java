package cn.mnsrc.corepaper.domain;

import java.util.Date;

public class CorePaper {
	private String 序号;
	private String 姓名;
	private String 工号;
	private String 是否是第一完成单位;
	private String 论文名称;
	private String 发表刊物名称;
	private String 刊号;
	private Date 发表时间;
	private String 备注;
	@Override
	public String toString() {
		return "CorePaper [序号=" + 序号 + ", 姓名=" + 姓名 + ", 工号=" + 工号 + ", 是否是第一完成单位=" + 是否是第一完成单位 + ", 论文名称=" + 论文名称
				+ ", 发表刊物名称=" + 发表刊物名称 + ", 刊号=" + 刊号 + ", 发表时间=" + 发表时间 + ", 备注=" + 备注 + "]";
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
	public String get是否是第一完成单位() {
		return 是否是第一完成单位;
	}
	public void set是否是第一完成单位(String 是否是第一完成单位) {
		this.是否是第一完成单位 = 是否是第一完成单位;
	}
	public String get论文名称() {
		return 论文名称;
	}
	public void set论文名称(String 论文名称) {
		this.论文名称 = 论文名称;
	}
	public String get发表刊物名称() {
		return 发表刊物名称;
	}
	public void set发表刊物名称(String 发表刊物名称) {
		this.发表刊物名称 = 发表刊物名称;
	}
	public String get刊号() {
		return 刊号;
	}
	public void set刊号(String 刊号) {
		this.刊号 = 刊号;
	}
	public Date get发表时间() {
		return 发表时间;
	}
	public void set发表时间(Date 发表时间) {
		this.发表时间 = 发表时间;
	}
	public String get备注() {
		return 备注;
	}
	public void set备注(String 备注) {
		this.备注 = 备注;
	}
	
	
}
