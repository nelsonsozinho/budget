--Roles
INSERT INTO wallet_role (id, role_name, description)
VALUES ('81ec177a-8ca5-4f6b-8111-4d23f3ee38f0', 'ADMIN_USER', 'Admin User - Has permission to perform admin tasks');
INSERT INTO wallet_role (id, role_name, description)
VALUES ('52f47d9f-3946-4e30-aabd-d5cb607e28c3', 'STANDARD_USER', 'Standard User - Has no admin rights');

--Users
--password superuser
INSERT INTO wallet_user (id, first_name, last_name, password, username)
VALUES ('789eae4c-1bcf-48c5-beb0-fb5a80c36927', 'Admin', 'Admin', '$2a$10$xLqlSqjcSXRPGi19NkJL1uTyPqVZ5HbfAk47xZc1tFBXhP11QF1XO', 'superuser');
-- password test1234
INSERT INTO wallet_user (id, first_name, last_name, password, username)
VALUES ('9f3a280c-3903-4fe6-b503-c41de9a3e9c9', 'John', 'Doe', '$2a$10$5AWyzymSnNypg9BkMOyKE.zA05GtRKHCoWimh.q2w.KAO5koBYPM6', 'john.doe');

--User Roles
INSERT INTO users_roles(user_id, role_id) VALUES ('789eae4c-1bcf-48c5-beb0-fb5a80c36927', '81ec177a-8ca5-4f6b-8111-4d23f3ee38f0');
INSERT INTO users_roles(user_id, role_id) VALUES ('789eae4c-1bcf-48c5-beb0-fb5a80c36927', '52f47d9f-3946-4e30-aabd-d5cb607e28c3');
INSERT INTO users_roles(user_id, role_id) VALUES ('9f3a280c-3903-4fe6-b503-c41de9a3e9c9', '52f47d9f-3946-4e30-aabd-d5cb607e28c3');

--New Assets
INSERT INTO public.asset (id,  code, "name") VALUES('8d02841f-428c-4dac-912f-81d0c8a3aa44', 'UNIP6', 'Unipar Carbocloro');
INSERT INTO public.asset (id,  code, "name") VALUES('d0588d51-abe7-453c-9020-dc20bb6b0ac2', 'ASAI3', 'Assai');
INSERT INTO public.asset (id,  code, "name") VALUES('da79375e-d0b2-4979-b823-1cbdba9ed516', 'ITSA4', 'Itau SA');
INSERT INTO public.asset (id,  code, "name") VALUES('6edefac9-1e23-4bf4-92c8-33f5bbbd8b66', 'ITUB4', 'Itau');

--New wallets
INSERT INTO public.wallet(id,  description, "name", user_id) VALUES('9a65975c-8490-4856-b757-db0564a5215d', 'Personal wallet', 'Personal', '9f3a280c-3903-4fe6-b503-c41de9a3e9c9');
INSERT INTO public.wallet(id,  description, "name", user_id) VALUES('316e4e83-6cb9-42fb-8ab7-3d6e784a0712', 'Children wallet', 'Children', '9f3a280c-3903-4fe6-b503-c41de9a3e9c9');

--Wallet and Assset
insert into wallet_asset (wallet_id, asset_id) values('9a65975c-8490-4856-b757-db0564a5215d', '8d02841f-428c-4dac-912f-81d0c8a3aa44');
insert into wallet_asset (wallet_id, asset_id) values('9a65975c-8490-4856-b757-db0564a5215d', '6edefac9-1e23-4bf4-92c8-33f5bbbd8b66');