package com.uhc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UHOnePage {

	private WebDriver driver;
	
	public UHOnePage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	//@FindBy(css="LocationViewModel_ZipCode")  
	@FindBy(id="LocationViewModel_ShowRedirectMessage")
	public WebElement zipcode;
	
	@FindBy(css="#PrimaryApplicant_Gender")
	public WebElement applicant;
	
	@FindBy(css="#PrimaryApplicant_BirthDate")
	public WebElement applicantBirthDay;
	
	@FindBy(css="#PrimaryApplicant_HasTobaccoUsage")
	public WebElement tabacoUsage;
	
	@FindBy(css="#hylViewPlans")
	public WebElement plans;
	
}
