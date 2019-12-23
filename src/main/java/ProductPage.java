import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

class ProductPage {
    private WebDriver driver;

    ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    By productSize = By.xpath("//span[@id=\"select2-chosen-1\"]");
    By productCount = By.xpath("//span[@id=\"select2-chosen-3\"]");

    private By buttonInBasket = By.xpath("//button[@class=\"blockAddActions__btn btn-primary jsProductInfo__btn qa-addToCartBtn js-addToCartBtn blockAddActions__btn_show\"]");
    private By buttonInWishList = By.xpath("//span[@class=\"blockWishlistButton__text\"]");
    private By buttonChoiceWishList = By.xpath("//button[@class=\"blockAddToWishlistOverlay__confirm qaBlockAddToWishlistOverlay__confirm btn-primary\"]");
    private By productName = By.xpath("//h1[@class=\"blockProductHeading__heading\"]");

    String getProductName() {
        return driver.findElement(productName).getText();
    }

    void clickButtonInBasket() {
        driver.findElement(buttonInBasket).click();
    }

    void clickButtonInWishList() {
        driver.findElement(buttonInWishList).click();
    }

    void clickButtonChoiceWishList() {
        driver.findElement(buttonChoiceWishList).click();
    }

}
