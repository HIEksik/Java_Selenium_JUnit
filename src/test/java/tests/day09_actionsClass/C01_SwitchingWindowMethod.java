package tests.day09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class C01_SwitchingWindowMethod extends TestBase {

    @Test
    public void test01(){

        //● https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get("https://testotomasyonu.com/addremove");

        //● Sayfa başlığının(title) “Test Otomasyonu” olduğunu doğrulayın.
        String expectedTitle="Test Otomasyonu";
        String actualTitle=driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

        //● 'Please click for Electronics Products' linkine tiklayin.
        driver.findElement(By.xpath("//*[text()='Electronics Products']")).click();

        //● Sayfa başlığının(title) “Test Otomasyonu - Electronics” olduğunu doğrulayın.

        titleIleWindowDegistir("Test Otomasyonu - Electronics");

        expectedTitle="Test Otomasyonu - Electronics";
        actualTitle =driver.getTitle();

        Assert.assertEquals(expectedTitle,actualTitle);

        // Titlesi "Test Otomasyonu" olan windowa geri dönün
        titleIleWindowDegistir("Test Otomasyonu");

        //"Add/Remove Elements" element yazının göründüğünü test edin

        WebElement addremoveYazisi= driver.findElement(By.xpath("//*[text()='Add/Remove Elements']"));

        Assert.assertTrue(addremoveYazisi.isDisplayed());

        //● Sayfa başlığının(title) “Test Otomasyonu - Electronics” windova geçin
        titleIleWindowDegistir("Test Otomasyonu - Electronics");

        // bulunan ürün 16 oldugunu test edin

        List<WebElement> bulunanurunElementleriListi=driver.findElements(By.xpath("//*[@*='product-box mb-2 pb-1']"));

        int expectedUrunsayisi=16;
        int actualUrunSayisi= bulunanurunElementleriListi.size();

        Assert.assertEquals(expectedUrunsayisi,actualUrunSayisi);




        ReusableMethods.bekle(2);
    }

    public void titleIleWindowDegistir(String hedefTitle){

        Set<String> whdSeti=driver.getWindowHandles();

        for (String eachwhd:whdSeti
             ) {
            driver.switchTo().window(eachwhd); // oldugumuz sayfanın whd si

            String oldugumuzSayfaTitle=driver.getTitle(); // oldugumuz sayfanın whd sini aldık

            if (oldugumuzSayfaTitle.equals(hedefTitle)){  // oldugumuz sayfa whd si ile hedef sayfa whd si aynıysa doğru yerdeyiz
                break;
            }
        }

    }

}
