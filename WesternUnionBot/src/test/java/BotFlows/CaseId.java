
package BotFlows;


import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaseId {
	
	@Test
	
	public void Case() throws IOException, InterruptedException {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
	    CaseIdOne one  = new CaseIdOne();
	    one.MethodOne(driver);
		
		String url;
		
		FileInputStream fis = new FileInputStream("C:\\Users\\ManikanthaPonduru\\Documents\\Practice.xlsx");
		//defining the excel sheet to the workbook instance @ apache.POI
		XSSFWorkbook wb = new XSSFWorkbook(fis); 
		XSSFSheet sheet = wb.getSheetAt(0);  
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		
		XSSFRow row = sheet.getRow(0);
	
		//accessing the number of columns 
		int colCount = row.getLastCellNum();
		
		System.out.println(rowCount + colCount +" "+"No. of countries are being used for testing");
		
		for(int i=0;i<rowCount-1; i++) {
			
			row = sheet.getRow(i+1);
			url = row.getCell(0).getStringCellValue();
			System.out.println(url);

			String a[] = {"Case number", "Case number status", "Case status update", "Case status inquiry", "Check case status", "Update on case", "Case progress", "Case resolution", "Case reference"};
			for (int j = 0; j<a.length; j++)  {  
				System.out.println("Intent name being used is -- "+" "+a[j]);
				driver.get(url);
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
				WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
				//Clicking the Bot Icon
				driver.findElement(By.xpath("//img[@src=\"https://d3dqyamsdzq0rr.cloudfront.net/wu-widget/chat/images/wu_icon.png\"]")).click();
				//Waiting till the greeting message displays to the user
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=\"Hi, I am Eve—your automated Western Union assistant. How can I help you today?\"]")));
				//sending the intents as input
				driver.findElement(By.xpath("//textarea[@name=\"reply-lisa-textarea\"]")).sendKeys(a[j]);
				//Clicking the send button
				driver.findElement(By.xpath("//img[@src=\"https://d3dqyamsdzq0rr.cloudfront.net/wu-widget/chat/images/icons8-send-100.png\"]")).click();
				try 
				{
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=\"Please provide the 9-digit Case ID to know the status\"]")));
				//Printing the valid case id input text
				System.out.println(driver.findElement(By.xpath("//div[text()=\"Please provide the 9-digit Case ID to know the status\"]")).getText());
				driver.findElement(By.xpath("//textarea[@name=\"reply-lisa-textarea\"]")).sendKeys("abcdefghijkl");
				driver.findElement(By.xpath("//img[@src=\"https://d3dqyamsdzq0rr.cloudfront.net/wu-widget/chat/images/icons8-send-100.png\"]")).click();
				System.out.println(driver.findElement(By.xpath("//div[text()=\"Invalid Case ID entered. Please enter again (e.g 123456789)\"]")).getText());	
				driver.findElement(By.xpath("//i[@title=\"close\"]")).click();
				System.out.println("Intent" + " "+ a[j] +" "+ "has been verified");
				System.out.println(" ");
				}
				catch(Exception e)
				{
					System.out.println("Something went wrong");
				}
				
				}	
	      
      }
		

	}
	}
	

