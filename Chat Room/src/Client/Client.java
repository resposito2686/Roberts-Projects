package Client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.*;

/* Programmed By : Matthew Nguyen, Oscar Lugo, Robert Esposito, Rachel Cleary, and Michael Chi
   Date          : 05/15/17
   Class         : CS 113, Monday @ 5:30PM
   Assignment    : Final Project

   Description: This is a chat room program. Users can create accounts which are stored
   into a Hash Table. Then can then log in to their accounts to chat. Utilizes Sockets
   to connect the Client to the Server. Utilizes Swing and AWT for GUI elements.

 */
public class Client {

    BufferedReader in;
    PrintWriter out;
    JFrame frame = new JFrame("A/S/L Chat");
    JTextField textField = new JTextField(40);
    JTextArea messageArea = new JTextArea(8, 40);

    /**
     * Constructor: Builds the GUI elements and the action listener
     */
    public Client() {

        // Layout GUI
        textField.setEditable(false);
        messageArea.setEditable(false);
        frame.getContentPane().add(textField, "North");
        frame.getContentPane().add(new JScrollPane(messageArea), "Center");
        frame.pack();

        // Add Listener
        textField.addActionListener(new ActionListener() {
            /**
             * Sends the contents of the text field to the server, then clears
             * the textfield.
             */
            public void actionPerformed(ActionEvent e) {
                out.println(textField.getText());
                textField.setText("");
            }
        });
    }

    /**
     * Server Address box
     * returns the address entered in the dialog box.
     */
    private String getServerAddress() {
        return JOptionPane.showInputDialog(
                frame,
                "Enter IP Address of the Server:",
                "Server Address",
                JOptionPane.QUESTION_MESSAGE);
    }

    /**
     * Username box
     * returns the username entered in the dialog box.
     */
    private String getName() {
        return JOptionPane.showInputDialog(
                frame,
                "Enter your screen name:",
                "Screen Name",
                JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * New password box. Used when the username doesn't exist already.
     * returns the password entered into the dialog box.
     */
    private String newPassword(){
        return JOptionPane.showInputDialog(frame,
                "Choose a password:",
                "Password",
                JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * Password box. Used when the username already exists.
     * returns the password entered into the dialog box.
     */
    private String getPassword(){
        return JOptionPane.showInputDialog(frame,
                "Enter your password:",
                "Password",
                JOptionPane.PLAIN_MESSAGE);
    }

    /** Message box when incorrect password is entered. */
    private void badPassword(){
        JOptionPane.showMessageDialog(frame, "Invalid password.");
    }
    /** Message box when a new user is being created. */
    private void newUser(){
        JOptionPane.showMessageDialog(frame, "Click OK to create a new account.");
    }
    /**
     * Connects to the server, sets up the input and output streams.
     * Then waits for server response and takes the appropriate action.
     */
    private void run() throws IOException {

        // Make connection and initialize streams
        String serverAddress = getServerAddress();
        Socket socket = new Socket(serverAddress, 9001);
        in = new BufferedReader(new InputStreamReader(
                socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);

        // Process messages from server.
        while (true) {
            String line = in.readLine();
            if (line.startsWith("SUBMITNAME"))
            {
                out.println(getName());
            }
            else if (line.startsWith("EXISTS"))
            {
                out.println(getPassword());
            }
            else if (line.startsWith("SUBMITPASS"))
            {
                newUser();
                out.println(newPassword());
            }
            else if (line.startsWith("NAMEACCEPTED"))
            {
                textField.setEditable(true);
            }
            else if (line.startsWith("MESSAGE"))
            {
                messageArea.append(line.substring(8) + "\n");
            }
            else if (line.startsWith("BADPASS"))
            {
                badPassword();
            }
        }
    }

    /**
     * Runs the client
     */
    public static void main(String[] args) throws Exception {
        Client client = new Client();
        client.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        client.frame.setVisible(true);
        client.run();
    }
}