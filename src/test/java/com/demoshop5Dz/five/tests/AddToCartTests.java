package com.demoshop.five.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartTests extends TestBase{

    @BeforeMethod
    public void precondition(){
        click(By.cssSelector("[href='/login']"));
        type(By.id("Email"), "lenapracht@gm.com");
        type(By.id("Password"),"Qwerty123");
        click(By.cssSelector(".button-1.login-button"));
    }
    //позитивный тест на добавление товаров в корзину
    @Test
    public void addItemToCartPositiveTest(){
        //click on Add to cart button
        click(By.cssSelector(".item-box:nth-child(3) .buttons"));
        //click on Shopping cart link
        click(By.id("topcartlink"));
        //Assert item by title
        Assert.assertTrue(isTextPresent(By.cssSelector(".cart-item-row .product>a"), "14.1-inch Laptop"));
    }

    @AfterMethod
    public void postCondition(){
        click(By.name("removefromcart"));
        click(By.name("updatecart"));
    }


}
