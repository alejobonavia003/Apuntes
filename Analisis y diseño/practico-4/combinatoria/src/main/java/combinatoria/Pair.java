package combinatoria;

public class Pair<T1, T2> {
    double a;
    double b;
    public Pair(double a, double b){
        this.a = a;
        this.b = b;
    }

    public double getA (){
        return a;
    }
    public double getB () {
        return b;
    }

    @Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Pair)) return false;
    Pair p = (Pair) o;
    return this.a == p.a && this.b == p.b;
}


}
