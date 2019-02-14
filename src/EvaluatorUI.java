import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvaluatorUI extends JFrame implements ActionListener {
  
    private TextField txField = new TextField();
    private Panel buttonPanel = new Panel();
    private String expression = "";
 
    private static final String[] bText = {
    "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3",
    "*", "0", "^", "=", "/", "(", ")", "C", "CE"
    };
    
    private Button[] buttons = new Button[ bText.length ];

    public static void main(String argv[]) {
        new EvaluatorUI();
    }

    //constructor of the EvaluatorUI class
    public EvaluatorUI() {
        setLayout( new BorderLayout() );

        add( txField, BorderLayout.NORTH );
        txField.setEditable( false );

        add( buttonPanel, BorderLayout.CENTER );
        buttonPanel.setLayout( new GridLayout( 5, 4 ));

        //create 20 buttons with corresponding text in bText[] array
        for ( int i = 0; i < 20; i++ ) {
            buttons[ i ] = new Button( bText[ i ]);
        }

        //add buttons to button panel
        for (int i=0; i<20; i++) {
            buttonPanel.add( buttons[ i ]);
        }

        //set up buttons to listen for mouse input
        for ( int i = 0; i < 20; i++ ) {
            buttons[ i ].addActionListener( this );
        }

        setTitle( "Calculator" );
        setSize( 400, 400 );
        setLocationByPlatform( true  );
        setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE );
        setVisible( true );
        txField.setText("0");
    }

    public void actionPerformed( ActionEvent arg0 ) {
        String buttonValue = arg0.getActionCommand();
        
        //check if the button pressed is between 0 to 9 numbers or any mathematical operator
        if('0' <= buttonValue.charAt(0) && buttonValue.charAt(0) <= '9' || buttonValue.equals("+") 
                || buttonValue.equals("-") || buttonValue.equals("*") 
                || buttonValue.equals("/")|| buttonValue.equals("^")
                || buttonValue.equals("(") || buttonValue.equals(")")){

            expression += buttonValue;
            txField.setText(expression);
            System.out.println("Expression: " + expression);
        }        
        else if(buttonValue.equals("=")){
            Evaluator evaluator = new Evaluator();
            int result = 0;
            try{
                //call eval method from Evaluator class to evaluate the expression
                result = evaluator.eval(expression);
            }catch(IllegalArgumentException e){
                System.err.println("Given input expression is invalid. Given expression:  " + expression);
                System.err.println("Failure Msg = " + e.getMessage());
            }
            String resultStr = Integer.toString(result);
            txField.setText(resultStr);
            expression = resultStr;
        }
        else if(buttonValue.equals("C")){
            txField.setText("0");
            expression = "0";
        }
        else if(buttonValue.equals("CE")){
            if(expression.isEmpty()){
                System.out.println("Expression is empty");
                txField.setText("0");
            } else {
                int length = expression.length();
                expression = expression.substring(0, length-1);
                txField.setText(expression);     
            }
       
        }
    }
        
}