(ns gerenciadorDeDataShow.controller.professorController
  (:require
    [gerenciadorDeDataShow.database.professorDB :as professorDB]
    [gerenciadorDeDataShow.view.view :as view]))

(defn new-professor [nome] 
  (let [matricula (hash nome)]
    (professorDB/create-professor {:matricula matricula :nome nome})
    (view/log "Professor adicionado com sucesso!")
    (view/log (str "Matricula: " matricula))))

(defn get-all-professors []
  (let [professors (professorDB/read-all-professors)]
    (view/log "Listando professores: ")
    (doseq [professor professors]
      (view/show-professor professor))))

(defn erase-professor [id]
  (professorDB/delete-professor id)
  (view/log "Professor removido com sucesso!"))
