package com.myproject.game.network.kademlia;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class InMessageQueue {
    private final BlockingQueue<KademliaMessage> inQueue;

    public InMessageQueue() {
        this.inQueue = new LinkedBlockingQueue<>();
    }


    public KademliaMessage getNextMessage() {
        KademliaMessage nextMessage = null;
        try {
            nextMessage = inQueue.take();
            System.out.println("message taken from queue");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return nextMessage;
    }

    public void addMessage(KademliaMessage message) {
        inQueue.add(message);
    }

    public boolean isEmpty() {
        return inQueue.isEmpty();
    }

    public int length() {
        return inQueue.size();
    }
}
