package com.example.SpringBootProje.rest;


import com.example.SpringBootProje.Service.siparisService;
import com.example.SpringBootProje.dao.siparisDAO;
import com.example.SpringBootProje.Entity.siparis;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Bu anotasyon, sınıfın bir REST API kontrolcüsü olduğunu belirtir.
//WEB hizmetlerinin etkileşimi için kullanılır.
@RestController
@RequestMapping("/api") //Bu anotasyon, bu kontrolcünün "/api" path'inde gelen istekleri işleyeceğini belirtir.
public class restController {

    //siparisService adında bir servis nesnesi tanımlanır.
    private siparisService SiparisService;

   // private siparisDAO siparisDAO;
    // sonuçları hızlı bir şekilde döndürün ve  siparisDAO 'sunu enjekte edin.(yapıcı enjeksiyon kullanın.)

    //siparisService nesnesini bağımlılık enjeksiyonu yoluyla alır.
    public restController(siparisService theSiparisService) {
        //siparisDAO = theSiparisDAO;
        SiparisService = theSiparisService;
    }

    //siparişleri listeler.
    @GetMapping("/siparis") //HTTP GET isteklerini "/api/siparis" path'ine yönlendirir.
    public List<siparis> findAll() {
       // return siparisDAO.findAll();
        return SiparisService.findAll();
    }

    //sipariş ekler.
    @PostMapping("/siparis") //path'e yönlendirir. Bu, yeni bir sipariş ekler.
    public siparis addSiparis(@RequestBody siparis thesiparis){ //JSON verilerini sipariş nesnesine dönüştürür.
        System.out.println("siparis eklendi");
        thesiparis.setId(0); //ıd 0 alır ve her yeni siparişte ıd otomatik olarak atanır.
        siparis dbEmployee = SiparisService.save(thesiparis); //Yeni siparişi SiparisService aracılığıyla veri tabanına kaydeder.
        return  dbEmployee; //en son kayıt edileni döndürür.

    }

    //belirli siparişi getir.
    @GetMapping("/siparis/{siparisId}")

    //URL'den {siparisId} değerini alır ve siparisId değişkenine atar.
    public siparis getSiparis(@PathVariable int siparisId){

        siparis thesiparis= SiparisService.findById(siparisId);

        //Sipariş bulunamazsa bir hata mesajı fırlatır.
        if (thesiparis == null){
            throw new RuntimeException("siparis id yok - " + siparisId);
        }
        return thesiparis;
    }

    //siparişi siler.
    @DeleteMapping("/siparis/{siparisId}")
    public String deleteSiparis(@PathVariable int siparisId){

        siparis tempsiparis = SiparisService.findById(siparisId);
        if (tempsiparis == null){
            throw new RuntimeException("siparis İd bulunmuyor - "+ siparisId);

        }
        SiparisService.deletebyId(siparisId);
        return "delete siparis id - " + siparisId;
    }

    // mevcut siparişi günceller.
    @PutMapping("/siparis")
    public siparis updateEmployee(@RequestBody siparis theSiparis){

        //Güncellenmiş siparişi veri tabanına kaydeder.
        siparis dbEmployee = SiparisService.save(theSiparis);
        return  dbEmployee; //güncellenmiş siparişi döndürür.
    }
}

