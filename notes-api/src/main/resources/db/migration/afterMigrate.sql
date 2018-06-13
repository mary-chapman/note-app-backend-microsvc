INSERT INTO TITLES
    (USER_ID, TEXT)
VALUES
    (1, 'frontend'),
    (1, 'backend');

INSERT INTO HEADERS
    (TITLE_ID, TEXT)
VALUES
    (1, 'html'),
    (1, 'css'),
    (1, 'frameworks'),
    (2, 'databases'),
    (2, 'servers');

INSERT INTO PARAS
    (HEADER_ID, TEXT)
VALUES
    (1, 'html stands for hypertext markup language'),
    (3, 'react and angular are 2 popular frameworks');

INSERT INTO CODEBLOCKS
    (HEADER_ID, TEXT)
VALUES
    (1, '<h1>this is a tag</h1>'),
    (2, 'h1: { color: blue }');