-- USER
INSERT INTO public.users (name, email, pass) VALUES ('Ernesto Canales', '00051120@uca.edu.sv', '$2a$05$IsNwUKl1SJ8T2WdCp0BBi.FWoYaz16naQa3WSoGY7qSi56LFd1MJG');
INSERT INTO public.users (name, email, pass) VALUES ('Christian López', '00179320@uca.edu.sv', '$2a$05$IsNwUKl1SJ8T2WdCp0BBi.FWoYaz16naQa3WSoGY7qSi56LFd1MJG');
INSERT INTO public.users (name, email, pass) VALUES ('Diego Gasteazoro', '00315919@uca.edu.sv', '$2a$05$IsNwUKl1SJ8T2WdCp0BBi.FWoYaz16naQa3WSoGY7qSi56LFd1MJG');
INSERT INTO public.users (name, email, pass) VALUES ('Oscar Cornejo', '00223019@uca.edu.sv', '$2a$05$IsNwUKl1SJ8T2WdCp0BBi.FWoYaz16naQa3WSoGY7qSi56LFd1MJG');
INSERT INTO public.users (name, email, pass) VALUES ('Dogulas Hernández', 'dohernandez@uca.edu.sv', '$2a$05$IsNwUKl1SJ8T2WdCp0BBi.FWoYaz16naQa3WSoGY7qSi56LFd1MJG');

-- ROLE
INSERT INTO public.roles (rol) VALUES ('Customer');
INSERT INTO public.roles (rol) VALUES ('Employee');
INSERT INTO public.roles (rol) VALUES ('Moderator');
INSERT INTO public.roles (rol) VALUES ('Business analyst');
INSERT INTO public.roles (rol) VALUES ('Event manager');
INSERT INTO public.roles (rol) VALUES ('Administrator role');

-- EVENT_CATEGORY
INSERT INTO public.event_categories (event_category) VALUES ('Toques musicales');
INSERT INTO public.event_categories (event_category) VALUES ('Exposiciones de arte');
INSERT INTO public.event_categories (event_category) VALUES ('Teatro');
INSERT INTO public.event_categories (event_category) VALUES ('Danza');
INSERT INTO public.event_categories (event_category) VALUES ('Literatura');
INSERT INTO public.event_categories (event_category) VALUES ('Debate');
INSERT INTO public.event_categories (event_category) VALUES ('Cine forums');
INSERT INTO public.event_categories (event_category) VALUES ('Stand up comedy');
INSERT INTO public.event_categories (event_category) VALUES ('Otro');

-- ACTION
INSERT INTO public.actions (action_name) VALUES ('Buy ticket');
INSERT INTO public.actions (action_name) VALUES ('Redeem ticket');
INSERT INTO public.actions (action_name) VALUES ('Transfer ticket');

-- PLACE
INSERT INTO public.places (place, address_location) VALUES ('Centro Internacional de Ferias y Convenciones', 'CIFCO, San Salvador');
INSERT INTO public.places (place, address_location) VALUES ('Centro de Convenciones de El Salvador', 'Calle Chiltiupán, Antiguo Cuscatlán');
INSERT INTO public.places (place, address_location) VALUES ('Hotel Sheraton Presidente', 'Avenida La Revolución, San Salvador');
INSERT INTO public.places (place, address_location) VALUES ('Museo de Arte de El Salvador', 'Final Avenida La Revolución, San Salvador');
INSERT INTO public.places (place, address_location) VALUES ('Teatro Nacional de El Salvador', 'Calle del Teatro, San Salvador');
INSERT INTO public.places (place, address_location) VALUES ('Centro Cultural de España en El Salvador', 'Calle La Reforma, San Salvador');
INSERT INTO public.places (place, address_location) VALUES ('Parque Bicentenario', 'Km 5 1/2 Carretera a Comalapa, San Salvador');
INSERT INTO public.places (place, address_location) VALUES ('Centro Histórico de Suchitoto', 'Suchitoto, Cuscatlán');
INSERT INTO public.places (place, address_location) VALUES ('Playa El Tunco', 'La Libertad');
INSERT INTO public.places (place, address_location) VALUES ('Jardín Botánico La Laguna', 'Boulevard Orden de Malta, Santa Tecla');
INSERT INTO public.places (place, address_location) VALUES ('Parque Nacional El Imposible', 'Ahuachapán');
INSERT INTO public.places (place, address_location) VALUES ('Lago de Coatepeque', 'Santa Ana');
INSERT INTO public.places (place, address_location) VALUES ('Cerro Verde', 'Santa Ana');
INSERT INTO public.places (place, address_location) VALUES ('Ruta de las Flores', 'Sonsonate');
INSERT INTO public.places (place, address_location) VALUES ('Catedral de Santa Ana', 'Santa Ana');
INSERT INTO public.places (place, address_location) VALUES ('Volcán de Santa Ana', 'Santa Ana');
INSERT INTO public.places (place, address_location) VALUES ('Playa El Cuco', 'San Miguel');
INSERT INTO public.places (place, address_location) VALUES ('Cerro El Pital', 'Chalatenango');
INSERT INTO public.places (place, address_location) VALUES ('Parque Nacional Montecristo', 'Chalatenango');
INSERT INTO public.places (place, address_location) VALUES ('Ruta de Las Joyas Artesanales', 'La Libertad');
INSERT INTO public.places (place, address_location) VALUES ('Galería Nacional de Arte', 'San Salvador');
INSERT INTO public.places (place, address_location) VALUES ('Museo Nacional de Antropología Dr. David J. Guzmán', 'San Salvador');
INSERT INTO public.places (place, address_location) VALUES ('Planetario de San Salvador', 'San Salvador');
INSERT INTO public.places (place, address_location) VALUES ('Museo de la Palabra y la Imagen', 'San Salvador');
INSERT INTO public.places (place, address_location) VALUES ('Museo Tin Marín', 'San Salvador');

