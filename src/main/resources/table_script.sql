CREATE TABLE `TEST_DUMMY` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `name` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `account` varchar(45) COLLATE utf8_unicode_ci DEFAULT NULL,
  `country_code` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;


CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `location` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(1000) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



CREATE TABLE `items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `desc` text COLLATE utf8_unicode_ci,
  `price` decimal(10,2) DEFAULT NULL,
  `cat_id` int(11) DEFAULT NULL,
  `location_id` int(3) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `category_on_item_fk_idx` (`cat_id`),
  CONSTRAINT `category_on_item_fk` FOREIGN KEY (`cat_id`) REFERENCES `category` (`id`),
    KEY `location_on_item_fk_idx` (`location_id`),
  CONSTRAINT `location_on_item_fk_idx` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

CREATE TABLE `currency_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `unit` varchar(10) COLLATE utf8_unicode_ci DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;



INSERT INTO `magpie`.`category`(name) VALUES('Electronics');
INSERT INTO `magpie`.`category`(name) VALUES('Foods');
INSERT INTO `magpie`.`location`(name) VALUES('Seoul');
INSERT INTO `magpie`.`location`(name) VALUES('Busan');
INSERT INTO `magpie`.`location`(name) VALUES('Daejeon');
INSERT INTO `magpie`.`items`(`name`,`desc`,`price`,`cat_id`,`location_id`) VALUES('Network card','',200, 1, 1);
INSERT INTO `magpie`.`items`(`name`,`desc`,`price`,`cat_id`,`location_id`) VALUES('Lan cable','',100, 1, 1);
INSERT INTO `magpie`.`items`(`name`,`desc`,`price`,`cat_id`,`location_id`) VALUES('Laptop computer','',199, 1, 2);
INSERT INTO `magpie`.`items`(`name`,`desc`,`price`,`cat_id`,`location_id`) VALUES('Lan Docker','',1, 1, 2);
INSERT INTO `magpie`.`items`(`name`,`desc`,`price`,`cat_id`,`location_id`) VALUES('Rice','','50', 2, 3);
INSERT INTO `magpie`.`items`(`name`,`desc`,`price`,`cat_id`,`location_id`) VALUES('Bread','',2, 1, 3);
INSERT INTO `magpie`.`items`(`name`,`desc`,`price`,`cat_id`,`location_id`) VALUES('Toilet paper','',1, 1, 1);
INSERT INTO `magpie`.`items`(`name`,`desc`,`price`,`cat_id`,`location_id`) VALUES('Apple','',100, 1, 2);
INSERT INTO `magpie`.`items`(`name`,`desc`,`price`,`cat_id`,`location_id`) VALUES('Snack','',1, 1, 3);
INSERT INTO `magpie`.`items`(`name`,`desc`,`price`,`cat_id`,`location_id`) VALUES('Beer','',2, 1, 3);
INSERT INTO `magpie`.`currency_info`(`unit`, `price`) VALUES ('KRW', 1220);
INSERT INTO `magpie`.`currency_info`(`unit`, `price`) VALUES ('EUR', 1.2);




