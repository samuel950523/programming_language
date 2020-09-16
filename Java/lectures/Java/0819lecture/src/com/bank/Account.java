package com.bank;

// Account.java .... share data

public class Account {
	private int balance;// 잔액
	private int transactionNum; // 거래횟수

	public void deposit(int money) {
		synchronized (this) {
			transactionNum++;
			balance += money;
			System.out.print("[" + transactionNum + "]예금 : \t");
			System.out.println(money + " 예금 후 잔액 > " + balance);
			this.notify();
		}
	}

	public synchronized void withdraw(int money) {

		while (balance <= 0) {

			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		transactionNum++;
		balance -= money;
		System.out.print("[" + transactionNum + "]출금 : \t");
		System.out.println(money + " 출금 후 잔액 > " + balance);
	}
}
