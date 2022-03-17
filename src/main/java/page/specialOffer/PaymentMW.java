package page.specialOffer;

import driver.DriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import page.MainPage.MainPage;

import static driver.DriverManager.getDriver;

public class PaymentMW extends MainPage {

    WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), 20);
    @FindBy(css = "[type='tel'][name='cardNumber']")
    private WebElement cardNumber;

    @FindBy(css = "[type='tel'][name='cardExpiryDate']")
    private WebElement expiryDate;

    @FindBy(css = "[type='tel'][name='cardCvv']")
    private WebElement cvv;

    @FindBy(xpath = "//button[@name='submitButton']")
    private WebElement buttonPay;

    @FindBy(css = "#solid-payment-form-iframe")
    private WebElement iFrameMW;

    @FindBy(xpath = "//div[@class='col-6 text-right timeOut']")
    private WebElement price;


    @Step
    public void setCardNumber() {
        wait.until(ExpectedConditions.visibilityOf(cardNumber)).sendKeys("4532456618142692");
    }

    @Step
    public void setExpiryDate() {
//        clickOnElementWithJS(expiryDate);
        sendInputValue(expiryDate, "03/2029");
    }

    @Step
    public void setCvv() {
        cvv.click();
        sendInputValue(cvv, "934");
    }

    @Step
    public void clickPay() {
        buttonPay.click();
    }

    @Step
    public boolean checkThatPayButtonEnabled() {
        return buttonPay.isEnabled();

    }

    @Step
    public PaymentMW goToiFrameMW() {
        getDriver().switchTo().frame(iFrameMW);
        return new PaymentMW();
    }

    @Step
    public PaymentMW goToParentFrame(){
        getDriver().switchTo().parentFrame();
        return new PaymentMW();
    }

    @Step
    public String getPriceMWPayment(){
        wait.until(ExpectedConditions.visibilityOf(price));
        String priceStr = String.valueOf(new StringBuffer(price.getText()).deleteCharAt(4));
        return priceStr;
    }

    public void clickOnElementWithJS(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
    }

    private void sendInputValue(WebElement element, String text) {
        ((JavascriptExecutor) getDriver()).executeScript(
                "arguments[0].setAttribute('value',' " + text + "')", element);
    }


}
