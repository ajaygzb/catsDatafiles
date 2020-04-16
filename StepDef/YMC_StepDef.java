package cats.selenium.bdd.stepdef;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebElement;
import com.sapient.qa.cats.core.framework.CATSCucumberConfig;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import de.retest.web.selenium.By;

public class YMC_StepDef extends CATSCucumberConfig {


		public String website;
		public ExcelReader ormData;
		public String site;
		

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
		  
		  
		  
		  @When("^user click on Venue in Header$")
		    public void user_click_on_venue_in_header() throws Throwable {
			  Thread.sleep(3000);
				catsAction.click(CustomRules.locatorPresentInSite(website+".Header.Venue",this.ormData));
				catsAction.pageLoadWait();
				
		  }
		  
		  @Then("^user click on card component on landing page$")
		    public void user_click_on_card_component_on_landing_page() throws Throwable {
			    catsAction.pageLoadWait(); 
			    catsAction.scrollDownByOffset("600");
			    Thread.sleep(5000);    
				catsAction.click(CustomRules.locatorPresentInSite(website+".Header.Card_LandingPage",this.ormData));
				catsAction.pageLoadWait();
		  }
		  
		  @Then("^user click on card component on listing page$")
		    public void user_click_on_card_component_on_listing_page() throws Throwable {
			    catsAction.pageLoadWait(); 
			    catsAction.scrollDownByOffset("600");
			    Thread.sleep(5000);
				catsAction.click(CustomRules.locatorPresentInSite(website+".Header.Card_ListingPage",this.ormData));
				catsAction.pageLoadWait();
		  }
		  
