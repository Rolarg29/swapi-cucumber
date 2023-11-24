package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.WikipediaHomePage;
import pages.WikipediaResultsPage;
import pojos.People;
import static io.restassured.RestAssured.*;

public class PeopleTestSteps {

    private final WebDriver driver = Hooks.getDriver();
    private People people;
    WikipediaHomePage homePage = new WikipediaHomePage(driver);
    WikipediaResultsPage resultPage;

    @Before
    public void setUp(){
        people = null;
    }

    @Given("I am a user at the Wikipedia Web Page")
    public void userInWikipedia(){
        driver.get("https://en.wikipedia.org/");
    }

    @When("I request the SW character with ID {int} from SWAPI")
    public void swapiRequest(int number){
        this.people = get("https://swapi.dev/api/people/" + number).then().extract().as(People.class);
    }

    @When("I search for the SW character's name on Wikipedia")
    public void searchCharacter() {
        resultPage = homePage.searchValue(people.getName());
    }

    @Then("I should see the character's Wikipedia page correctly displayed")
    public void titleIsDisplayed() {
        Assert.assertEquals(people.getName(), resultPage.getPageTitle());
        Assert.assertTrue(resultPage.sidebarIsPresent());
        Assert.assertTrue(resultPage.navbarIsPresent());

    }

}
