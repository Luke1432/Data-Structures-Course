public class Activity3A1{
    public static void main(String[] args){
        int[] arrayToSort=new int[10];
        for(int i=0; i<arrayToSort.length; i++){
            arrayToSort[i]=(int)Math.round(Math.random()*10);
        }
        for(int i=0; i<arrayToSort.length; i++){
            System.out.print((i==arrayToSort.length-1)?arrayToSort[i]+". ":arrayToSort[i]+", ");
        }
        System.out.println();
        int swapCount=0;
        int j=0;
        while(swapCount!=0){
            if(arrayToSort[j]>arrayToSort[j+1]){
                swapCount++;
                int temp=arrayToSort[j+1];
                arrayToSort[j+1]=arrayToSort[j];
                arrayToSort[j]=temp;
            }
            j++;

        }
        for(int i=0; i<arrayToSort.length; i++){
            System.out.print((i==arrayToSort.length-1)?arrayToSort[i]+".":arrayToSort[i]+", ");
        }

    }
}