		  @Then("^user land on detail Page$")
		    public void user_land_on_detail_page() throws Throwable {
			     Thread.sleep(3000);
			     catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Header.OverView",this.ormData));
		  }
	
		  
		  @Then("^user verify on My Profile button present under Profile icon is present$")
		    public void user_verify_on_my_profile_button_present_under_profile_icon_is_present() throws Throwable {
			  catsAction.pageLoadWait();
			  Thread.sleep(10000);
			  catsAction.clickJS(CustomRules.locatorPresentInSite(website + ".UserProfile.Profile",this.ormData));
			  catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website + ".UserProfile.MyProfile",this.ormData));
			  catsAction.pageLoadWait();
				Thread.sleep(3000);
		  }
		  
		   @Then("^verify user logout successfully$")
		    public void verify_user_logout_successfully() throws Throwable {
			   catsAction.pageLoadWait();
			   Thread.sleep(10000);
				catsAction.click(CustomRules.locatorPresentInSite(website + ".Login.Profile",this.ormData));
				catsAction.verifyElementNotPresent(CustomRules.locatorPresentInSite(website + ".UserProfile.MyProfile",this.ormData));
			
		  }
		  
		  @Then("^user should get error msg for wrong details$")
		    public void user_should_get_error_msg_for_wrong_details() throws Throwable {
			  Thread.sleep(3000);
		    	catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website + ".UserProfile.errorForRegistration",this.ormData));
			
		  }
		  
		  @Then("^user increase and decrese tickets in minicart$")
		    public void user_increase_and_decrese_tickets_in_minicart() throws Throwable {
			  
			  String TicketPresent= getDriver().findElementByXPath(catsVariable.getORM(CustomRules.locatorPresentInSite(website+".Booking.Minicart_NoOfTickets",this.ormData)).getXpath()).getAttribute("value");
			  System.out.println("TicketPresent: "+TicketPresent);
			  int noOfTicketsPresent= Integer.parseInt(TicketPresent);
			      
			 
				  catsAction.click(CustomRules.locatorPresentInSite(website+".Booking.Minicart_IncreaseButton",this.ormData));
				  String TicketUpdated= getDriver().findElementByXPath(catsVariable.getORM(CustomRules.locatorPresentInSite(website+".Booking.Minicart_NoOfTickets",this.ormData)).getXpath()).getAttribute("value");
				  System.out.println("TicketUpdated: "+TicketUpdated);
				  
				  int noOfUpdatedTickets= noOfTicketsPresent+1;
				  String checkUpdatedValue = Integer.toString(noOfUpdatedTickets);
				  catsAction.verifyVariableValue(TicketUpdated, checkUpdatedValue);
				  
				  Thread.sleep(2000);
				  if(noOfTicketsPresent>0)
				  {
				    int noOfTicketsbeforeDecrease = Integer.parseInt(TicketUpdated);
				    System.out.println("noOfTicketsbeforeDecrease:"+noOfTicketsbeforeDecrease);
				    catsAction.click(CustomRules.locatorPresentInSite(website+".Booking.Minicart_DecreaseButton",this.ormData));
					
				    String TicketUpdatedAfterDecrease= getDriver().findElementByXPath(catsVariable.getORM(CustomRules.locatorPresentInSite(website+".Booking.Minicart_NoOfTickets",this.ormData)).getXpath()).getAttribute("value");
					  System.out.println("TicketUpdatedAfterDecrease: "+TicketUpdatedAfterDecrease);
					  
					  int noOfUpdatedTicketsAfterDecrease= noOfTicketsbeforeDecrease-1;
					 String checkUpdatedValueAfterDecrease = Integer.toString(noOfUpdatedTicketsAfterDecrease);
					  catsAction.verifyVariableValue(TicketUpdatedAfterDecrease, checkUpdatedValueAfterDecrease);
					}
				
		  }
		  
		  @Then("^verify user is able see all fields in minicart$")
		    public void verify_user_is_able_see_all_fields_in_minicart() throws Throwable {
			  
			  catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Booking.Minicart_NoOfTickets",this.ormData));
			  catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Booking.Minicart_ProductName",this.ormData));
			  catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Booking.Minicart_ProductType",this.ormData));
			  catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Booking.Minicart_Category",this.ormData));
			  catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Booking.Minicart_Validity",this.ormData));
			  catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Booking.Minicart_TimeSlot",this.ormData));
			  catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Booking.Minicart_Price",this.ormData));
			  catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Booking.Minicart_SubTotal",this.ormData));
			  catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Booking.Minicart_Total",this.ormData));
				  
		  }
		  
		  @Then("^user verify different currency in minicart$")
		    public void user_verify_different_currency_in_minicart() throws Throwable {
			  Thread.sleep(3000);
			  catsAction.scrollDownByOffset("1200");
			  catsAction.clickJS(CustomRules.locatorPresentInSite(website+".Minicart.ExpandCurrencyList",this.ormData));
			  List<WebElement> productList = getDriver().findElementsByXPath(catsVariable.getORM(website+".Minicart.CurrencyTypeList").getXpath()); 
              System.out.println("productList: "+productList.size());
              for(int i=1; i<productList.size();i++)
          //    for (int i = 0; i < productList.size()-1; i++) 
              {   
            	  int check=i+1;
                  System.out.println("list:"+productList.get(i).getText());
                  String selectedCurrency= productList.get(i).getText();
                 
      			  catsAction.click("(//div[@class='c-currency-converter']//ul[contains(@class,'dropdown-menu')]/li/div/span)["+check+"]");
                  Thread.sleep(3000);
      			  String convertedCurrency= getDriver().findElementByXPath(catsVariable.getORM(website+".Minicart.ConvertedCurrency").getXpath()).getText();
           //       catsAction.verifyTextContainsIgnoreCase(selectedCurrency, convertedCurrency);
                  catsAction.verifyVariableValueContainsIgnoreCase(convertedCurrency, selectedCurrency);
                  
                  Thread.sleep(2000);
                  catsAction.clickJS(CustomRules.locatorPresentInSite(website+".Minicart.ExpandCurrencyList",this.ormData));
                  Thread.sleep(2000);           
              }
		  }
              @When("^User clicks on Venue and TrackHire in homepage$")
              public void user_clicks_on_venue_and_trackhire_in_homepage() throws Throwable 
              {
              	Thread.sleep(2000);
              catsAction.click(CustomRules.locatorPresentInSite(website+".Header.VenueNtrack",this.ormData));
              }

              @Then("^User clicks on Venue$")
              public void user_clicks_on_venue() throws Throwable 
              {
              	Thread.sleep(2000);	
              catsAction.clickJS(CustomRules.locatorPresentInSite(website+".Header.VenueHire",this.ormData));
              	
              }

              @And("^User verify the venune tiles$")
              public void user_verify_the_venune_tiles() throws Throwable 
              {
              	Thread.sleep(2000);	
              catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Header.VenueHeroImage",this.ormData));
              	
              }
              @Then("^User click on HandF link$")
              public void user_click_on_handf_link() throws Throwable 
              {
              Thread.sleep(2000);	
              catsAction.clickJS(CustomRules.locatorPresentInSite(website+".Header.HandF",this.ormData));
              Thread.sleep(5000);	
              //catsAction.clickJS(CustomRules.locatorPresentInSite(website+".Header.HandFtiles",this.ormData));
              }
              @Then("^User click on Register now$")
              public void user_click_on_register_now() throws Throwable 
              {
              	Thread.sleep(5000);
              	catsAction.clickJS(CustomRules.locatorPresentInSite(website+".Header.RegisterFormHnF",this.ormData));
              }
              @And("^User verify the prefill form$")
              public void user_verify_the_prefill_form() throws Throwable 
              {
            	  
              Thread.sleep(5000);
              catsAction.waitUntilElementDisplay(CustomRules.locatorPresentInSite(website+".Contactuserror.FirstName",this.ormData),"15");
              Thread.sleep(4000);
              catsAction.verifyAttributeValue(CustomRules.locatorPresentInSite(website+".Contactuserror.FirstName",this.ormData),"value","AJAY");
              Thread.sleep(1000);
              catsAction.verifyAttributeValue(CustomRules.locatorPresentInSite(website+".Contactuserror.lastname",this.ormData),"value","KUMAR");
              Thread.sleep(3000);
              catsAction.verifyAttributeValue(CustomRules.locatorPresentInSite(website+".GuestCheckout.email",this.ormData),"value","AUTOMATIONYMC4@EMAIL.GHOSTINSPECTOR.COM");

              }
              @Then("^user enter the requried data$")
              public void user_enter_the_requried_data() throws Throwable 
              {
              	
              catsAction.clickJS(CustomRules.locatorPresentInSite(website+".Registration.TrainYas",this.ormData));
              Thread.sleep(2000);
              catsAction.selectElementByValue(CustomRules.locatorPresentInSite(website+".Registration.TitelDropDown",this.ormData), "Mr");
              Thread.sleep(1500);
              catsAction.selectElementByValue(CustomRules.locatorPresentInSite(website + ".ProfilePagePreference.CountryDropDwn",this.ormData), "IN");
             // catsAction.clickJS(CustomRules.locatorPresentInSite(website+".Contactuserror.countrydropdown",this.ormData));
              Thread.sleep(1500);
             // catsAction.clickJS(CustomRules.locatorPresentInSite(website+".Contactuserror.countrydropdown1",this.ormData));
              Thread.sleep(1500);
              catsAction.enter(CustomRules.locatorPresentInSite(website+".Registration.MobileNo",this.ormData), "$MiralGlobal.PhoneNoForGuestForm.<<site>>");
              Thread.sleep(1500);
              catsAction.enter(CustomRules.locatorPresentInSite(website+".Registration.EmerCont",this.ormData), "$MiralGlobal.PhoneNoForGuestForm.<<site>>");
              Thread.sleep(2000);
              catsAction.click(CustomRules.locatorPresentInSite(website+".Registration.Gender",this.ormData));
              Thread.sleep(2000);
              catsAction.selectElementByValue(CustomRules.locatorPresentInSite(website+".Registration.NationalityDropDwon",this.ormData), "IN");
              Thread.sleep(3000);
              catsAction.click(CustomRules.locatorPresentInSite(website+".Registration.DOBbox",this.ormData));
              Thread.sleep(1500);
              catsAction.selectElementByValue(CustomRules.locatorPresentInSite(website+".Registration.Month",this.ormData), "10");
              Thread.sleep(1500);
              catsAction.selectElementByValue(CustomRules.locatorPresentInSite(website+".Registration.Year",this.ormData), "1990");
              Thread.sleep(3000);
              catsAction.click(CustomRules.locatorPresentInSite(website+".Registration.Date",this.ormData));
              Thread.sleep(2000);
              catsAction.clickJS(CustomRules.locatorPresentInSite(website+".Registration.PrefLan",this.ormData));
              Thread.sleep(1500);
              catsAction.clickJS(CustomRules.locatorPresentInSite(website+".Registration.PrefCont",this.ormData));
              Thread.sleep(1500);
              catsAction.selectElementByValue(CustomRules.locatorPresentInSite(website+".Registration.Height",this.ormData), "170");
              Thread.sleep(1500);
              catsAction.selectElementByValue(CustomRules.locatorPresentInSite(website+".Registration.Weight",this.ormData), "60");
              Thread.sleep(1500);
              catsAction.selectElementByValue(CustomRules.locatorPresentInSite(website+".Registration.ExerciseFrequency",this.ormData), "1");
              Thread.sleep(1500);
              catsAction.selectElementByValue(CustomRules.locatorPresentInSite(website+".Registration.IntensityOfActivity",this.ormData), "3");
              Thread.sleep(1500);
              catsAction.clickJS(CustomRules.locatorPresentInSite(website+".Contactuserror.TermsAndCondition",this.ormData));

              }
              @And("^user click on featue tiles and click on quote$")
              public void user_click_on_featue_tiles_and_click_on_quote() throws Throwable 
              {
               Thread.sleep(4000);
              catsAction.clickJS(CustomRules.locatorPresentInSite(website+".Registration.YasConferenceCenter",this.ormData));
              Thread.sleep(4000);
			  catsAction.pageLoadWait();
              catsAction.clickJS(CustomRules.locatorPresentInSite(website+".Registration.Quote",this.ormData));
              }
              @Then("^user fill quote form$")
              public void user_fill_quote_form() throws Throwable 
              {
                  catsAction.pageLoadWait();
                  Thread.sleep(10000);
                  catsAction.selectElementByValue(CustomRules.locatorPresentInSite(website+".Registration.NumberOfAttentend",this.ormData), "empty-key1");
                 Thread.sleep(2000);
                 catsAction.click(CustomRules.locatorPresentInSite(website+".Registration.DOBbox",this.ormData));
                 Thread.sleep(2000);
                 catsAction.click(CustomRules.locatorPresentInSite(website+".Registration.Date",this.ormData));
                 Thread.sleep(1500);
                catsAction.enter(CustomRules.locatorPresentInSite(website+".Registration.MobileNo",this.ormData), "$MiralGlobal.PhoneNoForGuestForm.<<site>>");
                Thread.sleep(1500);
                catsAction.enter(CustomRules.locatorPresentInSite(website+".Registration.CompanyName",this.ormData), "Sapient");  
                Thread.sleep(1500); 
                catsAction.enter(CustomRules.locatorPresentInSite(website+".Contactuserror.Message",this.ormData), "This is Test Mesage");
                 Thread.sleep(1500);
                catsAction.clickJS(CustomRules.locatorPresentInSite(website+".Contactuserror.TermsAndCondition",this.ormData));
              }

              @Then("^user verify promocode in minicart$")
  		    public void user_verify_promocode_in_minicart() throws Throwable {
  			  Thread.sleep(3000);
  			  catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Minicart.PromoCode",this.ormData));
  			  catsAction.enterAppend(CustomRules.locatorPresentInSite(website+".Minicart.PromoCode",this.ormData),"$MiralGlobal.YMC_PromoCode.<<site>>");
  			  catsAction.clickJS(CustomRules.locatorPresentInSite(website+".Minicart.Apply_PromoCode",this.ormData));
  			  Thread.sleep(2000);
  			  catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Minicart.Discount",this.ormData));
  			  
  		  }
  		  
  		  
  		  @Then("^user verify \"([^\"]*)\" products in minicart$")
  		    public void user_verify_something_products_in_minicart(String strArg1) throws Throwable {
  			  Thread.sleep(3000);
  			  List<WebElement> productList = getDriver().findElementsByXPath(catsVariable.getORM(website+".Minicart.TicketSection").getXpath()); 
                System.out.println("productList: "+productList.size());
                String noOfTicketsPresent= Integer.toString(productList.size());
                catsAction.verifyVariableValue(noOfTicketsPresent, strArg1);
  		  }
  		  
  		  @And("^user add tickets if not added$")
  		    public void user_add_tickets_if_not_added() throws Throwable {
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
  		  
  		  @Then("^user click on Product Name and verify it move to PDP$")
  		    public void user_click_on_product_name_and_verify_it_move_to_pdp() throws Throwable {
  			  Thread.sleep(2000);
                catsAction.click(CustomRules.locatorPresentInSite(website+".Booking.ProductName",this.ormData));
                Thread.sleep(4000);
                catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".PDPbook.BookNow",this.ormData));
                catsAction.verifyElementNotPresent(CustomRules.locatorPresentInSite(website+".PDPbook.DiscoverMore",this.ormData));
    			 
  		  }
  		  
  		  @Then("^user verify invalid promocode message in minicart$")
  		    public void user_verify_invalid_promocode_message_in_minicart() throws Throwable {
  			  Thread.sleep(3000);
  			  catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Minicart.PromoCode",this.ormData));
  			  catsAction.enterAppend(CustomRules.locatorPresentInSite(website+".Minicart.PromoCode",this.ormData),"$MiralGlobal.YMC_InvalidPromoCode.<<site>>");
  			  catsAction.clickJS(CustomRules.locatorPresentInSite(website+".Minicart.Apply_PromoCode",this.ormData));
  			  Thread.sleep(2000);
  			  catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Minicart.InvalidPromoMsg",this.ormData));
  			
  		  }
  		   
  		  @When("^user enter invalid credit card details$")
  		    public void user_enter_invalid_credit_card_details() throws Throwable {
  			  catsAction.action("Move", "SKMouseMove", "", "", "", "", "", "", "");
  				catsAction.scrollPageDown();
  				
  				catsAction.waitUntilElementDisplay(CustomRules.locatorPresentInSite(website+".Ticket.CardNo",this.ormData),"30");
  				Thread.sleep(5000);
  				catsAction.enterAppend(CustomRules.locatorPresentInSite(website+".Ticket.CardNo",this.ormData), "$MiralGlobal.Invalid_CardNumberForCardPayment.<<site>>");
  				Thread.sleep(1000);
  				catsAction.enter(CustomRules.locatorPresentInSite(website+".Ticket.ExpDate",this.ormData), "$MiralGlobal.ExpDateForCardPayment.<<site>>");
  				Thread.sleep(1000);
  				catsAction.enter(CustomRules.locatorPresentInSite(website+".Ticket.CVV",this.ormData), "$MiralGlobal.CVVForCardPayment.<<site>>");
  				Thread.sleep(2000);
  		  }
  		  
  		  @Then("^user get the error message for valid information$")
  		    public void user_get_the_error_message_for_valid_information() throws Throwable {
  			  Thread.sleep(2000);
  			  catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Ticket.CreditCardErrorMsg",this.ormData));
  			 
  		  }
  		  
