package page.specialOffer;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import page.MainPage.MainPage;

public class OfferPage extends MainPage {
    @FindBy(xpath = "//div[@class='item']//../following-sibling::a")
    private WebElement buttonSetOffer;

    @FindBy(css = ".not-you")
    private WebElement notYouButton;

    @FindBy(css = ".email")
    private WebElement email;

    @FindBy(css = ".subPrice")
    private WebElement priceOfferPage;

    @Step
    public boolean offerPageIsOpened(){
        return buttonSetOffer.isDisplayed();
    }

    @Step
    public void clickButtonSetOffer(){
        buttonSetOffer.click();
    }

    @Step
    public void clickToNotYouButton(){
        notYouButton.click();
    }

    @Step
    public String getEmail(){
        return email.getText().toString();
    }

    @Step
    public String getPriceOfferPage(){
        return priceOfferPage.getText().toString();
    }
}
