import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class ParticleList {

    /**
     * A list of Particle objects
     */
    public ArrayList<Particle> micrographs = new ArrayList<Particle>();

    public ParticleList(){
        micrographs = new ArrayList<Particle>();
    }

    /**
     * Reads an enternal text file and separates the content into the different particle parameters
     * 
     * @param fileName Source of the input file entered into the command line directly
     * @throws FileNotFoundException Exception thrown if the file source isn't found
     */
    public void readFile(String fileName) throws FileNotFoundException {
        Scanner input = new Scanner(new File(fileName));

        File file = new File(fileName);
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis, cs);
        BufferedReader br = new BufferedReader(isr);
        
        String line;
        while((line = br.readLine()) != null){
            // process the line
            System.out.println(line);
            micrographs.clear();

            line = input.nextLine();

            String[] part = line.split(",    ");


        //Skips image file headers within the data files
            while(part.length < 2){
                
                input.nextLine();
                line = input.nextLine();

                part = line.split(",    ");

            }

            String[] mainConsidered = part[0].split(",");

            int tempParticleNumber;
            double tempEulerTheta, tempEulerPhi, tempEulerOmega, tempCentreX, tempCentreY, tempScalingFactor;

            tempParticleNumber = Integer.parseInt(mainConsidered[0].trim());

            tempEulerTheta = Double.parseDouble(mainConsidered[1].trim());
            tempEulerPhi = Double.parseDouble(mainConsidered[2].trim());
            tempEulerOmega = Double.parseDouble(mainConsidered[3].trim());

            tempCentreX = Double.parseDouble(mainConsidered[4].trim());
            tempCentreY = Double.parseDouble(mainConsidered[5].trim());
            
            tempScalingFactor = Double.parseDouble(mainConsidered[6].trim());

            Particle singlePoint = new Particle(tempParticleNumber, tempEulerTheta, tempEulerPhi, tempEulerOmega, tempCentreX, tempCentreY, tempScalingFactor);

            micrographs.add(singlePoint);
        
        }

        input.close();
    }

    /**
     * Adds a particle with its details to the list of micrographs
     * @param newParticle The particle to be added to the list of micrographs
     */
    public void add (Particle newParticle){
        micrographs.add(newParticle);
    }


    /**
     * 
     * @return The number of particles present in an iteration
     */
    public int size(){
        return micrographs.size();
    }

    /**
     * 
     * @param index The particle number in the iteration
     * @return The details of the particle corresponding to the input number
     */
    public Particle get(int index){
        if(index>=size()){
            throw new IndexOutOfBoundsException("Entered Index exceeds the maximum number of particles in the iteration.");
        }
        if(index<0){
            throw new IndexOutOfBoundsException("Entered Index cannot be negative.");
        }
        return micrographs.get(index);
    }
}
