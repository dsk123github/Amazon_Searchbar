package Steps;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utils.BrowserManager;

public class Hooks {


        private final BrowserManager browserManager;
        public Hooks (BrowserManager browserManager) {

            this.browserManager = browserManager;
        }
        @Before(order=0)
        public void setup(){
            browserManager.setDriver();

        }
        @After(order=1)
        public void takeScreenShot(Scenario scenario) {
            if (scenario.isFailed()) {
                TakesScreenshot ts = (TakesScreenshot) browserManager.getDriver();
                byte[] src = ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(src, "image/png", "screenshot");
            }
        }

//        @After(order=0)
//        public void tearDown() {
 //           browserManager.getDriver().quit();
//        }
    }




