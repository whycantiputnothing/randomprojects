#1 Retrieve a name of all ART_OBJECTs' names of a particular type
SELECT 
    title
FROM
    art_object
WHERE
    type = 'painting';
#2 Retrieve a list of all ART_OBJECTs' names from a particular Epoch, and type.
SELECT 
    title
FROM
    art_object
WHERE
    type = 'painting' AND epoch = 'modern';
#3 Retrieve a list of all ART_OBJECTs' names from a particular artist.
SELECT 
    title
FROM
    art_object
WHERE
    artist = 'reuben';
#4 Display a list of all ART_OBJECTs that are part of the PERMANENT_COLLECTION, and show their name, description, type, epoch, and artist.
SELECT 
    title, description, type, epoch, artist
FROM
    (SELECT 
        *
    FROM
        art_object
    INNER JOIN permanent_collection ON art_object.id = permanent_collection.art_id) AS T;
#5 Display a list of all ART_OBJECTs that are BORROWED, and show their name, description, type, epoch, and artist.
SELECT 
    title, description, type, epoch, artist
FROM
    (SELECT 
        *
    FROM
        art_object
    INNER JOIN borrowed ON art_object.id = borrowed.art_id) AS T;
#6 Display a list of all ongoing exhibitions.
SELECT DISTINCT
    ename
FROM
    exhitbition
WHERE
    end_date >= '2018-03-02';
#7 Display a list of ART_OBJECTs that are on display on a particular exhibition.
SELECT 
    title, description, type, epoch, artist
FROM
    (SELECT 
        *
    FROM
        art_object
    INNER JOIN exhitbition ON art_object.id = exhitbition.art_id
    WHERE
        exhitbition.ename = 'brandon expo') AS T;
#8 Display a list of ART_OBJECTs that are on display at a particular date.
SELECT 
    title, description, type, epoch, artist
FROM
    (SELECT 
        *
    FROM
        art_object
    INNER JOIN exhitbition ON art_object.id = exhitbition.art_id
    WHERE
        exhitbition.start_date <= '2018-02-02'
            AND exhitbition.end_date >= '2018-02-02') AS T;
#9 retrieve a list of all paintings on display
SELECT 
    title, description, type, epoch, artist
FROM
    (SELECT 
        *
    FROM
        art_object
    INNER JOIN permanent_collection ON art_object.id = permanent_collection.art_id
    WHERE
        type = 'painting' AND status = 'display') AS T;
#10 retrieve a list of all paintings done on canvas
SELECT 
    title, description, type, epoch, artist
FROM
    (SELECT 
        *
    FROM
        art_object
    INNER JOIN painting ON art_object.id = painting.art_id
    WHERE
        drawn_on = 'canvas') AS T;
#11 retrieve a list of all art objects with a cost of over 2000
SELECT 
    title, description, type, epoch, artist
FROM
    (SELECT 
        *
    FROM
        art_object
    INNER JOIN permanent_collection ON art_object.id = permanent_collection.art_id
    WHERE
        cost > 2000) AS T;
#12 retrive a list of borrowed art objects that have not been returned
SELECT 
    title, description, type, epoch, artist
FROM
    (SELECT 
        *
    FROM
        art_object
    INNER JOIN borrowed ON art_object.id = borrowed.art_id
    WHERE
        borrowed.date_returned > '2018-03-02') AS T;
#13 retrive a list of artists who have not died yet
SELECT 
    aname
FROM
    artist
WHERE
    date_died IS NULL;
#14 retireve a list of art objects done in a particular year
SELECT 
    title, description, type, epoch, artist
FROM
    art_object
WHERE
    year = 2012;
#15 retrieve a list of borrowed objects after a particular date
SELECT 
    title, description, type, epoch, artist, date_borrowed
FROM
    (SELECT 
        *
    FROM
        art_object
    INNER JOIN borrowed ON art_object.id = borrowed.art_id
    WHERE
        borrowed.date_borrowed > '2000-01-01') AS T;
#16 retrive a list of exhibitions that have completed
SELECT DISTINCT
    ename, end_date
FROM
    exhitbition
WHERE
    end_date < '2018-03-02';
#17 retrive a list of contact persons and phone numbers for each collection
SELECT 
    cname, phone, contact_person
FROM
    collection;
#18 retrive a list of sculptures done in a particular style
SELECT 
    title, description, type, epoch, artist, style
FROM
    (select *
    from art_object
        INNER JOIN
    sculpture ON art_object.id = sculpture.art_id
    where sculpture.style = 'ancient') as T;