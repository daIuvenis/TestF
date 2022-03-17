import org.testng.annotations.Test;
import page_bo.MainPageBO;
import page_bo.OfferPageBO;
import page_bo.PaymentMWBO;

public class GetIronVpnTest extends BaseWeb {

    @Test(description = "Check Full Pay Iron VPN")
    public void checkFullPayIronVPN() throws InterruptedException {
        new MainPageBO()
                .getIronVPN()
                .verifyThatEmailMWisOpened()
                .setDataInEmailMW();

        new OfferPageBO()
                .verifyThatOfferPageIsOpened()
                .openOffer();

        new PaymentMWBO()
                .goToIFrameWM()
                .setDataPayments()
                .pay()
                .parentFrame();
    }

    @Test(description = "Check email change")
    public void checkEmailChange(){
        new MainPageBO()
                .getIronVPN()
                .verifyThatEmailMWisOpened()
                .setDataInEmailMW();
        new OfferPageBO()
                .changeEmail()
                .verifyWhatEmailWasChanged();
    }

    @Test(description = "Check that the correct amount is due")
    public void checkThatTheCorrectAmountIsDue(){
        new MainPageBO()
                .getIronVPN()
                .verifyThatEmailMWisOpened()
                .setDataInEmailMW();
        new OfferPageBO()
                .getPriceInOfferPage()
                .openOffer();
        new PaymentMWBO()
                .getPriceInPaymentMW()
                .verifyThatPricesDoNotDiffer();

    }

    @Test(description = "Check email confirmation without accepting Terms & Condition and Privacy Policy")
    public void checkEmailConfirmationWithoutAcceptingConditions() {
        new MainPageBO()
                .getIronVPN()
                .verifyThatEmailMWisOpened()
                .setDataWithoutCheckbox()
                .verifyThatSubmitButtonIsDisabled();
    }
}
