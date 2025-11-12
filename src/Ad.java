import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ad {
    public int area;
    public Category category;
    public LocalDate createAt;
    public String description;
    public int floors;
    public boolean freeOfCharge;
    public int id;
    public String imageUrl;
    public String latLong;
    public int rooms;
    public Seller seller;

    public static List<Ad> LoadFromCsv(String filename) throws IOException {
        List<Ad> ads = new ArrayList<>();
        StringBuilder csvText = new StringBuilder();
        FileReader f = new FileReader(filename);
        int c;
        while ((c=f.read()) > -1) csvText.append((char)c);
        f.close();

        String[] lines = csvText.toString().split("\n");
        for (String line: lines){
            ads.add(new Ad());
        }

        return ads;
    }
}
