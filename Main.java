import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean loop = true;
        
        System.out.println("Welcome to the fraction calculator");
        System.out.println("Type h for help or q to quit");
        
        
        while (loop == true){
            System.out.println("Enter a fraction operation: ");
            String answer = input.nextLine();
            
            //the calculator will loop until q is inputted
            if(answer.toLowerCase().equals("q")){
                loop = false;
                System.out.println("Closed");
            }
            //if the user inputs "h", then it will tell the user what the calc can do
            else if (answer.toLowerCase().equals("h")){
                System.out.println("Fractions have parenthesis and no space: (m/n)"); 
                System.out.println("Operations are +, -, *, /, entered with no space."); 
                System.out.println("You can simplify by typing: simplify(m/n)");
            }
            else{
                //if the user wants to only simplify the fraction
                //the user can imput "simplify" and the program will only simplify the fraction given
                if (answer.substring(0, 8).toLowerCase().equals("simplify")){
                    int firstParentheses = answer.indexOf("(");
                    String substring1 = answer.substring(firstParentheses + 1);
                    int slash = substring1.indexOf("/");
                    int num = Integer.valueOf(substring1.substring(0, slash));
                    int denom = Integer.valueOf(substring1.substring(slash + 1, substring1.length()- 1));
                    Fraction f = new Fraction(num, denom);
                    System.out.println(f.simplify(f));
                }
                else{
                    //gets the numerators and denominators of the two fractions in the equation 
                    for (int i = 0; i < answer.length() - 2; i++){
                        int firstParentheses = answer.indexOf(")");
                        int slash1 = answer.indexOf("/");
                        String substring1 = answer.substring(0, firstParentheses + 1);
                        int num1 = Integer.valueOf(substring1.substring(1, slash1));
                        int denom1 = Integer.valueOf(substring1.substring(slash1 + 1, substring1.length() - 1));
                        String substring2 = answer.substring(firstParentheses + 2);
                        int slash2 = substring2.indexOf("/");
                        int num2 = Integer.valueOf(substring2.substring(1, slash2));
                        int denom2 = Integer.valueOf(substring2.substring(slash2 + 1, substring2.length() - 1));
                        
                        //creates the two fraction objects 
                        Fraction f = new Fraction(num1, denom1);
                        Fraction g = new Fraction(num2, denom2);
                        
                        //looks for the second bracket and operation symbol to determine what operation the user wants
                        String secondParentheses = answer.substring(i, i + 1);
                        String operation = answer.substring(i + 1, i + 2);
                        
                        //if it's the "+" operation, the program uses the addition method
                        if (secondParentheses.equals(")") && operation.equals("+")){
                            System.out.println(f.add(g)); 
                        }
                        //if it's the "-" operation, the program uses the subtraction method
                        else if (secondParentheses.equals(")") && operation.equals("-")){
                            System.out.println(f.subtract(g)); 
                        }
                        //if it's the "*" operation, the program uses the multiplication method
                        else if (secondParentheses.equals(")") && operation.equals("*")){
                            System.out.println(f.multiply(g)); 
                        }
                        //if it's the "/" operation, the program uses the division method
                        else if (secondParentheses.equals(")") && operation.equals("/")){
                            System.out.println(f.divide(g)); 
                        }
                        
                    }
                }
            }
            
        }
        
    }
}
