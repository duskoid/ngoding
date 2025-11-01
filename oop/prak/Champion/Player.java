class Player implements Comparable<Player> {
    // TODO:
    // 1. Tambahkan atribut final untuk menyimpan nama dengan tipe String.
    // 2. Tambahkan atribut final untuk menyimpan skor dengan tipe int.
    private final String name;
    private final int score;

    Player(String name, int score) {
        // TODO:
        // 1. Lengkapi parameter konstruktor dengan tipe yang sesuai.
        // 2. Inisialisasikan atribut nama dan skor menggunakan parameter yang diterima.
        this.name = name;
        this.score = score;
    }

    Player boostScore(int bonus) {
        // TODO:
        // 1. Lengkapi parameter dengan tipe yang sesuai untuk bonus skor.
        // 2. Kembalikan objek Player baru dengan skor yang sudah ditambahkan bonus.
        Player p = new Player(this.name, this.score + bonus);
        return p;
    }

    Player faceOff(Player challenger) { // bener kah manggilnya gini //salah
        // TODO:
        // 1. Lengkapi parameter dengan tipe Player.
        // 2. Gunakan ChampionFinder.findChampion untuk menentukan pemenang antara this dan challenger.
        //ChampionFinder.findChampion(this, challenger) ini dipanggil ke return aja biar langsung ngereturn
        return ChampionFinder.findChampion(this, challenger);
    }

    @Override
    public String toString() {
        // TODO:
        // Kembalikan representasi string dalam format "<nama>(<skor>)" tanpa spasi tambahan.
        return String.format(name + "(" + score + ")");
    }

    @Override
    public int compareTo(Player other) {
        // TODO:
        // 1. Lengkapi parameter dengan tipe Player.
        // 2. Bandingkan skor terlebih dahulu menggunakan Integer.compare.
        // 3. Jika skor sama, bandingkan nama secara leksikografis.
        // 4. Kembalikan hasil perbandingan sesuai kontrak Comparable.
        int result = Integer.compare(this.score, other.score);
        if (result == 0){
            int hasil = this.name.compareTo(other.name);
            return hasil;
        }
        return result;
    }
}
