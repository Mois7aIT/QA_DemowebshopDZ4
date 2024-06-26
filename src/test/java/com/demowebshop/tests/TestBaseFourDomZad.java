package com.demowebshop.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TestBaseFourDomZad extends TestBase{


    @Test
    public void FindElementByTagName(){

        //ищем элемент по тэгу
        WebElement element = driver.findElement(By.tagName("li"));
        System.out.println(element.getText());

        //ищем элемент по тэгу
        WebElement element0 = driver.findElement(By.tagName("form"));
        System.out.println(element0.getText());

        WebElement element1 = driver.findElement(By.tagName("a"));
        System.out.println(element1.getText());

        //ищем список элементов

        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println(elements.size());


        List<WebElement> elements1 = driver.findElements(By.tagName("ul"));
        System.out.println(elements1.size());
        //в консоли выводит кол-во элеметов где есть значения
    }

    @Test
    public void findElementByLocator() {
        //стратегия id
        driver.findElement(By.id("bar-notification"));

        driver.findElement(By.id("dialog-notifications-error"));

        driver.findElement(By.id("dialog-notifications-success"));


        //стратегия уникальности класса
        WebElement login = driver.findElement(By.className("ico-login"));
        System.out.println(login.getText());

        WebElement register = driver.findElement(By.className("ico-register"));
        System.out.println(register.getText());

        //link текст - это текст который находится рядом с линком
        //WebElement linkText = driver.findElement(By.linkText("Let the car work"));
        //System.out.println(linkText.getText());
        //вывод в консоль Let the car work

        try {
            // ищу ссылку с текстом "Shopping cart"
            WebElement linkText = driver.findElement(By.linkText("Shopping cart"));

            // Вывод текст ссылки в консоль
            System.out.println(linkText.getText());
            // Попроб. найти элемент с помощью XPath
            WebElement partialLinkText = driver.findElement(By.xpath("//a[contains(text(), 'cart')]"));
            System.out.println(partialLinkText.getText());
        } catch (Exception e) {
            System.out.println("Element not found: " + e.getMessage());
        } finally {
            // Закрываю браузер
            tearDown();
        }


        //partial link text - частичное совпадение текста
        //WebElement partialLinkText = driver.findElement(By.partialLinkText("cart"));
        //System.out.println(partialLinkText.getText());
        // вывод в консоль Let the car work

    }

    @Test
    public void findElementByCssSelector(){
        //tag name -> tag
        //driver.findElement(By.tagName("h1")):
        driver.findElement(By.cssSelector("#bar-notification"));

        driver.findElement(By.cssSelector("#dialog-notifications-error"));


        driver.findElement(By.cssSelector("#dialog-notifications-success"));
        //class -> class css из класа деланм сss
        // driver.findElement(By.className("telephone"));
        driver.findElement(By.cssSelector(".ico-login"));

        driver.findElement(By.cssSelector(".ico-register"));

        //[attr="value]  пара
        // driver.findElement(By.cssSelector("[ng-reflect-name='city']"));
        //распечатываю селектор который выше
        //WebElement cssSelector = driver.findElement(By.cssSelector("//a[contains(text(), 'cart')]"));
        //System.out.println(cssSelector.getAttribute("type"));

    }

    @Test
    public void findElementByXpath(){
        // //*[@attr='value']  *ищи везде //ищи домен.имя @если не напишем собачку, эта пара не найдется и селениум будет думать, что это метод(даю знать, что это пара)

        //tag name -> //tag
        //driver.findElement(By.cssSelector("h1"));
        //driver.findElement(By.xpath("//h1"));

        //id -> //*[@id='value']
        //driver.findElement(By.cssSelector("#city"));
        driver.findElement(By.xpath("//*[@id='bar-notification']"));

        //class -> //*[@class='value']
        //driver.findElement(By.cssSelector(".telephone"));
        driver.findElement(By.xpath("//*[@class='ico-login']"));

        //text = //tag[text()='Text']
        driver.findElement(By.xpath("//span[text()='Shopping cart']"));
        driver.findElement(By.xpath("//span[.='Shopping cart']"));

        //contains - когда что-то где-то содержится (найти только по одному слову)
        //contains -> //tag[contains(.,'Text')]
        driver.findElement(By.xpath("//span[contains(.,'cart')]"));

        // берем какую-то пару для него
        //contains value -> //tag[contains(@attr,'partialValue')]
        driver.findElement(By.xpath("//input[contains(@class,'box')]"));
        driver.findElement(By.xpath("//div[contains(@class,'links')]"));
        driver.findElement(By.xpath("//ul[contains(@class,'mob')]"));



        //start -> //tag[starts-with(@attr,'startOfValue')]
        driver.findElement(By.xpath("//ul[starts-with(@class,'ui')]"));
        driver.findElement(By.xpath("//input[starts-with(@class,'search')]"));
    }

    @Test
    public void findElementByXpath2(){
        //parent
        driver.findElement(By.xpath("//input/parent::*"));
        driver.findElement(By.xpath("//input/.."));
        driver.findElement(By.xpath("//input/parent::div"));

        //ancestor
        driver.findElement(By.xpath("//input/ancestor::*")); //all
        driver.findElement(By.xpath("//input/ancestor::div"));
        driver.findElement(By.xpath("//input/ancestor::div[2]"));
        driver.findElement(By.xpath("//input/ancestor::div[1]"));

        //following-sibling
        driver.findElement(By.xpath("//input/following-sibling::*")); //all
        driver.findElement(By.xpath("//input/following-sibling::input")); //one option

        //preceding-sibling
        driver.findElement(By.xpath("//input/preceding-sibling::*"));
        driver.findElement(By.xpath("//span/preceding-sibling::*"));

    }
    @Test
    public void isVirtualGiftCardPresentTest(){
        Assert.assertTrue(isVirtualGiftCardPresent());
        // System.out.println("Virtual Gift Card is " + isVirtualGiftCardPresent());
        //driver.findElement(By.cssSelector("div:nth-child(2)>div>div>h2"));
        // driver.findElement(By.cssSelector("//div[2]/div/div/h2"));
    }
    public boolean isVirtualGiftCardPresent(){
        return isElementPresent(By.cssSelector("div:nth-child(2)>div>div>h2"));
    }
}

//input../../..
//parent
//child
//ancestor
//descendant
