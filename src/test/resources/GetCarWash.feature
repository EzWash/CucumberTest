# language: en
# encoding: iso-8859-1
Feature: Ver Información detallada de un Car Wash
  Como Usuario
  Yo quiero ver la información de los Car Washes
  Para poder elegir un servicio con mayor confianza

  Scenario: El usuario puede ver la información general y los servicios regulares como los promocionales
    Given que ingreso al API "http://localhost:8080" para ver CarWash
    And se ubico en la ruta "/api/carwashes/1" para ver CarWash
    And mediante el metodo "GET" para ver CarWash
    When envio su peticion para ver CarWash
    Then obtuvo el CarWash