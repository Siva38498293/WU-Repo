package BotFlows;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CaseIdOne {

	@Test
	public void MethodOne(WebDriver driver) {
		driver.get("https://dev-wu.skil.ai/ai-demo/html/pages/wu-assisstant-v3.html?language=en_US");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		String b[] = {"Case number", "Case number status", "Case status update", "Case status inquiry", "Check case status", "Update on case", "Case progress", "Case resolution", "Case reference"};
		for(int k=0; k<b.length; k++) {
		driver.findElement(By.xpath("//img[@class=\"chat-bot-icon\"]")).click();
		WebDriverWait waitZero=new WebDriverWait(driver, Duration.ofSeconds(30));
		waitZero.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=\"Hi, I am Eve—your automated Western Union assistant. How can I help you today?\"]")));
		driver.findElement(By.xpath("//textarea[@name=\"reply-lisa-textarea\"]")).sendKeys(b[k]);
		//Clicking the send button
		driver.findElement(By.xpath("//img[@src=\"https://d3dqyamsdzq0rr.cloudfront.net/wu-widget/chat/images/icons8-send-100.png\"]")).click();
		try 
		{
		waitZero.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()=\"Please provide the 9-digit Case ID to know the status\"]")));
		//Printing the valid case id input text
		System.out.println(driver.findElement(By.xpath("//div[text()=\"Please provide the 9-digit Case ID to know the status\"]")).getText());
		driver.findElement(By.xpath("//textarea[@name=\"reply-lisa-textarea\"]")).sendKeys("abcdefghijkl");
		driver.findElement(By.xpath("//img[@src=\"https://d3dqyamsdzq0rr.cloudfront.net/wu-widget/chat/images/icons8-send-100.png\"]")).click();
		System.out.println(driver.findElement(By.xpath("//div[text()=\"Invalid Case ID entered. Please enter again (e.g 123456789)\"]")).getText());
		driver.findElement(By.xpath("//textarea[@name=\"reply-lisa-textarea\"]")).sendKeys("987654321");
		driver.findElement(By.xpath("//img[@src=\"https://d3dqyamsdzq0rr.cloudfront.net/wu-widget/chat/images/icons8-send-100.png\"]")).click();
		waitZero.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("driver.findElement(By.xpath(\"//span[@class=\\\"form-control formHeading\\\"]\"))")));
	//	driver.findElement(By.xpath("")).sendKeys("Other");
		WebElement staticDropdown = driver.findElement(By.xpath("//select[@class=\"dropdownList chatReasonList\"]"));
		Select dropdown = new Select (staticDropdown);
		dropdown.selectByIndex(8);
		driver.findElement(By.xpath("(//input[@name=\"lastName\"])[5]")).sendKeys("Test");
		driver.findElement(By.xpath("(//input[@name=\"emailId\"])[3]")).sendKeys("Test@gmail.com");
		driver.findElement(By.xpath("(//button[text()=\"Next\"])[2]")).click();
		waitZero.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"form-control formHeading2\"]")));
		Thread.sleep(2500);
		driver.findElement(By.xpath("//i[@title=\"close\"]")).click();
		System.out.println("Intent" + " "+ b[k] +" "+ "has been verified");
		System.out.println(" ");
		
		}
		
		catch(Exception e)
		{
			System.out.println("Something went wrong");
		}
		}
	}
	}

