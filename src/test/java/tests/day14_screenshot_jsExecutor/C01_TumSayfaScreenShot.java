package tests.day14_screenshot_jsExecutor;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C01_TumSayfaScreenShot extends TestBase {

    @Test
    public void aramaTesti(){

        // TestOtotmasyonu anasayfaya gidin.
        driver.get("https://www.testotomasyonu.com");

        // Doğru sayfaya gittigimizi testedin
        String expectedUrl="https://www.testotomasyonu.com/";
        String actualUrl=driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);

        // Screensot alın
        ReusableMethods.tumSayfaScreenShot(driver);

        // phone için arama yapın
        WebElement aramaKutusu=driver.findElement(By.id("global-search"));

        aramaKutusu.sendKeys("phone"+ Keys.ENTER);

        // Arama sonucunda urun bulunabildigini test edin

        WebElement aramaSonucu= driver.findElement(By.xpath("//*[@*='product-count-text']"));

        String unExpectedSonucYAzisi="0 Products Found";
        String actualSonucYAzisi=aramaSonucu.getText();

        Assert.assertNotEquals(unExpectedSonucYAzisi,actualSonucYAzisi);


        //Screenshot alın
        ReusableMethods.tumSayfaScreenShot(driver,"Arama sonucu ScreenShot");


    }
}
