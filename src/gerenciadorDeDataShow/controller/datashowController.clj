(ns gerenciadorDeDataShow.controller.datashowController
  (:require
    [gerenciadorDeDataShow.database.datashowDB :as datashowDB]))

(defn newDatashow []
  (datashowDB/create-datashow))

(defn eraseDatashow [id]
  (datashowDB/delete-datashow id))