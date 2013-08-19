
    alter table sec_orga 
        drop 
        foreign key FK_1r6dqvf0vv2uwk5wvqfpnwddg;

    alter table sec_resc 
        drop 
        foreign key FK_q12vbaxlng2qxmle62b545hf8;

    alter table sec_role_resc 
        drop 
        foreign key FK_cflipb9bobkayvhtrman3xcgn;

    alter table sec_role_resc 
        drop 
        foreign key FK_s69w6uef9xxv4g475mhy6omf7;

    alter table sec_user 
        drop 
        foreign key FK_3m359fjatk8v594ae4ywnff3y;

    alter table sec_user_resc 
        drop 
        foreign key FK_33cw7h8y35yqp1fnhnogp68pn;

    alter table sec_user_resc 
        drop 
        foreign key FK_3j34i4j6joj2vdmyovxuxyhq8;

    alter table sec_user_role 
        drop 
        foreign key FK_gbjxy45gdoyjjskfv4lx10ef7;

    alter table sec_user_role 
        drop 
        foreign key FK_ltjxt102lg9nu9ep8jn7iybmu;

    drop table if exists sec_orga;

    drop table if exists sec_resc;

    drop table if exists sec_role;

    drop table if exists sec_role_resc;

    drop table if exists sec_user;

    drop table if exists sec_user_resc;

    drop table if exists sec_user_role;

    create table sec_orga (
        id bigint not null auto_increment,
        address varchar(255),
        code varchar(255),
        description varchar(255),
        districtCode varchar(255),
        orgaType varchar(255),
        text varchar(255),
        parent_id bigint,
        primary key (id)
    );

    create table sec_resc (
        id bigint not null auto_increment,
        code varchar(255),
        description varchar(255),
        text varchar(255),
        parent_id bigint,
        primary key (id)
    );

    create table sec_role (
        id bigint not null auto_increment,
        code varchar(255),
        description varchar(255),
        name varchar(255),
        primary key (id)
    );

    create table sec_role_resc (
        role_id bigint not null,
        resc_id bigint not null,
        primary key (role_id, resc_id)
    );

    create table sec_user (
        id bigint not null auto_increment,
        fax varchar(255),
        loginName varchar(255),
        password varchar(255),
        phone varchar(255),
        sex varchar(255),
        userCard varchar(255),
        username varchar(255),
        orga_id bigint not null,
        primary key (id)
    );

    create table sec_user_resc (
        user_id bigint not null,
        resc_id bigint not null,
        primary key (user_id, resc_id)
    );

    create table sec_user_role (
        user_id bigint not null,
        role_id bigint not null,
        primary key (user_id, role_id)
    );

    alter table sec_orga 
        add index FK_1r6dqvf0vv2uwk5wvqfpnwddg (parent_id), 
        add constraint FK_1r6dqvf0vv2uwk5wvqfpnwddg 
        foreign key (parent_id) 
        references sec_orga (id);

    alter table sec_resc 
        add index FK_q12vbaxlng2qxmle62b545hf8 (parent_id), 
        add constraint FK_q12vbaxlng2qxmle62b545hf8 
        foreign key (parent_id) 
        references sec_resc (id);

    alter table sec_role_resc 
        add index FK_cflipb9bobkayvhtrman3xcgn (resc_id), 
        add constraint FK_cflipb9bobkayvhtrman3xcgn 
        foreign key (resc_id) 
        references sec_resc (id);

    alter table sec_role_resc 
        add index FK_s69w6uef9xxv4g475mhy6omf7 (role_id), 
        add constraint FK_s69w6uef9xxv4g475mhy6omf7 
        foreign key (role_id) 
        references sec_role (id);

    alter table sec_user 
        add index FK_3m359fjatk8v594ae4ywnff3y (orga_id), 
        add constraint FK_3m359fjatk8v594ae4ywnff3y 
        foreign key (orga_id) 
        references sec_orga (id);

    alter table sec_user_resc 
        add index FK_33cw7h8y35yqp1fnhnogp68pn (resc_id), 
        add constraint FK_33cw7h8y35yqp1fnhnogp68pn 
        foreign key (resc_id) 
        references sec_resc (id);

    alter table sec_user_resc 
        add index FK_3j34i4j6joj2vdmyovxuxyhq8 (user_id), 
        add constraint FK_3j34i4j6joj2vdmyovxuxyhq8 
        foreign key (user_id) 
        references sec_user (id);

    alter table sec_user_role 
        add index FK_gbjxy45gdoyjjskfv4lx10ef7 (role_id), 
        add constraint FK_gbjxy45gdoyjjskfv4lx10ef7 
        foreign key (role_id) 
        references sec_role (id);

    alter table sec_user_role 
        add index FK_ltjxt102lg9nu9ep8jn7iybmu (user_id), 
        add constraint FK_ltjxt102lg9nu9ep8jn7iybmu 
        foreign key (user_id) 
        references sec_user (id);
