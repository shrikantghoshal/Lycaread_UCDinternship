import java.io.*;
import java.lang.Exception;
import java.util.*;

public class LycaRead {

    public static void main(String[] args) {

        String fileName1, fileName2;
        double percentParam;

        ElementSeparation newSet = new ElementSeparation();
        Scanner userIn = new Scanner(System.in);

        System.out.println("Welcome to LycaRead. Please follow the instructions below.\n\n");
        System.out.print("Please enter the file path for the first file to read in: ");

        fileName1 = userIn.next();

        System.out.print("\nPlease enter the file path for the second file to read in: ");

        fileName2 = userIn.next();

        try {
            newSet.readFileByLine(fileName1, fileName2);

        } catch (FileNotFoundException exception) {
            System.out.println("XXX\nError in paths entered: At least one of the files couldn't be found... \n(._.;)\n");
            System.exit(0);
        }

        newSet.separateLineByParam();

        System.out.print("Now, please enter the percentage boundary for the parameter comparision (0-100): ");
        percentParam = userIn.nextDouble();

        try {

            // create an print writer for writing to a file
            PrintWriter out = new PrintWriter(new FileWriter("LycaReadOutput.txt"));

            for (int particleCounter = 0; particleCounter < newSet.iteration1.listOfParticles
                    .size(); particleCounter++) {
                MultipleParticleCompare outputScript = new MultipleParticleCompare(
                        newSet.iteration1.listOfParticles.get(particleCounter),
                        newSet.iteration2.listOfParticles.get(particleCounter));

                double Xcompare, Ycompare;
                double tempCentralX1 = outputScript.getCentralX1();
                double tempCentralY1 = outputScript.getCentralY1();
                double tempCentralX2 = outputScript.getCentralX2();
                double tempCentralY2 = outputScript.getCentralY2();

                //System.out.println(outputScript.toString());


                if (tempCentralX1 <= tempCentralX2) {
                    Xcompare = tempCentralX1 / tempCentralX2;
                } else {
                    Xcompare = tempCentralX2 / tempCentralX1;
                }

                if (tempCentralY1 <= tempCentralY2) {
                    Ycompare = tempCentralY1 / tempCentralY2;
                } else {
                    Ycompare = tempCentralY2 / tempCentralY1;
                }

                if (Xcompare < ((100 - percentParam) / 100) || Ycompare < ((100 - percentParam) / 100)) {

                    particleCounter++;
                } else {
                    // output to the file a line
                    out.println(outputScript.toString());
                }

            }

            System.out.println("\nThe output is now in the local directory named as \"LycaReadOutput.txt\"\n");
            // close the file (VERY IMPORTANT!)
            out.close();

        } catch (IOException e1) {
            System.out.println("Error during writing");
        }

        userIn.close();

    }
}