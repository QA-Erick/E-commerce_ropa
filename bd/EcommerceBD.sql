SET GLOBAL time_zone = '+8:00';
DROP DATABASE IF EXISTS EcommerceBD;
CREATE DATABASE EcommerceBD;
USE EcommerceBD;

CREATE TABLE IF NOT EXISTS Usuario (
usu_id int NOT NULL AUTO_INCREMENT COMMENT 'Id usuario',
usu_tip varchar(100) NOT NULL COMMENT 'Tipo usuario',
usu_nom varchar(100) NOT NULL COMMENT 'Nombres usuario',
usu_dni varchar(11) NOT NULL COMMENT 'DNI usuario',
usu_ema varchar(100) NOT NULL COMMENT 'E-mail usuario',
usu_dir varchar(300) NOT NULL COMMENT 'Drireccion usuario',
usu_tel varchar(20) NOT NULL COMMENT 'Telefono usuario',
usu_con varchar(65) NOT NULL COMMENT 'Usuario contraseña',
PRIMARY KEY (`usu_id`)
);

CREATE TABLE IF NOT EXISTS Categoria (
cat_id int NOT NULL AUTO_INCREMENT COMMENT 'Id categoria',
cat_nom varchar(100) NOT NULL COMMENT 'Nombre categoria',
PRIMARY KEY (`cat_id`)
); 

CREATE TABLE IF NOT EXISTS Producto(
prd_id int NOT NULL AUTO_INCREMENT COMMENT 'Id producto',
prd_nom varchar(100) NOT NULL COMMENT 'Nombre producto',
prd_img varchar(200) NOT NULL COMMENT 'Imagen producto',
prd_pre decimal NOT NULL COMMENT 'Precio producto',
id_cat int NOT NULL COMMENT 'FK Tabla Categoria',
PRIMARY KEY (`prd_id`),
FOREIGN KEY (id_cat) REFERENCES Categoria(cat_id)
);
-- prd_ima NOT NULL COMMENT 'Imagen producto',
-- stock

CREATE TABLE IF NOT EXISTS Boleta(
bol_id int NOT NULL AUTO_INCREMENT COMMENT 'Id boleta',
bol_fec DATETIME NOT NULL COMMENT 'Fecha boleta',
id_usu int NOT NULL COMMENT 'FK Tabla Usuario',
PRIMARY KEY (`bol_id`),
FOREIGN KEY (id_usu) REFERENCES Usuario(usu_id)
);

CREATE TABLE IF NOT EXISTS Items_Boleta(
itb_id int NOT NULL AUTO_INCREMENT COMMENT 'Id boleta',
itb_can int NOT NULL COMMENT 'Cantidad seleccionada del producto',
id_bol  int NOT NULL COMMENT 'FK Tabla Boleta',
id_prd  int NOT NULL COMMENT 'FK Tabla Producto',
PRIMARY KEY (`itb_id`),
FOREIGN KEY (id_bol) REFERENCES Boleta(bol_id),
FOREIGN KEY (id_prd) REFERENCES Producto(prd_id)
);

insert Usuario values
(null,'ROLE_CLIENTE','Prueba1','12345678','prueba1@gmail.com','av. prueba1','987654321',
'$2a$12$haQ1FCbjrI/JUALJxC5f.uYAYPLVsuvvjwT818biRr8SMwuN2WQE.'),  -- contraseña: prueba1
(null,'ROLE_ADMIN','Prueba2','12345678','prueba2@gmail.com','av. prueba2','987654321',
'$2a$12$5DybUmMjmj1wLE43cUNQNO/PVk60LnXxPKpMkBBDN6pR5ahhoxe2C');  -- contraseña: prueba2


insert Categoria values
(null,'Mujeres'),
(null,'Hombres');
-- https://cdn.shopify.com/s/files/1/0218/9988/products/
insert Producto values
(null,'W Storm All-Weather Jacket','w_storm_allweather_jacket_te_01.jpg?v=1679010996&width=420&height=546&crop=center',160.0,1),
(null,'Zephyr Jacket','w_zephyer_jacket_wb_02.jpg?v=1661884924&width=420&height=546&crop=center',230.0,1),
(null,'Halley Jacket','w_halley_jacket_w_01.jpg?v=1661884940&width=420&height=546&crop=center',250.00,1),
(null,'W Foundation Pullover','w_foundation_pullover_ch_01.jpg?v=1660755281&width=420&height=546&crop=center',180.0,1),
(null,'Solstice Lightweight Jogger','w_solstice_lightweight_jogger_lg_02.jpg?v=1680635472&width=420&height=546&crop=center',145.0,1),
(null,'Felix Pant','w_felix_pant_ob_02.jpg?v=1661887576&width=420&height=546&crop=center',155.0,1),
(null,'W Dolomite Boot','w_dolomite_boot_stn_02.jpg?v=1668020683&width=420&height=546&crop=center',320.0,1),
(null,'W Dalton Low-Top Sneaker','w_dalton_lotop_sneaker_blk_01.jpg?v=1661887794&width=420&height=546&crop=center',260.0,1),
(null,'Aero Sweater','m_aero_sweater_ag_01.jpg?v=1679348892&width=420&height=546&crop=center',185.0,2),
(null,'Mojave Motorcycle Jacket','m_mojave_moto_jacket_gr_01.jpg?v=1663517814&width=420&height=546&crop=center',340.0,2),
(null,'Pine Shacket','m_pine_shacket_bone_01.jpg?v=1679346496&width=420&height=546&crop=center',310.0,2),
(null,'Laurentic Crew Tee','m_laurentic_crew_bone_01.jpg?v=1661886863&width=420&height=546&crop=center',130.0,2),
(null,'Concourse Pant','m_concourse_pant_nn_01.jpg?v=1661887318&width=420&height=546&crop=center',260.0,2),
(null,'Strand Tech Pant','m_fairfax_pant_cg_02.jpg?v=1663011974&width=420&height=546&crop=center',240.0,2),
(null,'Dalton Sneaker','m_dalton_hi_sneaker_nn_01.jpg?v=1661888046&width=420&height=546&crop=center',350.0,2),
(null,'Dalton Low-Top Sneaker','m_dalton_low_white_01.jpg?v=1661888024&width=420&height=546&crop=center',300.0,2);

select * from Categoria;
select * from Producto;
select * from Usuario;