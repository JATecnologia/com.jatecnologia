SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `jat-ie` ;
CREATE SCHEMA IF NOT EXISTS `jat-ie` ;
USE `jat-ie` ;

-- -----------------------------------------------------
-- Table `jat-ie`.`ie_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jat-ie`.`ie_user` ;

CREATE  TABLE IF NOT EXISTS `jat-ie`.`ie_user` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `login` VARCHAR(25) NOT NULL ,
  `password` VARCHAR(64) NOT NULL ,
  `email` VARCHAR(50) NOT NULL ,
  `update_date` DATETIME NOT NULL ,
  `update_user` VARCHAR(25) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `uk_user_login` (`login` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jat-ie`.`ie_group`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jat-ie`.`ie_group` ;

CREATE  TABLE IF NOT EXISTS `jat-ie`.`ie_group` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(30) NOT NULL ,
  `email` VARCHAR(25) NOT NULL ,
  `update_date` DATETIME NOT NULL ,
  `update_user` VARCHAR(25) NOT NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `uk_group_name` (`name` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jat-ie`.`ie_user_group`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jat-ie`.`ie_user_group` ;

CREATE  TABLE IF NOT EXISTS `jat-ie`.`ie_user_group` (
  `group_id` INT NOT NULL ,
  `user_id` INT NOT NULL ,
  `update_date` DATETIME NOT NULL ,
  `update_user` VARCHAR(25) NOT NULL ,
  PRIMARY KEY (`group_id`, `user_id`) ,
  INDEX `fk_user_id` (`user_id` ASC) ,
  CONSTRAINT `fk_user_id`
    FOREIGN KEY (`user_id` )
    REFERENCES `jat-ie`.`ie_user` (`id` )
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_group_id`
    FOREIGN KEY (`group_id` )
    REFERENCES `jat-ie`.`ie_group` (`id` ))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jat-ie`.`ie_cutomer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jat-ie`.`ie_cutomer` ;

CREATE  TABLE IF NOT EXISTS `jat-ie`.`ie_cutomer` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `first_name` VARCHAR(25) NOT NULL ,
  `surname` VARCHAR(50) NOT NULL ,
  `birth_date` DATETIME NOT NULL ,
  `gender` ENUM('F', 'M') NOT NULL ,
  `email` VARCHAR(45) NOT NULL ,
  `create_date` DATETIME NOT NULL ,
  `actived` TINYINT(1) NOT NULL DEFAULT true ,
  `update_date` DATETIME NOT NULL ,
  `update_user` VARCHAR(25) NOT NULL ,
  `jat_cutomercol` VARCHAR(45) NULL ,
  PRIMARY KEY (`id`) ,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) ,
  UNIQUE INDEX `first_name_UNIQUE` (`first_name` ASC) ,
  UNIQUE INDEX `surname_UNIQUE` (`surname` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jat-ie`.`ie_customer_contact`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jat-ie`.`ie_customer_contact` ;

CREATE  TABLE IF NOT EXISTS `jat-ie`.`ie_customer_contact` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `customer_id` INT NOT NULL ,
  `type` ENUM('C', 'M', 'O', 'R') NOT NULL ,
  `operator` VARCHAR(15) NOT NULL ,
  `contry_code` VARCHAR(2) NOT NULL DEFAULT '55' ,
  `ddd` VARCHAR(2) NOT NULL ,
  `telephone` VARCHAR(9) NOT NULL ,
  `update_date` DATETIME NOT NULL ,
  `update_user` VARCHAR(25) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_jat_customer_id_idx` (`customer_id` ASC) ,
  CONSTRAINT `fk_jat_customer_id`
    FOREIGN KEY (`customer_id` )
    REFERENCES `jat-ie`.`ie_cutomer` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jat-ie`.`ie_customer_address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jat-ie`.`ie_customer_address` ;

CREATE  TABLE IF NOT EXISTS `jat-ie`.`ie_customer_address` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `customer_id` INT NOT NULL ,
  `type` ENUM('C', 'R') NOT NULL ,
  `street` VARCHAR(60) NOT NULL ,
  `number` VARCHAR(10) NOT NULL ,
  `complement` VARCHAR(25) NOT NULL ,
  `neighborhood` VARCHAR(30) NOT NULL ,
  `county` VARCHAR(45) NOT NULL ,
  `city` VARCHAR(45) NOT NULL ,
  `country` VARCHAR(25) NOT NULL DEFAULT 'BRASIL' ,
  `update_date` DATETIME NOT NULL ,
  `update_user` VARCHAR(25) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_jat_customer_id_idx` (`customer_id` ASC) ,
  CONSTRAINT `fk_jat_customer_address_id`
    FOREIGN KEY (`customer_id` )
    REFERENCES `jat-ie`.`ie_cutomer` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jat-ie`.`ie_product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jat-ie`.`ie_product` ;

CREATE  TABLE IF NOT EXISTS `jat-ie`.`ie_product` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NOT NULL ,
  `description` VARCHAR(255) NOT NULL ,
  `create_date` DATETIME NOT NULL ,
  `actived` TINYINT(1) NOT NULL DEFAULT true ,
  `update_date` DATETIME NOT NULL ,
  `update_user` VARCHAR(25) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jat-ie`.`ie_transaction_status`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jat-ie`.`ie_transaction_status` ;

CREATE  TABLE IF NOT EXISTS `jat-ie`.`ie_transaction_status` (
  `status` VARCHAR(15) NOT NULL ,
  `description` VARCHAR(45) NOT NULL ,
  `update_date` DATETIME NOT NULL ,
  `update_user` VARCHAR(25) NOT NULL ,
  PRIMARY KEY (`status`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jat-ie`.`ie_language`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jat-ie`.`ie_language` ;

CREATE  TABLE IF NOT EXISTS `jat-ie`.`ie_language` (
  `code` VARCHAR(2) NOT NULL ,
  `description` VARCHAR(45) NOT NULL ,
  `update_date` DATETIME NOT NULL ,
  `update_user` VARCHAR(25) NOT NULL ,
  PRIMARY KEY (`code`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `jat-ie`.`ie_transaction`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `jat-ie`.`ie_transaction` ;

CREATE  TABLE IF NOT EXISTS `jat-ie`.`ie_transaction` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `customer_id` INT NOT NULL ,
  `user_id` INT NOT NULL ,
  `contact` VARCHAR(20) NOT NULL ,
  `product_id` INT NOT NULL ,
  `locality` VARCHAR(20) NOT NULL ,
  `language_code` VARCHAR(2) NOT NULL ,
  `scheduled` DATETIME NOT NULL ,
  `appointment` DATETIME NOT NULL ,
  `visit` DATETIME NULL ,
  `transaction_status` VARCHAR(15) NOT NULL ,
  `last_contact` DATETIME NOT NULL ,
  `closing_date` DATETIME NOT NULL ,
  `observation` LONGTEXT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_ie_customer_id_idx` (`customer_id` ASC) ,
  INDEX `fk_ie_user_id_idx` (`user_id` ASC) ,
  INDEX `fk_ie_product_id_idx` (`product_id` ASC) ,
  INDEX `fk_ie_transaction_status[_idx` (`transaction_status` ASC) ,
  INDEX `fk_ie_language_code_idx` (`language_code` ASC) ,
  CONSTRAINT `fk_ie_customer_id`
    FOREIGN KEY (`customer_id` )
    REFERENCES `jat-ie`.`ie_cutomer` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ie_user_id`
    FOREIGN KEY (`user_id` )
    REFERENCES `jat-ie`.`ie_user` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ie_product_id`
    FOREIGN KEY (`product_id` )
    REFERENCES `jat-ie`.`ie_product` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ie_transaction_status[`
    FOREIGN KEY (`transaction_status` )
    REFERENCES `jat-ie`.`ie_transaction_status` (`status` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ie_language_code`
    FOREIGN KEY (`language_code` )
    REFERENCES `jat-ie`.`ie_language` (`code` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
COMMENT = ' ';

USE `jat-ie` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
