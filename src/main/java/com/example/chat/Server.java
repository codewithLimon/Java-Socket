package com.example.chat;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket=new ServerSocket(22222);
        System.out.println("server started..");

        while(true){


            Socket socket=serverSocket.accept();
            System.out.println("Client connected..");

            ObjectInputStream ois=new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());


            //read from client
            Object cMSG=ois.readObject();
            System.out.println(cMSG.toString());

            String serverMsg= cMSG.toString();
            serverMsg =serverMsg.toUpperCase();

            //send to client..
            oos.writeObject(serverMsg);
        }
    }
}
