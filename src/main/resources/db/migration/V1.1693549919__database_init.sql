create table if not exists client
(
    id       bigserial primary key,
    name     varchar(255) not null
);

create table if not exists contacts
(
    id              bigserial primary key,
    email           varchar(255) not null,
    phone_number    varchar(255) not null,
    client_id       bigint references client (id)
);
