package com.system.poi;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

public class DownLoadMessage<T> {
	
	private String[] headers;
	
	private HttpServletResponse response;
	
	private List<T> message;
	
	public DownLoadMessage(String[] headers,List<T> message,HttpServletResponse response){
		this.headers = headers;
		this.response = response;
		this.message = message;
	}
	
	@SuppressWarnings("unchecked")
	public void download() throws IOException {
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet();
		sheet.setDefaultColumnWidth((short)headers.length);
		HSSFRow row = sheet.createRow(0);
		for(int i=0; i<headers.length; i++) {
			HSSFCell cell = row.createCell(i);
			HSSFRichTextString text = new HSSFRichTextString(headers[i]);
			cell.setCellValue(text);
		}
		Iterator<T> it = message.iterator();
		int index = 0;
		while(it.hasNext()) {
			index++;
			row = sheet.createRow(index);
			T items = it.next();
			//获取所有声明字段。
			Field[] fields = items.getClass().getDeclaredFields();
			for(short i=0; i < fields.length; i++) {
				HSSFCell cell = row.createCell(i);
				Field field = fields[i];
				String fieldName = field.getName();
				String getMethodName = "get" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
				try {
					@SuppressWarnings("rawtypes")
					Class it_Class = items.getClass();
					Method getMethod = it_Class.getMethod(getMethodName, new Class[] {});
					Object value = getMethod.invoke(items, new Object[] {});
					String textValue = value.toString();
					HSSFRichTextString richString = new HSSFRichTextString(textValue);
					HSSFFont font3 = workbook.createFont();
					font3.setColor(HSSFColor.HSSFColorPredefined.BLUE.getIndex());
					richString.applyFont(font3);
					cell.setCellValue(richString);
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		response.setContentType("application/octet-stream");
		response.setHeader("Content-disposition", "attachment;filename=StudentList"+(new Date()).toString()+".xls");
		response.flushBuffer();
		workbook.write(response.getOutputStream());
		workbook.close();
		
	}
}
