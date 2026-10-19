import java.util.Random;

public class Message {
    private String messageID;
    private int numMessagesSent;
    private String recipient;
    private String messageText;
    private String messageHash;

    public Message(String recipient, String messageText, int numMessagesSent) {
        this.messageID = createMessageID();
        this.recipient = recipient;
        this.messageText = messageText;
        this.numMessagesSent = numMessagesSent;
        this.messageHash = createMessageHash();
    }

    public String createMessageID() {
        Random rand = new Random();
        long id = 1000000000L + (long)(rand.nextDouble() * 9000000000L);
        return String.valueOf(id);
    }

    public String checkRecipientCell() {
        if (recipient.length() <= 13 && recipient.startsWith("+")) {
            return "Cell phone number successfully captured.";
        } else {
            return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
        }
    }

    public String checkMessageLength() {
        if (messageText.length() <= 250) {
            return "Message ready to send.";
        } else {
            int excess = messageText.length() - 250;
            return "Message exceeds 250 characters by " + excess + ", please reduce the size.";
        }
    }

    public String createMessageHash() {
        String[] words = messageText.trim().split("\\s+");
        String firstWord = words[0].replaceAll("[^a-zA-Z0-9]", "");
        String lastWord = words[words.length - 1].replaceAll("[^a-zA-Z0-9]", "");
        return messageID.substring(0, 2) + ":" + numMessagesSent + ":" + firstWord.toUpperCase() + lastWord.toUpperCase();
    }

    public String sentMessage(int choice) {
        if (choice == 1) return "Message successfully sent.";
        if (choice == 2) return "Press 0 to delete the message.";
        if (choice == 3) return "Message successfully stored.";
        return "Invalid option.";
    }

    public String getMessageID() { return messageID; }
    public String getMessageHash() { return messageHash; }
    public String getRecipient() { return recipient; }
    public String getMessageText() { return messageText; }
}
