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
	            	r.setServName(sheet.getCell(0, i).getContents());
	            	r.setProdId(sheet.getCell(1, i).getContents());
	            	r.setServAddr(sheet.getCell(2, i).getContents());
	            	r.setAccsNbr(sheet.getCell(3, i).getContents());
	            	r.setTy(sheet.getCell(4, i).getContents());
	            	r.setSpeed(sheet.getCell(5, i).getContents());
	            	r.setStartdt(sheet.getCell(6, i).getContents());
	            	r.setProdTel(sheet.getCell(7, i).getContents());
	            	r.setBipDataNum(sheet.getCell(8, i).getContents());
	            	r.setBipDuration(sheet.getCell(9, i).getContents());
	            	r.setArea(sheet.getCell(10, i).getContents());
	            	r.setRsrc(sheet.getCell(11, i).getContents());
	            	r.setItvProdId(sheet.getCell(12, i).getContents());
	            	r.setPackName(sheet.getCell(13, i).getContents());
	            	r.setKpiProdId(sheet.getCell(14, i).getContents());
	            	r.setPhone(sheet.getCell(15, i).getContents());
	            	r.setWareName(sheet.getCell(16, i).getContents());
	            	r.setGridName(sheet.getCell(17, i).getContents());
	            	r.setAreaName(sheet.getCell(18, i).getContents());
	            	r.setChName(sheet.getCell(19, i).getContents());
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