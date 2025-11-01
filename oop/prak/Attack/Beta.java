public abstract class Beta {
    private Alpha b1;
    private static int countBeta;

    public abstract float g1();

    public void set_b1(Alpha bb1){
        b1 = bb1;
    }
    
    public Alpha get_b1(){
        return b1;
    }

    public int getCountBeta(){
        return countBeta;
    }
}
