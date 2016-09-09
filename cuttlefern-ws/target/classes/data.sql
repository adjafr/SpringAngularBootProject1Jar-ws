insert into cuttlefern.state (name) values ('Georgia');
insert into cuttlefern.state (name) values ('Tennessee');
insert into cuttlefern.state (name) values ('New York');
insert into cuttlefern.state (name) values ('California');

insert into cuttlefern.city (name, state_id) values ('Atlanta', 1);
insert into cuttlefern.city (name, state_id) values ('Bronx', 3);
insert into cuttlefern.city (name, state_id) values ('Marin City', 4);
insert into cuttlefern.city (name, state_id) values ('Memphis', 2);

insert into cuttlefern.interest (name) values ('Gun Clubs');
insert into cuttlefern.interest (name) values ('Open Carry');
insert into cuttlefern.interest (name) values ('Criminal Activities');
insert into cuttlefern.interest (name) values ('Hacking');

insert into cuttlefern.group (name, city_id, interest_id) values ('I Love Guns', 2, 1);
insert into cuttlefern.group (name, city_id, interest_id) values ('Photography Club', 1, 2);
insert into cuttlefern.group (name, city_id, interest_id) values ('Underground Club', 4, 3);
insert into cuttlefern.group (name, city_id, interest_id) values ('Convicts Club', 3, 4);

insert into cuttlefern.person (name, city_id) values ('AJ Fraser', 1);
insert into cuttlefern.person (name, city_id) values ('Jon', 2);
insert into cuttlefern.person (name, city_id) values ('Andre Fraser', 3);
insert into cuttlefern.person (name, city_id) values ('George Wallace', 4);
insert into cuttlefern.person (name, city_id) values ('Dooshima Akuva-Fraser', 1);

--INSERT INTO cuttlefern.person_groups(members_id, groups_id) VALUES (?, ?);
insert into cuttlefern.group_members (groups_id, members_id) values (1, 2);
insert into cuttlefern.group_members (groups_id, members_id) values (2, 5);
insert into cuttlefern.group_members (groups_id, members_id) values (2, 1);
insert into cuttlefern.group_members (groups_id, members_id) values (3, 3);
insert into cuttlefern.group_members (groups_id, members_id) values (4, 4);
--
--INSERT INTO cuttlefern.person_interests(members_id, interests_id) VALUES (?, ?);
insert into cuttlefern.person_interests (people_id, interests_id) values (1, 2);
insert into cuttlefern.person_interests (people_id, interests_id) values (2, 1);
insert into cuttlefern.person_interests (people_id, interests_id) values (3, 3);
insert into cuttlefern.person_interests (people_id, interests_id) values (4, 4);
insert into cuttlefern.person_interests (people_id, interests_id) values (5, 4);