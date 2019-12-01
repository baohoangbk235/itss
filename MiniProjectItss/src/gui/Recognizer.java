package gui;

import hust.soict.se.customexception.InvalidIDException;
import hust.soict.se.recognizer.TicketRecognizer;

public class Recognizer {
	private static TicketRecognizer tr = TicketRecognizer.getInstance();
	private String pseudoBarCode;
	
	/**
	 * Khởi tạo Recognizer 
	 * @param pseudoBarCode Mã giả của vé, gồm 8 chữ cái in thường
	 */
	public Recognizer(String pseudoBarCode) {
		super();
		this.pseudoBarCode = pseudoBarCode;
	}
	/**
	 * Lấy mã code 16 bits cho vé từ mã giả.
	 * @return Trả về code 16 bits của vé 
	 * @throws InvalidIDException Ngoại lệ khi chuyển đổi id từ mã giả.
	 */
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
