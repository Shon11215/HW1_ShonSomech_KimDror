import java.util.Date;

public class BoardMessage extends Message {
    PriorityType priority;
    String location;

    public void setLocation(String location) {
        this.location = location;
    }

    public void setPriority(PriorityType priority) {
        this.priority = priority;
    }

    public BoardMessage(Date senDate, String sender, String content, PriorityType priority, String major, String location) {
        super(senDate, sender, content, major);
        setPriority(priority);
        setLocation(location);
    }

    public BoardMessage(String sender, String content, String location) {
        super(sender, content);
        setPriority(PriorityType.REGULAR);
        setLocation(location);
    }

    @Override
    public String GeneratePreview() {
        if (GetContentLength() <= 15) {
            return sender + " " + content;
        }
        return sender + " " + content.substring(0, 15);
    }

    //our function
    public boolean isUrgent() {
        return priority == PriorityType.SUPER_URGENT || priority == PriorityType.URGENT;
    }

    @Override
    public String toString() {
        return super.toString() + ", priority=" + priority + ", Location="+ location;
    }

}
