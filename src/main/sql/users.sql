-- Table: public.users

-- DROP TABLE IF EXISTS public.users;

CREATE TABLE IF NOT EXISTS public.users
(
    login character varying(25) COLLATE pg_catalog."default" NOT NULL,
    password character varying(25) COLLATE pg_catalog."default" NOT NULL,
    email character varying(25) COLLATE pg_catalog."default",
    username character varying(30) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT users_pkey PRIMARY KEY (login)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.users
    OWNER to postgres;