//  		  @Then("^user hover over header links and mega links should open$")
//  		    public void user_hover_over_header_links_and_mega_links_should_open() throws Throwable {
//  			  Thread.sleep(3000);
//  			  List<WebElement> productList = getDriver().findElementsByXPath(catsVariable.getORM(website+".Header.HeaderLinks").getXpath()); 
//                System.out.println("productList: "+productList.size());
//                for(int i=1; i<=productList.size();i++)
//                {   
//                    System.out.println("list:"+productList.get(i).getText());
//                    catsAction.hover("(//a[contains(@class,'header-nav-link')])["+i+"]");
//                    catsAction.
//                }  
//  		  }

  		  @Then("^user click on trip advisor and verify overlay$")
  		    public void user_click_on_trip_advisor_and_verify_overlay() throws Throwable {
  			  catsAction.clickJS(CustomRules.locatorPresentInSite(website+".PDPbook.TripAdvisor",this.ormData));
  			  Thread.sleep(4000);
  			  
  			  catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".PDPbook.TripAdvisorOverlay",this.ormData));
  				 
  		    }
  		  
  		  @Then("^user click on share icon and verify overlay$")
  		    public void user_click_on_share_icon_and_verify_overlay() throws Throwable {
  			  catsAction.clickJS(CustomRules.locatorPresentInSite(website+".PDPbook.ShareButton",this.ormData));
  			  Thread.sleep(4000);
  			  catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".PDPbook.ShareOverlay",this.ormData));
  				
  		  }
		  
  		@And("^user select Super Park Pass Type$")
  		public void user_select_super_park_pass_type() throws Throwable {
  			catsAction.waitUntilElementDisplay(CustomRules.locatorPresentInSite(website+".BookNowOverlay.SuperParkPass",this.ormData),"60");
  			Thread.sleep(2000);
  			catsAction.clickJS(CustomRules.locatorPresentInSite(website+".BookNowOverlay.SuperParkPass",this.ormData));

  		}   
  		
  		@Then("^user is able to validate recommendations for \"([^\"]*)\" for \"([^\"]*)\"$")
  		public void user_is_able_to_validate_recommendations_for_something(String str1, String strArg1) throws Throwable {
  			// Add "Abu Dhabi Hill 2D" product in cart
  			//Validate recomendations for "RED,SILVER,GOLDEN" for "1Day"
  			//Validate recomendations for "GOLDEN" for "1Day"

  			//   public void recomended(String str1, String str2){
  			System.out.println("changing in step def");
  			String[] productLst=str1.split(",");

  			for(String product:productLst){
  				System.out.println(product);

  				switch(product){
  				case("RED"):
  					validateRedParking(strArg1);
  				case("SILVER"):
  					validateSilverParking(strArg1);
  				case("GOLDEN"):
  					validateGoldenCircleParking(strArg1);
  				}
  			}

  		}

  		public void validateRedParking(String Days){

  			switch(Days){
  			case("1Day"):
  				// THU Parking and Friday Parking
  				catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Recommendation.RedThursday",this.ormData));
  			catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Recommendation.RedFriday",this.ormData));
  			break;

  			case("2Day"):
  				// THU Parking and Sat and Sun Parking
  				catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Recommendation.RedThursday",this.ormData));
  			catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Recommendation.RedSaturday",this.ormData));
  			catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Recommendation.RedSunday",this.ormData));
  			break;
  			case("3Day"):
  				// THU Parking and Fri Sat and Sun Parking and Combo Package
  				catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Recommendation.RedThursday",this.ormData));
  			catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Recommendation.RedSaturday",this.ormData));
  			catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Recommendation.RedSunday",this.ormData));
  			catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Recommendation.RedFriday",this.ormData));
  			catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Recommendation.RedCombo",this.ormData));
  			break;
  			}

  		}

  		public void validateSilverParking(String Days){

  			switch(Days){
  			case("1Day"):
  				// THU Parking and Friday Parking
  				catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Recommendation.SilverThursday",this.ormData));
  			catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Recommendation.SilverFriday",this.ormData));
  			break;
  			case("2Day"):
  				// THU Parking and Sat and Sun Parking
  				catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Recommendation.SilverThursday",this.ormData));
  			catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Recommendation.SilverSaturday",this.ormData));
  			catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Recommendation.SilverSunday",this.ormData));
  			break;
  			case("3Day"):
  				// THU Parking and Fri Sat and Sun Parking and Combo Package
  				catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Recommendation.SilverThursday",this.ormData));
  			catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Recommendation.SilverSaturday",this.ormData));
  			catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Recommendation.SilverSunday",this.ormData));
  			catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Recommendation.SilverFriday",this.ormData));
  			catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Recommendation.SilverCombo",this.ormData));
  			break;
  			}

  		}

  		public void validateGoldenCircleParking(String Days){

  			switch(Days){
  			case("1Day"):
  				// THU Parking and Friday Parking
  				catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Recommendation.GoldenThursday",this.ormData));
  			catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Recommendation.GoldenFriday",this.ormData));
  			break;
  			case("2Day"):
  				// THU Parking and Sat and Sun Parking
  				catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Recommendation.GoldenThursday",this.ormData));
  			catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Recommendation.GoldenSaturday",this.ormData));
  			catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Recommendation.GoldenSunday",this.ormData));
  			break;
  			case("3Day"):
  				// THU Parking and Fri Sat and Sun Parking and Combo Package
  				catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Recommendation.GoldenThursday",this.ormData));
  			catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Recommendation.GoldenFriday",this.ormData));  
  			catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Recommendation.GoldenSaturday",this.ormData));
  			catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Recommendation.GoldenSunday",this.ormData));
  			catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Recommendation.GoldenCombo",this.ormData));
  			break;


  			}

  		}
  			
  			
  			@Then("^user is able to validate recommendations for WRX Product$")
  		public void user_is_able_to_validate_recommendations_for_wrx_product() throws Throwable {
  			Thread.sleep(5000);
  			catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".WRX.WarnerBros",this.ormData));
  			catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".WRX.SilverParking",this.ormData));
  			catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".WRX.FerrariWorld",this.ormData));
  			catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".WRX.YasWaterWorld",this.ormData));
  			
  		}

  		@Then("^user is able to see all WRX product on world rallycross tab$")
  		public void user_is_able_to_see_all_wrx_product_on_world_rallycross_tab() throws Throwable {
  			Thread.sleep(2000);
  			catsAction.clickJS(CustomRules.locatorPresentInSite(website+".WRX.WorldRallycross",this.ormData));
  			Thread.sleep(3000);
  			catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".WRX.NorthClub",this.ormData));
  			catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".WRX.GeneralAdmission",this.ormData));
  			catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".WRX.Hospitality",this.ormData));
  		}
  		  
  		  

}