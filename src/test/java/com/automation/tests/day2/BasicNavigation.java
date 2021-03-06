package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BasicNavigation {
    public static void main(String[] args) throws Exception {
        //to start selenium script we need:
        //setup webdriver (browser driver) and create webdriver object
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        //In selenium, everything starts from WebDriver interface
        //ChromeDriver extends RemoteWebDriver --> implements WebDriver
        driver.get("http://google.com");//to open a website
        driver.manage().window().maximize();//to maximize browser
        //driver.manage().window().fullscreen();

        Thread.sleep(3000);//for demo, wait 3 seconds
        //method that return page title
        //you can also see it as tab name, in the browser
        String title = driver.getTitle(); //returns <title>Some title</title> text
        String expectedTitle = "Google";//we provide it

        System.out.println("Title is..." + title);

        if (expectedTitle.equals(title)){
            System.out.println("TEST PASSED!");
    }else {
            System.out.println("TEST FAILED!");
        }
        //go to another website within the same window
        driver.navigate().to("http://amazon.com");

        if(driver.getTitle().toLowerCase().contains("amazon")){
            System.out.println("TEST PASSED!");
        }else {
            System.out.println("TEST FAILED!");
        }
        //comeback to google
        driver.navigate().back();
        //checking if page title is equals to Google
        verifyEquals(driver.getTitle(), "Google");
        //move forward in the browser history
        //again,going to amazon
        driver.navigate().forward();
        System.out.println("Title: "+driver.getTitle());
        //driver.getTitle() - returns page title of the page that is currently opened
        //to get URL
        System.out.println("URL: "+driver.getCurrentUrl());

        driver.navigate().refresh();//to reload page

        //driver.navigate().to() = driver.get()
        //must be at the end
        driver.close();//to close browser
        //browser cannot close itself
    }

    /**
     * Check if to strings are same.If print Test Passed!message
     * *Otherwise,print Test Failed message
     * @param arg1
     * @param arg2
     */

    public static void verifyEquals(String arg1, String arg2){
        if(arg1.equals(arg2)){
            System.out.println("TEST PASSED!");
        }else {
            System.out.println("TEST FAILED!");

        }
    }
}
