package larosa;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class pageclass {
	WebDriver driver;
	@FindBy(xpath="//*[@id=\"siteHeader\"]/div[1]/div/div/div/div/div[2]/div/div[3]/h6/a  ") 
	WebElement account ;
	

@FindBy(xpath="//*[@id=\"siteHeader\"]/div[1]/div/div/div/div/div[2]/div/div[1]/form/div/div/input")
WebElement searchkey ; //send keys

@FindBy(xpath=" //*[@id=\"siteHeader\"]/div[1]/div/div/div/div/div[2]/div/div[1]/form/div/button ") 
WebElement searchbutton ;//click

@FindBy(name="name")
WebElement firstName;

@FindBy(name="email")
WebElement Email;

@FindBy(name="phone")
WebElement Phone;

@FindBy(xpath="/html/body/div[1]/div/section/div/div/div/form/div/div[5]/button")
WebElement Submit;

@FindBy(xpath="//*[@id=\"siteHeader\"]/div[2]/div/div/div/div/div[2]/div[1]/ul/li[2]/a")
WebElement NewArrivals;

@FindBy(xpath="//*[@id=\"latest-product-listing\"]/div[3]/div/div[1]/a")
WebElement selectAdress;

@FindBy(xpath="//*[@id=\"btn-cart-add\"]")
WebElement addTocart;

@FindBy(xpath="//*[@id=\"siteHeader\"]/div[1]/div/div/div/div/div[2]/div/div[4]/h6/a")
WebElement MyCart;



public pageclass(WebDriver driver) {
	  this .driver=driver;
	  PageFactory.initElements(driver, this);
}
public void titleVerification()
{
	String actualTitle=driver.getTitle() ;
	Assert.assertEquals("Kerala online ladies boutique Alappuzha textiles", actualTitle);
	System.out.println("ActualTitle="+actualTitle);
		
	}
public void linkcount()	
{
List<WebElement>linkDetails=driver.findElements(By.tagName("a"));    //<a +angertag ,<input,<div, are the tags
System.out.println("Total number of links="+linkDetails.size());
for(WebElement element :linkDetails)
{
	String link=element.getAttribute("href");
	//verify(link);//create method
//}}
//public void verify(String link) {
	// response code methpod
	try {
		URL u=new URL(link);//import
		HttpURLConnection code=(HttpURLConnection)u.openConnection();
		if (code.getResponseCode()==200)
		{
		System.out.println("Response code is 200 -----"+ link)	;

		}
		else 
		if(code.getResponseCode()==404)
		{
			System.out.println("Response code is 404-------"+link);
		}
		else
		{
			System.out.println("other response code");
	}}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}}}

public void pagesource()
{
	String src=driver.getPageSource();
	if (src.contains("My Cart"))
	{
		System.out.println("My Cart present");
	}
	else
	{
	System.out.println("My Cart not present");	
	}}

public void search()
{
	searchkey.sendKeys(" INDO WESTERN STYLE TOPS");
}
public void searchbuttonclick()
{
	searchbutton.click();
}
public void accountCreation()
{
	account.click();
	
}
public void setValues(String fname,String email,String phone)
{
	 firstName.sendKeys(fname);
	 Email.sendKeys(email);
	 Phone.sendKeys(phone);
     Submit.click();
	
}
public void navigateHome()
{
	driver.navigate().back();  
}
public void newArrivals()
{
	NewArrivals.click();
}
public void SelectAdress()
{
	selectAdress.click();
}
public void AddToCart()
{
addTocart.click();

}

public void myCart()
{
	MyCart.click();
}
}





















