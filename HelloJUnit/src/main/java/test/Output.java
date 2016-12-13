package test;


public class Output {
	private boolean success;
	private String message;
	private String errorCode;
	private int balance;
	
	public Output(){
		
	}
	
	public Output(boolean success, int balance, String errorCode, String message){
		this.success = success;
		this.balance = balance;
		this.errorCode = errorCode;
		this.message = message;
	}
	
	public boolean getIsSuccess() {
		return success;
	}
	public void setIsSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
