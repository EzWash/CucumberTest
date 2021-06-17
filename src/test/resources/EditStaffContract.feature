# language: en
# encoding: iso-8859-1

Feature: Editar trabajador al contrato
  Como dueño de un Car Wash
  Quiero designar un empleado a un contrato
  Para que recoja el vehículo del usuario desde su ubicación

  Scenario: El usuario asigna un trabajador a un contrato
    Given que ingreso al API "http://localhost:8080" para actualizar Trabajador del contrato
    And se ubica en la ruta "/contracts/1/staff/2" para actualizar Trabajador del contrato
    And mediante el metodo "PUT" para actualizar Trabajador del contrato
    And tengo el siguiente formulario para actualizar Trabajador del contrato
    When envio su peticion para actualizar Trabajador del contrato
    Then se actualiza el Trabajador del contrato