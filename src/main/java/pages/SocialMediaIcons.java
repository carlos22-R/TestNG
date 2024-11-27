package pages;

import com.claro.abstractcomponent.AbstractComponent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

  List<String> links = Arrays.asList("https://www.facebook.com/claroelsalvador","https://twitter.com/claroelsalvador","http://instagram.com/claroelsalvador","https://api.whatsapp.com/send?phone=50360605555");



  @FindBy(how = How.XPATH, using = "//*[@id=\"initial\"]/footer/div[1]/div/div[2]/dl/dd[1]/a")
  private WebElement facebookIcon;
  @FindBy(how= How.XPATH,using = "//div[@aria-label='Cerrar']")
  private WebElement closeLoginFacebook;
  // no tiene el certificado de seguridad

  @FindBy(how = How.XPATH, using = "//*[@id=\"initial\"]/footer/div[1]/div/div[2]/dl/dd[2]/a")
  private WebElement instagramIcon;
  @FindBy(how = How.XPATH, using = "//*[@id=\"layers\"]/div/div[2]/div/div/div/button")
  private WebElement modalX;
  // Path diferente a los anteriores

  @FindBy(how = How.XPATH, using = "//(//a[@class='icoRs'])[4]")
  private WebElement whatsAppIcon;

  @FindBy(how = How.XPATH, using = "//div[@class='footerRS fRSBtns fRSBtnsLibRec']//dl")
  private WebElement footer;

  @FindBy(id = "themaCookieModal")
  WebElement cookieModal;

 @FindBy(how = How.XPATH, using = "//*[@id=\"initial\"]/footer/div[1]/div/div[2]/dl")
 private WebElement socialSection;


  @FindBy(xpath = "//button[@class='fancybox-button fancybox-close-small']")
  private WebElement closeCookieModalButton;

  public SocialMediaIcons(WebDriver driver) {

    super(driver);
  }

  public String clickOnFacebookIcon() {
    facebookIcon.click();
    String url= switchToWindow(1);
    waitTime(3000);
    closeLogin(closeLoginFacebook);
    waitTime(3000);
    return url;
  }

  public String clickOnXIcon() {
      instagramIcon.click();
      String url=switchToWindow(1);
      waitTime(3000);
      modalX.click();
      waitTime(3000);
      return url;

  }

  public void cickOnInstagramIcon() {
    // Click on Instagram icon
  }

  public void clickOnWhatsAppIcon() {
    // Click on WhatsApp icon
  }

  public boolean iconsPresent(){
    if (socialSection.isDisplayed()){
      List<WebElement> list = socialSection.findElements(By.xpath("./*"));
      // System.out.println(list.size());
      if (list.size() == 5){
        int count = 0;
        for (WebElement element : list) {
          if (count!=0){

            //System.out.println(element.findElement(By.tagName("a")).getAttribute("href"));
            if (!links.contains(element.findElement(By.tagName("a")).getAttribute("href"))){
              System.out.println("The element no contains the link correctly");
              return false;
            }
          }
          count++;
        }
        return true;
      }else {
        System.out.println("There is no icons present");
        return false;
      }
    }else {
      System.out.println("The section is not present");
      return false;
    }
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



  public void scrollToFooter() {
    try {
      scrollToElement(footer);
    } catch (Exception e) {

    }
  }


  public void switchToTab(int tabIndex, WebDriver driver) {
    ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
    if (tabIndex < tabs.size()) {
      driver.switchTo().window(tabs.get(tabIndex));
    } else {
      throw new IllegalArgumentException("Índice de pestaña inválido: " + tabIndex);
    }
  }



}
