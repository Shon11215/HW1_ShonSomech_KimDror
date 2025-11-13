import java.util.Date;

public class BoardMessage extends Message {
    PriorityType priority;

    public void setPriority(PriorityType priority) {
        this.priority = priority;
    }

    public BoardMessage(Date senDate, String sender, String content, PriorityType priority) {
        super(senDate, sender, content);
        setPriority(priority);
    }

    public BoardMessage(String sender, String content) {
        super(sender, content);
        setPriority(PriorityType.REGULAR);
    }

    @Override
    public String GeneratePreview(){
         if (content.length() <= 15) {
            return sender + " " + content;
         }
            return sender + " " + content.substring(0,15);
    }

    @Override
    public String toString() {
        return super.toString() + ", priority=" + priority;
    }

}
