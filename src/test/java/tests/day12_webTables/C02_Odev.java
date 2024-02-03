package tests.day12_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C02_Odev extends TestBase {

    @Test
    public void test01(){
        //1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        //2. Headers da bulunan basliklari yazdirin
        WebElement headersBaslik= driver.findElement(By.xpath("//*[@class='rt-thead -header']"));
        System.out.println(headersBaslik.getText());

        //3. 3.sutunun basligini yazdirin
        WebElement ucuncusutunBAsligi=driver.findElement(By.xpath("(//*[@role='row'])/*[@role='columnheader'][3]"));
        System.out.println(ucuncusutunBAsligi.getText());
        //4. Tablodaki tum datalari yazdirin
        List<WebElement> tumData=driver.findElements(By.xpath("(//*[@role='row'])/*[@role='gridcell']"));


        List<String> stringListData=new ArrayList<>();

        for (WebElement eachData:tumData
        ) {

            stringListData.add(eachData.getText());

        }
        System.out.println(stringListData);


        //5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
         tumData=driver.findElements(By.xpath("(//*[@role='row'])/*[@role='gridcell']"));


        List<String> stringBosOlmayan=new ArrayList<>();

        for (WebElement aechData:tumData
        ) {

            if (!aechData.getText().equalsIgnoreCase(" ")){
                stringBosOlmayan.add(aechData.getText());
            }

        }
        System.out.println(stringBosOlmayan.size());


        //6. Tablodaki satir sayisini yazdirin
        List<WebElement>satirsayisi=driver.findElements(By.xpath("//*[@role='row']"));
        System.out.println(satirsayisi.size());

        //7. Tablodaki sutun sayisini yazdirin
        List<WebElement>sutunSayisi=driver.findElements(By.xpath("(//*[@role='row'])[2]/*[@role='gridcell']"));
        System.out.println(sutunSayisi.size());
        //8. Tablodaki 3.kolonu yazdirin
        List<WebElement>ucuncuKolon=driver.findElements(By.xpath("(//*[@role='row'])/*[@role='gridcell'][3]"));

        List<String> ucuncuKol=new ArrayList<>();

        for (WebElement eachData:ucuncuKolon
        ) {

            ucuncuKol.add(eachData.getText());

        }
        System.out.println(ucuncuKol);

        //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        WebElement firstKierra=driver.findElement(By.xpath("(//*[@role='row'])[4]/*[@role='gridcell'][5]"));

        System.out.println(firstKierra.getText());

        //10. Page sayfasinda bir method olusturun, Test sayfasindan satir ve sutun
        //sayisini girdigimde bana datayi yazdirsin

        datayiYaz(3,5);


    }
    public  void datayiYaz(int satirNumara,int sutunNumara){


        // (//*[@role='row'])[  4  ]/*[@role='gridcell'][  5  ]
        String dinamikXpath="(//*[@role='row'])["+ satirNumara +"]/*[@role='gridcell']["+sutunNumara+"]";

        WebElement istenenHucreElementi=driver.findElement(By.xpath(dinamikXpath));

        System.out.println("Hücredeki Data Degeri : "+istenenHucreElementi.getText());

    }

}