package com.lyl.udptalk;

public class UdpStudent {
	public static void main(String[] args) {
		new Thread(new UdpSend("学生", "localhost", 7777, 9999)).start();
		new Thread(new UdpReceive(8888)).start();
	}
}
