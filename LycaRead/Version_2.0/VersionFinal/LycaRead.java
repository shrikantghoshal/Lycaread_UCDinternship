import java.io.*;
import java.lang.Exception;
import java.util.*;

public class LycaRead {

    
    public static void main(String[] args) {
        // // Reading files using buffered reader
        // BufferedReader reader1 = new BufferedReader(
        // new
        // FileReader("/Users/shrikantghoshal/Desktop/UCD_work/P22demo/dat/P22demo_stack.date_020"));
        // BufferedReader reader2 = new BufferedReader(
        // new
        // FileReader("/Users/shrikantghoshal/Desktop/UCD_work/P22demo/dat/P22demo_stack.date_019"));
        String fileName1, fileName2;

        ElementSeparation newSet = new ElementSeparation();

        try {
            newSet.readFileByLine("/Users/shrikantghoshal/Desktop/UCD_work/P22demo/dat/P22demo_stack.date_020", "/Users/shrikantghoshal/Desktop/UCD_work/P22demo/dat/P22demo_stack.date_019");

        } catch (FileNotFoundException exception) {
            System.out.println("File not found in directory");
            System.exit(0);
        }

        // int lineCounter = 0;

        // DefaultParticleList iteration1 = new DefaultParticleList();
        // DefaultParticleList iteration2 = new DefaultParticleList();

        // while (reader1.hasNextLine() && reader2.hasNextLine()) {

        //     String[] iter1split = reader1.nextLine().split(",    ");
        //     String[] iter2split = reader2.nextLine().split(",    ");

        //     while (iter1split.length != iter2split.length || iter1split.length != 2) {
        //         lines1.add(reader1.nextLine());
        //         lines2.add(reader2.nextLine());

        //         iter1split = reader1.nextLine().split(",    ");
        //         iter2split = reader2.nextLine().split(",    ");
        //     }

        //     iteration1.particleGen(iter1split[0]);
        //     iteration2.particleGen(iter2split[0]);
        //     lineCounter++;

        // }

        // reader1.close();
        // reader2.close();

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