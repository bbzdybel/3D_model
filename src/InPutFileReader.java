import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class InPutFileReader {
    private ArrayList<Line> lines;

    public InPutFileReader(String path){
        lines = new ArrayList<>();
        readeFromFile(path);
    }

    public void readeFromFile(String path){
        File file = new File(path);
        try (Scanner scanner = new Scanner(file)) {
            while(scanner.hasNextLine()){
                String [] points = scanner.nextLine().split(" ");
                for (int i = 0; i < points.length; i++) {
                    System.out.println(points[i]);
                }
                MyPoint a = new MyPoint(Double.parseDouble(points[0]),Double.parseDouble(points[1]),Double.parseDouble(points[2]));
                MyPoint b = new MyPoint(Double.parseDouble(points[3]),Double.parseDouble(points[4]),Double.parseDouble(points[5]));
                lines.add(new Line(a,b));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } ;
    }

    public ArrayList<Line> getLines(){
        return lines;
    }
}
