package com.axis.springbootdemo.entity;

import java.util.Objects;

public class Cricketer {

	private int crickerterId;
	private String name;
	private int runScored;
	private int ballsFaced;
	private int fours;
	private int sixes;
	private double strikeRate;
	
	public Cricketer() {
		
	}

	public Cricketer(int crickerterId, String name, int runScored, int ballsFaced, int fours, int sixes, double strikeRate) {
		super();
		this.crickerterId = crickerterId;
		this.name = name;
		this.runScored = runScored;
		this.ballsFaced = ballsFaced;
		this.fours = fours;
		this.sixes = sixes;
		this.strikeRate = strikeRate;
	}

	public int getBallsFaced() {
		return ballsFaced;
	}

	public void setBallsFaced(int ballsFaced) {
		this.ballsFaced = ballsFaced;
	}

	public int getCrickerterId() {
		return crickerterId;
	}

	public void setCrickerterId(int crickerterId) {
		this.crickerterId = crickerterId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRunScored() {
		return runScored;
	}

	public void setRunScored(int runScored) {
		this.runScored = runScored;
	}

	public int getFours() {
		return fours;
	}

	public void setFours(int fours) {
		this.fours = fours;
	}

	public int getSixes() {
		return sixes;
	}

	public void setSixes(int sixes) {
		this.sixes = sixes;
	}

	public double getStrikeRate() {
		return strikeRate;
	}

	public void setStrikeRate(double strikeRate) {
		this.strikeRate = strikeRate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(crickerterId, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cricketer other = (Cricketer) obj;
		return crickerterId == other.crickerterId && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Cricketer [crickerterId=" + crickerterId + ", name=" + name + ", runScored=" + runScored
				+ ", ballsFaced=" + ballsFaced + ", fours=" + fours + ", sixes=" + sixes + ", strikeRate=" + strikeRate
				+ "]";
	}

	
	
	
	
}
