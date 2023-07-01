-- CREATE DATABASE TicketPlusDB;

-- public.actions definition

-- Drop table

-- DROP TABLE public.actions;

CREATE TABLE public.actions (
	id_action uuid NOT NULL DEFAULT gen_random_uuid(),
	action_name varchar NOT NULL,
	CONSTRAINT actions_pk_id PRIMARY KEY (id_action),
	CONSTRAINT actions_un_action UNIQUE (action_name)
);


-- public.event_categories definition

-- Drop table

-- DROP TABLE public.event_categories;

CREATE TABLE public.event_categories (
	id_event_category uuid NOT NULL DEFAULT gen_random_uuid(),
	event_category varchar NOT NULL,
	CONSTRAINT event_categories_pk_id PRIMARY KEY (id_event_category)
);


-- public.involved definition

-- Drop table

-- DROP TABLE public.involved;

CREATE TABLE public.involved (
	id_involved uuid NOT NULL DEFAULT gen_random_uuid(),
	involved varchar NOT NULL,
	CONSTRAINT involved_pk_id PRIMARY KEY (id_involved)
);


-- public.places definition

-- Drop table

-- DROP TABLE public.places;

CREATE TABLE public.places (
	id_place uuid NOT NULL DEFAULT gen_random_uuid(),
	place varchar NOT NULL,
	address_location varchar NOT NULL,
	CONSTRAINT places_pk_id PRIMARY KEY (id_place)
);


-- public.roles definition

-- Drop table

-- DROP TABLE public.roles;

CREATE TABLE public.roles (
	id_role uuid NOT NULL DEFAULT gen_random_uuid(),
	rol varchar NOT NULL,
	CONSTRAINT roles_pk_id PRIMARY KEY (id_role),
	CONSTRAINT roles_un_role UNIQUE (rol)
);


-- public.sponsors definition

-- Drop table

-- DROP TABLE public.sponsors;

CREATE TABLE public.sponsors (
	id_sponsor uuid NOT NULL DEFAULT gen_random_uuid(),
	sponsor varchar NOT NULL,
	CONSTRAINT sponsor_pk_id PRIMARY KEY (id_sponsor)
);


-- public.users definition

-- Drop table

-- DROP TABLE public.users;

CREATE TABLE public.users (
	id_user uuid NOT NULL DEFAULT gen_random_uuid(),
	"name" varchar NULL,
	email varchar NOT NULL,
	pass varchar NULL,
	verified bool NOT NULL DEFAULT false,
	active bool NOT NULL DEFAULT true,
	CONSTRAINT users_pk_id PRIMARY KEY (id_user),
	CONSTRAINT users_un_email UNIQUE (email)
);


-- public.events definition

-- Drop table

-- DROP TABLE public.events;

CREATE TABLE public.events (
	id_event uuid NOT NULL DEFAULT gen_random_uuid(),
	id_event_category uuid NOT NULL,
	id_place uuid NOT NULL,
	title varchar NOT NULL,
	start_date timestamp NOT NULL,
	end_date timestamp NOT NULL,
	qr_scan_start_time timestamp NOT NULL,
	description varchar NOT NULL,
	card_picture varchar NOT NULL,
	banner_picture varchar NOT NULL,
	active bool NOT NULL DEFAULT false,
	archived bool NOT NULL DEFAULT false,
	CONSTRAINT events_pk_id PRIMARY KEY (id_event),
	CONSTRAINT events_fk_category FOREIGN KEY (id_event_category) REFERENCES public.event_categories(id_event_category) ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT events_fk_place FOREIGN KEY (id_place) REFERENCES public.places(id_place) ON DELETE RESTRICT ON UPDATE CASCADE
);


-- public.events_involved definition

-- Drop table

-- DROP TABLE public.events_involved;

CREATE TABLE public.events_involved (
	id_event_involved uuid NOT NULL DEFAULT gen_random_uuid(),
	id_event uuid NOT NULL,
	id_involved uuid NOT NULL,
	CONSTRAINT events_involved_pk_id PRIMARY KEY (id_event_involved),
	CONSTRAINT events_involved_fk_event FOREIGN KEY (id_event) REFERENCES public.events(id_event) ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT events_involved_fk_involved FOREIGN KEY (id_involved) REFERENCES public.involved(id_involved) ON DELETE RESTRICT ON UPDATE CASCADE
);


-- public.events_sponsor definition

-- Drop table

-- DROP TABLE public.events_sponsor;

CREATE TABLE public.events_sponsor (
	id_event_sponsor uuid NOT NULL DEFAULT gen_random_uuid(),
	id_event uuid NOT NULL,
	id_sponsor uuid NOT NULL,
	CONSTRAINT events_sponsor_pk_id PRIMARY KEY (id_event_sponsor),
	CONSTRAINT events_sponsor_fk_event FOREIGN KEY (id_event) REFERENCES public.events(id_event) ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT events_sponsor_fk_sponsor FOREIGN KEY (id_sponsor) REFERENCES public.sponsors(id_sponsor) ON DELETE RESTRICT ON UPDATE CASCADE
);


-- public.orders definition

-- Drop table

-- DROP TABLE public.orders;

