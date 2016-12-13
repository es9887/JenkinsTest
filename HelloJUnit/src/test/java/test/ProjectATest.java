package test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ProjectATest {
	@InjectMocks
	ProjectA selfcare = new ProjectA();

	@Mock
	ProjectB crm = new ProjectB();

	@Test
	public void getBalanceByMsisdn_regular_balance_overpaid() {
		// Arrange
		String msisdn = "0911111111";
		// mockito
		MockitoAnnotations.initMocks(this);
		when(crm.getBalanceByMsisdn(msisdn)).thenReturn(new Output(true, 100, "", ""));
		// ACT
		Output result = selfcare.getBalanceByMsisdn(msisdn);
		// Assert
		assertEquals(100, result.getBalance());
	}

	@Test
	public void getBalanceByMsisdn_regular_balance_noOverpaid() {
		// Arrange
		String msisdn = "0913333333";
		// ACT
		Output result = selfcare.getBalanceByMsisdn(msisdn);
		// Assert
		assertEquals(200, result.getBalance());
	}

	@Test
	public void getBalanceByMsisdn_regular_noBalance_overpaid() {
		// Arrange
		String msisdn = "0912222222";
		// ACT
		Output result = selfcare.getBalanceByMsisdn(msisdn);
		// Assert
		assertEquals("No payment is required", result.getMessage());
	}

	@Test
	public void getBalanceByMsisdn_regular_noBalance_noOverpaid() {
		// Arrange
		String msisdn = "0914444444";
		// ACT
		Output result = selfcare.getBalanceByMsisdn(msisdn);
		// Assert
		assertEquals("No payment is required", result.getMessage());
	}

	@Test
	public void getBalanceByMsisdn_irregular_size() {
		// Arrange
		String msisdn = "09111111110";
		// ACT
		Output result = selfcare.getBalanceByMsisdn(msisdn);
		// Assert
		assertEquals("001", result.getErrorCode());
	}

	@Test
	public void getBalanceByMsisdn_irregular_type() {
		// Arrange
		String msisdn = "abcdefghij";
		// ACT
		Output result = selfcare.getBalanceByMsisdn(msisdn);
		// Assert
		assertEquals("002", result.getErrorCode());
	}

	@Test
	public void getBalanceByMsisdn_irregular_null() {
		// Arrange
		String msisdn = null;
		// ACT
		Output result = selfcare.getBalanceByMsisdn(msisdn);
		// Assert
		assertEquals("003", result.getErrorCode());
	}

	@Test
	public void getBalanceByMsisdn_irregular_external_fail() {
		// Arrange
		String msisdn = "0944444444";
		// ACT
		Output result = selfcare.getBalanceByMsisdn(msisdn);
		// Assert
		assertEquals("004", result.getErrorCode());
	}
}