# language: en
# encoding: iso-8859-1
Feature:  Buscar Car Wash por nombre
    Como Usuario
    quiero encontar un Car Wash específico a través de su nombre
    Para poder utilizar sus servicios

    Scenario: El usuario puede encontrar Car Washes con el nombre que dió por input
        Given que ingreso al API "http://localhost:8080" para filtrar por nombre
        And se ubico en la ruta "/api/carwashes/name/Todo Limpio" para filtrar por nombre
        And mediante el metodo "GET" para filtrar por nombre
        When envio su peticion para filtrar por nombre
        Then obtuvo la lista de CarWashes filtrados por nombre