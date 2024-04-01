package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.google.common.base.Stopwatch;
import io.qameta.allure.Step;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static configurations.BaseTest.setBaseCookies;

public class HomePage {
    private final SelenideElement searchButton = $("[data-component='search-button']");
    private final SelenideElement searchInput = $(".search-input");
    private final SelenideElement acceptCookiesButton = $("#onetrust-accept-btn-handler");
    private final SelenideElement undefinedSearchResultsText = $("[data-testid='results-container']");
    private final SelenideElement footerCompanyLink = $("[href='/company']");

    @Step("Открыть главную страницу")
    public void open() {
        Selenide.open("/");
        setBaseCookies();
    }

    @Step("Выполнить поиск по названию: {searchQuery}")
    public void searchByTitle(String searchQuery) {
        searchButton.click();
        searchInput.setValue(searchQuery);
    }

    @Step("Открыть карточку найденного элемента с заголовком: {title}")
    public void openSearchedCard(String title) {
        $(byTitle(title)).click();
    }

    @Step("Проверить наличие описания: {description}")
    public void checkAbout(String description) {
        $(withText(description)).shouldHave(exist);
    }

    @Step("Принять использование cookies при запросе")
    public void acceptCookies() {
        try {
            if (isElementAppearWithWait(acceptCookiesButton, 4000)) {
                acceptCookiesButton.click();
            } else {
                System.out.println("Кнопка принятия cookies не отобразилась в течение 4 секунд.");
            }
        } catch (Exception e) {
            System.out.println("Ошибка при принятии cookies: " + e.getMessage());
        }
    }

    boolean isElementAppearWithWait(SelenideElement element, long maxWaitTime) {
        Stopwatch sw = Stopwatch.createStarted();
        while (sw.elapsed(TimeUnit.MILLISECONDS) < maxWaitTime) {
            if (element.is(Condition.appear)) {
                return true;
            }
        }
        return false;
    }

    @Step("Проверить сообщение об отсутствии результатов поиска")
    public void checkUndefinedErrorMessage() {
        undefinedSearchResultsText.shouldHave(text("NO RESULTS FOUND"));
    }

    @Step("Выполнить скролл до футера")
    public void scrollToFooter() {
        footerCompanyLink.scrollIntoView(true);
    }
}
