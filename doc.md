# Documentation des end points de l'API

**1 Ajouter un produit**

- Méthode : POST
- URL : http://localhost/api/produit
- JSON dans le body :

**JSON Valide**
```json
{
  "nom": "Produit 1",
  "description": "Description du produit 1",
  "prix": 10.99,
  "categorie": {
    "id": 1
  }
}
```
- Code de statut : 201 CREATED

**JSON Invalide**
```json
{
  "nom": "",
  "prix": -1.00,
  "categorie": {
    "id": 1
  }
}
```
- Code de statut : 400 BAD REQUEST

**2 Afficher tous les produits**

- Méthode : GET
- URL : http://localhost/api/produits
- Code de statut : 200 OK

**3 Afficher un produit par son ID**

- Méthode : GET
- URL : http://localhost/api/produit/{id}
- Code de statut : 200 OK
