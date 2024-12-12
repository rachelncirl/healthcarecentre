package org.rachel.healthcare;

import java.util.Objects;

public class Account {
	private final int id = IdGenerator.generateId();
	private int balance;
	private final int patientId;
	private int healthcareCentreId;

	public Account(final int balance, final int patientId, final int healthcareCentreId) {
		this.balance = balance;
		this.patientId = patientId;
		this.healthcareCentreId = healthcareCentreId;
	}

	public int getId() {
		return id;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void charge(int amount) {
		this.balance += amount;
	}

	public void pay(int amount) {
		this.balance -= amount;
	}

	public int getPatientId() {
		return patientId;
	}

	public int getHealthcareCentreId() {
		return healthcareCentreId;
	}

	public void setHealthcareCentreId(int healthcareCentreId) {
		this.healthcareCentreId = healthcareCentreId;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Account account = (Account) o;
		return id == account.id && balance == account.balance && patientId == account.patientId && healthcareCentreId == account.healthcareCentreId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, balance, patientId, healthcareCentreId);
	}

	@Override
	public String toString() {
		return "Account{" +
				"id=" + id +
				", balance=" + balance +
				", patientId=" + patientId +
				", healthcareCentreId=" + healthcareCentreId +
				'}';
	}

}