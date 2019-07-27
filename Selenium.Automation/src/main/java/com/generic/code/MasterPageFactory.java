package com.generic.code;

import java.util.List;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MasterPageFactory {
	
	
	
	//@FindBy=driver.findElelment
	
	//WebElement signinbutton;//dec
	//signinbutton= driver.findElelment(By.xpath("//*[contains(text(),'Hello')]"));//initialization
	
	@FindBy(xpath="//*[contains(text(),'Hello')]")// a=10
	private List<WebElement> signinbutton;//dec==> int a
	
	
	@FindBy(xpath="//*[contains(@id,'add-to-cart-button')]")
	private List<WebElement> addToCart;
	
	@FindBy(xpath="(//*[contains(text(),'View Cart' )])[2]")
	private List<WebElement> viewCart;

	@FindBy(xpath="//*[contains(@class,'close')]")
	private List<WebElement> clsoeBtn;
	
	
	
			
	//@FindBy(xpath="//*[contains(text(),'Proceed to checkout')]")
	@FindBy(xpath="//*[@name='proceedToCheckout']")
	private List<WebElement> proceedBtn;
	
	@FindBy(xpath = "//*[contains(text(),'Hello')]") // value
	private WebElement signinbtn;// decl
	
	@FindBy(xpath = "//*[@id='nav-al-your-account']//*[contains(text(),'Sign Out')]")
	private List<WebElement> signout;

	@FindBy(xpath = "//*[contains(@id,'twotabsearchtextbox')]")
	private WebElement searchBox;

	@FindBy(xpath = "//*[contains(@id,'a-autoid-0-announce')]")
	private WebElement sorting;

	@FindBy(xpath = "//*[contains(@id,'Apple')]//*[@class='a-icon a-icon-checkbox']")
	private WebElement Applecheckbox;

	// 22 iphone ==multiple>>>> List
	@FindBy(xpath = "//h2//a//span")
	private List<WebElement> iphonename;
	
	@FindBy(xpath = "//*[@class='sg-row']//*[@class='a-price']//span[@class='a-offscreen']")
	private List<WebElement> iphoneprice;
	
	@FindBy(xpath = "//*[@class='a-button-inner']//*[contains(text(),'Deliver to this address')]")
	private List<WebElement> deliverAddressBtn;
	
	@FindBy(xpath = "//*[@class='a-box-inner']/span[1]")
	private List<WebElement> continueBtn;
	@FindBy(xpath = "//*[@id='ap_email']")
	private WebElement email;

	@FindBy(xpath = "//*[@id='ap_password']")
	private WebElement pass;

	@FindBy(xpath = "//*[@class='a-popover-wrapper']//li")
	private List<WebElement> sortingDropOptions;
	
	/*
	 * @FindBy(css= "#ap_password") private WebElement pass3;
	 */

	public List<WebElement> getSignout() {
		return signout;
	}

	public WebElement getSigninbtn() {

		return signinbtn;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getSorting() {
		return sorting;
	}

	public WebElement getApplecheckbox() {
		return Applecheckbox;
	}

	public List<WebElement> getIphonename() {
		return iphonename;
	}

	public List<WebElement> getIphoneprice() {
		return iphoneprice;
	}

	public WebElement getEmail() {

		return email;
	}

	public WebElement getPass() {

		return pass;
	}

	public List<WebElement> getSigninbutton() {
		return signinbutton;
	}

	public List<WebElement> getSortingDropOptions() {
		return sortingDropOptions;
	}

	public List<WebElement> getAddToCart() {
		return addToCart;
	}

	public List<WebElement> getViewCart() {
		return viewCart;
	}

	public List<WebElement> getClsoeBtn() {
		return clsoeBtn;
	}

	public List<WebElement> getProceedBtn() {
		return proceedBtn;
	}

	public List<WebElement> getDeliverAddressBtn() {
		return deliverAddressBtn;
	}

	public List<WebElement> getContinueBtn() {
		return continueBtn;
	}

}
