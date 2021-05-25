package ejercicio2.domain;

public class Constants {
    private Constants() {
    }

    public static final String WEB_URL = "https://www.vueling.com/es";
    public static final String WEB_URL_RESULT = "https://tickets.vueling.com/ScheduleSelectNew.aspx";
    public static final String COOKIES = "ensCloseBanner";

    public static final String SELECT_FROM_AIRPORT = "#tab-search > div > div.form-group.form-group--flight-search > vy-airport-selector.form-input.origin > div > input";
    public static final String SELECT_FROM_AIRPORT_OPTION = "#popup-list > vy-airports-li > li > p:nth-child(1)";
    public static final String SELECT_TO_AIRPORT = "#tab-search > div > div.form-group.form-group--flight-search > vy-airport-selector.form-input.destination > div > input";
    public static final String SELECT_TO_AIRPORT_OPTION = "#popup-list > vy-airports-li > li.liStation > p:nth-child(1)";

    public static final String SELECT_ONLY_ONE = "#searchbar > div > vy-datepicker-popup > vy-datepicker-header > ul > li:nth-child(2) > label";
    public static final  String BUTTON = "btnSubmitHomeSearcher";

}
