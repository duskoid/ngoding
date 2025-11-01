public class Warrior implements PhysicalAttack, StrengthComparable {
    // TODO: Buat atribut private String name, int physicalPower
    private String name;
    private int physicalPower;
    
    // TODO: Buat constructor yang menerima name dan physicalPower
    // Set kedua atribut dengan parameter yang diterima
    public Warrior(String name, int physicalPower){
        this.name = name;
        this.physicalPower = physicalPower;
    }
    
    // TODO: Override method performAttack()
    // Tampilkan: "<name> mengayunkan pedang dengan kuat! memberikan <physicalPower> damage fisik!"
    public void performAttack(){
        System.out.println(name + " mengayunkan pedang dengan kuat! memberikan " + getPhysicalPower() + " damage fisik!");
    }
    
    // TODO: Override method getPhysicalPower()
    // Buat getter untuk physicalPower
    public int getPhysicalPower(){
        return physicalPower;
    }
    
    // TODO: Override method setPhysicalPower(int power)
    // Buat setter untuk physicalPower
    public void setPhysicalPower(int power){
        physicalPower = power;
    }

    // TODO: Override method compareStrength(StrengthComparable other)
    // Jika other adalah instance dari Warrior:
    //   - Bandingkan physicalPower:
    //     - Jika this.physicalPower < other.physicalPower, return -1
    //     - Jika this.physicalPower == other.physicalPower, return 0
    //     - Jika this.physicalPower > other.physicalPower, return 1
    // Jika other bukan instance dari Warrior, return -2
    public int compareStrength(StrengthComparable other){
        Warrior othr = (Warrior) other;
        if (othr.getPhysicalPower() == 0){
            return -2;
        } else {
            if (this.getPhysicalPower() < othr.getPhysicalPower()){
                return -1;
            } else if (this.getPhysicalPower() == othr.getPhysicalPower()){
                return 0;
            } else {
                return 1;
            }
        }
    }
}