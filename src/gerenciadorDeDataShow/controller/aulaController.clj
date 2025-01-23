(ns gerenciadorDeDataShow.controller.aulaController
  (:require
    [gerenciadorDeDataShow.database.aulaDB :as aulaDB]
    [gerenciadorDeDataShow.database.datashowDB :as datashowDB]
    [gerenciadorDeDataShow.view.view :as view]))

(defn new-aula [matriculaProfessor data horarioInicio horarioFim]
  (aulaDB/create-aula {:data data :horario_inicio horarioInicio :horario_final horarioFim :id_professor matriculaProfessor}))

(defn get-all-aulas []
  (let [aulas (aulaDB/read-all-aulas)]
    (view/log "Listando aulas: ")
    (doseq [aula aulas]
      (view/show-aula aula))))

(defn get-available-datashow-for-aula [aula-id]
  (let [aula (first (aulaDB/read-aula aula-id)) datashows (datashowDB/read-all-datashows) aulas (aulaDB/read-aula-on-day (:data aula))]
    (if (empty? aulas)
      (view/log "Não há aulas marcadas para este dia.")
      (let [datashowsAlocados (set (map :id aulas)) datashowsDisponiveis (filter #(not (contains? datashowsAlocados (:id %))) datashows)]
        (view/log "Listando datashows disponíveis para aula: ")
        (doseq [datashow datashowsDisponiveis]
          (view/show-datashow datashow))))))

(defn put-datashow-in-aula [datashow-id aula-id]
  (let [aula (first (aulaDB/read-aula aula-id))] 
    (if aula
      (do (aulaDB/update-aula (assoc aula :id_datashow datashow-id))
          (view/log "Datashow alocado com sucesso."))
      (throw (Exception. (str "Aula com id " aula-id " não encontrada."))))))