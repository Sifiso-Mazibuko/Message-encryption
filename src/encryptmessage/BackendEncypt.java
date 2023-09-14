
package encryptmessage;

public class BackendEncypt {
    
    private String message;
    
    public BackendEncypt(String message){
        
        this.message = message;
    }
    
    public void setMessage(String message){
    
        this.message = message;
    }
    
    public String getMessage(){
    
        return message;
    }
    
    public String toString(){
    
        String take = message.substring(0,message.indexOf(','));
        
        String textToUser = "Hello " + take + " Thank you for sending us a message!";
        
        return textToUser;
    }
}
