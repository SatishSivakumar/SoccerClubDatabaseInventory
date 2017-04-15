insert ignore into sec_group(groupname, groupdesc) values('PLAYERS','This group contains players.');
insert ignore into sec_group(groupname, groupdesc) values('MANAGERS','This group contains managers.');

insert ignore into sec_user(username, password) values('player1',SHA2('player1',256)); 
insert ignore into sec_user(username, password) values('player2',SHA2('player2',256)); 
insert ignore into sec_user(username, password) values('player3',SHA2('player3',256)); 
insert ignore into sec_user(username, password) values('player4',SHA2('player4',256)); 
insert ignore into sec_user(username, password) values('player5',SHA2('player5',256)); 
insert ignore into sec_user(username, password) values('player6',SHA2('player6',256));
insert ignore into sec_user(username, password) values('player8',SHA2('player8',256));
insert ignore into sec_user(username, password) values('player9',SHA2('player9',256));
insert ignore into sec_user(username, password) values('player10',SHA2('player10',256));
insert ignore into sec_user(username, password) values('player11',SHA2('player11',256));
insert ignore into sec_user(username, password) values('player12',SHA2('player12',256));
insert ignore into sec_user(username, password) values('player13',SHA2('player13',256));
insert ignore into sec_user(username, password) values('player14',SHA2('player14',256));
insert ignore into sec_user(username, password) values('player15',SHA2('player15',256));
insert ignore into sec_user(username, password) values('player16',SHA2('player16',256));
insert ignore into sec_user(username, password) values('player17',SHA2('player17',256));
insert ignore into sec_user(username, password) values('player18',SHA2('player18',256));
insert ignore into sec_user(username, password) values('player19',SHA2('player19',256));
insert ignore into sec_user(username, password) values('player20',SHA2('player20',256));
insert ignore into sec_user(username, password) values('player21',SHA2('player21',256));
insert ignore into sec_user(username, password) values('player22',SHA2('player22',256)); 
insert ignore into sec_user(username, password) values('manager1',SHA2('manager1',256)); 
insert ignore into sec_user(username, password) values('manager2',SHA2('manager2',256)); 
insert ignore into sec_user(username, password) values('manager3',SHA2('manager3',256)); 

insert ignore into sec_user_groups(username, groupname) values('player1','PLAYERS');
insert ignore into sec_user_groups(username, groupname) values('player2','PLAYERS');
insert ignore into sec_user_groups(username, groupname) values('player3','PLAYERS');
insert ignore into sec_user_groups(username, groupname) values('player4','PLAYERS');
insert ignore into sec_user_groups(username, groupname) values('player5','PLAYERS');
insert ignore into sec_user_groups(username, groupname) values('player6','PLAYERS');
insert ignore into sec_user_groups(username, groupname) values('player8','PLAYERS');
insert ignore into sec_user_groups(username, groupname) values('player9','PLAYERS');
insert ignore into sec_user_groups(username, groupname) values('player10','PLAYERS');
insert ignore into sec_user_groups(username, groupname) values('player11','PLAYERS');
insert ignore into sec_user_groups(username, groupname) values('player12','PLAYERS');
insert ignore into sec_user_groups(username, groupname) values('player13','PLAYERS');
insert ignore into sec_user_groups(username, groupname) values('player14','PLAYERS');
insert ignore into sec_user_groups(username, groupname) values('player15','PLAYERS');
insert ignore into sec_user_groups(username, groupname) values('player16','PLAYERS');
insert ignore into sec_user_groups(username, groupname) values('player17','PLAYERS');
insert ignore into sec_user_groups(username, groupname) values('player18','PLAYERS');
insert ignore into sec_user_groups(username, groupname) values('player19','PLAYERS');
insert ignore into sec_user_groups(username, groupname) values('player20','PLAYERS');
insert ignore into sec_user_groups(username, groupname) values('player21','PLAYERS');
insert ignore into sec_user_groups(username, groupname) values('player22','PLAYERS');
insert ignore into sec_user_groups(username, groupname) values('manager1','MANAGERS');
insert ignore into sec_user_groups(username, groupname) values('manager2','MANAGERS');
insert ignore into sec_user_groups(username, groupname) values('manager3','MANAGERS');


