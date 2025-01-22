(ns view
  (:require [controller.ProfessorController :as professorController]
            [controller.DatashowController :as datashowController]
            [controller.AulaController :as aulaController]
            [clojure.string :as str]))

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
  (println "9. Atualizar Aula")
  (println "10. Remover Aula")
  (println "11. Sair")
  (println "Escolha uma opção:"))

(defn handle-input [choice]
  (case choice
    "1" (do
          (log "Digite o nome do professor:")
          (let [nome (read-line)]
            (log "Digite a matrícula:")
            (let [matricula (read-line)]
              (professor-controller/newProfessor nome matricula)
              (log "Professor adicionado!"))))
    "2" (do
          (log "Digite a matrícula do professor para remover:")
          (let [matricula (read-line)]
            (professor-controller/eraseProfessor matricula)
            (log "Professor removido!")))
    "3" (do
          (log "Lista de Professores:")
          (let [professores (professor-controller/getAllProfessors)]
            (doseq [professor professores]
              (show-professor professor))))
    "4" (do
          (datashow-controller/newDatashow)
          (log "Datashow adicionado!"))
    "5" (do
          (log "Digite o ID do datashow para remover:")
          (let [id (read-line)]
            (datashow-controller/eraseDatashow id)
            (log "Datashow removido!")))
    "6" (do
          (log "Lista de Datashows:")
          (let [datashows (datashow-controller/getAllDatashows)]
            (doseq [datashow datashows]
              (show-datashow datashow))))
    "7" (do
          (log "Digite a matrícula do professor:")
          (let [matricula (read-line)]
            (log "Digite a data da aula:")
            (let [data (read-line)]
              (log "Digite o horário de início:")
              (let [inicio (read-line)]
                (log "Digite o horário de término:")
                (let [fim (read-line)]
                  (aula-controller/newAula ())
                  (log "Aula criada!"))))))
    "8" (do
          (log "Lista de Aulas:")
          (let [aulas (aula-controller/getAllAulas)]
            (doseq [aula aulas]
              (show-aula aula))))
    "9" (log "Função de atualizar aulas não implementada ainda.")
    "10" (log "Função de remover aulas não implementada ainda.")
    (log "Opção inválida.")))
