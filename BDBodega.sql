
CREATE DATABASE IF NOT EXISTS ProyectoBodegaPOO2;

USE ProyectoBodegaPOO2;

CREATE TABLE CategoriaProducto(
nombreCategoria nvarchar(100) PRIMARY KEY NOT NULL);


CREATE TABLE Producto(
nombreProducto nvarchar(100) PRIMARY KEY  NOT NULL,
nombreCategoria nvarchar(100) NOT NULL,
precio float NOT NULL,
FOREIGN KEY (nombreCategoria) REFERENCES CategoriaProducto(nombreCategoria));

CREATE TABLE Inventario(
Lote nvarchar(100) PRIMARY KEY NOT NULL,
nombreProducto nvarchar(100) NOT NULL,
fechaCaducidad datetime NOT NULL,
cantidadProducto int NOT NULL,
FOREIGN KEY(nombreProducto) REFERENCES Producto(nombreProducto));

CREATE TABLE VentaDetalle(
fechaVenta datetime NOT NULL,
nombreProducto nvarchar(100) NOT NULL,
cantidadVendido int NOT NULL,
importeTotal float NOT NULL,
FOREIGN KEY(nombreProducto) REFERENCES Producto(nombreProducto));

CREATE TABLE ReporteInventario(
LoteProducto nvarchar(100) NOT NULL,
fechaRegistro datetime NOT NULL,
tipo boolean NOT NULL,
nombreProducto nvarchar(100) NOT NULL,
cantidad int NOT NULL,
FOREIGN KEY(LoteProducto) REFERENCES Inventario(Lote),
FOREIGN KEY(nombreProducto) REFERENCES Producto(nombreProducto));

INSERT INTO CategoriaProducto VALUES
('Lacteos'),
('Gaseosas'),
('Frituras'),
('Galletas');

INSERT INTO Producto VALUES
('Coca-Cola 1 Litro', 'Gaseosas', 3.99),
('Inka-Cola 1 Litro', 'Gaseosas', 3.99),
('Coca-Cola 3 Litros', 'Gaseosas', 9.99),
('Inka-Cola 3 Litros', 'Gaseosas', 9.99),
('Galleta vainilla', 'Galletas', 1.50),
('Galleta nick', 'Galletas', 1.99),
('Galleta soda', 'Galletas', 0.99),
('Papas Lays pequenia', 'Frituras', 0.99),
('Papas Lays mediana', 'Frituras', 2.99),
('Papas Lays grande', 'Frituras', 4.99),
('Lata de leche gloria', 'Lacteos', 3.99),
('Bolsa de leche gloria', 'Lacteos', 4.99);

INSERT INTO Inventario VALUES
('LaysP012345', 'Papas Lays pequenia', '2023-05-15' , 10),
('LaysM012345', 'Papas Lays mediana', '2023-05-15' , 8),
('LaysG012345', 'Papas Lays grande', '2023-05-15' , 5),
('CCola1L3467', 'Coca-Cola 1 Litro', '2023-02-10' , 12),
('ICola1L3463', 'Inka-Cola 1 Litro', '2023-02-10' , 15),
('CCola3L3476', 'Coca-Cola 3 Litros', '2023-02-10' , 10),
('ICola3L3486', 'Inka-Cola 3 Litros', '2023-02-10' , 10);
