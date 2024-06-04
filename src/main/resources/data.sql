INSERT IGNORE INTO tb_roles (role_id, name) VALUES (1, 'admin');
INSERT IGNORE INTO tb_roles (role_id, name) VALUES (2, 'basic');

INSERT IGNORE INTO tb_users (email, name, password, registration_date)
VALUES ('admin@admin.com', 'admin', '$2a$10$J4EU7b/sbf8SwLhLpXAFWO0vZ/1zOyextYSX48s.4aBWiBDQEFrGO', '2024-01-31T16:07:21.123Z');

INSERT IGNORE INTO tipo_produto (nome, user_id) VALUES ('REFRIGERANTE LATA', 1);
INSERT IGNORE INTO tipo_produto (nome, user_id) VALUES ('REFRIGERANTE 2L', 1);
INSERT IGNORE INTO tipo_produto (nome, user_id) VALUES ('CERVEJA LATA', 1);
INSERT IGNORE INTO tipo_produto (nome, user_id) VALUES ('CERVEJA GARRAFA', 1);
INSERT IGNORE INTO tipo_produto (nome, user_id) VALUES ('CERVEJA LITRO', 1);

INSERT IGNORE INTO produto (nome, quantidade, valor_custo, valor_venda, id_tipo, user_id, text_color, background_color) VALUES
('COCA COLA', 200, 2.95, 4, 1, 1, '#f7f3f2', '#d13317');
INSERT IGNORE INTO produto (nome, quantidade, valor_custo, valor_venda, id_tipo, user_id, text_color, background_color) VALUES
('COCA COLA ZERO', 200, 3, 5, 1, 1, '#ff0000', '#000000');
INSERT IGNORE INTO produto (nome, quantidade, valor_custo, valor_venda, id_tipo, user_id, text_color, background_color) VALUES
('FANTA UVA', 200, 2.75, 4, 1, 1, '#ffffff', '#623ce8');
INSERT IGNORE INTO produto (nome, quantidade, valor_custo, valor_venda, id_tipo, user_id, text_color, background_color) VALUES
('FANTA LARANJA', 200, 2.75, 4, 1, 1, '#ffffff', '#db9a53');
INSERT IGNORE INTO produto (nome, quantidade, valor_custo, valor_venda, id_tipo, user_id, text_color, background_color) VALUES
('FANTA GUARANA', 200, 2.75, 4, 1, 1, '#ffffff', '#2a571d');
INSERT IGNORE INTO produto (nome, quantidade, valor_custo, valor_venda, id_tipo, user_id, text_color, background_color) VALUES
('PEPSI COLA', 200, 2.75, 4, 1, 1, '#ffffff', '#3f72bf');
INSERT IGNORE INTO produto (nome, quantidade, valor_custo, valor_venda, id_tipo, user_id, text_color, background_color) VALUES
('SPRITE', 200, 2.75, 4, 1, 1, '#ffffff', '#346e41');
INSERT IGNORE INTO produto (nome, quantidade, valor_custo, valor_venda, id_tipo, user_id, text_color, background_color) VALUES
('GUARANA ANTARCTICA', 200, 2.75, 4, 1, 1, '#ff0000','#2b663d');
INSERT IGNORE INTO produto (nome, quantidade, valor_custo, valor_venda, id_tipo, user_id, text_color, background_color) VALUES
('RIO BRANCO', 200, 5.59, 8, 2, 1, '#303f82','#367a36');
INSERT IGNORE INTO produto (nome, quantidade, valor_custo, valor_venda, id_tipo, user_id, text_color, background_color) VALUES
('COCA COLA', 200, 8.59, 12, 2, 1, '#f7f3f2', '#d13317');
INSERT IGNORE INTO produto (nome, quantidade, valor_custo, valor_venda, id_tipo, user_id, text_color, background_color) VALUES
('SKOL', 200, 3, 4.5, 3, 1, '#d13317', '#e8aa0c');
INSERT IGNORE INTO produto (nome, quantidade, valor_custo, valor_venda, id_tipo, user_id, text_color, background_color) VALUES
('SKOL', 200, 5, 7, 4, 1, '#d13317', '#e8aa0c');
INSERT IGNORE INTO produto (nome, quantidade, valor_custo, valor_venda, id_tipo, user_id, text_color, background_color) VALUES
('SKOL', 200, 7, 10, 5, 1, '#d13317', '#e8aa0c');
INSERT IGNORE INTO produto (nome, quantidade, valor_custo, valor_venda, id_tipo, user_id, text_color, background_color) VALUES
('BRAHMA', 200, 2.7, 4, 3, 1, '#f0d44a', '#ff0000');
INSERT IGNORE INTO produto (nome, quantidade, valor_custo, valor_venda, id_tipo, user_id, text_color, background_color) VALUES
('BRAHMA', 200, 5, 8, 4, 1, '#f0d44a', '#ff0000');
INSERT IGNORE INTO produto (nome, quantidade, valor_custo, valor_venda, id_tipo, user_id, text_color, background_color) VALUES
('BRAHMA', 200, 7.5, 11, 5, 1, '#f0d44a', '#ff0000');
INSERT IGNORE INTO produto (nome, quantidade, valor_custo, valor_venda, id_tipo, user_id, text_color, background_color) VALUES
('CONTI', 200, 2.5, 3.5, 3, 1, '#f7f3f2', '#d13317');
INSERT IGNORE INTO produto (nome, quantidade, valor_custo, valor_venda, id_tipo, user_id, text_color, background_color) VALUES
('CONTI', 200, 4, 6, 4, 1, '#f7f3f2', '#d13317');
INSERT IGNORE INTO produto (nome, quantidade, valor_custo, valor_venda, id_tipo, user_id, text_color, background_color) VALUES
('CONTI', 200, 6, 10, 5, 1, '#f7f3f2', '#d13317');


