INSERT INTO projeto_status (projeto_status_id, nome) VALUES (1, 'Nao Iniciado');
INSERT INTO projeto_status (projeto_status_id, nome) VALUES (2, 'Em Andamento');
INSERT INTO projeto_status (projeto_status_id, nome) VALUES (3, 'Concluido');

INSERT INTO tarefa_status (tarefa_status_id, nome) VALUES (1, 'Nao Iniciada');
INSERT INTO tarefa_status (tarefa_status_id, nome) VALUES (2, 'Em Andamento');
INSERT INTO tarefa_status (tarefa_status_id, nome) VALUES (3, 'Concluida');

INSERT INTO projeto (projeto_id, nome, descricao, status, created_at) VALUES (1, 'Projeto 1', 'Descricao projeto 1', 1, '2023-05-27T19:30:56.881879Z');

INSERT INTO recurso (recurso_id, nome, funcao) VALUES (1, 'Um cara', 'Desenvolvedor');

INSERT INTO tarefa (tarefa_id, nome, descricao, status, created_at, projeto) VALUES (1, 'Tarefa 1', 'Descricao tarefa 1', 2, '2023-05-27T19:30:56.881879Z', 1);

INSERT INTO recursos_projetos (projeto_id, recurso_id) VALUES (1, 1)