create table inspection_record
(
  id                 varchar(64)                         not null  primary key,
  code               varchar(64)                         not null  comment '巡检编号',
  mileage            smallint(6)                         not null  comment '里程',
  inspection_user_id varchar(64)                         not null  comment '巡检人ID',
  create_time        timestamp default CURRENT_TIMESTAMP not null  comment '创建时间',
  update_time        timestamp default CURRENT_TIMESTAMP not null  on update CURRENT_TIMESTAMP comment '修改时间'
);

