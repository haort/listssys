package com.lhdx.www.server.web;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lhdx.www.server.model.FileUploadBean;
import com.lhdx.www.server.model.Report;
import com.lhdx.www.server.service.ReportService;
import com.lhdx.www.server.util.FileReturn;

@Controller 
@RequestMapping(value = "/service")
public class FileUploadController {  
	@Resource(name = "reportService")
	private ReportService reportService;
	
	  @RequestMapping(value="/upload.json",method = RequestMethod.POST)  
	    public void upload(FileUploadBean userVO,@RequestParam("text") String text,
				@RequestParam("description") String description,HttpServletResponse response) throws Exception{ 
		   
		    String decodeText =new String(text.getBytes("ISO-8859-1"), "UTF-8");
		    String decodeDescription =new String(description.getBytes("ISO-8859-1"), "UTF-8");
	        if(!userVO.getFile().isEmpty()){ 
	        	List<Report> reports = new ArrayList<Report>();
	            Workbook book  =  Workbook.getWorkbook(userVO.getFile().getInputStream());
	            Sheet sheet  =  book.getSheet(0);
	            int  columnum  =  sheet.getColumns();
	            int  rownum  =  sheet.getRows();
	            for(int i=1;i<rownum;i++ ){
	            	Report r  = new Report();
	            	r.setServName(new String(sheet.getCell(0, i).getContents().getBytes(),"utf-8"));
	            	r.setProdId(new String(sheet.getCell(1, i).getContents().getBytes(),"utf-8"));
	            	r.setServAddr(new String(sheet.getCell(2, i).getContents().getBytes(),"utf-8"));
	            	r.setAccsNbr(new String(sheet.getCell(3, i).getContents().getBytes(),"utf-8"));
	            	r.setTy(new String(sheet.getCell(4, i).getContents().getBytes(),"utf-8"));
	            	r.setSpeed(new String(sheet.getCell(5, i).getContents().getBytes(),"utf-8"));
	            	r.setStartdt(new String(sheet.getCell(6, i).getContents().getBytes(),"utf-8"));
	            	r.setProdTel(new String(sheet.getCell(7, i).getContents().getBytes(),"utf-8"));
	            	r.setBipDataNum(new String(sheet.getCell(8, i).getContents().getBytes(),"utf-8"));
	            	r.setBipDuration(new String(sheet.getCell(9, i).getContents().getBytes(),"utf-8"));
	            	r.setArea(new String(sheet.getCell(10, i).getContents().getBytes(),"utf-8"));
	            	r.setRsrc(new String(sheet.getCell(11, i).getContents().getBytes(),"utf-8"));
	            	r.setItvProdId(new String(sheet.getCell(12, i).getContents().getBytes(),"utf-8"));
	            	r.setPackName(new String(sheet.getCell(13, i).getContents().getBytes(),"utf-8"));
	            	r.setKpiProdId(new String(sheet.getCell(14, i).getContents().getBytes(),"utf-8"));
	            	r.setPhone(new String(sheet.getCell(15, i).getContents().getBytes(),"utf-8"));
	            	r.setWareName(new String(sheet.getCell(16, i).getContents().getBytes(),"utf-8"));
	            	r.setGridName(new String(sheet.getCell(17, i).getContents().getBytes(),"utf-8"));
	            	r.setAreaName(new String(sheet.getCell(18, i).getContents().getBytes(),"utf-8"));
	            	r.setChName(new String(sheet.getCell(19, i).getContents().getBytes(),"utf-8"));
	            	reports.add(r);
	          } 
	          book.close();
	          reportService.createReports(decodeText, decodeDescription,reports);
	        }  
	        response.setContentType(FileReturn.CONTENT_TYPE);  
	        response.getWriter().write(FileReturn.UPLOAD_SUCCESS);  
	        response.flushBuffer();  
	    } 
}