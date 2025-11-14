import java.util.ArrayList;
import java.util.Date;

public class EmailMessage extends Message implements IDigital {
    String subject;
    ArrayList<File> fileList;

    public void setSubject(String subject) {
        if (subject == null) {
            throw new IllegalArgumentException("The subject must contain at least one character.");
        }
        this.subject = subject;
    }

    public EmailMessage(Date senDate, String sender, String content, String major,String subject) {
        super(senDate, sender, content,major);
        fileList = new ArrayList<>();
        setSubject(subject);
    }

    public EmailMessage(String sender, String content, String subject) {
        super(sender, content);
        fileList = new ArrayList<>(); 
        setSubject(subject);
    }

    public void addAttachment(File file) {
        fileList.add(file);
    }

    public void removeAttachment(File file) throws AttachmentException{
        boolean found = false;
        for (int i = 0; i < fileList.size(); i++) {
            if (fileList.get(i).compareTo(file) == 0) {
                fileList.remove(i);
                i--;
                found = true;
            }
        }
        if (!found){
            throw new AttachmentException("file not found: "+ file.toString());
        }
    }

    @Override
    public String printCommunicationMethod() {
        return "Sent via Email Server";
    }

    @Override
    public String GeneratePreview() {
        if (GetContentLength() <= 15) {
            return "Subject: " + subject + "From:[Email] " + sender + " " + content; // לחזור לבדוק האם ככה
        }
        return "Subject: " + subject + "From:[Email] " + sender + " " + content.substring(0, 15);
    }

    @Override
    public String toString() {
        return super.toString() + ", subject='" + subject + "'";
    }

    public void ShowFiles(){
        for(File file : fileList){
            System.out.println(file.fileName + " "+ file.fileType);
        }
    }

}
