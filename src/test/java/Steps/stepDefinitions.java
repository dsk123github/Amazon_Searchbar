package Steps;

import Pages.HomePage;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.BrowserManager;
import utils.QaProps;
import utils.TestDataReader;

import java.util.HashMap;

public class stepDefinitions {

    private WebDriver driver;
    HomePage homePage;
    String url;
    HashMap<String, String> data;
    Scenario scenario;

    public stepDefinitions(BrowserManager browserManager) {
        this.driver = browserManager.getDriver();
    }

    @Before(order = 1)
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }


    @Given("the User navigates to the Homepage")
    public void the_user_navigates_to_the_homepage() {
        url = QaProps.getValue("url");
        driver.get(url);
        data = TestDataReader.getData(scenario.getName());
    }


    @When("the User enters the product name")
    public void the_user_enters_the_product_name() {
        HomePage homePage = new HomePage(driver);
        homePage.getSearchbar().sendKeys("Mobiles");
        homePage.getSearchbar().sendKeys(Keys.ENTER);

    }

    @Then("the relevant product results should be displayed")
    public void the_relevant_product_results_should_be_displayed() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        String text = homePage.getSearchResult().getText();
        Assert.assertEquals(text, "\"Mobiles\"");


    }


    @When("the User enters the brand name")
    public void the_User_enters_the_brand_name() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.getSearchbar().sendKeys("Redmi");
        homePage.getSearchbar().sendKeys(Keys.ENTER);



    }


    @Then("the user should get the relevant products based on the brand name")
    public void the_user_should_get_the_relevant_products_based_on_the_brand_name() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        String text = homePage.getSearchResult().getText();
        Assert.assertEquals(text, "\"Redmi\"");

    }

    @When("the user should enter the invalid product name")
    public void the_user_should_enter_the_invalid_product_name() {
        HomePage homePage = new HomePage(driver);
        homePage.getSearchbar().sendKeys("abfrgghhjhj");
        homePage.getSearchbar().sendKeys(Keys.ENTER);


    }

    @Then("the user should be able get the error message")
    public void the_user_should_be_able_get_the_error_message()throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        String error = homePage.getError().getText();
        Assert.assertEquals(error, " no results ");

    }
    @When("the User types the product name")
    public void the_user_types_the_product_name() {
        HomePage homePage = new HomePage(driver);
        homePage.getSearchbar().sendKeys("Sarees");


    }
    @Then("user is able to see the suggested product list in the Drop-down list")
    public void user_is_able_to_see_the_suggested_product_list_in_the_drop_down_list() {
        HomePage homePage = new HomePage(driver);
        String text = homePage.getSearchResult().getText();
        Assert.assertEquals(text, "\"Sarees\"");

    }

    @When("the user clicks inside the Searchbar")
    public void the_user_clicks_inside_the_searchbar() {
        HomePage homePage = new HomePage(driver);
        homePage.getSearchbar().click();



    }
    @Then("user is able to see the Cursor inside the searchbar")
    public void user_is_able_to_see_the_Cursor_inside_the_searchbar() {
        HomePage homePage = new HomePage(driver);
        String text = homePage.getSearchResult().getText();

    }

}























































