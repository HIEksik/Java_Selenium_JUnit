package tests.day13_excelOtomasyon;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C02_ReadExcell {
    @Test
    public void readExcell() throws IOException {

        String dosyaYolu="src/test/java/tests/day13_excelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fileInputStream);
        Sheet sayfa1= workbook.getSheet("Sayfa1");


        //- 1.satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(sayfa1.getRow(0).getCell(1));
        //- 1.satirdaki 2.hucreyi bir string degiskene atayalim ve yazdiralim
        String istenenHucre=sayfa1.getRow(0).getCell(1).toString();
        System.out.println(istenenHucre);
        //- 2.satir 4.cell’in afganistan’in baskenti oldugunu test edelim
        String expectedHucredegeri="Kabil";
        String actualHucreDegeri=sayfa1.getRow(1).getCell(3).toString();

        Assert.assertEquals(expectedHucredegeri,actualHucreDegeri);

        //- Satir sayisini bulalim
        System.out.println(sayfa1.getLastRowNum()); // 190 son saturun indexi

        //- Fiziki olarak kullanilan satir sayisini bulun
        System.out.println(sayfa1.getPhysicalNumberOfRows());// 191 fiki gördügümüz satır sayısını verdi


        Sheet sayfa2= workbook.getSheet("Sayfa2");

        System.out.println(sayfa2.getLastRowNum()); // 21  Son kullanılan satırın indexi

        System.out.println(sayfa2.getPhysicalNumberOfRows()); // 10 Kullanılan satırları verdi .. boşları saymadı

        // System.out.println(sayfa2.getRow(23).getCell(1)); // NullPointerException
        // WorkBook excell dosyasında kullanılan son satırdan sonrasını almaz
        // o satırlara ulaşmak isterseniz NullPointerExceptions verir

       // System.out.println(sayfa2.getRow(5).getCell(10)); // NullPointerException
        System.out.println(sayfa2.getRow(6).getCell(10)); // null


        //- Ingilizce Ulke isimleri ve baskentleri bir map olarak kaydedelim

        // excell de ingilizce ülke ismi olarak Poland ın oldugunu test edin

        boolean polandVarmi=false;

        for (int i = 0; i <=sayfa1.getLastRowNum(); i++) {

            String satirdakiIngilizceUlkeIsmi=sayfa1.getRow(i).getCell(0).toString();
            if (satirdakiIngilizceUlkeIsmi.equalsIgnoreCase("Poland")){
                polandVarmi=true;
            }
        }

        Assert.assertTrue(polandVarmi);

        // excel de ingilizce ismi Samoa olan ülkenin  başkenti Apia oldugunu test edin

        for (int i = 0; i <=sayfa1.getLastRowNum() ; i++) {
            String satirdakiUlkeIsmi=sayfa1.getRow(i).getCell(0).toString();
            String satirdakiBaskentIsmi=sayfa1.getRow(i).getCell(1).toString();

            if (satirdakiUlkeIsmi.equalsIgnoreCase("Samoa")){
                Assert.assertEquals("Apia",satirdakiBaskentIsmi);
            }

        }

        // Bu iki Testi Map kullanarakta yapalım

        // *****  bunun için önce İngilizce ulke isimleri ve Başkentleri bir map yapalım

        Map<String,String>ulkelerVeBaskentler=new TreeMap<>();

        for (int i = 0; i <=sayfa1.getLastRowNum() ; i++) {
            String satirdakiUlkeIsmi=sayfa1.getRow(i).getCell(0).toString();
            String satirdakiBaskentIsmi=sayfa1.getRow(i).getCell(1).toString();

            ulkelerVeBaskentler.put(satirdakiUlkeIsmi,satirdakiBaskentIsmi);

        }


        // Excell de ingilizce ülke ismi olarak Poland ın oldugunu test edin

        Assert.assertTrue(ulkelerVeBaskentler.containsKey("Poland"));

       // Excel de ingilizce ismi Samoa olan ülkenin  başkenti Apia oldugunu test edin

        Assert.assertEquals("Apia",ulkelerVeBaskentler.get("Samoa"));




    }
}
