

OTEL_EXPORTER_OTLP_ENDPOINT="http://localhost:4318"

java -Dotel.service.name=lab3api -Dotel.service.namespace=lab3 -Dotel.exporter.otlp.endpoint="http://localhost:4317" -jar target/banking-2.1.0.null.jar