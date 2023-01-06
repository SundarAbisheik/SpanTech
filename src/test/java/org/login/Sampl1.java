package org.login;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sampl1 {
	
	WebDriver driver;
	@Test
	public void tc1() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ees.efile4taxes.com/User/AccountLogIn");

		// Login with credentials
		driver.findElement(By.id("LoginName")).sendKeys("barnettcandy20@gmail.com");
		driver.findElement(By.id("OriginalPassword")).sendKeys("Admin@123", Keys.ENTER);

		driver.findElement(By.id("linkglobalSettings")).click();
		
		Actions actions = new Actions(driver);
		WebElement form = driver.findElement(By.xpath("(//a[contains(text(),'Form 7004')])[1]"));
		Actions moveToElement = actions.moveToElement(form);;
		
		
		moveToElement.click().perform();
		
		WebElement actual = driver.findElement(By.xpath("//span[text()='- Form History']"));
		String actualText = actual.getText();
		System.out.println(actualText);
		Assert.assertEquals(actualText, "- Form History");
		
		
	}


}
