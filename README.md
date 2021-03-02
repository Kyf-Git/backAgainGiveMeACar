# <p style="text-align:center;"> Give me a car</br>Back-end</p>

<p style="text-align:right;"> <i>Restitution par Franck Isambert.</i></p>

<br>
<br>


## Présentation :

### <u>1. La base de données relationnelle</u>

A partir d'un **diagramme EER** sur **MySQL Workbench**, puis d'un "Forward Engineering", nous générons un script de création de table.
A l'exécution du script, 3 tables (avec leurs relations, __*OneToOne*__, __*OneToMany*__/__*ManyToOne*__) sont créees :

**<li>Agence</li>**
**<li>Adresse</li>**
**<li>Vehicule</li>**

<br>

### <u>2. Configuration de Spring Boot</u>


#### pom.xml :

Fichier xml utilisé pour le pilotage de Maven.<br>
Il contient: 
* des élements d'identifications de notre projet,
* la configuration Spring Boot,
* les propriétés pour le projet,
* les dépendances vers les librairies utiles au projet :

  * __*spring-boot-starter-data-jpa*__ : Intégre __JPA/Hibernate__.
  * __*spring-boot-starter-web*__ : Convertit le __JSON__ en objet __Java__ et vice versa.
  * __*spring-boot-devtools*__ : Prend en compte instantanément toute modification et relance automatiquement l'application.
  * __*mysql-connector-java*__ : Permet la connection de __MySQL__ à l'API.
  * __*spring-boot-starter-test*__ : Dépendance principale permettant de réaliser les tests.
  * __*spring-boot-starter-validation*__ : Permet l'utilisation de l'annotation __@Valid__.

<br>

#### application.properties :

Fichier de propriété java classique (clés/valeurs).

__Contient toutes les informations de configuration des composants utilisés par le projet__. Prenons l'exemple de la connexion à la base de données, afin que Spring Boot puisse s'y connecter vous devez le configurer dans le fichier __applications.properties__ :
<br>

`spring.datasource.url=jdbc:mysql://givemeacar00.cwjwn3kucajv.eu-west-3.rds.amazonaws.com/franck`

<br>

### <u>3. Les différents packages</u>

Pour chaque classe, nous avons un contrôleur, un service, un modèle et un repository. Chacun de ces rôles est établi dans un package, __chaque traitement va être cloisonné__.<br>

C'est le principe de l'__AOP__ (Aspect Oriented Programming), permettre de séparer la couche technique de la couche métier. C’est un modèle de programmation qui en complète un autre, dans notre cas l'__OOP__ (Object Oriented Programming).

<br>

#### Le model : 

__@Entity__<br>
__DAO__ (Data Access Object), __c'est le moule de notre entité__ (la classe) et tous ses attributs. Chaque classe correspond à une table et chaque attribut correspond à un champ. __C'est également ici que sont renseignées les relations__. Il permet l'accès aux données.

<br>

#### Le repository : 

__@Repository__<br>
__DTO__ (Data Transfert Object), __fait le lien avec la base de données, envoie et reçoit les requêtes__. C'est ici que sont lu et écrit les enregistrements de la base de données et est renseigné le modèle (dans notre cas grâce à __JpaRepository__). Par un système d'injection de dépendance (__DI__), Spring trouve dans son architecture la bonne classe qui est capable d'exécuter la requête SQL.

<br>

#### Le service :

__@Service__<br>
Représente la couche métier (le coeur du logiciel). __C'est ici qu'on décrit le comportement de la classe__. Le service est appelé par le __controller__ et agit sur le __model__.

<br>

#### Le controller :

__@RestController__<br>
Fournit les services Web, __gère les interactions et la couche métier__. Il fait le lien entre le __client__ et le __model__ par le biais des méthodes du __service__ puis renvoie les données (généralement du __XML__ ou du __Json__) dans le __response body HTTP__.

<br>

### <u>3. Les requêtes</u>

__End-points de l'application__ :

<br>

__GET__ :<br>
_Récupére toutes les agences._<br>
`http://localhost:8080/agences`<br>

_Récupére une agence par son ID._<br>
`http://localhost:8080/agences/{id}`<br>

