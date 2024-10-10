public class Burrito{
    private String size;
    private String protein;
    private String rice;
    private String beans;
    private String toppings;
    private boolean guac;

    public void setSize(String newSize){
        size=newSize;
    }
    public String getSize(){
        return size;
    }

    public void setProtein(String newProtein){
        protein=newProtein;
    }
    public String getProtein(){
        return protein;
    }

    public void setRice(String newRice){
        rice=newRice;
    }
    public String getRice(){
        return rice;
    }

    public void setBeans(String newBeans){
        beans=newBeans;
    }
    public String getBeans(){
        return beans;
    }
    public void setToppings(String newToppings){
        toppings=newToppings;
    }
    public String getToppings(){
        return toppings;
    }
    public void setGuac(boolean newGuac){
        guac=newGuac;
    }
    public boolean getGuac(){
        return guac;
    }


    public Burrito(){
        this.size="small";
        this.protein="no";
        this.rice="no";
        this.beans="black";
        this.toppings="no";
        this.guac=false;
    }

    public Burrito(String size, String protein){
        this.size=size;
        this.protein=protein;
        this.rice="no";
        this.beans="no";
        this.toppings="no";
        this.guac=false;
    }

    public Burrito(String size, String protein, String rice, String beans, String toppings, boolean guac){
        this.size=size;
        this.protein=protein;
        this.rice=rice;
        this.beans=beans;
        this.toppings=toppings;
        this.guac=guac;
    }

     public double getCost(){
        double totalCost=0.00;
        if(size.equals("small")){
            totalCost+=5;
        }else if(size.equals("large")){
            totalCost+=7.50;
        }
        if(protein.equals("chicken")||protein.equals("steak")){
            totalCost+=2;
        }else if(protein.equals("carnitas")||protein.equals("sofritas")){
            totalCost+=3;
        }
        if(!rice.equals("no")){
            totalCost+=1;
        }
        if(!beans.equals("no")){
            totalCost+=1;
        }
        if(guac){
            totalCost+=2;
        }
        return totalCost;
    }

    @Override
    public String toString(){
        double cost=getCost();
        return this.size+" "+this.protein+" Burrito with "+this.rice+" rice, "+this.beans+" beans, "+this.toppings+" and "+((this.guac)?" guac. ":" no guac. ")+"Cost: $"+cost;
    }

   

    public static void main(String[] args){
        
    }
}