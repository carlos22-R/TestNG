package com.claro.abstractcomponent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

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






}
