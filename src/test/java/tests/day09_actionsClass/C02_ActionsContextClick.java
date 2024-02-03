package tests.day09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C02_ActionsContextClick extends TestBase {

    @Test
    public void test01(){
        //1- https://testotomasyonu.com/click sitesine gidin
        driver.get("https://testotomasyonu.com/click");

        //2- “DGI Drones” uzerinde sag click yapin
                //1.adım : actions objesi oluşturalım
        Actions actions=new Actions(driver);
                // 2. adım : Kullanacağımız web elementi locate edip kaydedelim
        WebElement dgiDronsElementi= driver.findElement(By.id("pic2_thumb"));
                // 3. adım : Actions onbjesi ve kaydettigimiz Web element ile
        //            istenen action ı gerçekleştirelim
        ReusableMethods.bekle(1);
        actions.contextClick(dgiDronsElementi).perform();
        ReusableMethods.bekle(1);
        //3- Alert’te cikan yazinin “Tebrikler!... Sağ click yaptınız.” oldugunu test edin.
        String expectedAllerYazisi="Tebrikler!... Sağ click yaptınız.";
        String actualAllertYazisi=driver.switchTo().alert().getText(); // allerte geçiş yaptık

        Assert.assertEquals(expectedAllerYazisi,actualAllertYazisi);
        ReusableMethods.bekle(1);

        //4- Tamam diyerek alert’i kapatalim

        driver.switchTo().alert().accept(); // alerte geçiş yaptık ve ok tuşuna bastık

        ReusableMethods.bekle(3);

    }
}