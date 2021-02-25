import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorEngine implements ActionListener {
    Calculator parent; //a reference to Calculator window
    char selectedAction;//+, -, / , or *
    double currentResult=0;
    /*constructor stores the reference to the Calculator window in the
    member variable parent
     */
    CalculatorEngine(Calculator parent){
        this.parent=parent;
    }
    public void actionPerformed(ActionEvent e){
        //set the source of this action
        JButton clickedButton=(JButton) e.getSource();
        String displayFieldText=parent.displayField.getText();
        double displayValue=0;
        //get the number from the text field if it's not empty
        if(!"".equals(displayFieldText)){
            displayValue=Double.parseDouble(displayFieldText);
        }
        Object src=e.getSource();
        /*for each action button memorize selected action +, -, /,
        or *, store the current value in the currentResult, and
        clean up the display field for entering the next number
         */
        if (src==parent.buttonDelete){
            selectedAction='<';
            currentResult=displayValue;
            parent.displayField.setText("");

        }

        else if(src==parent.buttonPlus){
            selectedAction='+';
            currentResult=displayValue;
            parent.displayField.setText("");
        }
        else if (src==parent.buttonMinus){
            selectedAction='-';
            currentResult=displayValue;
            parent.displayField.setText("");
        }
        else if (src==parent.buttonDivide){
            selectedAction='/';
            currentResult=displayValue;
            parent.displayField.setText("");
        }
        else if (src==parent.buttonMultiply){
            selectedAction='*';
            currentResult=displayValue;
            parent.displayField.setText("");
        }
        else if (src==parent.buttonEqual) {
            /*perform the operations based on selectedAction, update
            the value of the variable currentResult and display the result
             */

            if(selectedAction=='+') {
                currentResult += displayValue;
                //convert the result to string by concatenating to an empty
                //string and display it
                parent.displayField.setText("" + currentResult);
            }
            else if (selectedAction=='-'){
                currentResult -= displayValue;
                parent.displayField.setText("" + currentResult);
            }
        else if (selectedAction=='/'){
                currentResult/=displayValue;
                parent.displayField.setText("" +currentResult);
            }
        else if(selectedAction=='*'){
                currentResult*=displayValue;
                parent.displayField.setText("" +currentResult);
            }
        }
        else {
            /*for all numeric buttons append the button's label to the
            text field
             */
            String clickedButtonLabel=clickedButton.getText();
            parent.displayField.setText(displayFieldText+clickedButtonLabel);
        }
    }
}
