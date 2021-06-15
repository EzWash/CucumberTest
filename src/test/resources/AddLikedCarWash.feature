Feature: Agregar un Car Wash a la lista de preferidos
  Como Usuario
  Yo quiero agregar un Car Wash a mi lista de preferidos
  Para solicitar sus servicios mucho más rápido

  Scenario: El usuario puede agregar un Car Wash a su lista de preferidos
    Given que ingreso al API "http://localhost:8080" para agregar - User_CarWash
    And se ubico en la ruta "/api/users/1/carwashes/1" para agregar - User_CarWash
    And mediante el metodo "POST" para agregar - User_CarWash
    When envio su peticion para agregar a favoritos - User_CarWash
    Then se registro CarWash en favoritos