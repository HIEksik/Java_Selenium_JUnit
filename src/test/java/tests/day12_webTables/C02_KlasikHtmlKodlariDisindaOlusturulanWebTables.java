package tests.day12_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C02_KlasikHtmlKodlariDisindaOlusturulanWebTables extends TestBase {
    @Test
    public void test01(){

        //          (//*[@role='trow'])/*[@role='tdata']

        //1. “https://testotomasyonu.com/webtables2” sayfasina gidin
        driver.get("https://testotomasyonu.com/webtables2");

        //2. Headers da bulunan basliklari yazdirin
        WebElement baslikSatirElementi=driver.findElement(By.xpath("//*[@role='hrow']"));
        System.out.println(baslikSatirElementi.getText());

        //3. 3.sutunun basligini yazdirin
        WebElement ucuncuSutunBaslikElementi= driver.findElement(By.xpath("(//*[@role='hdata'])[3]"));
        System.out.println(ucuncuSutunBaslikElementi.getText());

        //4. Tablodaki tum datalari yazdirin
        List<WebElement> tabloTumdatalar= driver.findElements(By.xpath("//*[@role='tdata']"));

        System.out.println(ReusableMethods.stringListeCevir(tabloTumdatalar));


        //5. Tabloda kac tane cell (data) oldugunu yazdirin
        System.out.println("Tablodaki Cell sayisi : "+tabloTumdatalar.size());

        //6. Tablodaki satir sayisini yazdirin
        List<WebElement> tabloSatirSayisi=driver.findElements(By.xpath("//*[@role='trow']"));
        System.out.println("Tablodaki satir sayisi : "+tabloSatirSayisi.size());

        //7. Tablodaki sutun sayisini yazdirin ( herhangi bir satırdaki dataları bulursak sutun sayısını buluruz)
        List<WebElement>ikinciSatirDataElementleri=driver.findElements(By.xpath("(//*[@role='trow'])[2]/*[@role='tdata']"));

        System.out.println("Tablodaki sütun sayisi : "+ikinciSatirDataElementleri.size());


        //8. Tablodaki 3.kolonu yazdirin //( her satırdaki üçüncü elementi aldık)
        List<WebElement> ucuncuSutunElementlerlist=driver.findElements(By.xpath("(//*[@role='trow'])/*[@role='tdata'][3]"));

        System.out.println(ReusableMethods.stringListeCevir(ucuncuSutunElementlerlist));

        //9. Tabloda " Category" si Furniture olan urunun fiyatini yazdirin

        // category : (//*[@role='trow'])[     3   ]/*[@role='tdata'][2]
        // fiyat    : (//*[@role='trow'])[     3   ]/*[@role='tdata'][3]

        for (int i = 1; i <=tabloSatirSayisi.size() ; i++) {

            String dinamikCategoryXpath="(//*[@role='trow'])["+ i +"]/*[@role='tdata'][2]";
            String dinamikFiyatXpath="(//*[@role='trow'])["+ i +"]/*[@role='tdata'][3]";

            WebElement satirdakiCategoriElementi= driver.findElement(By.xpath(dinamikCategoryXpath));
            WebElement satirdakiFiyatelementi=driver.findElement(By.xpath(dinamikFiyatXpath));

            if (satirdakiCategoriElementi.getText().equalsIgnoreCase("Men Fashion")){
                System.out.println(satirdakiFiyatelementi.getText());
            }
        }

        //10. Bir method olusturun, Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin

        datayiYazdir(3,3);

        ReusableMethods.bekle(2);


    }
    public  void datayiYazdir(int satirNo,int sutunNo){

        // (//*[@role='trow'])[     3   ]/*[@role='tdata'][  2  ]

        String dinamikXpath="(//*[@role='trow'])["+ satirNo +"]/*[@role='tdata']["+sutunNo+"]";

        WebElement istenenHucreElementi=driver.findElement(By.xpath(dinamikXpath));

        System.out.println("İstenen hucredeki data : "+istenenHucreElementi.getText());

    }
}
