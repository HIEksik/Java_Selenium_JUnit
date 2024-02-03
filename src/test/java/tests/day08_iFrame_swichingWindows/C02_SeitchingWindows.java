package tests.day08_iFrame_swichingWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C02_SeitchingWindows extends TestBase {
    @Test
    public void yeniWindowTesti(){

        /*
            Bir sayfada test yaparken
            Driver.swichTo().newWindow(....) kullandığımızda
            yeni window u driver a oluşturttugumuz için
            driver otomatik olamak yeni sayfaya geçer

            driver yeni window a  geçtikten sonra eski windowlardan birine dönmesi istenecekse
            dönülecek windowda iken o sayfanın window handle degerini alıp kaydetmeliyiz

            driver.switchTo().window(kaydedilenWindowHAndleDegeri) ile
            o sayfaya dönebiliriz.
         */

        //Yeni bir class olusturun: WindowHandle
        //● testotomasyonu anasayfa adresine gidin.
        driver.get("https://www.testotomasyonu.com");

        //● Sayfa’nin window handle degerini String bir degiskene atayin
        String toWindowHandleDegeri= driver.getWindowHandle(); // window handle degerini kaydettik

        //● Sayfa title’nin “Otomasyon” icerdigini test edin
        String expectedTitleicerik="Otomasyon";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitleicerik));



        //● Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin
        ReusableMethods.bekle(2);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://wisequarter.com");



        //● Sayfa title’nin “Wise Quarter” icerdigini test edin
        expectedTitleicerik="Wise Quarter";
        actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitleicerik));


        //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com");

        //● Sayfa title’nin “Walmart” icerdigini test edin
        expectedTitleicerik="Walmart";
        actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitleicerik));

        //● Ilk acilan sayfaya donun ve testotomasyonu sayfasina dondugunuzu test edin
        driver.switchTo().window(toWindowHandleDegeri);

        expectedTitleicerik="Otomasyon";
        actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitleicerik));

        ReusableMethods.bekle(2);



    }
}
