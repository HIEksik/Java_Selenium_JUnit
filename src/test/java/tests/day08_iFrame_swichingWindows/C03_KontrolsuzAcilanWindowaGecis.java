package tests.day08_iFrame_swichingWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class C03_KontrolsuzAcilanWindowaGecis extends TestBase {

    @Test
    public void kontrolsuzWindowTesti(){
        //1- https://testotomasyonu.com/discount adresine gidin
        driver.get("https://testotomasyonu.com/discount");
        //2- Elektronics Products yazisinin gorunur olduğunu test edin
                // Yazı İframe içinde oldugundan önce onu locate etmemmiz lazım
        WebElement iFrameElementi=driver.findElement(By.xpath("(//iframe)[1]"));
        driver.switchTo().frame(iFrameElementi);

        WebElement electronixYaziElementi=driver.findElement(By.xpath("//*[text()='Electronics Products']"));
        Assert.assertTrue(electronixYaziElementi.isDisplayed());


        //3- Dell bilgisayar urun isminin ‘DELL Core I3 11th Gen’ olduğunu test edin
        WebElement dellElementi= driver.findElement(By.id("dell-core"));
        String expectedUrunIsmi="DELL Core I3 11th Gen";
        String actualUrunIsmi=dellElementi.getText();

        Assert.assertEquals(expectedUrunIsmi,actualUrunIsmi);

             //* click yapılmadan önce kontrolsüz olarak yeni bir TAB açıldıgından driver yeni taba geçmez
            //* eski windowda kalır.
           // bu durumda ikinci sayfanın window handle degerini bulabilmek için 3 adıma ihtiyacımız var
         //1- adım : ilk window un Window hanle degerini kaydedelim
        String ilkWindowWHD=driver.getWindowHandle();


        //4- Dell bilgisayar’a tiklayip acilan sayfada urun fiyatinin $399.00 olduğunu test edin.
        dellElementi.click();

        // 2- adım : Clikc yapıldıktan sonra window handle degeriniz kaydettigimiz ilk windoe un yanına
        //           Yeni bir TAB açıldı .. getWindowHandles() kullanarak açık olan iki window un
        //          Window handle degerini bir set olarak kaydedelim

        Set<String> whdDegerleriSeti=driver.getWindowHandles();

        // 3 - Adım : whdDegerleriSeti ve ilkWindowWHD ni kullanarak
        //          ikinci window un WHD bulup kaydedin

        String ikinciWHDdegeri="";

        // Foreach kullanarak ilk window degerine eşit olmayanı oluşturdugumuz String e Set ten atadık atadık
        for (String eachWhd:whdDegerleriSeti
             ) {
            if (!eachWhd.equals(ilkWindowWHD)){
                ikinciWHDdegeri=eachWhd;
            }
        }
        // Şimdi Yeni Window a swich yapabiliriz
        driver.switchTo().window(ikinciWHDdegeri); // ikinci sayfanın window handle degerine geçiş yaptık

        WebElement fiyatElementi=driver.findElement(By.id("priceproduct"));

        String expectedFiyat="$399.00";
        String actualFiyat=fiyatElementi.getText();

        Assert.assertEquals(expectedFiyat,actualFiyat);

        //5- Ilk window'a donun ve "Here are some products." yazisinin gorunur olduğunu test edin
        driver.switchTo().window(ilkWindowWHD);
        WebElement hereAreYazielementi=driver.findElement(By.xpath("//*[text()='Here are some products.']"));

        Assert.assertTrue(hereAreYazielementi.isDisplayed());

        //6- Sayfayi kapatin

        ReusableMethods.bekle(2);


    }
}
