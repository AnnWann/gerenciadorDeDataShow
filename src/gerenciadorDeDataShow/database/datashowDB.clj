(ns gerenciadorDeDataShow.database.datashowDB 
  (:require
   [next.jdbc :as jdbc]
   [gerenciadorDeDataShow.database.connection :as connection]
   [gerenciadorDeDataShow.models.Datashow :as dt]))



(defn create-datashow []
  (jdbc/execute! connection/get-db 
                 ["INSERT INTO datashows () VALUES ()"]
                 :return-keys? true))

(defn read-all-datashows []
  (let [datashows (jdbc/execute! connection/get-db ["SELECT * FROM datashows"])]
     (map (fn [row] (dt/->Datashow (:id row))) datashows)))

(defn delete-datashow [id]
  (jdbc/execute! connection/get-db ["DELETE FROM datashows WHERE id = ?" id]))





