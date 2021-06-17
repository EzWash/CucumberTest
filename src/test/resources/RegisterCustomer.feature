Feature:  Registrar datos personales del cliente
  Como Usuario
  Quiero registrar mis datos personales dentro de la aplicación
  Para poder tener un servicio más personalizado dentro de la aplicación

  Scenario: Pudo registrar sus datos personales
    Given que ingreso al API "http://localhost:8080" para agregar - Usuario
    And se ubico en la ruta "/api/users" para agregar - Usuario
    And mediante el metodo "POST" para agregar - Usuario
    And tengo el siguiente Usuario para agregar
      | First_Name | Last_Name | Email | Phone | Gender | Password | Location |
      | Roberto | Vega |  terocal@hotmail.com |987654321|M       | rBT      | 5       |
    When envio su peticion para agregar - Usuario
    Then se registro Usuario