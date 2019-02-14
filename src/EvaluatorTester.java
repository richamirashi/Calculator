public class EvaluatorTester {
  public static void main(String[] args) {
    Evaluator evaluator = new Evaluator();
  //  args = new String[]{"3/(2-3)", "2+3", "2-1", "(2*3)^2"};
    for ( String arg : args ) {
      try {
          System.out.println("-----------");
          System.out.println("Processing expression = " + arg);
          System.out.format( "%s = %d\n", arg, evaluator.eval( arg ) );
          
      } catch (IllegalArgumentException e) {
          System.err.println("Given input expression is invalid. Given expression:  " + arg);
          System.err.println("Failure Msg = " + e.getMessage());
      }
    }
  }   
  
}