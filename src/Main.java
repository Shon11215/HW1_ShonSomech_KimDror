import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        ArrayList<Message> messages = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice = 100;
        while (choice != 0) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add message");
            System.out.println("2. Remove message");
            System.out.println("3. Print all messages");
            System.out.println("4. Count messages that contain specific words");
            System.out.println("5. Print only digital messages");
            System.out.println("6. Show messages from a specific sender");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println(
                            "Please choose the message type that you want:\n1:Phone Message\n2:Board Message\n3:Email Message\n");
                    int msgChoice = sc.nextInt();
                    sc.nextLine();
                    switch (msgChoice) {
                        case 1:
                            System.out.print("Enter sender name: ");
                            String phoneSender = sc.nextLine();

                            System.out.print("Enter message content: ");
                            String phoneContent = sc.nextLine();

                            System.out.print("Enter phone number: ");
                            String phoneNumber = sc.nextLine();
                            try {
                                PhoneMessage phoneMsg = new PhoneMessage(phoneSender, phoneContent, phoneNumber);
                                messages.add(phoneMsg);

                            } catch (IllegalArgumentException e) {
                                System.out.println(e);
                            }
                            break;
                        case 2:
                            System.out.print("Enter location name: ");
                            String location = sc.nextLine();

                            System.out.print("Enter sender name: ");
                            String boardSender = sc.nextLine();

                            System.out.print("Enter message content: ");
                            String boardContent = sc.nextLine();

                            System.out.println("Choose priority: 1-Regular, 2-Urgent, 3-SuperUrgent");
                            int p = sc.nextInt();
                            sc.nextLine();

                            PriorityType priority;
                            switch (p) {
                                case 1:
                                    priority = PriorityType.REGULAR;
                                    break;
                                case 2:
                                    priority = PriorityType.URGENT;
                                    break;
                                default:
                                    priority = PriorityType.SUPER_URGENT;
                                    break;
                            }

                            System.out.print("Enter Major if you have 1: ");
                            String major = sc.nextLine();
                            try {
                                BoardMessage boardMsg = new BoardMessage(new Date(), boardSender, boardContent,
                                        priority, major, location);
                                messages.add(boardMsg);
                            } catch (IllegalArgumentException e) {
                                System.out.println(e);
                            }

                            break;
                        case 3:
                            System.out.print("Enter sender name: ");
                            String emailSender = sc.nextLine();

                            System.out.print("Enter message content: ");
                            String emailContent = sc.nextLine();

                            System.out.print("Enter email subject: ");
                            String subject = sc.nextLine();
                            try {
                                EmailMessage emailMsg = new EmailMessage(emailSender, emailContent, subject);

                                int fileChoice = 0;
                                while (fileChoice != 3) {
                                    System.out.println("Your file list: ");
                                    emailMsg.ShowFiles();

                                    System.out
                                            .println("\n1: to add file\n2: to remove file\n3:to finish handling files");

                                    fileChoice = sc.nextInt();
                                    sc.nextLine();
                                    String fileName;
                                    String fileType;
                                    File file;

                                    switch (fileChoice) {
                                        case 1:
                                            System.out.print("Enter file name: ");
                                            fileName = sc.nextLine();

                                            System.out.print("Enter file type: ");
                                            fileType = sc.nextLine();
                                            file = new File(fileType, fileName);
                                            emailMsg.addAttachment(file);
                                            break;
                                        case 2:
                                            emailMsg.ShowFiles();
                                            System.out.print("Enter file name: ");
                                            fileName = sc.nextLine();

                                            System.out.print("Enter file type: ");
                                            fileType = sc.nextLine();
                                            file = new File(fileType, fileName);

                                            try {
                                                emailMsg.removeAttachment(file);

                                            } catch (AttachmentException e) {
                                                System.out.println(e);
                                            }

                                            break;

                                        default:
                                            fileChoice = 3;
                                            break;
                                    }

                                }
                                messages.add(emailMsg);

                            } catch (IllegalArgumentException e) {
                                System.out.println(e);
                            }

                            break;

                        default:
                            System.out.println("Please choose a valid input..");
                            break;
                    }

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
                    } else {
                        System.out.println("Invalid number.");
                    }
                    break;
                case 3:
                    if (messages.isEmpty()) {
                        System.out.println("There are no messages.");
                    } else {
                        System.out.println("\n--- ALL MESSAGES ---");
                        for (int i = 0; i < messages.size(); i++) {
                            System.out.println(i + ": " + messages.get(i));
                        }
                    }
                    break;
                case 4:
                    System.out.println("Enter the word to search seperated by spaces:");
                    String word = sc.nextLine();
                    ArrayList<String> wordList = new ArrayList<>(Arrays.asList(word.split(" ")));
                    int counter = 0;
                    for (Message msg : messages) {
                        if (msg.Find(wordList)) {
                            counter++;
                        }
                    }
                    System.out
                            .println("The amounts of messages that contain the words: " + word + "\nCount: " + counter);
                    break;
                case 5:
                    if (messages.isEmpty()) {
                        System.out.println("There are no messages.");
                    } else {
                        System.out.println("\n--- DIGITAL MESSAGES ---");
                        for (Message msg : messages) {
                            if (msg instanceof EmailMessage || msg instanceof PhoneMessage) {
                                System.out.println(msg);
                            }
                        }
                    }
                    break;
                case 6:
                    System.out.println("Enter the sender name out of this list:");
                    ArrayList<String> senderNames = new ArrayList<>();
                    for (Message msg : messages) {
                        if (!senderNames.contains(msg.sender)) {
                            senderNames.add(msg.sender);
                            System.out.println(msg.sender);
                        }
                    }
                    String name = sc.nextLine();
                    for (Message msg : messages) {
                        if (msg.sender.equals(name)) {
                            System.out.println(msg.toString());
                        }
                    }
                    break;

                default:
                    break;
            }

        }
        sc.close();

    }
}
