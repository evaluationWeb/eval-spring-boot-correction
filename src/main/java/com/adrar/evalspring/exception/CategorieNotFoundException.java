package com.adrar.evalspring.exception;

public class CategorieNotFoundException extends RuntimeException {
    public CategorieNotFoundException(Long id) {
        super("La catégorie avec l'ID " + id + " n'a pas été trouvée");
    }
}
