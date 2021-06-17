Feature:  Publicar comentario y nivel de calidad
  Como Usuario
  Quiero registrar mis comentarios y nivel de calidad
  Para dar a conocer mis pensamientos constructivos o mis felicitaciones hacia el Car Wash

  Scenario: El usuario puede comentar y elegir el nivel de calidad
    Given que ingreso al API "http://localhost:8080" para agregar Comentario y Calificacion
    And se ubico en la ruta "/api/customers/1/carwashes/1/comments" para agregar Comentario y Calificacion
    And mediante el metodo "POST" para agregar Comentario y Calificacion
    And tengo el siguiente Comentario y Calificación para agregar
      | Description | Qualification |
      | Roberto | 4 |
    When envio su peticion para agregar Comentario y Calificacion
    Then se registro Comentario y Calificacion