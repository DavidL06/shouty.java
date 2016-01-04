package shouty;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static java.util.Collections.emptyList;
import static org.junit.Assert.assertEquals;

public class ShoutSteps {

    private final Shouty shouty = new Shouty();

    @Given("^Lucy is (\\d+)m from Sean$")
    public void lucy_is_m_from_Sean(int distanceInMetres) throws Throwable {
        shouty.setLocation("Lucy", 0);
        shouty.setLocation("Sean", distanceInMetres);
    }

    @When("^Sean shouts$")
    public void sean_shouts() throws Throwable {
        shouty.shout("Sean", "Free bagels!");
    }

    @Then("^Lucy should hear nothing$")
    public void lucy_should_hear_nothing() throws Throwable {
        assertEquals(emptyList(), shouty.getMessagesHeardBy("Lucy"));
    }
}
