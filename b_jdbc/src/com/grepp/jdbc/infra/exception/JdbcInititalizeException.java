package com.grepp.jdbc.infra.exception;

public class JdbcInititalizeException extends RuntimeException{

  public JdbcInititalizeException(String message) {
    super(message);
  }

  public JdbcInititalizeException(String message, Throwable cause) {
    super(message, cause);
  }
}
