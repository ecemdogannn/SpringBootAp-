package com.example.SpringBootProje.dao;


import com.example.SpringBootProje.Entity.siparis;
import java.util.List;

public interface siparisDAO {
    List<siparis> findAll(); //siparişleri listeler.
    siparis save (siparis theSiparis); // yeni sipariş kaydı yapar.
   siparis findById (int theId); // belirlibir siparişi getirir.
    void deletebyId(int theId); //istenilen bir siparişi siler.

}
