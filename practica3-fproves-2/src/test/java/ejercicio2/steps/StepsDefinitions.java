package ejercicio2.steps;
 import io.cucumber.java.DataTableType;
        import io.cucumber.java.en.Given;
        import io.cucumber.java.en.Then;
        import io.cucumber.java.en.When;
        import org.junit.Assert;
        import ejercicio2.domain.SearchDto;
 import ejercicio2.page.ResultPage;
 import ejercicio2.page.Home;

        import java.util.List;
        import java.util.Map;

public class StepsDefinitions {
    private Home Home;
    private ResultPage ResultPage;


    @DataTableType
    public SearchDto searchDtoDataTableTransform(Map<String, String> entry) {
        return new SearchDto(
                entry.get("origin"),
                entry.get("destination"),
                entry.get("outboundDate"),
                entry.get("returnDate")

        );
    }

    @Given("I'm main page")
    public void goPage() {
        Home.navigate();
    }

    @When("I try to find a fly")
    public void findAFlight(List<SearchDto> data) {
        SearchDto searchForm = data.get(0);
        Home.search(searchForm);
    }

    @Then("I get available flight")
    public void checkResult() {
        Assert.assertTrue(ResultPage.validate());
    }
}
