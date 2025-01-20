(ns gerenciadorDeDataShow.database.aulaDB 
  (:require
   [next.jdbc :as jdbc]
   [gerenciadorDeDataShow.database.connection :as connection]))

(defn create-aula [aula]
  (jdbc/execute! connection/get-db
                 ["INSERT INTO aula (data, horario_inicio, horario_fim, id_professor) VALUES (?, ?, ?, ?)"
                  (:data aula) (:horario_inicio aula) (:horario_final aula) (:id_professor aula)]
                 :return-keys? true))

(defn read-aula [id] 
  (jdbc/query connection/get-db ["SELECT * FROM aula WHERE id = ?" id]))

(defn read-aula-on-day [data]
  (jdbc/query connection/get-db ["SELECT * FROM aula WHERE data = ?" data]))

(defn update-aula [aula]
  (jdbc/execute! connection/get-db ["UPDATE aula SET data = ?, horario_inicio = ?, horario_fim = ?, id_professor = ? WHERE id = ?" (:data aula) (:horario_inicio aula) (:horario_final aula) (:id_professor aula) (:id aula)]))

(defn delete-aula [id]
  (jdbc/execute! connection/get-db ["DELETE FROM aula WHERE id = ?" id]))



