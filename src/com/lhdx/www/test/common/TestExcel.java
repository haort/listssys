package com.lhdx.www.test.common;

import java.io.File;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class TestExcel {
	  public   static   void  main(String args[])  {
	       /*  try   {
	            Workbook book  =  Workbook.getWorkbook(new  File("D:\\upload\\hao.xls"));
	             //  获得第一个工作表对象 
	             Sheet sheet  =  book.getSheet( 0 );
	             //  得到第一列第一行的单元格 
	             Cell cell1  =  sheet.getCell( 0 ,  0 );
	            String result  =  cell1.getContents();
	            System.out.println(result);
	            book.close();
	        }   catch  (Exception e)  {
	            System.out.println(e);
	        } */
		  System.out.println(System.currentTimeMillis());
	    } 
}
