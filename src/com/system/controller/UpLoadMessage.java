package com.system.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


@WebServlet("/UpLoadMessage")
public class UpLoadMessage extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;
    
    private static final String UPLOAD_DIRECTORY = "upload";
 
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB
 

	protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        if (!ServletFileUpload.isMultipartContent(request)) {
            PrintWriter writer = response.getWriter();
            writer.println("Error: 表单必须包含 enctype=multipart/form-data");
            writer.flush();
            return;
        }
        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
 
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(MAX_FILE_SIZE);
         
        upload.setSizeMax(MAX_REQUEST_SIZE);
        upload.setHeaderEncoding("UTF-8"); 

        String uploadPath = getServletContext().getRealPath("/") + File.separator + UPLOAD_DIRECTORY;
       
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        String file_path=null;
        try {
            List<FileItem> formItems = upload.parseRequest(request);
 
            if (formItems != null && formItems.size() > 0) {
                for (FileItem item : formItems) {
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
                        System.out.println(filePath);
                        file_path = filePath;
                        item.write(storeFile);
                        request.setAttribute("message",
                            "文件上传成功!");
                    }
                }
            }
        } catch (Exception ex) {
            request.setAttribute("message",
                    "错误信息: " + ex.getMessage());
        }
        List<List<String>> data = readExcel(file_path);
        if(data.get(0).size() == 9) {
        	for (List<String> student : data) {
        		String username = student.get(1);
        		Integer userid = Integer.parseInt(student.get(0));
        		String sex = student.get(2);
        		String birthyear = student.get(3);
        		String college = student.get(4);
        		String gradeyear = student.get(5);
        		String stu_class = student.get(6);
        		String account = student.get(7);
        		String passwd = student.get(8);
        		try {
        			List<Object> ls = new ArrayList<>();
        			ls.add(userid);
        			ls.add(username);
        			ls.add(sex);
        			ls.add(birthyear);
        			ls.add(gradeyear);
        			ls.add(college);
        			ls.add(stu_class);
        			ls.add(account);
        			ls.add(passwd);
					add("student",ls);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
        }else if(data.get(0).size() == 12) {
        	for (List<String> course : data) {
				String crs_code = course.get(1);
				String crs_name = course.get(2);
				String crs_attribute = course.get(3);
				Integer crs_credit = Integer.parseInt(course.get(4));
				String crs_semester = course.get(5);
				String crs_time = course.get(6);
				String crs_frequency = course.get(7);
				String crs_class = course.get(8);
				String crs_teacher = course.get(9);
				String crs_address = course.get(10);
				String crs_num = course.get(11);
				List<Object> ls = new ArrayList<>();
				ls.add(crs_code);
				ls.add(crs_name);
				ls.add(crs_attribute);
				ls.add(crs_credit);
				ls.add(crs_semester);
				ls.add(crs_time);
				ls.add(crs_frequency);
				ls.add(crs_class);
				ls.add(crs_teacher);
				ls.add(crs_address);
				ls.add(crs_num);
				try {
					add("course",ls);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
        }
        getServletContext().getRequestDispatcher("/admin/uploadMessage").forward(
                request, response);
    }
    
	public static final String URL = "jdbc:mysql://localhost:3306/examination_system_2019801";
    public static final String USER = "root";
    public static final String PASSWORD = "qazPLM123";
	public void add(String log,List<Object> data) throws Exception {
    	Class.forName("com.mysql.jdbc.Driver");
    	Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
    	String sql = null;
    	if(log.equals("student")) {
        	sql ="insert into student values(?,?,?,?,?,?,?,?,?)";
        	PreparedStatement ptmt = conn.prepareStatement(sql);
        	ptmt.setInt(1, Integer.parseInt(data.get(0).toString()));
        	ptmt.setString(2, data.get(1).toString());
        	ptmt.setString(3, data.get(2).toString());
        	ptmt.setString(4, data.get(3).toString());
        	ptmt.setString(5, data.get(4).toString());
        	ptmt.setString(6, data.get(5).toString());
        	ptmt.setString(7, data.get(6).toString());
        	ptmt.setString(8, data.get(7).toString());
        	ptmt.setString(9, data.get(8).toString());
        	ptmt.execute();
    	}else if(log.equals("course")) {
    		sql = "insert into course(crs_code,crs_name,crs_attribute,crs_credit,crs_semester,crs_time,crs_frequency,crs_class,crs_teacher,crs_address) values(?,?,?,?,?,?,?,?,?,?,?)";
        	PreparedStatement ptmt = conn.prepareStatement(sql);
        	ptmt.setString(2, data.get(1).toString());
        	ptmt.setString(3, data.get(2).toString());
        	ptmt.setString(4, data.get(3).toString());
        	ptmt.setInt(5, Integer.parseInt(data.get(4).toString()));
        	ptmt.setString(6, data.get(5).toString());
        	ptmt.setString(7, data.get(6).toString());
        	ptmt.setString(8, data.get(7).toString());
        	ptmt.setString(9, data.get(8).toString());
        	ptmt.setString(10, data.get(9).toString());
        	ptmt.setString(11, data.get(10).toString());
        	ptmt.setInt(12, Integer.parseInt(data.get(11).toString()));
        	ptmt.execute();
    	}
	}
	
    @SuppressWarnings({ "deprecation", "resource" })
	public static List<List<String>> readExcel(String path) {
        String fileType = path.substring(path.lastIndexOf(".") + 1);
        List<List<String>> lists = new ArrayList<List<String>>();
        InputStream is = null;
        try {
            is = new FileInputStream(path);
            Workbook wb = null;
            if (fileType.equals("xls")) {
                wb = new HSSFWorkbook(is);
            } else if (fileType.equals("xlsx")) {
                wb = new XSSFWorkbook(is);
            } else {
                return null;
            }

            Sheet sheet = wb.getSheetAt(0);
            for (Row row : sheet) {
            	if(row.getCell(0).getStringCellValue().equals("学号")) {
            		continue;
            	}
                ArrayList<String> list = new ArrayList<String>();
                for (Cell cell : row) {
                    cell.setCellType(CellType.STRING);
                    list.add(cell.getStringCellValue());
                }
                lists.add(list);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return lists;
    }
}
