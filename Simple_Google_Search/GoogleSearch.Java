package com.aj.seleniumwebautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class GoogleSearch {
    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Open Google
        driver.get("https://www.google.com");

        // Find the search box and enter a query
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Selenium WebDriver");

        // Submit the search form
        searchBox.submit();
        JavascriptExecutor jse=(JavascriptExecutor)driver;
	      jse.executeScript("window.scrollBy(0,250)");
        // Wait for search results to load
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Find and print search results
        List<WebElement> resultLinks = driver.findElements(By.className("LC20lb DKV0Md"));
        for (WebElement link : resultLinks) {
            System.out.println(link.getText() + " - " + link.getAttribute("href"));
        }

        // Close the browser
        driver.quit();
    }
}

