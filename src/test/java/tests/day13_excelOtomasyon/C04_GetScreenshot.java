package tests.day13_excelOtomasyon;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C04_GetScreenshot extends TestBase {

    @Test
    public void aramaTesti() throws IOException {

        // Testotomasyon anasayfaya gidin
        driver.get("https://www.testotomasyonu.com");

        // Nutella için arama yapın
        WebElement aramaKutusu= driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        // Arama sonucunda Urun bulunamadığını test edin
        WebElement aramaSonucuElementi= driver.findElement(By.xpath("//*[@*='product-count-text']"));

        String expectedSunucYazisi="0 Products Found";
        String actualSonucYazisi=aramaSonucuElementi.getText();

        Assert.assertEquals(expectedSunucYazisi,actualSonucYazisi);

        ReusableMethods.bekle(1);
        // Teslerimiz Sırasında istersek tüm sayfanın istersek de
        // Bir web elementin görüntüsünü Kaydedebiliriz

        // Eger tüm sayfa ScreenShot almak istersek 4 adımı gerçekleştirmeliyiz

        // 1 - bir TakesScreenShot objesi oluştur ve deger olarak driver ı atayın
        TakesScreenshot tss= (TakesScreenshot) driver;

        // 2- ScreenShot ı kaydedecegimiz bir dosya oluşturalım ve dosyanın uzantısını verelim (tss.jpeg)
        File tumSayfaScreenShot=new File("target/tumSayfaScreenShot/tss.jpeg");

        // 3- tss objesini kullanarak ScreenShot alın ve bir File olarak kaydedin
        File geciciDosya=tss.getScreenshotAs(OutputType.FILE);

        // 4-  gecici dosyayı deger olarak asıl kaydedilecek File a atayın yani kopyalayın
        FileUtils.copyFile(geciciDosya,tumSayfaScreenShot);





        ReusableMethods.bekle(3);

    }
}
