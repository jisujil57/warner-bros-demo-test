package pages;

import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.$$;

public class MoviesPage {
    private final ElementsCollection brandsLinks = $$("#content h1");

    @Step("Проверить заголовки страницы")
    public void checkPageHeaders() {
        brandsLinks.shouldHave(texts("WHAT'S HOT", "NEW RELEASES TO OWN", "MOVIE NIGHT FAVORITES"));
    }
}
