/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientserver;


// A Java program for a Client 
import java.net.*;
import java.io.*;
 
/**
 * This program demonstrates a simple TCP/IP socket client that reads input
 * from the user and prints echoed message from the server.
 *
 * @author www.codejava.net
 */
public class Client {
 
    public static void main(String[] args) {
 
        String hostname = "localhost";
        int port = 5050;
 
        try (Socket socket = new Socket(hostname, port)) {
            
            System.out.println("Server is connected");
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);
 
            //Console console = System.console();
            //String text;
            
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String name;
            
            do {
                //text = console.readLine("Enter text: ");
            System.out.println("Enter the Message to the Server:");
            name = br.readLine();
            
                
                writer.println(name);
 
                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                
                String time = reader.readLine();
 
                System.out.println(time);
 
            } while (!name.equals("Ma salama"));
 
            socket.close();
 
        } catch (UnknownHostException ex) {
 
            System.out.println("Server not found: " + ex.getMessage());
 
        } catch (IOException ex) {
 
            System.out.println("I/O error: " + ex.getMessage());
        }
    }
}
