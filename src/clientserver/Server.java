/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientserver;

import java.io.*;
import java.net.*;
 
/**
 * This program demonstrates a simple TCP/IP socket server that echoes every
 * message from the client in reversed form.
 * This server is single-threaded.
 *
 * @author www.codejava.net
 */
public class Server {
 
    public static void main(String[] args) {
 
        int port = 5050;
 
        try (ServerSocket serverSocket = new ServerSocket(port)) {
 
            System.out.println("Server is listening on port " + port);
 
            while (true) {
                try (Socket socket = serverSocket.accept()) {
                    System.out.println("New client connected");
                    
                    InputStream input = socket.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                    
                    OutputStream output = socket.getOutputStream();
                    PrintWriter writer = new PrintWriter(output, true);
                    
                    
                    String text;
                   
                    do {
                        text = reader.readLine();

                        System.out.println("Client sent Message: "+text);
                        //System.out.println("Message Count: );

                        if(!text.equals("Ma salama")){
                           writer.println("Reply from Server: Ok");
                        }else{
                        String reply = "مع السلامة";
                        writer.println("Reply from Server: " +reply);
                        }
                        
                    } while (!text.equals("Ma salama"));
                    System.out.println("Connection Closed");
                    socket.close();
                }
            }
 
        } catch (IOException ex) {
            System.out.println("Server exception: " + ex.getMessage());
        }
    }
}