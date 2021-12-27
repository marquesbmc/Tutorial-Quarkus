package com.github.marquesbmc.infrastructure.enums;

public enum MsgErrors {

	ExceptionMapperHandled("Por favor entrar em contato com suporte ou aceoutros canais.");


	    private final String description;

	    private MsgErrors(String description) {
	        this.description = description;
	    }

	  
	    @Override
	    public String toString() {
	        return description;
	    }
	}
