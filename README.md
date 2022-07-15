# **DEVELHOPE GAMES**

L’applicativo consiste in un backend dove gli sviluppatori possono pubblicare i loro giochi, e dove gli utenti possono aggiungere giochi alla propria libreria, pubblicare recensioni, e voti.

Il backend è utilizzabile tramite API RESTful, che mette a disposizione metodi per visualizzare, inserire, modificare e cancellare giochi e recensioni (CRUD), creare le proprie librerie, navigare tra le recensioni con numerosi filtri e ottenere alcuni insight statistici.
Come tecnologia abbiamo utilizzato Java 17, con design pattern MVC realizzando l’API con Spring Web e la connessione al database con Spring Data JPA. Il database utilizzato per lo storage dei dati è un database MySQL.

Una volta lanciata l’applicazione l’API è disponibile all’indirizzo.[http://localhost:8080](http://localhost:8080). Tutte le operazioni disponibili sono raggiungibili agli indirizzi elencati di seguito in opportune chiamate GET, POST, PUT o DELETE. Prima di lanciare l’applicazione è necessario specificare nel file resources/application.properties l’indirizzo di un’istanza di MySQL da utilizzare come database.

Abbiamo corredato la nostra applicazione con i Framework HAL per renderlo più user friendly e il framework Swagger per poter documentare le API REST.

> HAL explorer: [http://localhost:8080/](http://localhost:8080/) (utilizzato per rendere il progetto più user friendly).

> Swagger ui: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html) (per avere la possibilità di visionare la documentazione API anche attraverso browser).

Nelle pagine seguenti è possibile trovare la documentazione delle chiamate create con le relative descrizioni.

# **User**

Tabella contenente i dati degli utenti.

### **SCHEMA**

	{
	"id": 0,
    "name": "string",
    "surname": "string",
    "playerName": "string",
    "mail": "string",
    "birth": "2022-06-27T19:19:23.270Z",
    "subscription": "string",
    "userWallet": 0,
    "country": "string"
	}

  


### **GET**

 - /user 

	> Otteniamo una lista di tutti gli utenti presenti nel database.

 - /user/{id}

	> Otteniamo un utente specificando il suo numero id.

 - /user/game/{id}
	> Otteniamo tutti gli utenti che possiedono un gioco specificando l’id del gioco.

### **POST**

 - /user 
	> Aggiungiamo un utente al database specificando tutti i suoi dati nel “body”.

### **PUT**

 - /user 
	> Modifichiamo un utente scrivendo nel “body” sia i dati che abbiamo modificato sia quelli senza modifiche. In questo caso dobbiamo anche aggiungere (sempre nel body) l’id univoco dell’utente che intendiamo modificare.

### **DELETE**

 - /user/{id} 
	> Eliminiamo un utente dal database specificando il suo numero “id”.
	
# **Game**

Tabella che contiene i dati relativi ai giochi storati nel DB.

### **SCHEMA**

	{
    "id": 0,
    "name": "string",
    "description": "string",
    "developer": "string",
    "price": 0,
    "releaseDate": "2022-06-27T19:20:00.223Z",
    "category": "string",
    "language": "string",
    "systemRequirements": "string"
	}


### **GET**

 - /game 

	> Otteniamo una lista di tutti i giochi presenti nel database.

 - /game/{id}

	> Otteniamo un gioco specificando il suo numero id.

 - /game/user/{id}
	> Otteniamo tutti i giochi che possiede un utente specificando l’id dell’utente.

### **POST**

 - /game 
	> Aggiungiamo un gioco al database specificando tutti i suoi dati nel “body”.

### **PUT**

 - /game 
	> Modifichiamo un gioco scrivendo nel “body” sia i dati che abbiamo modificato sia quelli senza modifiche. In questo caso dobbiamo anche aggiungere (sempre nel body) l’id univoco del gioco che intendiamo modificare.

### **DELETE**

 - /game/{id} 
	> Eliminiamo un gioco dal database specificando il suo numero “id”.
	
# **Review**

Tabella che contiene i commenti, il voto ed un collegamento ai giochi e all’utente.

### **SCHEMA**

	{
    "id": 0,
    "comment": "string",
    "votes": "string",
	}


### **GET**

 - /review 

	> Otteniamo una lista di tutte le recensioni presenti nel database.

 - /review/{id}

	> Otteniamo una recensione specificando il suo numero id.

 - /review/allvotesaverage
	> Otteniamo la media di tutti i voti di tutti i giochi presenti nel database.

 - /review/avgvotes/{id}

	> Otteniamo la media dei voti di un gioco specificando l’id del gioco.

 - /review/votes

	> Otteniamo tutti i voti di tutti i giochi presenti nel database.

 - /review/votes/{id}
	> Otteniamo tutti i singoli voti di un gioco specificando l’id del gioco.
	
- /review/games/{id}
	> Otteniamo tutte le recensioni di un gioco specificando l’id del gioco.
	
- /review/user/{id}
	> Otteniamo tutte le recensioni di un utente specificando l’id dell’utente.


### **POST**

 - /review 
	> Aggiungiamo una recensione al database specificando tutti i suoi dati nel “body”. Dobbiamo inoltre specificare quale utente sta lasciando la recensione e a quale gioco è riferita.

### **PUT**

 - /review 
	> Modifichiamo una recensione scrivendo nel “body” sia i dati che abbiamo modificato sia quelli senza modifiche. In questo caso dobbiamo anche aggiungere (sempre nel body) l’id univoco della recensione che intendiamo modificare.

### **DELETE**

 - /review/{id} 
	> Eliminiamo una recensione dal database specificando il suo numero “id”.

# **Library (UserGame)**

Questa è una tabella che ha lo scopo di collegare tra loro gli utenti e i giochi e ci permette di poter gestire le librerie di ogni singolo utente aggiungendo ed eliminando giochi.

### **POST**

- /library

	> Aggiungiamo un gioco ad un utente andando a specificare sia l’id del gioco che intendiamo aggiungere sia l’id dell’utente che deve riceverlo.


### **DELETE**

- /library

	> Eliminiamo un gioco dall’utente andando a specificare sia l’id del gioco che intendiamo rimuovere sia l’id dell’utente da cui deve essere rimosso.