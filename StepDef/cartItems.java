package cats.selenium.bdd.stepdef;

import java.util.HashMap;

public class cartItems {
	
	private HashMap<String,HashMap<String,String>> miniCartData;
	private HashMap<String,HashMap<String,String>> summaryCartData;
	private HashMap<String,HashMap<String,String>> confirmationSummaryCartData;

	
	
	public HashMap<String,HashMap<String,String>> getMiniCartData(){
		return miniCartData;
	}
	
	public void setMiniCartData( HashMap<String,HashMap<String,String>> miniCartData){
		this.miniCartData= miniCartData;
	}

	public HashMap<String,HashMap<String,String>> getSummaryCartData(){
		return summaryCartData;
	}
	
	public void setSummaryCartData( HashMap<String,HashMap<String,String>> summaryCartData){
		this.summaryCartData= summaryCartData;
	}
	
	public HashMap<String,HashMap<String,String>> getConfirmationSummaryCartData(){
		return confirmationSummaryCartData;
	}
	
	public void setConfirmationSummaryCartData( HashMap<String,HashMap<String,String>> confirmationSummaryCartData){
		this.confirmationSummaryCartData= confirmationSummaryCartData;
	}
	
}
