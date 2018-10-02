-- begin EVENTPROBLEM_DOCUMENT
create table EVENTPROBLEM_DOCUMENT (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    SOME_TEXT varchar(255),
    --
    primary key (ID)
)^
-- end EVENTPROBLEM_DOCUMENT
