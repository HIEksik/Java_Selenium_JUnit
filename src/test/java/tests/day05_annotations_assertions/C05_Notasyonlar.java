package tests.day05_annotations_assertions;

import org.junit.*;

public class C05_Notasyonlar {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("Before Class çalıştı");
    }
    @AfterClass
    public static void afterClass() {
        System.out.println("Afret Class çalıştı");
    }

    @Before
    public void setup(){
        System.out.println("Before methodu çalıştı");
    }
    @After
    public void teardown(){
        System.out.println("After methodu çalıştı");
    }

    @Test
    public void test01(){
        System.out.println("test 01 çalıştı");
    }
    @Test
    public void test02(){
        System.out.println("test 02 çalıştı");
    }
    @Test
    public void test03(){
        System.out.println("test 03 çalıştı");
    }

}
