package config;

public final class Constants {
	public static final String DB_HOST = "localhost";
	public static final String DB_PORT = "3306";
	public static final String DB_USERNAME = "pnb";
	public static final String DB_PASSWORD = "";
	public static final String DB_DATABASE = "AFC_System";

	public static final String station_code_pattern = "\\s*[1-2]\\s*[-]\\s*[a-i]\\s*";
	public static final String ticket_code_pattern = "[a-zA-Z]{8}";

	public static final int BASE_DISTANCE = 5;
	public static final float BASE_FARE = 1.9f;
	public static final int EXTRA_DISTANCE = 2;
	public static final float EXTRA_FARE = 0.4f;
	public static final float MIN_BALANCE = 2.5f;
	private Constants() {}
}
 