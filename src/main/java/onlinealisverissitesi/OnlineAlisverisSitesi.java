package onlinealisverissitesi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OnlineAlisverisSitesi {
    static Scanner input = new Scanner(System.in);// mainden once calisacak.
    //static yapayim ki urun fiyatlarim urun listem her zaman gorunsun.
    static List<String> urunListesi = new ArrayList<>();
    static List<Double> urunFiyatlari = new ArrayList<>();
    static double odenecekMiktar;
    //tum bunlar static block'tur.


    public static void main(String[] args) {
        urunListesi.add(" Saat Urun kodu 0");
        urunListesi.add(" Monitor Urun kodu 1");
        urunListesi.add(" Canta Urun kodu 2");
        urunListesi.add(" TV Urun kodu 3");
        urunListesi.add(" Kitap Urun kodu 4");

        urunFiyatlari.add(150.0);
        urunFiyatlari.add(3000.0);
        urunFiyatlari.add(5000.0);
        urunFiyatlari.add(6000.0);
        urunFiyatlari.add(100.0);

        List<String>yeniUrunler = new ArrayList<>();
        yeniUrunler.add("Taki Urun Kodu 5");
        yeniUrunler.add("Tencere Urun Kodu 6");
        yeniUrunler.add("Kiyafet Urun Kodu 7");
        urunListesi.addAll(yeniUrunler);//ikinci listeyi ilk listeye ekledik.

        List<Double> yenUrunFiyatlari = new ArrayList<>();
        yenUrunFiyatlari.add(9000.0);
        yenUrunFiyatlari.add(200.0);
        yenUrunFiyatlari.add(400.0);
        urunFiyatlari.addAll(yenUrunFiyatlari); //ikinci listeyi ilk listeye ekledik.

        musteriSecim ();

    }//main
    public static void musteriSecim() {//urunleri secebilomesi icin method olusturduk.

        urunListesiniGoster();

        System.out.println("Lutfen urun kodunu giriniz");
        int urunKodu = input.nextInt();

        if(urunKodu>=0 && urunKodu< urunListesi.size()){
            System.out.println("Kac adet istediginizi giriniz.");
            int adet = input.nextInt();//istedigi adedi giriyor.
            double toplamUrunFiyati= urunFiyatlari.get(urunKodu)*adet;
            odenecekMiktar+=toplamUrunFiyati;
            devamMi();

        }else {
            System.out.println("Lutfen gecerli bir urun kodu giriniz");
            musteriSecim();//recursive method.secim yapmaya geri gidiyor.

        }

    }//musteri secim methodu

    private static void devamMi() {//devam etmek istiyor mu? methodu olusturduk.
        System.out.println("Alisverise devam etmek istiyor musunuz?" +
                " \nEvet ise ==>1'e, \nHayir ise ==>2'ye basiniz.");
        int devamMi = input.nextInt();//kullanicinin cevabi
        if (devamMi == 1) {//devam etmek istiyorsa
            musteriSecim();// tekrardan urun secmeye gidiyor.
        } else if (devamMi == 2) {//devam etmek istemiyorsa
            odemeYap();//odemeye yonlendiriliyor.

        } else {
            System.out.println("Lutfen gecerli bir secenek giriniz.");
            devamMi();//recursive
        }
    }

    private static void odemeYap() {// kurulus tarihine denk gelip gelmedigine baktik.

        LocalDate kurulusGunu = LocalDate.of(2023,04,8);//kurulus tarihi
        LocalDate date = LocalDate.now();//alisveris yapilan tarih
        if(date.isEqual(kurulusGunu)){
            SlowPrint("TechPro Alisveris Sitesine Hosgeldiniz." +
                    "\n Bugun Bizim Kurulus Yil Donumumuz. \nBorcunuz yoktur.",50);
        }else {
            SlowPrint("TechPro Alisveris Sitesini TErcih Ettiginiz Icin Tesekkur Ederiz.",50);
            System.out.println("Toplam Odenecek Miktar: "+ odenecekMiktar+ " Tl'dir.");
        }
    }
    private static void SlowPrint(String metin, int gecikme) {
        for (char ch: metin.toCharArray()) {
            System.out.print(ch);
            try {
                Thread.sleep(gecikme);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void urunListesiniGoster() {
        System.out.println("*********Urun Listesi***********");
        for (int i = 0; i < urunListesi.size(); i++) {
            System.out.println(i + " - " + urunListesi.get(i) + " Fiyat " + urunFiyatlari.get(i) + " TL ");

        }


    }
}
