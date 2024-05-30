package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Alerts {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        //-------------U R L -----------------
        driver.get("https://artoftesting.com/samplesiteforselenium");
        //--------------/U R L End -------------
        WebElement alertButton = driver.findElement(By.xpath("//*[@id=\"AlertBox\"]/button"));
        WebElement confirmAlertButton = driver.findElement(By.xpath("//*[@id=\"ConfirmBox\"]/button"));
//        WebElement PromptAlertButton = driver.findElement(By.xpath());



        System.out.println(alertButton.getText());
        alertButton.click();
        WebDriverWait wait = new WebDriverWait(driver,5);
        Alert basicAlert = driver.switchTo().alert();
        System.out.println(basicAlert.getText());
        basicAlert.accept();

        Thread.sleep(1000);
        System.out.println(confirmAlertButton.getText());
        confirmAlertButton.click();
         wait = new WebDriverWait(driver,5);
        basicAlert = driver.switchTo().alert();
        System.out.println(basicAlert.getText());
        wait = new WebDriverWait(driver,5);

        String Selection= driver.findElement(By.id("demo")).getText();
        System.out.println("What we have pressed :"+ Selection);
        basicAlert.dismiss();



        Thread.sleep(2000);
        driver.quit();
    }
}
