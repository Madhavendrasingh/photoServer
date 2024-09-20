CREATE TABLE IF NOT EXISTS photos (
    id identity primary key,
    file_name varchar(255),
    content_type varchar(255),
    data BINARY LARGE OBJECT
);