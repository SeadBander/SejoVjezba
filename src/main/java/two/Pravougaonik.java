package two;

public class Pravougaonik {
    public int stranaA;
    public int stranaB;
    public int povrsina;

    public Pravougaonik() {
        this.stranaA = stranaA;
        this.stranaB = stranaB;
        this.povrsina = povrsina;
    }

    public void povrsina(int stranaA, int stranaB) {
        povrsina = stranaA*stranaB;
        System.out.println("Površina kvadrata je: "+povrsina);
    }
}
