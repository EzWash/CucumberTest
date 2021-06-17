# language: en
# encoding: iso-8859-1
Feature: Ver los servicios que ofrece el Car Wash
  Como dueño de un CarWash
  Quiero visualizar los servicios que ofrece mi establecimiento
  Para poder gestionarlos

  Scenario: El usuario visualiza servicios ofrecidos
    Given que ingreso al API "http://localhost:8080" para obtener servicios_carwashID
    And se ubico en la ruta "/carwashes/1/service" para obtener servicios_carwashID
    And mediante el metodo "GET" para obtener servicios_carwashID
    When envio su peticion para obtener servicios_carwashID
    Then obtuvo la lista de Servicios por ID del CarWash