import java.util.List;

// TODO: Buat generic class DataProcessor<T extends Comparable<T>>
// Pertanyaan: Mengapa kita menggunakan bounded type parameter "T extends Comparable<T>"?
// Hint: Method apa yang diperlukan untuk melakukan sorting atau mencari min/max?
//       Apakah semua tipe data memiliki method tersebut secara default?
//
// Atribut yang diperlukan:
// - String processorName
//
// Method yang diperlukan:
// - Constructor(String processorName): inisialisasi processor
// - findMin(Container<T> container): mencari nilai minimum
//   * Tampilkan: "Mencari nilai minimum di [container.getName()]..."
//   * Return nilai minimum, atau null jika container kosong
//   * Hint: Bagaimana cara membandingkan dua objek untuk menentukan mana yang lebih kecil?
// - findMax(Container<T> container): mencari nilai maximum
//   * Tampilkan: "Mencari nilai maksimum di [container.getName()]..."
//   * Return nilai maximum, atau null jika container kosong
// - sort(Container<T> container): mengurutkan item dalam container (ascending)
//   * Tampilkan: "Mengurutkan data di [container.getName()]..."
//   * Hint: Pikirkan algoritma sorting sederhana yang pernah Anda pelajari.
//   * Method ini memodifikasi container secara langsung
// - getProcessorName(): return nama processor

public class DataProcessor<T extends Comparable<T>> {
    // TODO: Implementasikan class ini
    private String processorName;

    public DataProcessor(String processorName){
        this.processorName = processorName;
    }

    public T findMin(Container<T> container){
        System.out.println("Mencari nilai minimum di " + container.getName() + "...");
        if (container.getItems().isEmpty()){
            return null;
        }

        T min = container.get(0);
        for (int i = 1; i < container.size(); i++){
            if (container.get(i).compareTo(min) < 0){
                min = container.get(i);
            }
        }
        return min;
    }

    public T findMax(Container<T> container){
        System.out.println("Mencari nilai maximum di " + container.getName() + "...");
        if (container.getItems().isEmpty()){
            return null;
        }

        T max = container.get(0);
        for (int i = 1; i < container.size(); i++){
            if (container.get(i).compareTo(max) > 0){
                max= container.get(i);
            }
        }
        return max;
    }

    public void sort(Container<T> container) {
    System.out.println("Mengurutkan data di " + container.getName() + "...");
    
    List<T> items = container.getItems();
    int n = items.size();
    
    // For each position from start to end
    for (int i = 0; i < n - 1; i++) {
        // Assume current position has the minimum
        int minIndex = i;
        
        // Find the actual minimum in the remaining unsorted part
        for (int j = i + 1; j < n; j++) {
            if (items.get(j).compareTo(items.get(minIndex)) < 0) {
                minIndex = j;  // Found a smaller one!
            }
        }
        
        // Swap the minimum with current position
        T temp = items.get(i);
        items.set(i, items.get(minIndex));
        items.set(minIndex, temp);
        }
    }

    public String getProcessorName(){
        return processorName;
    }
}