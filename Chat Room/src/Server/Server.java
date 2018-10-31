package Server;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Server {

    //The port the server is listening on
    private static final int PORT = 9001;

    //Stores the username and passwords
    private static Hashtable<String, String> usernames = new Hashtable<>();

    //Set of PrintWrites so messages can be sent to all clients
    private static HashSet<PrintWriter> writers = new HashSet<>();

    /**
     * Imports the hash table from the file so username and passwords aren't erased.
     */
    public static void buildHashTableFromFile() {
        WriteToText logins = new WriteToText();
        logins.readLoginInfo();

        // add logins to local Arraylist
        for (String sentence : logins.logins) {
            int userLength = sentence.indexOf("*");
            String user = sentence.substring(0, userLength);
            String pass = sentence.substring(userLength + 1);

            addLogin(user, pass);
        }
    }

    /**
     * Writes any changes to the hash table into the file.
     */
    public static void writeHashTableToFile(){
        StringBuilder sb = new StringBuilder();
        WriteToText logins = new WriteToText();
        for(Map.Entry<String,String > entry : usernames.entrySet() )
        {
            String user = entry.getKey();
            String pass = entry.getValue();
            logins.writeToFile(user,pass);
        }
    }

    /**
     * Adds a user to the hash table.
     */
    public static synchronized boolean addLogin(String username, String pass) {
        if (!userExist(username)) {
            usernames.put(username, pass);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks if a username exists aleady.
     */
    public static boolean userExist(String userName) {
        return usernames.containsKey(userName);
    }
    /**
     * Responsible for a dealing with a single client
     * and broadcasting its messages.
     */
    private static class Handler extends Thread {
        private String name;
        private String password;
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        /**
         * Constructor
         */
        public Handler(Socket socket) {
            this.socket = socket;
        }

        /**
         * Initializes the input and output streams.
         * Prompts the Client for information the processes it accordingly.
         */
        public void run() {
            try {

                // Create character streams for the socket.
                in = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                // Request a name from this client.  Keep requesting until
                // a name is submitted that is not already used.  Note that
                // checking for the existence of a name and adding the name
                // must be done while locking the set of names.
                while (true) {
                    out.println("SUBMITNAME");
                    name = in.readLine();

                    //Prompts again if nothing is entered.
                    if (name == null) {
                        return;
                    }

                    //Checks if the username exists
                    if (userExist(name)) {
                        out.println("EXISTS");
                        password = in.readLine();

                        //Checks if the password matches
                        if (!usernames.get(name).equals(password)) {
                            out.println("BADPASS");
                        } else {
                            break;
                        }
                    }

                    //Creates a new user if name doesn't exist already
                    else {
                        out.println("SUBMITPASS");
                        password = in.readLine();

                        //Prompts again if nothing is entered.
                        if (password == null) {
                            return;
                        }

                        else {
                            //Adds the new user to the hash table and writes it to the file.
                            synchronized (usernames)
                            {
                                usernames.put(name, password);
                                writeHashTableToFile();
                                break;
                            }
                        }
                    }
                }
                out.println("NAMEACCEPTED");

                //Adds this users socket to the PrintWriter set so it can receive messages.
                writers.add(out);

                // Accept messages from this client and broadcast them.
                while (true) {
                    String input = in.readLine();
                    if (input == null) {
                        return;
                    }
                    for (PrintWriter writer : writers) {
                        writer.println("MESSAGE " + name + ": " + input);
                    }
                }
            } catch (IOException e) {
                System.out.println(e);
            } finally {
                //Removes the PrintWriter from the set and closes its socket.
                if (out != null) {
                    writers.remove(out);
                }
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println("The chat server is running.");
        ServerSocket listener = new ServerSocket(PORT);
        buildHashTableFromFile();
        try {
            while (true) {
                new Handler(listener.accept()).start();
            }
        } finally {
            listener.close();
        }
    }
}
