

#ENV VARIABLES
export OTEL_EXPORTER_OTLP_ENDPOINT=http://localhost:4318
export OTEL_RESOURCE_ATTRIBUTES="service.name=demoservice,service.namespace=otel-demo1"

#APM AGENT VARIABLES
export JAVA_TOOL_OPTIONS="-javaagent:opentelemetry-javaagent.jar"

java -jar banking-2.1.0.jar

