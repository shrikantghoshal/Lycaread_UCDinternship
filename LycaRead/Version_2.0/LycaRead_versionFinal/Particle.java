/**
 * A Particle - Has six descriptive parameters apart from the particle number:
 * <ul>
 *     <li>Three Euler angles: Theta, Phi, Omega
 *     <li>Two Central Angles: X and Y
 *     <li>A Scaling Factor
 * </ul>
 * 
 * <p>Made for use in the LycaRead program</p>
 * 
 * @author Shrikant Ghoshal
 */
public class Particle {
    private int ParticleNumber;
    private double EulerTheta, EulerPhi, EulerOmega, CentreX, CentreY, ScalingFactor;

    /**
     * Returns the corresponding particle number
     * @return Particle number
     */
    public int getParticleNumber() {
        return ParticleNumber;
    }

    /**
     * Returns the Euler theta angle of the corresponding particle
     * @return Euler Theta
     */
    public double getEulerTheta() {
        return EulerTheta;
    }

    /**
     * Returns the Euler phi angle of the corresponding particle
     * @return Euler Phi
     */
    public double getEulerPhi() {
        return EulerPhi;
    }

    /**
     * Returns the Euler omega angle of the corresponding particle
     * @return Euler Omega
     */
    public double getEulerOmega() {
        return EulerOmega;
    }

    /**
     * Returns the Centre X angle of the corresponding particle
     * @return Centre X
     */
    public double getCentreX() {
        return CentreX;
    }

    /**
     * Returns the Centre Y angle of the corresponding particle
     * @return Centre Y
     */
    public double getCentreY() {
        return CentreY;
    }

    /**
     * Returns the Scaling Factor of the corresponding particle
     * @return Scaling Factor
     */
    public double getScalingFactor() {
        return ScalingFactor;
    }
/**
 * 
 * Creates a Particle object given the following parameters
 * 
 * @param particleNumber The particle number
 * @param eulerTheta Value of Euler Theta angle
 * @param eulerPhi Value of Euler Phi angle
 * @param eulerOmega Value of Euler Omega angle
 * @param centreX Value of Centre X angle
 * @param centreY Value of Centre Y angle
 * @param scalingFactor Value of the scaling factor
 */
    public Particle(int particleNumber, double eulerTheta, double eulerPhi, double eulerOmega, double centreX,
            double centreY, double scalingFactor) {
        this.ParticleNumber = particleNumber;
        this.EulerTheta = eulerTheta;
        this.EulerPhi = eulerPhi;
        this.EulerOmega = eulerOmega;
        this.CentreX = centreX;
        this.CentreY = centreY;
        this.ScalingFactor = scalingFactor;
    }
}