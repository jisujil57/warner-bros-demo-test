import com.codeborne.selenide.Selenide;
import components.NavigationMenuComponent;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.MoviesPage;


public class NavigationMenuTest extends BaseTest{
    HomePage homePage = new HomePage();
    NavigationMenuComponent navigationMenu = new NavigationMenuComponent();
    MoviesPage moviesPage = new MoviesPage();

    @BeforeEach
    void setUp() {
        homePage.open();
        homePage.acceptCookies();
        homePage.scrollToFooter();
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    void checkNavigationListTest() {
        navigationMenu.openNavigationMenu();
        navigationMenu.checkNavigationList();
    }

    @Test
    void closeHamburgerMenuTest() {
        navigationMenu.openNavigationMenu();
        navigationMenu.closeNavigationMenu();


    }

    @Test
    void openMoviesPageTest() {
        navigationMenu.openNavigationMenu();
        navigationMenu.openMoviesPage();
        moviesPage.checkPageHeaders();
    }

}
