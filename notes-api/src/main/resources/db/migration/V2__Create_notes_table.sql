create table TITLES (
    ID serial PRIMARY KEY,
    USER_ID integer,
    TEXT varchar(100)
);

create table HEADERS (
    ID serial PRIMARY KEY,
    TITLE_ID integer,
    TEXT varchar(100),
    CONSTRAINT TITLE_ID FOREIGN KEY(TITLE_ID)
        REFERENCES TITLES (ID)
);

create table PARAS (
    ID serial PRIMARY KEY,
    HEADER_ID integer,
    TEXT varchar(100),
    CONSTRAINT HEADER_ID FOREIGN KEY(HEADER_ID)
        REFERENCES HEADERS (ID)
);

create table CODEBLOCKS (
    ID serial PRIMARY KEY,
    HEADER_ID integer,
    TEXT varchar(100),
    CONSTRAINT HEADER_ID FOREIGN KEY(HEADER_ID)
        REFERENCES HEADERS (ID)
)