import java.io.*;
import java.lang.Exception;
import java.util.*;

public class LycaRead {

    
    public static void main(String[] args) {

        String fileName1, fileName2;

        ElementSeparation newSet = new ElementSeparation();

        try {
            newSet.readFileByLine("/Users/shrikantghoshal/Desktop/UCD_work/P22demo/dat/P22demo_stack.date_020", "/Users/shrikantghoshal/Desktop/UCD_work/P22demo/dat/P22demo_stack.dato_020");

        } catch (FileNotFoundException exception) {
            System.out.println("File not found in directory");
            System.exit(0);
        }

        newSet.separateLineByParam();

        for (int particleCounter = 0; particleCounter <= newSet.iteration1.listOfParticles.size(); particleCounter++) {
            MultipleParticleCompare outputScript = new MultipleParticleCompare(
                    newSet.iteration1.listOfParticles.get(particleCounter), newSet.iteration2.listOfParticles.get(particleCounter));

            double Xcompare, Ycompare;
            double tempCentralX1 = outputScript.getCentralX1();
            double tempCentralY1 = outputScript.getCentralY1();
            double tempCentralX2 = outputScript.getCentralX2();
            double tempCentralY2 = outputScript.getCentralY2();

            if (tempCentralX1 >= tempCentralX2) {
                Xcompare = tempCentralX1 / tempCentralX2;
            } else {
                Xcompare = tempCentralX2 / tempCentralX1;
            }

            if (tempCentralY1 >= tempCentralY2) {
                Ycompare = tempCentralY1 / tempCentralY2;
            } else {
                Ycompare = tempCentralY2 / tempCentralY1;
            }

            if (Xcompare > 0.2 || Ycompare > 0.2) {
                System.out.println(outputScript.toString());
                particleCounter++;
            } else {
                particleCounter++;
            }

        }

    }
}