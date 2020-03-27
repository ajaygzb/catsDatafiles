package cats.selenium.bdd.stepdef;

import java.io.IOException;

import com.sapient.qa.cats.core.framework.CATSCucumberConfig;

import cucumber.api.Scenario;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class YIRegression extends  CATSCucumberConfig
{
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
	
	
          
      
  @Then("^header should be sticky and logo should be present$")
  public void header_should_be_sticky_and_logo_should_be_present() throws Throwable
     { 
	  catsAction.scrollPageUp();
	  Thread.sleep(2000);
 	catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Header.Logo",this.ormData));
} 
 
	  @Then("^book CTA should be present on sticky header$")
	  public void book_CTA_should_be_present_on_sticky_header() throws Throwable
	     { 
		  Thread.sleep(2000);
	catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Header.BookPackageCTA",this.ormData));

	     }
@Then("^primary links should be present$")
	  public void primary_links_should_be_present() throws Throwable
	  { 
	Thread.sleep(2000);
catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Header.PrimaryLinks",this.ormData));

	  } 
@When("^User hovers on things to do link in header$")
public void User_hovers_on_things_to_do_link_in_header() throws Throwable {
	Thread.sleep(2000);
catsAction.hover(CustomRules.locatorPresentInSite(website+".Header.Thingstodo_link",this.ormData));

		 	      
		         }
@Then("mega nav one should open up")
public void mega_nav_one_should_open_up() throws Throwable
		        { 
	Thread.sleep(2000);
catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Header.MegaNav",this.ormData));
		        }
		    
		 	   
@When("User hovers on Places to stay link in header")
		     public void User_hovers_on_Places_to_stay_link_in_header() throws Throwable {
	Thread.sleep(2000);
catsAction.hover(CustomRules.locatorPresentInSite(website+".Header.PlacesToStay_link",this.ormData));

		 	 
}
@Then("mega nav two should open up")
public void mega_nav_two_should_open_up() throws Throwable
{ 
	Thread.sleep(2000);
catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Header.MegaNav",this.ormData));

} 

@When("User clicks on city link")
public void User_clicks_on_city_link() {
	  
  	catsAction.scrollDownByOffset("600");
  	
catsAction.click(CustomRules.locatorPresentInSite(website+".Listing_Page.CityButton",this.ormData));
}

@Then("^it should open up listing page$")
  public void it_should_open_up_listing_page() throws Throwable {
  		Thread.sleep(3000);
  		catsAction.pageLoadWait();
  		catsAction.scrollDownByOffset("650");
  	 
  }





@When("User verify tile heading")
public void User_verify_tile_heading() throws Throwable {

catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Listing_Page.TileHeading",this.ormData));


}

@Then("^tile heading should be present$")
public void tile_heading_should_be_present() throws Throwable {
	Thread.sleep(3000);
	

}

@When("User verify tile subtext")
public void User_verify_tile_subtext() throws Throwable {

catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Listing_Page.TileText",this.ormData));


}

//@Then("^tile subtext should be present$")
//public void tile_subtext_should_be_present() throws Throwable {
//	Thread.sleep(3000);
//	



@When("User verify tile wishlist icon")
public void User_verify_tile_wishlist_icon() throws Throwable {
catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Listing_Page.WishlistIc",this.ormData));


}

@Then("^tile wishlist icon should be present$")
public void tile_wishlist_icon_should_be_present() throws Throwable {
	Thread.sleep(3000);
	

}

@When("User clicks on discover link")
public void User_clicks_on_discover_link() throws Throwable {

catsAction.click(CustomRules.locatorPresentInSite(website+".Listing_Page.DiscoverLink",this.ormData));


}

@Then("^it should navigate to hotel details page$")
public void it_should_navigate_to_hotel_details_page() throws Throwable {
	Thread.sleep(3000);
	catsAction.pageLoadWait();

}

@When("User verify hero panel")
public void User_verify_hero_panel() throws Throwable {

catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Listing_Page.HotelImage",this.ormData));


}

@Then("^hero panel should be present$")
public void hero_panel_should_be_present() throws Throwable {
	Thread.sleep(3000);
	catsAction.pageLoadWait();
	catsAction.scrollDownByOffset("200");

}

@When("User verify wishlist icon")
public void User_verify_wishlist_icon() throws Throwable {

catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Listing_Page.HotelWishlist",this.ormData));


}

@Then("^wishlist icon should be present in hero$")
public void wishlist_icon_should_be_present_in_hero() throws Throwable {
	Thread.sleep(3000);
	catsAction.pageLoadWait();

}

@When("^User clicks on Offers link in header$")
public void User_clicks_on_Offers_link_in_header() {
catsAction.click(CustomRules.locatorPresentInSite(website+".OfferPage.Offers",this.ormData));

catsAction.pageLoadWait();
catsAction.scrollDownByOffset("1000");


}
@Then("^User should land on Offers page$")
public void User_should_land_on_Offers_page()
{ 
catsAction.pageLoadWait();
catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".OfferPage.OfferFeatureTile",this.ormData));

}


