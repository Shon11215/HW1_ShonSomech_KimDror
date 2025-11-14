import java.util.Date;

public class PhoneMessage extends Message implements IDigital {
    String phoneNumber;

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() < 9) {
            throw new IllegalArgumentException("The phone number must be 10 characters");

        }
        this.phoneNumber = phoneNumber;
    }

    public PhoneMessage(Date senDate, String sender, String content, String major, String phoneNumber) {
        super(senDate, sender, content, major);
        setPhoneNumber(phoneNumber);

    }

    public PhoneMessage(String sender, String content, String phoneNumber) {
        super(sender, content);
        setPhoneNumber(phoneNumber);
    }

    public String printCommunicationMethod() {
        return "Sent via Phone Server";

    }

    @Override
    public String GeneratePreview() {
        if (GetContentLength() <= 15) {
            return "Subject: " + phoneNumber + "From: " + sender + " " + content;
        }
        return "Subject: " + phoneNumber + "From: " + sender + " " + content.substring(0, 15);
    }

    @Override
    public String toString() {
        return super.toString() + ", subject='" + phoneNumber + "'";
    }
}
