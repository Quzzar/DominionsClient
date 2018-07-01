package com.quzzar.dominions.ClientListeners;


import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;
import com.quzzar.dominions.Misc.Utility;
import com.quzzar.dominions.Packets.PacketMessage;
import com.quzzar.dominions.Packets.WorldUpdatePacket;

public class ClientListener extends Listener {


    @Override
    public void connected(Connection c) {
        super.connected(c);
        Utility.print("CLIENT-Status","Client connected!");
    }

    @Override
    public void disconnected(Connection c) {
        super.disconnected(c);
        Utility.print("CLIENT-Status","Client disconnected!");
    }

    @Override
    public void received(Connection c, Object packet) {
        super.received(c, packet);
        Utility.print("CLIENT-Status","Received a packet!");

        if(packet instanceof PacketMessage){
            PacketMessage packetMessage = (PacketMessage) packet;
            Utility.print("CLIENT-Status",packetMessage.getMessage());
        } else if (packet instanceof WorldUpdatePacket){
            WorldUpdatePacket worldUpdatePacket = (WorldUpdatePacket) packet;
        }

    }

    @Override
    public void idle(Connection c) {
        super.idle(c);
        // Do nothing.
    }
}
