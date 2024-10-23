public class NBody {
    public static double readRadius(String fileName){
        In in  = new In(fileName);

        int planetNumber = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Planet[] readPlanets(String fileName){
        In in = new In(fileName);

        int planetNumber = in.readInt();
        double radius = in.readDouble();
        Planet[] planets = new Planet[5];
        
        for(int i = 0; i < 5; i++){
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            planets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
        }

        return planets;
    }

    public static void main(String[] args) {
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        double radius = readRadius(filename);
        Planet[] planets = readPlanets(filename);

        StdDraw.setXscale(-radius, radius);
        StdDraw.setYscale(-radius, radius);

        StdDraw.enableDoubleBuffering();

        double time = 0;
        while(time <= T){
            double[] xForces = new double[5];
            double[] yForces = new double[5] ;
            for(int i = 0; i < 5; i++){
                double netXForce = planets[i].calcNetForceExertedByX(planets);
                double netYForce = planets[i].calcNetForceExertedByY(planets);
                xForces[i] = netXForce;
                yForces[i] = netYForce;
            }

            for(int i = 0; i < 5; i++){
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.picture(0, 0, "images/starfield.jpg");
            for(Planet planet : planets){
                planet.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time += dt;
        }

    }
}
