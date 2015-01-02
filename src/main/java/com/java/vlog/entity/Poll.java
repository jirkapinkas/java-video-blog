package com.java.vlog.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "vlog_poll")
public class Poll extends MasterEntity {

	private static final long serialVersionUID = 1L;

	private int answer1Count;

	private int answer2Count;

	private int answer3Count;

	private int answer4Count;

	private int answer5Count;

	private int answer6Count;

	private int answer7Count;

	public int getAnswer5Count() {
		return answer5Count;
	}

	public void setAnswer5Count(int answer5Count) {
		this.answer5Count = answer5Count;
	}

	public int getAnswer6Count() {
		return answer6Count;
	}

	public void setAnswer6Count(int answer6Count) {
		this.answer6Count = answer6Count;
	}

	public int getAnswer7Count() {
		return answer7Count;
	}

	public void setAnswer7Count(int answer7Count) {
		this.answer7Count = answer7Count;
	}

	public int getAnswer1Count() {
		return answer1Count;
	}

	public void setAnswer1Count(int answer1Count) {
		this.answer1Count = answer1Count;
	}

	public int getAnswer2Count() {
		return answer2Count;
	}

	public void setAnswer2Count(int answer2Count) {
		this.answer2Count = answer2Count;
	}

	public int getAnswer3Count() {
		return answer3Count;
	}

	public void setAnswer3Count(int answer3Count) {
		this.answer3Count = answer3Count;
	}

	public int getAnswer4Count() {
		return answer4Count;
	}

	public void setAnswer4Count(int answer4Count) {
		this.answer4Count = answer4Count;
	}

}