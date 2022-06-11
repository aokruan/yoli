-- Table: public.games

-- DROP TABLE IF EXISTS public.games;

CREATE TABLE IF NOT EXISTS public.games
(
    "gameId" character varying(100) COLLATE pg_catalog."default" NOT NULL,
    name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    backdrop character varying(50) COLLATE pg_catalog."default",
    logo character varying(50) COLLATE pg_catalog."default",
    description character varying(500) COLLATE pg_catalog."default" NOT NULL,
    download_count integer,
    version character varying(15) COLLATE pg_catalog."default" NOT NULL,
    weight character varying(10) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT games_pkey PRIMARY KEY ("gameId")
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.games
    OWNER to postgres;