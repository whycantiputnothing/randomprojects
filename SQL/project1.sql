Create database ART_MUSEUM;
use ART_MUSEUM;
CREATE TABLE art_object (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    artist VARCHAR(30),
    year SMALLINT,
    title VARCHAR(30) NOT NULL,
    description VARCHAR(300) NOT NULL,
    type enum ('PAINTING', 'SCULPTURE','STATUE','OTHER') not null,
    origin VARCHAR(30) NOT NULL,
    epoch VARCHAR(30) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (artist)
        REFERENCES artist (name)
);
create table other(
	type varchar(30) not null,
    style varchar(30) not null,
    art_id int unsigned not null,
    foreign key(art_id) references art_object(id)
);
CREATE TABLE painting (
    paint_type VARCHAR(30) NOT NULL,
    drawn_on VARCHAR(30) NOT NULL,
    style VARCHAR(30) NOT NULL,
    art_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (art_id)
        REFERENCES art_object (id)
);
CREATE TABLE sculpture (
    material VARCHAR(30) NOT NULL,
    height INT NOT NULL,
    weight INT NOT NULL,
    style VARCHAR(30) NOT NULL,
    art_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (art_id)
        REFERENCES art_object (id)
);
CREATE TABLE statue (
    material VARCHAR(30) NOT NULL,
    height INT NOT NULL,
    weight INT NOT NULL,
    style VARCHAR(30) NOT NULL,
    art_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (art_id)
        REFERENCES art_object (id)
);
CREATE TABLE permanent_collection (
    date_acquired DATE NOT NULL,
    status ENUM('display', 'on loan', 'stored') NOT NULL,
    cost INT NOT NULL,
    art_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (art_id)
        REFERENCES art_object (id)
);
CREATE TABLE borrowed (
	collection_name varchar(30) not null,
    date_borrowed DATE NOT NULL,
    date_returned DATE NOT NULL,
    foreign key(collection_name) references collection (cname)
);
CREATE TABLE artist (
    aname VARCHAR(30) NOT NULL,
    date_born DATE,
    date_died DATE,
    country_of_origin VARCHAR(30) NOT NULL,
    epoch VARCHAR(30) NOT NULL,
    main_style VARCHAR(30) NOT NULL,
    description VARCHAR(300) NOT NULL,
    PRIMARY KEY (aname),
    UNIQUE (aname)
);
CREATE TABLE exhitbition (
    ename VARCHAR(30) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    art_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (art_id)
        REFERENCES art_object (id)
);
create table collection ( 
	cname varchar(30) not null,
    type varchar(30) not null,
    description varchar(300) not null,
    address varchar (100) not null,
    phone varchar(10) not null,
    contact_person varchar(30) not null,
    unique (cname),
    primary key (cname)
);
SHOW TABLES;