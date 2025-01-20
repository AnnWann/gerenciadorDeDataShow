(ns gerenciadorDeDataShow.database.datashowDB 
  (:require
    [next.jdbc :as jdbc]
    [gerenciadorDeDataShow.database.connection :as connection]))



(defn create-datashow []
  (jdbc/execute! connection/get-db 
                 ["INSERT INTO datashows () VALUES ()"]
                 :return-keys? true))

(defn read-all-datashows []
  (jdbc/query connection/get-db ["SELECT * FROM datashows"]))

(defn delete-datashow [id]
  (jdbc/execute! connection/get-db ["DELETE FROM datashows WHERE id = ?" id]))


