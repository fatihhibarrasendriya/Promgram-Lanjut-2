package kelas.controller;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import kelas.Navigator;
import kelas.model.Produk;

public class DetailController {

    @FXML
    private Label kodeLabel, namaLabel, kategoriLabel, hargaLabel, pesanLabel;
    private Navigator navigator;

    public void setData(Navigator navigator, Produk p) {
        this.navigator = navigator;
        NumberFormat rupiah = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("id-ID"));
        rupiah.setMaximumFractionDigits(0);

        kodeLabel.setText(p.getKode());
        namaLabel.setText(p.getNama());
        kategoriLabel.setText(p.getKategori());
        hargaLabel.setText(rupiah.format(p.getHarga()));
    }

    @FXML
    private void tambah() {
        try {
            navigator.bukaForm();
        } catch (IOException e) {
            pesanLabel.setText("Gagal membuka form.");
        }
    }

    @FXML
    private void bukaDaftar() {
        try {
            navigator.bukaDaftar();
        } catch (IOException e) {
            pesanLabel.setText("Gagal membuka daftar.");
        }
    }
}
