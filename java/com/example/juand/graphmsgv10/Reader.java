package com.example.juand.graphmsgv10;

import java.io.DataInputStream;
import java.io.IOException;

/**
 * Created by Juan D on 27/11/2016.
 */

public class Reader extends Thread {

    DataInputStream msj;
    String msjS;


    public Reader(DataInputStream msjcom ){
        msj = msjcom;

    }

    public void run(){
        try {
            msjS = msj.readUTF();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readMessage(){
        return msjS;
    }

}
