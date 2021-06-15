Feature:  Registrar Servicios
  Como Car Wash
  Quiero registrar mis servicios
  Para publicarlos en la aplicación y que puedan ser contratadas

  Scenario: El Car Wash pudo registrar un servicio
    Given que ingreso al API "http://localhost:8080" para agregar - Servicio
    And se ubico en la ruta "/api/carwashes/1/service" para agregar - Servicio
    And mediante el metodo "POST" para agregar - Servicio
    And tengo el siguiente Servicio para agregar
      | Name | Description | Details | Is_promotion | Price |
      | Roberto | Vega |  terocal@hotmail.com |0|30.0       |
    When envio su peticion para agregar - Servicio
    Then se registro Servicio