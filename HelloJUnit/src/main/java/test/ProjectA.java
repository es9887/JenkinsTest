package test;
public class ProjectA {
	
	public Output getBalanceByMsisdn(String msisdn){
		
		ProjectB projectB = new ProjectB();
		Output output = new Output();
		
		//validate msisdn
		String validateCode = validateMsisdn(msisdn);
		
		//000銵函內撽����
		if(!"000".equals(validateCode)){
			output.setIsSuccess(false);
			output.setErrorCode(validateCode);
			
			return output;
		}
		
		//call external api
		Output result = projectB.getBalanceByMsisdn(msisdn);
		//check if api return success
		if(!result.getIsSuccess()){
			//return failure message
			output.setIsSuccess(false);
			output.setErrorCode(result.getErrorCode());
			output.setMessage(result.getMessage());
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
