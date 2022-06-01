package com.flipkart.tests;

import org.testng.annotations.Test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;


import com.flipkart.Base.TestBase;
import com.flipkart.pages.LoginPage;
import com.flipkart.pages.SearchProductPage;
import com.flipkart.pages.SearchResultPage;




public class PlaceOrder extends TestBase {
	
	public void LoginTest() {
		LoginPage loginpage = new LoginPage();
		boolean text = loginpage.ValidateLogin("9676608522", "Ganesh@166");
		Assert.assertTrue(text);
		
	}
	
	@Test(dependsOnMethods = {"LoginTest"})
	public void SearchProductTest() {
		SearchProductPage search = new SearchProductPage();
		boolean searchRes = search.ValidateSearchProduct("Laptop");
		Assert.assertTrue(searchRes);
		
	
	}
	
	@Test(dependsOnMethods = {"SearchProductTest"})
	public void SearchResultTest() {
		SearchResultPage res = new SearchResultPage();
		boolean result = res.ValidateSearchResult();
		Assert.assertTrue(result);
		
	}
	
	
	
	  
	  


	  @DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { 1, "a" },
	      new Object[] { 2, "b" },
	    };
	  }
	  @BeforeClass
	  public void setUp() {
		 
		  launchBrowser();
		  navigateToURL();
		 
	  }

	
		
	

	@AfterClass
	  public void afterClass() {
	  }

}
