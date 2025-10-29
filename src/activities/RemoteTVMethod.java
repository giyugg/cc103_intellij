package activities;
import java.util.Scanner;

public class RemoteTVMethod {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int volume = 5;  // default volume
        int channel = 2; // default channel
        String choice;

        System.out.println("POWER ON");
        System.out.println("--------------------");

        display(channel, volume);

        do {
            menu();
            choice = inputChoice(input);

            switch (choice) {
                case "+":
                    channel = channelUp(channel);
                    break;
                case "-":
                    channel = channelDown(channel);
                    break;
                case "++":
                    volume = volumeUp(volume);
                    break;
                case "--":
                    volume = volumeDown(volume);
                    break;
                case "o":
                    System.out.println("POWER OFF");
                    break;
                default:
                    System.out.println("Invalid choice...");
                    break;
            }

            if (!choice.equals("o")) {
                display(channel, volume);
            }

        } while (!choice.equals("o"));

        input.close();
    }

    public static void menu() {
        System.out.println("Channel Up:   +");
        System.out.println("Channel Down: -");
        System.out.println("Volume Up:    ++");
        System.out.println("Volume Down:  --");
        System.out.println("Power Off:    o");
    }

    public static String inputChoice(Scanner x) {
        System.out.print("Choose: ");
        String choice = x.next();
        return choice;
    }

    public static int channelUp(int ch) {
        if (ch < 100) {
            ch++;
        } else {
            ch = 1;
        }
        return ch;
    }

    public static int channelDown(int ch) {
        if (ch > 1) {
            ch--;
        } else {
            ch = 100;
        }
        return ch;
    }

    public static int volumeUp(int vol) {
        if (vol < 20) {
            vol++;
        } else {
            System.out.println("Volume is at maximum!");
        }
        return vol;
    }

    public static int volumeDown(int vol) {
        if (vol > 0) {
            vol--;
        } else {
            System.out.println("Volume is at minimum!");
        }
        return vol;
    }

    public static void display(int ch, int vol) {
        System.out.println("--------------------");
        System.out.println("Channel: " + ch);
        System.out.println("Volume: " + vol);
        System.out.println("--------------------");
    }
}
