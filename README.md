### Setup con Eclipse

Clonare la repository in locale, aprire il progetto su Eclipse, eseguire `Maven Install` per il setup delle dependencies e la compilazione dei sorgenti. Avviare poi l’applicazione su un server a piacere, nella fase di test è stato utilizzato Apache Tomcat.

### Setup con Github Codespace

NB: è necessario aver effettuato l’accesso su Github;

NB2: il servizio comprende dei costi, ma ogni account, anche free, ha delle soglie fino alle quali non c’è bisogno di nessun pagamento. Per le modifiche richieste le soglie sono oltre che sufficienti a livello di tempistiche, informarsi meglio sulla [documentazione](https://docs.github.com/en/billing/managing-billing-for-your-products/managing-billing-for-github-codespaces/about-billing-for-github-codespaces).

Andare su Code e creare una codespace su main.
Github imposterà quindi tutto l’environment, aprendo in una tab separata l’ambiente di sviluppo (circa 2 minuti di esecuzione), mettendo a disposizione anche un terminale per eseguire comandi Linux.
Per avviare la web application eseguire nel terminale il comando
```bash
chmod +x mvnw && ./mvnw spring-boot:run
```
Uscirà poi un pop-up che permette di aprire il sito web nel browser per una facile interazione con l’applicativo.

### Setup con IntelliJ

Ho semplicemente scaricato il progetto da IntelliJ, ho modificato il pom affinchè il server embedded fosse usato (non volevo scaricare un server), la parte successiva è uguale ad Eclipse.
Gli screenshot dimostrano un utilizzo dell'applicazione nel caso non fosse immediata la riproduzione dei risultati.