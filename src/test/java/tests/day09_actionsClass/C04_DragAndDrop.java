package tests.day09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_DragAndDrop extends TestBase {
    @Test
    public void test01(){
        //1- https://testotomasyonu.com/droppable adresine gidelim
        driver.get("https://testotomasyonu.com/droppable");
        //2- Accept bolumunde “Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        Actions action=new Actions(driver);
        WebElement acceptableButonElementi= driver.findElement(By.xpath("//*[text()='Acceptable']"));
        WebElement drophereElementi=driver.findElement(By.xpath("//*[@id='droppable2']"));

        ReusableMethods.bekle(2);
        action.dragAndDrop(acceptableButonElementi,drophereElementi).perform();


        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        String expectedYazi="Dropped!";
        String actualYazi=drophereElementi.getText();

        Assert.assertEquals(expectedYazi,actualYazi);
        //4- Sayfayi yenileyin
        driver.navigate().refresh();
        //5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        WebElement notAcceptableButonElementi=driver.findElement(By.xpath("//*[@id='draggable-nonvalid2']"));
        drophereElementi=driver.findElement(By.xpath("//*[@id='droppable2']"));

        ReusableMethods.bekle(1);
        action.dragAndDrop(notAcceptableButonElementi,drophereElementi).perform();

        //6- “Drop Here” yazisinin degismedigini test edin

        expectedYazi="Drop Here";
        actualYazi=drophereElementi.getText();

        Assert.assertEquals(expectedYazi,actualYazi);

        ReusableMethods.bekle(2);
    }
}
