package com.example.SpringBootProje.Service;

import com.example.SpringBootProje.Entity.siparis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.SpringBootProje.dao.siparisDAO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//Bu anotasyon, sınıfın bir Spring Bean olduğunu ve servis katmanında bulunacağını belirtir.
// Ayrıca veri erişim ile sunum katmanları arasında köprü görevi görür.
@Service

//Bu sınıf, servis katmanında bulunur ve siparis entity'si için crud işlemler içerir.
// Bu katman, DAO katmanıyla etkileşime girer.
public class siparisServiceImpl implements siparisService {
    private siparisDAO SiparişDAO;

    @Autowired
    public siparisServiceImpl(siparisDAO thesiparisDAO) {
        SiparişDAO = thesiparisDAO;
    }

    //DAO katmanındaki findAll yöntemini çağırır ve tüm siparis entity'lerini döner.
    @Override
    public List<siparis> findAll() {
        return SiparişDAO.findAll();
    }

    //Bu anotasyon, yöntemin bir işlem (transaction) içinde çalışmasını sağlar. Yöntem başarılı olursa işlem tamamlanır,
    // aksi halde geri alınır.(commit ve rollback yapar kısaca)
    @Transactional

   // DAO katmanındaki save yöntemini çağırır ve yeni bir sipariş entity'i kayıt eder.
    @Override
    public siparis save(siparis theSiparis) {
        return SiparişDAO.save( theSiparis);
    }

    //DAO katmanındaki findById yöntemini çağırır ve belirtilen ID'ye sahip siparis entity'sini döner.
    @Override
    public siparis findById(int theId) {
        return SiparişDAO.findById(theId);
    }

    @Transactional

    //DAO katmanındaki deletebyId yöntemini çağırır ve belirtilen ID'ye sahip siparis entity'sini siler.
    @Override
    public void deletebyId(int theId) {
         SiparişDAO.deletebyId(theId);
    }


}