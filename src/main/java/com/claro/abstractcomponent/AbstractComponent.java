package com.claro.abstractcomponent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponent {

  WebDriver driver;

  public AbstractComponent(WebDriver driver){

    this.driver = driver;
    PageFactory.initElements(driver, this);
  }


  public void waitForVisual(int milliseconds) {
    try {
      Thread.sleep(milliseconds);
    } catch (InterruptedException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  public void waitTime(){
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  public String switchToWindow(int index){
    Object[] windowHandles=driver.getWindowHandles().toArray();
    return driver.switchTo().window((String) windowHandles[index]).getCurrentUrl();
  }
  public void closeWindow(int index){
    Object[] windowHandles=driver.getWindowHandles().toArray();
    driver.switchTo().window((String) windowHandles[index]).close();
    driver.switchTo().window((String) windowHandles[index-1]);
  }

  public void closeLogin(){
    try {

      WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(1000));
      WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='Cerrar']")));
      closeButton.click();
    }catch (Exception e){
      System.out.println("Error: " + e.getMessage());
    }
  }
  public void scrollToElement(By locator){
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", driver.findElement(locator));
  }
  public  void scrollToElement(WebElement element){
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()", element);
  }


}
