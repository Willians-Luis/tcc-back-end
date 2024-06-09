INSERT IGNORE INTO tb_roles (role_id, name) VALUES (1, 'admin');
INSERT IGNORE INTO tb_roles (role_id, name) VALUES (2, 'basic');

INSERT IGNORE INTO tb_users (email, name, password, registration_date)
VALUES ('admin@admin.com', 'admin', '$2a$10$J4EU7b/sbf8SwLhLpXAFWO0vZ/1zOyextYSX48s.4aBWiBDQEFrGO', '2024-01-31T16:07:21.123Z');

INSERT IGNORE INTO tipo_produto (id, nome, user_id) VALUES (1, 'REFRIGERANTE LATA', 1);
INSERT IGNORE INTO tipo_produto (id, nome, user_id) VALUES (2, 'REFRIGERANTE 2L', 1);
INSERT IGNORE INTO tipo_produto (id, nome, user_id) VALUES (3, 'CERVEJA LATA', 1);
INSERT IGNORE INTO tipo_produto (id, nome, user_id) VALUES (4, 'CERVEJA GARRAFA', 1);
INSERT IGNORE INTO tipo_produto (id, nome, user_id) VALUES (5, 'CERVEJA LITRO', 1);

INSERT IGNORE INTO produto (id, nome, quantidade, valor_custo, valor_venda, id_tipo, user_id, text_color, background_color, border_color)
VALUES (1, 'COCA COLA', 200, 2.95, 4, 1, 1, '#f0e9e9', '#782416', '#f0e9e9');
INSERT IGNORE INTO produto (id, nome, quantidade, valor_custo, valor_venda, id_tipo, user_id, text_color, background_color, border_color)
VALUES (2, 'COCA COLA ZERO', 200, 3, 5, 1, 1, '#f0e9e9', '#000', '#782416');
INSERT IGNORE INTO produto (id, nome, quantidade, valor_custo, valor_venda, id_tipo, user_id, text_color, background_color, border_color)
VALUES (3, 'FANTA UVA', 200, 2.75, 4, 1, 1, '#f0e9e9', '#623ce8', '#f0e9e9');
INSERT IGNORE INTO produto (id, nome, quantidade, valor_custo, valor_venda, id_tipo, user_id, text_color, background_color, border_color)
VALUES (4, 'FANTA LARANJA', 200, 2.75, 4, 1, 1, '#f0e9e9', '#db9a53', '##f0e9e9');
INSERT IGNORE INTO produto (id, nome, quantidade, valor_custo, valor_venda, id_tipo, user_id, text_color, background_color, border_color)
VALUES (5, 'FANTA GUARANA', 200, 2.75, 4, 1, 1, '#f0e9e9', '#2a571d', '#f0e9e9');
INSERT IGNORE INTO produto (id, nome, quantidade, valor_custo, valor_venda, id_tipo, user_id, text_color, background_color, border_color)
VALUES (6, 'PEPSI COLA', 200, 2.75, 4, 1, 1, '#f0e9e9', '#3f72bf', '#782416');
INSERT IGNORE INTO produto (id, nome, quantidade, valor_custo, valor_venda, id_tipo, user_id, text_color, background_color, border_color)
VALUES (7, 'SPRITE', 200, 2.75, 4, 1, 1, '#f0e9e9', '#4fa161', '#4052d6');
INSERT IGNORE INTO produto (id, nome, quantidade, valor_custo, valor_venda, id_tipo, user_id, text_color, background_color, border_color)
VALUES (8, 'GUARANA ANTARCTICA', 200, 2.75, 4, 1, 1, '#782416','#2b663d', '#f0e9e9');
INSERT IGNORE INTO produto (id, nome, quantidade, valor_custo, valor_venda, id_tipo, user_id, text_color, background_color, border_color)
VALUES (9, 'RIO BRANCO', 200, 5.59, 8, 2, 1, '#303f82','#367a36', '#f0e9e9');
INSERT IGNORE INTO produto (id, nome, quantidade, valor_custo, valor_venda, id_tipo, user_id, text_color, background_color, border_color)
VALUES (10, 'COCA COLA', 200, 8.59, 12, 2, 1, '#f0e9e9', '#782416', '#f0e9e9');
INSERT IGNORE INTO produto (id, nome, quantidade, valor_custo, valor_venda, id_tipo, user_id, text_color, background_color, border_color)
VALUES (11, 'SKOL', 200, 3, 4.5, 3, 1, '#d13317', '#e8aa0c', '#d13317');
INSERT IGNORE INTO produto (id, nome, quantidade, valor_custo, valor_venda, id_tipo, user_id, text_color, background_color, border_color)
VALUES (12, 'SKOL', 200, 5, 7, 4, 1, '#d13317', '#e8aa0c', '#d13317');
INSERT IGNORE INTO produto (id, nome, quantidade, valor_custo, valor_venda, id_tipo, user_id, text_color, background_color, border_color)
VALUES (13, 'SKOL', 200, 7, 10, 5, 1, '#d13317', '#e8aa0c', '#d13317');
INSERT IGNORE INTO produto (id, nome, quantidade, valor_custo, valor_venda, id_tipo, user_id, text_color, background_color, border_color)
VALUES (14, 'BRAHMA', 200, 2.7, 4, 3, 1, '#f0e9e9', '#782416', '#e8b23f');
INSERT IGNORE INTO produto (id, nome, quantidade, valor_custo, valor_venda, id_tipo, user_id, text_color, background_color, border_color)
VALUES (15, 'BRAHMA', 200, 5, 8, 4, 1, '#f0e9e9', '#782416', '#e8b23f');
INSERT IGNORE INTO produto (id, nome, quantidade, valor_custo, valor_venda, id_tipo, user_id, text_color, background_color, border_color)
VALUES (16, 'BRAHMA', 200, 7.5, 11, 5, 1, '#f0e9e9', '#782416', '#e8b23f');
INSERT IGNORE INTO produto (id, nome, quantidade, valor_custo, valor_venda, id_tipo, user_id, text_color, background_color, border_color)
VALUES (17, 'CONTI', 200, 2.5, 3.5, 3, 1, '#f0e9e9', '#782416', '#f0e9e9');
INSERT IGNORE INTO produto (id, nome, quantidade, valor_custo, valor_venda, id_tipo, user_id, text_color, background_color, border_color)
VALUES(18, 'CONTI', 200, 4, 6, 4, 1, '#f0e9e9', '#782416', '#f0e9e9');
INSERT IGNORE INTO produto (id, nome, quantidade, valor_custo, valor_venda, id_tipo, user_id, text_color, background_color, border_color)
VALUES (19, 'CONTI', 200, 6, 10, 5, 1, '#f0e9e9', '#782416', '#f0e9e9');


