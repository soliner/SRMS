package cn.mnsrc.monograph.domain;

public class Monograph {
	private String id;
	private String 姓名;
	private String 工号;
	private String 时间;
	private String 著作名称;
	private String 作者;
	private String 出版社;
	private String 著作总字数;
	private String 撰写字数;
	private String 著作类别;
	private String 备注;
	@Override
	public String toString() {
		return "Monograph [id=" + id + ", 姓名=" + 姓名 + ", 工号=" + 工号 + ", 时间=" + 时间 + ", 著作名称=" + 著作名称 + ", 作者=" + 作者
				+ ", 出版社=" + 出版社 + ", 著作总字数=" + 著作总字数 + ", 撰写字数=" + 撰写字数 + ", 著作类别=" + 著作类别 + ", 备注=" + 备注 + "]";
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
	public String get时间() {
		return 时间;
	}
	public void set时间(String 时间) {
		this.时间 = 时间;
	}
	public String get著作名称() {
		return 著作名称;
	}
	public void set著作名称(String 著作名称) {
		this.著作名称 = 著作名称;
	}
	public String get作者() {
		return 作者;
	}
	public void set作者(String 作者) {
		this.作者 = 作者;
	}
	public String get出版社() {
		return 出版社;
	}
	public void set出版社(String 出版社) {
		this.出版社 = 出版社;
	}
	public String get著作总字数() {
		return 著作总字数;
	}
	public void set著作总字数(String 著作总字数) {
		this.著作总字数 = 著作总字数;
	}
	public String get撰写字数() {
		return 撰写字数;
	}
	public void set撰写字数(String 撰写字数) {
		this.撰写字数 = 撰写字数;
	}
	public String get著作类别() {
		return 著作类别;
	}
	public void set著作类别(String 著作类别) {
		this.著作类别 = 著作类别;
	}
	public String get备注() {
		return 备注;
	}
	public void set备注(String 备注) {
		this.备注 = 备注;
	}

}
