package de.hybris.training.core.exception;

public class NegativeWarrantyMonthException extends RuntimeException {
    public String getMessage() {
        return "Warranty month value must be positive";
    }

}
