(ns gerenciadorDeDataShow.controller.professorController
  (:require
    [gerenciadorDeDataShow.database.professorDB :as professorDB]))

(defn getProfessor [id]
  (first (professorDB/read-professor id)))

(defn newProfessor [nome matricula]
  (professorDB/create-professor {:nome nome :matricula matricula}))

(defn eraseProfessor [id]
  (professorDB/delete-professor id))
