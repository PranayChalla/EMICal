package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class SummaryReport
{
       @Test
    public static void write(int rowNum,String value)
    {
    try {
    File src = new File("C:\\Users\\Pranay challa\\Downloads\\Report.xlsx");

    FileInputStream fis = new FileInputStream(src);
    XSSFWorkbook wbk = new XSSFWorkbook(fis);
    XSSFSheet sht = wbk.getSheet("Sheet1");
    
    Row	row = sht.getRow(rowNum);
    Cell cell = row.createCell(3);
    cell.setCellValue(value);
    
    
    FileOutputStream fos = new FileOutputStream(src);

    wbk.write(fos);
    
    wbk.close();
    } 
    catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
    }
    }

}