import java.util.ArrayList;
import java.util.List;

// TODO: Buat class StatisticalAnalyzer (standalone class)
//
// Atribut yang diperlukan:
// - String analyzerName
//
// Method yang diperlukan:
// - Constructor(String name): inisialisasi analyzer
// - getAnalyzerName(): return nama analyzer
// - calculateAverage(Container<? extends Number> container): hitung rata-rata
//   * Pertanyaan: Mengapa kita menggunakan wildcard "? extends Number"?
//   * Hint: Apa hubungan antara Integer, Double, Float dengan Number?
//         Jika method menerima Container<Number>, bisakah kita pass Container<Integer>?
//   * Tampilkan: "Menghitung rata-rata dari [container.getName()]..."
//   * Return rata-rata sebagai double, atau 0.0 jika kosong
//   * Hint: Bagaimana cara mengkonversi berbagai tipe Number menjadi double?
// - calculateSum(Container<? extends Number> container): hitung total
//   * Tampilkan: "Menghitung total dari [container.getName()]... (tanpa [])"
//   * Return sum sebagai double
// - findAboveThreshold(Container<? extends Number> container, double threshold)
//   * Tampilkan: "Mencari nilai di atas threshold [threshold] di [container.getName()]..."
//   * Return List<Number> berisi semua nilai yang lebih besar dari threshold
//   * Hint: Pikirkan cara membandingkan Number dengan double.

public class StatisticalAnalyzer {
    // TODO: Implementasikan class ini
    private String analyzerName;

    public StatisticalAnalyzer(String name){
        analyzerName = name;
    }

    public double calculateAverage(Container<? extends Number> container){
        System.out.println("Menghitung rata-rata dari " + container.getName() + "...");
        if (container.getItems().isEmpty()){
            return 0.0;
        }
        double total = 0.0;
        for (int i = 0; i < container.size();i++){
            total += (double)container.get(i);
        }
        return total/container.size();
    }

    public double calculateSum(Container<? extends Number> container){
        
    }
}
