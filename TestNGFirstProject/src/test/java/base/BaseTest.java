package base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties login_locators = new Properties();
	public static FileReader fr;
	public static FileReader fr_locators;

	
	@BeforeMethod		
	public void setup() throws IOException {
		if(driver==null){
            fr = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\config.properties");
            prop.load(fr);
            
            fr_locators = new FileReader(System.getProperty("user.dir")+"\\src\\test\\resources\\configfiles\\login_locators.properties");
            login_locators.load(fr_locators);
        }

        if(prop.getProperty("browser").equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(prop.getProperty("testurl"));

        } else if (prop.getProperty("browser").equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.get(prop.getProperty("testurl"));
        }
		
	}

	@AfterMethod
	public void teardown() {
		
	     driver.close();
		
	}
	
}
