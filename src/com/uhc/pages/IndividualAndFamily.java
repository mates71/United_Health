package com.uhc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndividualAndFamily {

	private WebDriver driver;
	
	public  IndividualAndFamily (WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(css=".button-primary-common.button-digital-blue")
	public WebElement viewPlan;
}
