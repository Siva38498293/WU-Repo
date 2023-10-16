package BotFlows;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class checkrates {
	
	public void rates(WebDriver driver) throws InterruptedException {
		
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));
		driver.findElement(By.xpath("//p[text()=\"Check rates\"]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"message-bot pb-2\"][2]")));
		driver.findElement(By.xpath("//textarea[@name=\"reply-lisa-textarea\"]")).sendKeys("USA");
		driver.findElement(By.xpath("//img[@src=\"https://d3dqyamsdzq0rr.cloudfront.net/wu-widget/chat/images/icons8-send-100.png\"]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"How will you send the money?\"]")));
		driver.findElement(By.xpath("//div[@btn-val=\" Online \"]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"How does your receiver want the money?\"]")));
		driver.findElement(By.xpath("//p[text()=\"Cash \"] ")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"How will you like to pay?\"]")));
		driver.findElement(By.xpath("//div[@btn-val=\" Credit/Debit card\"]")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"Lastly, how much would you like to send?\"]")));
		driver.findElement(By.xpath("//textarea[@name=\"reply-lisa-textarea\"]")).sendKeys("100");
		driver.findElement(By.xpath("//img[@src=\"https://d3dqyamsdzq0rr.cloudfront.net/wu-widget/chat/images/icons8-send-100.png\"]")).click();
		try {
		System.out.println(driver.findElement(By.xpath("//div//table[@class=\"lisa-wu-price-estimator\"]")));
		}
		catch(Exception e)
		{
			System.out.println("Something went wrong");
		}
		driver.findElement(By.xpath("//i[@title=\"close\"]")).click();
		
		 
	
	
		
	}



}
