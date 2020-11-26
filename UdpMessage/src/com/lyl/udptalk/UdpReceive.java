package com.lyl.udptalk;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpReceive implements Runnable{
	
	private int pot;
	
	private DatagramSocket server;
	
	
	public UdpReceive(int pot) {
		super();
		this.pot = pot;
		try {
			server = new  DatagramSocket(this.pot);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public void run() {
		while (true) {
			byte[] container = new byte[1024];
			DatagramPacket packet = new DatagramPacket(container, 0, container.length);
			try {
				server.receive(packet);
				byte[] datas = packet.getData();
				int len = packet.getLength();
				String rsultString = new String(datas, 0, len);
				System.out.println(rsultString);
				if (rsultString.equals("bye")) {
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		server.close();
		
	}
}
