package com.example.SpringBootProje.Entity;

import jakarta.persistence.*;

//burada veritabanı tablomuz ile eşleştiriyoruz.
@Entity
@Table(name = "siparis")
public class siparis {

    @Id //id alanının bu öğrenci için primary olduğunu söylemek için kullanılıyor.
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Bu anotasyon, JPA ve Hibernate'de birincil anahtar alanının otomatik olarak veri tabanı tarafından üretileceğini belirtir.
    @Column(name="id") //veritabanı sütunuyle eşleştiriyoruz.
    private int id;

    @Column(name="customer_name")
    private String customerName;

    @Column(name="ürün")
    private String ürün;

    @Column(name="fiyat")
    private int fiyat;

    public siparis() {
    }

    public siparis( String customerName, String ürün, int fiyat) {

        this.customerName = customerName;
        this.ürün = ürün;
        this.fiyat = fiyat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getÜrün() {
        return ürün;
    }

    public void setÜrün(String ürün) {
        this.ürün = ürün;
    }

    public int getFiyat() {
        return fiyat;
    }

    public void setFiyat(int fiyat) {
        this.fiyat = fiyat;
    }

    @Override
    public String toString() {
        return "siparis{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", ürün='" + ürün + '\'' +
                ", fiyat=" + fiyat +
                '}';
    }
}
