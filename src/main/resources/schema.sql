create table if not exists game_entity(
    id varchar(40) not null,
    state varchar(255) not null,
    turn varchar(255) not null,
    board varchar(255) not null,
    primary key(id)
);