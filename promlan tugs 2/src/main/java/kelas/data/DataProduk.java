package kelas.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import kelas.model.Produk;

public class DataProduk {

    private final ObservableList<Produk> daftar = FXCollections.observableArrayList();
    private int urutan = 1;

    public DataProduk() {
        tambah("Nasi Goreng Spesial", "Makanan", 25000);
        tambah("Es Teh Manis", "Minuman", 5000);
        tambah("Ayam Goreng Kremes", "Makanan", 20000);
    }

    public ObservableList<Produk> getDaftar() {
        return FXCollections.unmodifiableObservableList(daftar);
    }

    public Produk tambah(String nama, String kategori, long harga) {
        Produk p = new Produk(String.format("PR%03d", urutan), nama, kategori, harga);
        daftar.add(p);
        urutan++;
        return p;
    }
}
