-- Table: public.tournaments

-- DROP TABLE IF EXISTS public.tournaments;

CREATE TABLE IF NOT EXISTS public.tournaments
(
    "tournamentId" character varying(50) COLLATE pg_catalog."default" NOT NULL,
    name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    status integer NOT NULL,
    format character varying(20) COLLATE pg_catalog."default" NOT NULL,
    prize character varying(25) COLLATE pg_catalog."default" NOT NULL,
    watchers integer NOT NULL,
    CONSTRAINT tournaments_pkey PRIMARY KEY ("tournamentId")
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tournaments
    OWNER to postgres;