--
-- SETTING UP CATEGORIES
--
insert into category(id, name)
values (1, 'sale');
insert into category(id, name)
values (2, 'maintenance');
insert into category(id, name)
values (3, 'rental');
insert into category(id, name)
values (4, 'construction');
insert into category(id, name)
values (5, 'service');

--
-- SETTING UP SUB CATEGORIES
-- items
insert into sub_category(id, name)
values (1, 'cars');
insert into sub_category(id, name)
values (2, 'electronics');
insert into sub_category(id, name)
values (3, 'tools');
insert into sub_category(id, name)
values (4, 'boats');
insert into sub_category(id, name)
values (5, 'books');
insert into sub_category(id, name)
values (6, 'art');
insert into sub_category(id, name)
values (7, 'pets');
insert into sub_category(id, name)
values (8, 'aquariums');
insert into sub_category(id, name)
values (9, 'food');
insert into sub_category(id, name)
values (10, 'free');
insert into sub_category(id, name)
values (11, 'computers');
insert into sub_category(id, name)
values (12, 'cell phones');
insert into sub_category(id, name)
values (13, 'collectable');
insert into sub_category(id, name)
values (14, 'bikes');
insert into sub_category(id, name)
values (15, 'automotive');
insert into sub_category(id, name)
values (16, 'motorcycle');
insert into sub_category(id, name)
values (17, 'furniture');
insert into sub_category(id, name)
values (18, 'sports');
insert into sub_category(id, name)
values (19, 'videogames');
insert into sub_category(id, name)
values (20, 'plants');
insert into sub_category(id, name)
values (21, 'toys');
insert into sub_category(id, name)
values (22, 'clothes');
-- maintenance
insert into sub_category(id, name)
values (23, 'lawn');
insert into sub_category(id, name)
values (24, 'plumber');
insert into sub_category(id, name)
values (25, 'electrician');
insert into sub_category(id, name)
values (26, 'hvac');
insert into sub_category(id, name)
values (27, 'pool');
insert into sub_category(id, name)
values (28, 'ponds');
insert into sub_category(id, name)
values (29, 'ac');
insert into sub_category(id, name)
values (30, 'mechanic');
insert into sub_category(id, name)
values (31, 'repairs');
-- rental
insert into sub_category(id, name)
values (32, 'houses');
insert into sub_category(id, name)
values (33, 'rooms');
insert into sub_category(id, name)
values (34, 'hotels');
insert into sub_category(id, name)
values (35, 'apartments');
-- construction
insert into sub_category(id, name)
values (36, 'residential');
insert into sub_category(id, name)
values (37, 'industrial');
insert into sub_category(id, name)
values (38, 'commercial');
insert into sub_category(id, name)
values (39, 'infrastructure');
insert into sub_category(id, name)
values (40, 'civil');
insert into sub_category(id, name)
values (41, 'railways');
insert into sub_category(id, name)
values (42, 'roads');
insert into sub_category(id, name)
values (43, 'bridges');
-- service
insert into sub_category(id, name)
values (44, 'tutors');
insert into sub_category(id, name)
values (45, 'photography');
insert into sub_category(id, name)
values (46, 'catering');
insert into sub_category(id, name)
values (47, 'baby sitter');
insert into sub_category(id, name)
values (48, 'cleaning');
insert into sub_category(id, name)
values (49, 'snow plow');
insert into sub_category(id, name)
values (50, 'dog trainer');
insert into sub_category(id, name)
values (51, 'massage');
insert into sub_category(id, name)
values (52, 'pet sitter');


