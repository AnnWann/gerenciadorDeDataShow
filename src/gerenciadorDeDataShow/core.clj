(ns gerenciadorDeDataShow.core
  (:gen-class)
  (:require
            [gerenciadorDeDataShow.controlador.ProfessorController :as prof-ctrl]
            [gerenciadorDeDataShow.controlador.DatashowController :as ds-ctrl]
            [gerenciadorDeDataShow.controlador.AulaController :as aula-ctrl]
            [gerenciadorDeDataShow.view.View :as view]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (loop []
    (view/showMenu)
    (let [option (read-line)]
      (case option
        "1" (let [nome (do (println "Digite seu nome:") (read-line))
                  matricula (do (println "Digite sua matrícula:") (read-line))]
              (prof-ctrl/cadastrarProfessor nome matricula)
              (println "Professor cadastrado com sucesso!"))

        "2" (let [matricula (do (println "Digite a matrícula do professor:") (read-line))]
              (println (view/showProfessor (prof-ctrl/getProfessor matricula))))
        "3" (let [matricula (do (println "Digite a matricula do professor para deletar:") (read-line))]
              (prof-ctrl/excluirProfessor matricula)
              (println "Professor excluído com sucesso!"))
        "4" (let [Datashow-id (do (println "Digite o id do Datashow:") (read-line))]
              (ds-ctrl/newDatashow Datashow-id)
              (println "Datashow criado com sucesso!"))
        "5" (let [Datashow-id (do (println "Digite o ID do datashow a ser apagado:") (read-line))]
              (ds-ctrl/eraseDatashow Datashow-id)
              (println "Datashow apagado com sucesso!"))
        "6" (let [data (do (println "Digite a data da aula (AAAA-MM-DD):") (read-line))
                  horarioInicio (do (println "Digite o horário de início da aula (HH:MM):") (read-line))
                  horarioFim (do (println "Digite o horário de término da aula (HH:MM):") (read-line))
                  aula-id (do (println "Digite o ID da aula:") (read-line))]
              (aula-ctrl/newAula aula-id data horarioInicio horarioFim)
              (println "Aula criada com sucesso!"))
        "7" (let [aula-id (do (println "Digite o ID da aula:") (read-line))]
              (println (view/showDatashow (aula-ctrl/getAvailableDatashowForAula aula-id)))) 
        "8" (let [datashow-id (do (println "Digite o ID do datashow:") (read-line))
                  aula-id (do (println "Digite o ID da aula:") (read-line))]
              (aula-ctrl/putDatashowInAula datashow-id aula-id)
              (println "Datashow alocado na aula com sucesso!"))
        
         "0" (do (println "Saindo do sistema...") (System/exit 0))
        
         (do (println "Opção inválida, tente novamente.") (recur)))
        
        

        ) ))
