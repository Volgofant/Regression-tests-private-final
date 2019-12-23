import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MailRuRegistration {
    private WebDriver driver;

    MailRuRegistration(WebDriver driver) {
        this.driver = driver;
    }

    private By name = By.xpath("//input[@class=\"b-input b-input_responsive b-input_compact b-input_animate\"]");
    private By surname = By.xpath("//input[@class=\"b-input b-input_responsive b-input_compact b-input_popup b-input_animate\"]");
    private By birthDay = By.xpath("//span[text()='День']");
    private By birthMounth = By.xpath("//span[text()='Месяц']");
    private By Mounth = By.xpath("//a[@data-num=\"0\"]");
    private By birthYear = By.xpath("//span[text()='Год']");
    private By maleGender = By.xpath("//span[@class=\"b-radiogroup__input-wrapper\"]//div[@class=\"b-radiogroup__radio-border\"]");
    private By accName = By.xpath("//input[@class=\"b-input b-input_responsive b-input_compact b-input_popup b-input_wide b-input_disallow-custom-domain b-input_animate b-input_no-margin-bottom b-input_no-margin-top b-input_scroll-to-error b-input_wide-columns\"]");
    private By passwordMail = By.xpath("//input[@id=\"password_37\"]");
    private By buttonCreate = By.xpath("//button[@class=\"btn btn_main btn_responsive btn_responsive-wide \"]");

    public MailRuRegistration inputName() {
        driver.findElement(name).sendKeys("Тестер");
        return this;
    }

    public MailRuRegistration inputSurname() {
        driver.findElement(surname).sendKeys("Автоматон");
        return this;
    }

    public MailRuRegistration inputBirthDay() {
        driver.findElement(birthDay).sendKeys("10");
        return this;
    }

    public MailRuRegistration inputBirthMonth() {
        driver.findElement(birthMounth).click();
        driver.findElement(Mounth).click();
        return this;
    }

    public MailRuRegistration inputBirthYear() {
        driver.findElement(birthYear).sendKeys("1990");
        return this;
    }

    public MailRuRegistration choiceMaleGender() {
        driver.findElement(maleGender).click();
        return this;
    }

    public MailRuRegistration inputNameAcc(String mail) {
        driver.findElement(accName).sendKeys(mail);
        return this;
    }

    public MailRuRegistration inputPass() {
        driver.findElement(passwordMail).sendKeys("1753942865qwerty");
        return this;
    }

    public MailRuRegistration clickButtonCreate() {
        driver.findElement(buttonCreate).click();
        return this;
    }
}
