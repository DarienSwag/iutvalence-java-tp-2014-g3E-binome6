
public class TimerThread extends Thread{
	public void run(){
		while(true)
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		
	}
}
