psql -U kuzumeji -d kuzumeji -f kuzumeji-ref/kuzumeji-ref-entity/src/main/data/drop.sql
mvn -pl kuzumeji-ref/kuzumeji-ref-entity test -Dtest=EntityCreator
