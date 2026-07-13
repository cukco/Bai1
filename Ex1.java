class Rectanglee{
    private double width;
    private double height;
    public Rectanglee(double width,double height){
        this.height=height;
        this.width=width;
    }
    double getArea(){
        return width*height;
    }
    double getPerimeter(){
        return 2*(width+height);
    }
    double getWidth(){
        return width;
    }
    double getHeight(){
        return height;
    }
    void printInfo(){
        System.out.print("Rectangle(width= "+width+", height= "+height+ ", area= "+getArea()+", perimeter= " +getPerimeter()+")");
    }
}
public class Ex91 {
    public static void main(String[] args) {
        Rectanglee r1 = new Rectanglee(3, 4);
        r1.printInfo();
    }
}
