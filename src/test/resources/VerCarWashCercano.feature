# language: en
# encoding: iso-8859-1
Feature: Ver Car Wash cercanos
  Como Usuario
  Yo quiero ver los Car Wash más cercanos a mi ubicación
  Para poder solicitar el servicio de uno de ellos

  Scenario: El usuario puede ver Car Wash cercanos a su ubicacion
    Given que ingreso al API "http://localhost:8080" - user_carwash
    And se ubico en la ruta "/api/carwashes/12.114006/-77.0070258/1" - user_carwash
    And mediante el metodo "GET" - user_carwash
    When envio su peticion - user_carwash
    Then obtuvo la lista de CarWashes - user_carwash