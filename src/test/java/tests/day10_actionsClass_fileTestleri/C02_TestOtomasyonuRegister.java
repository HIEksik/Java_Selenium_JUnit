package tests.day10_actionsClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C02_TestOtomasyonuRegister extends TestBase {
    @Test
    public void kayitOlusturmaTesti(){
        //1- https://www.testotomasyonu.com adresine gidelim
        driver.get("https://www.testotomasyonu.com ");
        //2- Account linkine tiklayin
        driver.findElement(By.xpath("(//a[@class='e-cart'])[1]")).click();

        //3- Sign Up linkine basalim
        driver.findElement(By.xpath("//*[@class='sign-up ']")).click();
        Actions actions=new Actions(driver);

        for (int i = 0; i < 5; i++) {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
        }

        ReusableMethods.bekle(3);

        //4- Ad, soyad, mail ve sifre kutularina deger yazalim ve Sign Up butonuna basalim
        WebElement firsNameKutusu= driver.findElement(By.id("firstName"));



        ReusableMethods.bekle(1);


        actions.click(firsNameKutusu)



                .sendKeys("Harf")
                .sendKeys(Keys.TAB)
                .sendKeys("Hirf")
                .sendKeys(Keys.TAB)
                .sendKeys("Harf@hotmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("Harf123")
                .sendKeys(Keys.TAB)
                .sendKeys("Harf123")
                .perform();


        ReusableMethods.bekle(1);

       WebElement butonGiris= driver.findElement(By.xpath("//button[@*='btn-submit-form']"));
       butonGiris.click();

       ReusableMethods.bekle(1);

        //5- Kaydin olusturuldugunu test edin
        WebElement emailKutusu=driver.findElement(By.xpath("//input[@id='email']"));

        emailKutusu.sendKeys("Harf@hotmail.com");

        WebElement sifreKutusu= driver.findElement(By.xpath("//input[@id='password']"));

        sifreKutusu.sendKeys("Harf123");

        WebElement singinbutonu= driver.findElement(By.xpath("//*[@id='submitlogin']"));
        singinbutonu.click();

        WebElement uyeEmailElementi= driver.findElement(By.xpath("//p[text()='Harf@hotmail.com']"));

        Assert.assertTrue(uyeEmailElementi.isDisplayed());


        ReusableMethods.bekle(1);

    }
}
