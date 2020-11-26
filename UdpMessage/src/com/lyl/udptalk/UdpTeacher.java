package com.lyl.udptalk;

public class UdpTeacher {
	public static void main(String[] args) {
		new Thread(new UdpReceive(9999)).start();
		new Thread(new UdpSend("老师", "localhost", 6666,8888)).start();
	}
}
