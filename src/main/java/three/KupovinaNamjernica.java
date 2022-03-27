package three;

import java.util.Scanner;

public class KupovinaNamjernica {
    public static void main(String[] args) {
        String proizvod = null;
        int stanjeRacuna = 50;
        int cijena = 0;
        System.out.println("Stanje vaseg računa je: "+stanjeRacuna);
        System.out.println("Unesi zeljeni proizvod");
        Scanner scanner = new Scanner(System.in);
        proizvod = scanner.next();
        System.out.println("Unesi cijenu proizvoda");
        cijena = scanner.nextInt();

        if (cijena<stanjeRacuna){
            stanjeRacuna=stanjeRacuna-cijena;
            System.out.println("Kupili ste: " +proizvod+ ". Raspolozivo na vasem računu je: "+stanjeRacuna);
        }else {
            System.out.println("Nemate dovoljno sredstava na računu.");
        }

    }
}
