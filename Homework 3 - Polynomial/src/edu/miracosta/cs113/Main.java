import java.util.Scanner;

// declare main 
public class Main {
  
  public static void main(String[] args){
    Scanner keyboard = new Scanner(System.in);
      
    // create polynomial objects to get two different polynomial from the user
    Polynomial poly1 = new Polynomial();
    Polynomial poly2 = new Polynomial();
    Polynomial pAdd = null;
    int choice = 0;
      
    do{
      menu(); // display menu to the user
      // get choice 
      choice = Integer.parseInt(keyboard.nextLine());

      if(choice == 4) // if choice = 4 exit the do-while loop
        System.exit(0);
      else{
        if(choice == 1) // edit poly1
          editPolynomial(keyboard, poly1); 
        else if(choice == 2) // edit poly2
          editPolynomial(keyboard, poly2);
        else if(choice == 3){ // add poly1 and poly2
          if(poly1 != null && poly2 != null){
            pAdd = poly1.addPolynomial(poly2);
            System.out.println("Polynomial after addition is:"+ pAdd);
          }
        }
        else{ // choice isnt an option display error message
          System.out.println("Try Again.");
          keyboard.close();
        }
      }
    }while(true);
  }
  
  // menu function to display the main menu
  private static void menu(){
    System.out.println("1. Edit polynomial one");
    System.out.println("2. Edit polynomial two");
    System.out.println("3. Add polynomials");
    System.out.println("4. Exit");  
    System.out.println("Choice: ");
  }
  
  // editPolynomial function
  private static void editPolynomial(Scanner keyboard, Polynomial p){
    int choice, coefficient, exponent; // declare variables
    System.out.println("1. clear \n2. Create \n3. Add term \n4. display term");
    System.out.print("\nChoice: "); // prompt user for choice
    choice = Integer.parseInt(keyboard.nextLine()); // convert string to int
       
    if(choice == 1)
      p.clear();
    else if(choice == 2){
      System.out.println("Enter polynomial string:");
      p.create(keyboard.nextLine()); // place polynomial string into create function in polynomial.java
    }
    else if(choice == 3){ // prompt user for the coefficient and exponent
      System.out.println("Enter coeffcient:");
      coefficient = Integer.parseInt(keyboard.nextLine()); // convert string to int
      System.out.println("Enter exponent:");
      exponent = Integer.parseInt(keyboard.nextLine()); // convert string to int
      p.addTerm(coefficient, exponent); // place exponent and coefficient in addTerm function
    }
    else if(choice == 4) // display the polynomial
      System.out.println(p);
    else // if choice isnt an option display error message
      System.out.println("Try Again!"); 
  }

}