@When("^User checks offer name$")
public void User_checks_offer_name() {
catsAction.click(CustomRules.locatorPresentInSite(website+".OfferPage.OfferFeatureTile",this.ormData));




}
@Then("^User is able to see offer name$")
public void user_is_able_to_see_offer_name()
{ 
catsAction.pageLoadWait();
catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".OfferPage.OfferName",this.ormData));

}

@When("^User checks offer venue$")
public void User_checks_offer_venue() {
catsAction.click(CustomRules.locatorPresentInSite(website+".OfferPage.OfferFeatureTile",this.ormData));




}
@Then("^User is able to see offer venue$")
public void user_is_able_to_see_offer_venue()
{ 
catsAction.pageLoadWait();
catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".OfferPage.OfferVenue",this.ormData));
}
@When("^User checks offer description$")
public void User_checks_offer_description() {
catsAction.click(CustomRules.locatorPresentInSite(website+".OfferPage.OfferFeatureTile",this.ormData));
}
@Then("^User is able to see offer description$")
public void user_is_able_to_see_offer_description()
{ 
catsAction.pageLoadWait();
catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".OfferPage.OfferDescription",this.ormData));
}
@When("User clicks on YAS Vibes link")
public void User_clicks_on_YAS_Vibes_link() {

catsAction.scrollDownByOffset("600");
catsAction.click(CustomRules.locatorPresentInSite(website+".TripAdvisor.YasButton",this.ormData));
catsAction.pageLoadWait();

}
@Then("^it should open up a Hotel listing page$")
public void it_should_open_up_a_Hotel_listing_page() throws Throwable {
	Thread.sleep(3000);
	catsAction.pageLoadWait();
}

@When("User clicks on any hotel")
public void User_clicks_on_any_hotel() throws Throwable {
catsAction.scrollDownByOffset("1000");
catsAction.click(CustomRules.locatorPresentInSite(website+".TripAdvisor.HotelLink",this.ormData));

}

@Then("^It should be able to open the hotel page$")
public void It_should_be_able_to_open_the_hotel_page() throws Throwable {
Thread.sleep(3000);
catsAction.pageLoadWait();

}

@When("User clicks on tripad icon")
public void User_clicks_on_tripad_icon() {
catsAction.scrollDownByOffset("200");
catsAction.click(CustomRules.locatorPresentInSite(website+".TripAdvisor.Tripadicon",this.ormData));
}
@Then("^it should open up a tripad popup")
public void it_should_open_up_a_tripad_popup() throws Throwable {
Thread.sleep(3000);
catsAction.pageLoadWait();

}

@When("Verify Travel rating")
public void Verify_Travel_rating() {
catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".TripAdvisor.TripadRating",this.ormData));
}

@Then("^Popup should have hotel ratings")
public void Popup_should_have_hotel_ratings() throws Throwable {
Thread.sleep(3000);
catsAction.pageLoadWait();

}

@When("^User clicks on Event  link$")
public void user_clicks_on_event_link() throws Throwable
{
	catsAction.waitUntilElementDisplay(CustomRules.locatorPresentInSite(website+".Event_Search.Explore",this.ormData),"30");

	catsAction.scrollPageDown();
	catsAction.click(CustomRules.locatorPresentInSite(website+".Event_Search.Explore",this.ormData));
}

@Then("^it should open up a listing page$")
public void it_should_open_up_a_listing_page() throws Throwable {
	Thread.sleep(3000);
	catsAction.pageLoadWait();
	catsAction.scrollDownByOffset("750");
 }
