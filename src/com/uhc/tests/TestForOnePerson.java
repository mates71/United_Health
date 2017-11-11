package com.uhc.tests;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.uhc.pages.HomePage;
import com.uhc.pages.IndividualAndFamily;
import com.uhc.pages.UHOnePage;
import com.uhc.utulities.Driver;

public class TestForOnePerson {

	static WebDriver driver;
	UHOnePage uHOnePage = new UHOnePage(driver);

	@BeforeTest
	@Parameters({ "browser" })

	public void setUp(String Browser) {
		driver = Driver.getDriver(Browser);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	@Parameters({ "url" })
	public void step1(String Browser) {
		System.out.println("TestForOnePerson");
		driver.get(Browser);

		HomePage homePage = new HomePage(driver);
		homePage.individualOrFamily.click();

	}

	@Test(description = "Finding a health plan for one person")
	public void step2() throws InterruptedException {
		HomePage homePage = new HomePage(driver);
		Thread.sleep(1000);
		highlightAreaWithJavascript(homePage.individualOrFamily);
		// highlightAreaWithJavascript(homePage.individualOrFamily, 5000);
		// highlightAreaWithJavascript(homePage.individualOrFamily, 2000, 15);
		homePage.individualOrFamily.click();

	}

	@Test
	public void step3() throws InterruptedException {
		Thread.sleep(1000);
		IndividualAndFamily indAndFam = new IndividualAndFamily(driver);
		highlightAreaWithJavascript(indAndFam.viewPlan);
		indAndFam.viewPlan.click();

	}

	@Test
	@Parameters({"zipcode"})
	public void step4(String zipCode) throws Exception{
		List<String> handles=new ArrayList(driver.getWindowHandles());
		System.out.println(driver.getTitle());
		driver.switchTo().window(handles.get(1));
		System.out.println(driver.getTitle());
		
		// 4- Enter zipcode
		UHOnePage uHOnePage=new UHOnePage(driver);
		Thread.sleep(3000);
		uHOnePage.zipcode.sendKeys(zipCode);

	}

	@Test
	public void step5() throws InterruptedException {

		// 5- Select applicant gender
		UHOnePage uHOnePage = new UHOnePage(driver);
		Thread.sleep(1000);
		Select applicantDrop = new Select(uHOnePage.applicant);
		applicantDrop.selectByVisibleText("Male");
	}

	@Test
	public void step6() throws InterruptedException {
		// 6- Enter birthday
		Thread.sleep(2000);
		UHOnePage uHOnePage=new UHOnePage(driver);
		Thread.sleep(2000);
		uHOnePage.applicantBirthDay.sendKeys("1/2/1988");
		
		

	}

	@Test
	public void step7() throws InterruptedException {
		// 7- Select tabacco usage
		UHOnePage uHOnePage=new UHOnePage(driver);
		Thread.sleep(2000);
		Select tabaco = new Select(uHOnePage.tabacoUsage);
		tabaco.selectByValue("False");
		
		
		
				
	}

	@Test
	public void step8() throws InterruptedException {
		// 8- Click view plans
		UHOnePage uHOnePage=new UHOnePage(driver);
		Thread.sleep(3000);
		uHOnePage.plans.click();
		
		
		
	}
	@Test
	public void step9() throws InterruptedException {
		// 9- Confirm that we are in quote page
		Thread.sleep(2000);
		String expectedTitle = "UHOne";
		Assert.assertEquals(driver.getTitle(), expectedTitle);
		


	}
//	@Test
	public static void highlightAreaWithJavascript(WebElement element) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border= '3px solid red'", element);
		Thread.sleep(2000);

	}
	//@Test
	public static void highlightAreaWithJavascript(WebElement element, int milliSecondsToWait)
			throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border= '10px solid red'", element);
		Thread.sleep(milliSecondsToWait);
	}
	//@Test
	public static void highlightAreaWithJavascript(WebElement element, int milliSecondsToWait, int boldnessSize)
			throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border= '" + boldnessSize + "px solid red'", element);
		Thread.sleep(milliSecondsToWait);
	}

	// 1- one needs to go to the home page
	// 2- one needs to click Individuals&Families
	// 3- one needs to click view plans
	// 4- Enter zipcode
	// 5- Select aplicant gender
	// 6- Enter birthday
	// 7- Select tabacco usage
	// 8- Click view plans
	// 9- Confirm that we are in quote page
	// Environment: www.uhc.com
}
