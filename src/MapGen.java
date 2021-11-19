import static java.lang.Math.*;
public class MapGen {
    //Color
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    //Random
    public static int Random(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    //Start
    public static void main (String[] avr) {
        int [][] map;
        int x, y, a, b, u=0;
        int size =50*2;//Map Size
        map = new int[size][size];
        for (int l = 0; l < size; l++) {
            u = u + Random(10, 25);//Add low spawn percent
            for (int w = 0; w < size; w++) {
                int wi = Random(0, size - 30);//island place
                int li = Random(0, size - 30);
                int k = Random(0, u);//spawn percent
                if (k == 0 || k == 500) {
                    for (double i = -3.14; i <= 3.14; i = i + 0.01) {//Island(Ellipse shape)
                        a = Random(5, 15);
                        b = Random(5, 15);
                        x = (int) ( a * cos(i));
                        y = (int) ( b * sin(i));
                        map[wi + x + a][li + y + b] = 2;
                    }
                }
            }
        }
        for (int l = 0; l < size; l++) {
            u = u + Random(5, 15);
            for (int w = 0; w < size; w++) {
                //Sand
                if (map[l][w] == 2 && map[l][w - 1] == 0 || map[l][w] == 2 && map[l][w + 1] == 0 || map[l][w] == 2 && map[l - 1][w] == 0 || map[l][w] == 2 && map[l + 1][w] == 0) {
                    map[l][w] = 1;
                }
                //AntiWaterSand
                if (map[l][w] == 1 && map[l][w - 1] == 0 && map[l][w + 1] == 0 || map[l][w] == 1 && map[l - 1][w] == 0 && map[l + 1][w] == 0 || map[l][w] == 1 && map[l+1][w+1]==0 && map[l-1][w+1]==0 || map[l][w] == 1 && map[l+1][w-1]==0 && map[l-1][w+1]==0) {
                    map[l][w] = 0;
                }
                //Color print
                if (map[l][w] == 0) {
                    System.out.print(BLUE + "█");//Вода
                }
                if (map[l][w] == 1) {
                    System.out.print(YELLOW + "█");//Песок
                }
                if (map[l][w] == 2) {
                    System.out.print(GREEN + "█");//Трава
                }
            }
            System.out.println();
        }
    }
}
