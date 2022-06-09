-- Table: public.tokens

-- DROP TABLE IF EXISTS public.tokens;

CREATE TABLE IF NOT EXISTS public.tokens
(
    id character varying(50) COLLATE pg_catalog."default" NOT NULL,
    login character varying(25) COLLATE pg_catalog."default" NOT NULL,
    token character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT tokens_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tokens
    OWNER to postgres;

