public class bitmanuplation {
    public static void oddOrEven(int n){
        int bitMask = 1;
        if((n & bitMask) == 0){
            //even number
            System.out.println("even number");
        }else{//odd number
            System.out.println("odd number");
        }
    }
    public static int getIthBit(int n, int i){
        int bitMask = 1<<i;
        if((n & bitMask) == 0){
            return 0;
        }else{
            return 1;
        }
    }
    public static int setIthBit(int n, int i){
        int bitMask = 1<<i;
        return n | bitMask;
    }
    public static int clearIthBit(int n, int i){
        int bitMask = ~(1<<i);
        return n & bitMask;
    }
    public static int updateIthBit(int n, int i, int newBit){
        if(newBit == 0){
            return clearIthBit(n, i);
        }else{
            return setIthBit(n, i);
        }
    }
    public static int clearIBits(int n , int i){
        int bitMask = (~0)<<i;
        return n & bitMask;
    }
    public static int clearBits(int n, int i, int j){
        int a = ((~0)<<(j+1));
        int b = (1<<i)-1;
        int bitMask = a|b;
        return n & bitMask;
    }
    public static boolean isPowerOfTwo(int n){
        if((n & (n-1)) == 0){
            return true;
        }else{
            return false;
        }
    }
    public static int setBits(int n){
        int count = 0;
        while(n!=0){
            n = n & (n-1);
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(getIthBit(11, 1));
    }
}