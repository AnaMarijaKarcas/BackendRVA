-- Fakultet podaci 

insert into fakultet (id, naziv, sediste)
values (nextval('fakultet_seq'), 'Fakultet tehnickih nauka', 'Novi Sad'),
(nextval('fakultet_seq'), 'Medicinski fakultet', 'Novi Sad'),
(nextval('fakultet_seq'), 'Masinski fakultet', 'Novi Sad'),
(nextval('fakultet_seq'), 'Prirodno-matematicki fakultet', 'Novi Sad'),
(nextval('fakultet_seq'), 'Ekonomski fakultet', 'Novi Sad');


insert into status (id, naziv, oznaka)
values (nextval('status_seq'), 'Redovan-budzet', 'RB1'),
(nextval('status_seq'), 'Redovan-samofinansiranje', 'RS1'),
(nextval('status_seq'), 'Vanredan-budzet', 'VB2'),
(nextval('status_seq'), 'Vanredan-samofinansiranje', 'VS2'),
(nextval('status_seq'), 'Zaposlen-budzet', 'ZB3');

insert into departman (id, naziv, oznaka, fakultet)
values (nextval('departman_seq'), 'Departman za mehartoniku', 'DM', 1),
(nextval('departman_seq'), 'Departman za industrijsko inzenjerstvo', 'DII', 1),
(nextval('departman_seq'), 'Departman za opstu medicinu', 'DOM', 2),
(nextval('departman_seq'), 'Departman za marketing', 'EDM', 5),
(nextval('departman_seq'), 'Departman za biologiju', 'DZB', 4),
(nextval('departman_seq'), 'Departman za turizam', 'DZT', 4),
(nextval('departman_seq'), 'Departman za robotiku', 'DZR', 3);

insert into student(id, ime, prezime, broj_indeksa, status, departman)
values( nextval('student_seq'), 'Milica', 'Popovic', 'IT18-2019', 1, 2),
( nextval('student_seq'), 'Milica', 'Petrovic', 'OM56-2019', 2, 3),
( nextval('student_seq'), 'Jovana', 'Stevic', 'TR18-2019', 3, 6),
( nextval('student_seq'), 'Lazar', 'Krajnovic', 'EDM28-2019', 4, 4),
( nextval('student_seq'), 'Dragan', 'Rankov', 'BE95-2016', 5, 5);


insert into fakultet (id, naziv, sediste)
values(-100, 'test', 'test');
insert into status(id, naziv, oznaka)
values(-100, 'test', 'test');
insert into departman (id, naziv, oznaka, fakultet)
values (-100, 'test', 'test', -100);
insert into student(id, ime, prezime, broj_indeksa, status, departman)
values (-100, 'test', 'test', -120, -100, -100);

