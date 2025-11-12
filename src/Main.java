import java.io.IOException;
import java.util.List;

public class Main {
    public static List<Ad> ads;

    public static void debugger() {int i = 0;}

    public static void main(String[] args) throws IOException {
        System.out.println("RealEstate solution by Benjamin Ver");
        System.out.println();

        ads = Ad.LoadFromCsv("src/realestates.csv");
        debugger();
    }
}