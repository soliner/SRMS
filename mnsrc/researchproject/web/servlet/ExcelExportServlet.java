package cn.mnsrc.researchproject.web.servlet;

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

import cn.mnsrc.researchproject.dao.ResearchProjectDao;
import cn.mnsrc.researchproject.domain.ResearchProject;

public class ExcelExportServlet extends HttpServlet {
	private ResearchProjectDao researchProjectDao = new ResearchProjectDao();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("octets/stream");
		String excelname = "科研项目统计表";
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(excelname.getBytes("gb2312"), "ISO8859-1") + ".xls");
		
		/*Object[] headers =  researchProjectDao.exportExcel().toArray();
		System.out.println(headers);*/
		String[] headers = new String[] {  "项目序号", "姓名", "工号", "参与人", "项目来源", "项目编号", 
								"项目名称", "起始时间", "结束时间", "合同经费", "进账总经费", "备注"};
		OutputStream out = response.getOutputStream();
		List<Map<String, Object>> list = researchProjectDao.findAll();
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
		for(int i=0; i<list.size(); i++){
			Map<String, Object> map = (Map<String, Object>) list.get(i);
			row = sheet.createRow(i + 1);
			int j = 0;
			Object value = null;
			value = map.get("项目序号");
			if(value == null){
				row.createCell(j++).setCellValue("");
			}else{
				row.createCell(j++).setCellValue(map.get("项目序号").toString());
			}
			row.createCell(j++).setCellValue(map.get("姓名").toString());
			row.createCell(j++).setCellValue(map.get("工号").toString());
			row.createCell(j++).setCellValue(map.get("参与人").toString());
			row.createCell(j++).setCellValue(map.get("项目来源").toString());
			row.createCell(j++).setCellValue(map.get("项目编号").toString());
			row.createCell(j++).setCellValue(map.get("项目名称").toString());
			row.createCell(j++).setCellValue(map.get("起始时间").toString());
			row.createCell(j++).setCellValue(map.get("结束时间").toString());
			value = map.get("合同经费");
			/*if (value instanceof Integer) {
				row.createCell(j++).setCellValue(String.valueOf(value));
			}
			
			if (value instanceof Integer) {
				row.createCell(j++).setCellValue(String.valueOf(value));
			}*/
			if(value == null){
				row.createCell(j++).setCellValue("");
			}else{
				row.createCell(j++).setCellValue(map.get("合同经费").toString());
			}
			value = map.get("进账总经费");
			if(value == null){
				row.createCell(j++).setCellValue("");
			}else{
				row.createCell(j++).setCellValue(map.get("进账总经费").toString());
			}
			
			row.createCell(j++).setCellValue(map.get("备注").toString());
		}
		/*for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map = (Map<String, Object>) list.get(i);
			row = sheet.createRow(i + 1);
			int j = 0;
			Object value = null;
			value = map.get("number");
			if (value instanceof Integer) {
				row.createCell(j++).setCellValue(String.valueOf(value));
			}
			row.createCell(j++).setCellValue(map.get("name").toString());
			value = map.get("age");
			if (value instanceof Integer) {
				row.createCell(j++).setCellValue(String.valueOf(value));
			}
			row.createCell(j++).setCellValue("0".equals(map.get("sex").toString()) ? "女" : "男");
		}*/
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
