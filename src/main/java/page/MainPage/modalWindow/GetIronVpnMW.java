package page.MainPage.modalWindow;

import driver.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.MainPage.MainPage;

import java.time.Duration;

public class GetIronVpnMW extends MainPage {
    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(120));
    @FindBy(xpath = "//input[@id='email']")
    private WebElement email;

    @FindBy(xpath = "//i[@class='checkplace']")
    private WebElement checkbox;

    @FindBy(xpath = "//button[@name='get_now']")
    private WebElement submitEmail;

    @FindBy(xpath = "//button[@class='hystmodal__close ']")
    private WebElement closeModalWindow;

    @FindBy(xpath = "//div[@class='hystmodal__window hystmodal__window--form']")
    private WebElement emailModalWindow;

    @FindBy(xpath = "//p[@style='color: rgb(250, 172, 172);']")
    private WebElement conditions;

    @Step
    public boolean modalWindowIsOpened() {
        return emailModalWindow.isDisplayed();
    }

    @Step
    public void setEmail() {
        email.sendKeys("qa@test.com");
    }

    @Step
    public void setIncorrectEmail() {
        email.sendKeys("test@qa.com");
    }

    @Step
    public void clickToCheckbox() {
        checkbox.click();
    }

    @Step
    public void submitModalWindow() {
        submitEmail.click();
    }

    @Step
    public String verifyThatButtonSubmitIsDisabled() {
        return wait.until(ExpectedConditions.elementToBeClickable(submitEmail)).getCssValue("display");
    }
}
