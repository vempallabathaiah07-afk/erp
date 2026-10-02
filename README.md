# erp

Spring Boot REST API for student records, with Postman workspace assets in `postman/`.

## Requirements

- Java 21 or newer
- MySQL 8

## Database

The schema-only export is in `database/erp_db-schema.sql`. It contains no student rows and does not drop existing tables. Import it into an empty MySQL database with:

```bash
mysql -u root -p < database/erp_db-schema.sql
```

The app connects to `erp_db` on localhost. Set `DB_USERNAME` and `DB_PASSWORD` in the environment before starting it. The password is intentionally not stored in this repository.

## Run

From the `student-api/` directory, set your database credentials, then run:

```powershell
$env:DB_USERNAME = "root"
$env:DB_PASSWORD = "your-local-mysql-password"
.\mvnw.cmd spring-boot:run
```

The API listens on `http://localhost:8081`.