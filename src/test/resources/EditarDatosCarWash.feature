# language: en
# encoding: iso-8859-1
Feature: Editar datos generales del Car Wash
  Como Car Wash
  quiero editar mis datos generales
  Para mantenerlos actualizados en el tiempo

  Scenario: El Car Wash pudo editar sus datos con exito
    Given que ingreso al API "http://localhost:8080/api" para actualizar datos del CarWash
    And se ubica en la ruta "/carwashes/1" para actualizar datos del CarWash
    And mediante el metodo "PUT" para actualizar datos del CarWash
    And tengo el siguiente formulario para actualizar datos del CarWash
      | Description | Name | Name_owner | Location|
      |  Todo bonito | Todo limpio| Pabdsao Escobr |1|

    When envio su peticion para actualizar datos del CarWash
    Then se actualiza los datos del CarWash