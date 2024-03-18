package controller;

import java.util.concurrent.Semaphore;

public class ThreadSemaforosController extends Thread {
	private static int id;
	private Semaphore semaforo;

	public ThreadSemaforosController(Semaphore semaforo) {
		this.semaforo = semaforo;
		id++;
	}

	@Override
	public void run() {
		comportamentoThread();
	}

	private void comportamentoThread() {
		int tempoC, tempoBD;
		// 1 seg -> 1000 mlSeg
		// 0,2 seg -> 200 mlSeg
		if (id % 3 == 1) {
			tempoC = (int) ((Math.random() * 1001) + 200);
			tempoBD = 1000;
			calculando(tempoC);
			transacaoBD(tempoBD);
			calculando(tempoC);
			transacaoBD(tempoBD);
		}
		else if (id % 3 == 2) {
			tempoC = (int) ((Math.random() * 1501) + 500);
			tempoBD = 1500;
			calculando(tempoC);
			transacaoBD(tempoBD);
			calculando(tempoC);
			transacaoBD(tempoBD);
			calculando(tempoC);
			transacaoBD(tempoBD);

		}
		else if (id % 3 == 0) {
			tempoC = (int) ((Math.random() * 2001) + 1000);
			tempoBD = 1500;
			calculando(tempoC);
			transacaoBD(tempoBD);
			calculando(tempoC);
			transacaoBD(tempoBD);
			calculando(tempoC);
			transacaoBD(tempoBD);
		}
	}

	private void calculando(int tempo) {
		System.out.println("Thread #" + id + " está calculando");
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}

	}

	private void transacaoBD(int tempo) {
		try {
			semaforo.acquire();
			System.out.println("Thread #" + id + " está realizando uma transação no banco de dados");
			sleep(tempo);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		} finally {
			semaforo.release();
		}
		
	}

}
