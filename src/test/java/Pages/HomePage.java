package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    WebElement Searchbar;

    public WebElement getSearchbar() {
        return Searchbar;
    }

    public void setSearchbar(WebElement searchbar) {
        Searchbar = searchbar;
    }

    @FindBy(xpath = "//span[@class='a-color-state a-text-bold']")
    WebElement SearchResult;

    public WebElement getSearchResult() {

        return SearchResult;
    }

    public void setSearchResult(WebElement searchResult) {

        SearchResult = searchResult;
    }



    @FindBy(xpath = "(//span[@class='a-size-medium a-color-base'])[1]")
    WebElement Error;

    public void setError(WebElement error) {

        Error = error;
    }

    public WebElement getError() {

        return Error;
    }


}




