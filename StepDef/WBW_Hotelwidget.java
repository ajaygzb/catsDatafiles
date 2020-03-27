package cats.selenium.bdd.stepdef;

import com.sapient.qa.cats.core.framework.CATSCucumberConfig;
import java.io.IOException;
import cucumber.api.Scenario;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;
import cucumber.api.java.en.When;

public class WBW_Hotelwidget  extends CATSCucumberConfig{
	 
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
	   **********************Start writing your Step definition below this sectio***************************************************************
	   *****************************************************************************************************************************************
	   */
	 
	

	 
	  @When("^User click on Park tickets$")
	    public void user_click_on_park_tickets() throws Throwable {
		  catsAction.click(CustomRules.locatorPresentInSite(website+".Home.ParkTicket",this.ormData));
		   System.out.println("Clicked on Park tickets");
	    }

	    @Then("^User verify Genral Admission tab selected$")
	    public void user_verify_genral_admission_tab_selected() throws Throwable {
	    	catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Ticket.GeneralAdmission",this.ormData));
	 	    System.out.println("verified element on General element is selected");
	    }

	    @Then("^user navigate on Home Page$")
	    public void user_navigate_on_home_page() throws Throwable {
	    	catsAction.navigateBack();
	    	System.out.println("Navigated Back to Home Screen");
	    }

	    @Then("^User click on Annual Pass tab$")
	    public void user_click_on_annual_pass_tab() throws Throwable {
	    	catsAction.click(CustomRules.locatorPresentInSite(website+".Home.AnnualPass",this.ormData));
	 	    System.out.println("Clicked on Annual Pass ");
	    }

	    @Then("^User verify Annual Pass tab selected$")
	    public void user_verify_annual_pass_tab_selected() throws Throwable {
	    	catsAction.verifyElementPresent(CustomRules.locatorPresentInSite(website+".Ticket.AnnualPasses",this.ormData));
		     
	    }

	    
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	}
