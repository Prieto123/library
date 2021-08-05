-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-08-2021 a las 02:24:09
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 7.3.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `library`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `arriendos`
--

CREATE TABLE `arriendos` (
  `id` int(11) NOT NULL,
  `fecha_arriendo` date DEFAULT NULL,
  `fecha_devolucion_deseada` date DEFAULT NULL,
  `fecha_devolucion_real` date DEFAULT NULL,
  `clientes_rut` int(11) NOT NULL,
  `trabajadores_rut` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `arriendos`
--

INSERT INTO `arriendos` (`id`, `fecha_arriendo`, `fecha_devolucion_deseada`, `fecha_devolucion_real`, `clientes_rut`, `trabajadores_rut`) VALUES
(5, '2021-07-29', '2021-07-30', '2021-07-30', 7419310, 40293456),
(6, '2021-07-29', '2021-07-25', '2021-07-25', 18345934, 9856934);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `autores`
--

CREATE TABLE `autores` (
  `id` int(11) NOT NULL,
  `nombre` varchar(128) COLLATE utf8_spanish_ci DEFAULT NULL,
  `apellido_paterno` varchar(128) COLLATE utf8_spanish_ci DEFAULT NULL,
  `apellido_materno` varchar(128) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `autores`
--

INSERT INTO `autores` (`id`, `nombre`, `apellido_paterno`, `apellido_materno`) VALUES
(1, 'Stephen', 'King', NULL),
(2, 'Joanne', 'Rowling', NULL),
(3, 'Haruki', 'Murakami', NULL),
(4, 'Mario', 'Carvajal', NULL),
(5, 'Carlos', 'Saraniti', NULL),
(6, 'John', 'Katzenbach', NULL),
(7, 'Stephen', 'Chbosky', NULL),
(8, 'ElRubius', 'OMG', NULL),
(9, 'Sergio', 'Vergara', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `boletas`
--

CREATE TABLE `boletas` (
  `folio` int(11) NOT NULL,
  `fecha_venta` date DEFAULT NULL,
  `hora_venta` date DEFAULT NULL,
  `cliente_rut` int(11) NOT NULL,
  `trabajadores_rut` int(11) NOT NULL,
  `metodos_pago_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `boletas`
--

INSERT INTO `boletas` (`folio`, `fecha_venta`, `hora_venta`, `cliente_rut`, `trabajadores_rut`, `metodos_pago_id`) VALUES
(2, '2021-07-29', '2021-07-07', 7419310, 40293456, 5),
(5, '2021-07-29', '2021-07-29', 20703735, 40293456, 3),
(6, '2021-07-29', '2021-07-29', 18345934, 9856934, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE `categorias` (
  `id` int(11) NOT NULL,
  `nombre` varchar(60) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`id`, `nombre`) VALUES
(1, 'Terror'),
(2, 'Fantasía'),
(3, 'Drama'),
(4, 'Epistolario'),
(5, 'Novela'),
(6, 'Suspenso'),
(7, 'Thriller Psicológico'),
(8, 'Puzle');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `rut` int(8) NOT NULL,
  `numero_verificador` char(1) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre` varchar(25) COLLATE utf8_spanish_ci DEFAULT NULL,
  `apellido_paterno` varchar(25) COLLATE utf8_spanish_ci DEFAULT NULL,
  `apellido_materno` varchar(25) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`rut`, `numero_verificador`, `nombre`, `apellido_paterno`, `apellido_materno`) VALUES
(7419310, '2', 'Isabel', 'Cepeda', 'Pinto'),
(18345934, '4', 'Lucas', 'Goñi', 'Flániga'),
(19238945, '3', 'Paz', 'Pena', 'Asenjo'),
(20283413, '2', 'Catalina', 'Cepeda', 'Órdenes'),
(20703735, '7', 'Sebastián', 'Mena', 'Cordova'),
(24999888, '2', 'Sebastián', 'Uribe', 'Pulgar');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes_has_correos`
--

CREATE TABLE `clientes_has_correos` (
  `clientes_id` int(11) NOT NULL,
  `correos_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes_has_direcciones`
--

CREATE TABLE `clientes_has_direcciones` (
  `clientes_rut` int(11) NOT NULL,
  `direcciones_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `clientes_has_direcciones`
--

INSERT INTO `clientes_has_direcciones` (`clientes_rut`, `direcciones_id`) VALUES
(20283413, 11),
(24999888, 13);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes_has_telefonos`
--

CREATE TABLE `clientes_has_telefonos` (
  `clientes_rut` int(11) NOT NULL,
  `telefonos_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `clientes_has_telefonos`
--

INSERT INTO `clientes_has_telefonos` (`clientes_rut`, `telefonos_id`) VALUES
(20283413, 10),
(24999888, 13);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compras`
--

CREATE TABLE `compras` (
  `id` int(11) NOT NULL,
  `facturas_folio` int(11) NOT NULL,
  `ejemplar_libro_numero_serie` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `compras`
--

INSERT INTO `compras` (`id`, `facturas_folio`, `ejemplar_libro_numero_serie`) VALUES
(2, 1, 35475),
(3, 2, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `correos`
--

CREATE TABLE `correos` (
  `id` int(11) NOT NULL,
  `direccion` varchar(64) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `correos`
--

INSERT INTO `correos` (`id`, `direccion`) VALUES
(1, 'pablojavierprietocepeda@gmail.com'),
(2, 'pablo.prieto05@inacapmail.cl');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_arriendo`
--

CREATE TABLE `detalle_arriendo` (
  `ejemplar_libro_numero_serie` int(11) NOT NULL,
  `arriendos_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `detalle_arriendo`
--

INSERT INTO `detalle_arriendo` (`ejemplar_libro_numero_serie`, `arriendos_id`) VALUES
(7, 5),
(2353, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `direcciones`
--

CREATE TABLE `direcciones` (
  `id` int(11) NOT NULL,
  `direccion` varchar(60) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `direcciones`
--

INSERT INTO `direcciones` (`id`, `direccion`) VALUES
(1, 'Newton 0933, Quilpué'),
(2, 'El Rincón de los Zorzales, Villa Alemana'),
(6, 'Las Condes'),
(7, 'Las Kongdes'),
(8, 'Cachagua 493'),
(9, 'Cachagua 492'),
(10, 'Villa Paraíso 419, Quillota'),
(11, 'Los Presidentes 8912, Casa 116, Peñalolén'),
(12, 'Avenida Argentina Valparaíso'),
(13, 'Hola');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `distribuidores`
--

CREATE TABLE `distribuidores` (
  `rut` int(9) NOT NULL,
  `numero_verificador` char(1) COLLATE utf8_spanish_ci DEFAULT NULL,
  `nombre` varchar(60) COLLATE utf8_spanish_ci DEFAULT NULL,
  `ano_antiguedad` int(4) DEFAULT NULL,
  `telefonos_id` int(11) NOT NULL,
  `direcciones_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `distribuidores`
--

INSERT INTO `distribuidores` (`rut`, `numero_verificador`, `nombre`, `ano_antiguedad`, `telefonos_id`, `direcciones_id`) VALUES
(96834344, '7', 'Distribuidora Cristal XD', 2018, 12, 12),
(99456945, '2', 'Distribuidora Los Patos', 2021, 6, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `editoriales`
--

CREATE TABLE `editoriales` (
  `id` int(11) NOT NULL,
  `editorial` varchar(60) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `editoriales`
--

INSERT INTO `editoriales` (`id`, `editorial`) VALUES
(1, 'Zig Zag'),
(2, 'Planeta'),
(8, 'Lorem'),
(9, 'Arcano IV'),
(10, 'Overol'),
(11, 'Cuatro Vientos'),
(12, 'Cuneta'),
(13, 'Ocho Libros'),
(14, 'Kactus'),
(15, 'Catalonia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejemplar_libro`
--

CREATE TABLE `ejemplar_libro` (
  `numero_serie` int(11) NOT NULL,
  `precio` varchar(8) COLLATE utf8_spanish_ci DEFAULT NULL,
  `estados_id` int(11) NOT NULL,
  `libros_isbn` bigint(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `ejemplar_libro`
--

INSERT INTO `ejemplar_libro` (`numero_serie`, `precio`, `estados_id`, `libros_isbn`) VALUES
(7, '100', 3, 9780446677455),
(2353, '5000', 2, 8924862835892),
(35475, '2000', 3, 1245135475752);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estados`
--

CREATE TABLE `estados` (
  `id` int(11) NOT NULL,
  `estado` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `estados`
--

INSERT INTO `estados` (`id`, `estado`) VALUES
(1, 'Disponible'),
(2, 'Arrendado'),
(3, 'Comprado');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturas`
--

CREATE TABLE `facturas` (
  `folio` int(11) NOT NULL,
  `fecha_compra` date DEFAULT NULL,
  `hora_compra` time DEFAULT NULL,
  `metodos_pago_id` int(11) NOT NULL,
  `distribuidores_rut` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `facturas`
--

INSERT INTO `facturas` (`folio`, `fecha_compra`, `hora_compra`, `metodos_pago_id`, `distribuidores_rut`) VALUES
(1, '2021-08-03', NULL, 2, 99456945),
(2, '2021-08-04', NULL, 4, 99456945);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `idiomas`
--

CREATE TABLE `idiomas` (
  `id` int(11) NOT NULL,
  `nombre` varchar(24) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `idiomas`
--

INSERT INTO `idiomas` (`id`, `nombre`) VALUES
(1, 'Español'),
(2, 'Inglés');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libros`
--

CREATE TABLE `libros` (
  `isbn` bigint(13) NOT NULL,
  `titulo` varchar(48) COLLATE utf8_spanish_ci DEFAULT NULL,
  `paginas` int(8) DEFAULT NULL,
  `ano_publicado` int(4) DEFAULT NULL,
  `editoriales_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `libros`
--

INSERT INTO `libros` (`isbn`, `titulo`, `paginas`, `ano_publicado`, `editoriales_id`) VALUES
(1245135475752, 'El Jorobado de Notredame', 120, 2001, 8),
(2624632343434, 'El libro Troll', 100, 2018, 15),
(8924862835892, 'El Principito', 1, 2021, 13),
(9780446677455, 'Padre Rico, Padre Pobre', 207, 1997, 1),
(9780582402751, 'Misery', 420, 1987, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libros_has_autores`
--

CREATE TABLE `libros_has_autores` (
  `libros_isbn` bigint(13) NOT NULL,
  `autores_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `libros_has_autores`
--

INSERT INTO `libros_has_autores` (`libros_isbn`, `autores_id`) VALUES
(9780582402751, 1),
(1245135475752, 1),
(2624632343434, 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libros_has_categorias`
--

CREATE TABLE `libros_has_categorias` (
  `libros_isbn` bigint(13) NOT NULL,
  `categorias_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `libros_has_categorias`
--

INSERT INTO `libros_has_categorias` (`libros_isbn`, `categorias_id`) VALUES
(9780582402751, 6),
(9780582402751, 7),
(9780582402751, 1),
(1245135475752, 1),
(2624632343434, 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libros_has_idiomas`
--

CREATE TABLE `libros_has_idiomas` (
  `libros_isbn` bigint(13) NOT NULL,
  `idiomas_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `libros_has_idiomas`
--

INSERT INTO `libros_has_idiomas` (`libros_isbn`, `idiomas_id`) VALUES
(9780582402751, 1),
(9780582402751, 2),
(1245135475752, 1),
(2624632343434, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `metodos_pago`
--

CREATE TABLE `metodos_pago` (
  `id` int(11) NOT NULL,
  `metodo` varchar(24) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `metodos_pago`
--

INSERT INTO `metodos_pago` (`id`, `metodo`) VALUES
(1, 'Contado'),
(2, 'PayPal'),
(3, 'MasterCard'),
(4, 'Visa'),
(5, 'MACH');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `telefonos`
--

CREATE TABLE `telefonos` (
  `id` int(11) NOT NULL,
  `numero` varchar(9) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `telefonos`
--

INSERT INTO `telefonos` (`id`, `numero`) VALUES
(1, '978569972'),
(2, '900000000'),
(6, '988877787'),
(7, '988877786'),
(8, '978123456'),
(9, '978123455'),
(10, '974784610'),
(11, '975968785'),
(12, '975968783'),
(13, '956565656');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `trabajadores`
--

CREATE TABLE `trabajadores` (
  `rut` int(8) NOT NULL,
  `numero_verificador` char(1) COLLATE utf8_spanish_ci NOT NULL,
  `nombre` varchar(25) COLLATE utf8_spanish_ci DEFAULT NULL,
  `apellido_paterno` varchar(25) COLLATE utf8_spanish_ci DEFAULT NULL,
  `apellido_materno` varchar(25) COLLATE utf8_spanish_ci DEFAULT NULL,
  `fecha_contrato` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `trabajadores`
--

INSERT INTO `trabajadores` (`rut`, `numero_verificador`, `nombre`, `apellido_paterno`, `apellido_materno`, `fecha_contrato`) VALUES
(9384596, '2', 'Juan', 'Pérez', 'Pérez', '2021-08-01'),
(9856934, '2', 'Zacarías', 'Flores', 'Del Campo', '2021-07-30'),
(20482863, '3', 'Pablo', 'Prieto', 'Cepeda', '2021-07-29'),
(40293456, '2', 'Alan', 'Brito', 'Delgado', '2021-07-29');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `trabajadores_has_correos`
--

CREATE TABLE `trabajadores_has_correos` (
  `trabajadores_id` int(11) NOT NULL,
  `correos_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `trabajadores_has_direcciones`
--

CREATE TABLE `trabajadores_has_direcciones` (
  `trabajadores_rut` int(11) NOT NULL,
  `direcciones_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `trabajadores_has_telefonos`
--

CREATE TABLE `trabajadores_has_telefonos` (
  `trabajadores_id` int(11) NOT NULL,
  `telefonos_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `id` int(11) NOT NULL,
  `boletas_folio` int(11) DEFAULT NULL,
  `ejemplar_libro_numero_serie` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `arriendos`
--
ALTER TABLE `arriendos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `clientes_rut_arriendos` (`clientes_rut`),
  ADD KEY `trabajadores_id_arriendos` (`trabajadores_rut`);

--
-- Indices de la tabla `autores`
--
ALTER TABLE `autores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `boletas`
--
ALTER TABLE `boletas`
  ADD PRIMARY KEY (`folio`),
  ADD KEY `cliente_rut_boletas` (`cliente_rut`),
  ADD KEY `trabajadores_rut_boletas` (`trabajadores_rut`),
  ADD KEY `metodos_pago_id_boletas` (`metodos_pago_id`);

--
-- Indices de la tabla `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`rut`);

--
-- Indices de la tabla `clientes_has_correos`
--
ALTER TABLE `clientes_has_correos`
  ADD KEY `clientes_id_correos` (`clientes_id`),
  ADD KEY `correos_id_clientes` (`correos_id`);

--
-- Indices de la tabla `clientes_has_direcciones`
--
ALTER TABLE `clientes_has_direcciones`
  ADD KEY `clientes_rut_direcciones` (`clientes_rut`),
  ADD KEY `direcciones_id_clientes` (`direcciones_id`);

--
-- Indices de la tabla `clientes_has_telefonos`
--
ALTER TABLE `clientes_has_telefonos`
  ADD KEY `clientes_rut_telefonos` (`clientes_rut`),
  ADD KEY `telefonos_id_clientes` (`telefonos_id`);

--
-- Indices de la tabla `compras`
--
ALTER TABLE `compras`
  ADD PRIMARY KEY (`id`),
  ADD KEY `facturas_folio_compras` (`facturas_folio`),
  ADD KEY `ejemplar_libro_numero_serie_compras` (`ejemplar_libro_numero_serie`);

--
-- Indices de la tabla `correos`
--
ALTER TABLE `correos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `detalle_arriendo`
--
ALTER TABLE `detalle_arriendo`
  ADD KEY `ejemplar_libro_numero_serie_arriendos` (`ejemplar_libro_numero_serie`),
  ADD KEY `arriendos_id_ejemplar_libro` (`arriendos_id`);

--
-- Indices de la tabla `direcciones`
--
ALTER TABLE `direcciones`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `distribuidores`
--
ALTER TABLE `distribuidores`
  ADD PRIMARY KEY (`rut`),
  ADD KEY `telefonos_id_distribuidores` (`telefonos_id`),
  ADD KEY `direcciones_id_distribuidores` (`direcciones_id`);

--
-- Indices de la tabla `editoriales`
--
ALTER TABLE `editoriales`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `ejemplar_libro`
--
ALTER TABLE `ejemplar_libro`
  ADD PRIMARY KEY (`numero_serie`),
  ADD KEY `estados_id_ejemplares` (`estados_id`),
  ADD KEY `libros_isbn_ejemplares` (`libros_isbn`);

--
-- Indices de la tabla `estados`
--
ALTER TABLE `estados`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `facturas`
--
ALTER TABLE `facturas`
  ADD PRIMARY KEY (`folio`),
  ADD KEY `metodos_pago_id_facturas` (`metodos_pago_id`),
  ADD KEY `distribuidores_id_facturas` (`distribuidores_rut`);

--
-- Indices de la tabla `idiomas`
--
ALTER TABLE `idiomas`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `libros`
--
ALTER TABLE `libros`
  ADD PRIMARY KEY (`isbn`),
  ADD KEY `libros_isbn_editoriales_id` (`editoriales_id`);

--
-- Indices de la tabla `libros_has_autores`
--
ALTER TABLE `libros_has_autores`
  ADD KEY `libros_isbn_autores` (`libros_isbn`),
  ADD KEY `autores_id_libros` (`autores_id`);

--
-- Indices de la tabla `libros_has_categorias`
--
ALTER TABLE `libros_has_categorias`
  ADD KEY `libros_isbn_categorias` (`libros_isbn`),
  ADD KEY `categorias_id_libros` (`categorias_id`);

--
-- Indices de la tabla `libros_has_idiomas`
--
ALTER TABLE `libros_has_idiomas`
  ADD KEY `libros_isbn_idiomas` (`libros_isbn`),
  ADD KEY `idiomas_id_libros` (`idiomas_id`);

--
-- Indices de la tabla `metodos_pago`
--
ALTER TABLE `metodos_pago`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `telefonos`
--
ALTER TABLE `telefonos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `trabajadores`
--
ALTER TABLE `trabajadores`
  ADD PRIMARY KEY (`rut`);

--
-- Indices de la tabla `trabajadores_has_correos`
--
ALTER TABLE `trabajadores_has_correos`
  ADD KEY `trabajadores_id_correos` (`trabajadores_id`),
  ADD KEY `correos_id_trabajadores` (`correos_id`);

--
-- Indices de la tabla `trabajadores_has_direcciones`
--
ALTER TABLE `trabajadores_has_direcciones`
  ADD KEY `trabajadores_rut_direcciones` (`trabajadores_rut`),
  ADD KEY `direcciones_id_trabajadores` (`direcciones_id`);

--
-- Indices de la tabla `trabajadores_has_telefonos`
--
ALTER TABLE `trabajadores_has_telefonos`
  ADD KEY `trabajadores_id_telefonos` (`trabajadores_id`),
  ADD KEY `telefonos_id_trabajadores` (`telefonos_id`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `boletas_folio_ventas` (`boletas_folio`),
  ADD KEY `ejemplar_libro_numero_serie_ventas` (`ejemplar_libro_numero_serie`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `arriendos`
--
ALTER TABLE `arriendos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `autores`
--
ALTER TABLE `autores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `boletas`
--
ALTER TABLE `boletas`
  MODIFY `folio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de la tabla `categorias`
--
ALTER TABLE `categorias`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `compras`
--
ALTER TABLE `compras`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `correos`
--
ALTER TABLE `correos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `direcciones`
--
ALTER TABLE `direcciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `editoriales`
--
ALTER TABLE `editoriales`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `estados`
--
ALTER TABLE `estados`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `facturas`
--
ALTER TABLE `facturas`
  MODIFY `folio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `idiomas`
--
ALTER TABLE `idiomas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `metodos_pago`
--
ALTER TABLE `metodos_pago`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `telefonos`
--
ALTER TABLE `telefonos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT de la tabla `ventas`
--
ALTER TABLE `ventas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `arriendos`
--
ALTER TABLE `arriendos`
  ADD CONSTRAINT `clientes_rut_arriendos` FOREIGN KEY (`clientes_rut`) REFERENCES `clientes` (`rut`),
  ADD CONSTRAINT `trabajadores_id_arriendos` FOREIGN KEY (`trabajadores_rut`) REFERENCES `trabajadores` (`rut`);

--
-- Filtros para la tabla `boletas`
--
ALTER TABLE `boletas`
  ADD CONSTRAINT `cliente_rut_boletas` FOREIGN KEY (`cliente_rut`) REFERENCES `clientes` (`rut`),
  ADD CONSTRAINT `metodos_pago_id_boletas` FOREIGN KEY (`metodos_pago_id`) REFERENCES `metodos_pago` (`id`),
  ADD CONSTRAINT `trabajadores_rut_boletas` FOREIGN KEY (`trabajadores_rut`) REFERENCES `trabajadores` (`rut`);

--
-- Filtros para la tabla `clientes_has_correos`
--
ALTER TABLE `clientes_has_correos`
  ADD CONSTRAINT `clientes_id_correos` FOREIGN KEY (`clientes_id`) REFERENCES `clientes` (`rut`),
  ADD CONSTRAINT `correos_id_clientes` FOREIGN KEY (`correos_id`) REFERENCES `correos` (`id`);

--
-- Filtros para la tabla `clientes_has_direcciones`
--
ALTER TABLE `clientes_has_direcciones`
  ADD CONSTRAINT `clientes_rut_direcciones` FOREIGN KEY (`clientes_rut`) REFERENCES `clientes` (`rut`),
  ADD CONSTRAINT `direcciones_id_clientes` FOREIGN KEY (`direcciones_id`) REFERENCES `direcciones` (`id`);

--
-- Filtros para la tabla `clientes_has_telefonos`
--
ALTER TABLE `clientes_has_telefonos`
  ADD CONSTRAINT `clientes_rut_telefonos` FOREIGN KEY (`clientes_rut`) REFERENCES `clientes` (`rut`),
  ADD CONSTRAINT `telefonos_id_clientes` FOREIGN KEY (`telefonos_id`) REFERENCES `telefonos` (`id`);

--
-- Filtros para la tabla `compras`
--
ALTER TABLE `compras`
  ADD CONSTRAINT `ejemplar_libro_numero_serie_compras` FOREIGN KEY (`ejemplar_libro_numero_serie`) REFERENCES `ejemplar_libro` (`numero_serie`),
  ADD CONSTRAINT `facturas_folio_compras` FOREIGN KEY (`facturas_folio`) REFERENCES `facturas` (`folio`);

--
-- Filtros para la tabla `detalle_arriendo`
--
ALTER TABLE `detalle_arriendo`
  ADD CONSTRAINT `arriendos_id_ejemplar_libro` FOREIGN KEY (`arriendos_id`) REFERENCES `arriendos` (`id`),
  ADD CONSTRAINT `ejemplar_libro_numero_serie_arriendos` FOREIGN KEY (`ejemplar_libro_numero_serie`) REFERENCES `ejemplar_libro` (`numero_serie`);

--
-- Filtros para la tabla `distribuidores`
--
ALTER TABLE `distribuidores`
  ADD CONSTRAINT `direcciones_id_distribuidores` FOREIGN KEY (`direcciones_id`) REFERENCES `direcciones` (`id`),
  ADD CONSTRAINT `telefonos_id_distribuidores` FOREIGN KEY (`telefonos_id`) REFERENCES `telefonos` (`id`);

--
-- Filtros para la tabla `ejemplar_libro`
--
ALTER TABLE `ejemplar_libro`
  ADD CONSTRAINT `estados_id_ejemplares` FOREIGN KEY (`estados_id`) REFERENCES `estados` (`id`),
  ADD CONSTRAINT `libros_isbn_ejemplares` FOREIGN KEY (`libros_isbn`) REFERENCES `libros` (`isbn`);

--
-- Filtros para la tabla `facturas`
--
ALTER TABLE `facturas`
  ADD CONSTRAINT `distribuidores_id_facturas` FOREIGN KEY (`distribuidores_rut`) REFERENCES `distribuidores` (`rut`),
  ADD CONSTRAINT `metodos_pago_id_facturas` FOREIGN KEY (`metodos_pago_id`) REFERENCES `metodos_pago` (`id`);

--
-- Filtros para la tabla `libros`
--
ALTER TABLE `libros`
  ADD CONSTRAINT `libros_isbn_editoriales_id` FOREIGN KEY (`editoriales_id`) REFERENCES `editoriales` (`id`);

--
-- Filtros para la tabla `libros_has_autores`
--
ALTER TABLE `libros_has_autores`
  ADD CONSTRAINT `autores_id_libros` FOREIGN KEY (`autores_id`) REFERENCES `autores` (`id`),
  ADD CONSTRAINT `libros_isbn_autores` FOREIGN KEY (`libros_isbn`) REFERENCES `libros` (`isbn`);

--
-- Filtros para la tabla `libros_has_categorias`
--
ALTER TABLE `libros_has_categorias`
  ADD CONSTRAINT `categorias_id_libros` FOREIGN KEY (`categorias_id`) REFERENCES `categorias` (`id`),
  ADD CONSTRAINT `libros_isbn_categorias` FOREIGN KEY (`libros_isbn`) REFERENCES `libros` (`isbn`);

--
-- Filtros para la tabla `libros_has_idiomas`
--
ALTER TABLE `libros_has_idiomas`
  ADD CONSTRAINT `idiomas_id_libros` FOREIGN KEY (`idiomas_id`) REFERENCES `idiomas` (`id`),
  ADD CONSTRAINT `libros_isbn_idiomas` FOREIGN KEY (`libros_isbn`) REFERENCES `libros` (`isbn`);

--
-- Filtros para la tabla `trabajadores_has_correos`
--
ALTER TABLE `trabajadores_has_correos`
  ADD CONSTRAINT `correos_id_trabajadores` FOREIGN KEY (`correos_id`) REFERENCES `correos` (`id`),
  ADD CONSTRAINT `trabajadores_id_correos` FOREIGN KEY (`trabajadores_id`) REFERENCES `trabajadores` (`rut`);

--
-- Filtros para la tabla `trabajadores_has_direcciones`
--
ALTER TABLE `trabajadores_has_direcciones`
  ADD CONSTRAINT `direcciones_id_trabajadores` FOREIGN KEY (`direcciones_id`) REFERENCES `direcciones` (`id`),
  ADD CONSTRAINT `trabajadores_rut_direcciones` FOREIGN KEY (`trabajadores_rut`) REFERENCES `trabajadores` (`rut`);

--
-- Filtros para la tabla `trabajadores_has_telefonos`
--
ALTER TABLE `trabajadores_has_telefonos`
  ADD CONSTRAINT `telefonos_id_trabajadores` FOREIGN KEY (`telefonos_id`) REFERENCES `telefonos` (`id`),
  ADD CONSTRAINT `trabajadores_id_telefonos` FOREIGN KEY (`trabajadores_id`) REFERENCES `trabajadores` (`rut`);

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `boletas_folio_ventas` FOREIGN KEY (`boletas_folio`) REFERENCES `boletas` (`folio`),
  ADD CONSTRAINT `ejemplar_libro_numero_serie_ventas` FOREIGN KEY (`ejemplar_libro_numero_serie`) REFERENCES `ejemplar_libro` (`numero_serie`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
