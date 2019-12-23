import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class RegistrationPage<i> {
    private WebDriver driver;

    RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    private By logInMail = By.xpath("//input[@id=\"LoginForm_email\"]");
    private By logInPass = By.xpath("//input[@id=\"LoginForm_password\"]");
    private By forgotPass = By.xpath("//a[text()='Забыли пароль?']");
    private By LogInButton = By.xpath("//button[text()='Войти']");
    private By logInFacebook = By.xpath("//span[@class=\"fbAuthButton__text js-FbLoginButton__text\"]");
    private By femaleGender = By.xpath("//input[@id=\"frau-input\"]");
    private By maleGender = By.xpath("//input[@id=\"herr-input\"]");
    private By signInName = By.xpath("//input[@id=\"CheckoutShortRegistrationForm_first_name\"]");
    private By signInSurname = By.xpath("//input[@id=\"CheckoutShortRegistrationForm_last_name\"]");
    private By signInMail = By.xpath("//input[@id=\"CheckoutShortRegistrationForm_email\"]");
    private By signInPass = By.xpath("//input[@id=\"CheckoutShortRegistrationForm_password\"]");
    private By signInAgreement = By.xpath("//input[@id=\"CheckoutShortRegistrationForm_is_tc_accepted\"]");
    private By signInMailSpam = By.xpath("//input[@id=\"CheckoutShortRegistrationForm_is_newsletter_subscribed\"]");
    private By signInButton = By.xpath("//button[text()='Зарегистрироваться']");
    private By singInFacebook = By.xpath("//button[@class=\"fbAuthButton btn-default js-FbRegisterButton qa-FbRegisterButton\"]");
    private By incorrectMailOnMail = By.xpath("//div[@class=\"s-error msg\"][1]");
    private By incorrectMailOnPass = By.xpath("//div[@class=\"checkout__forms__passNewForm\"]/div[@class=\"s-error msg\"]");
    private By nullName = By.xpath("//div[@class=\"checkout__forms__nameForm\"]/div[@class=\"s-error msg\"]");
    private By nullSurname = By.xpath("//div[@class=\"checkout__forms__lastNameForm\"]/div[@class=\"s-error msg\"]");
    private By nullMail = By.xpath("//div[@class=\"checkout__forms__newMailForm\"]/div[@class=\"s-error msg\"]");
    private By repeatMail = By.xpath("//div[@class=\"checkout__forms__newMailForm\"]/div[@class=\"s-error\"]");
    private By wrongMail = By.xpath("//h2[@class=\"checkout__forms__header__heading\"]");
    private By nullPass = By.xpath("//div[@class=\"checkout__forms__passNewForm\"]/div[@class=\"s-error\"]");
    private By nullPassNo = By.xpath("//div[@class=\"checkout__forms__passNewForm\"]/div[@class=\"s-error msg\"]");
    private By nullAgreements = By.xpath("//div[@class=\"checkout__forms__info1Form  checker__error\"]/div[@class=\"s-error msg\"]");
    private By facebookPassword = By.xpath("//input[@type=\"password\"]");
    private By facebookMail = By.xpath("//input[@id=\"email\"]");
    private By facebookButtonLogIn = By.xpath("//input[@id=\"u_0_0\"]");

    private int min = 1;
    private int max = 999999999;
    private int diff = max - min;
    private Random random = new Random();
    int i = random.nextInt(diff + 1);

    String getThisPageWrongMail() {
        return driver.findElement(wrongMail).getText();
    }

    String getErrorMessageMailOnMail() {
        return driver.findElement(incorrectMailOnMail).getText();
    }

    String getNullAgreements() {
        return driver.findElement(nullAgreements).getText();
    }

    String getNullPassNo() {
        return driver.findElement(nullPassNo).getText();
    }

    String getThisPageWrongPass() {
        return driver.findElement(nullPass).getText();
    }

    String getErrorMessageRepeatMail() {
        return driver.findElement(repeatMail).getText();
    }

    String getErrorMessageNullMail() {
        return driver.findElement(nullMail).getText();
    }

    String getErrorMessageNullName() {
        return driver.findElement(nullName).getText();
    }

    String getErrorMessageNullSurName() {
        return driver.findElement(nullSurname).getText();
    }

    String getErrorMessageMailOnPass() {
        return driver.findElement(incorrectMailOnPass).getText();
    }

    public String getActualPass() {
        return driver.findElement(logInPass).getText();
    }

    void insertLogInMail(String mail) {
        driver.findElement(logInMail).sendKeys(mail);
    }

    void insertLogInPass(String pass) {
        driver.findElement(logInPass).sendKeys(pass);
    }

    public RestoreForgotPasswordPage clickForgotPass() {
        driver.findElement(forgotPass).click();
        return new RestoreForgotPasswordPage(driver);
    }

    void clickLogInButton() {
        driver.findElement(LogInButton).click();
        new MainPage(driver);
    }

    void choiceMaleGender() {
        driver.findElement(maleGender).click();
    }

    void choiceFemaleGender() {
        driver.findElement(femaleGender).click();
    }

    void insertSignInName(String name) {
        driver.findElement(signInName).sendKeys(name);
    }

    void insertSignInSurname(String surname) {
        driver.findElement(signInSurname).sendKeys(surname);
    }

    void insertSignInMail(String mail) {
        driver.findElement(signInMail).sendKeys(mail);
    }

    void insertSignInPass(String pass) {
        driver.findElement(signInPass).sendKeys(pass);
    }

    void checkBoxAgreement() {
        driver.findElement(signInAgreement).click();
    }

    void checkBoxMailSpam() {
        driver.findElement(signInMailSpam).click();
    }

    void clickSignInButton() {
        driver.findElement(signInButton).click();
        new MainPage(driver);
    }

    void clickSingInFacebook() {
        driver.findElement(singInFacebook).click();
    }

    void inputFacebookInfo() {
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
        driver.findElement(facebookMail).sendKeys("volgofant@mail.ru");
        driver.findElement(facebookPassword).sendKeys("175394286v");
        driver.findElement(facebookButtonLogIn).click();
    }

    void loginInFacebook() {
        driver.findElement(logInFacebook).click();
    }


}
