import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class ParticleList {
    /**
     * A list of Particle objects
     */
    public ArrayList<Particle> micrographs = new ArrayList<Particle>();

    public ParticleList() {
        micrographs = new ArrayList<Particle>();
    }

    public void particleGen(String partToSplit) {

        String[] superSplit1 = partToSplit.split(",");

        int tempParticleNumber;
        double tempEulerTheta, tempEulerPhi, tempEulerOmega, tempCentreX, tempCentreY, tempScalingFactor;
        tempParticleNumber = Integer.parseInt(superSplit1[0].trim());

        tempEulerTheta = Double.parseDouble(superSplit1[1].trim());
        tempEulerPhi = Double.parseDouble(superSplit1[2].trim());
        tempEulerOmega = Double.parseDouble(superSplit1[3].trim());

        tempCentreX = Double.parseDouble(superSplit1[4].trim());
        tempCentreY = Double.parseDouble(superSplit1[5].trim());

        tempScalingFactor = Double.parseDouble(superSplit1[6].trim());

        Particle singlePoint = new Particle(tempParticleNumber, tempEulerTheta, tempEulerPhi, tempEulerOmega,
                tempCentreX, tempCentreY, tempScalingFactor);

        micrographs.add(singlePoint);
    }

}

public class TwoFileRead {

    public static void main(String[] args) throws IOException {
        BufferedReader reader1 = new BufferedReader(new FileReader("/Users/shrikantghoshal/Desktop/UCD_work/P22demo/dat/P22demo_stack.date_020"));

        BufferedReader reader2 = new BufferedReader(new FileReader("/Users/shrikantghoshal/Desktop/UCD_work/P22demo/dat/P22demo_stack.date_019"));

        String line1 = reader1.readLine();

        String line2 = reader2.readLine();

        ParticleList iteration1 = new ParticleList();
        ParticleList iteration2 = new ParticleList();

        ParticleList goodImages = new ParticleList();
        ParticleList badImages = new ParticleList();

        while (line1 != null || line2 != null) {

            String[] part1 = line1.split(",    ");
            String[] part2 = line2.split(",    ");

            // Skips image file headers within the data files
            while (part1.length != part2.length || part1.length < 2) {

                line1 = reader1.readLine();
                line2 = reader2.readLine();
                line1 = reader1.readLine();
                line2 = reader2.readLine();

                part1 = line1.split(",    ");
                part2 = line2.split(",    ");

            }

            iteration1.particleGen(part1[0]);
            iteration2.particleGen(part2[0]);

            Iterator<Particle> firstIterator = iteration1.micrographs.iterator();
            Iterator<Particle> secondIterator = iteration2.micrographs.iterator();

            int compareCount = 0;

            while (firstIterator.hasNext() && secondIterator.hasNext()) {

                firstIterator.next();
                secondIterator.next();

                double Xcompare, Ycompare;
                double xComparatorIter1 = iteration2.micrographs.get(compareCount).getCentreX();
                double yComparatorIter1 = iteration2.micrographs.get(compareCount).getCentreY();
                double xComparatorIter2 = iteration2.micrographs.get(compareCount).getCentreX();
                double yComparatorIter2 = iteration2.micrographs.get(compareCount).getCentreY();

                if (xComparatorIter1 >= xComparatorIter2) {
                    Xcompare = xComparatorIter1 / xComparatorIter2;
                } else {
                    Xcompare = xComparatorIter2 / xComparatorIter1;
                }

                if (yComparatorIter1 >= yComparatorIter2) {
                    Ycompare = yComparatorIter1 / yComparatorIter2;
                } else {
                    Ycompare = yComparatorIter2 / yComparatorIter1;
                }

                if (Xcompare > 0.2 || Ycompare > 0.2) {
                    firstIterator.remove();
                    secondIterator.remove();
                } else {
                    System.out.println(firstIterator.toString() + secondIterator.toString());
                }

                compareCount++;
            }

            reader1.close();

            reader2.close();
        }

    }
}
