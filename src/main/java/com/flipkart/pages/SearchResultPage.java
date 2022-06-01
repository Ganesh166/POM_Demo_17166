package com.flipkart.pages;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.flipkart.Base.TestBase;

public class SearchResultPage extends TestBase {
	By firstProd = By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[2]/div[1]/div[1]");
	public boolean ValidateSearchResult() { 
		driver.findElement(firstProd).click();
		String parentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		
		
		for(String obj:allWindows) {
			if(!obj.equals(parentWindow)) {
				driver.switchTo().window(obj);
			}
		}
		wait = new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Share']")));
		String text = driver.findElement(By.xpath("//span[text()='Share']")).getText();
		return text .equalsIgnoreCase("Share");
	}
	
	

}
