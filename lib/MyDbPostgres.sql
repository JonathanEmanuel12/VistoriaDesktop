-- Criação do banco de dados (opcional, geralmente feito fora do dump)
-- CREATE DATABASE mydb;

-- Conexão ao banco

-- Drop e criação da tabela `terreno`
DROP TABLE IF EXISTS terreno CASCADE;

CREATE TABLE terreno (
  ter_id SERIAL PRIMARY KEY,
  ter_latitude VARCHAR(45),
  ter_longitude VARCHAR(45),
  ter_estado VARCHAR(45),
  ter_cidade VARCHAR(45),
  ter_bairro VARCHAR(45),
  ter_rua VARCHAR(45),
  ter_numero INTEGER,
  ter_area DOUBLE PRECISION
);

-- Inserts para `terreno`
INSERT INTO terreno (
  ter_id, ter_latitude, ter_longitude, ter_estado, ter_cidade, ter_bairro, ter_rua, ter_numero, ter_area
) VALUES
  (1, '64°65´´46´S', '65°46´´54´L', 'Minas Gerais', NULL, 'Roseira', 'Francisco', 21, 40),
  (2, '16°54´´13´N', '65°45´´45´O', 'São Paulo', NULL, 'Coronéis', 'Jorge', 85, NULL),
  (3, '56°46´´85´L', '54°46´´55´S', 'Minas', 'Extrema', 'abc', '123', 20, 55),
  (4, '98°64´´53´S', '54°16´´51´L', 'dfgf', 'jhvjhg', 'jvkjhkn', 'jhggjvh', 21, NULL);

-- Drop e criação da tabela `usuario`
DROP TABLE IF EXISTS usuario CASCADE;

CREATE TABLE usuario (
  usu_id SERIAL PRIMARY KEY,
  usu_nome VARCHAR(45) NOT NULL,
  usu_login VARCHAR(45) NOT NULL,
  usu_senha VARCHAR(45) NOT NULL,
  usu_tipo INTEGER NOT NULL
);

-- Inserts para `usuario`
INSERT INTO usuario (
  usu_id, usu_nome, usu_login, usu_senha, usu_tipo
) VALUES
  (4, 'Matheus', 'mater', '4567', 0),
  (5, 'jonathan', 'jonta', '12345', 1),
  (6, 'Marcos', 'marc', '12345', 0),
  (7, 'Lucas', 'luca', '1234', 0),
  (8, 'Maheus', 'mate', '1234', 0);

-- Drop e criação da tabela `areairregular`
DROP TABLE IF EXISTS areairregular CASCADE;

CREATE TABLE areairregular (
  are_id SERIAL PRIMARY KEY,
  are_area_aprox DOUBLE PRECISION NOT NULL,
  are_descricao TEXT NOT NULL,
  are_ter_id INTEGER NOT NULL,
  CONSTRAINT fk_AreaIrregular_Terreno1 FOREIGN KEY (are_ter_id)
    REFERENCES terreno (ter_id)
);

-- Drop e criação da tabela `vistoria`
DROP TABLE IF EXISTS vistoria CASCADE;

CREATE TABLE vistoria (
  vis_id SERIAL PRIMARY KEY,
  vis_data_entrega DATE,
  vis_usu_id INTEGER NOT NULL,
  vis_ter_id INTEGER NOT NULL,
  vis_estado VARCHAR(45) NOT NULL,
  vis_observacoes TEXT,
  CONSTRAINT fk_Vistoria_Usuario FOREIGN KEY (vis_usu_id) REFERENCES usuario (usu_id),
  CONSTRAINT fk_Vistoria_Terreno1 FOREIGN KEY (vis_ter_id) REFERENCES terreno (ter_id)
);

-- Inserts para `vistoria`
INSERT INTO vistoria (
  vis_id, vis_data_entrega, vis_usu_id, vis_ter_id, vis_estado, vis_observacoes
) VALUES
  (1, '2019-05-20', 4, 1, 'Executando', NULL);
