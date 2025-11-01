public class Delta extends Beta implements Gamma{
    private float d1;

    public Delta(float d1, Alpha b1) {
        set_b1(b1);
        this.d1 = d1;
    }

    public void setD1 (float d1) {
        this.d1 = d1;
    }
    public float getD1 () {
        return d1;
    }
}