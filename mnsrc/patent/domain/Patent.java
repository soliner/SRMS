package cn.mnsrc.patent.domain;

public class Patent {
	private String id;
	private String 姓名;
	private String 工号;
	private String 时间;
	private String 专利名称;
	private String 专利类别;
	private String 专利授权号;
	private String 专利发放单位名称;
	private String 备注;
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
	public String get时间() {
		return 时间;
	}
	public void set时间(String 时间) {
		this.时间 = 时间;
	}
	public String get专利名称() {
		return 专利名称;
	}
	public void set专利名称(String 专利名称) {
		this.专利名称 = 专利名称;
	}
	public String get专利类别() {
		return 专利类别;
	}
	public void set专利类别(String 专利类别) {
		this.专利类别 = 专利类别;
	}
	public String get专利授权号() {
		return 专利授权号;
	}
	public void set专利授权号(String 专利授权号) {
		this.专利授权号 = 专利授权号;
	}
	public String get专利发放单位名称() {
		return 专利发放单位名称;
	}
	public void set专利发放单位名称(String 专利发放单位名称) {
		this.专利发放单位名称 = 专利发放单位名称;
	}
	public String get备注() {
		return 备注;
	}
	public void set备注(String 备注) {
		this.备注 = 备注;
	}
	@Override
	public String toString() {
		return "Patent [id=" + id + ", 姓名=" + 姓名 + ", 工号=" + 工号 + ", 时间=" + 时间 + ", 专利名称=" + 专利名称 + ", 专利类别=" + 专利类别
				+ ", 专利授权号=" + 专利授权号 + ", 专利发放单位名称=" + 专利发放单位名称 + ", 备注=" + 备注 + "]";
	}
	

}
