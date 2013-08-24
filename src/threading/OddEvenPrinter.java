package threading;

public class OddEvenPrinter {

	static int count = 0;
	static Object lock = new Object();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Printing odd and even numbers in different threads");
		
		Thread oddThread = new Thread(){
			@Override
			public void run()
			{
				while(true){
					synchronized(lock) {
						while(count%2 != 1){
							try {
								lock.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						System.out.println("from oddthread: " + count);
						count++;
						lock.notifyAll();
					}
				}
			}
		};
		
		Thread evenThread = new Thread(){
			@Override
			public void run()
			{
				while(true){
					synchronized(lock) {
						while(count%2 != 0){
							try {
								lock.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
							System.out.println("from eventhread  : " + count);
							count++;
							lock.notifyAll();
					}
				}
			}
		};
		oddThread.start();
		evenThread.start();
	}

}
