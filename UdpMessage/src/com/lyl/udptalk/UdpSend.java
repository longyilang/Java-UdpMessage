package com.lyl.udptalk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UdpSend implements Runnable{
	
	private String  name;
	private String ip;
	private int spot;
	private int rpot;

	private DatagramSocket client;
	BufferedReader reader;

	public UdpSend(String name, String ip, int spot, int rpot) {
		super();
		this.name = name;
		this.ip = ip;
		this.setSpot(spot);
		this.rpot = rpot;
		try {
			client = new DatagramSocket(spot);
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		reader = new BufferedReader(new InputStreamReader(System.in));
	}



	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			try {
				String string = this.name+"说:"+reader.readLine();
				byte[] datas = string.getBytes();
				DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress(this.ip, rpot));
				client.send(packet);
				if (string.equals("bye")) {
					break;
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		client.close();
	}



	public int getSpot() {
		return spot;
	}



	public void setSpot(int spot) {
		this.spot = spot;
	}

}
