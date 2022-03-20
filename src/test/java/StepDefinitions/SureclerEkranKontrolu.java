package StepDefinitions;

import Pages.HomePage;
import Pages.SureclerPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SureclerEkranKontrolu {
    WebDriver driver = null;
    HomePage homePage;
    SureclerPage sureclerPage;
    boolean isDone = false;

    @Given("^anasayfaya acilir$")
    public void anasayfaya_acilir() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//drivers//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.epias.com.tr/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @When("^surecler sayfasina gidilir$")
    public void surecler_sayfasina_gidilir() {
        homePage.goToSurecler();
        sureclerPage = new SureclerPage(driver);
    }

    @Then("^sayfanin acildigi gorulur$")
    public void sayfanin_acildigi_gorulur() {
        isDone = sureclerPage.sureclerKontrolu();
        if (!isDone)
            Assert.fail("Süreçler sayfası açılmadı!!");
    }
}
