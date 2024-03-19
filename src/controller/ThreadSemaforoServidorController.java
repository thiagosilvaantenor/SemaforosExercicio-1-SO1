package controller;

import java.util.concurrent.Semaphore;

public class ThreadSemaforoServidorController extends Thread {
	private int id = 0;
	private Semaphore semaforo;

	public ThreadSemaforoServidorController(int id, Semaphore semaforo) {
		this.semaforo = semaforo;
		this.id = id;
	}

	@Override
	public void run() {
		comportamentoThread();
	}

	private void comportamentoThread() {
		int tempoBD, maxC,minC;
		int comportamento = id % 3;
		
		switch (comportamento) {
		case 1:
			// 1seg => 1000mlSeg
			tempoBD = 1000;
			maxC = 1000;
			//0,2seg => 200mlSeg
			minC = 200;
			transacoes(tempoBD, maxC, minC);
			transacoes(tempoBD, maxC, minC);
			break;
		case 2:
			// 1,5seg => 1500mlSeg
			tempoBD = 1500;
			maxC = 1500;
			//0,5seg => 500mlSeg
			minC = 500;
			transacoes(tempoBD, maxC, minC);
			transacoes(tempoBD, maxC, minC);
			transacoes(tempoBD, maxC, minC);
			break;
		case 0:
			//1,5seg => 1500mlSeg
			tempoBD = 1500;
			//2seg => 2000mlSeg
			maxC = 2000;
			minC = 1000;
			transacoes(tempoBD, maxC, minC);
			transacoes(tempoBD, maxC, minC);
			transacoes(tempoBD, maxC, minC);
			break;
		}
	}

	private void transacoes(int tempoBD, int maxC, int minC) {
		calculando(maxC, minC);
		transacaoBD(tempoBD);
	}
	
	private void calculando(int maxC, int minC) {
		int tempoC = (int) ((Math.random() * (maxC+1)) + minC);
		try {
			System.out.println("Thread #" + id + " está calculando");
			sleep(tempoC);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		}

	}

	private void transacaoBD(int tempoBD) {
		try {
			semaforo.acquire();
			System.out.println("Thread #" + id + " está realizando uma transação no banco de dados");
			sleep(tempoBD);
		} catch (InterruptedException e) {
			System.err.println(e.getMessage());
		} finally {
			semaforo.release();
		}

	}

}
