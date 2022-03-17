package page_bo;

import lombok.extern.slf4j.Slf4j;
import net.jodah.failsafe.internal.util.Assert;
import page.MainPage.modalWindow.GetIronVpnMW;
import page.specialOffer.OfferPage;

import java.util.Objects;

@Slf4j
public class OfferPageBO {
    OfferPage offerPage = new OfferPage();
    GetIronVpnMW getIronVpnMW = new GetIronVpnMW();

    public OfferPageBO verifyThatOfferPageIsOpened() {
        try {
            log.info("Check that offer page is opened");
            Assert.isTrue(offerPage.offerPageIsOpened(), "Offer page isn`t opened");
        } catch (Exception e) {
            log.error("Offer page not opened");
        }
        return this;
    }

    public OfferPageBO openOffer() {
//        verifyThatOfferPageIsOpened();
        try {
            log.info("Click to button Get Iron VPN");
            offerPage.clickButtonSetOffer();
        } catch (Exception e) {
            log.error("Click not executed");
        }
        return this;
    }

    public OfferPageBO changeEmail() {
        try {
            log.info("Click to Not your email");
            offerPage.clickToNotYouButton();
        } catch (Exception e) {
            log.error("Change email not opened");
        }

        try {
            log.info("Set incorrect email");
            getIronVpnMW.setIncorrectEmail();
        } catch (Exception e) {
            log.error("Email not inserted");
        }

        try {
            log.info("Choice checkbox");
            getIronVpnMW.clickToCheckbox();
        } catch (Exception e) {
            log.error("Checkbox not selected");
        }
        return this;
    }

    public OfferPageBO verifyWhatEmailWasChanged() {
        try {
            log.info("Check emails");
            Assert.state(Objects.equals(offerPage.getEmail(), "test@qa.com"), "email incorrect!");
        } catch (Exception e) {
            log.error("Email incorrect");
        }
        return this;
    }

    public OfferPageBO getPriceInOfferPage() {
        try {
            log.info("Get Price from Offer Page");
            offerPage.getPriceOfferPage();
        } catch (Exception e) {
            log.error("Price not received");
        }
        return this;
    }


}
