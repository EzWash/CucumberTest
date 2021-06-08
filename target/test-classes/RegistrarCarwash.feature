# language: en
# encoding: iso-8859-1
Feature: Registrar datos generales del Car Wash
  Como CarWash
  Yo quiero registrarme en la aplicación
  Para obtener usuarios por medio de la aplicación

  Scenario: El usuario intenta registrarse como comprador
    Given que ingreso al API "http://localhost:8080" para agregar - CarWash
    And se ubico en la ruta "/api/carwashes" para agregar - CarWash
    And mediante el metodo "POST" para agregar - CarWash
    And tengo el siguiente CarWash para agregar
      | Name | Description | Name_owner | Location |
      | Esquina12 | 12/11/2020 | FSAD | 5|
    When envio su peticion para agregar - CarWash
    Then se registro CarWash