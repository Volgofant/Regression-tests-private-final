import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

class FurniturePage {
    private WebDriver driver;
    FurniturePage(WebDriver driver) {
        this.driver = driver;
    }

    private By product = By.xpath("//button[@data-sku=\"RUQ19LOR419321-133418\"]/parent::article");

    void clickProduct() {
        driver.findElement(product).click();
    }
}
