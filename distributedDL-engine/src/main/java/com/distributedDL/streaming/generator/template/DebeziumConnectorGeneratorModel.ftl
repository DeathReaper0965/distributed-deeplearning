{
  "name": "${debezuimConModel.connectorName}",
  "config": {
    "connector.class": "io.debezium.connector.postgresql.PostgresConnector",
    "tasks.max": "${debezuimConModel.tasksMax}",
    "plugin.name": "wal2json",
    "database.hostname": "${debezuimConModel.dbHost}",
    "database.port": "${debezuimConModel.dbPort}",
    "database.user": "${debezuimConModel.dbUsername}",
    "database.password": "${debezuimConModel.dbPassword}",
    "database.dbname" : "${debezuimConModel.dbName}",
    "database.server.name": "${debezuimConModel.dbServerName}",
    "key.converter": "org.apache.kafka.connect.json.JsonConverter",
    "value.converter": "org.apache.kafka.connect.json.JsonConverter",
    "key.converter.schemas.enable":"false",
    "value.converter.schemas.enable": "false",
    "slot.name" : "${debezuimConModel.slotName}",
    "decimal.handling.mode": "double"
  }
}
