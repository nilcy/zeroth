psql -U zeroth -d zeroth -f zeroth-application/zeroth-application-allinone/src/test/data/drop.sql
mvn -pl zeroth-actor/zeroth-actor-service-api test -Dtest=EntityCreator
