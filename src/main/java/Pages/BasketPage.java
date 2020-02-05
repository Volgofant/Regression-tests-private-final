package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasketPage {
    private WebDriver driver;

    public BasketPage(WebDriver driver) {
        this.driver = driver;
    }

    private int numberProductInBasket = 1;

    private void UpdateNumberProductInBasket(Integer x) {
        numberProductInBasket = x;
    }

    By backPrimaryButton = By.xpath("//a[@class=\"cart__cartBox__text__link sel-continue-shopping jsBlockBackButton_cart\"]");
    By couponLink = By.xpath("//a[@class=\"jsAddCoupon cartFormFooter__couponBoxLink\"]");
    By backSecondaryButton = By.xpath("//a[@class=\"cart__form__footer__btnLink btn-primary sel-cart-checkout-button\"]");
    By productAddWishList = By.xpath("//div[@class=\"js-overlay-product blockCartProduct \"][" + numberProductInBasket + "]//a[@class=\"jsWishlistHeart qaWishlistHeart blockCartProduct__wishlistLink jsCartToWishlist blockCartProduct__wishlistLink_withIcon\"]");
    By productSelectSum = By.xpath("//div[@class=\"js-overlay-product blockCartProduct \"][" + numberProductInBasket + "]//span[@role=\"presentation\"]");

    private By payButton = By.xpath("//a[@class=\"cart__cartBox__link btn-primary sel-cart-checkout-button\"]");
    private By productImage = By.xpath("//div[@class=\"js-overlay-product blockCartProduct \"][" + numberProductInBasket + "]//a[@class=\" blockCartProduct__imageLink\"]/img[@class=\"js-overlay-product-image blockCartProduct__image\"]");
    private By productName = By.xpath("//div[@class=\"js-overlay-product blockCartProduct \"][" + numberProductInBasket + "]//a[@class=\"blockCartProduct__nameLink\"]");
    private By productDelete = By.xpath("//div[@class=\"js-overlay-product blockCartProduct \"][" + numberProductInBasket + "]//span[@class=\"blockCartProduct__deleteText--remove\"]");
    private By confirmProductDelete = By.xpath("//button[@class=\"blockConfirmOverlay__confirm jsBlockConfirmOverlay__confirm qaBlockConfirmOverlay__confirm\"]");


    public BasketPage clickConfirmProductDelete() {
        driver.findElement(confirmProductDelete).click();
        return this;
    }

    public void clickProductDelete() {
        driver.findElement(productDelete).click();
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    public SearchPage clickProductImage(Integer x) {
        UpdateNumberProductInBasket(x);
        driver.findElement(productImage).click();
        return new SearchPage(driver);
    }

    public void clickPayButton() {
        driver.findElement(payButton).click();
    }

}

