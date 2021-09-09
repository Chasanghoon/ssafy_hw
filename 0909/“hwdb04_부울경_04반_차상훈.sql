-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema OrderSystem
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema OrderSystem
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `OrderSystem` DEFAULT CHARACTER SET utf8 ;
USE `OrderSystem` ;

-- -----------------------------------------------------
-- Table `OrderSystem`.`user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OrderSystem`.`user` ;

CREATE TABLE IF NOT EXISTS `OrderSystem`.`user` (
  `user_id` INT NOT NULL,
  `user_name` VARCHAR(45) NULL,
  `user_address` VARCHAR(45) NULL,
  `user_tel1` VARCHAR(45) NULL,
  `user_tel2` VARCHAR(45) NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OrderSystem`.`order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OrderSystem`.`order` ;

CREATE TABLE IF NOT EXISTS `OrderSystem`.`order` (
  `order_id` INT NOT NULL AUTO_INCREMENT,
  `order_price` INT NULL,
  `order_pay` VARCHAR(45) NULL,
  `order_delivery` VARCHAR(45) NULL DEFAULT 'N',
  `user_id` INT NULL,
  PRIMARY KEY (`order_id`),
  INDEX `order_user_id_fk_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `order_user_id_fk`
    FOREIGN KEY (`user_id`)
    REFERENCES `OrderSystem`.`user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OrderSystem`.`product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OrderSystem`.`product` ;

CREATE TABLE IF NOT EXISTS `OrderSystem`.`product` (
  `product_id` INT NOT NULL,
  `product_name` VARCHAR(45) NOT NULL,
  `price` INT NULL,
  PRIMARY KEY (`product_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `OrderSystem`.`order_detail`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `OrderSystem`.`order_detail` ;

CREATE TABLE IF NOT EXISTS `OrderSystem`.`order_detail` (
  `order_id` INT NOT NULL,
  `product_id` INT NULL,
  `cnt` INT NULL,
  PRIMARY KEY (`order_id`),
  INDEX `order_detail_product_id_fk_idx` (`product_id` ASC) VISIBLE,
  CONSTRAINT `order_detail_product_id_fk`
    FOREIGN KEY (`product_id`)
    REFERENCES `OrderSystem`.`product` (`product_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `order_detail_order_id_fk`
    FOREIGN KEY (`order_id`)
    REFERENCES `OrderSystem`.`order` (`order_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
