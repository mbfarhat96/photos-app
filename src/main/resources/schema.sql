create table if not exists photos (
  id bigint auto_increment primary key,
  FILE_NAME VARCHAR(255),
  CONTENT_TYPE VARCHAR(255),
  DATA BLOB
);