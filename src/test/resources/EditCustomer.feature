# language: en
# encoding: iso-8859-1

Feature: Editar datos personales del Usuario
  Como usuario
  quiero actualizar mis datos personales
  Para poder aprovechar mejor las recomendaciones que la aplicación me pueda otorgar

  Scenario: El usuario pudo editar sus datos personales con exito
    Given que ingreso al API "http://localhost:8080" para actualizar datos del Usuario
    And se ubica en la ruta "/api/users/1" para actualizar datos del Usuario
    And mediante el metodo "PUT" para actualizar datos del Usuario
    And tengo el siguiente formulario para actualizar datos del Usuario
      | First_Name | Last_Name | Email | Phone | Gender | Password | Location |
      | Roberto | Vega |  terl@hotmail.com |987654321|M       | rBT      | 6       |

    When envio su peticion para actualizar datos del Usuario
    Then se actualiza los datos del Usuario