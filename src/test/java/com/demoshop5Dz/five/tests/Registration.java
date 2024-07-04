package com.demoshop.five.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class Registration extends TestBase{

//проверка регистрации
@Test
    public void createAccountPositiveTest(){

    int i = new Random().nextInt(1000) + 1000;

    click(By.cssSelector("[href='/register']"));
    type(By.id("FirstName"), "Lena");
    type(By.id("LastName"), "Pracht");
    type(By.id("Email"), "lenapracht"+i+"@gm.com");
    type(By.id("Password"), "Qwerty123");//как можно сделать так, что бы можно было много раз зарегистрироваться
    type(By.id("ConfirmPassword"), "Qwerty123");
    click(By.id("register-button"));

    //lenapracht1513@gm.com
    Assert.assertTrue(isElementPresent(By.cssSelector("[href='/logout']")));
}

    //проверка существующего пользователя

    @Test
    public void createAccountUserPositiveTest(){

        int i = new Random().nextInt(1000) + 1000;

        click(By.cssSelector("[href='/register']"));
        type(By.id("FirstName"), "Lena");
        type(By.id("LastName"), "Pracht");
        type(By.id("Email"), "lenapracht@gm.com");
        type(By.id("Password"), "Qwerty123");//как можно сделать так, что бы можно было много раз зарегистрироваться
        type(By.id("ConfirmPassword"), "Qwerty123");
        click(By.id("register-button"));

        //lenapracht1513@gm.com
        Assert.assertTrue(isElementPresent(By.cssSelector("[href='/logout']")));
    }


    //проверка регистрации
    @Test
    public void createExistedAccountNegativeTest(){

        click(By.cssSelector("[href='/register']"));
        type(By.id("FirstName"), "Lena");
        type(By.id("LastName"), "Pracht");
        type(By.id("Email"), "lenapracht@gm.com");
        type(By.id("Password"), "Qwerty123");//как можно сделать так, что бы можно было много раз зарегистрироваться
        type(By.id("ConfirmPassword"), "Qwerty123");
        click(By.id("register-button"));

        //lenapracht1513@gm.com
        Assert.assertTrue(isElementPresent(By.cssSelector(".validation-summary-errors")));
    }

}

