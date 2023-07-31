package com.mert.entity;

import java.util.ArrayList;
import java.util.List;

public class HobiOzelListe {
	
	private List<boolean[]> hobiListesi;

    public HobiOzelListe() {
        hobiListesi = new ArrayList<>();
    }

    public void hobiEkle(boolean[] hobiBilgileri) {
        hobiListesi.add(hobiBilgileri);
    }

    public List<boolean[]> getHobiListesi() {
        return hobiListesi;
    }
}
