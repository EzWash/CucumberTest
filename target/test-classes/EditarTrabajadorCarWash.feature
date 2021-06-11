# language: en
# encoding: iso-8859-1

Feature: Editar trabajadores del Car Wash
        Como Car Wash
        Yo quiero editar los datos de mis trabajadores
        Para mantenerlos actualizados en el tiempo

        Scenario: El Car Wash pudo editar los datos de un trajabador con éxito
                Given que ingreso al API "http://localhost:8080" para actualizar datos del Trabajador
                And se ubica en la ruta "/api/carwashes/1/staff/1" para actualizar datos del Trabajador
                And mediante el metodo "PUT" para actualizar datos del Trabajador
                And tengo el siguiente formulario para actualizar datos del Trabajador
                        | First_name | Last_name | Email | Phone | Gender |
                        | Roberto | Vega |  tel@hotmail.com |123456289|M|
                When envio su peticion para actualizar datos del Trabajador
                Then se actualiza los datos del Trabajador