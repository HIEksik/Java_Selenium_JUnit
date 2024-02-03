package tests.day10_actionsClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C06_DosyaYuklemetesti extends TestBase {
    @Test
    public void dosyaYuklemeTesti(){
       // Masaüstü dosya yolum
        // C:\Users\LENOVO\Desktop

        //1. Tests packagenin altina bir class oluşturun : C05_UploadFile
        //2. https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //3. chooseFile butonuna basalim
        //4. Yuklemek istediginiz dosyayi secelim.

        /*
        Selenium WebDriver ile çalışır web sayfalarında istenen görevi yapar
        Ancak Kendi bilgisayarımızdaki dosya yapısı içerisinde
        dosya seçmek için click yapamaz


        1- upload yapacağımız dosyanın dosya yolunu kaydedin
        2- upload yapacagımız sitedeki coosFile butonunu locate edip kaydedin
        3- cooseFileButonElementi.sendKeys(yuklenecekDosyanınDosyayolu)

         *///"C:\Users\LENOVO\OneDrive\Masaüstü\spectrum-logo.png"


        WebElement chooseFileButonu= driver.findElement(By.id("file-upload"));

        ReusableMethods.bekle(3);

        String dinamikDosyaYolu=System.getProperty("user.home")+"/Desktop/spectrum-logo.png";

        chooseFileButonu.sendKeys(dinamikDosyaYolu);

        //5. Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        ReusableMethods.bekle(3);


        //6. “File Uploaded!” textinin goruntulendigini test edelim.

        WebElement dosyaYuklendiYazisi= driver.findElement(By.xpath("//*[@class='panel text-center']"));

        Assert.assertTrue(dosyaYuklendiYazisi.isDisplayed());

        ReusableMethods.bekle(3);

    }
}
