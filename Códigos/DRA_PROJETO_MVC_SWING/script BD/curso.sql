--
-- Database: 'sysControleAcademico'
--
CREATE DATABASE sysControleAcademico;

use sysControleAcademico;
-- --------------------------------------------------------

--
-- Table structure for table 'curso'
--

CREATE TABLE curso(
  idCurso bigint NOT NULL AUTO_INCREMENT,
  sigla varchar(10) NOT NULL,
  descricao  varchar(100) NOT NULL,
  primary key (idCurso)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
