# language: en
# encoding: iso-8859-1
Feature: Ver comentarios y nivel de calidad de un Car Wash
    Como Usuario
    quiero ver la opinión de otros usuarios que usaron el servicio de un Car Wash
    Para saber el trato del Car Wash

    Scenario: El usuario puede ver los comentarios de un Car Wash
        Given que ingreso al API "http://localhost:8080" para obtener comentarios
        And se ubico en la ruta "/api/users/carwashes/1" para obtener comentarios
        And mediante el metodo "GET" para obtener comentarios
        When envio su peticion para obtener comentarios
        Then obtuvo la lista de Comentarios de un CarWash