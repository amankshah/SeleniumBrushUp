package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

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



        //








//        driver.quit();
    }
}