INSERT IGNORE INTO cliente (data_registro, nome, telefone, user_id) VALUES ('2024-01-31T16:07:21.123Z', 'Ana Clara', '(11) 99999-9999', 1);
INSERT IGNORE INTO cliente (data_registro, nome, telefone, user_id) VALUES ('2024-01-31T16:07:21.123Z', 'João Pedro', '(21) 98888-8888', 1);
INSERT IGNORE INTO cliente (data_registro, nome, telefone, user_id) VALUES ('2024-01-31T16:07:21.123Z', 'Beatriz Vitória', '(31) 97777-7777', 1);
INSERT IGNORE INTO cliente (data_registro, nome, telefone, user_id) VALUES ('2024-01-31T16:07:21.123Z', 'Gabriel Henrique', '(41) 96666-6666', 1);
INSERT IGNORE INTO cliente (data_registro, nome, telefone, user_id) VALUES ('2024-01-31T16:07:21.123Z', 'Isadora Sofia', '(51) 95555-5555', 1);
INSERT IGNORE INTO cliente (data_registro, nome, telefone, user_id) VALUES ('2024-01-31T16:07:21.123Z', 'Laura Manuela', '(85) 99876-5432', 1);
INSERT IGNORE INTO cliente (data_registro, nome, telefone, user_id) VALUES ('2024-01-31T16:07:21.123Z', 'Enzo Miguel', '(27) 93210-9876', 1);
INSERT IGNORE INTO cliente (data_registro, nome, telefone, user_id) VALUES ('2024-01-31T16:07:21.123Z', 'Alice Júlia', '(13) 94321-5678', 1);
INSERT IGNORE INTO cliente (data_registro, nome, telefone, user_id) VALUES ('2024-01-31T16:07:21.123Z', 'Bernardo Arthur', '(64) 97654-3210', 1);
INSERT IGNORE INTO cliente (data_registro, nome, telefone, user_id) VALUES ('2024-01-31T16:07:21.123Z', 'Sofia Helena', '(71) 99087-6543', 1);

