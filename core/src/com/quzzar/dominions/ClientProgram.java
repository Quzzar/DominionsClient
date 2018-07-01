package com.quzzar.dominions;

import com.esotericsoftware.kryonet.Client;
import com.quzzar.dominions.ClientListeners.ClientListener;
import com.quzzar.dominions.Misc.Utility;
import com.quzzar.dominions.Packets.PacketMessage;
import com.quzzar.dominions.Packets.WorldUpdatePacket;

public class ClientProgram {

    // Client object
    private Client client;

    // IP to connect to
    private final String ip = "97.86.155.175";

    // Ports to connect on
    private final int tcpPort = 27960;
    private final int udpPort = 27960;

    public ClientProgram() {

        // Create client
        client = new Client();

        // Register a packet class
        client.getKryo().register(PacketMessage.class);
        client.getKryo().register(WorldUpdatePacket.class);

        // Start client
        client.start();
        // Start client BEFORE connecting to server

        // All server listener
        client.addListener(new ClientListener());

    }


    public void connect() {

        Utility.print("CLIENT-Status","Connecting to server...");

        // Connect to server - wait 5000ms before failing.
        try {
            client.connect(5000,ip,tcpPort,udpPort);
            Utility.print("CLIENT-Status", "Connected!");
        } catch (Exception e) {
            Utility.print("CLIENT-Status", "Failed to connected.");
        }

    }

    public boolean isConnected(){
        return client.isConnected();
    }

}