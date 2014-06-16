CREATE TABLE `user` (
`id` int(11) NOT NULL,
`name` varchar(32) NOT NULL,
`age` int(3) NOT NULL,
`birthday` date NULL,
`password` varchar(32) NOT NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `role` (
`id` int(11) NOT NULL,
`code` varchar(32) NOT NULL,
`name` varchar(32) NOT NULL,
PRIMARY KEY (`id`) 
);

CREATE TABLE `userRole` (
`id` int(11) NOT NULL,
`userId` int(11) NOT NULL,
`roleId` int(11) NOT NULL,
PRIMARY KEY (`id`) 
);


ALTER TABLE `userRole` ADD CONSTRAINT `fk_userRole_user_1` FOREIGN KEY (`userId`) REFERENCES `user` (`id`);
ALTER TABLE `userRole` ADD CONSTRAINT `fk_userRole_role_1` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`);

