-- https://www.baeldung.com/spring-boot-data-sql-and-schema-sql
INSERT IGNORE INTO greeting (id, template) VALUES
   (1, 'Hello there %s!'),
   (2, 'Hi %s how are you?'),
   (3, 'Hey %s how is it going?'),
   (4, '%s I''m so glad to see you!');
