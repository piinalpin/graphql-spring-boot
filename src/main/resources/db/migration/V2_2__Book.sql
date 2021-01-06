SET AUTOCOMMIT = false;

START TRANSACTION;
    CREATE TABLE m_book (
        id                      BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        created_at              DATETIME NOT NULL,
        created_by              BIGINT NOT NULL,
        updated_at              DATETIME,
        deleted_at              DATETIME,
        author_id               BIGINT NOT NULL,
        title                   VARCHAR(255) NOT NULL,
        publisher               VARCHAR(255) NOT NULL,
        description             VARCHAR(255),
        release_date            DATETIME NOT NULL,
        FOREIGN KEY (author_id) REFERENCES m_person(id)
    );
COMMIT;