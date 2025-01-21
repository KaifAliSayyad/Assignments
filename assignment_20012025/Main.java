import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Class c = Class.forName("Calculator");

        Method[] methods = c.getDeclaredMethods();
        
        while(true){
            System.out.println("Select the operation you want to perform.");
            System.out.println("0. Exit");
            for(int i = 0 ; i < methods.length ; i++){
                System.out.println((i+1)+". "+methods[i].getName());
            }

            System.out.print("-> ");
            int choice = sc.nextInt();
            if(choice == 0) break;

            Method operation = methods[choice-1];

            System.out.print("Enter the a in operands a, b : ");
            int num1 = sc.nextInt();
            
            
            System.out.print("Enter the b in operands a, b : ");
            int num2 = sc.nextInt();

            System.out.println("ans = "+operation.invoke(c.newInstance(), num1, num2));
        }
        sc.close();
    }
}
