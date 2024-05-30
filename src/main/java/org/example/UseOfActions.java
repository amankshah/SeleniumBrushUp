package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class UseOfActions {
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

        Actions actions = new Actions(driver);
        actions.dragAndDrop(draggable,droppable).build().perform();


        if(driver.findElement(By.cssSelector("#droppable > p")).getText().equals("Dropped!")){
            System.out.println("Dropped ✅");
//            driver.close();
        }else {
            System.out.println("Failed To drop ❌");
        }


        // Perform a right-click (context click) on the element
        actions.contextClick(draggable).perform();

        System.out.println("Right-click performed on the element!");



        //Sending F7 with Value
        actions.keyUp(Keys.F7)

    }
}
