package com.mert.entity;

import java.util.ArrayList;
import java.util.List;

public class MaasOzelListe {
	
	private List<Double> maasListesi;

    public MaasOzelListe() {
        maasListesi = new ArrayList<>();
    }

    public void maasEkle(double maasBeklentisi) {
        maasListesi.add(maasBeklentisi);
    }

    public List<Double> getMaasListesi() {
        return maasListesi;
    }
}
