package tests.day07_jsAlerts_iFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C02_JsAlerts extends TestBase {

    //3 test method'u olusturup asagidaki gorevi tamamlayin



   @Test
    public void birinciAllertTesti(){
       //1. Test
       //- https://testotomasyonu.com/javascriptAlert adresine gidin
       driver.get("https://testotomasyonu.com/javascriptAlert");

       //- 1.alert'e tiklayin
       driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

       //- Alert'deki yazinin "I am a JS Alert" oldugunu test edin
       String actualAlertYazi=driver.switchTo().alert().getText();
       String expectedAlertYazi="I am a JS Alert";



       Assert.assertEquals(expectedAlertYazi,actualAlertYazi);


       //- OK tusuna basip alert'i kapatin
       driver.switchTo().alert().accept();
   }
   @Test
    public void ikinciAlertTesti(){
       //2.Test
       //- https://testotomasyonu.com/javascriptAlert adresine gidin
       driver.get("https://testotomasyonu.com/javascriptAlert");
       //- 2.alert'e tiklayalim
       driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();

       //- Cancel'a basip,
       driver.switchTo().alert().dismiss();


       //cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
      WebElement cencelYazisi=driver.findElement(By.xpath("//*[@id='result']"));

      String expectedSonucYazisi="You clicked: Cancel";
      String actualSonucYazisi=cencelYazisi.getText();

      Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);

   }
@Test
   public void ucuncuAlertTest(){
   //3.Test
   //- https://testotomasyonu.com/javascriptAlert adresine gidin
   driver.get("https://testotomasyonu.com/javascriptAlert");
   //- 3.alert'e tiklayalim
   driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();


   //- Cikan prompt ekranina "Abdullah" yazdiralim
    driver.switchTo().alert().sendKeys("Abdullah");
   //- OK tusuna basarak alert'i kapatalim
    driver.switchTo().alert().accept();
   //- Cikan sonuc yazisinin Abdullah icerdigini test edelim
    WebElement sonucYazisi=driver.findElement(By.xpath("//*[@id='result']"));

    String actualYazi=sonucYazisi.getText();
    String expectedYazi="Abdullah";

    Assert.assertTrue(actualYazi.contains(expectedYazi));


}



}
