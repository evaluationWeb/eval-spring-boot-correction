package com.adrar.evalspring.controller;

import com.adrar.evalspring.model.Produit;
import com.adrar.evalspring.service.ProduitService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/api")
public class ProduitController {

    @Autowired
    private ProduitService produitService;

    //Méthode qui retourne un produit par son id
    @GetMapping("/produit/{id}")
    @ResponseStatus(org.springframework.http.HttpStatus.OK)
    public Produit findProduitById(@PathVariable Long id) {
        return produitService.getProduitById(id);
    }

    //Méthode qui retourne tous les produits
    @GetMapping("/produits")
    @ResponseStatus(org.springframework.http.HttpStatus.OK)
    public List<Produit> findAllProduits() {
        return produitService.getAllProduits();
    }

    //Méthode qui ajoute un produit
    @PostMapping("/produit")
    @ResponseStatus(org.springframework.http.HttpStatus.CREATED)
    public Produit createProduit(@Valid @RequestBody Produit produit) {
        return produitService.saveProduit(produit);
    }
}
