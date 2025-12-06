INSERT INTO People(id, lastname, firstname) VALUES
    ('33acebae-16ca-43b1-ade2-1b61ba176d59', 'Кабраль', 'Надежда'),
    ('ce2976e2-6474-49b1-af78-d649c0f2ae4a', 'Кабраль', 'Михаил'),
    ('a4e23b85-9f93-44ff-beb3-bb2464e1b8d6', 'Змушко', 'Юлия'),
    ('9d6daaec-7aeb-4555-b0c4-5897ded4cce3', 'Змушко', 'Станислав'),
    ('321a9317-0ecf-47da-926e-038f9f5c1e8e', 'Черняков', 'Артем');

INSERT INTO Events_Types(id, name, description) VALUES
    ('d7750feb-c057-41d5-bacf-2611ec42ed08', 'BIRTHDAY', null),
    ('1f6cd998-9f3b-4de8-b6ad-d0f2fd267c38', 'WEDDING_ANNIVERSARY', null),
    ('80e246a9-befa-431c-88a3-51c12902b80a', 'MOTHERS_DAY', null);

INSERT INTO Users(id, lastname, firstname, email, password, date_of_birthday) VALUES
    (
     'a208b62b-62ce-4ff7-bab2-624d7aa8cca0',
     'Кабраль',
     'Владислав',
     'mr.kabral@mail.ru',
     '$2a$12$q32rdu9P6QYdwk1H9LRnnOtZDDTnApEMIHyLJLjuMSLSt0IKpmBH6',
     '2002-03-27'
    );

INSERT INTO Events(id, name, description, date, type_id, person_id) VALUES
    ('a1ff0319-62aa-4ba1-ace4-20f87c9c7ba0', 'День Рождения', null, '1973-07-23', 'd7750feb-c057-41d5-bacf-2611ec42ed08', '33acebae-16ca-43b1-ade2-1b61ba176d59'),
    ('37e542cb-c080-4778-a007-856c377b8662', 'День Рождения', null, '1972-08-12', 'd7750feb-c057-41d5-bacf-2611ec42ed08', 'ce2976e2-6474-49b1-af78-d649c0f2ae4a'),
    ('0b4dd414-2577-4011-a64b-381d1660294e', 'День Рождения', null, '1994-01-26', 'd7750feb-c057-41d5-bacf-2611ec42ed08', 'a4e23b85-9f93-44ff-beb3-bb2464e1b8d6'),
    ('c790a277-65b0-492d-bfde-2568ca1d0090', 'День Рождения', null, '2018-11-28', 'd7750feb-c057-41d5-bacf-2611ec42ed08', '9d6daaec-7aeb-4555-b0c4-5897ded4cce3'),
    ('53e35699-4d67-4f2f-864f-7934a883450d', 'День Рождения', null, '2002-10-15', 'd7750feb-c057-41d5-bacf-2611ec42ed08', '321a9317-0ecf-47da-926e-038f9f5c1e8e'),
    ('ce26291e-e121-4e88-933d-d6f939e5269e', 'Годовщина свадьбы', 'Годовщина свадьбы у Кабраля Михаила и Кабраль Надежды', '1993-04-24', '1f6cd998-9f3b-4de8-b6ad-d0f2fd267c38', null),
    ('8bb28dd2-ff33-4a22-b48c-ae1c018b0bba', 'День Матери', null, '2000-10-14', '80e246a9-befa-431c-88a3-51c12902b80a', null);

INSERT INTO Subscriptions(user_id, event_id) VALUES
    ('a208b62b-62ce-4ff7-bab2-624d7aa8cca0', 'a1ff0319-62aa-4ba1-ace4-20f87c9c7ba0'),
    ('a208b62b-62ce-4ff7-bab2-624d7aa8cca0', '37e542cb-c080-4778-a007-856c377b8662'),
    ('a208b62b-62ce-4ff7-bab2-624d7aa8cca0', '0b4dd414-2577-4011-a64b-381d1660294e'),
    ('a208b62b-62ce-4ff7-bab2-624d7aa8cca0', 'c790a277-65b0-492d-bfde-2568ca1d0090'),
    ('a208b62b-62ce-4ff7-bab2-624d7aa8cca0', '53e35699-4d67-4f2f-864f-7934a883450d'),
    ('a208b62b-62ce-4ff7-bab2-624d7aa8cca0', 'ce26291e-e121-4e88-933d-d6f939e5269e'),
    ('a208b62b-62ce-4ff7-bab2-624d7aa8cca0', '8bb28dd2-ff33-4a22-b48c-ae1c018b0bba');