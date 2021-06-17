# language: en
# encoding: iso-8859-1
Feature: Ver Contratos activos
  Como dueño de un Car Wash
  Quiero visualizar los contratos activos
  Para poder gestionarlos y mantener informados a mis clientes

  Scenario: El usuario visualiza contratos activos
    Given que ingreso al API "http://localhost:8080" para ver Contratos activos
    And se ubico en la ruta "/api/contracts/states/state" para ver Contratos activos
    And mediante el metodo "GET" para ver Contratos activos
    When envio su peticion para ver Contratos activos
    Then obtuvo los Contratos Activos