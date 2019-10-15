-- Database: "syscontroleacademico"

CREATE DATABASE IF NOT EXISTS sysvendas;

USE sysvendas;

-- --------------------------------------------------------

--
-- Table structure for table "produto"
--
CREATE TABLE produto (
  id int(11) NOT NULL AUTO_INCREMENT,
  nome varchar(250) NOT NULL
  nome float NOT NULL
  primary key (id)
) ENGINE=INNODB DEFAULT CHARSET=latin1;


INSERT INTO produto (id, nome, valor) VALUES
(0, 'TV', 2500.00);


