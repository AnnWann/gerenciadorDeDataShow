(ns gerenciadorDeDataShow.controller.aulaController
  (:require
    [gerenciadorDeDataShow.database.aulaDB :as aulaDB]
    [gerenciadorDeDataShow.database.datashowDB :as datashowDB]))

(defn new-aula [matriculaProfessor data horarioInicio horarioFim]
  (aulaDB/create-aula {:data data :horario_inicio horarioInicio :horario_final horarioFim :id_professor matriculaProfessor}))

(defn get-all-aulas []
  ((aulaDB/read-all-aulas)))

(defn get-available-datashow-for-aula [aula-id]
  (let [aula (first (aulaDB/read-aula aula-id)) datashows (datashowDB/read-all-datashows) aulas (aulaDB/read-aula-on-day (:data aula))
        datashowsAlocados (set (map :id aulas))]
    (filter #(not (contains? datashowsAlocados (:id %))) datashows)))

(defn put-datashow-in-aula [datashow-id aula-id]
  (let [aula (first (aulaDB/read-aula aula-id))] 
    (if aula
      (aulaDB/update-aula (assoc aula :id_datashow datashow-id))
      (throw (Exception. (str "Aula com id " aula-id " não encontrada."))))))