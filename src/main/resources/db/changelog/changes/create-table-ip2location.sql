-- liquibase formatted sql

-- changeset gdp:create-table-ip2location splitStatements:true endDelimiter:;
CREATE TABLE `ip2location` (
    `ip_from`      bigint(11) NOT NULL,
    `ip_to`        bigint(11) NOT NULL,
    `country_code` varchar(2) NOT NULL,
    `country_name` varchar(64) NOT NULL,
    `region_name`  varchar(128) NOT NULL,
    `city_name`    varchar(128) NOT NULL,
    `latitude`     double NOT NULL,
    `longitude`    double NOT NULL,
    PRIMARY KEY `idx_ip_from_to` (`ip_from`, `ip_to`)
) ENGINE = InnoDB DEFAULT CHARSET = utf8 COLLATE = utf8_bin;

-- rollback drop table ip2location;
