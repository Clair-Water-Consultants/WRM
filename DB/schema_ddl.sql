-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema wrm
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `wrm` ;

-- -----------------------------------------------------
-- Schema wrm
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `wrm` DEFAULT CHARACTER SET utf8 ;
USE `wrm` ;

-- -----------------------------------------------------
-- Table `wrm`.`company_group`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wrm`.`company_group` (
  `id` VARCHAR(40) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  `address` VARCHAR(255) NOT NULL,
  `CREATED_TIME` DATETIME NOT NULL,
  `UPDATED_TIME` DATETIME NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wrm`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wrm`.`user` (
  `id` VARCHAR(40) NOT NULL,
  `name` VARCHAR(50) NOT NULL,
  `PASS` VARCHAR(100) NOT NULL,
  `GROUP_ID` VARCHAR(100) NOT NULL,
  `FIRST_NAME` VARCHAR(50) NULL DEFAULT NULL,
  `LAST_NAME` VARCHAR(50) NULL DEFAULT NULL,
  `EMAIL_ID` VARCHAR(50) NULL DEFAULT NULL,
  `CREATED_TIME` DATETIME NULL DEFAULT NULL,
  `UPDATED_TIME` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `group_ix_idx` (`GROUP_ID` ASC),
  CONSTRAINT `group_ix`
    FOREIGN KEY (`GROUP_ID`)
    REFERENCES `wrm`.`company_group` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wrm`.`element`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wrm`.`element` (
  `id` VARCHAR(40) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `units` VARCHAR(45) NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  `lower_limit` FLOAT NOT NULL,
  `upper_limit` FLOAT NOT NULL,
  `CREATED_TIME` DATETIME NOT NULL,
  `UPDATED_TIME` DATETIME NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wrm`.`water`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wrm`.`water` (
  `id` VARCHAR(40) NOT NULL,
  `type` VARCHAR(100) NOT NULL,
  `description` VARCHAR(255) NOT NULL,
  `CREATED_TIME` DATETIME NOT NULL,
  `UPDATED_TIME` DATETIME NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wrm`.`water_element_association`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wrm`.`water_element_association` (
  `water_id` VARCHAR(40) NOT NULL,
  `element_id` VARCHAR(40) NOT NULL,
  `CREATED_TIME` DATETIME NOT NULL,
  `UPDATED_TIME` DATETIME NOT NULL,
  PRIMARY KEY (`water_id`, `element_id`),
  INDEX `element_ix_idx` (`element_id` ASC),
  CONSTRAINT `water_ix`
    FOREIGN KEY (`water_id`)
    REFERENCES `wrm`.`water` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `element_ix`
    FOREIGN KEY (`element_id`)
    REFERENCES `wrm`.`element` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wrm`.`bay`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wrm`.`bay` (
  `id` VARCHAR(40) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `group_id` VARCHAR(100) NULL,
  `CREATED_TIME` DATETIME NOT NULL,
  `UPDATED_TIME` DATETIME NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `group_id_idx` (`group_id` ASC),
  CONSTRAINT `group_id_ix`
    FOREIGN KEY (`group_id`)
    REFERENCES `wrm`.`company_group` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wrm`.`bay_water_association`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wrm`.`bay_water_association` (
  `bay_id` VARCHAR(40) NOT NULL,
  `water_id` VARCHAR(40) NOT NULL,
  `CREATED_TIME` DATETIME NOT NULL,
  `UPDATED_TIME` DATETIME NOT NULL,
  PRIMARY KEY (`bay_id`, `water_id`),
  INDEX `water_ix0_idx` (`water_id` ASC),
  CONSTRAINT `bay_ix`
    FOREIGN KEY (`bay_id`)
    REFERENCES `wrm`.`bay` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `water_ix0`
    FOREIGN KEY (`water_id`)
    REFERENCES `wrm`.`water` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `wrm`.`wrm_data`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `wrm`.`wrm_data` (
  `user_id` VARCHAR(40) NOT NULL,
  `bay_id` VARCHAR(40) NOT NULL,
  `water_id` VARCHAR(40) NOT NULL,
  `element_id` VARCHAR(40) NOT NULL,
  `element_value` FLOAT NOT NULL,
  `criteria` VARCHAR(20) NULL,
  `CREATED_TIME` DATETIME NOT NULL,
  `UPDATED_TIME` DATETIME NOT NULL,
  INDEX `water_ix0_idx` (`water_id` ASC),
  PRIMARY KEY (`user_id`, `bay_id`, `water_id`, `element_id`),
  INDEX `bay_ix00_idx` (`bay_id` ASC),
  INDEX `element_ix00_idx` (`element_id` ASC),
  CONSTRAINT `water_ix00`
    FOREIGN KEY (`water_id`)
    REFERENCES `wrm`.`water` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `user_ix00`
    FOREIGN KEY (`user_id`)
    REFERENCES `wrm`.`user` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `bay_ix00`
    FOREIGN KEY (`bay_id`)
    REFERENCES `wrm`.`bay` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `element_ix00`
    FOREIGN KEY (`element_id`)
    REFERENCES `wrm`.`element` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
