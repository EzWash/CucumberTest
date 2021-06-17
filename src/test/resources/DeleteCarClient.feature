# language: en
# encoding: iso-8859-1
Feature: Eliminar el auto del cliente
  Como Usuario
  Quiero eliminar uno o más autos de mi lista
  Para mantener actualizada mi lista a los autos que mantengo en mi posesion

  Scenario: El usuario elimina su auto con exito
    Given que ingreso al API "http://localhost:8080" para eliminar carro del cliente
    And se ubico en la ruta "/api/vehicles/1/customer" para eliminar carro del cliente
    And mediante el metodo "DELETE" para eliminar carro del cliente
    When envio su peticion para eliminar carro del cliente
    Then se elimino el carro del cliente