package genericPackage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Flib {
	//use to store generic reusable methods
	//readExcellData
	public String  readExcelData(String excelPath, String sheetName, int cellCount,int rowCount) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(excelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowCount);
		Cell cell= row.getCell(cellCount);
		String data=cell.getStringCellValue();
		return data;
	}
	public  int rowCount(String excelPath,String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(excelPath);
		Workbook	wb=WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		int rc = sheet.getLastRowNum();	
		return rc;
	}
	//read data from property file
	public String readPropertyData(String propertyPath, String keyValue) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream(propertyPath);
		Properties prop = new Properties();
		prop.load(fis);
		String data=prop.getProperty(keyValue);
		return data;
	}
}
