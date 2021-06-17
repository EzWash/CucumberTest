# language: en
# encoding: iso-8859-1
Feature: Ver datos de los trabajadores de un CarWash
  Como dueño de un CarWash
  Quiero visualizar los trabajadores que tengo registrados
  Para poder gestionarlos

  Scenario: El usuario visualiza trabajadores registrados
    Given que ingreso al API "http://localhost:8080" para obtener trabajadores_carwashID
    And se ubico en la ruta "/api/carwashes/1/staff" para obtener trabajadores_carwashID
    And mediante el metodo "GET" para obtener trabajadores_carwashID
    When envio su peticion para obtener trabajadores_carwashID
    Then obtuvo la lista de Trabajadores por ID del CarWash