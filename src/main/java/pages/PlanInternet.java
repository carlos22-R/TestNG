package pages;

import com.claro.abstractcomponent.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PlanInternet extends AbstractComponent {
    WebDriver driver;
    public PlanInternet(WebDriver driver) {
        super(driver);
    }
    private WebElement element;
    By menu = By.xpath("//*[@id=\"initial\"]/header/div[2]/div/div/nav/ul[2]/li[1]/a");
    By subMenu = By.xpath("//*[@id=\"initial\"]/header/div[2]/div/div/nav/ul[2]/li[1]/div/div/ul/li[2]/ul/li[1]/a");
    @FindBy(id = "themaCookieModal")
    WebElement cookieModal;
    @FindBy(xpath = "//button[@class='fancybox-button fancybox-close-small']")
    private WebElement closeCookieModalButton;
    @FindBy(how = How.XPATH, using = "//*[@id=\"componentcpplanes\"]")
    private WebElement sectionPlan;
    @FindBy(how = How.XPATH,using = "/html/body/main/div/div[1]/div[2]/div/section/div/div[1]/div[1]/div[2]")
    private WebElement sectionInternet;
    @FindBy(how = How.XPATH,using = "//*[@id=\"cPal\"]/section[1]/div")
    private WebElement tab1;
    @FindBy(how = How.XPATH,using = "(//div[@class='c08BodyCardWrap'])")
    private List<WebElement> cards;
    @FindBy(how = How.XPATH,using = "//*[@id=\"tab-1\"]/div/div/div/div")
    private WebElement chosePlan;
    @FindBy(how = How.XPATH,using = "//div[@class=\"MoldalMolMain\"]")
    private WebElement modalText;
    @FindBy(how = How.XPATH,using = "//*[@id=\"tab-1\"]/div/div/div/div/div[2]/div/div/div/div/div[4]/div[1]")
    private WebElement prueba;
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
    public boolean navbarNavigate(){
        return navbarHover(menu,subMenu);
    }
    public boolean navigateToPlan(){
        if (sectionPlan.isDisplayed()) {
            if (sectionInternet.isDisplayed()) {
                scrollToElement(tab1);
                waitTime(2000);
                sectionInternet.click();
                waitTime(2000);
                scrollToElement(sectionPlan);
                return true;
            }else {
                System.out.println("Error: Section Internet plan is not displayed");
                return false;
            }

        }else {
            System.out.println("Error: section plan is not displayed");
            return false;
        }
    }
    public boolean planPresent(){
        if (chosePlan.isDisplayed()) {
            try {
                if (!cards.isEmpty()) {
                    WebElement element=getCard(cards);
                    if (element!=null){
                        element.findElement(By.xpath("(//div[@class='cPlanV2ContentOpen'])")).click();

                        return clickModal(element);
                    }else{
                        System.out.println("Error: Plan is not displayed");
                        return false;
                    }
                }else {
                    System.out.println("Error: internet Plan is not displayed");
                    return false;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                return false;
            }
        }else {
            System.out.println("Error: chose plan is not displayed");
            return false;
        }
    }
    public WebElement getCard(List<WebElement> cards) {
        for (WebElement card : cards) {
            if (card.getText().contains("4GB + Doble de Datos")){
                return card;
            }
        }
        return null;
    }

    public boolean clickModal(WebElement card){
        System.out.println(card);

        if (ElementClick(card.findElement(By.tagName("a")))) {
            card.findElement(By.tagName("a")).click();

           if (card.findElement(By.xpath("//div[@class=\"MoldalMolMain\"]")).isDisplayed()){

                if (card.findElement(By.xpath("//div[@class=\"mServiceHomePrice\"]")).getText().contains("10.00") && card.findElement(By.xpath("//div[@class=\"mServiceHomeFeatureItemVal\"]")).getText().contains("8GB (4GB + Doble de Datos)")){
                    waitTime(2000);
                    card.findElement(By.xpath("//i[@class=\"MoldalMolClose ico-x\"]")).click();
                    return true;
                }else {
                    System.out.println("Error: not contain text expected");
                    return false;
                }
            }else{
                System.out.println("Error: Card modal is not displayed");
                return false;
            }


        }else{
            System.out.println("Error: modal is not displayed");
            return false;
        }
    }

    public void getPriceModal(){
        try {
            if ( element.findElement(By.xpath("//div[@class=\"MoldalMolMain\"]")).isDisplayed()){
                System.out.println("si se desplego");
            }else {
                System.out.println("no se desplego");
            }




        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        }
    }
}
