package com.lyl.udptalk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;


public class UdpTalkClient {
	public static void main(String[] args) throws SocketException {
		System.out.println("发送方启动中...");

		DatagramSocket client = new DatagramSocket(8888);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				String string = reader.readLine();
				byte[] datas = string.getBytes();
				DatagramPacket packet = new DatagramPacket(datas, 0, datas.length, new InetSocketAddress("localhost", 9999));
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
}
