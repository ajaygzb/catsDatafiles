package cats.selenium.bdd.stepdef;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

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

public class SaadiyarRegression extends CATSCucumberConfig {
	
	String randomUser;
	public String site;
	public String website;
	public ExcelReader ormData;
	
	@Before()
	  public void launch(Scenario scenario) {
		try{
			String ormFile=System.getProperty("user.dir")+"/../DataFiles/ORM.xlsx";
			this.ormData=new ExcelReader(ormFile);
		}catch (Exception e) {
			catsAction.reportResultFail("Read ORM file", e.toString(), "Orm file should be accessible", "Not able to read orm file");
			e.printStackTrace();
		}	
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
	   **********************Start writing your Step definition below this sectio***************************************************************
	   *****************************************************************************************************************************************
	   */
	
	  @And("^User click on AboutUs link$")
	    public void user_click_on_aboutus_link() throws Throwable {
		 catsAction.scrollPageDown();
		 catsAction.clickJS(CustomRules.locatorPresentInSite(website+".AboutUS.AboutusLinks",this.ormData)); 
	    }
	  @Then("^veryfy AboutUs components is present$")
	    public void veryfy_aboutus_components_is_present() throws Throwable {
	  
		  Thread.sleep(5000);
		  catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".AboutUS.AboutUsComponets",this.ormData));
	  }
	  
	  @Then("^User click on Legal section on footer$")
	    public void user_click_on_legal_section_on_footer() throws Throwable {	
		  Thread.sleep(5000);
		  catsAction.scrollDownByOffset("1500");
		  catsAction.clickJS(CustomRules.locatorPresentInSite(website+".privacypolicy.PolicyLink",this.ormData));
		    
		    }
	  @And("^User verify Privacy Policy section present$")
	    public void user_verify_privacy_policy_section_present() throws Throwable {
		Thread.sleep(6000);
		catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".privacypolicy.Legalpage",this.ormData));
		
		
	  }
	  
	  @And("^Click on hotel and user is nvigate to tickect page$")
	    public void click_on_hotel_and_user_is_nvigate_to_tickect_page() throws Throwable {
		  Thread.sleep(5000);	    
		  catsAction.click(CustomRules.locatorPresentInSite(website+".HotelListing.HotelPage",this.ormData));

	  }
	  
	  @Then("^User are able to views all hotel pages$")
	    public void user_are_able_to_views_all_hotel_pages() throws Throwable {
		  Thread.sleep(5000);	    
		  catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".HotelListing.Hotelcards",this.ormData));
		  catsAction.verifyElementsCount(CustomRules.locatorPresentInSite(website+".HotelListing.Hotelcards",this.ormData)," ");

	    }
		
	@And("^user hover on Links HOTELS$")
	    public void user_hover_on_links_hotels() throws Throwable {
		  Thread.sleep(5000);
		 catsAction.hoverJS(CustomRules.locatorPresentInSite(website+".Hotelhover.Hotel",this.ormData)); 
	    }

	  @Then("^verify the all the hotels on dropdown$")
	    public void verify_the_all_the_hotels_on_dropdown() throws Throwable {
		  Thread.sleep(5000);
		  catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Hotelhover.Hoverlists",this.ormData));
	    } 
	  @And("^user hover on links Attraction$")
	    public void user_hover_on_links_attraction() throws Throwable {
		  Thread.sleep(5000);
		  catsAction.hoverJS(CustomRules.locatorPresentInSite(website+".Hotelhover.Attraction",this.ormData));
	  }
	    @Then("^verify the all the Atrractrion on dropdown$")
	    public void verify_the_all_the_atrractrion_on_dropdown() throws Throwable {
	    	Thread.sleep(5000);
			catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Hotelhover.AttractionLists",this.ormData));
}

@And("^Verify footer componets$")
	    public void verify_footer_componets() throws Throwable {
		 catsAction.scrollPageDown();
		 Thread.sleep(5000);
		 catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Footer.FooterComponets",this.ormData));
	    }
	  @Then("^Veryfy Hotel Links on footer$")
	    public void veryfy_hotel_links_on_footer() throws Throwable {
		Thread.sleep(5000);
		catsAction.clickJS(CustomRules.locatorPresentInSite(website+".Footer.FooterHotel",this.ormData));
	  }
	  @And("^Verify Attractions Links on footer$")
	    public void verify_attractions_links_on_footer() throws Throwable {
		Thread.sleep(5000);
		catsAction.clickJS(CustomRules.locatorPresentInSite(website+".Footer.FooterAttractions",this.ormData));
	  }
	  @Then("^Verify About Links On Footer$")
	    public void verify_about_links_on_footer() throws Throwable {
		Thread.sleep(5000);
		catsAction.clickJS(CustomRules.locatorPresentInSite(website+".Footer.FooterAbout",this.ormData));
		catsAction.clickJS(CustomRules.locatorPresentInSite(website+".Footer.FooterAbout",this.ormData));
	  }  
	  
	   @Then("^User scroll down to footer and click on Back to top clickk$")
	    public void user_scroll_down_to_footer_and_click_on_back_to_top_clickk() throws Throwable {
		 catsAction.scrollPageDown();
		  Thread.sleep(5000);
		 catsAction.clickJS(CustomRules.locatorPresentInSite(website+".BacktoTop.Backtop",this.ormData)); 
	    }

	    @And("^Verify that Header is getting displayed$")
	    public void verify_that_header_is_getting_displayed() throws Throwable {  
		catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".BacktoTop.HeaderValidate",this.ormData)); 

	  }
	
}