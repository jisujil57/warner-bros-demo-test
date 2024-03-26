import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.HomePage;

import java.util.Locale;


public class SearchTest extends BaseTest{
    HomePage homePage = new HomePage();
    Faker faker = new Faker(new Locale("ru"));

    @BeforeEach
    void setUp() {
        homePage.open();
        homePage.acceptCookies();
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }

    @DisplayName("Успешный поиск")
    @ParameterizedTest(name = "Поиск по запросу <{0}> должен показать информацию: <{1}>")
    @CsvSource({
            "Joker, The exploration of Arthur Fleck (Joaquin Phoenix), a man",
            "Batman, Tim Burton directs; Michael Keaton stars as Batman"
    })
    void successfulSearchTest(String searchTerm, String expectedAboutText) {
        homePage.searchByTitle(searchTerm);
        homePage.openSearchedCard(searchTerm);
        homePage.checkAbout(expectedAboutText);
    }

    @Test
    @DisplayName("Отсутствие результатов поиска")
    void undefinedSearchResultsTest() {
        homePage.searchByTitle(faker.address().fullAddress());
        homePage.checkUndefinedErrorMessage();
    }
}
