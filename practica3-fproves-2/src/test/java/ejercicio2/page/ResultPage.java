package ejercicio2.page;

import net.serenitybdd.core.pages.PageObject;
import  ejercicio2.domain.Constants;

public class ResultPage extends PageObject {

    public boolean validate() {
        return this.getDriver().getCurrentUrl().equals(Constants.WEB_URL_RESULT);
    }
}
