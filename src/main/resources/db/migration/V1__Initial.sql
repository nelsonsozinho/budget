CREATE TABLE public.users_roles (
    user_id character varying(255) NOT NULL,
    role_id character varying(255) NOT NULL
);

CREATE TABLE public.charge (
    id character varying(255) NOT NULL,
    last_modified_at timestamp without time zone,
    description character varying(255),
    tag character varying(255),
    amount double precision NOT NULL,
    user_id character varying(255)
);

CREATE TABLE public.charge_role (
    id character varying(255) NOT NULL,
    description character varying(255),
    role_name character varying(255)
);

CREATE TABLE public.charge_user (
    id character varying(255) NOT NULL,
    first_name character varying(255),
    last_name character varying(255),
    password character varying(255),
    username character varying(255)
);


ALTER TABLE ONLY public.charge_user
    ADD CONSTRAINT uk_egqusy937sbn54ed75mhknm71 UNIQUE (username);

ALTER TABLE ONLY public.users_roles
    ADD CONSTRAINT users_roles_pkey PRIMARY KEY (user_id, role_id);

ALTER TABLE ONLY public.charge
    ADD CONSTRAINT budget_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.charge_role
    ADD CONSTRAINT budget_role_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.charge_user
    ADD CONSTRAINT budget_user_pkey PRIMARY KEY (id);

ALTER TABLE ONLY public.users_roles
    ADD CONSTRAINT fk3b0gkanmye6xr4cgeu14xyvcy FOREIGN KEY (user_id) REFERENCES public.charge_user(id);

ALTER TABLE ONLY public.users_roles
    ADD CONSTRAINT fkk1lygo9axoq4nb9i2q0kbv1h1 FOREIGN KEY (role_id) REFERENCES public.charge_role(id);

ALTER TABLE ONLY public.charge
    ADD CONSTRAINT fkmkf27omhr0j9t77rpxemavecp FOREIGN KEY (user_id) REFERENCES public.charge_user(id);