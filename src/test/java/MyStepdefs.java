import CommonComponents.API;
import HelperClasses.SampleHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;


public class MyStepdefs {

    @Steps
    API api;

    @Steps
    SampleHelper sampleHelper;

    @Step
    @When("User hits the {string} endpoint")
    public void userHitsTheEndpoint(String arg0) {
        System.out.println("Hello I am in this");
        sampleHelper.intitalise();
    }

    @Step
    @Then("Response should not be null")
    public void responseShouldNotBeNull() {
        System.out.println("Hello I am in Response");
        api.response();
    }

    @Step
    @And("Status code should be {string}")
    public void statusCodeShouldBe(String arg0) {
        System.out.println("Hello I am in Status Code ");
        Assert.assertEquals(429,api.statusCode());
    }
}
