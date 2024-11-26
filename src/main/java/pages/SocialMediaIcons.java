package pages;

import com.claro.abstractcomponent.AbstractComponent;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SocialMediaIcons extends AbstractComponent {

  WebDriver driver;

  // no se ha actualizado la url
  @FindBy(how = How.XPATH, using = "//a[@href='https://twitter.com/claroelsalvador']")
  private WebElement XIcon;

  @FindBy(how = How.XPATH, using = "//a[@href='https://www.facebook.com/claroelsalvador']']")
  private WebElement facebookIcon;

  // no tiene el certificado de seguridad

  @FindBy(how = How.XPATH, using = "//a[@href='http://instagram.com/claroelsalvador']")
  private WebElement instagramIcon;

  // Path diferente a los anteriores

  @FindBy(how = How.XPATH, using = "//(//a[@class='icoRs'])[4]")
  private WebElement whatsAppIcon;

  @FindBy(how = How.XPATH, using = "//div[@class='footerRS fRSBtns fRSBtnsLibRec']//dl")
  private WebElement footer;

  @FindBy(id = "themaCookieModal")
  WebElement cookieModal;

  @FindBy(xpath = "//button[@class='fancybox-button fancybox-close-small']")
  private WebElement closeCookieModalButton;

  public SocialMediaIcons(WebDriver driver) {
    super(driver);
  }

  public void clickOnFacebookIcon() {
    // Click on Facebook icon
  }

  public void clickOnXIcon() {
    XIcon.click();

  }

  public void cickOnInstagramIcon() {
    // Click on Instagram icon
  }

  public void clickOnWhatsAppIcon() {
    // Click on WhatsApp icon
  }



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

}
