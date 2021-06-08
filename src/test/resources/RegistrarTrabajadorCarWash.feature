Feature:  Registrar trabajadores del Car Wash
  Como Car Wash
  Yo quiero registrar a mis trabajadores
  Para poder utilizarlos en cada servicio que llegue

  Scenario: El Car Wash pudo registrar a un trabajador
    Given que ingreso al API "http://localhost:8080" para agregar - Trabajador
    And se ubico en la ruta "/api/carwashes/1/staff" para agregar - Trabajador
    And mediante el metodo "POST" para agregar - Trabajador
    And tengo el siguiente Trabajador para agregar
      | First_name | Last_name | Email | Phone | Gender |
      | Roberto | Vega |  terocal@hotmail.com |123456789|M|
    When envio su peticion para agregar - Trabajador
    Then se registro Trabajador