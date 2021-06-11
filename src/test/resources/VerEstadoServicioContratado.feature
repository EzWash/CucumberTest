# language: en
# encoding: iso-8859-1
Feature: Ver Estado del servicio contratado
  Como Usuario
  Yo quiero saber los detalles del servicio que he contratado
  Para saber lo que está pasando con mi carro mientras no está en mi posesión

  Scenario: El usuario puede ver el estado del servicio actualizarse con éxito
    Given que ingreso al API "http://localhost:8080" - user_service
    And se ubico en la ruta "/api/service/1" - user_service
    And mediante el metodo "GET" - user_service
    When envio su peticion - user_service
    Then obtuvo la lista de Servicios - user_service