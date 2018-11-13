package cn.itcast.usermng.web.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

import cn.itcast.usermng.dao.TeacherDao;
import cn.mnsrc.researchproject.dao.ResearchProjectDao;
import cn.mnsrc.researchproject.domain.ResearchProject;

public class TeacherExportServlet extends HttpServlet {
	private TeacherDao teacherDao = new TeacherDao();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("octets/stream");
		String excelname = "教师基本信息表";
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(excelname.getBytes("gb2312"), "ISO8859-1") + ".xls");
		String[] headers = new String[] { "姓名", "工号", "性别", "出生年月", "政治面貌", "民族", "籍贯", "身份证号", "密码", "学历", "参加工作时间",
				"职称", "婚姻状态", "联系方式", "电子邮箱", "家庭住址" };
		OutputStream out = response.getOutputStream();
		List<Map<String, Object>> list = teacherDao.findAll();
		/* System.out.println(list); */
		exportExcel(excelname, headers, list, out, "yyyy-MM-dd");
		out.close();
		System.out.println("excel导出成功！");

	}

	private void exportExcel(String excelname, String[] headers, List<Map<String, Object>> list, OutputStream out,
			String string) {
		// 声明一个工作簿
		HSSFWorkbook workbook = new HSSFWorkbook();
		// 生成一个表格
		HSSFSheet sheet = workbook.createSheet();
		// 设置表格默认列宽度为15个字符
		sheet.setDefaultColumnWidth(20);
		// 生成一个样式，用来设置标题样式
		HSSFCellStyle style = workbook.createCellStyle();
		// 设置这些样式
		style.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		// 生成一个字体
		HSSFFont font = workbook.createFont();
		font.setColor(HSSFColor.VIOLET.index);
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		// 把字体应用到当前的样式
		style.setFont(font);
		// 生成并设置另一个样式,用于设置内容样式
		HSSFCellStyle style2 = workbook.createCellStyle();
		style2.setFillForegroundColor(HSSFColor.LIGHT_YELLOW.index);
		style2.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
		style2.setBorderTop(HSSFCellStyle.BORDER_THIN);
		style2.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		style2.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		// 生成另一个字体
		HSSFFont font2 = workbook.createFont();
		font2.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
		// 把字体应用到当前的样式
		style2.setFont(font2);
		// 产生表格标题行
		HSSFRow row = sheet.createRow(0);
		for (int i = 0; i < headers.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellStyle(style);
			HSSFRichTextString text = new HSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map = (Map<String, Object>) list.get(i);
			row = sheet.createRow(i + 1);
			int j = 0;
			Object value = null;
			
			value = map.get("姓名");
			if (value == null) {
				row.createCell(j++).setCellValue("");
			} else {
				row.createCell(j++).setCellValue(value.toString());
			}
			value = map.get("工号");
			if (value == null) {
				row.createCell(j++).setCellValue("");
			} else {
				row.createCell(j++).setCellValue(value.toString());
			}
			value = map.get("性别");
			if (value == null) {
				row.createCell(j++).setCellValue("");
			} else {
				row.createCell(j++).setCellValue(value.toString());
			}
			value = map.get("出生年月");
			if (value == null) {
				row.createCell(j++).setCellValue("");
			} else {
				row.createCell(j++).setCellValue(value.toString());
			}
			value = map.get("政治面貌");
			if (value == null) {
				row.createCell(j++).setCellValue("");
			} else {
				row.createCell(j++).setCellValue(value.toString());
			}
			value = map.get("民族");
			if (value == null) {
				row.createCell(j++).setCellValue("");
			} else {
				row.createCell(j++).setCellValue(value.toString());
			}
			value = map.get("籍贯");
			if (value == null) {
				row.createCell(j++).setCellValue("");
			} else {
				row.createCell(j++).setCellValue(value.toString());
			}
			value = map.get("身份证号");
			if (value == null) {
				row.createCell(j++).setCellValue("");
			} else {
				row.createCell(j++).setCellValue(value.toString());
			}
			value = map.get("密码");
			if (value == null) {
				row.createCell(j++).setCellValue("");
			} else {
				row.createCell(j++).setCellValue(value.toString());
			}
			value = map.get("学历");
			if (value == null) {
				row.createCell(j++).setCellValue("");
			} else {
				row.createCell(j++).setCellValue(value.toString());
			}
			value = map.get("参加工作时间");
			if (value == null) {
				row.createCell(j++).setCellValue("");
			} else {
				row.createCell(j++).setCellValue(value.toString());
			}
			value = map.get("职称");
			if (value == null) {
				row.createCell(j++).setCellValue("");
			} else {
				row.createCell(j++).setCellValue(value.toString());
			}
			value = map.get("婚姻状态");
			if (value == null) {
				row.createCell(j++).setCellValue("");
			} else {
				row.createCell(j++).setCellValue(value.toString());
			}
			value = map.get("联系方式");
			if (value == null) {
				row.createCell(j++).setCellValue("");
			} else {
				row.createCell(j++).setCellValue(value.toString());
			}
			value = map.get("电子邮箱");
			if (value == null) {
				row.createCell(j++).setCellValue("");
			} else {
				row.createCell(j++).setCellValue(value.toString());
			}
			value = map.get("家庭住址");
			if (value == null) {
				row.createCell(j++).setCellValue("");
			} else {
				row.createCell(j++).setCellValue(value.toString());
			}
			 

			/*value = map.get("姓名");
			if (value instanceof Integer) {
				row.createCell(j++).setCellValue(String.valueOf(value));
			}
			value = map.get("工号");
			if (value instanceof Integer) {
				row.createCell(j++).setCellValue(String.valueOf(value));
			}
			value = map.get("性别");
			if (value instanceof Integer) {
				row.createCell(j++).setCellValue(String.valueOf(value));
			}
			value = map.get("出生年月");
			if (value instanceof Integer) {
				row.createCell(j++).setCellValue(String.valueOf(value));
			}
			value = map.get("政治面貌");
			if (value instanceof Integer) {
				row.createCell(j++).setCellValue(String.valueOf(value));
			}
			value = map.get("民族");
			if (value instanceof Integer) {
				row.createCell(j++).setCellValue(String.valueOf(value));
			}
			value = map.get("籍贯");
			if (value instanceof Integer) {
				row.createCell(j++).setCellValue(String.valueOf(value));
			}
			value = map.get("身份证号");
			if (value instanceof Integer) {
				row.createCell(j++).setCellValue(String.valueOf(value));
			}
			value = map.get("密码");
			if (value instanceof Integer) {
				row.createCell(j++).setCellValue(String.valueOf(value));
			}
			value = map.get("学历");
			if (value instanceof Integer) {
				row.createCell(j++).setCellValue(String.valueOf(value));
			}
			value = map.get("参加工作时间");
			if (value instanceof Integer) {
				row.createCell(j++).setCellValue(String.valueOf(value));
			}
			value = map.get("职称");
			if (value instanceof Integer) {
				row.createCell(j++).setCellValue(String.valueOf(value));
			}
			value = map.get("婚姻状态");
			if (value instanceof Integer) {
				row.createCell(j++).setCellValue(String.valueOf(value));
			}
			value = map.get("联系方式");
			if (value instanceof Integer) {
				row.createCell(j++).setCellValue(String.valueOf(value));
			}
			value = map.get("电子邮箱");
			if (value instanceof Integer) {
				row.createCell(j++).setCellValue(String.valueOf(value));
			}
			value = map.get("家庭住址");
			if (value instanceof Integer) {
				row.createCell(j++).setCellValue(String.valueOf(value));
			}*/

			/*
			 * row.createCell(j++).setCellValue(map.get("姓名").toString());
			 * row.createCell(j++).setCellValue(map.get("工号").toString()); value
			 * = map.get("性别"); if (value instanceof Integer) {
			 * row.createCell(j++).setCellValue(String.valueOf(value)); } value
			 * = map.get("出生年月"); if(value == null){
			 * row.createCell(j++).setCellValue(""); }else{
			 * row.createCell(j++).setCellValue(value.toString()); }
			 * row.createCell(j++).setCellValue(map.get("出生年月").toString());
			 * row.createCell(j++).setCellValue(map.get("政治面貌").toString());
			 * row.createCell(j++).setCellValue(map.get("民族").toString());
			 * row.createCell(j++).setCellValue(map.get("籍贯").toString());
			 * row.createCell(j++).setCellValue(map.get("身份证号").toString());
			 * row.createCell(j++).setCellValue(map.get("密码").toString()); value
			 * = map.get("学历"); if(value == null){
			 * row.createCell(j++).setCellValue("1"); }else{
			 * row.createCell(j++).setCellValue(map.get("学历").toString()); }
			 * row.createCell(j++).setCellValue(map.get("学历").toString());
			 * row.createCell(j++).setCellValue(map.get("参加工作时间").toString());
			 * row.createCell(j++).setCellValue(map.get("职称").toString());
			 * row.createCell(j++).setCellValue(map.get("婚姻状态").toString());
			 * value = map.get("婚姻状态"); if(value == null){
			 * row.createCell(j++).setCellValue(""); }else{
			 * row.createCell(j++).setCellValue(value.toString()); }
			 * row.createCell(j++).setCellValue(map.get("联系方式").toString());
			 * value = map.get("电子邮箱"); if(value == null){
			 * row.createCell(j++).setCellValue(""); }else{
			 * row.createCell(j++).setCellValue(value.toString()); }
			 * row.createCell(j++).setCellValue(map.get("电子邮箱").toString());
			 * row.createCell(j++).setCellValue(map.get("家庭住址").toString()); }
			 */
			/*
			 * for (int i = 0; i < list.size(); i++) { Map<String, Object> map =
			 * (Map<String, Object>) list.get(i); row = sheet.createRow(i + 1);
			 * int j = 0; Object value = null; value = map.get("number"); if
			 * (value instanceof Integer) {
			 * row.createCell(j++).setCellValue(String.valueOf(value)); }
			 * row.createCell(j++).setCellValue(map.get("name").toString());
			 * value = map.get("age"); if (value instanceof Integer) {
			 * row.createCell(j++).setCellValue(String.valueOf(value)); }
			 * row.createCell(j++).setCellValue("0".equals(map.get("sex").
			 * toString()) ? "女" : "男"); }
			 */
		}

		try {
			workbook.write(out);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	/**
	 * 
	 * @Description: 模拟从数据库中查询出来的数据，一般是数据表中的几列
	 */
	public List<Map<String, Object>> getList() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < 100; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("number", 1000 + i);
			map.put("name", "张三" + i);
			int age = (int) (Math.random() * 100);
			do {
				age = (int) (Math.random() * 100);
			} while (age < 10 || age > 15);
			map.put("age", age);
			map.put("sex", age % 2 == 0 ? 0 : 1);
			list.add(map);
		}
		return list;
	}
	/**
	 * 
	 * @Description: 生成excel并导出到客户端（本地）
	 */

}
