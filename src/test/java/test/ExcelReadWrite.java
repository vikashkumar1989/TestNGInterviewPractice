package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadWrite {
	
	public void ExcelRead(int row, int col) throws IOException {
		FileInputStream fis=new FileInputStream("C:\\Users\\vikas\\Desktop\\Java\\TestNGInterviewPractice\\src\\test\\resources\\Excel\\ExcelRead.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sh=wb.getSheet("SheetA");
		int rownum=sh.getLastRowNum()-sh.getFirstRowNum();
		System.out.println("total row-->"+rownum);
		XSSFRow rw=sh.getRow(row-1);
		XSSFCell cell=rw.getCell(col-1);		
		if(cell.getCellTypeEnum()==CellType.STRING) {
			System.out.println(cell.getStringCellValue());
		}else if(cell.getCellTypeEnum()==CellType.NUMERIC){
			System.out.println(cell.getNumericCellValue());
		}
	}
	
	public void ExcelWrite(int row, int col, Object data) throws IOException {
		XSSFWorkbook wb=new XSSFWorkbook();
		XSSFSheet sh=wb.createSheet("SheetB");
		XSSFRow rw=sh.createRow(row-1);
		XSSFCell cell=rw.createCell(col-1);
		if(data instanceof String) {
			cell.setCellValue((String)data);
		}else if(data instanceof Double) {
			cell.setCellValue((Double)data);
		}
		FileOutputStream fos=new FileOutputStream("C:\\Users\\vikas\\Desktop\\Java\\TestNGInterviewPractice\\src\\test\\resources\\Excel\\ExcelWrite.xlsx");
		wb.write(fos);
		wb.close();
		
	}
	public static void main(String[] args) throws IOException {
		ExcelReadWrite ex=new ExcelReadWrite();
		ex.ExcelRead(2, 2);
		ex.ExcelWrite(2, 10,"Shastri");
	}

}
