package org.login;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Sample {
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

		driver.findElement(By.xpath("(//a[contains(text(),'Form 7004')])[1]")).click();
		driver.findElement(By.xpath("//a[@title='Start New Business Extension']")).click();

		driver.findElement(By.id("BusinessName")).sendKeys("Raja Enterprises");
		driver.findElement(By.id("EIN")).sendKeys("12-3456721");
		driver.findElement(By.id("ConfirmEIN")).sendKeys("12-3456721");
		driver.findElement(By.xpath("//label[@for='ForeignAddress']")).click();
		driver.findElement(By.id("Address1")).sendKeys("Anna Nagar");
		driver.findElement(By.id("City")).sendKeys("Chennai");
		driver.findElement(By.id("State")).sendKeys("TamilNadu");

		WebElement countries = driver.findElement(By.id("MyCountries"));
		Select select = new Select(countries);
		select.selectByVisibleText("India");

		driver.findElement(By.id("txtzip")).sendKeys("600015");

		driver.findElement(By.id("SAName")).sendKeys("Raja");
		driver.findElement(By.id("SATitle")).sendKeys("CEO");
		driver.findElement(By.id("SADayTimePhone")).sendKeys("9999999999");

		driver.findElement(By.id("btnNext")).click();

		driver.findElement(By.id("linkglobalSettings2")).click();

		driver.findElement(By.className("user-letter")).click();

		driver.findElement(By.xpath("//a[contains(text(),' Log Off ')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("btnSubmit")).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();

		driver.findElement(By.id("LoginName")).sendKeys("barnettcandy20@gmail.com");
		driver.findElement(By.id("OriginalPassword")).sendKeys("Admin@123", Keys.ENTER);

		driver.findElement(By.xpath("(//th[contains(text(),'Return Number')])[1]")).click();
		driver.findElement(By.xpath("(//th[contains(text(),'Return Number')])[1]")).click();

		WebElement status = driver.findElement(By.xpath(
				"//td//span[contains(text(),'Raja Enterprises')]/following::span[@class='mt-2 d-md-block ml-1 ml-md-0'][1]"));

		String text = status.getText();

		String substring = text.substring(1, 11);

		Assert.assertEquals(substring, "Incomplete");
		System.out.println(text);
		System.out.println(substring);

	}

}
