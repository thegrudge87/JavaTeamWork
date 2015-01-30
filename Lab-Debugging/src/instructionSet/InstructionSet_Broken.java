// Edit the original package name from "InstructionSet" to "instructionSet"
// According the convention package name can not start with capital letter.
package instructionSet;

import java.util.Scanner;

public class InstructionSet_Broken {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String opCode = input.nextLine();
        
        while (!opCode.equals("END")) {
            String[] codeArgs = opCode.split(" ");
            long result = 0;
            
            switch (codeArgs[0]) {
                case "INC": {
                    int operandOne = Integer.parseInt(codeArgs[1]);
                    /* Original: result = operandOne++;
                     * We must cast the variable to type long, 
                     * because the result of the operation might be out of range.
                     * Also the postfix is used incorrectly here.
                     * The result won't be the incremented value of the variable.
                     * */
                    result = (long)operandOne+1;
                    break;
                }
                case "DEC": {
                    int operandOne = Integer.parseInt(codeArgs[1]);
                    /* Original: result = operandOne--;
                     * We must cast the variable to type long, 
                     * because the result of the operation might be out of range.
                     * Also the postfix is used incorrectly here.
                     * The result won't be the incremented value of the variable.
                     * */
                    result = (long)operandOne-1;
                    break;
                }
                case "ADD": {
                    int operandOne  = Integer.parseInt(codeArgs[1]);
                    int operandTwo = Integer.parseInt(codeArgs[2]);
                    /* Original: result = operandOne + operandTwo;
                     * We must cast the variables to type long, 
                     * because the result of the operation might be out of int range.
                     */
                    result = (long)operandOne + (long)operandTwo;
                    break;
                }
                case "MLA": {
                    int operandOne  = Integer.parseInt(codeArgs[1]);
                    int operandTwo = Integer.parseInt(codeArgs[2]);
                    /* Original: result = (long)(operandOne * operandTwo);
                     * For the same reasons we must cast the variables here too.
                     * Every variable must be casted separately,
                     * because in the original only the result is casted.  
                     * */
                    result = (long)operandOne * (long)operandTwo;
                    break;
                }
                default:
                    break;
            }
            // We must add the line bellow to make sure that after switch execution
            // the program will wait for next command.
            opCode = input.nextLine();
            System.out.println(result);
        }
    }
}
