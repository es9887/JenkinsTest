package test;


public class ProjectB {
	public Output getBalanceByMsisdn(String msisdn){	
		
		Output output = new Output();
		
		Integer amountDue = getAmountDue(msisdn);
		
		if(amountDue == null){
			output.setIsSuccess(false); 
			output.setErrorCode("004");
			
			return output;
		}
			
		int overpaidAmount = getOverpaidAmount(msisdn);
		
		int subtractResult = amountDue;
		if(overpaidAmount > 0){
			subtractResult = subtract(amountDue, overpaidAmount);
		}
		
		output.setBalance(subtractResult);
		output.setIsSuccess(true);
		
		return output;
	}

	private int subtract(int amountDue, int overpaidAmount) {
		return amountDue - overpaidAmount;
	}

	private Integer getOverpaidAmount(String msisdn) {
		
		Integer amount = null;
		if("0911111111".equals(msisdn)){
			amount = 100; 
		}
		if("0912222222".equals(msisdn)){
			amount = 100; 
		}
		if("0913333333".equals(msisdn)){
			amount = 0; 
		}
		if("0914444444".equals(msisdn)){
			amount = 0; 
		}
		
		return amount;
	}

	private Integer getAmountDue(String msisdn) {
		
		Integer amount = null;
		
		if("0911111111".equals(msisdn)){
			amount = 200; 
		}
		if("0912222222".equals(msisdn)){
			amount = 50; 
		}
		if("0913333333".equals(msisdn)){
			amount = 200; 
		}
		if("0914444444".equals(msisdn)){
			amount = 0; 
		}
		
		return amount;
	}
}
