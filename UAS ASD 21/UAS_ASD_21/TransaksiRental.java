package UAS_ASD_21;

public class TransaksiRental {
    private static int counter = 1;
    private int kodeTransaksi;
    private String namaPeminjam;
    private int lamaPinjam;
    private double totalBiaya;
    private Rental21 barangRental;

    public TransaksiRental(String namaPeminjam, int lamaPinjam, Rental21 barangRental) {
        this.kodeTransaksi = counter++;
        this.namaPeminjam = namaPeminjam;
        this.lamaPinjam = lamaPinjam;
        this.barangRental = barangRental;

        double hargaPerJam = barangRental.getBiayaSewa();
        this.totalBiaya = hitungBiayaTotal(hargaPerJam, lamaPinjam);
    }

    private double hitungBiayaTotal(double hargaPerJam, int lamaPinjam) {
        double biaya = hargaPerJam * lamaPinjam;
        double potongan = 0;

        // Potongan untuk member
        potongan += 25000;

        // Potongan berdasarkan lama peminjaman
        if (lamaPinjam >= 48 && lamaPinjam <= 78) {
            potongan += biaya * 0.1;
        } else if (lamaPinjam > 78) {
            potongan += biaya * 0.2;
        }

        return biaya - potongan;
    }

    public int getKodeTransaksi() {
        return kodeTransaksi;
    }

    public String getNamaPeminjam() {
        return namaPeminjam;
    }

    public int getLamaPinjam() {
        return lamaPinjam;
    }

    public double getTotalBiaya() {
        return totalBiaya;
    }

    public Rental21 getBarangRental() {
        return barangRental;
    }

    @Override
    public String toString() {
        return "TransaksiRental{" +
                "kodeTransaksi=" + kodeTransaksi +
                ", namaPeminjam='" + namaPeminjam + '\'' +
                ", lamaPinjam=" + lamaPinjam +
                ", totalBiaya=" + totalBiaya +
                ", barangRental=" + barangRental +
                '}';
    }
}


