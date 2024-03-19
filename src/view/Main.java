package view;

import java.util.concurrent.Semaphore;
import controller.ThreadSemaforoServidorController;

public class Main {

	public static void main(String[] args) {
		Semaphore mutex = new Semaphore(1);
		
		for(int i = 1; i <= 21; i++) {
			Thread th = new ThreadSemaforoServidorController(i, mutex);
			th.start();
			
		}
	}

}
