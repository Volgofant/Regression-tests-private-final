package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
    private WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    By accountSelAddress = By.xpath("//a[@class=\"account__sidebar__nav__list__link__item sel-menu-addresses\"]");
    By accountSelMailSpam = By.xpath("//a[@class=\"account__sidebar__nav__list__link__item sel-menu-newsletter\"]");
    By buttonSavePass = By.xpath("//button[@class=\"accountPopup__btn btn-primary\"]");
    By updatePersonalDate = By.xpath("//a[@class=\"qaMyAccountCredentials\"]");
    By updateAddress = By.xpath("//a[@class=\"qaMyAccountBillingAddress\"]");
    By updateMailSpam = By.xpath("//a[@class=\"qaMyAccountNewsletters\"]");
    By updateAddressDelivery = By.xpath("//a[@class=\"qaMyAccountShippingAddress\"]");
    By accountSelMenu = By.xpath("//a[@class=\"account__sidebar__nav__list__link__item sel-menu-myaccount\"]");
    By accountSelWishList = By.xpath("//a[@class=\"account__sidebar__nav__list__link__item sel-menu-wishlist\"]");
    By accountSelOrders = By.xpath("//a[@class=\"account__sidebar__nav__list__link__item sel-menu-orders\"]");
    By accountSelReviews = By.xpath("//a[@class=\"account__sidebar__nav__list__link__item sel-menu-reviews\"]");
    By accountSelVouchers = By.xpath("//a[@class=\"account__sidebar__nav__list__link__item sel-menu-vouchers\"]");

    private By accountSelInfo = By.xpath("//a[@class=\"account__sidebar__nav__list__link__item sel-menu-info\"]");
    private By helloMessage = By.xpath("//p[@class=\"accountStep1__header__text\"]");
    private By buttonChangePass = By.xpath("//a[@href=\"#passwordPopup\"]/p");
    private By actualPass = By.xpath("//input[@id=\"password_current-input\"]");
    private By newPass = By.xpath("//input[@id=\"password-input\"]");
    private By newPassConfirm = By.xpath("//input[@id=\"password2-input\"]");
    private By textPassChange = By.xpath("//div[@class=\"message__text\"]");
    private By saveNewPass = By.xpath("//button[text()='Сохранить новый пароль']");


    void clickSaveNewPass() {
        driver.findElement(saveNewPass).click();
    }

    String getTextPassChange() {
        return driver.findElement(textPassChange).getText();
    }

    void inputActualPass(String AcPass) {
        driver.findElement(actualPass).sendKeys(AcPass);
    }

    void clickButtonChangePass() {
        driver.findElement(buttonChangePass).click();
    }

    public String getHelloMessage() {
        return driver.findElement(helloMessage).getText();
    }

    void clickChangeDate() {
        driver.findElement(accountSelInfo).click();
    }

    void inputNewPass(String x) {
        driver.findElement(newPass).sendKeys(x);
    }

    void inputNewPassConfirm(String y) {
        driver.findElement(newPassConfirm).sendKeys(y);
    }

    public AccountPage clickButtonSavePass() {
        driver.findElement(buttonChangePass);
        return this;
    }
}

