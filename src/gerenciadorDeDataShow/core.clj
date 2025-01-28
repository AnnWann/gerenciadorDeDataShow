(ns gerenciadorDeDataShow.core
  (:gen-class)
  (:require 
   [gerenciadorDeDataShow.view.view :as view]
   [gerenciadorDeDataShow.database.connection :as DB-connection]))


(defn greet
  "I don't do a whole lot ... yet."
  [& args]
  (DB-connection/init-db)
  (loop []
    (view/show-menu)
    (let [choice (read-line)]
      (if (= choice "11")
        ((view/log "Programa encerrado.")
         (System/exit 0))
        (do
          (view/handle-input choice)
          (recur))))))
