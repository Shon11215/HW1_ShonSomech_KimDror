import java.util.ArrayList;
import java.util.Date;

public abstract class Message {
    Date sendDate;
    String content, sender;

    // צריך להוסיף שדה נוסף לבחירתנו מתודה נוספת 
    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        if (content == null) {
            throw new IllegalArgumentException("The content must contain at least one character.");
        }
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        if (sender == null) {
            throw new IllegalArgumentException("The sender must contain at least one character.");
        }
        this.sender = sender;
    }

    public Message(Date senDate, String sender, String content) {
        setContent(content);
        setSendDate(senDate);
        setSender(sender);
    }

    public Message(String sender, String content) {
        setContent(content);
        setSender(sender);
    }

    public abstract String GeneratePreview();
    

    Boolean Find(ArrayList<String> wordList) {
        for (String word : wordList) {
            if (content.contains(word)) {
                return true;    
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Message {" + "sendDate=" + sendDate + ", sender='" + sender + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
