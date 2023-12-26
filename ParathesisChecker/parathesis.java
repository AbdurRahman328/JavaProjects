import java.util.Scanner;

public class parathesis {
    public static void main(String[] args) {
        System.out.println("Enter String to check : ");
        Scanner sc = new Scanner(System.in);
        String para = sc.nextLine();
        System.out.println("Enter String to check "+para);

        if(check(para)){
            System.out.println("Parathesis is balanced");
        }
        else{
            System.out.println("Parathesis is not balanced");
        }
    }  

    public static boolean check(String para){
        
        return true;

    }
}
