package configurations;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.HomePage;

import java.util.Map;
import java.util.Set;

import static configurations.Attach.*;


public class BaseTest {
    public static Set<Cookie> staticCookies;
    public static String BASE_URL = System.getProperty("baseUrl", "https://www.warnerbros.com");
    public final static String BROWSER_NAME = System.getProperty("browser", "chrome");
    public final static String SELENOID_URL = System.getProperty("selenoidUrl", "https://user1:1234@selenoid.autotests.cloud");


    @BeforeAll
    static void beforeAll() {
        configureWebDriver();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        configureRemoteExecution();
        Selenide.open(BASE_URL);
        new HomePage().acceptCookies();
        staticCookies = WebDriverRunner.getWebDriver().manage().getCookies();
        Selenide.closeWebDriver();
    }

    @AfterEach
    public void configurationAfter() {
        getAttachments();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWebDriver();
    }

    private static void configureWebDriver() {
        Configuration.browser = BROWSER_NAME;
        Configuration.baseUrl = BASE_URL;
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        Configuration.browserVersion = System.getProperty("browserVersion", "122.0");
        Configuration.pageLoadStrategy = "eager";
    }

    private static void configureRemoteExecution() {
        Configuration.remote = SELENOID_URL + "/wd/hub";

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

    public static void setBaseCookies() {
        if (staticCookies != null) {
            for (Cookie cookie : staticCookies) {
                WebDriverRunner.getWebDriver().manage().addCookie(cookie);
            }
        }
    }
}
