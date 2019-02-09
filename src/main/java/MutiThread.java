
public class MutiThread extends Thread {

	public void run() {
		try {
			System.out.println("--->" + Thread.currentThread().getId());

		} catch (Exception e) {
			System.out.println("Exception--->" + Thread.currentThread().getId());
		}
	}

}
