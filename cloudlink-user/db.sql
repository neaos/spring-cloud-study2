create table `pri_user` (
  `id` varchar(64) not null,
  `name` varchar(64) not null comment '姓名',
  `age` smallint not null comment '年龄',
  `create_time` timestamp not null default current_timestamp comment '创建时间',
  `update_time` timestamp not null default current_timestamp on update current_timestamp comment '修改时间',
  primary key (`id`)
);