public class Term implements Comparable<Term>{
  
   private int exponent;
   private int coefficient;
  
  // define a class Term that contains the exponent and coefficient
  public Term( int coefficient,int exponent) {
    this.exponent = exponent;
    this.coefficient = coefficient;
   }
  
  
   @Override
   public int compareTo(Term term) {
       if(this.exponent < term.exponent){
           return 1;
       }else if(this.exponent > term.exponent){
           return -1;
       }else{
           return 0;
       }
   }
   @Override
   public String toString() {
       return coefficient + "x^" + exponent + "^";
   }
  
  // getters and setters
   public int getExponent() {
       return exponent;
   }


   public int getCoefficient() {
       return coefficient;
   }


   public void setExponent(int exponent) {
       this.exponent = exponent;
   }


   public void setCoefficient(int coefficient) {
       this.coefficient = coefficient;
   }

   @Override
   public boolean equals(Object obj) {
      Term t = (Term)obj;
      
      if(this.coefficient == t.coefficient && this.exponent == t.exponent){
        return true;
      }
      
      return false;
   }
  

}

