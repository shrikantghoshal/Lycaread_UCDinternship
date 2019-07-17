import java.util.LinkedList;

public class MultipleParticleCompare {

    private int outputParticleNumber;
    private double euTheta1, euPhi1, euOmega1, euTheta2, euPhi2, euOmega2, centralX1, centralY1, centralX2, centralY2;

    public int getOutputParticleNumber() {
        return outputParticleNumber;
    }

    public double getEuTheta1() {
        return euTheta1;
    }

    public double getEuPhi1() {
        return euPhi1;
    }

    public double getEuOmega1() {
        return euOmega1;
    }

    public double getEuTheta2() {
        return euTheta2;
    }

    public double getEuPhi2() {
        return euPhi2;
    }

    public double getEuOmega2() {
        return euOmega2;
    }

    public double getCentralX1() {
        return centralX1;
    }

    public double getCentralY1() {
        return centralY1;
    }

    public double getCentralX2() {
        return centralX2;
    }

    public double getCentralY2() {
        return centralY2;
    }

    public MultipleParticleCompare (Particle oneParticle, Particle twoParticle){
        outputParticleNumber = oneParticle.getParticleNumber();

        euTheta1 = oneParticle.getEulerTheta();
        euPhi1 = oneParticle.getEulerPhi();
        euOmega1 = oneParticle.getEulerOmega();

        centralX1 = oneParticle.getCentreX();
        centralY1 = oneParticle.getCentreY();

        euTheta2 = twoParticle.getEulerTheta();
        euPhi2 = twoParticle.getEulerPhi();
        euOmega2 = twoParticle.getEulerOmega();

        centralX2 = twoParticle.getCentreX();
        centralY2 = twoParticle.getCentreY();
    }

    @Override
    public String toString() {
        return String.format(
                "%d  ||  %.2f  -  %.2f  -  %.2f  |  %.2f  -  %.2f  -  %.2f  ||  %.2f  -  %.2f |  %.2f  -  %.2f  ||",
                outputParticleNumber, euTheta1, euPhi1, euOmega1, euTheta2, euPhi2, euOmega2, centralX1, centralY1,
                centralX2, centralY2);
    }
}

