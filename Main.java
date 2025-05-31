public class Main {
    public static void main(String[] args) {
        Joc joc1 = new Joc("Echipa 1", "Echipa 2");
        joc1.simuleaza();
        System.out.println(joc1);

        System.out.println();

        Joc joc2 = new Joc("Echipa 3", "Echipa 4");
        joc2.simuleaza();
        System.out.println(joc2);
    }
}
