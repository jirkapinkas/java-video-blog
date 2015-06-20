package com.java.vlog.controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang.RandomStringUtils;

@ManagedBean
@ViewScoped
public class AdBlockController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String adBlockClassName;
	
	public String getAdBlockClassName() {
		if(adBlockClassName == null) {
			adBlockClassName = RandomStringUtils.randomAlphabetic(30).toString();
		}
		return adBlockClassName;
	}

}
