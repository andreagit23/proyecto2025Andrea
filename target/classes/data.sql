-- src/main/resources/data.sql

-- LIMPIEZA DE TABLAS
DELETE FROM comprobantes;
DELETE FROM transacciones;
DELETE FROM pedidos;
DELETE FROM productos;
DELETE FROM ongs;
DELETE FROM monederos;
DELETE FROM usuarios;
DELETE FROM categorias;

ALTER TABLE usuarios AUTO_INCREMENT = 1;
ALTER TABLE categorias AUTO_INCREMENT = 1;
ALTER TABLE ongs AUTO_INCREMENT = 1;
ALTER TABLE productos AUTO_INCREMENT = 1;

-- CATEGORIAS
INSERT INTO categorias(nombre) VALUES ('Tecnologia');
INSERT INTO categorias(nombre) VALUES ('Ropa');
INSERT INTO categorias(nombre) VALUES ('Libros');
INSERT INTO categorias(nombre) VALUES ('Hogar');
INSERT INTO categorias(nombre) VALUES ('Juguetes');
INSERT INTO categorias(nombre) VALUES ('Deporte');

-- USUARIOS NORMALES
INSERT INTO usuarios(nombre, apellidos, dni, correo_electronico, hash_contrasena, tipo, telefono, estado_cuenta, creado_en)
VALUES ('Ana', 'Martinez', '11111111A', 'ana@correo.com', '1234', 'USUARIO', '600000001', 'activo', NOW());

INSERT INTO usuarios(nombre, apellidos, dni, correo_electronico, hash_contrasena, tipo, telefono, estado_cuenta, creado_en)
VALUES ('Luis', 'Garcia', '22222222B', 'luis@correo.com', '1234', 'USUARIO', '600000002', 'activo', NOW());

INSERT INTO usuarios(nombre, apellidos, dni, correo_electronico, hash_contrasena, tipo, telefono, estado_cuenta, creado_en)
VALUES ('Maria', 'Lopez', '33333333C', 'maria@correo.com', '1234', 'USUARIO', '600000003', 'activo', NOW());

-- USUARIOS ONG
INSERT INTO usuarios(nombre, apellidos, dni, correo_electronico, hash_contrasena, tipo, telefono, estado_cuenta, creado_en)
VALUES ('ONG Solidaria', '', '99999999O', 'solidaria@ong.com', '1234', 'ONG', '699999999', 'activo', NOW());

-- ONGS
INSERT INTO ongs(usuario_id, nombre_ong, descripcion, direccion, telefono, correo_electronico, url, verificada)
VALUES (4, 'ONG Solidaria', 'Ayuda social a personas sin hogar', 'Calle Esperanza 1', '699999999', 'solidaria@ong.com', 'https://ongsolidaria.org', TRUE);

-- PRODUCTOS
INSERT INTO productos(nombre, descripcion, precio, porcentaje_donacion, imagen, estado, id_vendedor, id_categoria, creado_en)
VALUES ('Smartphone Samsung', 'Telefono usado en buen estado', 120.00, 20, 'samsung.jpg', 'DISPONIBLE', 1, 1, NOW());

INSERT INTO productos(nombre, descripcion, precio, porcentaje_donacion, imagen, estado, id_vendedor, id_categoria, creado_en)
VALUES ('Camiseta Azul', 'Camiseta talla M poco usada', 10.00, 15, 'samsung.jpg', 'DISPONIBLE', 2, 2, NOW());

INSERT INTO productos(nombre, descripcion, precio, porcentaje_donacion, imagen, estado, id_vendedor, id_categoria, creado_en)
VALUES ('Libro de Java', 'Libro de programación en Java 11', 25.00, 30, 'samsung.jpg', 'DISPONIBLE', 3, 3, NOW());

INSERT INTO productos(nombre, descripcion, precio, porcentaje_donacion, imagen, estado, id_vendedor, id_categoria, creado_en)
VALUES ('Batidora', 'Batidora nueva sin usar', 45.00, 10, 'samsung.jpg', 'DISPONIBLE', 1, 4, NOW());

INSERT INTO productos(nombre, descripcion, precio, porcentaje_donacion, imagen, estado, id_vendedor, id_categoria, creado_en)
VALUES ('Bicicleta', 'Bicicleta de montaña con 18 marchas', 180.00, 25, 'samsung.jpg', 'DISPONIBLE', 2, 6, NOW());

INSERT INTO productos(nombre, descripcion, precio, porcentaje_donacion, imagen, estado, id_vendedor, id_categoria, creado_en)
VALUES ('Juego de mesa', 'Juego de estrategia familiar', 35.00, 15, 'samsung.jpg', 'DISPONIBLE', 3, 5, NOW());
