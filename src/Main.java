//import java.lang.classfile.instruction.SwitchCase;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Message> messages = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add message");
            System.out.println("2. Remove message");
            System.out.println("3. Print all messages");
            System.out.println("4. Count messages that contain specific words");
            System.out.println("5. Print only digital messages");
            System.out.println("6. ");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    //System.out.println("Enter the content of the message:");
                   // String content = sc.nextLine();
                    
                    break;
                case 2:
                    if (messages.isEmpty()) {
                    System.out.println("There are no messages to delete.");
                    break;
                    }

                    System.out.println("Choose a message to delete:");
                    for (int i = 0; i < messages.size(); i++) {
                    System.out.println((i + 1) + ": " + messages.get(i).GeneratePreview());
                    }

                    System.out.print("Enter number to delete: ");
                    int numToDelete = sc.nextInt();
                    sc.nextLine(); 
                    int index = numToDelete - 1;

                    if (index >= 0 && index < messages.size()) {
                    messages.remove(index);
                    System.out.println("Message deleted.");
                    } 
                    else {
                    System.out.println("Invalid number.");
                    }
                    break;
                case 3:
                    if (messages.isEmpty()) {
                        System.out.println("There are no messages.");
                    } 
                    else {
                        System.out.println("\n--- ALL MESSAGES ---");
                        for (int i = 0; i < messages.size(); i++) {
                            System.out.println(i + ": " + messages.get(i));
                        }
                    }
                    break;
                case 4:
                    System.out.println("Enter the word to search seperated by spaces:");
                    String word = sc.nextLine();
                    ArrayList <String> wordList = new ArrayList<>(Arrays.asList(word.split(" ")));
                    int counter = 0;
                    for (Message msg : messages){
                        if (msg.Find(wordList)) {
                            counter++;
                        }
                    }
                    System.out.println("The amounts of messages that contain the words: "+ word+"\nCount: "+counter);
                   break;
                case 5:
                    if (messages.isEmpty()) {
                        System.out.println("There are no messages.");
                    } 
                    else {
                        System.out.println("\n--- DIGITAL MESSAGES ---");
                    for (Message msg : messages){
                           if (msg instanceof EmailMessage) {
                            System.out.println(msg);
                           }
                        }
                    }
                    break;
                case 6:
                    System.out.println("Enter the sender name out of this list:");
                    ArrayList <String> senderNames = new ArrayList<>();
                    for (Message msg : messages){
                        if (!senderNames.contains(msg.sender)) {
                            senderNames.add(msg.sender);
                            System.out.println(msg.sender);
                        }
                    }
                    String name = sc.nextLine();
                    for (Message msg : messages){
                        if (msg.sender.equals(name)) {
                            System.out.println(msg.toString());
                        }
                    }
                    break;
            
                default:
                    break;
            }
            

        }
}

/*
 * צריך להוסיף
 * מיין
 * לסיים את האימייל ולהוסיף שם את מחלקת שגיאה ולשנות ולהוסיף את REMOVE
 * לעבור על ההערות שהשארנו בקוד
 * 
 * 
 * 
 */