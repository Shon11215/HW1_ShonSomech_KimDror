import java.util.ArrayList;
import java.util.Date;

public abstract class Message {
    Date sendDate;
    String content, sender,major;


    public void setMajor(String major){
        this.major=major;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public void setContent(String content) {
        if (content == null || content.equals("")) {
            throw new IllegalArgumentException("The content must contain at least one character.");
        }
        this.content = content;
    }

    public void setSender(String sender) {
        if (sender == null || sender.equals("")) {
            throw new IllegalArgumentException("The sender must contain at least one character.");
        }
        this.sender = sender;
    }

    public Message(Date senDate, String sender, String content,String major) {
        setContent(content);
        setSendDate(senDate);
        setSender(sender);
        setMajor(major);
    }

    public Message(String sender, String content) {
        setContent(content);
        setSender(sender);
    }

    public abstract String GeneratePreview();
    

    //our function
    public int GetContentLength(){
        return content.length();
    }

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
                ", content='" + content + '\'' + ", major='" + major + '\'' +
                '}';
    }
}
