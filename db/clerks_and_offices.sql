create table offices(
    id serial primary key,
    office_area_in_meters int
);

create table clerks(
    id serial primary key,
    name varchar(255),
    office_id int references offices(id)
);

insert into offices(office_area_in_meters) values (25);
insert into clerks(name, office_id) VALUES ('John Doe', 1);
insert into clerks(name, office_id) VALUES ('Jack Bridge', 1);
insert into clerks(name, office_id) VALUES ('Emmet Broun', 1);