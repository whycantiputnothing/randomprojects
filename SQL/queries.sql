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
