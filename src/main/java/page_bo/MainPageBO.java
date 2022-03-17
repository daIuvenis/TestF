package page_bo;

import lombok.extern.slf4j.Slf4j;
import net.jodah.failsafe.internal.util.Assert;
import page.MainPage.MainPage;
import page.MainPage.modalWindow.GetIronVpnMW;

import java.util.Objects;

@Slf4j
public class MainPageBO {
    MainPage mainPage = new MainPage();
    GetIronVpnMW getIronVpnMW = new GetIronVpnMW();
    //private static final Logger log = LogManager.getLogger(MainPageBO.class);

    public MainPageBO getIronVPN() {
        try {
            log.info("Open modal window");
            mainPage.clickToGetIronVpn();
        } catch (Exception e) {
            log.error("Modal window not opened");
        }
        return this;
    }

    public MainPageBO verifyThatEmailMWisOpened() {
        try {
            log.info("Modal Window is opened");
            Assert.isTrue(getIronVpnMW.modalWindowIsOpened(), "Not true");
        } catch (Exception e) {
            log.error("Modal window not opened");
        }

        return this;
    }

    public MainPageBO setDataInEmailMW() {
        try {
            log.info("Send email");
            getIronVpnMW.setEmail();
        } catch (Exception e) {
            log.error("Email not inserted");
        }

        try {
            log.info("Click to checkbox");
            getIronVpnMW.clickToCheckbox();
        } catch (Exception e) {
            log.error("Checkbox not selected");
        }

        try {
            log.info("Submit window");
            getIronVpnMW.submitModalWindow();
        } catch (Exception e) {
            log.error("Not submitted");
        }
        return this;
    }

    public MainPageBO setDataWithoutCheckbox() {
        try {
            log.info("Send email");
            getIronVpnMW.setEmail();
        } catch (Exception e) {
            log.error("Email not inserted");
        }
        return this;
    }

    public MainPageBO verifyThatSubmitButtonIsDisabled() {
        try {
            log.info("Check that button is blocked");
            Assert.state(Objects.equals(getIronVpnMW.verifyThatButtonSubmitIsDisabled(), "block"), "Get Iron is not blocked");
        } catch (Exception e) {
            log.error("Get Iron is not blocked");
        }
        return this;
    }


}
