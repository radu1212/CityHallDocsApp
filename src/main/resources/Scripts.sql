

-- -----------------------------------------------------
-- Table `labsd`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `labsd`.`user` (
  `UUID` VARCHAR(255) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `role` BIT(1) NOT NULL,
  `username` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`UUID`),
  UNIQUE INDEX `UK_sb8bbouer5wak8vyiiy4pf2bx` (`username` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `labsd`.`address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `labsd`.`address` (
  `UUID` VARCHAR(255) NOT NULL,
  `apartment` VARCHAR(255) NOT NULL,
  `city` VARCHAR(255) NOT NULL,
  `county` VARCHAR(255) NOT NULL,
  `number` VARCHAR(255) NOT NULL,
  `street` VARCHAR(255) NOT NULL,
  `user_id` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`UUID`),
  INDEX `FKda8tuywtf0gb6sedwk7la1pgi` (`user_id` ASC) VISIBLE,
  CONSTRAINT `FKda8tuywtf0gb6sedwk7la1pgi`
    FOREIGN KEY (`user_id`)
    REFERENCES `labsd`.`user` (`UUID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `labsd`.`document`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `labsd`.`document` (
  `UUID` VARCHAR(255) NOT NULL,
  `requires_address` BIT(1) NULL DEFAULT NULL,
  `title` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`UUID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;





-- -----------------------------------------------------
-- Table `labsd`.`request`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `labsd`.`request` (
  `UUID` VARCHAR(255) NOT NULL,
  `address` VARCHAR(255) NULL DEFAULT NULL,
  `document` VARCHAR(255) NOT NULL,
  `status` VARCHAR(255) NOT NULL,
  `time` VARCHAR(255) NOT NULL,
  `user_id` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`UUID`),
  INDEX `FKqws2fdeknk90txm7qnm9bxd07` (`user_id` ASC) VISIBLE,
  CONSTRAINT `FKqws2fdeknk90txm7qnm9bxd07`
    FOREIGN KEY (`user_id`)
    REFERENCES `labsd`.`user` (`UUID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4;









Hibernate: insert into address (apartment, city, county, number, street, user_id, UUID) values (?, ?, ?, ?, ?, ?, ?)
Hibernate: insert into request (address, document, status, time, user_id, UUID) values (?, ?, ?, ?, ?, ?)
Hibernate: insert into document (requires_address, title, UUID) values (?, ?, ?)


Hibernate: delete from document where title=?
Hibernate: delete from request where time=?


Hibernate: update request set address=?, document=?, status=?, time=?, user_id=? where UUID=?
Hibernate: update user set email=?, password=?, role=?, username=? where UUID=?
