--
-- SETTING UP CATEGORIES
--
insert into category(id, name)
values (1, 'art');
insert into category(id, name)
values (2, 'automotive');
insert into category(id, name)
values (3, 'trading cards');
insert into category(id, name)
values (4, 'coins');
insert into category(id, name)
values (5, 'jewelry');
insert into category(id, name)
values (6, 'video games');

--
-- SETTING UP SUB CATEGORIES
insert into sub_category(id, name)
values (1, 'other');
-- art
insert into sub_category(id, name)
values (2, 'paintings');
insert into sub_category(id, name)
values (3, 'drawings');
insert into sub_category(id, name)
values (4, 'digital');
insert into sub_category(id, name)
values (5, 'sculpture');
insert into sub_category(id, name)
values (6, 'photography');
-- automotive
insert into sub_category(id, name)
values (7, 'cars');
insert into sub_category(id, name)
values (8, 'trucks');
insert into sub_category(id, name)
values (9, 'motorcycles');
insert into sub_category(id, name)
values (10, 'boats');
-- cards
insert into sub_category(id, name)
values (11, 'pokemon');
insert into sub_category(id, name)
values (12, 'magic the gathering');
insert into sub_category(id, name)
values (13, 'yugioh');
insert into sub_category(id, name)
values (14, 'spots');
-- coins
insert into sub_category(id, name)
values (15, 'crypto');
insert into sub_category(id, name)
values (16, 'physical');
-- jewelry
insert into sub_category(id, name)
values (17, 'earrings');
insert into sub_category(id, name)
values (18, 'necklace');
insert into sub_category(id, name)
values (19, 'bracelet');
insert into sub_category(id, name)
values (20, 'cuff links');
insert into sub_category(id, name)
values (21, 'gems');
insert into sub_category(id, name)
values (22, 'stones');
-- video games
insert into sub_category(id, name)
values (23, 'factory sealed');


--
-- SETTING UP MANY TO MANY FOR CATEGORIES & SUB CATEGORIES
-- art
insert into category_sub_categories(categories_id, sub_categories_id)
values (1, 1);
insert into category_sub_categories(categories_id, sub_categories_id)
values (1, 2);
insert into category_sub_categories(categories_id, sub_categories_id)
values (1, 3);
insert into category_sub_categories(categories_id, sub_categories_id)
values (1, 4);
insert into category_sub_categories(categories_id, sub_categories_id)
values (1, 5);
insert into category_sub_categories(categories_id, sub_categories_id)
values (1, 6);
-- automotive
insert into category_sub_categories(categories_id, sub_categories_id)
values (2, 1);
insert into category_sub_categories(categories_id, sub_categories_id)
values (2, 7);
insert into category_sub_categories(categories_id, sub_categories_id)
values (2, 8);
insert into category_sub_categories(categories_id, sub_categories_id)
values (2, 9);
insert into category_sub_categories(categories_id, sub_categories_id)
values (2, 10);
-- cards
insert into category_sub_categories(categories_id, sub_categories_id)
values (3, 1);
insert into category_sub_categories(categories_id, sub_categories_id)
values (3, 11);
insert into category_sub_categories(categories_id, sub_categories_id)
values (3, 12);
insert into category_sub_categories(categories_id, sub_categories_id)
values (3, 13);
insert into category_sub_categories(categories_id, sub_categories_id)
values (3, 14);
-- coins
insert into category_sub_categories(categories_id, sub_categories_id)
values (4, 1);
insert into category_sub_categories(categories_id, sub_categories_id)
values (4, 15);
insert into category_sub_categories(categories_id, sub_categories_id)
values (4, 16);
-- jewelry
insert into category_sub_categories(categories_id, sub_categories_id)
values (5, 1);
insert into category_sub_categories(categories_id, sub_categories_id)
values (5, 17);
insert into category_sub_categories(categories_id, sub_categories_id)
values (5, 18);
insert into category_sub_categories(categories_id, sub_categories_id)
values (5, 19);
insert into category_sub_categories(categories_id, sub_categories_id)
values (5, 20);
insert into category_sub_categories(categories_id, sub_categories_id)
values (5, 21);
insert into category_sub_categories(categories_id, sub_categories_id)
values (5, 22);
-- video games
insert into category_sub_categories(categories_id, sub_categories_id)
values (6, 1);
insert into category_sub_categories(categories_id, sub_categories_id)
values (6, 23);


--
-- CREATES USER
--
--insert into user(id, authorities, email, first_name, is_active, is_not_locked, join_date, last_login_date, last_login_date_display, last_name, password, profile_image_url, role, user_id, username)
--value ('1', null, 'someone@one.com', 'some', 1, 1, sysdate(), sysdate(), null, 'one', '$2a$10$QCYsQc4ZSyZiCffUts5HYun5o678oXj2Y8ED2OUTU6A6reSiP/TJy', 'https://robohash.org/someone?set=set4', 'ROLE_USER', '1378290348', 'someone');


--
-- demo data might delete
--
--insert into contract(id, body, contract_image_urls, created_date, last_updated_date, legal_agreement, status, subject, type, accepted_offer_id, contractee_id, contractor_id)
--values (3, 'Test 2 body for a new contract', null, sysdate(), sysdate(), null, null, 'test2', null, null, 1, null);
--
--insert into contract(id, body, contract_image_urls, created_date, last_updated_date, legal_agreement, status, subject, type, accepted_offer_id, contractee_id, contractor_id)
--values (4, 'Test 3 body for a new contract', null, sysdate(), sysdate(), null, null, 'test3', null, null, 1, null);
--
--insert into contract(id, body, contract_image_urls, created_date, last_updated_date, legal_agreement, status, subject, type, accepted_offer_id, contractee_id, contractor_id)
--values (5, 'Test 4 body for a new contract', null, sysdate(), sysdate(), null, null, 'test2', null, null, 2, null);
--
--insert into offer(id, amount, amount_type, approved, comment, created_date, last_updated_date, user_id, contract_id)
--values (1, "2.50", "USD", false, "I will give you $2.50", sysdate(), sysdate(), 2, 3);
--
--insert into offer(id, amount, amount_type, approved, comment, created_date, last_updated_date, user_id, contract_id)
--values (2, "3.50", "USD", false, "I will give you $3.50", sysdate(), sysdate(), 2, 3);
--
--insert into offer(id, amount, amount_type, approved, comment, created_date, last_updated_date, user_id, contract_id)
--values (3, "4.50", "USD", false, "I will give you $4.50", sysdate(), sysdate(), 2, 3);
--
--insert into offer(id, amount, amount_type, approved, comment, created_date, last_updated_date, user_id, contract_id)
--values (4, "5.50", "USD", false, "I will give you $5.50", sysdate(), sysdate(), 2, 4);
--
--insert into offer(id, amount, amount_type, approved, comment, created_date, last_updated_date, user_id, contract_id)
--values (5, "6.50", "USD", false, "I will give you $6.50", sysdate(), sysdate(), 2, 4);
