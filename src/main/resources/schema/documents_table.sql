create table if not exists documents
(
    id              bigint not null primary key,
    path            varchar(255) constraint uk_documents_path unique,
    content         text,
    create_date     timestamp(6),
    expiration_date timestamp(6),
    last_visit_date timestamp(6)
);