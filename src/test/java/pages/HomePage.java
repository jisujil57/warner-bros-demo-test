package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {

    public static String BASE_URL = "https://www.warnerbros.com/";

    private final SelenideElement searchButton = $("[data-component='search-button']");
    private final SelenideElement searchInput = $(".search-input");
    private final SelenideElement acceptCookiesButton = $("#onetrust-accept-btn-handler");
    private final SelenideElement undefinedSearchResultsText = $("[data-testid='results-container']");


    @Step("Открыть главную страницу")
    public void open() {
        Selenide.open(BASE_URL);
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

    @Step("Принять использование cookies")
    public void acceptCookies() {
        acceptCookiesButton.click();
    }

    @Step("Проверить сообщение об отсутствии результатов поиска")
    public void checkUndefinedErrorMessage() {
        undefinedSearchResultsText.shouldHave(text("NO RESULTS FOUND"));
    }

    public void scrollToFooter() {
        $("[href='/company']").scrollIntoView(true);
    }
}
