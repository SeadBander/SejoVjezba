package one;

public class TablicaMnozenja {
    public static void main(String[] args) {
        System.out.println("*********");
        System.out.println("1   2   3");
        System.out.println("*********");
        int[][] tablicaMnozenja = new int[10][3];
        int red = 1;
        int kolona = 1;
        for (int a = 0; a< tablicaMnozenja.length; a++){
            for (int b = 0; b< tablicaMnozenja [a].length; b++){
                tablicaMnozenja[a][b]= red*kolona;
                kolona=kolona+1;
                System.out.print(""+tablicaMnozenja[a][b]+ "\t");
            }
            System.out.print("\n");
            red = red+1;
            kolona=1;
        }
    }
}
