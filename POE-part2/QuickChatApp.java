import javax.swing.JOptionPane;
import java.util.ArrayList;

public class QuickChatApp {
    static ArrayList<Message> sentMessages = new ArrayList<>();
    static int totalMessagesSent = 0;

    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Welcome to QuickChat");

        int numMessages = Integer.parseInt(JOptionPane.showInputDialog("How many messages do you want to send?"));

        for(int i=0; i<numMessages; i++){
            String recipient = JOptionPane.showInputDialog("Enter recipient cell (+27...):");
            String text = JOptionPane.showInputDialog("Enter message (max 250 chars):");
            
            Message msg = new Message(recipient, text, totalMessagesSent);
            
            String recipientCheck = msg.checkRecipientCell();
            String lengthCheck = msg.checkMessageLength();
            
            JOptionPane.showMessageDialog(null, recipientCheck + "\n" + lengthCheck);

            if(recipientCheck.contains("successfully") && lengthCheck.contains("ready")){
                int choice = Integer.parseInt(JOptionPane.showInputDialog("1 - Send Message\n2 - Discard (Press 0 to delete)\n3 - Store Message"));
                String result = msg.sentMessage(choice);
                JOptionPane.showMessageDialog(null, result + "\nHash: " + msg.getMessageHash() + "\nID: " + msg.getMessageID());

                if(choice == 1){
                    sentMessages.add(msg);
                    totalMessagesSent++;
                }
            }
        }
        JOptionPane.showMessageDialog(null, "Total messages sent: " + totalMessagesSent);
    }
}