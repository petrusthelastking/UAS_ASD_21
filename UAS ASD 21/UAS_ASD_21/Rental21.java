package UAS_ASD_21;

public class Rental21 {
    private String noTNKB;
    private String namaKendaraan;
    private String jenisKendaraan;
    private int tahun;
    private int biayaSewa;

    public Rental21(String noTNKB, String namaKendaraan, String jenisKendaraan, int tahun) {
        this.noTNKB = noTNKB;
        this.namaKendaraan = namaKendaraan;
        this.jenisKendaraan = jenisKendaraan;
        this.tahun = tahun;
        this.biayaSewa = hitungBiayaSewa(jenisKendaraan);
    }

    public String getNoTNKB() {
        return noTNKB;
    }

    public String getNamaKendaraan() {
        return namaKendaraan;
    }

    public String getJenisKendaraan() {
        return jenisKendaraan;
    }

    public int getTahun() {
        return tahun;
    }

    public int getBiayaSewa() {
        return biayaSewa;
    }

    private int hitungBiayaSewa(String jenisKendaraan) {
        if (jenisKendaraan.equalsIgnoreCase("motor")) {
            return 25000;
        } else if (jenisKendaraan.equalsIgnoreCase("mobil")) {
            return 40000;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return String.format("| %-10s | %-15s | %-10s | %-6d | %-10d |",
                noTNKB, namaKendaraan, jenisKendaraan, tahun, biayaSewa);
    }
}



