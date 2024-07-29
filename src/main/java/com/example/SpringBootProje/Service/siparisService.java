package com.example.SpringBootProje.Service;

import com.example.SpringBootProje.Entity.siparis;

import java.util.List;

public interface siparisService {
    List<siparis> findAll();
    siparis save (siparis theSiparis);
    siparis findById (int theId);
    void deletebyId (int theId);

}
