package tests.day08_iFrame_swichingWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class C04_KontrolsuzAcilanWindowaGecis extends TestBase {

    @Test
    public void test01(){
        //● https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get("https://testotomasyonu.com/addremove");
        //● Sayfadaki textin “Add/Remove Elements” olduğunu doğrulayın.
        WebElement textElementi= driver.findElement(By.xpath("//*[text()='Add/Remove Elements']"));
        String expectedYazi="Add/Remove Elements";
        String actualYazi=textElementi.getText();

        Assert.assertEquals(expectedYazi,actualYazi);

        //● Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.
        String expectedTitle="Test Otomasyonu";
        String actualTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);

        String ilkWindowHandledegeri=driver.getWindowHandle();
        // ***** yeni tab açıldıgı için ilk window degerini alıp bir köşede tutmamız lazım



        //● 'Please click for Electronics Products' linkine tiklayin.
        driver.findElement(By.xpath("//*[text()='Electronics Products']")).click();


        //● Electronics sayfasinin acildigini test edin

        //***** İkinci Window kontrolsüz açıldıgı için Handle degerini bulup O window a geçmeliyiz
        Set<String> windowHandelDegerSeti=driver.getWindowHandles();

        String ikinciWindowHandle="";

        for (String eachWindowHanle:windowHandelDegerSeti
             ) {
            if (!eachWindowHanle.equals(ilkWindowHandledegeri)){
                ikinciWindowHandle=eachWindowHanle;
            }
        }

        // ** Şimdi ikinci sayfaya geçiş yapabiliriz
        driver.switchTo().window(ikinciWindowHandle);

        // Electronix sayfasının açıldığını tets edelim asıl istenen soru (tercih Sayfa başlıgı oldu)
        String expectedTitleIcerik="Electronics";
         actualTitle=driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));



        //● Bulunan urun sayisinin 16 olduğunu test edin
        List<WebElement> urunElementleriListi=driver.findElements(By.xpath("//*[@class='product-box mb-2 pb-1']"));

        int expectedUrunsayisi=16;
        int actualUrunSayisi=urunElementleriListi.size();
        Assert.assertEquals(expectedUrunsayisi,actualUrunSayisi);

        //● Ilk actiginiz addremove sayfasina donun
        driver.switchTo().window(ilkWindowHandledegeri);

        //● Url’in addremove icerdigini test edin

        String expectedUrlIcerik="addremove";
        String actualUrl=driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrlIcerik));


    }
}
