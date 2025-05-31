public class Joc {
    private String echipa1, echipa2;
    private int goluri1 = 0, goluri2 = 0;
    private int totalOut = 0, totalCorner = 0;

    public Joc(String echipa1, String echipa2) {
        this.echipa1 = echipa1;
        this.echipa2 = echipa2;
    }

    public void simuleaza() {
        Minge minge = new Minge(50, 25);
        for (int i = 0; i < 1000; i++) {
            System.out.println(echipa1 + " - " + echipa2 + 
                " : Mingea se afla la  (" + minge.getX() + "," + minge.getY() + ")");
            try {
                minge.suteaza();
            } catch (Gol g) {
                System.out.println(" " + g.getMessage());
                if (minge.getX() == 0)
                    goluri2++; 
                else
                    goluri1++; 
                minge = new Minge(50, 25); 
            } catch (Out o) {
                System.out.println(" " + o.getMessage());
                totalOut++;
                minge = new Minge(minge.getX(), minge.getY()); 
            } catch (Corner c) {
                System.out.println(" " + c.getMessage());
                totalCorner++;
                if (minge.getX() == 0) {
                    minge = new Minge(0, minge.getY() <= 25 ? 0 : 50); 
                } else {
                    minge = new Minge(100, minge.getY() <= 25 ? 0 : 50); 
                }
            }
        }
    }

    public String toString() {
        return echipa1 + " - " + echipa2 + " | Scor: " + goluri1 + " - " + goluri2 +
               " | Out-uri: " + totalOut + " | Cornere: " + totalCorner;
    }
}
