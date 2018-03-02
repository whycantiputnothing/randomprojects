insert into collection values ('best collection', 'personal', 'the best collection known to man', '111 first street', '1233211234', 'Brandon');
insert into collection values ('worst collection', 'museum', 'the worst collection known to man', '112 first street', '1233211234', 'Felix');


insert into artist (aname, country_of_origin, epoch, main_style, description) values ('reuben', 'mexico', 'modern', 'impressionism', 'the artist reuben'); 
insert into artist (aname, date_born, country_of_origin, epoch, main_style, description) values ('fransisco', '2012-01-01', 'mexico', 'modern', 'cubism', 'the artist fransisco'); 


insert into art_object (artist, year, title, description, type, origin, epoch) values ('reuben', 2012, 'self portrait', 'my self portrait', 'painting', 'america', 'modern');
insert into painting values ('oil', 'canvas', 'modern', LAST_INSERT_ID());
insert into permanent_collection values ('2014-01-01', 'display', 2000, last_insert_id());
insert into exhitbition values ('brandon expo', '1997-05-16', '2018-03-02' , last_insert_id());

insert into art_object (artist, year, title, description, type, origin, epoch) values ('reuben', 2013, 'dog', 'painting of dog', 'painting', 'mexico', 'ancient');
insert into painting values ('watercolor', 'canvas', 'modern', LAST_INSERT_ID());
insert into permanent_collection values ('2014-01-01', 'stored', 2000, last_insert_id());

insert into art_object (artist, year, title, description, type, origin, epoch) values ('fransisco', 2007, 'cat', 'sculpture of cat', 'sculpture', 'spain', 'ancient');
insert into sculpture values ('marble', 100, 1000, 'ancient', last_insert_id());
insert into borrowed values ('best collection', '2008-01-01', '2009-01-01', last_insert_id());
insert into exhitbition values ('brandon expo', '1997-05-16', '2018-03-02' , last_insert_id());

insert into art_object (title, description, type, origin, epoch) values ('thinker', 'statue of thinker', 'statue', 'france', 'renaissance,');
insert into statue values ('rock', 200, 2000, 'renaissance', last_insert_id());
insert into permanent_collection values ('2018-01-01', 'display', 2005, last_insert_id());
insert into exhitbition values ('kristin expo', '2018-01-01', '2018-03-02' , last_insert_id());


insert into art_object (artist, year, title, description, type, origin, epoch) values ('reuben', 2012, 'self portrait', 'my self portrait', 'painting', 'america', 'mordern');
insert into art_object (artist, year, title, description, type, origin, epoch) values ('reuben', 2012, 'self portrait', 'my self portrait', 'painting', 'america', 'mordern');
insert into art_object (artist, year, title, description, type, origin, epoch) values ('reuben', 2012, 'self portrait', 'my self portrait', 'painting', 'america', 'mordern');
insert into art_object (artist, year, title, description, type, origin, epoch) values ('reuben', 2012, 'self portrait', 'my self portrait', 'painting', 'america', 'mordern');





