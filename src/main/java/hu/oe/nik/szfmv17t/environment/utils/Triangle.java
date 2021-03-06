package hu.oe.nik.szfmv17t.environment.utils;
import java.awt.Point;
/**
 *
 * @author Krisztian Juhasz
 */
public class Triangle {
    double aX, aY;
    double bX, bY;
    double cX, cY;
    SensorType sensor;

    public SensorType getSensor() {
        return sensor;
    }
    
    public Triangle(Point a, Point b, Point c, SensorType sensor)
    {
        this.aX = a.x;
        this.aY = a.y;
        this.bX = b.x;
        this.bY = b.y;
        this.cX = c.x;
        this.cY = c.y;
        this.sensor = sensor;
    }
    
    public boolean contains(double objectX, double objectY)
    {
        //Barycentric method
        double dX = objectX - cX;
        double dY = objectY - cY;
        double dX21 = cX - bX;
        double dY12 = bY - cY;
        double D = dY12*(aX - cX) + dX21*(aY-cY);
        double s = dY12*dX + dX21*dY;
        double t = (cY-aY)*dX + (aX-cX)*dY;
        if (D<0) return s<=0 && t<=0 && s+t>=D;
        return s>=0 && t>=0 && s+t<=D;
    }

    @Override
    public String toString() {
        String triangleString = String.format("%1$s  A( %2$d, %3$d ) B( %4$d, %5$d) C( %6$d, %7$d )",
                sensor.name(),((int) aX),((int) aY),((int) bX),((int) bY),((int) cX),((int) cY));

        return triangleString;
    }
}
