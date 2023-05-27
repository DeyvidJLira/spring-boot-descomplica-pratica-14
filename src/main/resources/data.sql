INSERT INTO usuario (usuario_id, nome, email, password) VALUES (1, 'Deyvid', 'deyvid@ddd.com', '123456');

INSERT INTO projeto_status (projeto_status_id, nome) VALUES (1, 'Não Iniciado');
INSERT INTO projeto_status (projeto_status_id, nome) VALUES (2, 'Em Andamento');
INSERT INTO projeto_status (projeto_status_id, nome) VALUES (3, 'Concluído');

INSERT INTO tarefa_status (tarefa_status_id, nome) VALUES (1, 'Não Iniciada');
INSERT INTO tarefa_status (tarefa_status_id, nome) VALUES (2, 'Em Andamento');
INSERT INTO tarefa_status (tarefa_status_id, nome) VALUES (3, 'Concluída');

INSERT INTO projeto (projeto_id, nome, descricao, status) VALUES (1, 'Projeto 1', 'Descrição projeto 1', 1);