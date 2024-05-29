package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws Exception {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        Boolean headless = true; //creating variable to run it headless



        WebDriver driver ;

        if(headless){
            // Use Chrome Options pass arguments "headless"for headless method
            ChromeOptions options = new ChromeOptions();
            options.addArguments("headless");
            options.addArguments("window-size=1200x600");
            // Create a new instance of the Chrome driver
             driver = new ChromeDriver(options);
        }else{
            driver = new ChromeDriver();
        }





        //Set implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Navigate to a website
        driver.get("https://www.wikipedia.org/");

//        locators
        //---------- Id
        driver.findElement(By.id("js-link-box-en"));

        //---------- XPATH
        driver.findElement(By.xpath("//*[@id=\"js-link-box-en\"]"));

        //------------ CSS Selector
        driver.findElement(By.cssSelector("#js-link-box-en"));

        //checking time taken to find an element using an iD
        long start = System.currentTimeMillis();
        driver.findElement(By.id("js-link-box-en"));
        long end = System.currentTimeMillis();

        System.out.println("Time taken to find the element " + (end-start) + " MiliSeconds");



        //Getting title
        WebElement pageTitle = driver.findElement(By.cssSelector("#www-wikipedia-org > main > div.central-textlogo > h1 > span"));

        String TittleText = pageTitle.getText();
        String ExpectedText = "Wikipedia";

        if (TittleText.equals(ExpectedText)){
            System.out.println("Test Passed ✅");
        }else {
            System.out.println("Test Failed ❌");
            driver.close();
            throw new Exception();
        }



        //Clicking on English
        WebElement englishButton = driver.findElement(By.id("js-link-box-en"));
        englishButton.click();  //cliking here
                //Now we need to validate the english was clicked or not

                        WebElement newPageTitle = driver.findElement(By.id("mp-welcome"));
                         TittleText = newPageTitle.getText();
                         ExpectedText = "Welcome to Wikipedia,";

                        if (TittleText.equals(ExpectedText)){
                            System.out.println("Click Test Passed ✅");
                        }else {
                            System.out.println("Click Test Failed ❌");
                            driver.close();
                            throw new Exception();
                        }








        driver.quit();
    }
}


