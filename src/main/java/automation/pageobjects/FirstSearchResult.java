package automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FirstSearchResult {

	WebDriver driver;

	public FirstSearchResult(WebDriver driver) {
		this.driver = driver;
	}

	public By displayedLocationName = By.className("location__top");
	public By meeetingInfoTable = By.className("meeting-detail-bottom");

	public WebElement getdisplayedLocationName() {
		return driver.findElement(displayedLocationName);
	}

	public WebElement getHoursOfOperationToday() {
		return driver.findElement(meeetingInfoTable);
	}
}
