package com_nopcommerce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

/**
 * Project-1 - ProjectName : com-nopcommerce
 * BaseUrl = https://demo.nopcommerce.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Navigate to Url.
 * “https://demo.nopcommerce.com/login?returnUrl=
 * %2F”
 * 7. Print the current url.
 * 8. Navigate back to the home page.
 * 9. Navigate to the login page.
 * 10. Print the current url.
 * 11. Refresh the page.
 * 12. Enter the email to email field.
 * 13. Enter the password to password field.
 * 14. Click on Login Button.
 * 15. Close the browser.
 */

public class MultiBrowser {

    static String browser = "Chrome";// declaring the variable
    static String baseUrl = "https://demo.nopcommerce.com/";
    static WebDriver driver; // ??

    public static void main(String[] args) {
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
        }

        // Base Url
        driver.get(baseUrl);

        // maximuzing the window
        driver.manage().window().maximize();

        //Giving implicit wait for driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

        //Print the title of the page
        System.out.println("The page title is: " + driver.getTitle());

        //Print the current url
        System.out.println("The Url is: " + driver.getCurrentUrl());

        //Print the page source
        System.out.println("The page source is: " + driver.getPageSource());

        // Navigate to Url
        driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F");

        //Get current Url
        System.out.println("The current Url is: " + driver.getCurrentUrl());

        // Navigate Back to home page
        driver.navigate().back();

        //Navigate to the login page
        driver.navigate().forward();
        // driver.navigate().to("https://demo.nopcommerce.com/login?returnUrl=%2F"); // other way of doing

        //Print the current url
        System.out.println("The current page is: " + driver.getCurrentUrl());

        // Refresh the page
        driver.navigate().refresh();

        //Enter the email to email field
        driver.findElement(By.id("Email")).sendKeys("Prime123@yahoo.com");

        //Enter the password to password field
        driver.findElement(By.id("Password")).sendKeys("Prime@123");

        //Click on Login Button
        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();

        //Close the browser
        driver.quit();


    }

}
