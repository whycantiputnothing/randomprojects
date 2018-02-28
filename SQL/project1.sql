Create database ART_MUSEUM;
use ART_MUSEUM;
CREATE TABLE collection (
    cname VARCHAR(30) NOT NULL,
    type VARCHAR(30) NOT NULL,
    description VARCHAR(300) NOT NULL,
    address VARCHAR(100) NOT NULL,
    phone VARCHAR(10) NOT NULL,
    contact_person VARCHAR(30) NOT NULL,
    UNIQUE (cname),
    PRIMARY KEY (cname)
);
CREATE TABLE borrowed (
    collection_name VARCHAR(30) NOT NULL,
    date_borrowed DATE NOT NULL,
    date_returned DATE NOT NULL,
    FOREIGN KEY (collection_name)
        REFERENCES collection (cname)
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
CREATE TABLE art_object (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    artist VARCHAR(30),
    year SMALLINT,
    title VARCHAR(30) NOT NULL,
    description VARCHAR(300) NOT NULL,
    type ENUM('PAINTING', 'SCULPTURE', 'STATUE', 'OTHER') NOT NULL,
    origin VARCHAR(30) NOT NULL,
    epoch VARCHAR(30) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (artist)
        REFERENCES artist (aname)
);
CREATE TABLE other (
    type VARCHAR(30) NOT NULL,
    style VARCHAR(30) NOT NULL,
    art_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (art_id)
        REFERENCES art_object (id)
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
CREATE TABLE exhitbition (
    ename VARCHAR(30) NOT NULL,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    art_id INT UNSIGNED NOT NULL,
    FOREIGN KEY (art_id)
        REFERENCES art_object (id)
);
