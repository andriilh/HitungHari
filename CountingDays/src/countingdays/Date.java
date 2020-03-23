/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package countingdays;

/**
 *
 * @author root
 */
public class Date {

    int hari, bulan, tahun;
//    constructor function

    public Date(int hari, int bulan, int tahun) {
        this.hari = hari;
        this.bulan = bulan;
        this.tahun = tahun;
    }

//    array jumlah hari setiap bulan dalam satu tahun. berurutan dari januari hingga desember
    static int jlhHari[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

//   menghitung hari dari tahun kabisat
    static int thnKabisat(Date d) {
        int tahun = d.tahun;

//        cek apakah tahun inputan merupakan tahun kabisat atau tidak
        if (d.bulan <= 2) {
            tahun--;
        }

//        sesuai ketentuan bahwa tahun kabisat adalah tahun yang merupakan kelipatan 4 dan 400 
//        dan bukan kelipatan 100
        return tahun / 4 - tahun / 100 + tahun / 400;
    }
    
    public static int selisihHari(Date dt1, Date dt2) {
//        hitung total hari sebelum tanggal 'tg1'
        
//        inisialisasi penghitungan menggunakan  tahun dan hari
        int tg1 = dt1.tahun * 365 + dt1.hari;

//        tambahkan perhitungan bulan dengan tanggal yang diberikan
        for (int i = 0; i < dt1.bulan - 1; i++) {
            tg1 += jlhHari[i];
        }
        
        tg1 += thnKabisat(dt1);
        
//        menghitung untuk 'tg2'
        int tg2 = dt2.tahun * 365 + dt2.hari;
        for (int i = 0; i < dt2.bulan - 1; i++) {
            tg2 += jlhHari[i];
        }
        tg2 += thnKabisat(dt2);
        
//        mengembalikan nilai selisih antara dua tanggal yang diberikan
        return (tg2 - tg1);
    }
}
