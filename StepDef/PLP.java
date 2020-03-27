
package cats.selenium.bdd.stepdef;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.openqa.selenium.WebElement;

import com.sapient.qa.cats.core.framework.CATSCucumberConfig;


import cucumber.api.Scenario;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import de.retest.web.selenium.By;

public class PLP extends CATSCucumberConfig{

	public  String site;
	public String website;
	int days=1;
	//CustomRules customrules;

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

	/*public static Properties readPropertiesFile(String fileName) throws IOException {
		FileInputStream fis = null;
		Properties prop = null;
		try {
			fis = new FileInputStream(fileName);
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			fis.close();
		}
		return prop;
	}*/
	//------------------------------------------------------date selection------------------------------
	public boolean dateSelection() throws InterruptedException
	{
		boolean flag = false;
		Thread.sleep(3000);
		//String buttonList =catsVariable.getORM(website + ".HomePage.BookNowButtonList").getXpath();

		String availableDateInCal =catsVariable.getORM(website + ".BookNowOverlay.availabledate").getXpath();
		List<WebElement> AvailableDateCount = getDriver().findElements(By.xpath(availableDateInCal));
		for (int m=1; m<=5;m++)
		{
			if(AvailableDateCount.size()>0)
			{
				System.out.println("Slot available" +m);
				catsAction.clickJS(CustomRules.locatorPresentInSite(website + ".BookNowOverlay.availabledate",this.ormData));
				catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".BookNowOverlay.PreferredtimeSlots",this.ormData));
				 Thread.sleep(3000);
				catsAction.clickJS(CustomRules.locatorPresentInSite(website+".BookNowOverlay.PreferredtimeSlots",this.ormData));
				 Thread.sleep(3000);
				catsAction.clickJS(CustomRules.locatorPresentInSite(website+".BookNowOverlay.PreferredtimeSlotsOption",this.ormData));
				flag = true ;
				break;
			}
			else
			{
				Thread.sleep(5000);
				catsAction.click(website+".Product_Booking.nextMonthClickOnCalender");
				AvailableDateCount = getDriver().findElements(By.xpath(availableDateInCal));
				System.out.println("Available Date Count in next month .........."+AvailableDateCount.size());
			}

		}
		return flag;
	}

	//----------------------------------Book Now button--------------------------------------------------------------------------------
	public void clickBookNowButtonOfGivenFeature(String featureName) throws Throwable {


		String featureLabelNameListPath =catsVariable.getORM(website + ".HomePage.FeatureLabelNameListPath").getXpath();
		System.out.println("featureLabelNameListPath........."+featureLabelNameListPath);
		List<WebElement> FeatureLabelName = getDriver().findElements(By.xpath(featureLabelNameListPath));
		System.out.println("FeatureLabelName count......"+FeatureLabelName.size());
		//System.out.println("featureLabelName ........."+FeatureLabelName);
		System.out.println("Feature Label Name validation.........." +featureName);
		for (int k=0; k<FeatureLabelName.size();k++)
		{
			/*System.out.println("Feature Label Name" +FeatureLabelName.get(k).getText());
			System.out.println("Feature Label Name.........." +featureName);
			System.out.println("(//div[@class='buy-ticket-cta']/button)["+(k+1)+"]");
			 */
			if(FeatureLabelName.get(k).getText().equalsIgnoreCase(featureName))
			{
				System.out.println("Inside if");
				Thread.sleep(3000);
				catsAction.click("(//div[@class='buy-ticket-cta']/button)["+(k+1)+"]");
				
				break;
			}
			
		} 

	}
	//----------------------------------------


	public void verifyAndSelectTabOption(String menuName) throws Throwable {

		String TabManuOptionListPath =catsVariable.getORM(website + ".Booking.TabManuOptionListPath").getXpath();
		List<WebElement> TabManuOption = getDriver().findElements(By.xpath(TabManuOptionListPath));

		System.out.println("FeatureLabelName count......"+TabManuOption.size());
		for (int x=0; x<TabManuOption.size();x++)
		{
			System.out.println("Menu Option name" +TabManuOption.get(x).getText());
			System.out.println("Menu Option name.........." +menuName);

			if(TabManuOption.get(x).getText().equalsIgnoreCase(menuName))
			{
				System.out.println("Inside if"+TabManuOption.get(x).getText());
				catsAction.clickJS("(//ul[@class='tabs-menu']//li//span)["+(x+1)+"]");
				break;
			}
		} 
	}

		/* @And("^user apply PromoCode in Mini cart$")
		    public void user_apply_PromoCode_in_Mini_cart() throws Throwable {
			    catsAction.waitUntilElementDisplay(CustomRules.locatorPresentInSite(website+".Ticket.EnterPromoCode",this.ormData),"30");
			    Thread.sleep(2000);
			    catsAction.click(CustomRules.locatorPresentInSite(website+".Ticket.EnterPromoCode",this.ormData));
				Thread.sleep(2000);
				catsAction.enter(CustomRules.locatorPresentInSite(website+".Ticket.EnterPromoCode",this.ormData), "$MiralGlobal.Coupon.<<site>>");
				catsAction.click(CustomRules.locatorPresentInSite(website+".Ticket.Apply",this.ormData));
				Thread.sleep(3000);
		    }*/

	 /*   @And("^Verify Promo Code details on Payment page$")
	    public void Verify_Promo_Code_details_on_Payment_page() throws Throwable {
	    	Thread.sleep(3000);
	    	catsAction.waitUntilElementDisplay(CustomRules.locatorPresentInSite(website+".Payment.coupondiscount",this.ormData), "30");
	    	catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Payment.coupondiscount",this.ormData));
	    	
	    }*/
	    @Then("^User empty minicart$")
			public void user_empty_minicart_if_product_were_there() throws Throwable {	
				try{	catsAction.pageLoadWait();
				Thread.sleep(10000);
					if(getDriver().findElementByXPath("//div[@class='chevronDown'][@tabindex=0]").isDisplayed())
					{   
						Thread.sleep(4000);
						catsAction.clickJS("//div[@class='chevronDown'][@tabindex=0]");
					}
				}catch(Exception e)
				{
					System.out.println("Minicart already expanded");
				}

				List<WebElement> noOfProduct_MiniCart = getDriver().findElementsByXPath(catsVariable.getORM(website+".Booking.DeleteIcon").getXpath()); 

				System.out.println("noOfProduct_MiniCart: "+noOfProduct_MiniCart.size());

				for(int i=0; i<noOfProduct_MiniCart.size();i++)
				{
					catsAction.click(CustomRules.locatorPresentInSite(website+".Booking.DeleteIcon",this.ormData));
					Thread.sleep(3000);
					catsAction.click(CustomRules.locatorPresentInSite(website+".Booking.ConfirmDelete",this.ormData));
					Thread.sleep(3000);
				}
				System.out.println("noOfProduct_MiniCart: "+noOfProduct_MiniCart);

	}
	//-----------------------------------------

	@When("^User clicks on main Menu Experiences item and select \"([^\"]*)\"$")
	public void user_clicks_on_main_menu_experiences_item_and_select_something(String subMenuItem) throws Throwable {
		System.out.println("user is clicking experience tab");
		System.out.println("user is clicking experience tab sub Menu item" +subMenuItem);
		Thread.sleep(3000);
		catsAction.hoverNClickSubItem(CustomRules.locatorPresentInSite(website + ".HomePage.GlobalHeaderMenuBarlistExperience",this.ormData),subMenuItem);
		Thread.sleep(5000);
	}


	@When("^User navigate to PLP throught experience option for selecting date to Book product$")
	public void user_navigate_to_plp_throught_experience_option_for_selecting_date_to_book_product() throws Throwable {
		Thread.sleep(10000);

		// System.out.println("ORM value  .........."+catsVariable.getORM(website + ".HomePage.BookNowButtonList").getXpath());

		String buttonList =catsVariable.getORM(website + ".HomePage.BookNowButtonList").getXpath();

		System.out.println("ormValue  .........."+buttonList);

		//	 List<WebElement> ButtonList2 = getDriver().findElements(By.xpath("//div[@class='buy-ticket-cta']/button"));
		List<WebElement> ButtonList1 = getDriver().findElements(By.xpath(buttonList));

		System.out.println("button count .........."+ButtonList1.size());
		for (int i=1; i<=ButtonList1.size();i++)
		{

			catsAction.click("(//div[@class='buy-ticket-cta']/button)["+i+"]");
			System.out.println("button is clicked...");
			Thread.sleep(6000);
			catsAction.waitUntilElementDisplay(website + ".BookNowOverlay.SelectDateOverlay", "30");
			catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website + ".BookNowOverlay.SelectDateOverlay",this.ormData));

			if(dateSelection())
			{
				break;
			}

		}
		System.out.println("for loop done");

	}

	@And("^User click on discover More button$")
	public void user_click_on_discover_more_button() throws Throwable {
		List<WebElement> discoverMoreButtonList = getDriver().findElements(By.xpath("//div[@class='readMoreCTA']"));
		System.out.println("Total no of links Available: "+discoverMoreButtonList.size());
		for (int i = 1; i <=discoverMoreButtonList.size(); i++) 
		{
			catsAction.click("(//div[@class='readMoreCTA'])["+i+"]");
			Thread.sleep(3000);
			catsAction.scrollDownByOffset("350");
			Thread.sleep(5000);
			catsAction.waitUntilElementDisplay(website+".PDPbook.BookNow", "40");
			Thread.sleep(5000);
			catsAction.clickJS(website+".PDPbook.BookNow");

			if (dateSelection())
			{
				break;

			} 
			else
			{
				catsAction.navigateBack();
			}

		}
	}

	@And("^User select country of issue$")
	public void user_select_country_of_issue() throws Throwable {
		catsAction.clickJS(CustomRules.locatorPresentInSite(website+".BookNowOverlay.SelectCountryToIssue",this.ormData));
		catsAction.clickJS(CustomRules.locatorPresentInSite(website+".BookNowOverlay.SelectCountryToIssueOption",this.ormData));
	}

	@And("^User click on Terms and condition checkbox$")
	public void user_click_on_terms_and_condition_checkbox() throws Throwable {
		catsAction.clickJS(CustomRules.locatorPresentInSite(website+".BookNowOverlay.TermsAndConditionCheckBox",this.ormData));
	}

	@And("^User click on Add to cart Button on select Date Overlay$")
	public void user_click_on_add_to_cart_button_on_select_date_overlay() throws Throwable {
		catsAction.clickJS(CustomRules.locatorPresentInSite(website+".BookNowOverlay.AddToCartButton",this.ormData));
	}

	@And("^User click on Proceed to checkout Button on select Date Overlay$")
	public void user_click_on_proceed_to_checkout_button_on_select_date_overlay() throws Throwable {
		catsAction.clickJS(CustomRules.locatorPresentInSite(website+".BookNowOverlay.ProceedToCheckoutButton",this.ormData));
	}

	@And("^Verify user Navigate to Booking Page and Minicart is present$")
	public void verify_user_navigate_to_booking_page_and_minicart_is_present() throws Throwable {

		catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Booking.MiniCart",this.ormData));
	}

	@And("^user verifies the product amount listed on cart$")
	public void user_verifies_the_product_amount_listed_on_cart() throws Throwable {
		Thread.sleep(2000);
		catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Booking.MinicartValue",this.ormData));
	}

	@When("^user click on Check out button of mini cart$")
	public void user_click_on_check_out_button_of_mini_cart() throws Throwable {
		catsAction.clickJS(CustomRules.locatorPresentInSite(website+".Booking.MiniCartCheckoutButton",this.ormData));
	}

	@Then("^Verfy User Navigate to Mypayment page and invoice Summary is present$")
	public void verfy_user_navigate_to_mypayment_page_and_invoice_summary_is_present() throws Throwable {
		catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".MyPayment.InvoiceSummaryTitle",this.ormData));
	}

	@And("^User click on proceed to payment Button$")
	public void user_click_on_proceed_to_payment_button() throws Throwable {
		catsAction.scrollDownByOffset("300");
		catsAction.waitUntilElementDisplay(website+".MyPayment.ProceedToPaymentButton", "30");
		catsAction.clickJS(CustomRules.locatorPresentInSite(website+".MyPayment.ProceedToPaymentButton",this.ormData));
	}

	@Then("^verify user navigate to login page$")
	public void verify_user_navigate_to_login_page() throws Throwable {
		catsAction.waitUntilElementDisplay(website+".CheckIn.EmailId", "30");
		catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".CheckIn.EmailId",this.ormData));
	}
	@And("^verify user Navigate to payment page$")
	public void verify_user_navigate_to_payment_page() throws Throwable {
		Thread.sleep(3000);
		getDriver().getCurrentUrl().contains("mypayment");

	}

	@And("^click on Confirm order button$")
	public void click_on_confirm_order_button() throws Throwable {
		catsAction.clickJS(CustomRules.locatorPresentInSite(website+".MyPayment.ConfirmOrderButton",this.ormData));

	}

	@And("^User select feature \"([^\"]*)\" and click on book now button.$")
	public void user_select_feature_something_and_click_on_book_now_button(String featureName) throws Throwable {
		Thread.sleep(6000);
		System.out.println("feature to search" +featureName);
		clickBookNowButtonOfGivenFeature(featureName);
		dateSelection();
	}

	@Then("^Verify chose your ticket Overlay should open$")
	public void verify_chose_your_ticket_overlay_should_open() throws Throwable {
		Thread.sleep(2000);
		catsAction.waitUntilElementDisplay(website + ".BookNowOverlay.SelectDateOverlay", "30");
		catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website + ".BookNowOverlay.SelectDateOverlay",this.ormData));
	}

	@And("^Verify recommended tab should come$")
	public void verify_recommended_tab_should_come() throws Throwable {
		catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website + ".Booking.RecommendedTab",this.ormData));
	}

	@And("^User should verify recommended list and select recommended list option$")
	public void user_should_verify_recommended_list_and_select_recommended_list_option() throws Throwable {
		catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website + ".Booking.RecommendedItemList",this.ormData));
		Thread.sleep(3000);
		catsAction.click(CustomRules.locatorPresentInSite(website + ".Booking.RecommendedItemSelectButton",this.ormData));

	}

	@When("^User click on add to cart icon on home page$")
	public void user_click_on_add_to_cart_icon_on_home_page() throws Throwable {
		catsAction.waitUntilElementDisplay(CustomRules.locatorPresentInSite(website + ".HomePage.cartIcon",this.ormData),"60");
		catsAction.clickJS(CustomRules.locatorPresentInSite(website + ".HomePage.cartIcon",this.ormData));

	}

	@Then("^verify user navigate to my Payment page and click on Buy Experiences button$")
	public void verify_user_navigate_to_my_payment_page_and_click_on_buy_experiences_button() throws Throwable {

		catsAction.waitUntilElementDisplay(website + ".MyPayment.NoTicketInCartLabel", "30");
		catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website + ".MyPayment.NoTicketInCartLabel", this.ormData));
		catsAction.click(CustomRules.locatorPresentInSite(website + ".MyPayment.BuyExperience",this.ormData));
	}

	@And("^Verify and select \"([^\"]*)\" Voucher tab is present on Booking page$")
	public void verify_and_select_something_voucher_tab_is_present_on_booking_page(String tabOption) throws Throwable {
		verifyAndSelectTabOption(tabOption);
	}

	@When("^User select item in gift vouher list option$")
	public void user_select_item_in_gift_vouher_list_option() throws Throwable {

		catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website + ".Booking.GiftVoucherItemSelectButton", this.ormData));
		catsAction.clickJS(CustomRules.locatorPresentInSite(website + ".Booking.GiftVoucherItemSelectButton",this.ormData));

	}
	@When("^User select item in MOTORSPORTS list option$")
	public void user_select_item_in_motorsports_list_option() throws Throwable {
		catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website + ".Booking.MotorSportItemSelectButton", this.ormData));
		catsAction.clickJS(CustomRules.locatorPresentInSite(website + ".Booking.MotorSportItemSelectButton",this.ormData));

	}

	@Then("^User should select available date and time Slot$")
	public void user_should_select_available_date_and_time_slot() throws Throwable {
		Thread.sleep(6000);
		dateSelection();
		Thread.sleep(5000);
		try{
			if(getDriver().findElementByXPath(catsVariable.getORM(CustomRules.locatorPresentInSite(website+".Overlay.IncreaseTicketDiv",this.ormData)).getXpath()).isDisplayed())
			{   
				System.out.println("Add Tickets");
				Thread.sleep(2000);
				catsAction.click(CustomRules.locatorPresentInSite(website+".Overlay.IncreaseTicket",this.ormData));
			}
		}catch(Exception e)
		{
			System.out.println("Tickets Already added");
		}

	}


	@And("^User click on bookNow button$")
	public void user_click_on_booknow_button() throws Throwable {
		Thread.sleep(2000);
		catsAction.waitUntilElementDisplay(website + ".PDPbook.BookNow", "30");

		catsAction.click(website + ".PDPbook.BookNow");

		dateSelection();
		System.out.println("check---------" + dateSelection());

	}

	@Then("^User select quantity$")
	public void user_select_quantity() throws Throwable {
		catsAction.waitUntilElementDisplay(CustomRules.locatorPresentInSite(website+".BookNowOverlay.Quantity",this.ormData),"60");
		Thread.sleep(2000);
		catsAction.click(CustomRules.locatorPresentInSite(website+".BookNowOverlay.Quantity",this.ormData));

	}

	@And("^User verify Proceed to checkout Button disabled$")
	public void User_verify_Proceed_to_checkout_Button_disabled() throws Throwable {
		catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".BookNowOverlay.ProceedToCheckoutButtonDisabled",this.ormData));
	}

	@And("^User click on discover More button for Item that has recommneded items$")
	public void User_click_on_discover_More_button_for_Item_that_has_recommneded_items() throws Throwable {

		catsAction.scrollDownByOffset("300");
		Thread.sleep(3000);
		catsAction.click(CustomRules.locatorPresentInSite(website+".PDPbook.DiscoverMoreRecommended",this.ormData));
		catsAction.scrollDownByOffset("350");
		Thread.sleep(5000);
		catsAction.waitUntilElementDisplay(website+".PDPbook.BookNow", "40");
		Thread.sleep(5000);
		catsAction.clickJS(website+".PDPbook.BookNow");
		Thread.sleep(3000);
		dateSelection();
	}

	@When("^User clicks on main Menu Formula1 item and select \"([^\"]*)\"$")
	public void user_clicks_on_main_menu_Formula1_item_and_select_something(String subMenuItem) throws Throwable {
		System.out.println("user is clicking Formula1 tab");
		System.out.println("user is clicking Formula1 tab sub Menu item" +subMenuItem);
		Thread.sleep(3000);
		catsAction.hoverNClickSubItem(CustomRules.locatorPresentInSite(website + ".HomePage.GlobalHeaderMenuBarlistFormula1",this.ormData),subMenuItem);
		Thread.sleep(5000);
	}

	@And("^User select Non-Dated feature \"([^\"]*)\" and click on book now button.$")
	public void user_select_NonDated_feature_something_and_click_on_book_now_button(String featureName) throws Throwable {
		Thread.sleep(6000);
		System.out.println("feature to search" +featureName);
		clickBookNowButtonOfGivenFeature(featureName);
		Thread.sleep(6000);

	}




	@And("^User click on discover More button and then Book As Gift$")
	public void user_click_on_discover_more_button_and_then_book_as_gift() throws Throwable {

		catsAction.click(CustomRules.locatorPresentInSite(website+".PDPbook.DiscoverMore",this.ormData));
		Thread.sleep(3000);
		catsAction.scrollDownByOffset("350");
		Thread.sleep(5000);
		catsAction.waitUntilElementDisplay(website+".PDPbook.BookAsGift", "40");
		Thread.sleep(5000);
		catsAction.clickJS(CustomRules.locatorPresentInSite(website+".PDPbook.BookAsGift",this.ormData));

	}

	@And("^User click on discover More button and naviagte to PDP$")
	public void user_click_on_discover_more_button_and_naviagte_to_pdp() throws Throwable {
		catsAction.click(CustomRules.locatorPresentInSite(website+".PDPbook.DiscoverMore",this.ormData));
		Thread.sleep(3000);
		catsAction.scrollDownByOffset("350");
		Thread.sleep(5000);
	}
	/*@Then("^User empty minicart$")
	public void user_empty_minicart_if_product_were_there() throws Throwable {    
		try{    catsAction.pageLoadWait();
		Thread.sleep(10000);





		if(getDriver().findElementByXPath("//div[@class='chevronDown'][@tabindex=0]").isDisplayed())
		{   
			Thread.sleep(4000);
			catsAction.clickJS("//div[@class='chevronDown'][@tabindex=0]");
		}
		}catch(Exception e)
		{
			System.out.println("Minicart already expanded");
		}



		List<WebElement> noOfProduct_MiniCart = getDriver().findElementsByXPath(catsVariable.getORM(website+".Booking.DeleteIcon").getXpath()); 



		System.out.println("noOfProduct_MiniCart: "+noOfProduct_MiniCart.size());



		for(int i=0; i<noOfProduct_MiniCart.size();i++)
		{
			catsAction.click(CustomRules.locatorPresentInSite(website+".Booking.DeleteIcon",this.ormData));
			Thread.sleep(3000);
			catsAction.click(CustomRules.locatorPresentInSite(website+".Booking.ConfirmDelete",this.ormData));
			Thread.sleep(3000);
		}
		System.out.println("noOfProduct_MiniCart: "+noOfProduct_MiniCart);

	}*/
	@And("^user apply PromoCode in Mini cart$")
	public void user_apply_PromoCode_in_Mini_cart() throws Throwable {
		catsAction.waitUntilElementDisplay(CustomRules.locatorPresentInSite(website+".Ticket.EnterPromoCode",this.ormData),"30");
		Thread.sleep(2000);
		catsAction.click(CustomRules.locatorPresentInSite(website+".Ticket.EnterPromoCode",this.ormData));
		Thread.sleep(2000);
		catsAction.enter(CustomRules.locatorPresentInSite(website+".Ticket.EnterPromoCode",this.ormData), "$MiralGlobal.Coupon.<<site>>");
		catsAction.click(CustomRules.locatorPresentInSite(website+".Ticket.Apply",this.ormData));
		Thread.sleep(3000);
	}
	@And("^Verify Promo Code details on Payment page$")
	public void Verify_Promo_Code_details_on_Payment_page() throws Throwable {
		Thread.sleep(3000);
		catsAction.waitUntilElementDisplay(CustomRules.locatorPresentInSite(website+".Payment.coupondiscount",this.ormData), "30");
		catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Payment.coupondiscount",this.ormData));

	}
	@When("^user remove promocode from invoice summary page$")
	public void remove_promocode_from_invoice_summary() throws Throwable
	{
		Thread.sleep(2000);
		catsAction.click(CustomRules.locatorPresentInSite(website+".Payment.removecoupon",this.ormData));



	}

	@And("^verify coupon removed from minicart$")
	public void verify_coupon_removed_from_minicart() throws Throwable
	{
		Thread.sleep(2000);
		catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Ticket.EnterPromoCode",this.ormData));
	}
	@When("^User select cross sell product from list$")
	public void user_select_cross_sell_product() throws Throwable {


		catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website + ".Booking.crosssellproductselectButon", this.ormData));
		catsAction.clickJS(CustomRules.locatorPresentInSite(website + ".Booking.crosssellproductselectButon",this.ormData));

	}
	@Then("^verify price will update if user select cross sell product with video$")
	public void price_will_update_if_user_select_cross_sell_product_with_video() throws Throwable {
		Thread.sleep(8000);
		String Amountwithvideo = getDriver().findElementByXPath(catsVariable.getORM(CustomRules.locatorPresentInSite(website+".Booking.TotalAmountOnCartOverlay",this.ormData)).getXpath()).getText()
				.replaceAll("\\.0*$", "").replaceAll("[A-Z]","");
		System.out.println("Amountwithvideo: "+Amountwithvideo);
		// click on no video check box
		catsAction.clickJS(CustomRules.locatorPresentInSite(website+".Booking.radiobuttonNoThanks",this.ormData));
		Thread.sleep(5000);

		String Amountwithoutvideo = getDriver().findElementByXPath(catsVariable.getORM(CustomRules.locatorPresentInSite(website+".Booking.TotalAmountOnCartOverlay",this.ormData)).getXpath()).getText()
				.replaceAll("\\.0*$", "").replaceAll("[A-Z]","");
		System.out.println("Amountwithoutvideo: "+Amountwithoutvideo); 
		System.out.println("Verify price updated   "+Amountwithvideo.equals(Amountwithoutvideo));
		if(!Amountwithvideo.equals(Amountwithoutvideo)){
			catsAction.reportResultPass("Amount updated ","true" ,Amountwithvideo, Amountwithoutvideo);
		}else{
			catsAction.reportResultFail("Amount updated ","true" ,Amountwithvideo, Amountwithoutvideo);

		}}



	@And("^verify Discount details should be displayed against products if product is eligible for any discount$")
	public void verify_discount_price() throws Throwable {
		Thread.sleep(5000);
		catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".BookNowOverlay.ProductBaseprice",this.ormData));


	}



	@And("^user click on booking page link in summary page$")
	public void user_click_on_booking_page_link_in_summary_page() throws Throwable {
		Thread.sleep(3000);
		catsAction.click(CustomRules.locatorPresentInSite(website+".Booking.BookingPagelink",this.ormData));


	}

	

	@When("^User validate \"([^\"]*)\" PLP products")
	public void user_validate_PLP_products(String url) throws Throwable{		
		catsAction.launchSite(url);
		//catsAction.navigateTo("https://fe-sit3-apimgmt-service.azure-api.net/v1/ymcproductsprod");
		//Thread.sleep(6000);
		//String apiData=getDriver().getPageSource();
		
		/* XmlReader xmlRead= new XmlReader(getDriver().getPageSource());
		 String apiData= xmlRead.getNodeValue("/html/body/pre").get(0);
		 JSONObject obj = new JSONObject(apiData);
		String jsonToXml=XML.toString(obj);
		System.out.println(jsonToXml);
		catsAction.navigateTo(url);
		XmlReader productData= new XmlReader(getDriver().getPageSource());*/
		
		Thread.sleep(6000);
		catsAction.clickJS(CustomRules.locatorPresentInSite(website+".Language.CookieAccept",this.ormData));
		try{
			if(getDriver().findElementByXPath("//*[@class='load-more-cta']/button") != null){
				catsAction.clickJS("//*[@class='load-more-cta']/button");
			}
		}catch (Exception e) {
			System.out.println(e);
		}


		LinkedList<String> plpProductNameList= new LinkedList<>();
		List<WebElement> productNameEle= getDriver().findElementsByXPath("//h3[@class='heading-5']");

		for(WebElement element : productNameEle){
			plpProductNameList.add( element.getText());
			//plpProductDetailUrl.add(element.getAttribute(arg0))
		}
		
		for(String productName : plpProductNameList){
			System.out.println("Product Name valdation ::::::::::::::::::::::::"+ productName);
			catsAction.reportResultInfo("Product overlay validation for"+productName, productName, productName, productName);
			try{
				clickBookNowButtonOfGivenFeature(productName);
				Thread.sleep(20000);
			}catch (Exception e) {
				catsAction.reportResultWarn(productName, productName, productName, e.toString());
			}
			
//			System.out.println("Overlay Name::::::::::::"+getDriver().findElementByXPath(".//div[@class='overlay-wrapper']").getAttribute("class"));
			
			System.out.println("element there");
			
			if(getDriver().findElementsByXPath(".//div[@class='overlay-wrapper']").size() <= 0 && getDriver().getCurrentUrl().equals(url)){
				System.out.println(":::::::::::::::::::Inside retry Option:::::::::::::::::::::");
				catsAction.navigateTo(url);
				Thread.sleep(12000);
				try{
					if(getDriver().findElementByXPath("//*[@class='load-more-cta']/button") != null){
						catsAction.clickJS("//*[@class='load-more-cta']/button");
					}
				}catch (Exception e) {
					System.out.println(e);
				}
				clickBookNowButtonOfGivenFeature(productName);
				Thread.sleep(20000);
			}	
			
			if(getDriver().getCurrentUrl().equals(url)){
				Thread.sleep(3000);
				catsAction.waitUntilElementDisplay(".//*[@class='overlay-wrapper']", "60");
				catsAction.verifyElementPresent("//*[@class='t-n-c--label']");
				catsAction.verifyElementPresent("//*[@class='amount']");
				/*String productId=getDriver().findElementByXPath("").getAttribute("data-product");
				try{
					int ticketPrice=Integer.parseInt(getDriver().findElementByXPath(".//div[@class='amount']/h3")
							.getText().replace("AED", "").replace(",", "").trim());
					int apiTicketPrice=Integer.parseInt(productData.getNodeValue("/productlist/product/id[contains(text(),'"
							+productId+"')]/parent::product/price/gross").get(0));
					if(ticketPrice==apiTicketPrice){
						catsAction.reportResultPass("validate amount from API and Screen", String.valueOf(ticketPrice)
								, String.valueOf(apiTicketPrice), String.valueOf(apiTicketPrice));
					}else{
						catsAction.reportResultFail("validate amount from API and Screen", String.valueOf(ticketPrice)
								, String.valueOf(apiTicketPrice), String.valueOf(apiTicketPrice));
					}
				}catch (Exception e) {
					System.out.println(e);
				}*/
				
				catsAction.clickJS(".//*[@class='overlay--close-button']");
			}else{
				Thread.sleep(10000);
				catsAction.reportResultInfo("Product navigated to 3 party page"+productName, productName, productName, productName);
				//getDriver().get(url);
				catsAction.navigateTo(url);
				Thread.sleep(12000);
				try{
					if(getDriver().findElementByXPath("//*[@class='load-more-cta']/button") != null){
						catsAction.clickJS("//*[@class='load-more-cta']/button");
					}
				}catch (Exception e) {
					System.out.println(e);
				}
			}
		}
		getDriver().getCurrentUrl();
	}

	@When("^User validate \"([^\"]*)\" PDP products")
	public void user_validate_PDP_products(String url) throws Throwable{
		catsAction.launchSite(url);
		Thread.sleep(6000);
		catsAction.clickJS(CustomRules.locatorPresentInSite(website+".Language.CookieAccept",this.ormData));
		try{
			if(getDriver().findElementByXPath("//*[@class='load-more-cta']/button") != null){
				catsAction.clickJS("//*[@class='load-more-cta']/button");
			}
		}catch (Exception e) {
			System.out.println(e);
		}


		LinkedList<String> plpProductDetailUrl= new LinkedList<>();
		List<WebElement> productDetailEle= getDriver().findElementsByXPath("//*[@class='readMoreCTA']/a");

		for (WebElement elementDetail : productDetailEle){
			plpProductDetailUrl.add(elementDetail.getAttribute("href"));
		}
		
		for(String urlPDP: plpProductDetailUrl){
			catsAction.navigateTo(urlPDP);
			catsAction.scrollDownByOffset("200");
			catsAction.reportResultInfo("Product overlay validation for"+urlPDP, urlPDP, urlPDP, urlPDP);
			Thread.sleep(3000);
			catsAction.clickJS(website+".PDPbook.BookNow");
			Thread.sleep(20000);
			if(getDriver().getCurrentUrl().equals(urlPDP)){
				catsAction.waitUntilElementDisplay(".//*[@class='overlay-wrapper']", "60");
				catsAction.verifyElementPresent("//*[@class='t-n-c--label']");
				catsAction.verifyElementPresent("//*[@class='amount']");
				//getDriver().findElementByXPath("//*[@class='amount']/h3").getText().replace("AED", "").trim();
				catsAction.clickJS(".//*[@class='overlay--close-button']");
			}else{
				Thread.sleep(10000);
				catsAction.reportResultInfo("Product navigated to 3 party page"+urlPDP, urlPDP, urlPDP, urlPDP);
				//getDriver().get(url);
				catsAction.navigateTo(urlPDP);
			}
		}

		System.out.println(plpProductDetailUrl);
		getDriver().getCurrentUrl();
	}


}







