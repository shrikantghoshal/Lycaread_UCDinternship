import java.io.*;
import java.util.*;

class FirstIteration extends ParticleList {

    public FirstIteration() {

        micrographs = new ArrayList<Particle>();

    }

}

class SecondIteration extends ParticleList {

    public SecondIteration() {

        micrographs = new ArrayList<>();

    }

}

public class ComparisionOutput {

    public static void main(String[] args) {

        FirstIteration iteration1 = new FirstIteration();
        SecondIteration iteration2 = new SecondIteration();

        iteration1.

        try {
            iteration1.readFile("/Users/shrikantghoshal/Desktop/UCD_work/P22demo/dat/P22demo_stack.date_020");
        } catch (FileNotFoundException ex) {
            System.out.println("File not found in directory");
            System.exit(0);
        }

        try {
            iteration2.readFile("/Users/shrikantghoshal/Desktop/UCD_work/P22demo/dat/P22demo_stack.date_019");
        } catch (FileNotFoundException ex) {
            System.out.println("File not found in directory");
            System.exit(0);
        }

        if (iteration1.micrographs.size() != iteration2.micrographs.size()) {
            throw new UnsupportedOperationException(
                    "Input files do not have the same number of particles for comparision.\n");
        }

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

        // System.out.println(iteration1.micrographs.get(0).getParticleNumber() + " | "
        // + iteration1.micrographs.get(0).getCentreX() + " - "
        // + iteration1.micrographs.get(0).getCentreY() + " | "
        // + iteration2.micrographs.get(0).getCentreX() + " - "
        // + iteration2.micrographs.get(0).getCentreY());

    }

}