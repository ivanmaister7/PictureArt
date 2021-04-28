import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class PictureData {

    Picture pict;
    int[] rgb;
    int size;

    public PictureData(Picture p){
        pict = p;
        size = pict.height()*pict.width();
        rgb = new int[size];

        for (int i = 0; i < pict.height(); i++) {
            for (int j = 0; j < pict.width(); j++) {
                rgb[i*pict.width()+j] = pict.getRGB(j, i);
            }
        }

    }
    public static char getChar(int num){
        if(num < 4){
            return 32;
        } else if(num < 10){
            return 46;
        } else if(num < 20){
            return 42;
        }
        else if(num < 30){
            return 35;
        }
        else if(num < 40){
            return 56;
        }
        return 64;
    }

    public static void main(String[] args) throws IOException {
        Picture p = new Picture("black11.jpg");
        PictureData data = new PictureData(p);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < p.height(); i++) {
            for (int j = 0; j < p.width(); j++) {
                p.setRGB(j, i, data.rgb[(i)*p.width()+(j)]);
               sb.append(getChar(p.getRGB(j,i)/-328966) + "  ");
            }
            sb.append("\n");
        }
        FileWriter fw = new FileWriter(new File("pictRes.txt"));
        fw.write(sb.toString());
        fw.close();
        p.show();
    }
}
