public class Activity6A1{
    public static void main(String[] args) {
        int amount=495;
        int[] memo=new int[amount+1];
        int[] coins=new int[]{200,100,25,10,5};
        System.out.println(minCoinChange(coins, amount));
        System.out.println(recursiveMinCoinChange(coins, amount, memo));
    }
    public static int minCoinChange(int[] coins, int amount){
        int numCoins=0;
        while(amount!=0){
            if(amount>=200){
                amount-=200;
                numCoins+=1;
            }else if(amount>=100){
                amount-=100;
                numCoins+=1;
            }else if(amount>=25){
                amount-=25;
                numCoins+=1;
            }else if(amount>=10){
                amount-=10;
                numCoins+=1;
            }else{
                amount-=5;
                numCoins+=1;
            }
        }
        return numCoins;
    }
    public static int recursiveMinCoinChange(int[] coins, int amount, int[] memo){
        if(amount==0){
            return 0;
        }else if(memo[amount]!=0){
            return memo[amount];
        }else{
            int minCoins=Integer.MAX_VALUE;
            for(int coin:coins){
                if(coin<=amount){
                    int remaining=minCoinChange(coins, amount-coin);
                    minCoins=Math.min(minCoins, 1+remaining);
                }
            }
            return minCoins;
        }
    }
}