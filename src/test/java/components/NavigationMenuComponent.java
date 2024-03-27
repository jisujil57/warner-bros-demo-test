package components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.hidden;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class NavigationMenuComponent {
    private final SelenideElement hamburgerMenu = $("[data-component='hamburger']");
    private final SelenideElement closeHamburgerMenu = $("[data-component='hamburger'][open='']");
    private final SelenideElement moviesLink = $("[data-component='nav-list'] [href='/movies']");
//    private final SelenideElement gamesAndAppsLink = $("[data-component='nav-list'] [href='/games-and-apps']");
//    private final SelenideElement brandsLink = $("[data-component='nav-list'] [href='/brands']");
//    private final SelenideElement collectionsLink = $("[data-component='nav-list'] [href='/collections']");
//    private final SelenideElement pressReleasesLink = $("[data-component='nav-list'] [href='/news/press-releases']");
//    private final SelenideElement experienceLink = $("[data-component='nav-list'] [href='/experience']");
//    private final SelenideElement shopLink = $("[data-component='nav-list'] [href='/shop']");

    private final ElementsCollection brandsLinks = $$("[data-component='nav-list'] li");

    @Step("Открыть меню навигации")
    public void openNavigationMenu() {
        hamburgerMenu.click();
    }

    @Step("Закрыть меню навигации")
    public void closeNavigationMenu() {
        closeHamburgerMenu.click();
    }

    @Step("Проверить список навигации")
    public void checkNavigationList() {
        moviesLink.shouldHave(visible);
        brandsLinks.shouldHave(texts("Movies", "TV Shows", "Games & Apps",
                "Brands", "Collections", "Press Releases", "Experiences", "Shop"));
    }

    @Step("Открыть страницу фильмов")
    public void openMoviesPage() {
        moviesLink.click();
    }

    @Step("Проверить, что список навигации скрыт")
    public void checkNavigationListHidden() {
        moviesLink.shouldHave(hidden);
    }

}
