
package encryptmessage;

/**
 *
 * @author sifiso
 */
import javax.swing.*;
public class EncryptMessage {

   
    public static void main(String[] args) {
        
        int decide = JOptionPane.showConfirmDialog(null, "Do you want to Encrypt a message");
    
        encrypt(decide);
    }
    
    public static void encrypt(int decide){
        
        String message;

        //I love programming; 
        
        if(decide == 0){
            
            message = JOptionPane.showInputDialog(null, "Enter Message that you want to encrypt: ").trim();
            
            int arraySize = message.length();
            
            int [] takeCharAsInt = new int[arraySize];
            
            char[] finalE = new char[arraySize];
            
            for(int x = 0; x < message.length(); x++){
                
                char theChar = message.charAt(x);
                
                if(Character.isLetter(theChar)){
                    
                    int takeChar = theChar;
                
                    takeCharAsInt[x] += takeChar + 3;
                }   
            }
            
            fillingInEncrypt(takeCharAsInt, finalE);
            
            boolean nextStep = displayEncypted(finalE);
            
            if(nextStep){
                
                boolean Allowed = allowToNextStep(finalE);
                
                while(Allowed == false){
                    
                    JOptionPane.showMessageDialog(null, "Password doesn't match with the System Generated Password", "Error", JOptionPane.ERROR_MESSAGE);
                    Allowed = allowToNextStep(finalE);
                }
                
                sendAmessage();
            }
        }
    }
    
    public static void fillingInEncrypt(int[] takeCharAsInt, char[] finalE){
        
        for(int i = 0 ; i < takeCharAsInt.length; i++){
                
                int theNumeric = takeCharAsInt[i];
                
                char takeNum = (char)theNumeric;
                
                finalE[i] += takeNum;
        }
        
    }
    
    
    public static boolean displayEncypted(char[] finalE){
        
        String saveAll = "";
        
        for(int x = 0; x < finalE.length; x++){
            
            saveAll += finalE[x] + " ";
        }
        
        JOptionPane.showMessageDialog(null, "Your encryption code is: " +saveAll + "Please do save it now!", "Encrypted", JOptionPane.INFORMATION_MESSAGE);
        
        
        return true;
    }
 
    public static boolean allowToNextStep(char[] finalE){
        
        boolean isFound = false;
        
        String find = JOptionPane.showInputDialog(null, "Enter your password that was provided to you(System generated password): ").trim();
    
        String converCharToString = "";
        
        for(int x = 0; x < finalE.length; x++){
            
            converCharToString += finalE[x];
        }
        
        if(find.equalsIgnoreCase(converCharToString)){
           
            isFound = true;
        }
       
        return isFound;
    }
    
    public static void sendAmessage(){
        
        String sendAtext = JOptionPane.showInputDialog(null, "Send a message to the database and wait for respond(Start with your name, and speak(Sifiso, ..))");
    
        BackendEncypt obj = new BackendEncypt(sendAtext);
        
        JOptionPane.showMessageDialog(null, obj.toString(), "Response", JOptionPane.INFORMATION_MESSAGE);
    }
}
