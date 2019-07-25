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
        double tempEulerTheta, tempEulerPhi, tempEulerOmega, tempCentreX, tempCentreY, tempScalingFactor, tempScore1, tempScore2, tempScore3;
        tempParticleNumber = Integer.parseInt(superSplit1[0].trim());

        tempEulerTheta = Double.parseDouble(superSplit1[1].trim());
        tempEulerPhi = Double.parseDouble(superSplit1[2].trim());
        tempEulerOmega = Double.parseDouble(superSplit1[3].trim());

        tempCentreX = Double.parseDouble(superSplit1[4].trim());
        tempCentreY = Double.parseDouble(superSplit1[5].trim());

        tempScalingFactor = Double.parseDouble(superSplit1[6].trim());

        tempScore1 = Double.parseDouble(superSplit1[7].trim());
        tempScore2 = Double.parseDouble(superSplit1[8].trim());
        tempScore3 = Double.parseDouble(superSplit1[9].trim());

        Particle singleParticle = new Particle(tempParticleNumber, tempEulerTheta, tempEulerPhi, tempEulerOmega,
                tempCentreX, tempCentreY, tempScalingFactor, tempScore1, tempScore2, tempScore3);

        listOfParticles.add(singleParticle);
    }

}