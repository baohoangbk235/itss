package gui;

import hust.soict.se.customexception.InvalidIDException;
import hust.soict.se.scanner.CardScanner;

public class CScanner {
	private static CardScanner scanner = CardScanner.getInstance();
	private String pseudoBarCode;
	
	/**
	 * Khởi tạo CScanner 
	 * @param pseudoBarCode Mã giả của thẻ, gồm 8 chữ cái hoa
	 */
	public CScanner(String pseudoBarCode) {
		super();
		this.pseudoBarCode = pseudoBarCode;
	}
	
	/**
	 * Lấy mã code 16 bits cho thẻ từ mã giả.
	 * @return Trả về code 16 bits của thẻ  
	 * @throws InvalidIDException Ngoại lệ khi chuyển đổi id từ mã giả.
	 */
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
