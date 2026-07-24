-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 11-03-2019 a las 00:41:13
-- Versión del servidor: 10.1.35-MariaDB
-- Versión de PHP: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `recruiter2050`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cabecera_cv`
--

CREATE TABLE `cabecera_cv` (
  `id` int(11) NOT NULL,
  `id_candidato` int(11) NOT NULL,
  `email` varchar(25) COLLATE utf8_spanish2_ci NOT NULL,
  `web` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `cel` int(20) NOT NULL,
  `puntaje` int(11) NOT NULL,
  `propuesta_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `cabecera_cv`
--

INSERT INTO `cabecera_cv` (`id`, `id_candidato`, `email`, `web`, `cel`, `puntaje`, `propuesta_id`) VALUES
(1, 1, 'pevera@hotmail.com', 'pevera.com', 1520365455, 0, 8),
(2, 2, 'chamorro@hotmail.com', 'burbujitas.com', 1520366569, 0, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `candidatos`
--

CREATE TABLE `candidatos` (
  `id_candidato` int(100) NOT NULL,
  `nombre_apel` varchar(30) COLLATE utf8_spanish2_ci NOT NULL,
  `edad` int(150) NOT NULL,
  `dni` int(11) NOT NULL,
  `estado` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `avatar` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `candidatos`
--

INSERT INTO `candidatos` (`id_candidato`, `nombre_apel`, `edad`, `dni`, `estado`, `avatar`) VALUES
(1, 'Pedro Vera', 35, 30255788, 'Rechazado', 0),
(2, 'Alejandro Fernandez', 40, 20245784, 'Preseleccionado', 1),
(5, 'Gustavo Suarez', 45, 20122133, 'Seleccionado', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `candidato_pass`
--

CREATE TABLE `candidato_pass` (
  `user` varchar(15) COLLATE utf8_spanish2_ci NOT NULL,
  `pass` text COLLATE utf8_spanish2_ci NOT NULL,
  `id_candidato` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `candidato_pass`
--

INSERT INTO `candidato_pass` (`user`, `pass`, `id_candidato`) VALUES
('aleli', 'zapatilla33', 2),
('gusta', '1234', 4),
('pepepillo', 'camaron', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `educacion`
--

CREATE TABLE `educacion` (
  `id` int(11) NOT NULL,
  `texto` text COLLATE utf8_spanish2_ci NOT NULL,
  `id_candidato` int(11) NOT NULL,
  `colegio` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `calificacion` double NOT NULL,
  `puntaje` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `educacion`
--

INSERT INTO `educacion` (`id`, `texto`, `id_candidato`, `colegio`, `calificacion`, `puntaje`) VALUES
(1, 'Bachiller con orientación en arte y diseño\r\n', 1, 'EEM n9', 8, 0),
(2, 'Licenciatura en Letras en la UBA', 1, 'UBA Filosofía y letras', 8, 0),
(3, 'Licenciatura en Economía en la UBA', 2, 'UBA Economía', 10, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `experiencia`
--

CREATE TABLE `experiencia` (
  `id` int(11) NOT NULL,
  `texto` text COLLATE utf8_spanish2_ci NOT NULL,
  `id_candidato` int(11) NOT NULL,
  `cargo` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `desde` date NOT NULL,
  `hasta` date NOT NULL,
  `puntaje` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `experiencia`
--

INSERT INTO `experiencia` (`id`, `texto`, `id_candidato`, `cargo`, `desde`, `hasta`, `puntaje`) VALUES
(1, 'Lavaplatos en resto de primera en Palermo, con gran experiencia en limpieza y manejo de empleados a cargo.', 1, 'Empleado', '0205-02-16', '2009-05-20', 0),
(2, 'Pintor de casas, reparaciones en gral, reestructuración de inmuebles.', 1, 'Pintor', '2012-10-10', '2015-01-05', 0),
(3, 'vendedor de ropa deportiva, en grandes casas de deportes. Actitud proactiva y sociable. Manejo de caja.', 2, 'Vendedor', '2011-10-10', '2017-05-10', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lema`
--

CREATE TABLE `lema` (
  `id` int(11) NOT NULL,
  `texto` text COLLATE utf8_spanish2_ci NOT NULL,
  `id_candidato` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `lema`
--

INSERT INTO `lema` (`id`, `texto`, `id_candidato`) VALUES
(1, 'Ser redituable para la empresa en la que trabaje, brindando toda mi capacidad y empeño para funcionar al servicio de la empresa', 1),
(2, 'Quiero aprender y crecer profesionalmente', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `probar_date`
--

CREATE TABLE `probar_date` (
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `probar_date`
--

INSERT INTO `probar_date` (`fecha`) VALUES
('2012-02-14');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `propuesta`
--

CREATE TABLE `propuesta` (
  `cargo` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `id` int(11) NOT NULL,
  `texto` text COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `propuesta`
--

INSERT INTO `propuesta` (`cargo`, `id`, `texto`) VALUES
('repositor', 5, 'Se busca repositor con más de 3 años de experiencia en el rubro. Se valorará actitud positiva. Sueldo acorde al mercado. Requisitos excluyentes: secundario completo.'),
('Vendedor tienda Falabella', 6, 'Se busca vendedor/a de ropa con experiencia en el rubro. Requisitos: Muy buena presencia y trato con el público. manejo del idioma inglés. Disponibilidad full-time.'),
('Programador Java FullStack', 8, 'Buscamos los mejores talentos en programación java.\r\nRequisitos:\r\nManejo de java EE, Maven, Git u otro controlador de versiones, Bases de datos relacionales, JS, React, Rest Bootstrap4, e idioma inglés. Sueldo acorde al mercado.');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `skill`
--

CREATE TABLE `skill` (
  `id` int(11) NOT NULL,
  `texto` text COLLATE utf8_spanish2_ci NOT NULL,
  `id_candidato` int(11) NOT NULL,
  `puntaje` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `skill`
--

INSERT INTO `skill` (`id`, `texto`, `id_candidato`, `puntaje`) VALUES
(1, 'manejo del paquete Office', 1, 0),
(2, 'Lectura veloz', 1, 0),
(3, 'Proactivo', 1, 0),
(4, 'Hablo inglés a nivel básico', 1, 0),
(5, 'Hablo inglés a nivel conversacional', 2, 0),
(6, 'Hablo chino', 2, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `nombre` varchar(50) COLLATE utf8_spanish2_ci NOT NULL,
  `pass` varchar(50) COLLATE utf8_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish2_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`nombre`, `pass`) VALUES
('Ale', 'd8578edf8458ce06fbc5bb76a58c5ca4');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cabecera_cv`
--
ALTER TABLE `cabecera_cv`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `candidatos`
--
ALTER TABLE `candidatos`
  ADD PRIMARY KEY (`id_candidato`);

--
-- Indices de la tabla `candidato_pass`
--
ALTER TABLE `candidato_pass`
  ADD PRIMARY KEY (`user`);

--
-- Indices de la tabla `educacion`
--
ALTER TABLE `educacion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `experiencia`
--
ALTER TABLE `experiencia`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `lema`
--
ALTER TABLE `lema`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `propuesta`
--
ALTER TABLE `propuesta`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `skill`
--
ALTER TABLE `skill`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`nombre`),
  ADD UNIQUE KEY `nombre` (`nombre`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cabecera_cv`
--
ALTER TABLE `cabecera_cv`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `candidatos`
--
ALTER TABLE `candidatos`
  MODIFY `id_candidato` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `educacion`
--
ALTER TABLE `educacion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `experiencia`
--
ALTER TABLE `experiencia`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `lema`
--
ALTER TABLE `lema`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `propuesta`
--
ALTER TABLE `propuesta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `skill`
--
ALTER TABLE `skill`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
