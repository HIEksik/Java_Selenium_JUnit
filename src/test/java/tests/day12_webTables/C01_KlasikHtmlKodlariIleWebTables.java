package tests.day12_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C01_KlasikHtmlKodlariIleWebTables extends TestBase {

    @Test
    public void test01(){
        //1."https://testotomasyonu.com/webtables" adresine gidin
        driver.get("https://testotomasyonu.com/webtables");

        //2.Web table tum body’sini yazdirin
        WebElement tumbodyElementi= driver.findElement(By.tagName("tbody"));
        System.out.println(tumbodyElementi.getText());

        //3. Web tablosunda "Comfortable Gaming Chair" bulundugunu test edin
        String expectedTebloIcerik="Comfortable Gaming Chair";
        String actualTumbody=tumbodyElementi.getText();
        Assert.assertTrue(actualTumbody.contains(expectedTebloIcerik));


        //4. Web table Body’sindeki satir sayisinin 5 oldugunu test edin
        List<WebElement> satirlarListesi=driver.findElements(By.xpath("//tbody/tr"));
        int expectedSatirsayisi=5;
        int actualStirsayisi=satirlarListesi.size();
        Assert.assertEquals(expectedSatirsayisi,actualStirsayisi);

        //5. Tum satirlari yazdirin
        System.out.println("METhod Kullandık ===============satirlar Listesi=================");
        List<String> satiryazilariListi=ReusableMethods.stringListeCevir(satirlarListesi);
        System.out.println(satiryazilariListi);


        System.out.println("For ile yazdım =====================================================");

        String listeler="";
        for (WebElement aech:satirlarListesi
             ) {
            listeler+=aech.getText();
            System.out.println(listeler);
        }

        //6. Web table’daki sutun sayisinin 4 olduğunu test edin
        List<WebElement> ucuncuSatirDatalarList=driver.findElements(By.xpath("//tbody/tr[3]/td"));

        int expectedSutunSayisi=4;
        int actualSutunsayisi=ucuncuSatirDatalarList.size();
        Assert.assertEquals(expectedSutunSayisi,actualSutunsayisi);

        //7. 3.sutunu yazdirin
        List<WebElement> ucuncuSutunElementleriList=driver.findElements(By.xpath("//tbody/tr/td[3]"));

        System.out.println(ReusableMethods.stringListeCevir(ucuncuSutunElementleriList));
            /*
        List<String> stringList=new ArrayList<>();

        for (WebElement eachElement:ucuncuSutunElementleriList
        ) {

           stringList.add(eachElement.getText());

        }
        System.out.println(stringList);

             */

        //8. Tablodaki basliklari yazdirin
        WebElement baslikElementi=driver.findElement(By.tagName("thead"));
        System.out.println("Başlıklar :" +baslikElementi.getText());

        //9. Satir ve sutun sayisini parametre olarak alip, hucredeki bilgiyi döndüren bir method olusturun

        System.out.println(dataDondur(2, 3));
        System.out.println(dataDondur(4, 2));


        //10. 4.satirdaki category degerinin "Furniture" oldugunu test edin

        String expectedData="Furniture";
        String actualData=dataDondur(4,2);

        Assert.assertEquals(expectedData,actualData);



        ReusableMethods.bekle(1);
    }

    public String dataDondur(int satirNo , int sutunNo){

        //       //tbody/tr[ (satırNo) 4 ]/td[ (sütunNo) 1 ]


        String dinamikXpath="//tbody/tr[" + satirNo + "]/td[" + sutunNo+ "]";
        WebElement istenenHucreElementi=driver.findElement(By.xpath(dinamikXpath));

        return istenenHucreElementi.getText();


    }
}
