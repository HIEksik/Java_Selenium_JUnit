package tests.day09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_ActionsContextClick2 extends TestBase {
    @Test
    public void test01(){
        //1- Yeni bir class olusturalim: MouseActions1
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //3- Cizili alan uzerinde sag click yapin
        Actions actions=new Actions(driver);
        WebElement ciziliAlanElementi=driver.findElement(By.id("hot-spot"));
        actions.contextClick(ciziliAlanElementi).perform();// sağ tık yapıyoruz
        ReusableMethods.bekle(1);

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedAlertYAzi="You selected a context menu";
        String actualYazi=driver.switchTo().alert().getText(); // alert e geçiş yapıyoruz

        Assert.assertEquals(expectedAlertYAzi,actualYazi);
        ReusableMethods.bekle(1);
        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept(); // alert e tamam diyoruz

        //6- Elemental Selenium linkine tiklayalim
                    // ** Link tıkladıgında yeni bir tab açılıyor . o tab a geçmek için C01 deki methodu kullanalım
        WebElement linkYazisi= driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        linkYazisi.click();

        ReusableMethods.bekle(1);
        ReusableMethods.titleIleWindowDegistir("Elemental Selenium | Elemental Selenium",driver);



        //7- Acilan sayfada h1 taginda “Make sure your code lands” yazdigini test edelim

        WebElement h1TagElementi= driver.findElement(By.xpath("//*[@class='home-header']"));
        String expectedYaziElementi="Make sure your code lands";
        String actualYaziElementi=h1TagElementi.getText();

        Assert.assertEquals(expectedYaziElementi,actualYaziElementi);



        ReusableMethods.bekle(2);

    }
}
