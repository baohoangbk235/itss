package gui;

import hust.soict.se.gate.Gate;

public class GateInterface {
	private static Gate gate = Gate.getInstance();
	
	/**
	 * Phương thức để mở cổng
	 * @throws InterruptedException Ngoại lệ khi mở/đóng cổng
	 */
	public static void open() throws InterruptedException {
		gate.open();
//		TimeUnit.SECONDS.sleep(1);
//		gate.close();
	}
	
	/**
	 * Phương thức để đóng cổng
	 * @throws InterruptedException Ngoại lệ khi mở/đóng cổng
	 */
	public static void close() throws InterruptedException {
		gate.close();
	}
}
