docker run --env LIQUIBASE_COMMAND_USERNAME=postgres \
  --env LIQUIBASE_COMMAND_PASSWORD=postgres \
  --env LIQUIBASE_COMMAND_URL="jdbc:postgresql://127.0.0.1:5432/todolist?currentSchema=public" \
  --env LIQUIBASE_COMMAND_CHANGELOG_FILE=/liquibase/changelog --rm -v ./src/main/resources/db/changelog:/liquibase/changelog \
   liquibase/liquibase --log-level=info rollback --tag=release-2.0