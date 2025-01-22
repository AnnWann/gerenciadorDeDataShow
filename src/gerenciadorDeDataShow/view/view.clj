(ns view
  (:require [controller.ProfessorController :as professorController]
            [controller.DatashowController :as datashowController]
            [controller.AulaController :as aulaController]
            [clojure.string :as str]))

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
          (println "Digite o nome do professor:")
          (let [nome (read-line)]
            (println "Digite a matrícula:")
            (let [matricula (read-line)]
              (professor-controller/newProfessor nome matricula)
              (println "Professor adicionado"))))
    "2" (do
          (println "Digite a matrícula do professor para remover:")
          (let [matricula (read-line)]
            (professor-controller/eraseProfessor matricula)
            (println "Professor removido!")))
    "3" (println "Função de listar professores não implementada ainda.")
    "4" (datashow-controller/newDatashow)
    "5" (do
          (println "Digite o ID do datashow para remover:")
          (let [id (read-line)]
            (datashow-controller/eraseDatashow id)
            (println "Datashow removido")))
    "6" (println "Função de listar datashows não implementada ainda.")
    "7" (do
          (println "Digite a matrícula do professor:")
          (let [matricula (read-line)]
            (println "Digite a data da aula:")
            (let [data (read-line)]
              (println "Digite o horário de início:")
              (let [inicio (read-line)]
                (println "Digite o horário de término:")
                (let [fim (read-line)]
                  (aula-controller/newAula matricula data inicio fim)
                  (println "Aula criada!"))))))
    "8" (println "Função de listar aulas não implementada ainda.")
    "9" (println "Função de atualizar aulas não implementada ainda.")
    "10" (println "Função de remover aulas não implementada ainda.")
    "11" (println "Saindo do programa.")
    (println "Opção inválida.")))

(defn main-loop []
  (loop []
    (show-menu)
    (let [choice (read-line)]
      (if (= choice "11")
        (println "Programa encerrado.")
        (do
          (handle-input choice)
          (recur))))))
