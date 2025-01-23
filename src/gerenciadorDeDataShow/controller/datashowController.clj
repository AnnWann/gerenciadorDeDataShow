(ns gerenciadorDeDataShow.controller.datashowController
  (:require
   [gerenciadorDeDataShow.database.datashowDB :as datashowDB]
   [gerenciadorDeDataShow.view.view :as view]))

(defn new-datashow []
  (let [id (datashowDB/create-datashow)]
    (view/log "Datashow adicionado!")
    (view/log (str "ID: " id))))

(defn get-all-datashows []
  (let [datashows (datashowDB/read-all-datashows)]
    (view/log "Listando datashows: ")
    (doseq [datashow datashows]
      (view/show-datashow datashow))))

(defn erase-datashow [id]
  (datashowDB/delete-datashow id)
  (view/log "Datashow removido!"))

