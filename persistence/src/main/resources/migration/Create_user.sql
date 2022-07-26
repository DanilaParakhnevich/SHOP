create table "user" (
                        id bigserial primary key,
                        username varchar(24),
                        password varchar(64),
                        creationTime timestamp,
                        lastUpdateTime timestamp
)