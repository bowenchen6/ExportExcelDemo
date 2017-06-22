package com.bowen.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.bowen.bean.Student;

/**
 * Servlet implementation class ExcelServlet
 */
@WebServlet("/ExcelServlet")
public class ExcelServlet extends HttpServlet {
	static int d=2000;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Student> list=new ArrayList<Student>();
		list.add(new Student(1,"aa",22,"��","���·"));
		list.add(new Student(2,"bb",22,"Ů","����·"));
		list.add(new Student(3,"cc",22,"��","�Ž��߿�"));
		list.add(new Student(4,"dd",22,"Ů","������"));
		list.add(new Student(5,"ff",22,"��","����·"));
		list.add(new Student(6,"gg",22,"Ů","����·"));
		list.add(new Student(7,"hh",22,"��","��о·"));
		list.add(new Student(8,"ss",22,"Ů","�ֵ�·"));
		// ����һ��Excel�ļ�
		Workbook  wb=new HSSFWorkbook();
		// ����һ��Excel��Sheet
		Sheet sheet =wb.createSheet();
		// �����п�
		sheet.setColumnWidth(0, 6000);
		sheet.setColumnWidth(1, 6000);
		sheet.setColumnWidth(2, 6000);
		sheet.setColumnWidth(3, 6000);
		sheet.setColumnWidth(4, 6000);
		// ���ñ�ͷ��ʽ,�����
		CellStyle  headerStyle1 =wb.createCellStyle();
		//����ˮƽ����
		headerStyle1.setAlignment(CellStyle.ALIGN_CENTER);
		Font headerFont1=wb.createFont();
		//����������ʽ
		headerFont1.setBoldweight(Font.BOLDWEIGHT_BOLD);
		headerFont1.setFontHeightInPoints((short) 18);
		headerStyle1.setFont(headerFont1);
		// ���ñ�ͷ��ʽ,С���� ����������ʽ1
		CellStyle headerStyle2 = wb.createCellStyle();
		headerStyle2.setAlignment(CellStyle.ALIGN_CENTER);
		// �����ӱ�����ʽ
		CellStyle headerStyle3 =wb.createCellStyle();
		headerStyle3.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
		headerStyle3.setAlignment(CellStyle.ALIGN_CENTER);
		Font headerFont3 =wb.createFont();
		headerFont3.setBoldweight(Font.BOLDWEIGHT_BOLD);// ����Ӵ�
		headerFont3.setFontHeightInPoints((short) 10);
		headerStyle3.setFont(headerFont3);
		// ��һ�д����ϲ�
		CellRangeAddress cra = new CellRangeAddress(0, 0, 0, 4);
		sheet.addMergedRegion(cra);
		// �ڶ���С����ϲ�
		CellRangeAddress cra1 = new CellRangeAddress(1, 1, 0, 4);
		sheet.addMergedRegion(cra1);
		// ��һ��:����� ��Ԫ��
		Row row1 = sheet.createRow(0);
		// �����и�
		row1.setHeight((short) 600);
		Cell cell_1 = row1.createCell(0);
		//���ñ���
		cell_1.setCellValue("ѧ����Ϣͳ�Ʊ���");
		cell_1.setCellStyle(headerStyle1);
		// ��2��,С����
		Row row2 = sheet.createRow(1);
		Cell cell_2 = row2.createCell(0);
		// ������ʾ����
		cell_2.setCellValue("2017���13Ӧ������Ϣ");
		cell_2.setCellStyle(headerStyle2);
		// ������,�ӱ���
		Row row3 = sheet.createRow(2);
		int totalCellIndex = 0;
		Cell cell3_1 = row3.createCell(totalCellIndex++);
		cell3_1.setCellValue("ѧ��");
		cell3_1.setCellStyle(headerStyle3);
		Cell cell3_2 = row3.createCell(totalCellIndex++);
		cell3_2.setCellValue("����");
		cell3_2.setCellStyle(headerStyle3);
		Cell cell3_3 = row3.createCell(totalCellIndex++);
		cell3_3.setCellValue("����");
		cell3_3.setCellStyle(headerStyle3);
		Cell cell3_4 = row3.createCell(totalCellIndex++);
		cell3_4.setCellValue("�Ա�");
		cell3_4.setCellStyle(headerStyle3);
		Cell cell3_5 = row3.createCell(totalCellIndex++);
		cell3_5.setCellValue("��ַ");
		cell3_5.setCellStyle(headerStyle3);
		//�Ե�Ԫ����и�ֵ����
		if(list.size()>0){
			for(int i=0;i<list.size();i++){
				int j = 0;
				//�ӵ�4�п�ʼ��ÿһ����Ԫ��ֵ����Ϊ��һ���Ǵ���⣬�ڶ�����С���⣬��������ѧ����Ϣ��
				Row row4 = sheet.createRow(i+3);
				//�ڵ����д�����һ����Ԫ�����ڴ��ѧ��
				Cell cell = row4.createCell(j++);
				cell.setCellValue(list.get(i).getId());
				cell.setCellStyle(headerStyle2);
				//�ڵ����д����ڶ�����Ԫ�����ڴ������
				Cell cell2 = row4.createCell(j++);
				cell2.setCellValue(list.get(i).getName());
				cell2.setCellStyle(headerStyle2);
				//�ڵ����д�����������Ԫ�����ڴ������
				Cell idcel3= row4.createCell(j++);
				idcel3.setCellValue(list.get(i).getAge());
				idcel3.setCellStyle(headerStyle2);
				//�ڵ����д������ĸ���Ԫ�����ڴ���Ա�
				Cell cell4 = row4.createCell(j++);
				cell4.setCellValue(list.get(i).getSex());
				cell4.setCellStyle(headerStyle2);
				//�ڵ����д����������Ԫ�����ڴ�ŵ�ַ
				Cell cell5 = row4.createCell(j++);
				cell5.setCellValue(list.get(i).getAddress());
				cell5.setCellStyle(headerStyle2);
			}
		}
		// �����������ļ��浽ָ��λ��
		String fileName = "StundetInfo";
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-disposition","attachment; filename=" + URLEncoder.encode(fileName + ".xls", "UTF-8"));
		OutputStream ouputStream = response.getOutputStream();
		wb.write(ouputStream);// ����Excel�ļ�
		ouputStream.flush();
		ouputStream.close();
		wb.close();
		response.flushBuffer();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
