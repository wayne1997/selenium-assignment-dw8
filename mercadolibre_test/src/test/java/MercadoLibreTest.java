import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import static org.junit.Assert.assertTrue;

public class MercadoLibreTest extends BaseTest {

    @Test
    public void testHelpNavigationFlow() {
        driver.get(config.getProperty("base.url"));

        HomePage helpPage = new HomePage(driver);

        String initialTitle = driver.getTitle().toLowerCase();
        System.out.println("DEBUG - Initial Title: " + initialTitle);
        assertTrue(initialTitle.contains("ayuda") || initialTitle.contains("help"));

        helpPage.goToPurchasesCategory();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

        String currentUrl = driver.getCurrentUrl();
        System.out.println("DEBUG - Final URL: " + currentUrl);
        
        assertTrue("Navigation failed. Current URL: " + currentUrl,
                currentUrl.contains("ayuda") || currentUrl.contains("v2") || currentUrl.contains("compras"));
    }

    @Test
    public void testMultipleHelpCategories() {
        String[] categories = {"Compras", "Ventas", "Seguridad"};

        for (String category : categories) {
            driver.get(config.getProperty("base.url"));

            By categoryLocator = By.xpath("//*[contains(text(), '" + category + "')]");

            WebElement element = driver.findElement(categoryLocator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

            System.out.println("Validated category: " + category);
            assertTrue(driver.getCurrentUrl().contains("ayuda") || driver.getCurrentUrl().contains("v2"));
        }
    }
}