package com.github.marquesbmc.infrastructure.exception;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.core.Response.Status;

public class PrepareMessage {

	private Message msgException;
	private ExceptionMessage exMsg = new ExceptionMessage();
	

	public String getMessage(Exception ex) throws Exception {
		Jsonb jsonb = JsonbBuilder.create();
		mensagemDesenvolvedorJson msgDev = new mensagemDesenvolvedorJson();
		msgException = exMsg.getClass(ex);
		
		
		msgDev.setViolation(msgException.getExceptions());
		msgDev.setStack(msgException.getStackTrace());
		
		

		return jsonb.toJson(msgDev);
	}

	public Status getStatus(Exception ex) throws Exception {

		msgException = exMsg.getClass(ex);

		Status statusCode = msgException.getStatusCode();

		return statusCode;
	}

	public class mensagemDesenvolvedorJson {
		private String violation;

		private String stack;

		public String getViolation() {
			return violation;
		}

		public void setViolation(String violation) {
			this.violation = violation;
		}

		public String getStack() {
			return stack;
		}

		public void setStack(String stack) {
			this.stack = stack;
		}

	}

}
