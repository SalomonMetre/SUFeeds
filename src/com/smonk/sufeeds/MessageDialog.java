package com.smonk.sufeeds;

import javax.swing.JOptionPane;

public class MessageDialog {

    // Static method to display a message in a JOptionPane
    public static void showMessage(String text, String title) {
        // Show message dialog with the provided text and title
        JOptionPane.showMessageDialog(null, text, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        // Example usage:
        String message = "Hello, welcome to the system!";
        String title = "Welcome Message";
        
        // Display the message in a JOptionPane
        showMessage(message, title);
    }
}
