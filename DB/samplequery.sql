select * from wrm_data;

desc wrm_data;

show databases;

create database clairwat_clair;

use wrm;

show tables;


use clairwat_clair;

show tables;

select * from wrm_data;

select user_id,avg(element_value) val, DATE_FORMAT(created_time, '%m-%d-%Y') groupDate from wrm_data where user_id = '7cddbfb3-3b58-492e-8d93-c73130c6bb77' and bay_id = 'd11da240-6c3a-11e6-b652-f81654bab016' and water_id = '4e61ea70-6c36-11e6-b652-f81654bab016' and element_id = '166d565c-6c36-11e6-b652-f81654bab016' and created_time between now() - interval 30 day and now() group by groupDate order by created_time desc;

select user_id, avg(element_value) val, DATE_FORMAT(created_time, '%m-%d-%Y') groupDate from wrm_data where created_time between now() - interval 30 day and now() and user_id = '7cddbfb3-3b58-492e-8d93-c73130c6bb77' group by groupDate order by created_time desc;

select * from wrm_data where user_id = '7cddbfb3-3b58-492e-8d93-c73130c6bb77';

select * from user;

select DATE_FORMAT(created_time, '%m/%d/%Y'),user_id from wrm_data where created_time between now() - interval 30 day and now() order by created_time desc;

use clairwat_clair;

select * from wrm_data;


