package setup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DriverSetup {
    private static WebDriver driver;
    public static String BROWSER = System.getProperty("selenium.browser", "chrome");
    private static ThreadLocal<WebDriver> driverThread;
    private static List<WebDriver> webDriverPool = Collections.synchronizedList(new ArrayList<WebDriver>());

    public static WebDriver initDriver() {
        if (driver == null) {
            switch (BROWSER) {
                case "chrome":
                    String chromeDriverLocation = System.getProperty("selenium.chromedriver", "C:\\dev\\chromedriver.exe");
                    System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
                    if (Boolean.valueOf(System.getProperty("selenium.remote", "false"))) {
                        return initRemoteDriver(DesiredCapabilities.chrome());
                    } else {
                        driverThread = new ThreadLocal<WebDriver>() {
                            @Override
                            protected WebDriver initialValue() {
                                WebDriver webDriver = null;
                                webDriver = new ChromeDriver();
                                webDriverPool.add(webDriver);
                                return webDriver;
                            }
                        };
                    }
                    break;

                case "firefox":
                    String firefoxDriverLocation = System.getProperty("selenium.geckodriver", "C:\\dev\\geckodriver.exe");
                    System.setProperty("webdriver.gecko.driver", firefoxDriverLocation);
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    break;
            }
        }
        return driver;
    }


    public static WebDriver initRemoteDriver(DesiredCapabilities capability) {
        driverThread = new ThreadLocal<WebDriver>() {
            @Override
            protected WebDriver initialValue() {
                WebDriver webDriver = null;
                try {
                    capability.setCapability(CapabilityType.PLATFORM_NAME, "Linux");
                    webDriver = new RemoteWebDriver(new URL("http://Heghine:b2f7a81e-31f9-441f-8b82-80ea48d4605c@ondemand.saucelabs.com:80/wd/hub"), capability);
                    webDriverPool.add(webDriver);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                return webDriver;
            }
        };
        return null;
    }

    public static WebDriver getDriver() {
        if (driverThread == null) {
            initDriver();
        }
        return driverThread.get();
    }

    public static void quitDriver() {
        webDriverPool.stream().filter(driver -> driver != null).forEach(driver -> {
            if (((RemoteWebDriver) driver).getSessionId() != null) {
                driver.close();
            }
            driver.quit();
        });
        driverThread = null;

    }
}



/*
mvn install -DskipTests
mvn test -Dselenium.browser=firefox
mvn test -piti ashxati chrome
mvn test -Dselenium.browser=chrome*/
