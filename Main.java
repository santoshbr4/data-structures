import java.util.Scanner;

public class Main {

    public static void main(String [] arr) {
        Trie trie = new Trie();
        Scanner sc = new Scanner(System.in);

        boolean carryon = true;
        int command = 0;
        int count = 0;
        String text = null;

        while (carryon) {
            System.out.println("Enter command ");
            command = sc.nextInt();
            switch (command) {
                case 1: //Insert
                {
                    System.out.println("Enter string to insert");
                    text = sc.next();
                    trie.insert(text);
                    break;
                }
                case 2:
                {
                    System.out.println("Enter string to search");
                    text = sc.next();
                    count = trie.getWordCount(text);
                    System.out.println(count);
                    break;
                }
                case 3:
                    carryon = false;
                    break;
                default:
                    break;
            }
        }
    }
}
