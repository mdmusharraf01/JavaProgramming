import java.util.Scanner;
public class revnum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" enter the num");
        int x = sc.nextInt();
        int rev=0;
        while(x>0){
            int lastDigit =x%10;
            rev = (rev*10)+lastDigit;
            x=x/10;
        }System.out.println("reversed num"+rev);
    }
}