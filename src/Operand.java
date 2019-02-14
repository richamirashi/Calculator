public class Operand {

    public double value;
    
    public Operand( String token ) {
        if(!check(token)) {
          throw new IllegalArgumentException("Invalid operand " + token);
    }
      
        //convert a string to integer
        this.value  = Integer.parseInt(token);
    }

    public Operand( double value ) {
        this.value = value;
    }

    public double getValue() {
        return this.value;
    }

    public static boolean check( String token ) {
        if (token.matches("[0-9]+")){
          return true;
        }
        return false;
    }
  
}