--
-- SETTING UP MANY TO MANY FOR CATEGORIES & SUB CATEGORIES
-- items
insert into category_sub_categories(categories_id, sub_categories_id)
values (1, 1);
insert into category_sub_categories(categories_id, sub_categories_id)
values (2, 1);
insert into category_sub_categories(categories_id, sub_categories_id)
values (3, 1);
insert into category_sub_categories(categories_id, sub_categories_id)
values (1, 2);
insert into category_sub_categories(categories_id, sub_categories_id)
values (2, 2);
insert into category_sub_categories(categories_id, sub_categories_id)
values (3, 2);
insert into category_sub_categories(categories_id, sub_categories_id)
values (1, 3);
insert into category_sub_categories(categories_id, sub_categories_id)
values (3, 3);
insert into category_sub_categories(categories_id, sub_categories_id)
values (1, 4);
insert into category_sub_categories(categories_id, sub_categories_id)
values (2, 4);
insert into category_sub_categories(categories_id, sub_categories_id)
values (3, 4);
insert into category_sub_categories(categories_id, sub_categories_id)
values (1, 5);
insert into category_sub_categories(categories_id, sub_categories_id)
values (3, 5);
insert into category_sub_categories(categories_id, sub_categories_id)
values (1, 6);
insert into category_sub_categories(categories_id, sub_categories_id)
values (5, 6);
insert into category_sub_categories(categories_id, sub_categories_id)
values (1, 7);
insert into category_sub_categories(categories_id, sub_categories_id)
values (5, 7);
insert into category_sub_categories(categories_id, sub_categories_id)
values (1, 8);
insert into category_sub_categories(categories_id, sub_categories_id)
values (5, 8);
insert into category_sub_categories(categories_id, sub_categories_id)
values (1, 9);
insert into category_sub_categories(categories_id, sub_categories_id)
values (5, 9);
insert into category_sub_categories(categories_id, sub_categories_id)
values (1, 10);
insert into category_sub_categories(categories_id, sub_categories_id)
values (5, 10);
insert into category_sub_categories(categories_id, sub_categories_id)
values (1, 11);
insert into category_sub_categories(categories_id, sub_categories_id)
values (2, 11);
insert into category_sub_categories(categories_id, sub_categories_id)
values (3, 11);
insert into category_sub_categories(categories_id, sub_categories_id)
values (1, 12);
insert into category_sub_categories(categories_id, sub_categories_id)
values (2, 12);
insert into category_sub_categories(categories_id, sub_categories_id)
values (1, 13);
insert into category_sub_categories(categories_id, sub_categories_id)
values (2, 13);
insert into category_sub_categories(categories_id, sub_categories_id)
values (1, 14);
insert into category_sub_categories(categories_id, sub_categories_id)
values (2, 14);
insert into category_sub_categories(categories_id, sub_categories_id)
values (3, 14);
insert into category_sub_categories(categories_id, sub_categories_id)
values (1, 15);
insert into category_sub_categories(categories_id, sub_categories_id)
values (2, 15);
insert into category_sub_categories(categories_id, sub_categories_id)
values (3, 15);
insert into category_sub_categories(categories_id, sub_categories_id)
values (1, 16);
insert into category_sub_categories(categories_id, sub_categories_id)
values (2, 16);
insert into category_sub_categories(categories_id, sub_categories_id)
values (1, 17);
insert into category_sub_categories(categories_id, sub_categories_id)
values (2, 17);
insert into category_sub_categories(categories_id, sub_categories_id)
values (1, 18);
insert into category_sub_categories(categories_id, sub_categories_id)
values (5, 18);
insert into category_sub_categories(categories_id, sub_categories_id)
values (1, 19);
insert into category_sub_categories(categories_id, sub_categories_id)
values (1, 20);
insert into category_sub_categories(categories_id, sub_categories_id)
values (1, 21);
insert into category_sub_categories(categories_id, sub_categories_id)
values (1, 22);
-- maintenance
insert into category_sub_categories(categories_id, sub_categories_id)
values (2, 23);
insert into category_sub_categories(categories_id, sub_categories_id)
values (2, 24);
insert into category_sub_categories(categories_id, sub_categories_id)
values (2, 25);
insert into category_sub_categories(categories_id, sub_categories_id)
values (2, 26);
insert into category_sub_categories(categories_id, sub_categories_id)
values (2, 27);
insert into category_sub_categories(categories_id, sub_categories_id)
values (2, 28);
insert into category_sub_categories(categories_id, sub_categories_id)
values (2, 29);
insert into category_sub_categories(categories_id, sub_categories_id)
values (2, 30);
insert into category_sub_categories(categories_id, sub_categories_id)
values (2, 31);
-- rental
insert into category_sub_categories(categories_id, sub_categories_id)
values (3, 32);
insert into category_sub_categories(categories_id, sub_categories_id)
values (3, 33);
insert into category_sub_categories(categories_id, sub_categories_id)
values (3, 34);
insert into category_sub_categories(categories_id, sub_categories_id)
values (3, 35);
-- construction
insert into category_sub_categories(categories_id, sub_categories_id)
values (4, 36);
insert into category_sub_categories(categories_id, sub_categories_id)
values (4, 37);
insert into category_sub_categories(categories_id, sub_categories_id)
values (4, 38);
insert into category_sub_categories(categories_id, sub_categories_id)
values (4, 39);
insert into category_sub_categories(categories_id, sub_categories_id)
values (4, 40);
insert into category_sub_categories(categories_id, sub_categories_id)
values (4, 41);
insert into category_sub_categories(categories_id, sub_categories_id)
values (4, 42);
insert into category_sub_categories(categories_id, sub_categories_id)
values (4, 43);
-- service
insert into category_sub_categories(categories_id, sub_categories_id)
values (5, 44);
insert into category_sub_categories(categories_id, sub_categories_id)
values (5, 45);
insert into category_sub_categories(categories_id, sub_categories_id)
values (5, 46);
insert into category_sub_categories(categories_id, sub_categories_id)
values (5, 47);
insert into category_sub_categories(categories_id, sub_categories_id)
values (5, 48);
insert into category_sub_categories(categories_id, sub_categories_id)
values (5, 49);
insert into category_sub_categories(categories_id, sub_categories_id)
values (5, 50);
insert into category_sub_categories(categories_id, sub_categories_id)
values (5, 51);
insert into category_sub_categories(categories_id, sub_categories_id)
values (5, 52);


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
