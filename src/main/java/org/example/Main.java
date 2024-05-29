package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Create a new instance of the Chrome driver
        WebDriver driver = new ChromeDriver();

        // Navigate to a website
        driver.get("https://www.google.com");

        // Perform some actions (e.g., find elements, click, etc.)

        // Close the browser
//        driver.quit();
    }
}