@When("User fills in search details")
public void User_fills_in_search_details() throws Throwable {

catsAction.pageLoadWait();
catsAction.click(CustomRules.locatorPresentInSite(website+".Event_Search.Bvenue",this.ormData));
Thread.sleep(3000);
catsAction.click(CustomRules.locatorPresentInSite(website+".Event_Search.FW",this.ormData));
Thread.sleep(3000);
catsAction.click(CustomRules.locatorPresentInSite(website+".Event_Search.BDate",this.ormData));
Thread.sleep(3000);
catsAction.click(CustomRules.locatorPresentInSite(website+".Event_Search.NTomorrow",this.ormData));

}

@Then("^It should be able to select venue and date$")
public void It_should_be_able_to_select_venue_and_date() throws Throwable {
Thread.sleep(3000);
catsAction.pageLoadWait();

}

@When("User changes dates from calendar")
public void User_changes_dates_from_calendar() throws Throwable {
catsAction.pageLoadWait();
catsAction.clickJS(CustomRules.locatorPresentInSite(website+".Event_Search.Bvenue",this.ormData));
Thread.sleep(2000);
catsAction.clickJS(CustomRules.locatorPresentInSite(website+".Event_Search.WBWDD",this.ormData));
Thread.sleep(2000);
catsAction.clickJS(CustomRules.locatorPresentInSite(website+".Event_Search.BDate",this.ormData));
Thread.sleep(2000);
catsAction.clickJS(CustomRules.locatorPresentInSite(website+".Event_Search.DateRangeDD",this.ormData));
Thread.sleep(2000);
catsAction.clickJS(CustomRules.locatorPresentInSite(website+".Event_Search.Date1",this.ormData));
}

@Then("^It should be able to select venue and calendar date range$")
public void It_should_be_able_to_select_venue_and_calendar_date_range() throws Throwable {
Thread.sleep(3000);
catsAction.pageLoadWait();

}
@When("User clicks on search button")
public void User_clicks_on_search_button() {
catsAction.clickJS(CustomRules.locatorPresentInSite(website+".Event_Search.SearchButton",this.ormData));
}
@Then("^it should submit successfully$")
public void it_should_submit_successfully() throws Throwable {
Thread.sleep(3000);
catsAction.pageLoadWait();

}

@When("User hover on Things to do link")
public void User_hover_on_Things_to_do_link() throws InterruptedException {
Thread.sleep(5000);
catsAction.hover(CustomRules.locatorPresentInSite(website+".Home.Header_Thingstodo",this.ormData));



}
@Then("^Things to do overlay should open up$")
public void Things_to_do_overlay_should_open_up()
{ 
catsAction.pageLoadWait();
catsAction.click(CustomRules.locatorPresentInSite(website+".Home.Link1",this.ormData));

}
@When("User hover on Places to stay link")
public void User_hover_on_Places_to_stay_link() throws InterruptedException {
Thread.sleep(5000);
catsAction.hover(CustomRules.locatorPresentInSite(website+".Home.Header_Placestostay",this.ormData));
}
@Then("^Places to stay overlay should open up$")
public void Places_to_stay_overlay_should_open_up()
{ 
catsAction.pageLoadWait();
catsAction.click(CustomRules.locatorPresentInSite(website+".Home.Link2",this.ormData));

}

@When("User verify footer for guest user")
public void User_verify_footer_for_guest_user() {

catsAction.scrollDownByOffset("4000");
catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Footer.Footer_Guest",this.ormData));
}
@Then("^Footer must be present$")
public void Footer_must_be_present() throws Throwable {
	Thread.sleep(3000);
	catsAction.pageLoadWait();
	catsAction.scrollUpByOffset("4000");	    	 
}

@Then("^it should redirect to login page$")
public void it_should_redirect_to_login_page() throws Throwable {
Thread.sleep(3000);
catsAction.scrollDownByOffset("500");
}


@Then("^it should show user name$")
public void tile_subtext_should_be_present() throws Throwable {
Thread.sleep(3000);
}

@When("User verify footer for loggedin user")
public void User_verify_footer_for_loggedin_user() throws Throwable {

catsAction.scrollDownByOffset("4000");
catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Footer.Footer_Guest",this.ormData));

}

@Then("^footer should be available$")
public void footer_should_be_available() throws Throwable {
Thread.sleep(3000);
}
}
