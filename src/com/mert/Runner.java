package com.mert;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mert.entity.HobiOzelListe;
import com.mert.entity.MaasOzelListe;
import com.mert.entity.OgrenciOzelListe;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OgrenciOzelListe ogrenciOzelListe = new OgrenciOzelListe();
        HobiOzelListe hobiOzelListe = new HobiOzelListe();
        MaasOzelListe maasOzelListe = new MaasOzelListe();

        System.out.println("****************************");
        System.out.println("** ÖĞRENCİ BİLGİ SİSTEMİ ***");
        System.out.println("****************************");

        int secim;
        do {
            System.out.println("\n1- Sınıf arkadaşı tanımla");
            System.out.println("2- Hobilerini gir");
            System.out.println("3- Maaş beklentilerini gir");
            System.out.println("4- Sınıf Listesi");
            System.out.println("0- ÇIKIŞ");
            System.out.print("\nSeçiniz....:");
            secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    System.out.print("Kaç öğrenci tanımlayacaksınız....:");
                    int ogrenciSayisi = scanner.nextInt();
                    scanner.nextLine();

                    for (int i = 0; i < ogrenciSayisi; i++) {
                        System.out.print((i + 1) + ". Öğrencinin adı.....:");
                        String ogrenciAdi = scanner.nextLine();
                        ogrenciOzelListe.ogrenciEkle(ogrenciAdi);
                    }
                    break;

                case 2:
                    if (ogrenciOzelListe.getOgrenciListesi().isEmpty()) {
                        System.out.println("Öğrenci tanımlamadan hobi giremezsiniz!");
                    } else {
                        for (String ogrenciAdi : ogrenciOzelListe.getOgrenciListesi()) {
                            boolean[] hobiBilgileri = new boolean[4];

                            System.out.print(ogrenciAdi + " için yürümekten hoşlanır mısın[E/H]?");
                            hobiBilgileri[0] = scanner.next().equalsIgnoreCase("E");

                            System.out.print(ogrenciAdi + " için kitap okumaktan hoşlanır mısın[E/H]?");
                            hobiBilgileri[1] = scanner.next().equalsIgnoreCase("E");

                            System.out.print(ogrenciAdi + " için spor rutinlerin var mı[E/H]?");
                            hobiBilgileri[2] = scanner.next().equalsIgnoreCase("H");

                            System.out.print(ogrenciAdi + " için kod yazmaktan hoşlanır mısın[E/H]?");
                            hobiBilgileri[3] = scanner.next().equalsIgnoreCase("E");

                            scanner.nextLine();

                            hobiOzelListe.hobiEkle(hobiBilgileri);
                        }
                    }
                    break;

                case 3:
                    if (ogrenciOzelListe.getOgrenciListesi().isEmpty()) {
                        System.out.println("Öğrenci tanımlamadan maaş beklentisi giremezsiniz!");
                    } else {
                        for (String ogrenciAdi : ogrenciOzelListe.getOgrenciListesi()) {
                            System.out.print(ogrenciAdi + "in beklentisi...:");
                            double maasBeklentisi = scanner.nextDouble();
                            maasOzelListe.maasEkle(maasBeklentisi);
                        }
                    }
                    break;

                case 4:
                    List<String> ogrenciListesi = ogrenciOzelListe.getOgrenciListesi();
                    List<boolean[]> hobiListesi = hobiOzelListe.getHobiListesi();
                    List<Double> maasListesi = maasOzelListe.getMaasListesi();

                    System.out.println("No  | Ad            | Hobileri                    | Maaş Beklentisi");
                    System.out.println("-------------------------------------------------------------");
                    for (int i = 0; i < ogrenciListesi.size(); i++) {
                        String ogrenciAdi = ogrenciListesi.get(i);
                        boolean[] hobiBilgileri = hobiListesi.get(i);
                        double maasBeklentisi = maasListesi.get(i);

                        String hobiler = getHobiler(hobiBilgileri);

                        System.out.printf("%-4d %-14s %-27s %.3f%n", i + 1, ogrenciAdi, hobiler, maasBeklentisi);
                    }
                    break;

                case 0:
                    System.out.println("Çıkış yapıldı.");
                    break;

                default:
                	System.out.println("Geçersiz seçim!");
                    break;
            }
        } while (secim != 0);

        scanner.close();
    }

    private static String getHobiler(boolean[] hobiBilgileri) {
        List<String> hobiler = new ArrayList<>();
        if (hobiBilgileri[0]) hobiler.add("Yürümek");
        if (hobiBilgileri[1]) hobiler.add("Kitap Okuma");
        if (hobiBilgileri[2]) hobiler.add("Spor");
        if (hobiBilgileri[3]) hobiler.add("Kod Yazma");

        return String.join(",", hobiler);
    }
}