INSERT IGNORE INTO cliente (id, data_registro, nome, telefone, user_id) VALUES (1, '2024-01-31T16:07:21.123Z', 'Ana Clara', '(11) 99999-9999', 1);
INSERT IGNORE INTO cliente (id, data_registro, nome, telefone, user_id) VALUES (2, '2024-01-31T16:07:21.123Z', 'João Pedro', '(21) 98888-8888', 1);
INSERT IGNORE INTO cliente (id, data_registro, nome, telefone, user_id) VALUES (3, '2024-01-31T16:07:21.123Z', 'Beatriz Vitória', '(31) 97777-7777', 1);
INSERT IGNORE INTO cliente (id, data_registro, nome, telefone, user_id) VALUES (4, '2024-01-31T16:07:21.123Z', 'Gabriel Henrique', '(41) 96666-6666', 1);
INSERT IGNORE INTO cliente (id, data_registro, nome, telefone, user_id) VALUES (5, '2024-01-31T16:07:21.123Z', 'Isadora Sofia', '(51) 95555-5555', 1);
INSERT IGNORE INTO cliente (id, data_registro, nome, telefone, user_id) VALUES (6, '2024-01-31T16:07:21.123Z', 'Laura Manuela', '(85) 99876-5432', 1);
INSERT IGNORE INTO cliente (id, data_registro, nome, telefone, user_id) VALUES (7, '2024-01-31T16:07:21.123Z', 'Enzo Miguel', '(27) 93210-9876', 1);
INSERT IGNORE INTO cliente (id, data_registro, nome, telefone, user_id) VALUES (8, '2024-01-31T16:07:21.123Z', 'Alice Júlia', '(13) 94321-5678', 1);
INSERT IGNORE INTO cliente (id, data_registro, nome, telefone, user_id) VALUES (9, '2024-01-31T16:07:21.123Z', 'Bernardo Arthur', '(64) 97654-3210', 1);
INSERT IGNORE INTO cliente (id, data_registro, nome, telefone, user_id) VALUES (10, '2024-01-31T16:07:21.123Z', 'Sofia Helena', '(71) 99087-6543', 1);

