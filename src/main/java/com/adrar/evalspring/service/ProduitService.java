package com.adrar.evalspring.service;

import com.adrar.evalspring.exception.NoProductFoundException;
import com.adrar.evalspring.exception.ProductNotFoundException;
import com.adrar.evalspring.model.Produit;
import com.adrar.evalspring.repository.ProduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProduitService {

    @Autowired
    private ProduitRepository produitRepository;

    //Méthode pour ajouter un produit
    public Produit saveProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    //Méthode pour récupérer un produit par son ID
    public Produit getProduitById(Long id) {
        if(!produitRepository.existsById(id)) {
            throw new ProductNotFoundException(id);
        }
        return produitRepository.findById(id).get();
    }

    //Méthode pour récupérer tous les produits
    public List<Produit> getAllProduits() {
        if(produitRepository.count() == 0) {
            throw new NoProductFoundException();
        }
        return (List<Produit>) produitRepository.findAll();
    }
}
