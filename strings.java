import java.util.*;
public class strings {
    public static boolean isPalindrome(String str){
        for(int i=0; i<=str.length()/2; i++){
            int n = str.length();
            if(str.charAt(i)!=str.charAt(n-i-1)){
                return false ;
            }
        }
        return true ;
    }
    public static float getShortestPath(String path){
        int x=0;
        int y = 0 ;
        for(int i=0; i<path.length(); i++){
            char dir = path.charAt(i);
            if(dir == 's'){
                y--;
            }
            else if(dir == 'n'){
                y++;
            }
            else if(dir == 'w'){
                x--;
            }
            else{
                x++;
            }
        }
        return (float)Math.sqrt(x*x + y*y);
    }
    public static String upperCase(String str){
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        
        for(int i=1; i<str.length(); i++){
            if(str.charAt(i) == ' ' && i<str.length()-1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            }else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString() ;
    }
    public static String compress(String str){
        String newStr = "";
        for(int i=0; i<str.length(); i++){
            Integer count = 1;
            while(i<str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                count++;
                i++;
            }
            newStr += str.charAt(i);
            if(count>1){
                newStr += count.toString();
            }
        }
        return newStr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(compress(str));
    }
}