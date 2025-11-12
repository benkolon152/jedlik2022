package com.example.realestategui;
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
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            ads.add(new Ad(line));
        }

        return ads;
    }

    public Ad(String fileline){
        String[] fieldValues = fileline.split(";");

        id = Integer.parseInt(fieldValues[0]);
        rooms = Integer.parseInt(fieldValues[1]);
        latLong = fieldValues[2];
        floors = Integer.parseInt(fieldValues[3]);
        area = Integer.parseInt(fieldValues[4]);
        description = fieldValues[5];
        freeOfCharge = fieldValues[6].contains("1");
        imageUrl = fieldValues[7];
        createAt = LocalDate.parse(fieldValues[8]);

        seller = new Seller(
                Integer.parseInt(fieldValues[9]),
                fieldValues[10],
                fieldValues[11]
        );

        category = new Category(
                Integer.parseInt(fieldValues[12]),
                fieldValues[13]
        );

    }

    public double DistanceTo(String otherLatLong){
        String[] split1 = this.latLong.split(",");
        String[] split2 = otherLatLong.split(",");
        double x1 = Double.parseDouble(split1[0]);
        double y1 = Double.parseDouble(split1[1]);
        double x2 = Double.parseDouble(split2[0]);
        double y2 = Double.parseDouble(split2[1]);

        return Math.sqrt(
                (x2-x1)*(x2-x1) + (y2-y1)*(y2-y1)
        );
    }
}
