import java.util.*;
public static int maxProfit(){
    int buyPrice = Integer.MAX_VALUE;
    int mprofit = 0;

    for(int i=0; i<prices.length; i++){
        if(buyPrice<prices[i]){//profit
            int profit = prices[i]-buyPrice;//today's prrofit
            mprofit = Math.max(mprofit,profit);
        }else{
            buyPrice = prices[i];
        }
    }

    return mprofit;
}
public class stocks {
    int prices[] = {7,1,5,3,6,4};
    System.out.println(maxProfit(prices));
}
