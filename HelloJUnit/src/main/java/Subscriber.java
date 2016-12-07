
public class Subscriber {
	public boolean deleteSubscriber(String msisdn) {
		switch (msisdn) {
		case "09123456789":
			return false;
		case "0911111111":
			return true;
		default:
			return false;
		}

	}
}
