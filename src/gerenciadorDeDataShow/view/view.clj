(ns gerenciadorDeDataShow.view.view
  (:require [gerenciadorDeDataShow.controller.professorController :as professor-controller]
           [gerenciadorDeDataShow.controller.datashowController :as datashow-controller]
           [gerenciadorDeDataShow.controller.aulaController :as aula-controller]
            [gerenciadorDeDataShow.models.Aula :as Aula]))

(defn show-professor [professor]
  (println "=== Detalhes do Professor ===")
  (println (str "Nome: " (:nome professor)))
  (println (str "Matrícula: " (:matricula professor)))
  (println "============================="))

(defn show-datashow [datashow]
  (println "=== Detalhes do Datashow ===")
  (println (str "ID: " (:id datashow)))
  (println (str "Disponível: " (:disponivel datashow)))
  (println "============================="))

(defn show-aula [aula]
  (println "=== Detalhes da Aula ===")
  (println (str "ID: " (:id aula)))
  (println (str "Professor: " (:professor aula)))
  (println (str "Data: " (:data aula)))
  (println (str "Horário de Início: " (:horarioInicio aula)))
  (println (str "Horário de Fim: " (:horarioFim aula)))
  (println "========================"))

(defn log [message]
  (println message))

(defn show-menu []
  (println "=== Menu Principal ===")
  (println "1. Adicionar Professor")
  (println "2. Remover Professor")
  (println "3. Listar Professores")
  (println "4. Adicionar Datashow")
  (println "5. Remover Datashow")
  (println "6. Listar Datashows")
  (println "7. Criar Aula")
  (println "8. Listar Aulas")
  (println "9. Listar Datashows Disponíveis para Aula")
  (println "10. Alocar Datashow para Aula")
  (println "11. Remover Aula")
  (println "12. Sair")
  (println "Escolha uma opção:"))

(defn handle-input [choice]
  (case choice
    "1" (do
          (log "Digite o nome do professor para adicionar:")
          (let [nome (read-line)]
            (professor-controller/new-professor nome)))
    "2" (do 
          (log "Digite o nome do professor para remover:")
          (let [nome (read-line)]
            (professor-controller/erase-professor (hash nome))))
    "3" (do
          (log "Listando professores: ")
          ((professor-controller/get-all-professors)))
    "4" (do
          (datashow-controller/new-datashow))
    "5" (do
          (log "Digite o ID do datashow para remover:")
          (let [id (read-line)]
            (datashow-controller/erase-datashow id)))
    "6" ((datashow-controller/get-all-datashows))
    "7" (do
          (log "Digite a matrícula do professor:")
          (let [matricula (read-line)]
            (log "Digite a data da aula:")
            (let [data (read-line)]
              (log "Digite o horário de início:")
              (let [inicio (read-line)]
                (log "Digite o horário de término:")
                (let [fim (read-line) aula (Aula/->Aula nil data inicio fim nil matricula)] 
                  (aula-controller/new-aula aula))))))
    "8" (do
          (log "Lista de Aulas:")
          (let [aulas (aula-controller/get-all-aulas)]
            (doseq [aula aulas]
              (show-aula aula))))
    "9" (do
          (log "Digite o ID da aula:")
          (let [id (read-line)]
            (aula-controller/get-available-datashow-for-aula id))
          ) 
    "10" (do
           (log "Digite o ID do datashow:")
           (let [datashow-id (read-line)]
             (log "Digite o ID da aula:")
             (let [aula-id (read-line)]
               (aula-controller/put-datashow-in-aula datashow-id aula-id))))
    "11" (log "Função de remover aulas não implementada ainda.")
    (log "Opção inválida.")))
