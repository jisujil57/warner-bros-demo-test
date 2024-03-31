import com.codeborne.selenide.Configuration;
import pages.components.NavigationMenuComponent;
import configurations.BaseTest;
import org.junit.jupiter.api.*;
import pages.HomePage;
import pages.MoviesPage;

@DisplayName("Навигационное меню при разрешении 1280x800")
public class NavigationMenuTest extends BaseTest {
    HomePage homePage = new HomePage();
    NavigationMenuComponent navigationMenu = new NavigationMenuComponent();
    MoviesPage moviesPage = new MoviesPage();

    @BeforeEach
    void setUp() {
        Configuration.browserSize = "1280x800";
    }

    @Test
    @DisplayName("Проверка списка элементов в меню")
    void checkNavigationListTest() {
        homePage.open();
        homePage.scrollToFooter();
        navigationMenu.openNavigationMenu();
        navigationMenu.checkNavigationList();
    }

    @Test
    @DisplayName("Закрыть меню")
    void closeHamburgerMenuTest() {
        homePage.open();
        homePage.scrollToFooter();
        navigationMenu.openNavigationMenu();
        navigationMenu.checkNavigationList();
        navigationMenu.closeNavigationMenu();
        navigationMenu.checkNavigationListHidden();
    }

    @Test
    @DisplayName("Переход в раздел Movies через меню")
    void openMoviesPageTest() {
        homePage.open();
        homePage.scrollToFooter();
        navigationMenu.openNavigationMenu();
        navigationMenu.openMoviesPage();
        moviesPage.checkPageHeaders();
    }
}
