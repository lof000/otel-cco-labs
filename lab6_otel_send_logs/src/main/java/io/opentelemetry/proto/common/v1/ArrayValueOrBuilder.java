// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: opentelemetry/proto/common/v1/common.proto

// Protobuf Java Version: 4.26.1
package io.opentelemetry.proto.common.v1;

public interface ArrayValueOrBuilder extends
    // @@protoc_insertion_point(interface_extends:opentelemetry.proto.common.v1.ArrayValue)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Array of values. The array may be empty (contain 0 elements).
   * </pre>
   *
   * <code>repeated .opentelemetry.proto.common.v1.AnyValue values = 1;</code>
   */
  java.util.List<io.opentelemetry.proto.common.v1.AnyValue> 
      getValuesList();
  /**
   * <pre>
   * Array of values. The array may be empty (contain 0 elements).
   * </pre>
   *
   * <code>repeated .opentelemetry.proto.common.v1.AnyValue values = 1;</code>
   */
  io.opentelemetry.proto.common.v1.AnyValue getValues(int index);
  /**
   * <pre>
   * Array of values. The array may be empty (contain 0 elements).
   * </pre>
   *
   * <code>repeated .opentelemetry.proto.common.v1.AnyValue values = 1;</code>
   */
  int getValuesCount();
  /**
   * <pre>
   * Array of values. The array may be empty (contain 0 elements).
   * </pre>
   *
   * <code>repeated .opentelemetry.proto.common.v1.AnyValue values = 1;</code>
   */
  java.util.List<? extends io.opentelemetry.proto.common.v1.AnyValueOrBuilder> 
      getValuesOrBuilderList();
  /**
   * <pre>
   * Array of values. The array may be empty (contain 0 elements).
   * </pre>
   *
   * <code>repeated .opentelemetry.proto.common.v1.AnyValue values = 1;</code>
   */
  io.opentelemetry.proto.common.v1.AnyValueOrBuilder getValuesOrBuilder(
      int index);
}
