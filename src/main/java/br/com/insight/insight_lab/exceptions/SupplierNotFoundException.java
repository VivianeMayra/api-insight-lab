package br.com.insight.insight_lab.exceptions;

public class SupplierNotFoundException extends RuntimeException {

  public SupplierNotFoundException() {
    super("Supplier not found");
  }
}
