package com.adrar.evalspring.exception;

public class NoProductFoundException extends RuntimeException {
    public NoProductFoundException() {
        super("La liste des produits est vide");
    }
}
