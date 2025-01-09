public class recursion {
    //main function
    public static void main(String args[]) {
        /*int n = 45;
        int res = fib(n);
        System.out.println("factorial of :- "+n +" is "+ res);*/
        //int arr[] = {8,3,6,9,5,10,2,5,3};
        //String str = "mohammedmusharrafalikhateeburfzeeshan";
        //System.out.println(friendsParing(3));
        binaryStrings(3, 0, new String(""));
    }
    //increasing order
    public static void printInc(int n){
        if(n ==1){
            System.out.print(n +" ");
            return;
        }
        printInc(n-1);
        System.out.print(n+" ");
    }
    //decreasing order
    public static void printDec(int n){
        if( n == 1){
            System.out.print(1);
            return;
        }
        System.out.print(n +" ");
        printDec(n-1);
    }
    //factorial
    public static int fact(int n){
        if(n ==0){
            return 1;
        }
        int fm1 = fact(n-1);
        int fn = n*fm1;
        return fn;
    }
    public static int calcSum(int n){
        if(n == 1){
            return 1;
        }
        int sm1 = calcSum(n-1);
        int sn = n+sm1;
        return sn;
    }
    public static int fib(int n){
        if(n ==0 || n ==1){
            return n;
        }
        int fnm1 = fib(n-1);
        int fnm2 = fib(n-2);
        int fn = fnm1 + fnm2;
        return fn;
    }
    public static boolean isSorted(int arr[], int i){
        if(i == arr.length-1){
            return true;
        }
        if(arr[i] >arr[i+1]){
            return false;
        }
        return isSorted(arr, i+1);
    }
    public static int firstOcc(int arr[], int key, int i ){
        if(i == arr.length){
            return -1;
        }
        if(arr[i] == key){
            return i;
        }
        return firstOcc(arr, key, i+1);
    }
    public static int lastOcc(int arr[], int key, int i ){
        if(i == arr.length){
            return -1;
        }
        int isFound = lastOcc(arr, key, i+1);
        if(isFound != -1){
            return isFound;
        }
        //check for self
        if(arr[i] == key){
            return i;
        }
        return -1;
    }
    public static int power(int x , int n){
        if(n ==1){
            return x;
        }
        int xpnm1 = power(x, n-1);
        int xpn = x*xpnm1;
        return xpn;
    }
    public static int optimizedPower(int x, int n){
        if(n == 0){
            return 1;
        }
        int halfPower = optimizedPower(x, n/2);
        int halfPowerSq = halfPower*halfPower;
        //if n is odd
        if(n%2 != 0){
            halfPowerSq = x*halfPowerSq;
        }
        return halfPowerSq;
    }
    public static int tilingProblem(int n){
        //base case
        if(n ==0 || n == 1){
            return 1;
        }
        //vertical choice
        /*int fnm1 = tilingProblem(n-1);
        //horizontal choice
        int fnm2 = tilingProblem(n-2);
        int totWays = fnm1 + fnm2;
        return totWays;*/
        return tilingProblem(n-1) + tilingProblem(n-2);
    }
    public static void removeDublicates(String str, int idx, StringBuilder newstr, boolean map[]){
        if(idx == str.length()){
            System.out.println(newstr);
            return;
        }
        //kaam
        char currChar = str.charAt(idx);
        if(map[currChar-'a'] == true){
            //dublicate
            removeDublicates(str, idx+1, newstr, map);
        }else{
            map[currChar-'a'] = true;
            removeDublicates(str, idx+1, newstr.append(currChar), map);
        }
    }
    public static int friendsParing(int n){
        //base case
        if(n == 1 || n == 2){
            return n;
        }
        //choice
        //single
        int fnm1 = friendsParing(n-1);
        //pair
        int fnm2 = (n-1)*friendsParing(n-2);
        //total ways
        int totWays = fnm1 + fnm2;
        return totWays;
    }
    public static void binaryStrings(int n , int lastPlace, String str){
        if(n == 0){
            System.out.println(str);
            return;
        }
        //kaam
        /*if(lastPlace == 0){
            binaryStrings(n-1, str.append("0"), 0);
            binaryStrings(n-1, str.append("1"), 1);
        }else{
            binaryStrings(n-1, str.append("0"), 0);
        }*/
        binaryStrings(n-1, 0, str+"0");
        if(lastPlace == 0){
            binaryStrings(n-1, 1, str+"1");
        }
    }
}
