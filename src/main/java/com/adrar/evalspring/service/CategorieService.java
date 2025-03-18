package com.adrar.evalspring.service;

import com.adrar.evalspring.exception.CategorieNotFoundException;
import com.adrar.evalspring.exception.NoCategorieFoundException;
import com.adrar.evalspring.model.Categorie;
import com.adrar.evalspring.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {

    @Autowired
    private CategorieRepository categorieRepository;

    //Méthode pour ajouter une categorie
    public Categorie saveCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    //Méthode pour recupérer une catégorie par son ID
    public Categorie getCategorieById(Long id) {
        if(!categorieRepository.existsById(id)) {
            throw new CategorieNotFoundException(id);
        }
        return categorieRepository.findById(id).get();
    }

    //Méthode pour récupérer toutes les catégories
    public List<Categorie> getAllCategories() {
        if(categorieRepository.count() == 0) {
            throw new NoCategorieFoundException();
        }
        return (List<Categorie>) categorieRepository.findAll();
    }
}