_Récupére toutes les adresses._<br>
`http://localhost:8080/adresses`<br>

_Récupére toutes les véhicules._<br>
`http://localhost:8080/vehicules`<br>

_Récupére un véhicule par son ID._<br>
`http://localhost:8080/vehicules/{id}`<br>

_Récupére toutes les véhicules d'une agence par son ID._<br>
`http://localhost:8080/agences/{id}/vehicules`<br>

<br>

__POST__ :<br>
_Créee une agence._<br>
`http://localhost:8080/agences`<br>

_Créee un véhicule._<br>
`http://localhost:8080/vehicules`<br>

<br>

__PUT__ :<br>
_Met à jour une agence._<br>
`http://localhost:8080/agences/{id}`<br>

_Met à jour un véhicule._<br>
`http://localhost:8080/vehicules/{id}`<br>

<br>

__DELETE__ :<br>
_Efface une agence._<br>
`http://localhost:8080/agences/{id}`<br>

_Efface un véhicule._<br>
`http://localhost:8080/vehicules/{id}`<br>

<br>

### <u>4. Lexique</u>

<br>

#### <a id="def-JPA">JPA/Hibernate</a> : 
__Spring Data JPA__ (Java Persistence API) est une bibliothèque de Spring. C'est __JPA/Hibernate__ qui gère les relations entre les classes. Ces relations sont déclarées dans le modèle au niveau de l'entité (__@Entity__), à l'aide d'annotation.

Ces annotations sont utilisées pour signaler les champs (field) à Spring dans le but de décrire la modélisation (__mapping__) et leurs correspondances avec les colonnes d'une table.

<br>

#### <a>URI</a> : 
Identifiant uniforme de ressources (l'URL est un URI).

<br>

#### <a>HTTP</a> : 
Protocole de transmission permettant à l'utilisateur d'accéder à des pages web par l'intermédiaire d'un navigateur.

<br>

#### <a>ORM</a> : 
Fait la correspondance entre les schémas de la base de données et les classes du programmes applicatif, __"une couche d'abstraction entre le monde objet et le monde relationnel"__.<br>
L'utilisation de __POO__ sur une base de données relationnelle necessite de convertir les données relationnelles en objet et vice versa.

<br>

#### <a>JDBC</a> :
__Java Database Connectivity__, API intégrée à la __JSE__ (Java Standard Edition) pour communiquer avec des base de données relationnelles.

<br>

#### <a>IOC</a> :
__Inversion de contrôle__, __processus définissant les dépendances d'un objet sans avoir à le créer__. C'est lors de la création des objets que Spring va injecter les __beans__ afin d'avoir toutes les dépendances.<br>
Permet de ne pas se soucier de l'instanciation d'autres objets/modules dont il dépend et par conséquent de pouvoir le réutiliser dans d'autre classes.

<br>

#### <a>Bean</a> :
Objet instancié, assemblé et géré par __Spring IOC Container__.

<br>

#### <a>Autowired</a> : 
Lors de l'annotation d'un objet ou d'une méthode avec __@Autowired__, __Spring va instancier automatiquement l'objet lors de l'utilisation__.
Les annotations __@Autowired__ peuvent être positionnées :

* sur un __attribut__,
* sur un __setter__,
* sur une __méthode ayant au moins un paramètre__ (ce sont ces paramètres qui seront injectés),
* sur un __constructeur ayant au moins un paramètre__ (comme pour la méthode).

<br>

#### <a>Primary key</a> :
__Identifiant garantissant l'unicité d'une table__, permettant d'identifier de manière unique chaque ligne de la table (peut être un ID unique généré automatiquement ou un couple de deux champs permettant la génération d'un ID unique).

<br>

#### <a>Foreign key</a> : 
A pour fonction principale la vérification de l'intégrité de votre base. __Permet de définir une relation entre deux tables, et d'assurer la cohérence des données__.

<br>

#### <a>Transaction</a> : 
Dans un contexte de "base de données" une __transaction__ est la mise en oeuvre d'une suite d'opérations qui fait passer la base de données d'un __état A__ à un __état B__.

<br>
