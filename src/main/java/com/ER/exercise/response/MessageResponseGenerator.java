package com.ER.exercise.response;

public class MessageResponseGenerator {

	private String message = "";
	private final String ENTERED_VALUE = "Number entered by you";
	private final String NUMBER_IS_PERFECT = "is a perfect number.";
	private final String NOT_A_PERFECT_NUMBER = "is not a perfect number";

	public String generatePerfectNumberResponse(Long number) {
		this.message = this.ENTERED_VALUE + " (" + number + ") " + NUMBER_IS_PERFECT;
		return message;
	}

	public String generateNotAPerfectNumberResponse(Long number) {
		this.message = ENTERED_VALUE + " (" + number + ") " + NOT_A_PERFECT_NUMBER;
		return this.message;
	}
}
