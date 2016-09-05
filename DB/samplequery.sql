select * from wrm_data;

desc wrm_data;

show databases;

create database clairwat_clair;

use wrm;

show tables;


use clairwat_clair;

show tables;

select * from wrm_data;

select user_id,avg(element_value) val, DATE_FORMAT(created_time, '%m-%d-%Y %H:%i') groupDate from wrm_data where user_id = '7cddbfb3-3b58-492e-8d93-c73130c6bb77' and bay_id = 'd11da240-6c3a-11e6-b652-f81654bab016' and water_id = '4e61ea70-6c36-11e6-b652-f81654bab016' and element_id = '166d565c-6c36-11e6-b652-f81654bab016' and created_time between now() - interval 30 day and now() group by groupDate order by created_time desc;

select user_id, bay_id, water_id, element_id, criteria, avg(element_value) element_value, DATE_FORMAT(created_time, '%m-%d-%Y %H:%i') new_created_time, DATE_FORMAT(updated_time, '%m-%d-%Y %H:%i') new_updated_time from wrm_data where created_time between now() - interval 30 day and now() and user_id = '7cddbfb3-3b58-492e-8d93-c73130c6bb77' group by new_updated_time order by new_updated_time desc;

select user_id, bay_id, water_id, element_id, criteria, avg(element_value) element_value, DATE_FORMAT(created_time, '%m-%d-%Y %H:%i') new_created_time, DATE_FORMAT(updated_time, '%m-%d-%Y %H:%i') new_updated_time from wrm_data where DATE_FORMAT(created_time, '%m-%d-%Y %H:%i:%s') between '08-05-2016 00:00:00' and '09-05-2016 00:01:00' and user_id = '7cddbfb3-3b58-492e-8d93-c73130c6bb77' group by new_updated_time order by new_updated_time desc;

select user_id, bay_id, water_id, element_id,  criteria, avg(element_value) as element_value,  DATE_FORMAT(created_time, '%m-%d-%Y %H:%i') as newTimeCreated,  DATE_FORMAT(updated_time, '%m-%d-%Y %H:%i') as newTimeUpdated  from wrm_data where DATE_FORMAT(created_time, '%Y-%m-%d %H:%i:%s') between '2016-08-12 18:38:22' and '2016-09-11 18:38:22' and  user_id='7cddbfb3-3b58-492e-8d93-c73130c6bb77' and bay_id='d11da240-6c3a-11e6-b652-f81654bab016' and water_id='4e61ea70-6c36-11e6-b652-f81654bab016' and element_id='166d565c-6c36-11e6-b652-f81654bab016'  group by newTimeUpdated order by newTimeUpdated desc;



select * from wrm_data order by created_time desc;

select * from wrm_data where user_id = '7cddbfb3-3b58-492e-8d93-c73130c6bb77';

select * from user;

select DATE_FORMAT(created_time, '%m/%d/%Y'),user_id from wrm_data where created_time between now() - interval 30 day and now() order by created_time desc;

use clairwat_clair;

select * from wrm_data;


