use quizApp;

insert into
    User(firstName, lastName, email, password, phone)
VALUES
    ('Anna', 'Audrey', 'anna@gmail.com', '1234', 1234),
    ('Bob', 'Li', 'bob@gmail.com', '1234', 1234)
;

insert into
    User(firstname, lastname, email, password, phone, is_admin)
VALUES
    ('ad', 'min', 'admin@gmail.com', '123', 4321, true);


# http://mathandreadinghelp.org/multiple_choice_math_problems.html
insert into Question(category, description)
values

       ('Math',
            'A pizza is divided into 12 slices.
            \nIf there are eight slices left, what fraction of the pizza is remaining?'),
       ('Math',
            'There are ten houses on the street.
                Three people live in each house.
            \nHow many people live on the street?'),
       ('Math',
        'In a recipe, you have to add one cup of sugar for every four cups of flour.
        \nWhat is the ratio of sugar to flour?'),

       ('Chemistry',
        'Which one of the following fertilizers has more nitrogen content?'),
       ('Chemistry',
        'The most important are of aluminum is?'),
       ('Chemistry',
        'Number of electrons in sodium ion is?')
        ;

insert into Choice(question_id, description, is_correct)
VALUES
    (1, '2/3',true ),
    (1, '3/4',false ),
    (1, '1/5',false ),
    (1, '2/4',false ),

    (2, '30',true),
    (2, '10',false),
    (2, '20',false),
    (2, '40',false),

    (3, '1:4',true),
    (3, '1:5',false),
    (3, '1:6',false),
    (3, '1:7',false),

    (4, 'Urea',true),
    (4, 'Ammonium Nitrate',false),
    (4, 'Potassium Nitrate',false),
    (4, 'Ammonium Phosphate ',false),

    (5, 'Bauxite',true),
    (5, 'Galena',false),
    (5, 'Calcite',false),
    (5, 'Calamine',false),

    (6, 'Urea',true),
    (6, 'Ammonium Nitrate',false),
    (6, 'Potassium Nitrate',false),
    (6, 'Ammonium Phosphate ',false)
;

use quizApp;


# http://mathandreadinghelp.org/multiple_choice_math_problems.html
insert into Question(category, description)
values

    ('Math',
     'It takes Matt four hours to mow two lawns.
\nHow many lawns can he mow in ten hours?'),
    ('Math',
     '20 = 3x + 8; x = ?'),
    ('Math',
     'If y = 3x + 12 and y = 5, what is x?'),
    ('Math',
     '4 + 5 = ?')
;

insert into Choice(question_id, description, is_correct)
VALUES
    (7, 'Two lawns',true),
    (7, 'Five lawns',false),
    (7, 'Ten lawns',false),
    (7, 'Six lawns',false),

    (8, '3', true),
    (8, '2', false),
    (8, '4', false),
    (8, '5', false),

    (9, '7/3',true),
    (9, '3/7',false),
    (9, '-7',false),
    (9, '-7/3',true),

    (10, '1',true),
    (10, '2',false),
    (10, '9',false),
    (10, '10',false)

;


insert into Question(category, description)
values

    ('Chemistry',
     'Which of the following is not known as green house gas?'),
    ('Chemistry',
     'Penumbra is formed due to ___'),
    ('Chemistry',
     'Which of the following scientists was awarded the Nobel Prize in
1911 for the discovery of the radioactive elements, radium and polonium?'),
    ('Chemistry',
     'Which of the following pairs of German scientists discovered the
atomic fission of uranium and set the stage for the nuclear age?')
;


insert into Choice(question_id, description, is_correct)
VALUES
    (11, 'Hydrogen', true),
    (11, 'Carbon dioxide',false),
    (11, 'Nitrous oxide',false),
    (11, 'Methane',false),

    (12, 'source of light', true),
    (12, 'a point source of light', false),
    (12, 'an extended source of light', false),
    (12, 'a source of sound', false),

    (13, 'John Dalton',true),
    (13, 'Dmitri Mendeleev',false),
    (13, 'Jingwen Bai',false),
    (13, 'Marie Curie',false),

    (14, 'Hahn and Strassman',true),
    (14, 'Nernst and Planck',false),
    (14, 'Ostwald and Heisenberg',false),
    (14, 'Bohr and Rutherford',false)
;



insert into Question(category, description)
values

    ('Biology',
     'The adult human of average age and size has approximately how many quarts of
blood? Is it:'),
    ('Biology',
     'Once the erythrocytes enter the blood in humans, it is estimated that they have an
average lifetime of how many days. Is it:'),
    ('Biology',
     'Of the following, which mechanisms are important in the death of erythrocytes (pron:
eh-rith-reh-sites) in human blood? Is it'),
    ('Biology',
     'Surplus red blood cells, needed to meet an emergency, are MAINLY stored in what
organ of the human body? Is it the:'),
    ('Biology',
     'When a human donor gives a pint of blood, it usually requires how many weeks for
the body RESERVE of red corpuscles to be replaced? Is it:'),
    ('Biology',
     'The several types of white blood cells are sometime collectively referred to as:'),
    ('Biology',
     'The condition in which there is a DECREASE in the number of white blood cells in
humans is known as:')
;



insert into Choice(question_id, description, is_correct)
VALUES
    (15, '4', true),
    (15, '6',false),
    (15, '8',false),
    (15, '10',false),

    (16, '10 days', true),
    (16, '120 days', false),
    (16, '200 days', false),
    (16, '360 days', false),

    (17, 'phagocytosis',true),
    (17, 'hemolysis',false),
    (17, 'mechanical damage',false),
    (17, 'all of the above',false),

    (18, 'pancreas',true),
    (18, 'spleen',false),
    (18, 'liver',false),
    (18, 'kidneys',false),

    (19, '1 week', true),
    (19, '3 week', false),
    (19, '7 week', false),
    (19, '21 week', false),

    (20, 'erythrocytes',true),
    (20, 'leukocytes',false),
    (20, 'erythroblasts',false),
    (20, 'thrombocytes',false),

    (21, 'leukocytosis',true),
    (21, 'leukopenia', false),
    (21, 'leukemia',false),
    (21, 'leukohyperia',false)
;


insert into Question(category, description)
values

    ('Math',
     'It takes Matt four hours to mow two lawns.
\nHow many lawns can he mow in ten hours?'),
    ('Math',
     '20 = 3x + 8; x = ?'),
    ('Math',
     'If y = 3x + 12 and y = 5, what is x?'),
    ('Math',
     '4 + 5 = ?')
;

insert into Choice(question_id, description, is_correct)
VALUES
    (7, 'Two lawns',true),
    (7, 'Five lawns',false),
    (7, 'Ten lawns',false),
    (7, 'Six lawns',false),

    (8, '3', true),
    (8, '2', false),
    (8, '4', false),
    (8, '5', false),

    (9, '7/3',true),
    (9, '3/7',false),
    (9, '-7',false),
    (9, '-7/3',true),

    (10, '1',true),
    (10, '2',false),
    (10, '9',false),
    (10, '10',false)

;


insert into Question(category, description)
values

    ('Chemistry',
     'Which of the following is not known as green house gas?'),
    ('Chemistry',
     'Penumbra is formed due to ___'),
    ('Chemistry',
     'Which of the following scientists was awarded the Nobel Prize in
1911 for the discovery of the radioactive elements, radium and polonium?'),
    ('Chemistry',
     'Which of the following pairs of German scientists discovered the
atomic fission of uranium and set the stage for the nuclear age?')
;


insert into Choice(question_id, description, is_correct)
VALUES
    (11, 'Hydrogen', true),
    (11, 'Carbon dioxide',false),
    (11, 'Nitrous oxide',false),
    (11, 'Methane',false),

    (12, 'source of light', true),
    (12, 'a point source of light', false),
    (12, 'an extended source of light', false),
    (12, 'a source of sound', false),

    (13, 'John Dalton',true),
    (13, 'Dmitri Mendeleev',false),
    (13, 'Jingwen Bai',false),
    (13, 'Marie Curie',false),

    (14, 'Hahn and Strassman',true),
    (14, 'Nernst and Planck',false),
    (14, 'Ostwald and Heisenberg',false),
    (14, 'Bohr and Rutherford',false)
;



insert into Question(category, description)
values

    ('Biology',
     'The adult human of average age and size has approximately how many quarts of
blood? Is it:'),
    ('Biology',
     'Once the erythrocytes enter the blood in humans, it is estimated that they have an
average lifetime of how many days. Is it:'),
    ('Biology',
     'Of the following, which mechanisms are important in the death of erythrocytes (pron:
eh-rith-reh-sites) in human blood? Is it'),
    ('Biology',
     'Surplus red blood cells, needed to meet an emergency, are MAINLY stored in what
organ of the human body? Is it the:'),
    ('Biology',
     'When a human donor gives a pint of blood, it usually requires how many weeks for
the body RESERVE of red corpuscles to be replaced? Is it:'),
    ('Biology',
     'The several types of white blood cells are sometime collectively referred to as:'),
    ('Biology',
     'The condition in which there is a DECREASE in the number of white blood cells in
humans is known as:')
;



insert into Choice(question_id, description, is_correct)
VALUES
    (15, '4', true),
    (15, '6',false),
    (15, '8',false),
    (15, '10',false),

    (16, '10 days', true),
    (16, '120 days', false),
    (16, '200 days', false),
    (16, '360 days', false),

    (17, 'phagocytosis',true),
    (17, 'hemolysis',false),
    (17, 'mechanical damage',false),
    (17, 'all of the above',false),

    (18, 'pancreas',true),
    (18, 'spleen',false),
    (18, 'liver',false),
    (18, 'kidneys',false),

    (19, '1 week', true),
    (19, '3 week', false),
    (19, '7 week', false),
    (19, '21 week', false),

    (20, 'erythrocytes',true),
    (20, 'leukocytes',false),
    (20, 'erythroblasts',false),
    (20, 'thrombocytes',false),

    (21, 'leukocytosis',true),
    (21, 'leukopenia', false),
    (21, 'leukemia',false),
    (21, 'leukohyperia',false)
;




