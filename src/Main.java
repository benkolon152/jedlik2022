import java.io.IOException;
import java.util.List;

public class Main {
    public static List<Ad> ads;

    public static void debugger() {int i = 0;}

    public static void main(String[] args) throws IOException {
        //System.out.println("RealEstate solution by Benjamin Ver");
        //System.out.println();

        ads = Ad.LoadFromCsv("src/realestates.csv");

        //6.feladat:
        int sumOfFloor0Areas = 0;
        int countOfFloor0 = 0;
        for (Ad ad: ads){
            if (ad.floors == 0){
                sumOfFloor0Areas += ad.area;
                countOfFloor0++;
            }
        }
        double avgOfFloor0Areas = 1.0 * sumOfFloor0Areas / countOfFloor0;
        System.out.print("1. Földszinti ingatlanok átlagos alapterülete: ");
        System.out.print(Math.round(100.00 * avgOfFloor0Areas) / 100.00);
        System.out.println(" m2");

        debugger();
    }
}