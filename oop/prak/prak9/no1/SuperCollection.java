import java.util.*;

public class SuperCollection {
    private List<Integer> collection;

    // TODO: Buat constructor yang menerima List<Integer> sebagai parameter
    // Inisialisasi atribut collection dengan parameter yang diterima
    public SuperCollection(List<Integer> col){
        collection = new ArrayList<>(col);
    }
    // TODO: Buat method partitionByCondition(int threshold)
    // Pisahkan collection menjadi dua grup: element <= threshold dan element > threshold
    // Return List<List<Integer>> dimana:
    // - Index 0 berisi element <= threshold
    // - Index 1 berisi element > threshold
    //
    // HINT:
    // - Perlu membuat struktur data untuk menampung dua kelompok element
    // - Gunakan loop untuk mengiterasi collection dan kondisi untuk memisahkan
    public List<List<Integer>> partitionByCondition(int threshold){
        List<Integer> under = new ArrayList<>();
        List<Integer> above = new ArrayList<>();
        for (Integer i : collection){
            if (i <= threshold){
                under.add(i);
            } else {
                above.add(i);
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(under);
        res.add(above);
        return res;
    }

    // TODO: Buat method findTopN(int n)
    // Return List<Integer> berisi n element terbesar dalam urutan descending
    // Jika n lebih besar dari ukuran collection, return semua element yang ada
    // Pastikan hasilnya terurut dari terbesar ke terkecil
    //
    // HINT:
    // - Collection asli tidak boleh dimodifikasi
    // - Pertimbangkan cara mengurutkan List dalam urutan terbalik
    // - Collections class memiliki method utility yang berguna
    public List<Integer> findTopN(int n){
        List<Integer> temp = new ArrayList<>(collection);
        Collections.sort(temp, (p1, p2) -> p2 - p1);
        return temp.subList(0, n);
    }

    // TODO: Buat method runningSum()
    // Return List<Integer> berisi cumulative sum
    // Element ke-i berisi jumlah dari element index 0 sampai i
    // Contoh: [1, 2, 3, 4] -> [1, 3, 6, 10]
    //
    // HINT:
    // - Perlu menyimpan state (akumulasi) saat iterasi
    // - Setiap element dalam result adalah hasil penjumlahan sampai index tersebut
    public List<Integer> runningSum(){
        List<Integer> cumSum = new ArrayList<>();
        Integer sum = 0;
        for (int i = 0; i < collection.size(); i++){
            cumSum.add(sum + collection.get(i));
        }
        return cumSum;
    }

    // TODO: Buat method findPairsWithSum(int targetSum)
    // Cari semua pasangan element yang jika dijumlahkan = targetSum
    // Return List<String> dengan format "a+b=sum"
    // Hindari duplikat pasangan (a,b) dan (b,a) dianggap sama
    // Urutkan hasil berdasarkan nilai a
    //
    // HINT:
    // - Perlu mengecek setiap kemungkinan pasangan element
    // - Bagaimana cara menghindari duplikat seperti "3+5" dan "5+3"?
    // - Pertimbangkan struktur data yang otomatis mengurutkan dan menghindari duplikat
    // - TreeSet adalah Set yang sorted
    // - Gunakan .addAll untuk menambahkan seluruh elemen dari set ke List hasil kalian
    public List<String> findPairsWithSum(int targetSum){
        List<String> res = new ArrayList<>();
        TreeSet<String> pair = new TreeSet<>();

        for (Integer i : collection){
            for (Integer j : collection){
                if (i + j == targetSum){
                    String pairs = String.format("%d+%d=%d", i, j, targetSum);
                    if (!pair.contains(String.format("%d+%d", j, i))){
                        pair.add(pairs);
                    }
                }
            }
        }
        
        res.addAll(pair);
        return res;
    }

    // TODO: Buat method getMostFrequentElements(int n)
    // Return List<Integer> berisi n element yang paling sering muncul
    // Jika ada element dengan frekuensi sama, pilih yang nilainya lebih besar
    //
    // HINT:
    // - Langkah 1: Identifikasi semua element unik
    // - Langkah 2: Hitung berapa kali setiap element muncul
    // - Langkah 3: Urutkan berdasarkan frekuensi (tinggi ke rendah), lalu nilai (tinggi ke rendah)
    // - Pertimbangkan membuat helper class untuk menyimpan pasangan (value, frequency)
    // - Untuk sorting custom, gunakan Comparator
    public List<Integer> getMostFrequentElements(int n){
        Map<Integer, Integer> pair = new HashMap<>();
        List<Integer> sorted = new ArrayList<>();

        for (Integer i : collection){
            if (!pair.containsKey(i)){
                pair.put(i, 1);
            } else {
                pair.put(i, pair.get(i) + 1);
            }
        }
        Integer minFreq = Integer.MAX_VALUE;
        Integer minKey = 0;
        while (!pair.isEmpty()){
            for (Map.Entry<Integer, Integer> i : pair.entrySet()){
                if (i.getValue() < minFreq){
                    minFreq = i.getValue();
                    minKey = i.getKey();
                }
            }
            sorted.add(minKey);
            pair.remove(minKey, minFreq);
        }

        List<Integer> anu = sorted.subList(0, n-1);
        return anu;
        
    }

    // TODO: Buat method getCollection()
    // Return collection yang sedang digunakan (type: List<Integer>)
    public List<Integer> getCollection(){
        return collection;
    }

    // TODO: Buat method setCollection(List<Integer> newCollection)
    // Set atribut collection dengan newCollection
    public void setCollection(List<Integer> newCollection){
        collection = newCollection;
    }

}
