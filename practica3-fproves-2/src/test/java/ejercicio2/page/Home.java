package ejercicio2.page;


import ejercicio2.domain.Constants;
import ejercicio2.domain.SearchDto;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class Home extends PageObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    @FindBy(id = Constants.COOKIES)
    private WebElementFacade acceptCookies;

    @FindBy(css = Constants.SELECT_FROM_AIRPORT)
    private WebElementFacade from;

    @FindBy(css = Constants.SELECT_FROM_AIRPORT_OPTION)
    private WebElementFacade fromOption;

    @FindBy(css = Constants.SELECT_TO_AIRPORT)
    private WebElementFacade to;

    @FindBy(css = Constants.SELECT_TO_AIRPORT_OPTION)
    private WebElementFacade toOption;

    @FindBy(id = Constants.BUTTON)
    private WebElementFacade searchButton;

    @FindBy(css = Constants.SELECT_ONLY_ONE)
    private WebElementFacade oneWayOption;

    public void navigate() {
        this.getDriver().get(Constants.WEB_URL);
        acceptCookies.waitUntilVisible().click();
    }

    public void search(SearchDto flightQuery) {
        setFrom(flightQuery.getFromAirport());
        setTo(flightQuery.getToAirport());
        if (flightQuery.getDateReturn() == null) {
            oneWayOption.waitUntilVisible().click();
        }
        searchButton.click();
    }

    private void setFrom(String fromAirport) {
        from.click();
        from.sendKeys(fromAirport);
        fromOption.click();
    }

    private void setTo(String toAirport) {
        to.click();
        to.sendKeys(toAirport);
        toOption.click();
    }


}
