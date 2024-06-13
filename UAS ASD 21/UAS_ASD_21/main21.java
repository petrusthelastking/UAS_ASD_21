package UAS_ASD_21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class main21 {
    private static ArrayList<Rental21> barangRentals = new ArrayList<>();
    private static ArrayList<TransaksiRental> transaksiRentals = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Data barang yang sudah diisi ketika program dijalankan
        barangRentals.add(new Rental21("5 4567 yv", "Honda Beat", "Motor", 2017));
        barangRentals.add(new Rental21("N 4511 Vs", "Honda Vario", "Motor", 2018));
        barangRentals.add(new Rental21("N 14553 AA", "Toyota Yaris", "Mobil", 2022));
        barangRentals.add(new Rental21("AB 4321 A", "Toyota Innova", "Mobil", 2019));
        barangRentals.add(new Rental21("B 1234 AG", "Toyota Avanza", "Mobil", 2021));

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Daftar Kendaraan");
            System.out.println("2. Pinjaman");
            System.out.println("3. Tampilkan seluruh transaksi");
            System.out.println("4. Urutkan Transaksi Urut no TNKB");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (pilihan) {
                case 1:
                    lihatBarangRental();
                    break;
                case 2:
                    buatTransaksiRental();
                    break;
                case 3:
                    lihatTransaksiRental();
                    break;
                case 4:
                    urutkanTransaksi();
                    break;
                case 5:
                    System.out.println("Keluar dari program.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }

    private static void lihatBarangRental() {
        System.out.println("+------------+-----------------+------------+--------+");
        System.out.println("| NoTNKB     | Nama Kendaraan  | Jenis      | Tahun  |");
        System.out.println("+------------+-----------------+------------+--------+");
        for (Rental21 br : barangRentals) {
            System.out.println(br);
        }
        System.out.println("+------------+-----------------+------------+--------+");
    }

    private static void buatTransaksiRental() {
        System.out.print("Nama Peminjam: ");
        String namaPeminjam = scanner.nextLine();
        System.out.print("Kode Barang: ");
        String kodeBarang = scanner.nextLine();
        System.out.print("Lama Pinjam (jam): ");
        int lamaPinjam = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Rental21 barangRental = cariBarangRental(kodeBarang);
        if (barangRental != null) {
            TransaksiRental transaksiRental = new TransaksiRental(namaPeminjam, lamaPinjam, barangRental);
            transaksiRentals.add(transaksiRental);
            System.out.println("Transaksi berhasil dibuat:");
            System.out.println(transaksiRental);
        } else {
            System.out.println("Kode barang tidak ditemukan.");
        }
    }

    private static Rental21 cariBarangRental(String kodeBarang) {
        for (Rental21 br : barangRentals) {
            if (br.getNoTNKB().equalsIgnoreCase(kodeBarang)) {
                return br;
            }
        }
        return null;
    }

    private static void lihatTransaksiRental() {
        System.out.println("Daftar Transaksi Rental:");
        for (TransaksiRental tr : transaksiRentals) {
            System.out.println(tr);
        }
    }

    private static void urutkanTransaksi() {
        Collections.sort(transaksiRentals, Comparator.comparing(tr -> tr.getBarangRental().getNoTNKB()));
        System.out.println("Transaksi diurutkan berdasarkan no TNKB:");
        lihatTransaksiRental();
    }
}