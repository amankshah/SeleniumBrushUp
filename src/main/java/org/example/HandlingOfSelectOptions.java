package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class HandlingOfSelectOptions {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //-------------U R L -----------------
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select");
        //--------------/U R L End -------------


        driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
        WebElement SelectDropdown = driver.findElement(By.id("cars"));
        Select carDropdown = new Select(SelectDropdown);
        carDropdown.selectByIndex(1);




        Thread.sleep(10000);
        driver.quit();
    }
}
