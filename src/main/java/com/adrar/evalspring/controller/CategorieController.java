package com.adrar.evalspring.controller;

import com.adrar.evalspring.model.Categorie;
import com.adrar.evalspring.service.CategorieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api")
public class CategorieController {

    @Autowired
    private CategorieService categorieService;

    //Méthode qui retourne une catégorie par son id
    @GetMapping("/categorie/{id}")
    @ResponseStatus(org.springframework.http.HttpStatus.OK)
    public Categorie findCategorieById(@PathVariable Long id) {
        return categorieService.getCategorieById(id);
    }

    //Méthode qui retourne toutes les catégories
    @GetMapping("/categories")
    @ResponseStatus(org.springframework.http.HttpStatus.OK)
    public List<Categorie> findAllCategories() {
        return categorieService.getAllCategories();
    }

    //Méthode qui ajoute une catégorie
    @PostMapping("/categorie")
    @ResponseStatus(org.springframework.http.HttpStatus.CREATED)
    public Categorie createCategorie(@Valid @RequestBody Categorie categorie) {
        return categorieService.saveCategorie(categorie);
    }
}
