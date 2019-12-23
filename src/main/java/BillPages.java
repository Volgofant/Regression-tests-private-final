import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BillPages {
    WebDriver driver;

    public BillPages(WebDriver driver) {
        this.driver = driver;
    }

    By buttonNextStep = By.xpath("//button[@class=\"checkoutBtn blockCheckoutHeading__button js-blockCheckoutHeading__button btn-primary js-submitPayment\"]");
    By confrimCity = By.xpath("//div[@class=\"autocomplete-suggestion\"]");

    private By genderFemale = By.xpath("//input[@id=\"billing-frau-input\"]");
    private By genderMale = By.xpath("//input[@id=\"billing-herr-input\"]");
    private By name = By.xpath("//input[@id=\"shipping-name-input\"]");
    private By surname = By.xpath("//input[@id=\"shipping-lastName-input\"]");
    private By companyName = By.xpath("//input[@id=\"shipping-company-input\"]");
    private By streetNumber = By.xpath("//input[@id=\"shipping-street\"]");
    private By advancedAddress = By.xpath("//input[@id=\"shipping-street2\"]");
    private By mailIndex = By.xpath("//input[@id=\"shipping-code-input\"]");
    private By city = By.xpath("//input[@id=\"shipping-city-input\"]");
    private By phone = By.xpath("//input[@id=\"shipping-phone-input\"]");
    private By differentAddress = By.xpath("//input[@id=\"checkout__forms__info2Form__input\"]");
    private By creditCard = By.xpath("//input[@id=\"yandex_creditcard\"]");
    private By cash = By.xpath("//input[@id=\"cash_on_delivery\"]");
    private By nextPayPage = By.xpath("//p[@class=\"checkoutBtn__text\"]");
    private By nextPayPage2 = By.xpath("//button[@class=\"qa-checkout-submit-button checkoutBtn btn-primary js-submitPayment cart__form__footer__btnLink\"]");
    private By checkoutBtn = By.xpath("//button[@class=\"qa-checkout-submit-button checkoutBtn btn-primary js-submitFinish cart__form__footer__btnLink\"]");
    private By textCheckReadyOrder = By.xpath("//p[@class=\"checkout__finish__left__text\"][1]");
    private By textYandexPayService = By.xpath("//div[@class=\"payment-info2__showcase-name\"]");
    private By finalSum = By.xpath("//p[@class=\"cart__form__footer__totalTextRight\"]");
    private By yandexSum = By.xpath("//span[@class=\"price\"]");
    private By deliveryMethod = By.xpath("//span[text()='Выберите способ доставки']");
    private By expressDelivery = By.xpath("//div[text()='Курьерская доставка']");



    public String getYandexSum() {
        return driver.findElement(yandexSum).getText();
    }

    public String getFinalSum() {
        return driver.findElement(finalSum).getText();
    }

    public BillPages ClickNextPayPage() {
        driver.findElement(nextPayPage).click();
        return this;
    }

    public BillPages choiceGenderFemale() {
        driver.findElement(genderFemale).click();
        return this;
    }

    public BillPages choiceGenderMale() {
        driver.findElement(genderMale).click();
        return this;
    }

    public BillPages inputCompanyName() {
        driver.findElement(companyName).sendKeys("Новая фирма");
        return this;
    }

    public BillPages inputAdvancedAddress() {
        driver.findElement(advancedAddress).sendKeys("Дополнительного нет");
        return this;
    }

    public BillPages clickDifferentAddress() {
        driver.findElement(differentAddress).click();
        return this;
    }

    By getCash() {
        return cash;
    }

    By getCreditCard() {
        return creditCard;
    }

    String getTextYandexPayService() {
        return driver.findElement(textYandexPayService).getText();
    }

    String getTextCheckreadyOrder() {
        return driver.findElement(textCheckReadyOrder).getText();
    }

    void clickCheckoutBtn() {
        driver.findElement(checkoutBtn).click();
    }

    void choiceCreditCard() {
        driver.findElement(creditCard).click();
    }

    void choiceCash() {
        driver.findElement(cash).click();
    }

    void inputName() {
        driver.findElement(name).sendKeys("Имя1");
    }

    void inputSurname() {
        driver.findElement(surname).sendKeys("Фамилия1");
    }

    void inputStreetNumber() {
        driver.findElement(streetNumber).sendKeys("Улица доставки 42");
    }

    void inputMailIndex() {
        driver.findElement(mailIndex).sendKeys("123456");
    }

    void inputCity() {
        driver.findElement(city).sendKeys("Волгоград, Волгоградская область");
    }

    void inputPhone() {
        driver.findElement(phone).sendKeys("1234567890");
    }

    void clickButtonNextStep() {
        driver.findElement(nextPayPage).click();
    }

    void clickButtonNextStep2() {
        driver.findElement(nextPayPage2).click();
    }

    void choiceDeliveryMethodExpress() {
        driver.findElement(deliveryMethod).click();
        driver.findElement(expressDelivery).click();
    }

}
