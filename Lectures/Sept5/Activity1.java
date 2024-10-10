import java.awt.*;

public class Testing{
    public static void main(String[] args){
        Point a=new Point(4,4);
        Point b=new Point(1,3);
        Point c=new Point(4,2);
        Point d=new Point(3,1);
        Point e=new Point(2,3);
        print(a, b, c, d, e);
        
    }
    public static void print(Point a, Point b, Point c, Point d, Point e){
        for(int x=0; x<5; x++){
            System.out.println("-----------");
            for(int y=0; y<5; y++){
                System.out.print("|");
                if((a.getX()==x && a.getY()==y) ||
                (b.getX()==x && b.getY()==y) ||
                (c.getX()==x && c.getY()==y) ||
                (d.getX()==x && d.getY()==y) ||
                (e.getX()==x && e.getY()==y)){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }
        System.out.println("-----------");
    }
}