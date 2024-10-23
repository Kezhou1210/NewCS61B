public class Planet {

    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static double G = 6.67e-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img){
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet(Planet p){
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet otherPlanet){
        double xDistance = 0;
        double yDistance = 0;
        xDistance = this.xxPos - otherPlanet.xxPos;
        yDistance = this.yyPos - otherPlanet.yyPos;

        double distance;
        distance = Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
        return distance;
    }

    public double calcForceExertedBy(Planet otherPlanet){
        double distance = this.calcDistance(otherPlanet);

        double totalForce = 0;
        totalForce = G * ((this.mass * otherPlanet.mass) / Math.pow(distance, 2));
        return totalForce;
    }

    public double calcForceExertedByX(Planet otherPlanet){
        double totalForce = 0;
        totalForce = this.calcForceExertedBy(otherPlanet);

        double distance = this.calcDistance(otherPlanet);
        double xDistance = otherPlanet.xxPos - this.xxPos;
        double cos = 0;
        cos = xDistance / distance;

        double xForce = 0;
        xForce = totalForce * cos;
        return xForce;
    }

    public double calcForceExertedByY(Planet otherPlanet){
        double totalForce = 0;
        totalForce = this.calcForceExertedBy(otherPlanet);

        double distance = this.calcDistance(otherPlanet);
        double yDistance = otherPlanet.yyPos - this.yyPos;
        double sin = 0;
        sin = yDistance / distance;

        double yForce = 0;
        yForce = totalForce * sin;
        return yForce;
    }

    public double calcNetForceExertedByX(Planet[] planets){
        double netXForce = 0;
        for (Planet planet : planets) {
            if(this.equals(planet)){
                continue;
            }
            netXForce = netXForce + this.calcForceExertedByX(planet);
        }
        return netXForce;
    }

    public double calcNetForceExertedByY(Planet[] planets){
        double netYForce = 0;
        for (Planet planet : planets) {
            if(this.equals(planet)){
                continue;
            }
            netYForce = netYForce + this.calcForceExertedByY(planet);
        }
        return netYForce;
    }

    public void update(double time, double xForce, double yForce){
        double xAcceleration = 0;
        double yAcceleration = 0;
        xAcceleration = xForce/this.mass;
        yAcceleration = yForce/this.mass;

        this.xxVel = this.xxVel + xAcceleration * time;
        this.yyVel = this.yyVel + yAcceleration * time;

        this.xxPos += this.xxVel * time;
        this.yyPos += this.yyVel * time;
    }

    public void draw(){
        StdDraw.picture(xxPos, yyPos, "images/"+imgFileName);
    }
}
