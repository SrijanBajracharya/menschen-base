package com.achiever.menschenfahren.base.model;

public enum EventTypes {

	SEMINAR("Seminar"), CONFERENCE("Conference"), PICNIC("Picnic"), TREK("Trek"), HIKE("Hike"), GATHERING("Gathering");

	private String value;

	EventTypes(String role) {
		this.value = role;
	}

	public String getValue() {
		return value;
	}
}
