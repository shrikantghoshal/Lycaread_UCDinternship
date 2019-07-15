class Particle{
    private int ParticleNumber;
    private double EulerTheta, EulerPhi, EulerOmega, CentreX, CentreY, ScalingFactor;

    public int getParticleNumber(){
        return ParticleNumber;
    }

    public double getEulerTheta(){
        return EulerTheta;
    }
    public double getEulerPhi(){
        return EulerPhi;
    }
    public double getEulerOmega(){
        return EulerOmega;
    }

    public double getCentreX(){
        return CentreX;
    }
    public double getCentreY(){
        return CentreY;
    }
    
    public double getScalingFactor(){
        return ScalingFactor;
    }

    public Particle(int particleNumber, double eulerTheta, double eulerPhi, double eulerOmega, double centreX, double centreY, double scalingFactor){
        this.ParticleNumber = particleNumber;
        this.EulerTheta = eulerTheta;
        this.EulerPhi = eulerPhi;
        this.EulerOmega = eulerOmega;
        this.CentreX = centreX;
        this.CentreY = centreY;
        this.ScalingFactor = scalingFactor;
    }

    @Override
    public String toString(){
        return String.format("%d     %f %f", ParticleNumber, CentreX, CentreY); 
    }
}