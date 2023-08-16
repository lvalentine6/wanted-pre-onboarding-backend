USE `board`;

INSERT INTO `member` (email, password)
VALUES ('testuser1@email.com', 'password1'),
       ('testuser2@email.com', 'password2');
INSERT INTO `article` (writer_id, title, contents, last_modified_at)
VALUES (1, 'firstMemberTestArticle1', 'testContents1', '2023-08-15 12:47:20'),
       (1, 'firstTestArticle2', 'testContents2', '2023-08-15 12:47:20');

INSERT INTO `article` (writer_id, title, contents, last_modified_at)
VALUES (2, 'secondMemberTestArticle1', 'testContents1', '2023-08-15 12:47:20'),
       (2, 'secondMemberTestArticle2', 'testContents2', NOW());
