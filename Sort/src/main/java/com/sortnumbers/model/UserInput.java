package com.sortnumbers.model;

public class UserInput {

	private String unsortednumbers;

	public UserInput() {
	}

	/**
	 * @param unsortednumbers
	 */
	public UserInput(String unsortednumbers) {
		this.unsortednumbers = unsortednumbers;
	}

	/**
	 * @return the unsortednumbers
	 */
	public String getUnsortednumbers() {
		return unsortednumbers;
	}

	/**
	 * @param unsortednumbers
	 *            the unsortednumbers to set
	 */
	public void setUnsortednumbers(String unsortednumbers) {
		this.unsortednumbers = unsortednumbers;
	}

}
