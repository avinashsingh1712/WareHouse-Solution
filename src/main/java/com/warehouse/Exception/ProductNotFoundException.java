package com.warehouse.Exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Resource not found exception.
 *
 * @author Avsin3
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ProductNotFoundException extends Exception {

  private static final long serialVersionUID = 1L;

/**
   * Instantiates a new Resource not found exception.
   *
   * @param message the message
   */
  public ProductNotFoundException(String message) {
    super(message);
  }
}