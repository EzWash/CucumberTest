Feature: Registrar datos del auto del cliente
  Como Usuario
  Yo quiero registrar datos de mi auto
  Para poder aplicar los servicios a mi vehículo en específico

  Scenario: Pudo registrar los datos de sus autos
    Given que ingreso al API "http://localhost:8080" para agregar - Carro_User
    And se ubico en la ruta "/api/vehicles" para agregar - Carro_User
    And mediante el metodo "POST" para agregar - Carro_User
    And tengo el siguiente Carro para agregar
      | Model | Brand | Registration_Plate | Location | User |
      | Esquina12 | 12/11/2020 | FSAD | 7|1|
      | Esquina12 | 12/11/2020 | FSAD | 7|1|
    When envio su peticion para agregar - Carro_User
    Then se registro Carro