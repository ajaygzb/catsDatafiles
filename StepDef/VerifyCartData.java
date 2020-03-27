package cats.selenium.bdd.stepdef;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.sapient.qa.cats.core.framework.CATSCucumberConfig;

import cucumber.api.Scenario;
import cucumber.api.java.AfterStep;	
import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;
import cucumber.api.java.en.Then;

public class VerifyCartData extends CATSCucumberConfig {
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

	protected cartItems cartSummaryValues = new cartItems();

	@Then("^Store current values of \"([^\"]*)\" in site$")
	public void store_current_values_of_in_WBW_site(String arg1) throws Throwable {

		String productContainer="";
		String productName="";
		String productQty="";
		String subTicketTotal="";
		String TicketDate="";
		Thread.sleep(10000);
		switch(arg1){
		case("miniCart"):
			productContainer="(//div[@class='product-details-wrapper'])";
			productName="(//div[@class='product-details-wrapper'])/div/div[@class='product-name']/p[1]";
			productQty="/div[@class='ticket-subsection-container']/div/div/div/div[@class='c-spinner']/input";
			subTicketTotal="/parent::div/div[@class='sub-total']/p[2]";
			TicketDate="/div/span[@class='ticket-validity']/p[2]";
			cartSummaryValues.setMiniCartData(getCartDetails( productName, productContainer,  productQty,  subTicketTotal,  TicketDate, arg1));
			System.out.println("MINI CART DATA::::::::::::"+cartSummaryValues.getMiniCartData());

		break;
		case("cartSummary"):
			productContainer="(//div[@class='ticket-section'])";
			productName="(//div[@class='ticket-section'])/div/div/div[@class='product-name']/p";
			productQty="/div/div[@class='ticket-subsection-container']/div/div/div/div[@class='c-spinner']/input";
			subTicketTotal="/div[@class='sub-total']/p[2]";
			TicketDate="/div/div[@class='product-details']/div/span";
			cartSummaryValues.setSummaryCartData(getCartDetails( productName, productContainer,  productQty,  subTicketTotal,  TicketDate, arg1));
			System.out.println("CART SUMMARY CART DATA::::::::::::"+cartSummaryValues.getSummaryCartData());

		break;

		case("ticketConfirmation"):
			productContainer="(//div[@class='component c-booking-confirmation-ticket ticket-box'])";
			productName="//div[@class='c-booking-confirmation-ticket-title']/p[2]";
			productQty="/span/span/div[3]/p[2]";
			//subTicketTotal="/div[@class='sub-total']/p[2]";
			TicketDate="/span/span/div[2]/p[2]";
			cartSummaryValues.setConfirmationSummaryCartData(getCartDetails( productName, productContainer
					,  productQty,  subTicketTotal,  TicketDate, arg1));
			System.out.println("ticket confirmation summary DATA::::::::::::"+cartSummaryValues.getConfirmationSummaryCartData());

			break;

		default:
			break;
		}
	}
	
	
	
	public HashMap<String,HashMap<String,String>> getCartDetails(String productName,String productContainer, String productQty, String subTicketTotal, String TicketDate, String arg1){
		HashMap<String,HashMap<String,String>> miniCartData=new HashMap<>();
		HashMap<String,String> cartData=new HashMap<>();
		List<WebElement> productList = getDriver().findElementsByXPath(productName);
		int counter=1;
		int totalTicketQty=0;
		double TotalSubAmount=0;
		for(WebElement product :productList ){
			cartData=new HashMap<>();
			String qty=productContainer+"["+counter+"]"+productQty;
			List<WebElement> productQtyList=getDriver().findElementsByXPath(qty);
			String ticketName=product.getText();
			if(!miniCartData.containsKey(ticketName)){
				totalTicketQty=0;
				TotalSubAmount=0;
				totalTicketQty=ticketQty(productQtyList, arg1);
				cartData.put("ticketQty",  Integer.toString(totalTicketQty));
				System.out.println("ticketQty:::::"+cartData);

				if(!arg1.equals("ticketConfirmation")){
					TotalSubAmount=subTotal(productContainer, subTicketTotal, counter);
					cartData.put("SubTotal",  Double.toString(TotalSubAmount));
					System.out.println("SubTotal:::::"+cartData);
				}
				
				WebElement ticketValidity=getDriver().findElementByXPath(productContainer+"["+counter+"]"+TicketDate);
				String validityDate=ticketValidity.getText();
				cartData.put("TicketValidity",  validityDate);
				System.out.println("TicketValidity:::::"+cartData);

			}else{
				totalTicketQty=ticketQty(productQtyList, arg1)+Integer.parseInt(miniCartData.get(ticketName).get("ticketQty"));
				cartData.put("ticketQty",  Integer.toString(totalTicketQty));
				System.out.println("ticketQty:::::"+cartData);

				if(!arg1.equals("ticketConfirmation")){
				TotalSubAmount=subTotal(productContainer, subTicketTotal, counter)+Double.parseDouble(miniCartData.get(ticketName).get("SubTotal"));
				cartData.put("SubTotal",  Double.toString(TotalSubAmount));
				System.out.println("SubTotal:::::"+cartData);
				}
				
				WebElement ticketValidity=getDriver().findElementByXPath(productContainer+"["+counter+"]"+TicketDate);
				String validityDate=ticketValidity.getText();
				cartData.put("TicketValidity",  validityDate);
				System.out.println("TicketValidity:::::"+cartData);
				
			}

			miniCartData.put(ticketName, cartData);
			counter++;
		}
		System.out.println(miniCartData);
		return miniCartData;
		
	}
	
	
	
