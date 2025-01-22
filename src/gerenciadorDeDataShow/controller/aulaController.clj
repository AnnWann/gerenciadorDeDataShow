(ns gerenciadorDeDataShow.controller.aulaController
  (:require
    [gerenciadorDeDataShow.database.aulaDB :as aulaDB]
    [gerenciadorDeDataShow.database.datashowDB :as datashowDB]
    [controller.ProfessorController :as professorController]
    [controller.DatashowController :as datashowController]
    [controller.AulaController :as aulaController]
    [clojure.string :as str]))

(defn newAula [matriculaProfessor data horarioInicio horarioFim]
  (aulaDB/create-aula {:data data :horario_inicio horarioInicio :horario_final horarioFim :id_professor matriculaProfessor}))

(defn getAvailableDatashowForAula [aula]
  (let [datashows (datashowDB/read-all-datashows)]
    datashows))

(defn putDatashowInAula [datashow_id aula_id]
  (let [aula (first (aulaDB/read-aula aula_id))]
    (if aula
      (aulaDB/update-aula (assoc aula :id_datashow datashow_id))
      (throw (Exception. (str "Aula com id " aula_id " não encontrada."))))))