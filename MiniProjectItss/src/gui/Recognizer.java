package gui;

import hust.soict.se.customexception.InvalidIDException;
import hust.soict.se.recognizer.TicketRecognizer;

public class Recognizer {
	private static TicketRecognizer tr = TicketRecognizer.getInstance();
	private String pseudoBarCode;
	
	public Recognizer(String pseudoBarCode) {
		super();
		this.pseudoBarCode = pseudoBarCode;
	}
	
	public String getCode16bits() throws InvalidIDException {
		return tr.process(this.getPseudoBarCode());
	}

	public String getPseudoBarCode() {
		return pseudoBarCode;
	}

	public void setPseudoBarCode(String pseudoBarCode) {
		this.pseudoBarCode = pseudoBarCode;
	}
	
}