INSERT IGNORE INTO venda (id, data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES (1, '2024-01-11T16:07:21.123Z', 11, true, 1, 10, 1);
INSERT IGNORE INTO venda (id, data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES (2, '2024-01-11T16:07:21.123Z', 12, true, 2, 1, 1);
INSERT IGNORE INTO venda (id, data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES (3, '2024-01-11T16:07:21.123Z', 13, true, 3, 12, 1);
INSERT IGNORE INTO venda (id, data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES (4, '2024-01-11T16:07:21.123Z', 14, true, 4, 1, 1);
INSERT IGNORE INTO venda (id, data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES (5, '2024-01-11T16:07:21.123Z', 15, true, 1, 17, 1);
INSERT IGNORE INTO venda (id, data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES (6, '2024-01-11T16:07:21.123Z', 16, true, 1, 2, 1);
INSERT IGNORE INTO venda (id, data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES (7, '2024-01-11T16:07:21.123Z', 17, true, 1, 3, 1);
INSERT IGNORE INTO venda (id, data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES (8, '2024-01-11T16:07:21.123Z', 18, true, 1, 4, 1);
INSERT IGNORE INTO venda (id, data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES (9, '2024-02-11T16:07:21.123Z', 19, true, 4, 5, 1);
INSERT IGNORE INTO venda (id, data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES (10, '2024-02-11T16:07:21.123Z', 20, true, 1, 6, 1);
INSERT IGNORE INTO venda (id, data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES (11, '2024-02-11T16:07:21.123Z', 19, true, 2, 7, 1);
INSERT IGNORE INTO venda (id, data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES (12, '2024-02-11T16:07:21.123Z', 18, true, 2, 8, 1);
INSERT IGNORE INTO venda (id, data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES (13, '2024-02-11T16:07:21.123Z', 17, true, 1, 9, 1);
INSERT IGNORE INTO venda (id, data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES (14, '2024-02-11T16:07:21.123Z', 16, true, 1, 10, 1);
INSERT IGNORE INTO venda (id, data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES (15, '2024-02-11T16:07:21.123Z', 15, true, 1, 11, 1);
INSERT IGNORE INTO venda (id, data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES (16, '2024-02-11T16:07:21.123Z', 14, true, 1, 12, 1);
INSERT IGNORE INTO venda (id, data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES (17, '2024-02-11T16:07:21.123Z', 13, true, 3, 13, 1);
INSERT IGNORE INTO venda (id, data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES (18, '2024-02-11T16:07:21.123Z', 12, true, 4, 14, 1);
INSERT IGNORE INTO venda (id, data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES (19, '2024-03-11T16:07:21.123Z', 11, true, 4, 15, 1);
INSERT IGNORE INTO venda (id, data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES (20, '2024-03-11T16:07:21.123Z', 10, true, 1, 16, 1);
INSERT IGNORE INTO venda (id, data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES (21, '2024-03-11T16:07:21.123Z', 11, true,3, 17, 1);
INSERT IGNORE INTO venda (id, data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES (22, '2024-03-11T16:07:21.123Z', 12, true, 3, 2, 1);
INSERT IGNORE INTO venda (id, data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES (23, '2024-03-11T16:07:21.123Z', 13, true, 1, 1, 1);
INSERT IGNORE INTO venda (id, data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES (24, '2024-03-11T16:07:21.123Z', 14, true, 5, 3, 1);
INSERT IGNORE INTO venda (id, data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES (25, '2024-03-11T16:07:21.123Z', 15, true, 5, 4, 1);
INSERT IGNORE INTO venda (id, data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES (26, '2024-03-11T16:07:21.123Z', 5, true, 1, 15, 1);
INSERT IGNORE INTO venda (id, data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES (27, '2024-03-11T16:07:21.123Z', 10, true, 4, 8, 1);
INSERT IGNORE INTO venda (id, data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES (28, '2024-03-11T16:07:21.123Z', 10, true, 3, 6, 1);
INSERT IGNORE INTO venda (id, data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES (29, '2024-03-11T16:07:21.123Z', 10, true, 2, 7, 1);
INSERT IGNORE INTO venda (id, data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES (30, '2024-03-11T16:07:21.123Z', 16, true, 1, 5, 1);
INSERT IGNORE INTO venda (id, data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES (31, '2024-04-11T16:07:21.123Z', 10, true, 5, 1, 1);
INSERT IGNORE INTO venda (id, data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES (32, '2024-04-11T16:07:21.123Z', 16, true, 5, 4, 1);
INSERT IGNORE INTO venda (id, data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES (33, '2024-04-11T16:07:21.123Z', 10, true, 5, 1, 1);
INSERT IGNORE INTO venda (id, data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES (34, '2024-04-11T16:07:21.123Z', 10, true, 2, 3, 1);
INSERT IGNORE INTO venda (id, data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES (35, '2024-04-11T16:07:21.123Z', 17, true, 1, 2, 1);

INSERT IGNORE INTO despesas (id, data_registro, descricao, valor, ano, mes, tipo, user_id) VALUES
(1, '2024-01-11T16:07:21.123Z', 'Salarios', 300, 2024, 1, "saida", 1);
INSERT IGNORE INTO despesas (id, data_registro, descricao, valor, ano, mes, tipo, user_id) VALUES
(2, '2024-02-11T16:07:21.123Z', 'despesas totais menos custo produto', 200, 2024, 2, "saida", 1);
INSERT IGNORE INTO despesas (id, data_registro, descricao, valor, ano, mes, tipo, user_id) VALUES
(3, '2024-03-11T16:07:21.123Z', 'despesas totais menos custo produto', 350, 2024, 3, "saida", 1);
INSERT IGNORE INTO despesas (id, data_registro, descricao, valor, ano, mes, tipo, user_id) VALUES
(4, '2024-04-11T16:07:21.123Z', 'despesas totais menos custo produto', 250, 2024, 4, "saida", 1);