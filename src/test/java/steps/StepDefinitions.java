package steps;

import org.openqa.selenium.Dimension;
import pages.HomePage;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.BrowserManager;
import utils.QaProps;
import utils.TestDataReader;

import java.util.HashMap;

public class StepDefinitions {

    private WebDriver driver;
    HomePage homePage;
    String url;
    HashMap<String, String> data;
    Scenario scenario;

    public StepDefinitions(BrowserManager browserManager) {

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
        homePage = new HomePage(driver);
        data = TestDataReader.getData(scenario.getName());
    }


    @When("the User enters the product name")
    public void the_user_enters_the_product_name() {
        homePage.getSearchbar().sendKeys(data.get("Input"));
        homePage.getSearchbar().sendKeys(Keys.ENTER);

    }

    @Then("the relevant product results should be displayed")
    public void the_relevant_product_results_should_be_displayed() throws InterruptedException {
        String text = homePage.getSearchResult().getText();
        Assert.assertEquals(text, data.get("Expected Result"));



    }


    @When("the User enters the brand name")
    public void the_User_enters_the_brand_name() throws InterruptedException {
        homePage.getSearchbar().sendKeys(data.get("Input"));
        homePage.getSearchbar().sendKeys(Keys.ENTER);



    }


    @Then("the user should get the relevant products based on the brand name")
    public void the_user_should_get_the_relevant_products_based_on_the_brand_name() throws InterruptedException {
        String text = homePage.getSearchResult().getText();
        Assert.assertEquals(text, data.get("Expected Result"));

    }




   

    @Then("search box height should be as per specification")
    public void searchBoxHeightShouldBeAsPerSpecification() {
        Dimension dimension =  homePage.getSearchbar().getSize();
                 System.out.println(dimension.getHeight());
                Assert.assertEquals(dimension.getHeight(),38);
    }

    @Then("search box width should be as per specification")
    public void searchBoxWidthShouldBeAsPerSpecification() {
        Dimension dimension =  homePage.getSearchbar().getSize();
        System.out.println(dimension.getWidth());
               Assert.assertEquals(dimension.getWidth(),444);
    }

    @When("user enters {string} in the search bar")
    public void userEntersInTheSearchBar(String arg0) {
        homePage.getSearchbar().sendKeys(arg0);
        homePage.getSearchbar().sendKeys(Keys.ENTER);
    }
    @Then("User Should display the relevant {string}")
    public void userShouldDisplayTheRelevant(String arg0) {
        HashMap<String,String> searchData=new HashMap<>();
        searchData.put("sarreys","\"sarees\"");
        searchData.put("red dressid","\"red dress\"");
        String SearchInfo = homePage.getSearchResult().getText();
        Assert.assertEquals(SearchInfo,searchData.get(arg0));
    }
}





























































