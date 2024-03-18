package view;

import java.util.concurrent.Semaphore;
import controller.ThreadSemaforoController;

public class Main {

	public static void main(String[] args) {
		Semaphore mutex = new Semaphore(1);
		
		
		for(int i = 0; i < 21; i++) {
			ThreadSemaforoController th = new ThreadSemaforoController(mutex);
			th.start();
			
		}
	}

}
