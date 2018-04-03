package automation.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResultsPage {

	WebDriver driver;

	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
	}

	public By firstResultTitle = By.className("location__name");
	public By firstResultDistance = By.className("location__distance");

	public WebElement getFirstResultTitle() {
		List<WebElement> resultTitles = driver.findElements(firstResultTitle);
		return resultTitles.get(0);
	}

	public WebElement getFirstResultDistance() {
		List<WebElement> resultDistances = driver.findElements(firstResultDistance);
		return resultDistances.get(0);
	}
}