CREATE TABLE public.orders (
	id_order uuid NOT NULL DEFAULT gen_random_uuid(),
	id_action uuid NOT NULL DEFAULT gen_random_uuid(),
	action_date timestamp NOT NULL,
	CONSTRAINT orders_pk_id PRIMARY KEY (id_order),
	CONSTRAINT orders_fk_action FOREIGN KEY (id_action) REFERENCES public.actions(id_action) ON DELETE RESTRICT ON UPDATE CASCADE
);


-- public.tiers definition

-- Drop table

-- DROP TABLE public.tiers;

CREATE TABLE public.tiers (
	id_tier uuid NOT NULL DEFAULT gen_random_uuid(),
	id_event uuid NOT NULL,
	price numeric NOT NULL,
	tier varchar NOT NULL,
	capacity int4 NOT NULL,
	CONSTRAINT tiers_pk_id PRIMARY KEY (id_tier),
	CONSTRAINT tiers_fk_event FOREIGN KEY (id_event) REFERENCES public.events(id_event) ON DELETE RESTRICT ON UPDATE CASCADE
);


-- public.tokens definition

-- Drop table

-- DROP TABLE public.tokens;

CREATE TABLE public.tokens (
	id_token uuid NOT NULL DEFAULT gen_random_uuid(),
	"content" varchar NOT NULL,
	active bool NOT NULL DEFAULT true,
	"timestamp" timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
	id_user uuid NOT NULL,
	CONSTRAINT tokens_pk_id PRIMARY KEY (id_token),
	CONSTRAINT tokens_fk_user FOREIGN KEY (id_user) REFERENCES public.users(id_user) ON DELETE CASCADE ON UPDATE CASCADE
);


-- public.users_roles definition

-- Drop table

-- DROP TABLE public.users_roles;

CREATE TABLE public.users_roles (
	id_user_role uuid NOT NULL DEFAULT gen_random_uuid(),
	id_user uuid NOT NULL,
	id_role uuid NOT NULL,
	CONSTRAINT users_roles_pk_id PRIMARY KEY (id_user_role),
	CONSTRAINT users_roles_fk_role FOREIGN KEY (id_role) REFERENCES public.roles(id_role) ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT users_roles_fk_user FOREIGN KEY (id_user) REFERENCES public.users(id_user) ON DELETE RESTRICT ON UPDATE CASCADE
);


-- public.tickets definition

-- Drop table

-- DROP TABLE public.tickets;

CREATE TABLE public.tickets (
	id_ticket uuid NOT NULL DEFAULT gen_random_uuid(),
	id_user uuid NOT NULL,
	id_tier uuid NOT NULL,
	purchased_date timestamp NOT NULL,
	redeemed_date timestamp NOT NULL,
	redeemed bool NOT NULL,
	CONSTRAINT tickets_pk_id PRIMARY KEY (id_ticket),
	CONSTRAINT tickets_fk_tier FOREIGN KEY (id_tier) REFERENCES public.tiers(id_tier) ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT tickets_fk_user FOREIGN KEY (id_user) REFERENCES public.users(id_user) ON DELETE RESTRICT ON UPDATE CASCADE
);


-- public.transfer_qrs definition

-- Drop table

-- DROP TABLE public.transfer_qrs;

CREATE TABLE public.transfer_qrs (
	id_transfer_code uuid NOT NULL DEFAULT gen_random_uuid(),
	id_ticket uuid NOT NULL,
	qr_code varchar NOT NULL,
	creation_date timestamp NOT NULL,
	expiration_date timestamp NOT NULL,
	CONSTRAINT transfer_qrs_pk_id PRIMARY KEY (id_transfer_code),
	CONSTRAINT transfer_qrs_fk_ticket FOREIGN KEY (id_ticket) REFERENCES public.tickets(id_ticket) ON DELETE RESTRICT ON UPDATE CASCADE
);


-- public.verification_qrs definition

-- Drop table

-- DROP TABLE public.verification_qrs;

CREATE TABLE public.verification_qrs (
	id_verification_code uuid NOT NULL DEFAULT gen_random_uuid(),
	id_ticket uuid NOT NULL,
	qr_code varchar NOT NULL,
	creation_date timestamp NOT NULL,
	expiration_date timestamp NOT NULL,
	CONSTRAINT verification_qrs_pk_id PRIMARY KEY (id_verification_code),
	CONSTRAINT verification_qrs_fk_ticket FOREIGN KEY (id_ticket) REFERENCES public.tickets(id_ticket) ON DELETE RESTRICT ON UPDATE CASCADE
);


-- public.orders_ticket definition

-- Drop table

-- DROP TABLE public.orders_ticket;

CREATE TABLE public.orders_ticket (
	id_order_ticket uuid NOT NULL DEFAULT gen_random_uuid(),
	id_order uuid NOT NULL,
	id_ticket uuid NOT NULL,
	CONSTRAINT orders_ticket_pk_id PRIMARY KEY (id_order_ticket),
	CONSTRAINT orders_ticket_fk_order FOREIGN KEY (id_order) REFERENCES public.orders(id_order) ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT orders_ticket_fk_ticket FOREIGN KEY (id_ticket) REFERENCES public.tickets(id_ticket) ON DELETE RESTRICT ON UPDATE CASCADE
);