INSERT IGNORE INTO venda (data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES ('2024-01-11T16:07:21.123Z', 11, true, 1, 10, 1);
INSERT IGNORE INTO venda (data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES ('2024-01-11T16:07:21.123Z', 12, true, 2, 1, 1);
INSERT IGNORE INTO venda (data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES ('2024-01-11T16:07:21.123Z', 13, true, 3, 12, 1);
INSERT IGNORE INTO venda (data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES ('2024-01-11T16:07:21.123Z', 14, true, 4, 1, 1);
INSERT IGNORE INTO venda (data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES ('2024-01-11T16:07:21.123Z', 15, true, 1, 17, 1);
INSERT IGNORE INTO venda (data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES ('2024-01-11T16:07:21.123Z', 16, true, 1, 2, 1);
INSERT IGNORE INTO venda (data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES ('2024-01-11T16:07:21.123Z', 17, true, 1, 3, 1);
INSERT IGNORE INTO venda (data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES ('2024-01-11T16:07:21.123Z', 18, true, 1, 4, 1);
INSERT IGNORE INTO venda (data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES ('2024-02-11T16:07:21.123Z', 19, true, 4, 5, 1);
INSERT IGNORE INTO venda (data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES ('2024-02-11T16:07:21.123Z', 20, true, 1, 6, 1);
INSERT IGNORE INTO venda (data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES ('2024-02-11T16:07:21.123Z', 19, true, 2, 7, 1);
INSERT IGNORE INTO venda (data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES ('2024-02-11T16:07:21.123Z', 18, true, 2, 8, 1);
INSERT IGNORE INTO venda (data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES ('2024-02-11T16:07:21.123Z', 17, true, 1, 9, 1);
INSERT IGNORE INTO venda (data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES ('2024-02-11T16:07:21.123Z', 16, true, 1, 10, 1);
INSERT IGNORE INTO venda (data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES ('2024-02-11T16:07:21.123Z', 15, true, 1, 11, 1);
INSERT IGNORE INTO venda (data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES ('2024-02-11T16:07:21.123Z', 14, true, 1, 12, 1);
INSERT IGNORE INTO venda (data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES ('2024-02-11T16:07:21.123Z', 13, true, 3, 13, 1);
INSERT IGNORE INTO venda (data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES ('2024-02-11T16:07:21.123Z', 12, true, 4, 14, 1);
INSERT IGNORE INTO venda (data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES ('2024-03-11T16:07:21.123Z', 11, true, 4, 15, 1);
INSERT IGNORE INTO venda (data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES ('2024-03-11T16:07:21.123Z', 10, true, 1, 16, 1);
INSERT IGNORE INTO venda (data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES ('2024-03-11T16:07:21.123Z', 11, true,3, 17, 1);
INSERT IGNORE INTO venda (data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES ('2024-03-11T16:07:21.123Z', 12, true, 3, 2, 1);
INSERT IGNORE INTO venda (data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES ('2024-03-11T16:07:21.123Z', 13, true, 1, 1, 1);
INSERT IGNORE INTO venda (data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES ('2024-03-11T16:07:21.123Z', 14, true, 5, 3, 1);
INSERT IGNORE INTO venda (data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES ('2024-03-11T16:07:21.123Z', 15, true, 5, 4, 1);
INSERT IGNORE INTO venda (data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES ('2024-03-11T16:07:21.123Z', 5, true, 1, 15, 1);
INSERT IGNORE INTO venda (data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES ('2024-03-11T16:07:21.123Z', 10, true, 4, 8, 1);
INSERT IGNORE INTO venda (data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES ('2024-03-11T16:07:21.123Z', 10, true, 3, 6, 1);
INSERT IGNORE INTO venda (data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES ('2024-03-11T16:07:21.123Z', 10, true, 2, 7, 1);
INSERT IGNORE INTO venda (data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES ('2024-03-11T16:07:21.123Z', 16, true, 1, 5, 1);
INSERT IGNORE INTO venda (data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES ('2024-04-11T16:07:21.123Z', 10, true, 5, 1, 1);
INSERT IGNORE INTO venda (data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES ('2024-04-11T16:07:21.123Z', 16, true, 5, 4, 1);
INSERT IGNORE INTO venda (data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES ('2024-04-11T16:07:21.123Z', 10, true, 5, 1, 1);
INSERT IGNORE INTO venda (data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES ('2024-04-11T16:07:21.123Z', 10, true, 2, 3, 1);
INSERT IGNORE INTO venda (data_venda, quantidade, status, id_cliente, id_produto, user_id) VALUES ('2024-04-11T16:07:21.123Z', 17, true, 1, 2, 1);

INSERT IGNORE INTO despesas (valor, ano, mes, user_id) VALUES (300, 1, 2024, 1);
INSERT IGNORE INTO despesas (valor, ano, mes, user_id) VALUES (200, 2, 2024, 1);
INSERT IGNORE INTO despesas (valor, ano, mes, user_id) VALUES (350, 3, 2024, 1);
INSERT IGNORE INTO despesas (valor, ano, mes, user_id) VALUES (250, 4, 2024, 1);


