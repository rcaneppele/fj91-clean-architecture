package br.com.caelum.fj91.rh.domain;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public BusinessException(String msg) {
		super(msg);
	}

}
