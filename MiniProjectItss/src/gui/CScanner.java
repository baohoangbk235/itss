package gui;

import hust.soict.se.customexception.InvalidIDException;
import hust.soict.se.scanner.CardScanner;

public class CScanner {
	private static CardScanner scanner = CardScanner.getInstance();
	private String pseudoBarCode;
	
	public CScanner(String pseudoBarCode) {
		super();
		this.pseudoBarCode = pseudoBarCode;
	}
	
	public String getCode16bits() throws InvalidIDException {
		return scanner.process(this.getPseudoBarCode());
	}

	public String getPseudoBarCode() {
		return pseudoBarCode;
	}

	public void setPseudoBarCode(String pseudoBarCode) {
		this.pseudoBarCode = pseudoBarCode;
	}
}
