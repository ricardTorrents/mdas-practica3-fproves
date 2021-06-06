package ejercicio1;



import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchTest {

    //WEB DATA
    private static final String WEB_URL = "https://www.vueling.com/es";
    private static final String COOKIES = "ensCloseBanner";
    private static final String SELECT_FROM_AIRPORT = "#tab-search > div > div.form-group.form-group--flight-search > vy-airport-selector.form-input.origin > div > input";
    private static final String SELECT_FROM_AIRPORT_OPTION = "#popup-list > vy-airports-li > li > p:nth-child(1)";
    private static final String SELECT_TO_AIRPORT = "#tab-search > div > div.form-group.form-group--flight-search > vy-airport-selector.form-input.destination > div > input";
    private static final String SELECT_TO_AIRPORT_OPTION = "#popup-list > vy-airports-li > li.liStation > p:nth-child(1)";
    private static final String SELECT_ONLY_ONE = "#searchbar > div > vy-datepicker-popup > vy-datepicker-header > ul > li:nth-child(2) > label";
    private static final String SELECT_DATE = "#searchbar > div > vy-datepicker-popup > vy-specificdates-datepicker > div > div.ui-datepicker-group.ui-datepicker-group-last > table > tbody > tr:nth-child(2) > td:nth-child(6) > a";
    private static final String BUTTON = "btnSubmitHomeSearcher";
    private static final String RESULT_HEADER = "#newStv > div.stv-journey > div > div.vy-journey_header > h3";


    //TRAVEL DATA
    private static final String FROM_AIRPORT = "Barcelona";
    private static final String TO_AIRPORT = "Menorca";
    private static final String RESULT_HEADER_TITLE = "Barcelona (BCN) - Menorca (MAH)";


    // DRIVER
    private WebDriver driver;




    @BeforeClass
    public static void setupWebdriverChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
    }

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void down() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void search() {
        driver.get(WEB_URL);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(COOKIES))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(SELECT_FROM_AIRPORT))).sendKeys(FROM_AIRPORT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(SELECT_FROM_AIRPORT_OPTION))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(SELECT_TO_AIRPORT))).sendKeys(TO_AIRPORT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(SELECT_TO_AIRPORT_OPTION))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(SELECT_ONLY_ONE))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(SELECT_DATE))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(BUTTON))).click();
        WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(RESULT_HEADER)));
        assertThat(header.getText(), containsString(RESULT_HEADER_TITLE));
    }
}
