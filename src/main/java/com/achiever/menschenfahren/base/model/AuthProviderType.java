package com.achiever.menschenfahren.base.model;

/**
 * CreatedBy : edangol CreatedOn : 10/04/2020 Description :
 **/
public enum AuthProviderType {
	FACEBOOK("Facebook"), GOOGLE("Google"), OTHER("other");

	String value;

	AuthProviderType(String authProviderType) {
		this.value = authProviderType;
	}

	public String getValue() {
		return value;
	}
}
