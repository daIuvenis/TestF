package page_bo;

import lombok.extern.slf4j.Slf4j;
import net.jodah.failsafe.internal.util.Assert;
import page.specialOffer.OfferPage;
import page.specialOffer.PaymentMW;

import java.util.Objects;

@Slf4j
public class PaymentMWBO {
    PaymentMW paymentMW = new PaymentMW();
    OfferPage offerPage = new OfferPage();


    public PaymentMWBO goToIFrameWM() {
        paymentMW.goToiFrameMW();
        return this;
    }

    public PaymentMWBO setDataPayments() {
        try {
            log.info("Set card number");
            paymentMW.setCardNumber();
        } catch (Exception e) {
            log.warn("Card number not inserted");
        }

        try {
            log.info("Set expiry date");
            paymentMW.setExpiryDate();
        } catch (Exception e) {
            log.error("Expiry dater not inserted");
        }

        try {
            log.info("Set cvv code");
            paymentMW.setCvv();
        } catch (Exception e) {
            log.error("Cvv code not inserted");
        }
        return this;
    }
        public PaymentMWBO verifyWhatButtonPayIsntDisabled () {
            paymentMW.checkThatPayButtonEnabled();
            System.out.println(paymentMW.checkThatPayButtonEnabled());
            return this;
        }

        public PaymentMWBO getPriceInPaymentMW () {
            paymentMW.getPriceMWPayment();
            return this;
        }

        public PaymentMWBO verifyThatPricesDoNotDiffer () {
            Assert.state(Objects.equals(paymentMW.getPriceMWPayment(), offerPage.getPriceOfferPage()), "price is different");
            return this;
        }

        public PaymentMWBO parentFrame () {
            paymentMW.goToParentFrame();
            return this;
        }
        public PaymentMWBO pay(){
        paymentMW.clickPay();
        return this;
        }
    }
