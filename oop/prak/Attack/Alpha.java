public class Alpha {
    private float a1, a2;

    public Alpha(float a1, float a2){
        this.a1 = a1;
        this.a2 = a2;
    }

    public void f1(float aa1, float aa2){
        a1 += aa1;
        a2 += aa2;
    }

    public void set_a1(float a1){
        this.a1 = a1;
    }

    public float get_a1(){
        return a1;
    }

    public void set_a2(float a2){
        this.a2 = a2;
    }

    public float get_a2(){
        return a2;
    }
}
