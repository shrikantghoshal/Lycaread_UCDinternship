import java.util.*;

public class DefaultParticleList {
    /**
     * A list of Particle objects
     */
    public LinkedList<Particle> listOfParticles = new LinkedList<>();

    public DefaultParticleList() {
        listOfParticles = new LinkedList<Particle>();
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

        Particle singleParticle = new Particle(tempParticleNumber, tempEulerTheta, tempEulerPhi, tempEulerOmega,
                tempCentreX, tempCentreY, tempScalingFactor);

        listOfParticles.add(singleParticle);
    }

}