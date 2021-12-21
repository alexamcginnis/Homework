import java.util.Collections;
import java.util.LinkedList;

// Polynomial class
public class Polynomial{
  // LinkedList<Term> instance variable
  private LinkedList<Term> terms;

  public void clear(){
    terms.clear();
  }
  
  public Polynomial(){
       this.terms = new LinkedList<Term>(); 
  }
  public Polynomial(String polynomial){
    this();
    create(polynomial);
  }
  
  // create function
  public void create(String polynomial){
    int coefficient, exponent; // declare variables
    terms.clear(); // clear any terms before
    String[] polyTerms = null; // create a string of polymonial terms

    if(polynomial != null)
      polyTerms = polynomial.split("\\+");
    if(polyTerms != null){
      for(String poly: polyTerms){
        poly = poly.trim();
        // if polynomial = x, coefficient and exponent = 1
        if(poly.equals("x")){
          coefficient = 1;
          exponent = 1;
        }
        // if the polynomial has an x
        else if(poly.contains("x")){
          String[] data = poly.split("x");
          coefficient = Integer.parseInt(data[0]);
                   
          if(data.length == 1) 
            exponent = 1;
          else{
            String expData = data[1];
            String[] expDataArr = expData.split("\\^");
            exponent = Integer.parseInt(expDataArr[1]);
          }
        }
        else{
          coefficient = Integer.parseInt(poly); 
          exponent = 0;
        }
        // add the terms using the cofficient and exponents
        addTerm(coefficient, exponent);
      }
    }
  }
  
  public void addTerm(Term term){
    this.terms.add(term);
  }

  public void addTerm(int coefficient,int exponent){
    int newCoefficient;
    if(coefficient != 0){
      if(!terms.isEmpty()){
        for(int i = 0; i < terms.size(); i++){
          Term term = terms.get(i);
          if(term.getExponent() == exponent){
            newCoefficient = term.getCoefficient() + coefficient;
            terms.get(i).setCoefficient(newCoefficient);
            break;
          }
        }
        // add the new terms
        terms.add(new Term(coefficient,exponent));
      }
    }
  }
  // adding the polynomial together
  public Polynomial addPolynomial(Polynomial p){
    Polynomial poly = new Polynomial();
    LinkedList<Term> terms1 = this.terms;
    LinkedList<Term> terms2 = p.terms;
    int coefficient = 0;
       boolean isAdded = false;
       LinkedList<Term> termsUsed = new LinkedList<Term>();
       for(Term t1: terms1){
           isAdded = false;
            for(Term t2: terms2){
                if(t2.getExponent() == t1.getExponent()){
                  coefficient = t1.getCoefficient() + t2.getCoefficient();
                  termsUsed.add(t2);
                  isAdded = true;
                  break;
               }
            }
          
            if(isAdded){
               if(coefficient != 0)
                  poly.addTerm(new Term(coefficient, t1.getExponent()));
            }else{
               poly.addTerm(t1);
           }
          
       }
      
       for(Term t2: terms2){
           if(!termsUsed.contains(t2)){
              poly.addTerm(t2);
           }
       }
      
      
       return poly;  
      
   }

  @Override
  public String toString() {
    int counter = 0;
    String currentTermStr = "";
    StringBuilder sb = new StringBuilder();      
    if(!terms.isEmpty()){
      Collections.sort(terms);
      for(Term term: terms){
        counter++;
        int coefficient = term.getCoefficient();
        int exp = term.getExponent();
        if(coefficient > 0){
          if(counter > 1)
            currentTermStr = currentTermStr + "+";
            if(coefficient > 1)
              currentTermStr = currentTermStr + coefficient;
        }
        else if(coefficient < -1)
          currentTermStr = currentTermStr + coefficient;
        if(exp > 0){
          currentTermStr = currentTermStr + "x";
          if(exp > 1)
            currentTermStr = currentTermStr + "^" + exp + "^";
        }
              
        sb.append(currentTermStr);
      }
    }
      
  return sb.toString();
  }
  
  
}
