drop table project_bean if exists;
create table project_bean (
        project_id bigint not null,
        project_name varchar(255) not null,
        project_manager_id bigint,
        project_manger_name varchar(255),
        project_lead_id bigint,
        project_lead_name varchar(255),
        team_members integer,
        open_requiremnts integer,
        task_count integer,
        active boolean,
        last_updated varchar(255),
        primary key (project_id)
    );
insert into project_bean
values(123456,'Disney-World', 214525, 'Mickey Mouse', 345256, 'Donald Duck', 63, 25, 3, true, CURRENT_TIMESTAMP());

insert into project_bean
values(123458,'Marvels-Avngers', 214535, 'Nick Fiury', 345270, 'Thor', 35, 12, 2, true, CURRENT_TIMESTAMP());



drop table task_bean if exists;

create table task_bean (
       task_id bigint not null,
        task_name varchar(255) not null,
        task_description varchar(255) not null,
        task_active boolean not null,
        initiated_by_id bigint not null,
        initiated_by_name varchar(255) not null,
        last_updated varchar(255) not null,
        
        project_id bigint,
        project_name varchar(255),
        project_manager_id bigint,
        project_manager_name varchar(255),
        project_lead_id bigint,
        project_lead_name varchar(255),
        task_completd boolean,
        
        primary key (task_id)
    );
    
insert into task_bean
values (
    131294, 'Save-World', 'Saving the World from Thanos', true,  134528, 'Tony Stark', CURRENT_TIMESTAMP(), 
    123458,'Marvels-Avngers', 214535, 'Nick Fiury', 345270, 'Thor', false);

insert into task_bean
values (
    131284, 'Collect-Nuts', 'Collecting Nuts for Winters', true,  134518, 'Chip N Dell', CURRENT_TIMESTAMP(), 
    123456,'Disney-World', 214525, 'Mickey Mouse', 345256, 'Donald Duck', false);