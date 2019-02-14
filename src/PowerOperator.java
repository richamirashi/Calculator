public class PowerOperator extends Operator{
    public int priority(){
        priority = 4;
        return priority;
    }
    
    public Operand execute( Operand op1, Operand op2 ){
        double power;
        power = Math.pow(op1.getValue(), op2.getValue());
        Operand powerResult = new Operand(power);
        return powerResult;
    }
    
}
