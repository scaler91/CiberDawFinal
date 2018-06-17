-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-06-2018 a las 13:07:49
-- Versión del servidor: 10.1.31-MariaDB
-- Versión de PHP: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cibercafebd`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administradores`
--

CREATE TABLE `administradores` (
  `dni` varchar(9) NOT NULL,
  `Nombre` varchar(10) NOT NULL,
  `Apellidos` varchar(10) NOT NULL,
  `Contraseña` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `administradores`
--

INSERT INTO `administradores` (`dni`, `Nombre`, `Apellidos`, `Contraseña`) VALUES
('71964849B', 'Javier', 'Diego', '1234');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `conexiones`
--

CREATE TABLE `conexiones` (
  `dni` varchar(9) NOT NULL,
  `idOrdenador` int(2) NOT NULL,
  `FechaConexion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `conexiones`
--

INSERT INTO `conexiones` (`dni`, `idOrdenador`, `FechaConexion`) VALUES
('555A', 2, '2018-06-04 08:29:44'),
('555A', 3, '2018-06-04 08:30:00'),
('555A', 5, '2018-06-04 08:36:36'),
('555A', 6, '2018-06-04 08:40:18'),
('555A', 6, '2018-06-04 08:44:04'),
('666A', 10, '2018-06-04 08:44:32'),
('555A', 7, '2018-06-06 06:48:45'),
('555A', 3, '2018-06-06 06:50:29'),
('555A', 8, '2018-06-06 06:52:12'),
('555A', 4, '2018-06-06 07:08:53'),
('555A', 9, '2018-06-06 07:09:49'),
('555A', 3, '2018-06-06 07:10:04'),
('555A', 6, '2018-06-06 07:10:35'),
('555A', 2, '2018-06-06 07:10:54'),
('666A', 9, '2018-06-06 07:11:12'),
('555A', 4, '2018-06-06 07:16:32'),
('555A', 9, '2018-06-06 07:17:15'),
('555A', 2, '2018-06-06 07:18:50'),
('555A', 10, '2018-06-11 06:42:48'),
('555A', 3, '2018-06-11 06:50:31'),
('555A', 2, '2018-06-11 06:51:36'),
('555A', 5, '2018-06-11 07:06:32'),
('555A', 7, '2018-06-11 07:08:35'),
('555A', 2, '2018-06-11 07:12:46'),
('555A', 5, '2018-06-11 07:20:08'),
('555A', 6, '2018-06-11 07:21:57'),
('555A', 7, '2018-06-11 07:29:40'),
('555A', 1, '2018-06-11 07:35:03'),
('555A', 6, '2018-06-11 07:35:56'),
('555A', 8, '2018-06-11 07:39:36'),
('555A', 2, '2018-06-11 07:40:27'),
('555A', 10, '2018-06-11 07:44:42'),
('555A', 2, '2018-06-11 07:46:37'),
('555A', 7, '2018-06-11 07:53:00'),
('555A', 7, '2018-06-11 07:54:11'),
('555A', 3, '2018-06-11 07:58:56'),
('555A', 9, '2018-06-11 08:00:22'),
('666A', 10, '2018-06-11 08:04:00'),
('666A', 6, '2018-06-11 08:06:18'),
('666A', 8, '2018-06-11 08:07:42'),
('666A', 9, '2018-06-11 08:12:08'),
('666A', 7, '2018-06-11 08:15:17'),
('555A', 8, '2018-06-11 08:33:52'),
('666A', 4, '2018-06-11 08:39:17'),
('555A', 6, '2018-06-13 07:08:41'),
('555A', 5, '2018-06-13 07:09:45'),
('555A', 5, '2018-06-13 07:13:03'),
('555A', 8, '2018-06-13 07:32:10'),
('555A', 2, '2018-06-13 07:37:56'),
('555A', 2, '2018-06-13 07:41:27'),
('555A', 2, '2018-06-13 08:13:05'),
('71946339Q', 4, '2018-06-13 08:16:35'),
('71946339Q', 10, '2018-06-13 08:28:05'),
('71946339Q', 7, '2018-06-13 09:48:47'),
('71946339Q', 8, '2018-06-13 09:53:30'),
('71946339Q', 3, '2018-06-13 09:58:39'),
('71946339Q', 9, '2018-06-13 10:11:13'),
('71946339Q', 1, '2018-06-13 10:13:18'),
('71951754A', 3, '2018-06-13 10:48:44');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `consumibles`
--

CREATE TABLE `consumibles` (
  `idConsumible` int(4) NOT NULL,
  `Nombre` varchar(10) NOT NULL,
  `Cantidad` int(4) NOT NULL,
  `Precio` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `consumibles`
--

INSERT INTO `consumibles` (`idConsumible`, `Nombre`, `Cantidad`, `Precio`) VALUES
(0, 'Coca-cola', 50, 2),
(1, 'Fanta', 0, 2),
(2, 'Cerveza', 0, 1.5),
(3, 'Cafe', 1, 100),
(4, 'Galletitas', 0, 1),
(5, 'Pan', 0, 1.2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `dni` varchar(9) NOT NULL,
  `mesa` int(11) NOT NULL,
  `idConsumible` int(4) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` float NOT NULL,
  `realizado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pedidos`
--

INSERT INTO `pedidos` (`dni`, `mesa`, `idConsumible`, `cantidad`, `precio`, `realizado`) VALUES
('71946339Q', 1, 1, 1, 2, 1),
('71946339Q', 1, 5, 3, 3.6, 1),
('71946339Q', 1, 2, 1, 1.5, 1),
('71951754A', 1, 0, 9, 18, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `dni` varchar(9) NOT NULL,
  `Nombre` varchar(10) NOT NULL,
  `Apellidos` varchar(10) NOT NULL,
  `Contraseña` varchar(20) NOT NULL,
  `vip` tinyint(1) NOT NULL,
  `primerLog` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`dni`, `Nombre`, `Apellidos`, `Contraseña`, `vip`, `primerLog`) VALUES
('71946339Q', 'Saul', 'Monge', '1234', 0, 1),
('71951754A', 'jony', 'escaño', '12345', 1, 1),
('71955798E', 'Felipe', 'Ruiz', '1234', 1, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administradores`
--
ALTER TABLE `administradores`
  ADD PRIMARY KEY (`dni`);

--
-- Indices de la tabla `consumibles`
--
ALTER TABLE `consumibles`
  ADD UNIQUE KEY `id` (`idConsumible`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`dni`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
