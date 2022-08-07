--Roles
INSERT INTO charge_role (id, role_name, description)
VALUES ('81ec177a-8ca5-4f6b-8111-4d23f3ee38f0', 'ADMIN_USER', 'Admin User - Has permission to perform admin tasks');
INSERT INTO charge_role (id, role_name, description)
VALUES ('52f47d9f-3946-4e30-aabd-d5cb607e28c3', 'STANDARD_USER', 'Standard User - Has no admin rights');

--Users
--password superuser
INSERT INTO charge_user (id, first_name, last_name, password, username)
VALUES ('789eae4c-1bcf-48c5-beb0-fb5a80c36927', 'Admin', 'Admin', '$2a$10$xLqlSqjcSXRPGi19NkJL1uTyPqVZ5HbfAk47xZc1tFBXhP11QF1XO', 'superuser');
-- password test1234
INSERT INTO charge_user (id, first_name, last_name, password, username)
VALUES ('9f3a280c-3903-4fe6-b503-c41de9a3e9c9', 'John', 'Doe', '$2a$10$5AWyzymSnNypg9BkMOyKE.zA05GtRKHCoWimh.q2w.KAO5koBYPM6', 'john.doe');

--User Roles
INSERT INTO users_roles(user_id, role_id) VALUES ('789eae4c-1bcf-48c5-beb0-fb5a80c36927', '81ec177a-8ca5-4f6b-8111-4d23f3ee38f0');
INSERT INTO users_roles(user_id, role_id) VALUES ('789eae4c-1bcf-48c5-beb0-fb5a80c36927', '52f47d9f-3946-4e30-aabd-d5cb607e28c3');
INSERT INTO users_roles(user_id, role_id) VALUES ('9f3a280c-3903-4fe6-b503-c41de9a3e9c9', '52f47d9f-3946-4e30-aabd-d5cb607e28c3');

--New charges
INSERT INTO public.charge(id,  description, amount, "tag", user_id, last_modified_at) VALUES('9a65975c-8490-4856-b757-db0564a5215d', 'Room', 120.90, 'King size bed', '789eae4c-1bcf-48c5-beb0-fb5a80c36927', '2020-10-10');
INSERT INTO public.charge(id,  description, amount, "tag", user_id, last_modified_at) VALUES('316e4e83-6cb9-42fb-8ab7-3d6e784a0712', 'Bathroom', 30.55, 'grilled soap', '789eae4c-1bcf-48c5-beb0-fb5a80c36927', '2020-10-10');
INSERT INTO public.charge(id,  description, amount, "tag", user_id, last_modified_at) VALUES('ba1fad1c-ab94-4ba4-b34d-a28c632078b3', 'Kitchen', 20.55, 'Wall oven', '9f3a280c-3903-4fe6-b503-c41de9a3e9c9', '2020-10-10');
