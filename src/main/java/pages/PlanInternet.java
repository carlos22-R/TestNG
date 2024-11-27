package pages;

import com.claro.abstractcomponent.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PlanInternet extends AbstractComponent {
    WebDriver driver;
    public PlanInternet(WebDriver driver) {
        super(driver);
    }
    By menu = By.xpath("//*[@id=\"initial\"]/header/div[2]/div/div/nav/ul[2]/li[1]/a");
    By subMenu = By.xpath("//*[@id=\"initial\"]/header/div[2]/div/div/nav/ul[2]/li[1]/div/div/ul/li[2]/ul/li[1]/a");
    @FindBy(id = "themaCookieModal")
    WebElement cookieModal;
    @FindBy(xpath = "//button[@class='fancybox-button fancybox-close-small']")
    private WebElement closeCookieModalButton;
    public void closeCookieModal(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
            wait.until(ExpectedConditions.or(
                    ExpectedConditions.visibilityOf(cookieModal),
                    ExpectedConditions.invisibilityOf(cookieModal)
            ));
            if (cookieModal.isDisplayed()) {
                closeCookieModalButton.click();
                wait.until(ExpectedConditions.invisibilityOf(cookieModal));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    public void navbarNavigate(){
        navbarHover(menu,subMenu);
    }
}
