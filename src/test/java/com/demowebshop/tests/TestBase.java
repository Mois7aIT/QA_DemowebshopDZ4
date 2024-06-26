package com.demowebshop.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    //упражнение на поиск элементов
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = new ChromeDriver();

        driver.get("https://demowebshop.tricentis.com/");
        //maximize хотим что бы браузер развернулся до размера моего окна
        driver.manage().window().maximize();
        //wait что бы все элементы загрузились прежде чем начнутся тестирование
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(enabled = true)
    public void tearDown(){
        driver.quit();
    }

    //при помощи этого метода мы проверяем абсолютно любой элемент
    public boolean isElementPresent(By locator){
        return driver.findElements(locator).size()>0;
    }
}
