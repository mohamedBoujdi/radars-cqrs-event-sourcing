# **Gestion de radars de contrôle de vitesse**
Ce projet a pour but de développer une application de gestion de radars de contrôle de vitesse et d'infractions liées à ces dépassements de vitesse.

## **Technologies utilisées**
* Java
* Spring Cloud
* AXON
* Maven
## **Structure du projet**
Le projet est divisé en trois micro-services :

1. Un micro-service de gestion des radars, qui permet de définir chaque radar par son id, sa vitesse maximale et ses coordonnées géographiques.
2. ~~Un micro-service de gestion de l'immatriculation des véhicules, qui permet de définir chaque propriétaire par son id, son nom, sa date de naissance, son email et son adresse, ainsi que chaque véhicule par son id, son numéro de plaque d'immatriculation, sa marque, sa puissance fiscale et son modèle.~~
3. Un micro-service de gestion des infractions, qui permet de définir chaque infraction par son id, sa date, le numéro du radar qui a détecté le dépassement de vitesse, le numéro de plaque d'immatriculation du véhicule, la vitesse du véhicule, la vitesse maximale du radar et le montant de l'infraction.
4. Le projet contient également un module "common-api" qui contient les éléments communs aux différents micro-services, tels que les commandes, les événements, les requêtes, les DTOs, etc.
5. Le projet contient également un module "dicovery-service" qui permet de faire la découverte des différents micro-services.
6. Le projet contient également un module "gateway-service" qui permet de faire le routage des requêtes vers les différents micro-services.
## **Fonctionnalités**
L'application permet de réaliser les opérations suivantes :

* Poster un dépassement de vitesse
* Consulter les infractions d'un propriétaire de véhicule
* Modifier et consulter les données des radars
* Modifier et consulter les données des véhicules et de leurs propriétaires
* Modifier et consulter les données des infractions
## **Utilisation**
Pour utiliser l'application, suivez les étapes suivantes :

Clonez le dépôt Git du projet sur votre ordinateur
```bash
git clone
```
Ouvrez le projet dans votre IDE préféré
Importez le projet en tant que projet Maven
Lancez les trois micro-services en utilisant leurs classes de lancement respectives
Utilisez l'application en envoyant des requêtes HTTP aux différentes API exposées par les micro-services
## **API**
### **Radars**
#### **POST /radars**
Créer un radar
##### **Paramètres**
| Nom | Type | Description |
| --- | --- | --- |
| id | String | Identifiant du radar |
| maxSpeed | Integer | Vitesse maximale du radar |
| latitude | Double | Latitude du radar |
| longitude | Double | Longitude du radar |
##### **Exemple**
```json
{
    "id": "1",
    "maxSpeed": 50,
    "latitude": 48.856614,
    "longitude": 2.3522219
}
```
#### **GET /radars**
Récupérer tous les radars
##### **Exemple**
```json
[
    {
        "id": "1",
        "maxSpeed": 50,
        "latitude": 48.856614,
        "longitude": 2.3522219
    },
    {
        "id": "2",
        "maxSpeed": 50,
        "latitude": 48.856614,
        "longitude": 2.3522219
    }
]
```
#### **GET /radars/{id}**
Récupérer un radar par son id
##### **Paramètres**
| Nom | Type | Description |
| --- | --- | --- |
| id | String | Identifiant du radar |
##### **Exemple**
```json
{
    "id": "1",
    "maxSpeed": 50,
    "latitude": 48.856614,
    "longitude": 2.3522219
}
```
#### **PUT /radars/{id}**
Modifier un radar
##### **Paramètres**
| Nom | Type | Description |
| --- | --- | --- |
| id | String | Identifiant du radar |
##### **Exemple**
```json
{
    "id": "1",
    "maxSpeed": 50,
    "latitude": 48.856614,
    "longitude": 2.3522219
}
```
#### **DELETE /radars/{id}**
Supprimer un radar
##### **Paramètres**
| Nom | Type | Description |
| --- | --- | --- |
| id | String | Identifiant du radar |
### **Véhicules**
#### **POST /vehicles**
Créer un véhicule
##### **Paramètres**
| Nom | Type | Description |
| --- | --- | --- |
| id | String | Identifiant du véhicule |
| plateNumber | String | Numéro de plaque d'immatriculation du véhicule |
| brand | String | Marque du véhicule |
| power | Integer | Puissance fiscale du véhicule |
| model | String | Modèle du véhicule |
##### **Exemple**
```json
{
    "id": "1",
    "plateNumber": "AB-123-CD",
    "brand": "Renault",
    "power": 5,
    "model": "Clio"
}
```
#### **GET /vehicles**
Récupérer tous les véhicules
##### **Exemple**
```json
[
    {
        "id": "1",
        "plateNumber": "AB-123-CD",
        "brand": "Renault",
        "power": 5,
        "model": "Clio"
    },
    {
        "id": "2",
        "plateNumber": "AB-123-CD",
        "brand": "Renault",
        "power": 5,
        "model": "Clio"
    }
]
```
#### **GET /vehicles/{id}**
Récupérer un véhicule par son id
##### **Paramètres**
| Nom | Type | Description |
| --- | --- | --- |
| id | String | Identifiant du véhicule |

