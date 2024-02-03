package tests.day10_actionsClass_fileTestleri;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_OdevTest extends TestBase {
    @Test
    public void odevTesti(){
        //1- "http://webdriveruniversity.com/Actions" sayfasina gidin
        driver.get("http://webdriveruniversity.com/Actions");

        //2- Hover over Me First" kutusunun ustune gelin
        Actions actions=new Actions(driver);
        WebElement hoverovermeFirstKutusu=driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        ReusableMethods.bekle(1);
        actions.moveToElement(hoverovermeFirstKutusu).perform();
        ReusableMethods.bekle(1);

        //3- Link 1" e tiklayin
        WebElement link1=driver.findElement(By.xpath("(//*[@class='list-alert'])[1]"));
        link1.click();

        //4- Popup mesajini yazdirin
        String popupYazi=driver.switchTo().alert().getText();
        System.out.println(popupYazi);

        //5- Popup'i tamam diyerek kapatin
        driver.switchTo().alert().accept();
        ReusableMethods.bekle(3);

        //6- “Click and hold" kutusuna basili tutun
        WebElement clickYazisiElementi=driver.findElement(By.xpath("//*[@id='click-box']"));
        actions.clickAndHold(clickYazisiElementi).perform();
        ReusableMethods.bekle(3);
        //7-“Click and hold" kutusunda cikan yaziyi yazdirin
        String clickCikanYazi=clickYazisiElementi.getText();
        System.out.println(clickCikanYazi);
        ReusableMethods.bekle(3);

        //8- “Double click me" butonunu cift tiklayin
        WebElement ciftTik= driver.findElement(By.xpath("//*[@class='div-double-click']"));
        actions.doubleClick(ciftTik).perform();

        ReusableMethods.bekle(2);
    }

}
