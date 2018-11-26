package ExMavenDemo.MavenDemo;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {

	@Test
	public void verifytilte() {
		try {
			
			DesiredCapabilities capabilities = new DesiredCapabilities();
			
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,
					true);
			
			//System.out.println(""capabilities.getCapability(.BROWSER_VERSION));
			
			FirefoxOptions options = new FirefoxOptions(capabilities);
			FirefoxProfile profile = new FirefoxProfile();
			options.setProfile(profile);
			//String browserVersion = options.asMap().getCapability(CapabilityType.BROWSER_VERSION).toString();
			//Map<String, Object> browserVersion = DesiredCapabilities.firefox().asMap();
			String browserVersion = DesiredCapabilities.firefox().getCapability("version").toString();
			System.out.println("Browser Version :"+browserVersion);
			System.setProperty(
					"webdriver.gecko.driver",
					new File(
							"./src/resources/lib/geckodriver-v0.17.0-win64/geckodriver.exe")
							.getCanonicalPath());
			
			WebDriver driver = new FirefoxDriver(options);		
			
			
			driver.get("https://www.google.co.in/?gws_rd=ssl");
			System.out.println("Title : " + driver.getTitle());
			Assert.assertEquals(driver.getTitle(), "Google");
			System.out.println("End of test");
			//System.out.println("Running maven build from jenkins ");
			login();
			driver.quit();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Take inputs from pom.xml
	private void login() {

		/**
		 * 
		 * @parameter expression="${query.username}"
		 * 
		 */
		String username = System.getProperty("username");
		/**
		 * 
		 * @parameter expression="${query.password}"
		 * 
		 */
		String password = System.getProperty("password");
		System.out.println(username + " , " + password);

	}
}
