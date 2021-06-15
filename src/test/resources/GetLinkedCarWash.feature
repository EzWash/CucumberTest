# language: en
# encoding: iso-8859-1
Feature: Ver lista de preferidos de un Usuario
  Como Usuario
  Yo quiero ver la lista de Car Washes preferidos que he elegido
  Para poder seleccionar uno de ellos

  Scenario: El usuario puede ver cada Car Wash de su lista de preferidos
    Given que ingreso al API "http://localhost:8080" para ver user_carwash
    And se ubico en la ruta "/api/users/1/carwashes" para ver user_carwash
    And mediante el metodo "GET" para ver user_carwash
    When envio su peticion para ver user_carwash
    Then obtuvo lista de preferidos_CarWash