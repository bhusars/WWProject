package automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindAMeeting {

	WebDriver driver;

	public FindAMeeting(WebDriver driver) {
		this.driver = driver;
	}

	public By searchbox = By.id("meetingSearch");
	public By searchbutton = By.className("btn btn-default form-blue-pill__btn");

	public WebElement getSearchBox() {
		return driver.findElement(searchbox);
	}

	public WebElement getSearchButton() {
		return driver.findElement(searchbutton);
	}
}
