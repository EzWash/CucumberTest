# language: en
# encoding: iso-8859-1

Feature: Editar Servicios de un Car Wash
  Como Car Wash
  quiero editar mis servicios
  Para mantenerlos actualizados en el tiempo o eliminarlos

  Scenario: El Car Wash pudo editar su servicio con éxito
    Given que ingreso al API "http://localhost:8080" para actualizar datos del Servicio
    And se ubica en la ruta "/api/carwashes/1/services/1" para actualizar datos del Servicio
    And mediante el metodo "PUT" para actualizar datos del Servicio
    And tengo el siguiente formulario para actualizar datos del Servicio
      | Name | Description | Details | Is_promotion | Price |
      | Ro | Vega |  terocal@hotmail.com |0|30.0       |

    When envio su peticion para actualizar datos del Servicio
    Then se actualiza los datos del Servicio