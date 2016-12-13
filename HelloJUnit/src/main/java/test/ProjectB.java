package test;
public class ProjectB {
	public Output getBalanceByMsisdn(String msisdn){	
		
		Output output = new Output();
		
		int amountDue = getAmountDue(msisdn);
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
		switch (msisdn) { 
		    case "0911111111": 
		    	amount = 100; 
		        break; 
		    case "0912222222": 
		    	amount = 100;
		        break; 
		    case "0913333333": 
		    	amount = 0; 
		        break; 
		    case "0914444444": 
		    	amount = 0; 
		        break;
		}
		
		return amount;
	}

	private Integer getAmountDue(String msisdn) {
		
		Integer amount = null;
			switch (msisdn) { 
		    case "0911111111": 
		    	amount = 200; 
		        break; 
		    case "0912222222": 
		    	amount = 50;
		        break; 
		    case "0913333333": 
		    	amount = 200; 
		        break; 
		    case "0914444444": 
		    	amount = 0; 
		        break;
		}
		return amount;
	}
}
