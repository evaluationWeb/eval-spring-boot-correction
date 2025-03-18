package com.adrar.evalspring.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Long id) {
        super("Le produit avec l'ID " + id + " n'a pas été trouvé");
    }
}
