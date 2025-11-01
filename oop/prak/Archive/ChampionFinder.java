public final class ChampionFinder {
    // TODO:
    // Tambahkan konstruktor private tanpa parameter di sini agar kelas
    // tidak dapat diinstansiasi.
    private ChampionFinder() {}

    public static <T extends Comparable<T>> T findChampion(T a, T b) {
        // TODO:
        // 1. Lengkapi parameter generik yang menerapkan interface Comparable.
        // 2. Bandingkan kedua kandidat dan kembalikan kandidat dengan nilai terbesar.
        return a.compareTo(b) > 0 ? a : b;
        // HINT: gunakan fungsi compareTo
    }

    public static <T extends Comparable<T>> T findChampion(T a, T b, T c) {
        // TODO:
        // 1. Gunakan parameter generik yang sama seperti versi dua kandidat.
        // 2. Manfaatkan findChampion(a, b) untuk mendapatkan juara sementara.
        // 3. Bandingkan juara sementara dengan kandidat ketiga dan kembalikan hasil akhirnya.
        T tempChampion = findChampion(a, b);
        return findChampion(tempChampion, c);
    }
}
