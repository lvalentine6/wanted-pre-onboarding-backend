USE `board`;

INSERT INTO `member` (email, password) VALUES
                                           ('testuser1@email.com', 'password1'),
                                           ('testuser2@email.com', 'password2');
INSERT INTO `article` (writer_id, title, contents, posted_at) VALUES
                                                                              (1, '첫번째 유저 게시글 제목1', '첫번째 유저 게시글 내용1', NOW()),
                                                                              (1, '첫번째 유저 게시글 제목2', '첫번째 유저 게시글 내용2', NOW());

INSERT INTO `article` (writer_id, title, contents, posted_at) VALUES
                                                                              (2, '두번째 유저 게시글 제목1', '두번째 유저 게시글 내용1', NOW()),
                                                                              (2, '두번째 유저 게시글 제목1', '두번째 유저 게시글 내용1', NOW());
