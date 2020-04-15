package cats.selenium.bdd.stepdef;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.sapient.qa.cats.core.framework.CATSCucumberConfig;

import cucumber.api.Scenario;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WishList_verify_StepDef extends  CATSCucumberConfig{

	public String website;
	public ExcelReader ormData;

	@Before()
	public void launch(Scenario scenario) throws IOException {
		String ormFile=System.getProperty("user.dir")+"/../DataFiles/ORM.xlsx";
		this.ormData=new ExcelReader(ormFile);
		scenario.write("I am in before launch");
		website= catsVariable.getSuite("site");
		catsBeforeScenario(scenario); // this must be called all the time to invoke CATS framework
		disableAutoAssertion();
	}

	@BeforeStep
	public void beforeStep(Scenario scenario) {
		scenario.write("in cats Hybrid");
		catsBeforeStep(); // this must be called all the time to invoke CATS framework
		System.out.println(scenario.getStatus());
	}

	@AfterStep
	public void afterStep() {
		catsAfterStep(); // this must be called all the time to invoke CATS framework
	}

	/*****************************************************************************************************************************************
	 *****************************************************************************************************************************************
	 *************** To call your locator Please Use "CustomRules.locatorPresentInSite(website+".Language.CookieAccept",this.ormData)"********
	 *****************************************************************************************************************************************
	 *****************************************************************************************************************************************
	 **********************Start writing your Step definition below this section***************************************************************
	 *****************************************************************************************************************************************
	 */	  

	@Given("^User, click on wishlist icon$")
	public void user_click_on_wishlist_icon() throws Throwable {
		catsAction.waitUntilElementDisplay(CustomRules.locatorPresentInSite(website+".Wishlist.WishListIcon",this.ormData), "30");
		catsAction.click(CustomRules.locatorPresentInSite(website+".Wishlist.WishListIcon",this.ormData));

	}

	@And("^User verify wishlist is empty$")
	public void user_verify_wishlist_is_empty() throws Throwable 
	{
		Thread.sleep(5000);
		catsAction.verifyElementNotPresent(CustomRules.locatorPresentInSite(website+".Wishlist.WishlistItem",this.ormData));
		//System.out.println("wishlist empty message");

	}


	@Then("^User click on hotels navigation link$")
	public void user_click_on_hotels() throws Throwable {
		Thread.sleep(30000);
		catsAction.clickJS(CustomRules.locatorPresentInSite(website+".Home.HoteNavigationLink",this.ormData));
		catsAction.pageLoadWait();

	}

	@And("^User click on hotels wishlist icon$")
	public void user_click_on_hotels_wishlist_icon() throws Throwable {
		catsAction.clickJS(CustomRules.locatorPresentInSite(website+".HotelPage.WishListIconOnHotel",this.ormData));
		Thread.sleep(5000);
		try{
			if(getDriver().findElementByXPath(catsVariable.getORM(CustomRules.locatorPresentInSite(website+".HotelPage.CloseLoginPopUp",this.ormData)).getXpath()).isDisplayed())
			{   
				Thread.sleep(2000);
				catsAction.click(CustomRules.locatorPresentInSite(website+".HotelPage.CloseLoginPopUp",this.ormData));
			}
		}catch(Exception e)
		{
			System.out.println(e);
		}

	}

	@And("^User verify wishlist on wishlist page$")
	public void user_verify_wishlist_on_wishlist_page() throws Throwable {
		Thread.sleep(5000);
		catsAction.scrollPageUp();
		catsAction.clickJS(CustomRules.locatorPresentInSite(website+".Home.WishlistFilledIconHeader",this.ormData));
		Thread.sleep(20000);
		catsAction.waitUntilElementDisplay(CustomRules.locatorPresentInSite(website+".Wishlist.WishlistItem",this.ormData), "30");
		catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Wishlist.WishlistItem",this.ormData));

	}

	@Then("^user click on and share social site$")
	public void user_click_on_and_share_social_site() throws Throwable 
	{
		Thread.sleep(12000);
		catsAction.clickJS(CustomRules.locatorPresentInSite(website+".HotelPage.shareIcon",this.ormData));
		catsAction.waitUntilElementDisplay(CustomRules.locatorPresentInSite(website+".HotelPage.SocialMenu",this.ormData), "20");
		catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".HotelPage.SocialMenu",this.ormData));
	}
	@Given("^User click on whats on$")                
	public void user_click_on_whats_on() throws Throwable 
	{
		catsAction.waitUntilElementDisplay(CustomRules.locatorPresentInSite(website+".HotelPage.WhatsOn",this.ormData), "20");

		catsAction.click(CustomRules.locatorPresentInSite(website+".HotelPage.WhatsOn",this.ormData));
	}

	@Then("^User verify Event date$")
	public void user_verify_event_date() throws Throwable 
	{
		Thread.sleep(10000);
		List<WebElement> DateList = getDriver().findElementsByXPath(catsVariable.getORM(website+".HotelPage.DateList").getXpath()); 
		System.out.println("WishList_verify_StepDef.java:::::::::"+DateList.size());
		for(WebElement ele : DateList)    
		{
			String deliverydate= ele.getText();
			System.out.println("dateTocheck:"+deliverydate);
			String[] separateDateToVerify = deliverydate.split("-", 2); 

			String endDate= separateDateToVerify[1];
			System.out.println("endDate:"+endDate);

			String[] separateDateAgainToVerify = endDate.split(",", 2); 

			String endDateToVerify= separateDateAgainToVerify[1];
			System.out.println("endDateToVerify"+endDateToVerify);

			deliverydate=endDateToVerify.trim().replace(" ", "-").replace(",", "");   

			String month=deliverydate.split("-")[1];
			if(month.length()<=1){
				month="0"+month;
			}

			deliverydate=  deliverydate.split("-")[0]+"-"+month+"-"+deliverydate.split("-")[2];

			System.out.println("deliverydate::::::"+dateConvertor(deliverydate,"MMM-dd-yyyy"));
			LocalDate EventDate = dateConvertor(deliverydate,"MMM-dd-yyyy");


			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String date = simpleDateFormat.format(new Date());
			System.out.println("CurrentDate:::::::"+dateConvertor(date, "yyyy-MM-dd"));
			LocalDate currentDate= dateConvertor(date, "yyyy-MM-dd");

			if(EventDate.compareTo(currentDate) >=0) {
				catsAction.reportResultPass("Validating Event if Date is greater then or equal with current Date"
						, EventDate.toString(), currentDate.toString(), EventDate.toString());
			} else if(EventDate.compareTo(currentDate) == 0) {
				catsAction.reportResultFail("Validating Event if Date is greater then or equal with current Date"
						, EventDate.toString(), currentDate.toString(), EventDate.toString());
			}


		}
		System.out.println("DateList: "+DateList.size());

	}

	public LocalDate dateConvertor(String Date, String format){
		DateTimeFormatter formatter = new DateTimeFormatterBuilder()
				.parseCaseInsensitive()
				.appendPattern(format)
				.toFormatter(Locale.UK);
		LocalDate ld = LocalDate.parse(Date, formatter);
		System.out.println(ld);
		return ld;
	}

	@Then("^User Delete All item$")
	public void user_delete_all_item() throws Throwable 
	{
		Thread.sleep(12000);
		catsAction.clickJS(CustomRules.locatorPresentInSite(website+".HotelPage.SelectAllwishList",this.ormData));
		Thread.sleep(3000);
		catsAction.clickJS(CustomRules.locatorPresentInSite(website+".HotelPage.DeleteIcon",this.ormData));
		Thread.sleep(3000);
		catsAction.clickJS(CustomRules.locatorPresentInSite(website+".HotelPage.OK",this.ormData));



	}


	@Then("^User click on discoverMore and add wishlist$")
	public void user_click_on_discovermore_and_add_wishlist() throws Throwable {

		Thread.sleep(3000);
		List<WebElement> discoverMoreButtonList = getDriver().findElements(By.xpath("//div[@class='readMoreCTA']"));
		System.out.println("Total no of links Available: "+discoverMoreButtonList.size());
		for (int i = 1; i <=1; i++) 
		{

			catsAction.click("(//div[@class='readMoreCTA'])["+i+"]");
			Thread.sleep(3000);
			catsAction.scrollDownByOffset("350");

			Thread.sleep(5000);
			try{
				if(getDriver().findElementByXPath(catsVariable.getORM(CustomRules.locatorPresentInSite(website+".PDPbook.HotelWishlist",this.ormData)).getXpath()).isDisplayed())
				{   
					Thread.sleep(2000);
					catsAction.click(CustomRules.locatorPresentInSite(website+".PDPbook.HotelWishlist",this.ormData));
				}
			}catch(Exception e)
			{
				catsAction.scrollPageUp();
			}
		}
	} 

	@Then("^User click on Wishlist Tab And Verify$")
	public void user_click_on_wishlist_tab_and_verify() throws Throwable 
	{
		try{Thread.sleep(2000);
		catsAction.click(CustomRules.locatorPresentInSite(website+".WishListPage.WishListTab",this.ormData));
		Thread.sleep(2000);
		catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Wishlist.WishlistItem",this.ormData));
		}catch(Exception e){
			
			System.out.println("Exception in Wishlist tab "+e);
		}
	}
	@And("^User delete the wishlist$")
	public void user_delete_the_wishlist() throws Throwable 
	{
		Thread.sleep(5000);
		List<WebElement> noOfwishlistDltBtn = getDriver().findElementsByXPath(catsVariable.getORM(website+".WishListPage.Delete").getXpath()); 

		System.out.println("noOfdeleteBtn:"+noOfwishlistDltBtn.size());

		for(int i=0; i<noOfwishlistDltBtn.size();i++)
		{
			catsAction.click(CustomRules.locatorPresentInSite(website+".WishListPage.Delete",this.ormData));

		} 
	}
	@Then("^User verify empty wishlist$")
	public void user_verify_empty_wishlist() throws Throwable 
	{
		Thread.sleep(2000);
		catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".WishListPage.EmptyMgs",this.ormData));
	}
	@And("^User click on book now button$")
	public void user_click_on_book_now_button() throws Throwable 
	{
		Thread.sleep(2000);
		catsAction.clickJS(CustomRules.locatorPresentInSite(website+".WishListPage.BookNow",this.ormData));
		Thread.sleep(3000);
		catsAction.clickJS(CustomRules.locatorPresentInSite(website+".WishListPage.SelectFromList",this.ormData));


	}


}











