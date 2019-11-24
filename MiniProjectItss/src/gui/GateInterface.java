package gui;

import java.util.concurrent.TimeUnit;

import hust.soict.se.gate.Gate;

public class GateInterface {
	private static Gate gate = Gate.getInstance();
	public static void open() throws InterruptedException {
		gate.open();
		//TimeUnit.SECONDS.sleep(3);
		//gate.close();
	}
}
