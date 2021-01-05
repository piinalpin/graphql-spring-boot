SET AUTOCOMMIT = false;

START TRANSACTION;
    CREATE TABLE m_person (
        id                      BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
        created_at              DATETIME NOT NULL,
        created_by              BIGINT NOT NULL,
        updated_at              DATETIME,
        deleted_at              DATETIME,
        first_name              VARCHAR(255) NOT NULL,
        last_name               VARCHAR(255) NOT NULL,
        date_of_birth           DATETIME NOT NULL,
        identity_type           VARCHAR(255) NOT NULL,
        identity_number         VARCHAR(255) NOT NULL,
        address                 VARCHAR(1000)
    );
COMMIT;
