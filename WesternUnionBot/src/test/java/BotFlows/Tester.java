package BotFlows;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tester {
	
	DataFormatter formatter = new DataFormatter();
	@Test
	public void Excel() throws IOException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		FileInputStream fis = new FileInputStream("C:\\Users\\ManikanthaPonduru\\Documents\\BookOfUrls.xlsx");
		//defining the excel sheet to the workbook instance @ apache.POI
		XSSFWorkbook wb = new XSSFWorkbook(fis); 
		//We are starting to read the information from the 0th indexed page or the 1st page and storing that in the sheet variable
		//therefore sheet variable contains all the information of the page in the desired excel sheet
		XSSFSheet sheet = wb.getSheetAt(0);
		//accessing the rows and storing the no. of rows in the page in the variable rowCount
		int rowCount = sheet.getPhysicalNumberOfRows();
		//accessing the 1st row of the page, so inorder to access the column count
		//logic: 4 cells in a row is equal to 4 columns in the page. So we are trying to access the 0
		XSSFRow row = sheet.getRow(0);
		//accessing the number of columns
		int colCount = row.getLastCellNum();
		//storing all the rows and columns in an array
		//rowCount-1 means ignoring the first row because it consists of headings
		Object Data[][] = new Object[rowCount-1][colCount];
		//reading rows
		//rowCount-1 == I am asking to read each row apart from the 1st row in the 0th index as it contains headings
		for(int i=0;i<rowCount-1; i++) 
		{
			//i+1 == as i starts from 0th index or the 1st row so; 0+1 = 1st row
			System.out.println("outer loop started");
			row = sheet.getRow(i+1);//storing the rows in the row variable
			for (int j=0;j<colCount;j++) 
			{
				System.out.println("inner loop started");
				//storing the excel sheet cell values in the cell variable
				
				
				System.out.println( row.getCell(j)); //in the outer loop, i iterates through each row and in the inner loop j iterates through each cell in the row where i is present
			
				System.out.println("inner loop ended");
			}
			System.out.println("outer loop ended");
		}
	
	
	}

}
