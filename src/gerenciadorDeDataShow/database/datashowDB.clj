(ns gerenciadorDeDataShow.database.datashowDB 
  (:require
    [next.jdbc :as jdbc]
    [gerenciadorDeDataShow.database.connection :as connection]
   [gerenciadorDeDataShow.models.Datashow :as Datashow]))



(defn create-datashow []
  (jdbc/execute! connection/get-db 
                 ["INSERT INTO datashows () VALUES ()"]
                 :return-keys? true))

(defn read-all-datashows []
  (let [datashows (jdbc/query connection/get-db ["SELECT * FROM datashows"])]
     (map Datashow/newDatashow 
          (map :id datashows))))

(defn delete-datashow [id]
  (jdbc/execute! connection/get-db ["DELETE FROM datashows WHERE id = ?" id]))


