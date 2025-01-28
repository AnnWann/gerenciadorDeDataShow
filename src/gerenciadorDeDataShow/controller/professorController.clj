(ns gerenciadorDeDataShow.controller.professorController
  (:require
    [gerenciadorDeDataShow.database.professorDB :as professorDB]))

(defn new-professor [nome] 
  (let [matricula (hash nome)]
    (professorDB/create-professor {:matricula matricula :nome nome})
    matricula))

(defn get-all-professors []
  (professorDB/read-all-professors))

(defn erase-professor [id]
  (professorDB/delete-professor id))
