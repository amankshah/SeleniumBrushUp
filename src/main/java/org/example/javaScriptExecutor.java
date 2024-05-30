package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class javaScriptExecutor {



    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //-------------U R L -----------------
        driver.get("https://dashboard.abvssm.com/login");
        //--------------/U R L End -------------


        // Wait until the element is present and visible
        WebElement signUpButton = driver.findElement(By.xpath("//*[@id=\"formAuthentication\"]/div[2]/div[1]/a/small"));


        // Use JavaScriptExecutor to click the element

//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", signUpButton);

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();", signUpButton);
        System.out.println("executed");

        //Setting up timeout ( Using Asynchronous )
//        javascriptExecutor.executeAsyncScript("window.setTimeout(console.log('hello'),5000);");

        //change the webpage
        javascriptExecutor.executeScript("window.location ='https://dashboard.abvssm.com'");
        driver.get("https://www.wikipedia.org/");
        Thread.sleep(2000);
        //Scroll the webpage
        javascriptExecutor.executeScript("window.scrollBy(0,2000);");


    }






}
