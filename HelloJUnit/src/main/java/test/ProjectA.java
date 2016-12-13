package test;

public class ProjectA {
	ProjectB projectB = new ProjectB();
	public Output getBalanceByMsisdn(String msisdn){
		
		Output output = new Output();
		
		//validate msisdn
		String validateCode = validateMsisdn(msisdn);
		System.out.println(msisdn);
		//000表示驗證通過
		if(!"000".equals(validateCode)){
			output.setIsSuccess(false);
			output.setErrorCode(validateCode);
			
			return output;
		}
		
		//call external api
		Output result = projectB.getBalanceByMsisdn(msisdn);
		System.out.println(msisdn);
		System.out.println(result.getBalance());
		//check if api return success
		if(!result.getIsSuccess()){
			//return failure message
			output.setIsSuccess(false);
			output.setErrorCode(result.getErrorCode());
			output.setMessage(result.getMessage());
			
			return output;
		}
		
		if(result.getBalance() <= 0){
			output.setIsSuccess(true);
			output.setMessage("No payment is required");	
		}
		else{
			output.setIsSuccess(true);
			output.setBalance(result.getBalance());
		}
		
		return output;
	}
	
	public String validateMsisdn(String msisdn){
		
		if(msisdn == null || msisdn.isEmpty() ){
			return "003";
		}
		
		if (!isNumeric(msisdn)) {
			return "002";
		}
		
		else if(msisdn.length() != 10){
			return "001";
		}
		
		return "000";
	}
	
	public static boolean isNumeric(String string) {
		return string.matches("^[-+]?\\d+(\\.\\d+)?$");
	}
}
