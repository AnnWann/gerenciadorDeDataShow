(ns gerenciadorDeDataShow.core
  (:gen-class)
  (:require
   [gerenciadorDeDataShow.controlador.ProfessorController :as prof-ctrl]
   [gerenciadorDeDataShow.controlador.DatashowController :as ds-ctrl]
   [gerenciadorDeDataShow.controlador.AulaController :as aula-ctrl]
   [gerenciadorDeDataShow.view.View :as view]
   [gerenciadorDeDataShow.database.connection :as DB-connection]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (DB-connection/init-db)
  (loop []
    (show-menu)
    (let [choice (read-line)]
      (if (= choice "11")
        ((log "Programa encerrado.")
         (db-connection/close-connection)
         (System/exit 0))
        (do
          (handle-input choice)
          (recur))))))
