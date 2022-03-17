import driver.DriverManager;
import driver.TargetFactory;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static config.ConfigurationManager.configuration;

public abstract class BaseWeb {

    @BeforeClass()
    @Parameters("browser")
    public void preCondition(@Optional("chrome") String browser) {
        WebDriver driver = new TargetFactory().createInstance(browser);
        DriverManager.setDriver(driver);
        DriverManager.getDriver().get(configuration().url());
    }

    @AfterClass()
    public void postCondition() {
        DriverManager.quit();
    }
}
