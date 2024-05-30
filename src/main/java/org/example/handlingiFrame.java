package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class handlingiFrame {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //-------------U R L -----------------
        driver.get("https://www.w3schools.com/html/html_iframe.asp");
        //--------------/U R L End -------------


       String pageTitle=  driver.switchTo().frame(0).findElement(By.cssSelector("#main > h1")).getText();
        System.out.println(pageTitle);

        WebElement newFrame = driver.findElement(By.cssSelector("#main > div:nth-child(7) > iframe"));
        String FramePageText = driver.switchTo().frame(newFrame).findElement(By.xpath("//*[@id=\"main\"]/h2[1]")).getText();
        System.out.println(FramePageText);








        Thread.sleep(10000);
        driver.quit();
    }
}
