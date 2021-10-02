--insert into user(id, authorities, email, first_name, is_active, is_not_locked, join_date, last_login_date, last_login_date_display, last_name, password, profile_image_url, role, user_id, username)
--value ('1', null, 'someone@one.com', 'some', 1, 1, sysdate(), sysdate(), null, 'one', '$2a$10$QCYsQc4ZSyZiCffUts5HYun5o678oXj2Y8ED2OUTU6A6reSiP/TJy', 'https://robohash.org/someone?set=set4', 'ROLE_USER', '1378290348', 'someone');

insert into contract(id, body, contract_image_urls, created_date, last_updated_date, legal_agreement, status, subject, type, accepted_offer_id, contractee_id, contractor_id)
values (3, 'Test 2 body for a new contract', null, sysdate(), sysdate(), null, null, 'test2', null, null, 1, null);

insert into contract(id, body, contract_image_urls, created_date, last_updated_date, legal_agreement, status, subject, type, accepted_offer_id, contractee_id, contractor_id)
values (4, 'Test 3 body for a new contract', null, sysdate(), sysdate(), null, null, 'test3', null, null, 1, null);

insert into offer(id, amount, amount_type, approved, comment, created_date, last_updated_date, user_id, username, contract_id)
values (1, "2.50", "USD", false, "I will give you $2.50", sysdate(), sysdate(), 2, 'another', 3);

insert into offer(id, amount, amount_type, approved, comment, created_date, last_updated_date, user_id, username, contract_id)
values (2, "3.50", "USD", false, "I will give you $3.50", sysdate(), sysdate(), 2, 'another', 3);

insert into offer(id, amount, amount_type, approved, comment, created_date, last_updated_date, user_id, username, contract_id)
values (3, "4.50", "USD", false, "I will give you $4.50", sysdate(), sysdate(), 2, 'another', 3);

insert into offer(id, amount, amount_type, approved, comment, created_date, last_updated_date, user_id, username, contract_id)
values (4, "5.50", "USD", false, "I will give you $5.50", sysdate(), sysdate(), 2, 'another', 4);

insert into offer(id, amount, amount_type, approved, comment, created_date, last_updated_date, user_id, username, contract_id)
values (5, "6.50", "USD", false, "I will give you $6.50", sysdate(), sysdate(), 2, 'another', 4);
