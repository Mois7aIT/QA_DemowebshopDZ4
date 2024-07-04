package com.demoshop.five.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends TestBase {

    @Test
    public void loginPositiveTest(){
        click(By.cssSelector("[href='/login']"));
        type(By.id("Email"), "lenapracht@gm.com");
        type(By.id("Password"),"Qwerty123");
        click(By.cssSelector(".button-1.login-button"));

        Assert.assertTrue(isTextPresent
                (By.cssSelector(".header-links-wrapper:nth-child(2) [href='/customer/info']"),"lenapracht@gm.com"));
    }

}