	public int ticketQty(List<WebElement> productQtyList, String arg1){
		int totalTicketQty=0;
		for(WebElement ticketQty: productQtyList){
			if(arg1.equals("ticketConfirmation")){
				totalTicketQty=totalTicketQty+ Integer.parseInt(ticketQty.getText().replace("Adult", "")
						.replace("Junior", "").trim());
			}else{
				totalTicketQty=totalTicketQty+ Integer.parseInt(ticketQty.getAttribute("value").replace("Adult", "")
						.replace("Junior", "").trim());
			}
			
		}
		return totalTicketQty;
	}
	
	public double subTotal(String productContainer, String subTicketTotal, int counter){
		double TotalSubAmount=0;
		System.out.println("Sub total Xpath::::"+productContainer+"["+counter+"]"+subTicketTotal);
		WebElement ticketSubTotal=getDriver().findElementByXPath(productContainer+"["+counter+"]"+subTicketTotal);
		TotalSubAmount=Double.parseDouble(ticketSubTotal.getText().replace(" ", "").replace("AED", "").replace(",", ""));
		return TotalSubAmount;
	}

	
	
	@Then("^Compare MiniCart and CartSummary$")
	public void Compare_MiniCart_and_CartSummary() throws Throwable {
		
		HashMap<String,HashMap<String,String>> miniCartData=cartSummaryValues.getMiniCartData();
		HashMap<String,HashMap<String,String>> cartSummaryData=cartSummaryValues.getSummaryCartData();
		
		for(String key : miniCartData.keySet() ){
			catsAction.reportResultInfo("Validating Data Ticket ::::"+key, key , key, key);
			HashMap<String,String> miniCartTicketData=miniCartData.get(key);
			HashMap<String,String> cartSummaryTicketData= cartSummaryData.get(key);
			for(String keyAttribute: miniCartTicketData.keySet()){
				catsAction.reportResultInfo("Validating Data Ticket ::::"+keyAttribute, keyAttribute , keyAttribute, keyAttribute);
				String miniCartAtrData=miniCartTicketData.get(keyAttribute).replace(" ", "");
				String cartSummaryAtrData=cartSummaryTicketData.get(keyAttribute).replace("Valid Until", "").replace(" ", "");
				if(miniCartAtrData.equals(cartSummaryAtrData)){
					catsAction.reportResultPass("Validating Data for :::"+keyAttribute,cartSummaryAtrData , miniCartAtrData, miniCartAtrData);
				}else{
					catsAction.reportResultFail("Validating Data for :::"+keyAttribute,cartSummaryAtrData , miniCartAtrData, miniCartAtrData);

				}
			}
		}	
	}
	
	@Then("^Compare MiniCart and ticketConfirmationSummary$")
	public void Compare_MiniCart_and_ticketConfirmationSummary() throws Throwable {
		
		HashMap<String,HashMap<String,String>> Map1=cartSummaryValues.getMiniCartData();
		HashMap<String,HashMap<String,String>> Map2=cartSummaryValues.getConfirmationSummaryCartData();
		
		for(String key : Map1.keySet() ){
			catsAction.reportResultInfo("Validating Data Ticket ::::"+key, key , key, key);
			HashMap<String,String> miniCartTicketData=Map1.get(key);
			HashMap<String,String> confirmationSummaryTicketData= Map2.get(key);
			for(String keyAttribute: miniCartTicketData.keySet()){
				if(keyAttribute.equals("SubTotal")){
					continue;
				}
				catsAction.reportResultInfo("Validating Data Ticket ::::"+keyAttribute, keyAttribute , keyAttribute, keyAttribute);
				String miniCartAtrData=miniCartTicketData.get(keyAttribute).replace(" ", "");
				String cartSummaryAtrData=confirmationSummaryTicketData.get(keyAttribute).replace("Valid Until", "").replace(" ", "");
				if(miniCartAtrData.equals(cartSummaryAtrData)){
					catsAction.reportResultPass("Validating Data for :::"+keyAttribute,cartSummaryAtrData , miniCartAtrData, miniCartAtrData);
				}else{
					catsAction.reportResultFail("Validating Data for :::"+keyAttribute,cartSummaryAtrData , miniCartAtrData, miniCartAtrData);

				}
			}
		}	
	}
	
	
}
