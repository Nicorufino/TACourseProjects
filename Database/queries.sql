INSERT INTO newsPortal.Suscription_level (`name`, `cost`) Values ('free', 0);
INSERT INTO newsPortal.Suscription_level (`name`, `cost`) Values ('plus', 10);
INSERT INTO newsPortal.Suscription_level (`name`, `cost`) Values ('premium', 15);
INSERT INTO newsPortal.Users (`first_name`, `last_name`, `age`,`Suscription_level_id`) Values ('Nicolas', 'Rufino', 18, 2);
INSERT INTO newsPortal.Users (`first_name`, `last_name`, `age`,`Suscription_level_id`) Values ('Alex', 'Rodriguez', 24, 1);
INSERT INTO newsPortal.Users (`first_name`, `last_name`, `age`,`Suscription_level_id`) Values ('John', 'Smith', 18, 2);
INSERT INTO newsPortal.Categories (`name`) VALUES ('Politics');
INSERT INTO newsPortal.Location (`name`) VALUES ('United States');
INSERT INTO newsPortal.Tags (`name`) VALUES ('Elections');
INSERT INTO newsPortal.Tags (`name`) VALUES ('Democrat Party');
INSERT INTO newsPortal.Articles (`name`,`date`,`body`, `Suscription_level_id`, `Categories_id`, `author`) VALUES ('The Democrat party comes on top', '2020-11-03',  'lorem ipsum', 2, 1, 1);
INSERT INTO `newsPortal`.`Articles` (`name`, `date`, `body`, `Suscription_level_id`, `Categories_id`, `author`) VALUES ('Second Article', 2021-08-03, 'article text', 3, 1, 3);
INSERT INTO `newsPortal`.`Comments` (`comment_text`, `Users_id`, `Articles_id`) VALUES ('nice article!', 2, 1);
INSERT INTO `newsPortal`.`Users_follows_Tags` (`Users_id`, `Tags_id`) VALUES (3, 1);
INSERT INTO `newsPortal`.`Location_has_Articles` (`Location_id`, `Articles_id`) VALUES (1, 1);

UPDATE newsPortal.Users set age = age + 1;
UPDATE newsPortal.Suscription_level set cost = 7.5 where id = 2;
UPDATE newsPortal.Suscription_level set cost = 12.5 where id = 3;
UPDATE newsPortal.Tags set name = 'Elections (finished)' where name = 'Elections';
UPDATE newsPortal.Users set suscription_level_id = 3 where id = 1;
UPDATE newsPortal.Users set suscription_level_id = 2 where id = 2;
UPDATE newsPortal.Location set name = 'United States of America' where name = 'United States';
UPDATE newsPortal.Comments set Users_Suscription_level_id = 2 where Users_id = 2;
UPDATE newsPortal.Users set username = 'nicoRufino' where id = 1;
UPDATE newsPortal.Users set username = 'Alex1313' where id = 2;
UPDATE newsPortal.Articles set date = '2020/11/04' where id = 1;
UPDATE newsPortal.Articles set name = 'Democrats win the elections' where id = 1;
UPDATE newsPortal.Articles set body = 'body of the new' where id = 1;
UPDATE newsPortal.Comments set comment_text = 'Nice new!!!' where id = 1;
UPDATE newsPortal.Users set first_name = 'Alexander' where first_name = 'Alex';

DELETE FROM newsPortal.Comments where id = 1;
DELETE FROM newsPortal.Users where id = 2;
DELETE FROM newsPortal.Tags where name = 'Democrat Party';
DELETE FROM newsPortal.Articles where id = 2;
DELETE FROM newsPortal.Suscription_level where name = 'free';
 

