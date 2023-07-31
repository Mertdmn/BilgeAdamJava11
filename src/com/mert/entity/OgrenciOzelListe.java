package com.mert.entity;

import java.util.ArrayList;
import java.util.List;

public class OgrenciOzelListe {
	
	private List<String> ogrenciListesi;

    public OgrenciOzelListe() {
        ogrenciListesi = new ArrayList<>();
    }

    public void ogrenciEkle(String ogrenciAdi) {
        ogrenciListesi.add(ogrenciAdi);
    }

    public List<String> getOgrenciListesi() {
        return ogrenciListesi;
    }
}
