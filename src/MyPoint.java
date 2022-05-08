public class MyPoint {
    public double y, x, z;

    public MyPoint(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getZ(){
        return z;
    }

    public double getX(){
        return x;
    }

    public double getY(){
        return y;
    }

    public void setX(double x){
        this.x = x;
    }
    public void setY(double y){
        this.y = y;
    }
    public void setZ(double z){
        this.z = z;
    }
}
