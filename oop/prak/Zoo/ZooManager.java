import java.util.List;

// Hint: Pelajari PECS Rule
public class ZooManager {
    
    
    // TODO: Lengkapi tipe wildcard pada parameter
    public static void printAllAnimals(List<? extends Animal> animals) {
        // TODO: Loop semua animal dalam list dan tampilkan:
        for (Animal a : animals){
            System.out.println("- " + a.getInfo() + " says: " + a.makeSound());
        }
        // "- <animal.getInfo()> says: <animal.makeSound()>"
    }
    
    // TODO: Lengkapi tipe wildcard pada parameter
    public static void addMammals(List<? super Mammal> list, Mammal mammal) {

        list.add(mammal);
        System.out.println(mammal.getName() + " ditambahkan ke daftar mamalia");
    }
    
    // TODO: Lengkapi tipe wildcard pada parameter
    public static int countAnimals(List<? extends Animal> list) {
        // TODO: Return jumlah elemen dalam list (gunakan list.size())
        return list.size();
    }
    
    // TODO: Lengkapi tipe wildcard pada kedua parameter Enclosure
    public static void transferAnimal(Enclosure<? extends Animal> source, Enclosure<? super Animal> destination) {
        Animal temp = source.getAnimal();
        destination.setAnimal(temp);
        System.out.println(temp.getName() + " dipindahkan dari kandang " + source.getEnclosureId() + " ke " + destination.getEnclosureId());
    }
    
    // TODO: Lengkapi tipe wildcard pada parameter
    public static void showGenericInfo(Enclosure<? extends Animal> enclosure) {
        // TODO: Panggil enclosure.showEnclosureInfo()
        enclosure.showEnclosureInfo();
    }
}