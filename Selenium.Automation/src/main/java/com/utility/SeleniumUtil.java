package com.utility;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtil {
	

	 WebDriver driver;
	 
	public SeleniumUtil(WebDriver driver) {
		this.driver=driver;
		
	}
	
	
	public void explicitClick(WebElement element){
		
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
		
		}

		
	}
public void explicitVisible(WebElement element){
		
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			
		}

		
	}

public List<String> getListElementText(List<WebElement> element){
	
	List<String> list = new ArrayList<>();
	element.forEach(name -> {
		list.add(name.getAttribute("innerText"));

	});

	return list;
}
public List<Double> getListElementValue(List<WebElement> element){
	
	List<Double> list = new ArrayList<>();
	list =element.stream().map(e -> e.getAttribute("innerText")).map(e -> e.replaceAll("[^0-9.]", ""))
			.map(e -> Double.parseDouble(e)).collect(Collectors.toList());


	return list;
}
}
