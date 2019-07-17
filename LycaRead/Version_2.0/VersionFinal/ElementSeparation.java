import java.io.*;
import java.util.*;

public class ElementSeparation {

    public ArrayList<String> lines1 = new ArrayList();
    public ArrayList<String> lines2 = new ArrayList();

    public DefaultParticleList iteration1 = new DefaultParticleList();
    public DefaultParticleList iteration2 = new DefaultParticleList();

    public ElementSeparation() {
        lines1 = new ArrayList<>();
    }

    public void readFileByLine(String filename1, String filename2) throws FileNotFoundException {

        Scanner reader1 = new Scanner(new File(filename1));
        Scanner reader2 = new Scanner(new File(filename2));

        while (reader1.hasNextLine() && reader2.hasNextLine()) {

            lines1.add(reader1.nextLine());
            lines2.add(reader2.nextLine());
        }

        reader1.close();
        reader2.close();

    }

    public void separateLineByParam() {

        for (int iter1count = 0; iter1count < lines1.size(); iter1count++) {
            String[] iter1split = lines1.get(iter1count).split(",    ");

            while (iter1split.length < 2) {
                iter1count++;
                iter1split = lines1.get(iter1count).split(",    ");
            }

            iteration1.particleGen(lines1.get(iter1count));

        }

        for (int iter2count = 0; iter2count < lines2.size(); iter2count++) {

            String[] iter2split = lines2.get(iter2count).split(",    ");

            while (iter2split.length < 2) {
                iter2count++;
                iter2split = lines2.get(iter2count).split(",    ");
            }

            iteration2.particleGen(lines2.get(iter2count));
        }

    }
}