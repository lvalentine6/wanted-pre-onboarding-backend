SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0;
SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0;
SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE =
        'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

DROP SCHEMA IF EXISTS `board`;

CREATE SCHEMA IF NOT EXISTS `board` DEFAULT CHARACTER SET utf8;
USE `board`;

DROP TABLE IF EXISTS board.`member`;

CREATE TABLE IF NOT EXISTS `board`.`member`
(
    `member_id` BIGINT(20)   NOT NULL AUTO_INCREMENT,
    `email`     VARCHAR(50)  NOT NULL,
    `password`  VARCHAR(255) NOT NULL,
    PRIMARY KEY (`member_id`),
    UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE
)
    ENGINE = InnoDB;

DROP TABLE IF EXISTS `board`.`article`;

CREATE TABLE IF NOT EXISTS `board`.`article`
(
    `article_id`     BIGINT(20)   NOT NULL AUTO_INCREMENT,
    `writer_id`      BIGINT(20)   NOT NULL,
    `title`          VARCHAR(100) NOT NULL,
    `contents`       VARCHAR(500) NULL,
    last_modified_at DATETIME     NOT NULL,
    PRIMARY KEY (`article_id`),
    INDEX `fk_article_member_idx` (`writer_id` ASC) VISIBLE,
    CONSTRAINT `fk_article_member`
        FOREIGN KEY (`writer_id`)
            REFERENCES `board`.`member` (`member_id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


SET SQL_MODE = @OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS;
