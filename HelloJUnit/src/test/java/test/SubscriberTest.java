package test;
import static org.junit.Assert.*;

import org.junit.Test;

import test.Subscriber;

public class SubscriberTest {
	Subscriber subscriber = new Subscriber();

	@Test
	public void delete_Subscriber_Success_Test() {
		// Arrange
		String msisdn = "0911111111";		
		// ACT
		boolean result = subscriber.deleteSubscriber(msisdn);		
		// Assert
		assertEquals(true, result);
	}

	@Test
	public void delete_Subscriber_Fail_Test() {
		// Arrange
		String msisdn = "0912345678";		
		// ACT
		boolean result = subscriber.deleteSubscriber(msisdn);	
		// Assert
		assertEquals(false, result);
	}

}
