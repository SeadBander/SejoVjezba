package two;

public class Krug {
    public double poluprecnik;
    public static double pi=3.14;
    public double povrsina;


    public Krug() {
        this.poluprecnik = poluprecnik;
        this.povrsina = povrsina;
    }

    public void povrsina(double poluprecnik) {
        povrsina = poluprecnik*2*pi;
        System.out.println("Površina kruga je: "+povrsina);
    }
}
