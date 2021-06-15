# language: en
# encoding: iso-8859-1
Feature: Ver historial de servicios contratados
    Como Usuario
    quiero un historial de servicios contratados
    Para poder repetirlos o reportarlos de manera sencilla

    Scenario: El usuario tiene servicios contratados en su historial
        Given que ingreso al API "http://localhost:8080" para obtener servicios
        And se ubico en la ruta "/api/users/1/contracts" para obtener servicios
        And mediante el metodo "GET" para obtener servicios
        When envio su peticion para obtener servicios
        Then obtuvo la lista de Servicios de un CarWash