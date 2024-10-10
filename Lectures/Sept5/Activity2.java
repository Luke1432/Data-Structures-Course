class Car{
    String brand;
    int age;
    boolean isSports;
    int maxVelocity;

    public Car(String br, int a, boolean isS, int maxV){
        brand=br;
        age=a;
        isSports=isS;
        maxVelocity=maxV;
    }
    public String getBrand(){
        return brand;
    }
    public void setBrand(String newBrand){
        brand=newBrand;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int newAge){
        age=newAge;
    }
    public boolean isSportsCar(){
        return isSports;
    }
    public void setSportsCar(String is){
        if(is.equals("yes")){
            isSports=true;
        }else{
            isSports=false;
        }
    }
    public int getMaxVelocity(){
        return maxVelocity;
    }
    public void setMaxVelocity(int max){
        maxVelocity=max;
    }
    public void toCarString(){
        System.out.println("This car is made by "+brand+", is "+age+" years old, has a maxmimum velocity of "+maxVelocity+" and "+(isSports?"is a sports car":"is not a sports car."));
    }
}
public class Activity2{
    public static void main(String[] args){
        Car c=new Car("Lamborghini", 10, true, 300);
        System.out.println(c.getAge());
    }
}