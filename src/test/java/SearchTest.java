import com.github.javafaker.Faker;
import configurations.BaseTest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import pages.HomePage;

import java.util.Locale;
@DisplayName("Тестирование поиска по сервису")
public class SearchTest extends BaseTest {
    HomePage homePage = new HomePage();
    Faker faker = new Faker(new Locale("ru"));

    @DisplayName("Успешный поиск")
    @Tag("smoke-test")
    @ParameterizedTest(name = "Поиск по запросу <{0}> должен показать информацию: <{1}>")
    @CsvSource({
            "Joker, The exploration of Arthur Fleck (Joaquin Phoenix), a man",
            "Batman, Tim Burton directs; Michael Keaton stars as Batman"
    })
    void successfulSearchTest(String searchTerm, String expectedAboutText) {
        homePage.open();
        homePage.searchByTitle(searchTerm);
        homePage.openSearchedCard(searchTerm);
        homePage.checkAbout(expectedAboutText);
    }

    @Test
    @DisplayName("Отсутствие результатов поиска")
    void undefinedSearchResultsTest() {
        homePage.open();
        homePage.searchByTitle(faker.address().fullAddress());
        homePage.checkUndefinedErrorMessage();
    }
}