##### **Exemple**
```json
{
    "id": "1",
    "plateNumber": "AB-123-CD",
    "brand": "Renault",
    "power": 5,
    "model": "Clio"
}
```
#### **PUT /vehicles/{id}**
Modifier un véhicule
##### **Paramètres**
| Nom | Type | Description |
| --- | --- | --- |
| id | String | Identifiant du véhicule |
    
##### **Exemple**
```json
{
    "id": "1",
    "plateNumber": "AB-123-CD",
    "brand": "Renault",
    "power": 5,
    "model": "Clio"
}
```
#### **DELETE /vehicles/{id}**
Supprimer un véhicule
##### **Paramètres**
| Nom | Type | Description |
| --- | --- | --- |
| id | String | Identifiant du véhicule |
### **Propriétaires**
#### **POST /owners**
Créer un propriétaire
##### **Paramètres**
| Nom | Type | Description |
| --- | --- | --- |
| id | String | Identifiant du propriétaire |
| firstName | String | Prénom du propriétaire |
| lastName | String | Nom du propriétaire |
| address | String | Adresse du propriétaire |
| postalCode | String | Code postal du propriétaire |
| city | String | Ville du propriétaire |
| country | String | Pays du propriétaire |
##### **Exemple**
```json
{
    "id": "1",
    "firstName": "John",
    "lastName": "Doe",
    "address": "1 rue de la Paix",
    "postalCode": "75001",
    "city": "Paris",
    "country": "France"
}
```
#### **GET /owners**
Récupérer tous les propriétaires
##### **Exemple**
```json
[
    {
        "id": "1",
        "firstName": "John",
        "lastName": "Doe",
        "address": "1 rue de la Paix",
        "postalCode": "75001",
        "city": "Paris",
        "country": "France"
    },
    {
        "id": "2",
        "firstName": "John",
        "lastName": "Doe",
        "address": "1 rue de la Paix",
        "postalCode": "75001",
        "city": "Paris",
        "country": "France"
    }
]
```
#### **GET /owners/{id}**
Récupérer un propriétaire par son id
##### **Paramètres**
| Nom | Type | Description |
| --- | --- | --- |
| id | String | Identifiant du propriétaire |
##### **Exemple**
```json
{
    "id": "1",
    "firstName": "John",
    "lastName": "Doe",
    "address": "1 rue de la Paix",
    "postalCode": "75001",
    "city": "Paris",
    "country": "France"
}
```
#### **PUT /owners/{id}**
Modifier un propriétaire
##### **Paramètres**
| Nom | Type | Description |
| --- | --- | --- |
| id | String | Identifiant du propriétaire |
##### **Exemple**
```json
{
    "id": "1",
    "firstName": "John",
    "lastName": "Doe",
    "address": "1 rue de la Paix",
    "postalCode": "75001",
    "city": "Paris",
    "country": "France"
}
```
#### **DELETE /owners/{id}**
Supprimer un propriétaire
##### **Paramètres**
| Nom | Type | Description |
| --- | --- | --- |
| id | String | Identifiant du propriétaire |
### **Infractions**
####  ** Je n'ai pas encore cette partie dans mon projet**
