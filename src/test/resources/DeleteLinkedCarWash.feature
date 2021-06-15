# language: en
# encoding: iso-8859-1
Feature: Remover un Car Wash de la lista de preferidos de un Usuario
  Como Usuario
  Yo quiero remover un Car Wash de la lista de preferidos
  Para solo mantener los Car Wash que me interesan en mi lista

  Scenario: El usuario removió un Car Wash de su lista de preferidos
    Given que ingreso al API "http://localhost:8080" para eliminar de favoritos
    And se ubico en la ruta "/api/users/17/carwashes/21" para eliminar de favoritos
    And mediante el metodo "DELETE" para eliminar de favoritos
    When envio su peticion para eliminar de favoritos
    Then se eliminaron los carwashes de favoritos