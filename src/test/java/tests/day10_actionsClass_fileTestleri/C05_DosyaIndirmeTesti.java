package tests.day10_actionsClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C05_DosyaIndirmeTesti extends TestBase {

    @Test
    public void dosyaIndirmaTesti(){

        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //3. spectrum-logo.png dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='spectrum-logo.png']")).click();


        ReusableMethods.bekle(5);



        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
            // *** Kodunuzun herkesin bilgisayarında çalışabilmesi için dosya yolunu dinamik yapmalıyız
            // *** internette tıkladığımız downloads klasörüne indirilir

        String dinamikDosyayolu=System.getProperty("user.home")+"/Downloads/spectrum-logo.png";
        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyayolu)));


        //C:\Users\LENOVO\Downloads

        System.out.println(System.getProperty("user.home")); // C:\Users\LENOVO

    }

}
