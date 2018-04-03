package automation.TestProject;

import static org.testng.Assert.assertTrue;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import automation.basefolder.BaseClass;
import automation.pageobjects.FindAMeeting;
import automation.pageobjects.FirstSearchResult;
import automation.pageobjects.SearchResultsPage;
import automation.pageobjects.WWHomePage;

public class WWTestValidation {
	WebDriver driver;
	FindAMeeting findMeeting;
	WWHomePage homePage;
	SearchResultsPage searchResultsPage;
	FirstSearchResult firstSearchResult;

	BaseClass baseClass = new BaseClass();

	@Test(priority = 1)
	public void WWHomeTitleCheck() throws Exception {
		driver = baseClass.getDriver();
		driver.get(baseClass.getBaseAppURL());
		driver.manage().window().maximize();
		String pageTitle = driver.getTitle();
		Assert.assertEquals("Weight Loss Program, Recipes & Help | Weight Watchers", pageTitle);
		System.out.println("Page Title:"+pageTitle);
	}

	@Test(priority = 2)
	public void clickOnFind_A_Meeting() throws Exception {
		homePage = new WWHomePage(driver);
		findMeeting = new FindAMeeting(driver);
		homePage.getFindAMeeting().click();
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOfElementLocated(findMeeting.searchbox));
		String title = driver.getTitle();
		assertTrue(title.contains("Get Schedules & Times Near You"));
		findMeeting.getSearchBox().sendKeys("10011");
		findMeeting.getSearchBox().sendKeys(Keys.ENTER);
	}

	@Test(priority = 3)
	public void enterSearchBox() throws Exception {
		searchResultsPage = new SearchResultsPage(driver);
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.presenceOfElementLocated(searchResultsPage.firstResultTitle));
		WebElement FirstResultTitle = searchResultsPage.getFirstResultTitle();
		WebElement FirstResultDistance = searchResultsPage.getFirstResultDistance();
		System.out.println("First Result Title : " + FirstResultTitle.getText());
		System.out.println("First Result Tilte :" + FirstResultDistance.getText());
	}

	@Test(priority = 4)
	public void resultTitleMatch() throws Exception {
		searchResultsPage = new SearchResultsPage(driver);
		searchResultsPage.getFirstResultTitle().click();
		firstSearchResult = new FirstSearchResult(driver);
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.presenceOfElementLocated(firstSearchResult.displayedLocationName));
		String searchResult = searchResultsPage.getFirstResultTitle().getText();
		String displayedLocationName = firstSearchResult.getdisplayedLocationName().getText();

		if (searchResult.equals(displayedLocationName)) {
			System.out.println("Verified");
		}
	}

	@Test(priority = 5)
	public void displayHoursofOperation() throws Exception {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		firstSearchResult = new FirstSearchResult(driver);
		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.presenceOfElementLocated(firstSearchResult.meeetingInfoTable));
		WebElement meetinginfo = driver.findElement(By.className("meeting-detail-bottom"));
		je.executeScript("arguments[0].scrollIntoView(true);", meetinginfo);
		WebElement currentDayOfOperation = driver.findElement(By.xpath(
				"//div[@class='meeting-detail-bottom-bottom']/div[@class='meeting-hours meeting-detail-bottom-section']/hours-list/ul/li/div[@class='hours-list-item-wrapper hours-list--currentday']/div"));
		System.out.println(currentDayOfOperation.getText());
		List<WebElement> timeOfOperation = driver.findElements(By.xpath(
				"//div[@class='meeting-detail-bottom-bottom']/div[@class='meeting-hours meeting-detail-bottom-section']/hours-list/ul/li/div[@class='hours-list-item-wrapper hours-list--currentday']/div[@class='hours-list-item-hours']"));

		for (int i = 0; i < timeOfOperation.size(); i++) {
			System.out.println(timeOfOperation.get(i).getText());
		}
		
		driver.quit();
	}
}
