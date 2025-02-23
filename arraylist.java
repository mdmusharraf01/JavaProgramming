import java.util.*;
public class arraylist {
    public static void main(String args[]){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(6);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        int target = 5; 
        System.out.println(pairSum2(list, target));

        /*//Reverse print 
        for(int i = list.size()-1; i >= 0; i--){
            System.out.print( list.get(i) + " ");
        }
        System.out.println();*/
        /*int max = Integer.MIN_VALUE;
        for(int i = 0; i<list.size(); i++){
            if(max<list.get(i)){
                max = list.get(i);
            }
        }
        System.out.println("max elemet = " + max);*/
        /*System.out.println(list);
        Collections.sort(list);//ascending
        System.out.println(list);
        
        //decending
        Collections.sort(list,Collections.reverseOrder());
        System.out.println(list);*/
        /*ArrayList<ArrayList<Integer>> mainlist = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1); list.add(2);
        mainlist.add(list);
        
        ArrayList<Integer> list2 = new ArrayList<>();
        list.add(3); list.add(4);
        mainlist.add(list2);

        for(int i = 0; i<mainlist.size(); i++){
            ArrayList<Integer> currlist = mainlist.get(i);
            for(int j = 0; j<currlist.size(); j++){
                System.out.print(currlist.get(j) + " ");
            }
            System.out.println();
        }*/
        /*ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);

        System.out.println(storeWater(height));*/
    }

    //brute force


    /*public static int storeWater(ArrayList<Integer> height){
        int maxWater = 0;
        //brute force
        for(int i=0; i<height.size(); i++){
            for(int j=i+1; j<height.size(); j++){
                int ht = Math.min(height.get(i), height.get(j));
                int width = j-i;
                int currWater = ht*width;
                maxWater = Math.max(maxWater, currWater);
            }
        }
        return maxWater; 
    }*/
    /*public static boolean pairSum1(ArrayList<Integer> list, int target){
    //same code for pairsum 2
        for(int i=0; i<list.size(); i++){
            for(int j = i+1; j<list.size(); j++){
                if(list.get(i)+ list.get(j) == target){
                    return true;
                }
            }
        }
        return false;
    }*/


    //optimal methods


    /*public static int storeWater(ArrayList<Integer> height){
        int maxWater = 0;
        int lp = 0;
        int rp = height.size()-1;

        while(lp < rp){
            //calculate water area
            int ht = Math.min(height.get(lp), height.get(rp));
            int width = rp - lp;
            int currWater = ht * width;
            maxWater = Math.max(maxWater, currWater);

            //update ptr
            if(height.get(lp) < height.get(rp)){
                lp++;
            }else{
                rp--;
            }
        }
        return maxWater;
    }*/
    // 2pointer approach
    public static boolean pairSum1(ArrayList<Integer> list, int target){
        int lp = 0 ;
        int rp = list.size()-1;
        while(lp!=rp){
            if(list.get(rp) + list.get(lp) == target){
                return true;
            }
            if(list.get(rp) + list.get(lp) < target){
                lp++; 
            }else{
                rp--;
            }
        }
        return false ;
    }
    public static boolean pairSum2(ArrayList<Integer> list, int target){
        int bp = -1;
        int n = list.size();
        for(int i = 0; i<list.size(); i++){
            if(list.get(i)>list.get(i+1)){
                bp = i;
                break;
            }
        }
        int lp = bp+1;//smallest
        int rp = bp;//largest
        while(lp != rp){
            //case 1
            if(list.get(lp) + list.get(rp) == target){
                return true;
            }
            //case 2
            if(list.get(rp) + list.get(lp) < target){
                lp = (lp + 1)%n;
            }else{
                rp = (n+rp-1)%n;
            }
        }
        return false;
    }
}
