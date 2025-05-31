import java.util.Random;

public class Minge {
    private int x, y;
    private static Random rand = new Random();

    public Minge(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void suteaza() throws Gol, Out, Corner {
        
        x += rand.nextInt(21) - 10; 
        y += rand.nextInt(11) - 5; 

        if (y <= 0 || y >= 50) {
            throw new Out("Mingea este in out");
        }
        if ((x == 0 || x == 100)) {
            if (y >= 20 && y <= 30) {
                throw new Gol("Gol!!!");
            } else if (y > 0 && y < 20 || y > 30 && y < 50) {
                throw new Corner("Corner");
            }
        }
    }
}
