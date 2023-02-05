create database if not exists quizApp;
use quizApp;


create table if not exists User
(
    user_id int auto_increment,
    firstName varchar(20) ,
    lastName varchar(20) ,
    email varchar(50) unique,
    password varchar(20),
    phone int ,
    is_active boolean default true,
    is_admin boolean default false,
    primary key (user_id)
    );


create table if not exists Quiz
(
    quiz_id int auto_increment,
    user_id int not null ,
    category varchar(20),
    name varchar(50),
    time_start timestamp,
    time_end timestamp,
    primary key (quiz_id),
    foreign key (user_id) references User(user_id)
    );

create table if not exists Question
(
    question_id int auto_increment,
    category varchar(20),
    description varchar(200),
    is_active boolean default true,
    primary key (question_id)
    );

create table if not exists Choice
(
    choice_id int auto_increment,
    question_id int,
    choice_description varchar(200),
    is_correct boolean not null,
    primary key (choice_id),
    foreign key (question_id) references Question(question_id)
    );

create table if not exists QuizQuestion
(
    qq_id int auto_increment,
    quiz_id int,
    question_id int,
    user_choice_id int ,
    order_num int,
    primary key (qq_id),
    foreign key (quiz_id) references Quiz(quiz_id),
    foreign key (question_id) references Question(question_id),
    foreign key (user_choice_id) references Choice(choice_id)
    );

create table if not exists Feedback
(
    feedback_id int auto_increment,
    user_id int,
    message varchar(200),
    rating int,
    date timestamp,
    primary key (feedback_id),
    foreign key (user_id) references User(user_id)
);


create table if not exists Contact
(
    contact_id int auto_increment,
    firstName varchar(20),
    lastName varchar(20),
    subject varchar(50),
    message varchar(200),
    primary key (contact_id)
);


