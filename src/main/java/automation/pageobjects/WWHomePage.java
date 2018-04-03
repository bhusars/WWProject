/*Description:This class stores the page elements of weight watchers*/
package automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WWHomePage {

	WebDriver driver;

	public WWHomePage(WebDriver driver) {
		this.driver = driver;
	}

	By find_A_Meeting = By.id("ela-menu-visitor-desktop-supplementa_find-a-meeting");

	public WebElement getFindAMeeting() {
		return driver.findElement(find_A_Meeting);
	}

}
