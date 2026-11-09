package kelas.controller;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import kelas.Navigator;
import kelas.data.DataProduk;
import kelas.model.Produk;

public class FormController {

    @FXML
    private TextField namaField, hargaField;
    @FXML
    private ComboBox<String> kategoriBox;
    @FXML
    private Label pesanLabel;

    private Navigator navigator;
    private DataProduk data;

    @FXML
    private void initialize() {
        kategoriBox.getItems().setAll("Makanan", "Minuman");
        kategoriBox.setValue("Makanan");
    }

    public void setKonteks(Navigator navigator, DataProduk data) {
        this.navigator = navigator;
        this.data = data;
    }

    private void tampilkanError(String pesan) {
        pesanLabel.getStyleClass().setAll("label", "error");
        pesanLabel.setText(pesan);
    }

    private void tampilkanSukses(String pesan) {
        pesanLabel.getStyleClass().setAll("label", "success");
        pesanLabel.setText(pesan);
    }

    @FXML
    private void simpan() {
        try {
            String hargaText = hargaField.getText().trim();
            if (hargaText.isEmpty()) {
                tampilkanError("Harga tidak boleh kosong.");
                return;
            }
            long harga = Long.parseLong(hargaText);
            Produk p = data.tambah(namaField.getText(), kategoriBox.getValue(), harga);

            namaField.clear();
            hargaField.clear();
            kategoriBox.setValue("Makanan");
            tampilkanSukses("Produk " + p.getKode() + " (" + p.getNama() + ") berhasil disimpan.");
        } catch (NumberFormatException e) {
            tampilkanError("Harga harus berupa angka bulat positif.");
        } catch (IllegalArgumentException e) {
            tampilkanError(e.getMessage());
        }
    }

    @FXML
    private void bukaDaftar() {
        try {
            navigator.bukaDaftar();
        } catch (IOException e) {
            tampilkanError("Gagal membuka daftar produk.");
        }
    }
}
