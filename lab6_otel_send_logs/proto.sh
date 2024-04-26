
protoc --java_out=src/main/java opentelemetry/proto/common/v1/common.proto
protoc --java_out=src/main/java opentelemetry/proto/resource/v1/resource.proto
protoc --java_out=src/main/java opentelemetry/proto/logs/v1/logs.proto
protoc --java_out=src/main/java opentelemetry/proto/collector/logs/v1/logs_service.proto


