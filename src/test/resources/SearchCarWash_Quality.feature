# language: en
# encoding: iso-8859-1
Feature:  Buscar Car Wash por Nivel de Calidad
    Como Usuario
    quiero buscar por calidad de nivel un Car Wash
    Para seleccionar el que mejor me parezca

    Scenario: El usuario encontró Car Washes de un nivel de calidad determinado
        Given que ingreso al API "http://localhost:8080" para filtrar por calificacion
        And se ubico en la ruta "/api/carwashes/qualification/5" para filtrar por calificacion
        And mediante el metodo "GET" para filtrar por calificacion
        When envio su peticion para filtrar por calificacion
        Then obtuvo la lista de CarWashes filtrados por calificacion