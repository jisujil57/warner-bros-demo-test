package configurations;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.xmlbeans.SystemProperties;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static configurations.Attach.*;
import static helpers.Constants.BROWSER_NAME;

public class BaseTest {

    @BeforeAll
    static void beforeAll() {
        configureWebDriver();
        configureRemoteExecution();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    public void configurationAfter() {
        getAttachments();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }

    private static void configureWebDriver() {
        Configuration.browser = BROWSER_NAME;
        Configuration.baseUrl = SystemProperties.getProperty("baseUrl", "https://www.warnerbros.com");
        Configuration.browserSize = SystemProperties.getProperty("browserSize", "1920x1080");
        Configuration.browserVersion = SystemProperties.getProperty("browserVersion", "122.0");
        Configuration.pageLoadStrategy = "eager";
    }

    private static void configureRemoteExecution() {
        String selenoidUrl = System.getProperty("selenoidUrl", "http://212.192.9.163:4444");
        Configuration.remote = selenoidUrl + "/wd/hub";

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true));
        Configuration.browserCapabilities = capabilities;
    }

    private void getAttachments() {
        screenshotAs("Скрин");
        pageSource();
        browserConsoleLogs();
        addVideo();
    }
}
