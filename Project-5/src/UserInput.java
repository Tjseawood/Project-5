import java.util.ArrayList;
import java.util.Scanner;

    public class UserInput {
        private ArrayList<String> args;             // Where to store user's input (collection of string tokens)
        private Scanner userinput;                  // To see if there was any data was input

        /*
         Basic Constructor
         */
        UserInput() {
            userinput = new Scanner(System.in);
            args = new ArrayList<String>();
        }

        /*
         clear the list of user input tokens
         */
        public void clear() {
            args = new ArrayList<String>();
        }

        /*
         Get the first token on the line ("zeroth" token)
         */
        public String getCommand() {
            return args.get(0);
        }

        /*
         How many tokens did the user input
         */
        public int numargs() {
            return args.size();
        }

        /*
         Primary method that gets a line from the user and puts each token into an arraylist
         */
        public ArrayList<String> getArgs() {
            if (userinput.hasNextLine()) {                  // If the user typed something... even just a <CR>
                String cmd = userinput.nextLine();

                if (cmd.isEmpty() == false) {             // If the user typed some words.

                    // parsing what the user input
                    Scanner tokens = new Scanner(cmd);              // break up the line into words
                    while (tokens.hasNext()) {             // While there are words in the input, print them
                        args.add(tokens.next());
                    }
                }
            }
            return args;
        }

        /*
         Simple utility program to display all the args
         */
        public void displayArgs() {
            for (int i = 0; i < numargs(); i++ ) {
                System.out.println("Arg: " + i + "  = [" + args.get(i) + "]");
            }
        }

        public static void main(String[] argv) {
            UserInput ui = new UserInput();
            ArrayList<String> userArgs;

            while (true) {
                System.out.print("Command> ");
                userArgs = ui.getArgs();
                // show prompt to user

                switch (ui.getCommand().toLowerCase()) {
                    case "zipcode":
                        Zipcode z = new Zipcode(userArgs.get(1));
                        z.connect();
                        String resp = z.get();
                        System.out.println(resp);
                        break;
                    case "itunes":
                        System.out.println("Itunes!");
                        Itunes i = new Itunes(userArgs.get(1));
                        i.connect();
                        String iresp = i.get();
                        System.out.println((iresp));
                        break;
                    case "tv":
                        System.out.println("TV");
                        TV tele = new TV(userArgs.get(1));
                        tele.connect();
                        String tresp = tele.get();
                        System.out.println(tresp);
                    case "quit":
                        System.out.println("Thank you for using my program!");

                    default: System.out.println("Huh??? You can only use itunes or zipcode");
                }
                ui.clear();
            }
        }
    }