-- SPONSOR
INSERT INTO public.sponsors (sponsor) VALUES ('Coca-Cola');
INSERT INTO public.sponsors (sponsor) VALUES ('Samsung');
INSERT INTO public.sponsors (sponsor) VALUES ('Toyota');
INSERT INTO public.sponsors (sponsor) VALUES ('Nike');
INSERT INTO public.sponsors (sponsor) VALUES ('Pepsi');
INSERT INTO public.sponsors (sponsor) VALUES ('Apple');
INSERT INTO public.sponsors (sponsor) VALUES ('Adidas');
INSERT INTO public.sponsors (sponsor) VALUES ('McDonalds');
INSERT INTO public.sponsors (sponsor) VALUES ('Microsoft');
INSERT INTO public.sponsors (sponsor) VALUES ('Sony');
INSERT INTO public.sponsors (sponsor) VALUES ('TACA Airlines');
INSERT INTO public.sponsors (sponsor) VALUES ('Águila');
INSERT INTO public.sponsors (sponsor) VALUES ('La Constancia');
INSERT INTO public.sponsors (sponsor) VALUES ('Super Selectos');
INSERT INTO public.sponsors (sponsor) VALUES ('Pollo Campero');
INSERT INTO public.sponsors (sponsor) VALUES ('PANESAL');
INSERT INTO public.sponsors (sponsor) VALUES ('La Curacao');
INSERT INTO public.sponsors (sponsor) VALUES ('G&T Continental');
INSERT INTO public.sponsors (sponsor) VALUES ('La Prensa Gráfica');
INSERT INTO public.sponsors (sponsor) VALUES ('Claro');
INSERT INTO public.sponsors (sponsor) VALUES ('Café el Salvador');
INSERT INTO public.sponsors (sponsor) VALUES ('Industrias La Constancia');
INSERT INTO public.sponsors (sponsor) VALUES ('Distribuidora La Popular');
INSERT INTO public.sponsors (sponsor) VALUES ('Grupo Agrisal');
INSERT INTO public.sponsors (sponsor) VALUES ('Galletas Pozuelo');
INSERT INTO public.sponsors (sponsor) VALUES ('Dulces Rico');
INSERT INTO public.sponsors (sponsor) VALUES ('Banco Cuscatlán');
INSERT INTO public.sponsors (sponsor) VALUES ('Almacenes Simán');
INSERT INTO public.sponsors (sponsor) VALUES ('Cerveza Regia');
INSERT INTO public.sponsors (sponsor) VALUES ('Grupo Q');

-- INVOLVED
INSERT INTO public.involved (involved) VALUES ('Juan Pérez');
INSERT INTO public.involved (involved) VALUES ('María García');
INSERT INTO public.involved (involved) VALUES ('Pedro López');
INSERT INTO public.involved (involved) VALUES ('Ana Martínez');
INSERT INTO public.involved (involved) VALUES ('Inversiones S.A.');
INSERT INTO public.involved (involved) VALUES ('Luisa Hernández');
INSERT INTO public.involved (involved) VALUES ('Grupo Empresarial');
INSERT INTO public.involved (involved) VALUES ('Roberto Rodríguez');
INSERT INTO public.involved (involved) VALUES ('Carmen Morales');
INSERT INTO public.involved (involved) VALUES ('Distribuidora El Salvador');
INSERT INTO public.involved (involved) VALUES ('José Gómez');
INSERT INTO public.involved (involved) VALUES ('Empresa de Eventos');
INSERT INTO public.involved (involved) VALUES ('Carlos Castro');
INSERT INTO public.involved (involved) VALUES ('Patricia Molina');
INSERT INTO public.involved (involved) VALUES ('Organización Cultural');
INSERT INTO public.involved (involved) VALUES ('Ricardo Aguilar');
INSERT INTO public.involved (involved) VALUES ('Laura Díaz');
INSERT INTO public.involved (involved) VALUES ('Fundación Educativa');
INSERT INTO public.involved (involved) VALUES ('Fernando Menéndez');
INSERT INTO public.involved (involved) VALUES ('María Elena Herrera');
INSERT INTO public.involved (involved) VALUES ('Sandra Navarro');
INSERT INTO public.involved (involved) VALUES ('Javier Morales');
INSERT INTO public.involved (involved) VALUES ('Inversiones López');
INSERT INTO public.involved (involved) VALUES ('María Fernández');
INSERT INTO public.involved (involved) VALUES ('Grupo Empresarial Romero');
INSERT INTO public.involved (involved) VALUES ('Carlos Martínez');
INSERT INTO public.involved (involved) VALUES ('Distribuidora Central');
INSERT INTO public.involved (involved) VALUES ('Luis Gómez');
INSERT INTO public.involved (involved) VALUES ('Ana Castro');
INSERT INTO public.involved (involved) VALUES ('Empresa de Entretenimiento');
INSERT INTO public.involved (involved) VALUES ('Roberto Salazar');
INSERT INTO public.involved (involved) VALUES ('Patricia Méndez');
INSERT INTO public.involved (involved) VALUES ('Organización Deportiva');
INSERT INTO public.involved (involved) VALUES ('Ricardo Hernández');
INSERT INTO public.involved (involved) VALUES ('Laura Morales');
INSERT INTO public.involved (involved) VALUES ('Fundación Cultural');
INSERT INTO public.involved (involved) VALUES ('Fernanda Sánchez');
INSERT INTO public.involved (involved) VALUES ('Miguel Ángel Díaz');
INSERT INTO public.involved (involved) VALUES ('Fábrica de Ideas');
INSERT INTO public.involved (involved) VALUES ('Marcela Campos');