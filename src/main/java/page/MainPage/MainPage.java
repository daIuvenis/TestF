package page.MainPage;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.AbstractPageObject;

@Slf4j
public class MainPage extends AbstractPageObject {
    @FindBy(xpath = "//a[@class=' btn-cta initchackout']")
    private WebElement buttonGetIronVpn;

    @FindBy(xpath = "//button[@class='btn initchackout']")
    private WebElement getIronVpnNow;

    @Step
    public void clickToGetIronVpn() {
        buttonGetIronVpn.click();
        log.info("asdasdasd");
    }

}