insert into tournaments(name) values('Premier League');
insert into tournaments(name) values('Champions League');
insert into tournaments(name) values('FA Cup');
insert into tournaments(name) values('U21 League');
insert into tournaments(name) values('U18 League');


insert into manager(first_name,last_name,yearsoncontract,country,username) values('Jose','Mourinho',5,'Portugal','manager1');
insert into manager(first_name,last_name,yearsoncontract,country,username) values('Warren','Joyce',6,'Wales','manager2');
insert into manager(first_name,last_name,yearsoncontract,country,username) values('Nicky','Butt',7,'England','manager3');

insert into team(name) values('Senior Team',1);
insert into team(name) values('U21 Team',2);
insert into team(name) values('U18 Team',3);
insert into team(name) values('U17 Team',1);
insert into team(name) values('U16 Team',2);
insert into team(name) values('U15 Team',1);



insert into players(first_name,last_name,age,yearsoncontract,username,manager_id) values('Wayne','Rooney',31,2,'player1',1);
insert into players(first_name,last_name,age,yearsoncontract,username,manager_id) values('David', 'De Gea',26,4,'player2',1);
insert into players(first_name,last_name,age,yearsoncontract,username,manager_id) values('Anthony' ,'Martial',20,5,'player3',2);
insert into players(first_name,last_name,age,yearsoncontract,username,manager_id) values('Memphis' ,'Depay',20,5,'player4',2);
insert into players(first_name,last_name,age,yearsoncontract,username,manager_id) values('Marcus' ,'Rashford',18,6,'player5',3);
insert into players(first_name,last_name,age,yearsoncontract,username,manager_id) values('Timothy' ,'Fosu Mensah',17,7,'player6',3);
insert into players(first_name,last_name,age,yearsoncontract,username,manager_id) values('Antonio' ,'Valencia',30,1,'player8',1);
insert into players(first_name,last_name,age,yearsoncontract,username,manager_id) values('Chris' ,'Smalling',26,5,'player9',1);
insert into players(first_name,last_name,age,yearsoncontract,username,manager_id) values('Eric' ,'Bailly',24,5,'player10',1);
insert into players(first_name,last_name,age,yearsoncontract,username,manager_id) values('Daley' ,'Blind',25,5,'player11',1);
insert into players(first_name,last_name,age,yearsoncontract,username,manager_id) values('Ander' ,'Herrera',27,5,'player12',1);
insert into players(first_name,last_name,age,yearsoncontract,username,manager_id) values('Juan' ,'Mata',27,5,'player13',1);
insert into players(first_name,last_name,age,yearsoncontract,username,manager_id) values('Paul' ,'Pogba',23,7,'player14',1);
insert into players(first_name,last_name,age,yearsoncontract,username,manager_id) values('Luke' ,'Shaw',20,6,'player15',2);
insert into players(first_name,last_name,age,yearsoncontract,username,manager_id) values('Alex' ,'Tuanzebe',19,5,'player16',2);
insert into players(first_name,last_name,age,yearsoncontract,username,manager_id) values('James' ,'Wilson',20,6,'player17',2);
insert into players(first_name,last_name,age,yearsoncontract,username,manager_id) values('Andres' ,'Perreira',19,7,'player18',2);
insert into players(first_name,last_name,age,yearsoncontract,username,manager_id) values('Adnana' ,'Januzaj',20,6,'player19',2);
insert into players(first_name,last_name,age,yearsoncontract,username,manager_id) values('Joe' ,'Riley',17,6,'player20',3);
insert into players(first_name,last_name,age,yearsoncontract,username,manager_id) values('Tahith' ,'Chong',14,6,'player21',3);
insert into players(first_name,last_name,age,yearsoncontract,username,manager_id) values('Angel' ,'Gomes',13,6,'player22',3);



insert ignore into Scout(regionofScouting,firstname, lastname)values('Europe','Percy', 'Jackson');
insert ignore into Scout(regionofScouting,firstname, lastname)values('Asia','Manoj', 'Kumar');
insert ignore into Scout(regionofScouting,firstname, lastname)values('America','Scot', 'David');