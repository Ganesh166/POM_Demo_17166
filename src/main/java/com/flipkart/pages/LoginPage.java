package com.flipkart.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.flipkart.Base.TestBase;

public class LoginPage extends TestBase {
	
	By emailLoc = By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input");
	By passwordLoc = By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[2]/input");
	By loginButtonLoc = By.xpath("/html/body/div[2]/div/div/div/div/div[2]/div/form/div[4]/button/span");

	public boolean ValidateLogin(String Email, String Pass) {
		boolean loginFlag = true;
		driver.findElement(emailLoc).sendKeys(Email);
		wait(1000);
		driver.findElement(passwordLoc).sendKeys(Pass);
		wait(1000);
		driver.findElement(loginButtonLoc).click();
		
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"container\"]/div/div[1]/div[1]/div[2]/div[3]/div/div/div/div")));
		}catch(Exception E) {
			captureScreeenshot("Login Error");
			loginFlag = false;
		}
		if(loginFlag) {
			String actResult = driver.findElement(By.xpath("//*[text()='Ganesh']")).getText();
			return actResult.equalsIgnoreCase("Ganesh");
		}else
			return loginFlag;
	}
	
	
		
	}


	


