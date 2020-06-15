/**
 * 
 */
/**
 * @author Pranay challa
 *
 */
package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ImportFromExcel {


public ArrayList<String> getdata(String testcaseName) throws IOException {
ArrayList<String> a=new ArrayList<String>();

FileInputStream fis=new FileInputStream("C:\\Users\\Pranay challa\\eclipse-workspace\\emiCal\\Test Data\\Book2.xlsx");
XSSFWorkbook workbook = new XSSFWorkbook(fis);

int sheets = workbook.getNumberOfSheets();
for(int i=0;i<sheets;i++)
{
if(workbook.getSheetName(i).equalsIgnoreCase("Sheet1"))
{
XSSFSheet sheet=workbook.getSheetAt(i);
Iterator<Row> rows= sheet.iterator();
Row firstrow=rows.next();
Iterator<Cell> ce=firstrow.cellIterator();
int k=0;
int column = 0;
while(ce.hasNext())
{
Cell value=ce.next();
if(value.getStringCellValue().equalsIgnoreCase("Testcase"))
{
column=k;
}
k++;
}
//System.out.println(column);

while(rows.hasNext())
{
Row r=rows.next();
if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testcaseName))
{
Iterator<Cell> cd=r.cellIterator();
while(cd.hasNext())
{
Cell c=cd.next();
if(c.getCellTypeEnum()==CellType.STRING)
{
a.add(c.getStringCellValue());
}
else
{

a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
}


}
}

}

}
}
return a;
}
}