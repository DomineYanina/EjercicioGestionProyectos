INSERT INTO Suscripcion(id, tipo) VALUES (1, 0),
                                         (2, 1);

INSERT INTO Cliente (id, DNI, nombre, suscripcion_id) VALUES
                                                          (1, '12345678', 'Juan Perez', 1),
                                                          (2, '87654321', 'Maria Lopez', 1),
                                                          (3, '11223344', 'Carlos Gomez', 1),
                                                          (4, '44332211', 'Ana Torres', 1),
                                                          (5, '55667788', 'Luis Martinez', 2),
                                                          (6, '99887766', 'Laura Fernandez', 2),
                                                          (7, '22334455', 'Pedro Sanchez', 2),
                                                          (8, '33445566', 'Sofia Ramirez', 2),
                                                          (9, '44556677', 'Javier Morales', 1),
                                                          (10, '55667788', 'Isabel Ruiz', 1),
                                                          (11, '66778899', 'Diego Alvarez', 2),
                                                          (12, '77889900', 'Claudia Jimenez', 2),
                                                          (13, '88990011', 'Fernando Castillo', 1),
                                                          (14, '99001122', 'Patricia Herrera', 2);