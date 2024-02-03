package tests.day14_screenshot_jsExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class C02_istenenWebElementScreenShot extends TestBase {

    @Test
    public void aramaTesti() throws IOException {

        // TestOtotmasyonu anasayfaya gidin.
        driver.get("https://www.testotomasyonu.com");

        // Arama kutusuna phone yazıp arama kutusunun ScreenShot ını alın

              // 1- ScreenShot alacağınız webelementi locate edip kaydedin
        WebElement aramakutusu= driver.findElement(By.id("global-search"));
        aramakutusu.sendKeys("phone");
              // 1- ScreenShot alacağınız webelementi locate edip kaydedin
              // 2- ScreenShot ı kaydedecegimiz dosyayı olusturun
        File webElementScreenShot=new File("target/webelementScreenShots/aramaKutusu.jpg");
              // 3- Webelementi kullanarak Screenshot alın ve gecici dosyaya kaydedin
        File gecisiScreenShot= aramakutusu.getScreenshotAs(OutputType.FILE);
              // 4- Gecici dosyayı Asıl dosyaya kopyalayalım
        FileUtils.copyFile(gecisiScreenShot,webElementScreenShot);




        // phone için arama yapın
        aramakutusu.submit();

        // Arama sonucunda urun bulunabildigini test edin
        WebElement aramaSonucu= driver.findElement(By.xpath("//*[@*='product-count-text']"));
        String unExpectedSonucYAzisi="0 Products Found";
        String actualSonucYAzisi=aramaSonucu.getText();

        Assert.assertNotEquals(unExpectedSonucYAzisi,actualSonucYAzisi);


        // arama Sonuc yazısının ScreenShot ını alın

        ReusableMethods.webelementScreenshot(aramaSonucu);

        ReusableMethods.webelementScreenshot(aramaSonucu,"arama sonucu");


        ReusableMethods.bekle(2);

    }
}
