package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Actions {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //-------------U R L -----------------
        driver.get("https://demoqa.com/droppable/\n");
        //--------------/U R L End -------------

        WebElement droppable = driver.findElement(By.id("droppable"));
        WebElement draggable = driver.findElement(By.id("draggable"));

        org.openqa.selenium.interactions.Actions dragAndDrop = new org.openqa.selenium.interactions.Actions(driver);
        dragAndDrop.dragAndDrop(draggable,droppable).build().perform();


        if(driver.findElement(By.cssSelector("#droppable > p")).getText().equals("Dropped!")){
            System.out.println("Dropped ✅");
            driver.close();
        }else {
            System.out.println("Failed To drop ❌");
        }


    }
}
