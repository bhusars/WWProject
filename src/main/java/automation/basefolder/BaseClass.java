package automation.basefolder;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {
	public WebDriver driver;
	public Properties prop = new Properties();
	String propfile = "config\\prop.properties";

	public WebDriver getDriver() throws Exception {
		FileInputStream fis = new FileInputStream(propfile);
		prop.load(fis);
		String browser = prop.getProperty("browser");

		if (browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "config\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "config\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "config\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		return driver;
	}

	public String getBaseAppURL() throws IOException {
		FileInputStream inputStream = new FileInputStream(propfile);
		prop.load(inputStream);
		return prop.getProperty("AUT");
	}
}
