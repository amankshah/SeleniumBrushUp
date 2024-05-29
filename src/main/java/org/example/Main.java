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

        Boolean headless = false; //creating variable to run it headless



        WebDriver driver ;

        if(headless){

            // Use Chrome Options pass arguments "headless"for headless method
                ChromeOptions options = new ChromeOptions();
                options.addArguments("headless");
                options.addArguments("window-size=1200x600");
            // Create a new instance of the Chrome driver
                driver = new ChromeDriver(options);
            System.out.println("🏃🏻__ _~~ Headless Chrome is Running  ~~️__ _🏃🏻");

        }else{
            driver = new ChromeDriver();
        }





        //Set implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Maximizing Window to Full Screen
        driver.manage().window().maximize();



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

//        System.out.println("Time taken to find the element " + (end-start) + " MiliSeconds");



     /*   //Getting Title
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

        */



        /*
        //Clicking on English
        WebElement englishButton = driver.findElement(By.id("js-link-box-en"));
        englishButton.click();  //Clicking here
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
                */


        //Sending Text to search box

        WebElement searchBox = driver.findElement(By.id("searchInput"));
        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"search-form\"]/fieldset/button/i"));
        searchBox.sendKeys("Selenium");
        searchButton.click();

                WebElement validatorElement= driver.findElement(By.id("firstHeading"));
                String TittleText = validatorElement.getText();
                String ExpectedText = "Selenium";
                if (TittleText.equals(ExpectedText)){
                    System.out.println("Search Test Passed ✅");
                }else {
                    System.out.println("Search Test Failed ❌ ");
                    driver.close();
                    throw new Exception();
                }

                //fetching Value from Table
                WebElement tableElement = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table[2]"));
                String tableText = tableElement.getText();
                System.out.println(tableText);
                //getting valie of 1st row 1st element of the table
                String firstRowFirstElement = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table[2]/tbody/tr[1]/th[1]")).getText();
                System.out.println( "First Row First Element : " + firstRowFirstElement );







//        driver.quit();
    }
}


