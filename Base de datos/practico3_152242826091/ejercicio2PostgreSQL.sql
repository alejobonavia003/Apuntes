--
-- PostgreSQL database dump
--

-- Started on 2015-04-19 21:14:49

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

--
-- TOC entry 5 (class 2615 OID 43227)
-- Name: ejercicio2; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA ejercicio2;


ALTER SCHEMA ejercicio2 OWNER TO postgres;

SET search_path = ejercicio2, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 1498 (class 1259 OID 43231)
-- Dependencies: 5
-- Name: club; Type: TABLE; Schema: ejercicio2; Owner: postgres; Tablespace: 
--

CREATE TABLE club (
    "NRO_CLUB" integer NOT NULL,
    "NOMBRE_CLUB" character varying(30) NOT NULL,
    "PRESUPUESTO" integer
);


ALTER TABLE ejercicio2.club OWNER TO postgres;

--
-- TOC entry 1499 (class 1259 OID 43234)
-- Dependencies: 5
-- Name: competencia; Type: TABLE; Schema: ejercicio2; Owner: postgres; Tablespace: 
--

CREATE TABLE competencia (
    "NRO_COMPETENCIA" integer NOT NULL,
    "DESCRIPCION" character varying(30) NOT NULL,
    "CATEGORIA" integer NOT NULL
);


ALTER TABLE ejercicio2.competencia OWNER TO postgres;

--
-- TOC entry 1500 (class 1259 OID 43237)
-- Dependencies: 5
-- Name: participacion; Type: TABLE; Schema: ejercicio2; Owner: postgres; Tablespace: 
--

CREATE TABLE participacion (
    "NRO_CLUB" integer NOT NULL,
    "NRO_COMPETENCIA" integer NOT NULL,
    "PUESTO" character varying(20)
);


ALTER TABLE ejercicio2.participacion OWNER TO postgres;

--
-- TOC entry 1778 (class 0 OID 43231)
-- Dependencies: 1498
-- Data for Name: club; Type: TABLE DATA; Schema: ejercicio2; Owner: postgres
--

INSERT INTO club ("NRO_CLUB", "NOMBRE_CLUB", "PRESUPUESTO") VALUES (1, 'Atletico Estudiantes', 35000);
INSERT INTO club ("NRO_CLUB", "NOMBRE_CLUB", "PRESUPUESTO") VALUES (2, 'Banda Norte', 27501);
INSERT INTO club ("NRO_CLUB", "NOMBRE_CLUB", "PRESUPUESTO") VALUES (3, 'Atenas', 19700);
INSERT INTO club ("NRO_CLUB", "NOMBRE_CLUB", "PRESUPUESTO") VALUES (4, 'Sportivo Municipal', 21640);
INSERT INTO club ("NRO_CLUB", "NOMBRE_CLUB", "PRESUPUESTO") VALUES (5, 'Atletico Adelia Maria', 22000);
INSERT INTO club ("NRO_CLUB", "NOMBRE_CLUB", "PRESUPUESTO") VALUES (6, 'Atletico Sampacho', 18000);
INSERT INTO club ("NRO_CLUB", "NOMBRE_CLUB", "PRESUPUESTO") VALUES (7, 'Alianza Moldes', 65200);


--
-- TOC entry 1779 (class 0 OID 43234)
-- Dependencies: 1499
-- Data for Name: competencia; Type: TABLE DATA; Schema: ejercicio2; Owner: postgres
--

INSERT INTO competencia ("NRO_COMPETENCIA", "DESCRIPCION", "CATEGORIA") VALUES (1, 'torneo de futbol infantil', 5);
INSERT INTO competencia ("NRO_COMPETENCIA", "DESCRIPCION", "CATEGORIA") VALUES (2, 'torneo de futbol juvenil', 2);
INSERT INTO competencia ("NRO_COMPETENCIA", "DESCRIPCION", "CATEGORIA") VALUES (3, 'torneo de futbol veteranos', 5);
INSERT INTO competencia ("NRO_COMPETENCIA", "DESCRIPCION", "CATEGORIA") VALUES (4, 'torneo de tenis infantil', 5);
INSERT INTO competencia ("NRO_COMPETENCIA", "DESCRIPCION", "CATEGORIA") VALUES (5, 'torneo de tenis juvenil', 3);
INSERT INTO competencia ("NRO_COMPETENCIA", "DESCRIPCION", "CATEGORIA") VALUES (6, 'torneo de tenis veteranos', 6);
INSERT INTO competencia ("NRO_COMPETENCIA", "DESCRIPCION", "CATEGORIA") VALUES (7, 'torneo de basquet infantil', 3);
INSERT INTO competencia ("NRO_COMPETENCIA", "DESCRIPCION", "CATEGORIA") VALUES (8, 'torneo de basquet juvenil', 1);
INSERT INTO competencia ("NRO_COMPETENCIA", "DESCRIPCION", "CATEGORIA") VALUES (9, 'torneo de basquet veteranos', 2);


--
-- TOC entry 1780 (class 0 OID 43237)
-- Dependencies: 1500
-- Data for Name: participacion; Type: TABLE DATA; Schema: ejercicio2; Owner: postgres
--

INSERT INTO participacion ("NRO_CLUB", "NRO_COMPETENCIA", "PUESTO") VALUES (1, 1, 'primer puesto');
INSERT INTO participacion ("NRO_CLUB", "NRO_COMPETENCIA", "PUESTO") VALUES (2, 1, 'segundo puesto');
INSERT INTO participacion ("NRO_CLUB", "NRO_COMPETENCIA", "PUESTO") VALUES (3, 3, 'tercer puesto');
INSERT INTO participacion ("NRO_CLUB", "NRO_COMPETENCIA", "PUESTO") VALUES (4, 2, 'primer puesto');
INSERT INTO participacion ("NRO_CLUB", "NRO_COMPETENCIA", "PUESTO") VALUES (5, 4, 'segundo puesto');
INSERT INTO participacion ("NRO_CLUB", "NRO_COMPETENCIA", "PUESTO") VALUES (1, 2, 'primer puesto');
INSERT INTO participacion ("NRO_CLUB", "NRO_COMPETENCIA", "PUESTO") VALUES (6, 7, 'segundo puesto');
INSERT INTO participacion ("NRO_CLUB", "NRO_COMPETENCIA", "PUESTO") VALUES (3, 9, 'tercer puesto');


-- Completed on 2015-04-19 21:14:50

--
-- PostgreSQL database dump complete
--

