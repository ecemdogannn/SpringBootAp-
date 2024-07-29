package com.example.SpringBootProje.dao;

import com.example.SpringBootProje.Entity.siparis;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

//Bu anotasyon, sınıfın bir Spring Bean olduğunu ve bir veri erişim katmanı olarak kullanılacağını belirtir.
@Repository

//Bu sınıf, siparis entity'si için temel CRUD  işlemlerini gerçekleştiren bir JPA veri erişim katmanıdır.
public class siparisDAOJpaImpl implements siparisDAO{

    // Veritabanı işlemlerini gerçekleştirmek için kullanılan JPA arayüzü.
    private EntityManager entityManager;
    @Autowired
    //yapıcı enjeksiyonunu kullanarak varlık yöneticisini enjekte edilir.
    public siparisDAOJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    //siparişleri listeleme
    @Override
    public List<siparis> findAll() {
        //TypedQuery - JPQL sorgusu oluşturur.siparis entity'sinin tüm örneklerini getirir.
        //Sorgu sonuçlarını bir liste olarak döner.

        TypedQuery<siparis> theQuery = entityManager.createQuery("from siparis" , siparis.class);
        List<siparis> Sipariss = theQuery.getResultList();

        return Sipariss;
    }

    //yeni bir sipariş kaydetme
    @Override
    public siparis save(siparis theSiparis) {

        //merge yöntemi, güncellenmiş veya oluşturulmuş entity'yi döner.
        siparis dbEmployee=  entityManager.merge(theSiparis);
        return dbEmployee;
    }

    // belirli bir siparişi bulma
    @Override
    public siparis findById(int theId) {

        //find -  belirtilen ID'ye sahip bir entity'yi bulur ve döner.
        siparis thesiparis=  entityManager.find(siparis.class,theId);

        return thesiparis;
    }

    //Sipariş silme
    @Override
    public void deletebyId(int theId) {

        //silinecek ıd bulunur ve bulunan entity'yi veritabanından siler. Entity null değilse silme işlemi gerçekleştirilir.
        siparis thesiparis=  entityManager.find(siparis.class, theId);
        entityManager.remove(thesiparis);
    }
}
