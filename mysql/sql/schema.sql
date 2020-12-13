USE spring;

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `nome` varchar(45) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

INSERT INTO `role` (`id`, `nome`) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_CLIENT');

CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 1),
(2, 1),
(3, 2);

CREATE TABLE `usuarios` (
  `id` int(10) UNSIGNED NOT NULL,
  `user` varchar(50) NOT NULL,
  `password` varchar(200) NOT NULL,
  `nome` varchar(50) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

INSERT INTO `usuarios` (`id`, `user`, `password`, `nome`) VALUES
(1, 'matheus', '{bcrypt}$2a$10$7CuDZa3mvo./it7I4Gqe3uwp3z0eRr1eUp71vig74QhExhKcWBkry', 'Matheus Soares dos Santos Araújo'),
(2, 'admin', '{bcrypt}$2a$10$7CuDZa3mvo./it7I4Gqe3uwp3z0eRr1eUp71vig74QhExhKcWBkry', 'Admin'),
(3, 'cliente', '{bcrypt}$2a$10$zGfGF70jSowqOrX..zkJoeGXhQu9W6iiN1EK.fAwy0ZFwQABPaaAC', 'Cliente');

ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `user_role`
  ADD PRIMARY KEY (`user_id`,`role_id`);

ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `user` (`user`);

ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;

--
-- AUTO_INCREMENT de tabela `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1;