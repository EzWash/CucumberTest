Feature:  Generar reporte crítico
  Como Usuario
  Quiero generar un reporte crítico hacia un Car Wash
  Para poder dar a conocer algún daño físico que le ocurrió al auto durante la ejecución del servicio

  Scenario: El usuario genera el reporte crítico dentro del rango de tiempo estimado de 12h
    Given que ingreso al API "http://localhost:8080" para crear Reporte
    And se ubico en la ruta "/api/contracts/1/reports" para crear Reporte
    And mediante el metodo "POST" para crear Reporte
    And tengo el siguiente Reporte para crear
      | Description |
      | Robefdsafd|
    When envio su peticion para crear Reporte
    Then se registro Reporte