(ns gerenciadorDeDataShow.database.connection)

(require '[next.jdbc :as jdbc])

(def db {:classname "org.sqlite.JDBC"
         :dbtype "sqlite"
         :dbname "database.db"
         :host :none})

(def ds (jdbc/get-datasource db))

(defn init-db [] 
  (jdbc/execute! ds [
                     "CREATE TABLE IF NOT EXISTS datashows (
                    id INTEGER PRIMARY KEY AUTOINCREMENT);
                    
                    CREATE TABLE IF NOT EXISTS professor (
                     matricula INTEGER PRIMARY KEY,
                     nome TEXT)
                    
                    CREATE TABLE IF NOT EXISTS AULA (
                     id INTEGER PRIMARY KEY AUTOINCREMENT,
                     data TEXT,
                     hora TEXT,
                     id_professor INTEGER,
                     id_datashow INTEGER,
                     FOREIGN KEY (id_professor) REFERENCES professor(matricula),
                     FOREIGN KEY (id_datashow) REFERENCES datashows(id))"]))


(defn get-db [] ds)


                    
