(ns gerenciadorDeDataShow.controller.datashowController
  (:require
   [gerenciadorDeDataShow.database.datashowDB :as datashowDB]))

(defn new-datashow []
  (datashowDB/create-datashow))

(defn get-all-datashows []
  (datashowDB/read-all-datashows))

(defn erase-datashow [id]
  (datashowDB/delete-datashow id))

