// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: opentelemetry/proto/common/v1/common.proto

// Protobuf Java Version: 4.26.1
package io.opentelemetry.proto.common.v1;

/**
 * <pre>
 * ArrayValue is a list of AnyValue messages. We need ArrayValue as a message
 * since oneof in AnyValue does not allow repeated fields.
 * </pre>
 *
 * Protobuf type {@code opentelemetry.proto.common.v1.ArrayValue}
 */
public final class ArrayValue extends
    com.google.protobuf.GeneratedMessage implements
    // @@protoc_insertion_point(message_implements:opentelemetry.proto.common.v1.ArrayValue)
    ArrayValueOrBuilder {
private static final long serialVersionUID = 0L;
  static {
    com.google.protobuf.RuntimeVersion.validateProtobufGencodeVersion(
      com.google.protobuf.RuntimeVersion.RuntimeDomain.PUBLIC,
      /* major= */ 4,
      /* minor= */ 26,
      /* patch= */ 1,
      /* suffix= */ "",
      ArrayValue.class.getName());
  }
  // Use ArrayValue.newBuilder() to construct.
  private ArrayValue(com.google.protobuf.GeneratedMessage.Builder<?> builder) {
    super(builder);
  }
  private ArrayValue() {
    values_ = java.util.Collections.emptyList();
  }

  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return io.opentelemetry.proto.common.v1.CommonProto.internal_static_opentelemetry_proto_common_v1_ArrayValue_descriptor;
  }

  @java.lang.Override
  protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
      internalGetFieldAccessorTable() {
    return io.opentelemetry.proto.common.v1.CommonProto.internal_static_opentelemetry_proto_common_v1_ArrayValue_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            io.opentelemetry.proto.common.v1.ArrayValue.class, io.opentelemetry.proto.common.v1.ArrayValue.Builder.class);
  }

  public static final int VALUES_FIELD_NUMBER = 1;
  @SuppressWarnings("serial")
  private java.util.List<io.opentelemetry.proto.common.v1.AnyValue> values_;
  /**
   * <pre>
   * Array of values. The array may be empty (contain 0 elements).
   * </pre>
   *
   * <code>repeated .opentelemetry.proto.common.v1.AnyValue values = 1;</code>
   */
  @java.lang.Override
  public java.util.List<io.opentelemetry.proto.common.v1.AnyValue> getValuesList() {
    return values_;
  }
  /**
   * <pre>
   * Array of values. The array may be empty (contain 0 elements).
   * </pre>
   *
   * <code>repeated .opentelemetry.proto.common.v1.AnyValue values = 1;</code>
   */
  @java.lang.Override
  public java.util.List<? extends io.opentelemetry.proto.common.v1.AnyValueOrBuilder> 
      getValuesOrBuilderList() {
    return values_;
  }
  /**
   * <pre>
   * Array of values. The array may be empty (contain 0 elements).
   * </pre>
   *
   * <code>repeated .opentelemetry.proto.common.v1.AnyValue values = 1;</code>
   */
  @java.lang.Override
  public int getValuesCount() {
    return values_.size();
  }
  /**
   * <pre>
   * Array of values. The array may be empty (contain 0 elements).
   * </pre>
   *
   * <code>repeated .opentelemetry.proto.common.v1.AnyValue values = 1;</code>
   */
  @java.lang.Override
  public io.opentelemetry.proto.common.v1.AnyValue getValues(int index) {
    return values_.get(index);
  }
  /**
   * <pre>
   * Array of values. The array may be empty (contain 0 elements).
   * </pre>
   *
   * <code>repeated .opentelemetry.proto.common.v1.AnyValue values = 1;</code>
   */
  @java.lang.Override
  public io.opentelemetry.proto.common.v1.AnyValueOrBuilder getValuesOrBuilder(
      int index) {
    return values_.get(index);
  }

  private byte memoizedIsInitialized = -1;
  @java.lang.Override
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  @java.lang.Override
  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    for (int i = 0; i < values_.size(); i++) {
      output.writeMessage(1, values_.get(i));
    }
    getUnknownFields().writeTo(output);
  }

  @java.lang.Override
  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    for (int i = 0; i < values_.size(); i++) {
      size += com.google.protobuf.CodedOutputStream
        .computeMessageSize(1, values_.get(i));
    }
    size += getUnknownFields().getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @java.lang.Override
  public boolean equals(final java.lang.Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof io.opentelemetry.proto.common.v1.ArrayValue)) {
      return super.equals(obj);
    }
    io.opentelemetry.proto.common.v1.ArrayValue other = (io.opentelemetry.proto.common.v1.ArrayValue) obj;

    if (!getValuesList()
        .equals(other.getValuesList())) return false;
    if (!getUnknownFields().equals(other.getUnknownFields())) return false;
    return true;
  }

  @java.lang.Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    if (getValuesCount() > 0) {
      hash = (37 * hash) + VALUES_FIELD_NUMBER;
      hash = (53 * hash) + getValuesList().hashCode();
    }
    hash = (29 * hash) + getUnknownFields().hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static io.opentelemetry.proto.common.v1.ArrayValue parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.opentelemetry.proto.common.v1.ArrayValue parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.opentelemetry.proto.common.v1.ArrayValue parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.opentelemetry.proto.common.v1.ArrayValue parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.opentelemetry.proto.common.v1.ArrayValue parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static io.opentelemetry.proto.common.v1.ArrayValue parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static io.opentelemetry.proto.common.v1.ArrayValue parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static io.opentelemetry.proto.common.v1.ArrayValue parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public static io.opentelemetry.proto.common.v1.ArrayValue parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input);
  }

  public static io.opentelemetry.proto.common.v1.ArrayValue parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static io.opentelemetry.proto.common.v1.ArrayValue parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input);
  }
  public static io.opentelemetry.proto.common.v1.ArrayValue parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessage
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  @java.lang.Override
  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(io.opentelemetry.proto.common.v1.ArrayValue prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  @java.lang.Override
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @java.lang.Override
  protected Builder newBuilderForType(
      com.google.protobuf.GeneratedMessage.BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * <pre>
   * ArrayValue is a list of AnyValue messages. We need ArrayValue as a message
   * since oneof in AnyValue does not allow repeated fields.
   * </pre>
   *
   * Protobuf type {@code opentelemetry.proto.common.v1.ArrayValue}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessage.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:opentelemetry.proto.common.v1.ArrayValue)
      io.opentelemetry.proto.common.v1.ArrayValueOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return io.opentelemetry.proto.common.v1.CommonProto.internal_static_opentelemetry_proto_common_v1_ArrayValue_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessage.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return io.opentelemetry.proto.common.v1.CommonProto.internal_static_opentelemetry_proto_common_v1_ArrayValue_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              io.opentelemetry.proto.common.v1.ArrayValue.class, io.opentelemetry.proto.common.v1.ArrayValue.Builder.class);
    }

    // Construct using io.opentelemetry.proto.common.v1.ArrayValue.newBuilder()
    private Builder() {

    }

    private Builder(
        com.google.protobuf.GeneratedMessage.BuilderParent parent) {
      super(parent);

    }
    @java.lang.Override
    public Builder clear() {
      super.clear();
      bitField0_ = 0;
      if (valuesBuilder_ == null) {
        values_ = java.util.Collections.emptyList();
      } else {
        values_ = null;
        valuesBuilder_.clear();
      }
      bitField0_ = (bitField0_ & ~0x00000001);
      return this;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return io.opentelemetry.proto.common.v1.CommonProto.internal_static_opentelemetry_proto_common_v1_ArrayValue_descriptor;
    }

    @java.lang.Override
    public io.opentelemetry.proto.common.v1.ArrayValue getDefaultInstanceForType() {
      return io.opentelemetry.proto.common.v1.ArrayValue.getDefaultInstance();
    }

    @java.lang.Override
    public io.opentelemetry.proto.common.v1.ArrayValue build() {
      io.opentelemetry.proto.common.v1.ArrayValue result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    @java.lang.Override
    public io.opentelemetry.proto.common.v1.ArrayValue buildPartial() {
      io.opentelemetry.proto.common.v1.ArrayValue result = new io.opentelemetry.proto.common.v1.ArrayValue(this);
      buildPartialRepeatedFields(result);
      if (bitField0_ != 0) { buildPartial0(result); }
      onBuilt();
      return result;
    }

    private void buildPartialRepeatedFields(io.opentelemetry.proto.common.v1.ArrayValue result) {
      if (valuesBuilder_ == null) {
        if (((bitField0_ & 0x00000001) != 0)) {
          values_ = java.util.Collections.unmodifiableList(values_);
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.values_ = values_;
      } else {
        result.values_ = valuesBuilder_.build();
      }
    }

    private void buildPartial0(io.opentelemetry.proto.common.v1.ArrayValue result) {
      int from_bitField0_ = bitField0_;
    }

    @java.lang.Override
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof io.opentelemetry.proto.common.v1.ArrayValue) {
        return mergeFrom((io.opentelemetry.proto.common.v1.ArrayValue)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(io.opentelemetry.proto.common.v1.ArrayValue other) {
      if (other == io.opentelemetry.proto.common.v1.ArrayValue.getDefaultInstance()) return this;
      if (valuesBuilder_ == null) {
        if (!other.values_.isEmpty()) {
          if (values_.isEmpty()) {
            values_ = other.values_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureValuesIsMutable();
            values_.addAll(other.values_);
          }
          onChanged();
        }
      } else {
        if (!other.values_.isEmpty()) {
          if (valuesBuilder_.isEmpty()) {
            valuesBuilder_.dispose();
            valuesBuilder_ = null;
            values_ = other.values_;
            bitField0_ = (bitField0_ & ~0x00000001);
            valuesBuilder_ = 
              com.google.protobuf.GeneratedMessage.alwaysUseFieldBuilders ?
                 getValuesFieldBuilder() : null;
          } else {
            valuesBuilder_.addAllMessages(other.values_);
          }
        }
      }
      this.mergeUnknownFields(other.getUnknownFields());
      onChanged();
      return this;
    }

    @java.lang.Override
    public final boolean isInitialized() {
      return true;
    }

    @java.lang.Override
    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              io.opentelemetry.proto.common.v1.AnyValue m =
                  input.readMessage(
                      io.opentelemetry.proto.common.v1.AnyValue.parser(),
                      extensionRegistry);
              if (valuesBuilder_ == null) {
                ensureValuesIsMutable();
                values_.add(m);
              } else {
                valuesBuilder_.addMessage(m);
              }
              break;
            } // case 10
            default: {
              if (!super.parseUnknownField(input, extensionRegistry, tag)) {
                done = true; // was an endgroup tag
              }
              break;
            } // default:
          } // switch (tag)
        } // while (!done)
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.unwrapIOException();
      } finally {
        onChanged();
      } // finally
      return this;
    }
    private int bitField0_;

    private java.util.List<io.opentelemetry.proto.common.v1.AnyValue> values_ =
      java.util.Collections.emptyList();
    private void ensureValuesIsMutable() {
      if (!((bitField0_ & 0x00000001) != 0)) {
        values_ = new java.util.ArrayList<io.opentelemetry.proto.common.v1.AnyValue>(values_);
        bitField0_ |= 0x00000001;
       }
    }

    private com.google.protobuf.RepeatedFieldBuilder<
        io.opentelemetry.proto.common.v1.AnyValue, io.opentelemetry.proto.common.v1.AnyValue.Builder, io.opentelemetry.proto.common.v1.AnyValueOrBuilder> valuesBuilder_;

    /**
     * <pre>
     * Array of values. The array may be empty (contain 0 elements).
     * </pre>
     *
     * <code>repeated .opentelemetry.proto.common.v1.AnyValue values = 1;</code>
     */
    public java.util.List<io.opentelemetry.proto.common.v1.AnyValue> getValuesList() {
      if (valuesBuilder_ == null) {
        return java.util.Collections.unmodifiableList(values_);
      } else {
        return valuesBuilder_.getMessageList();
      }
    }
    /**
     * <pre>
     * Array of values. The array may be empty (contain 0 elements).
     * </pre>
     *
     * <code>repeated .opentelemetry.proto.common.v1.AnyValue values = 1;</code>
     */
    public int getValuesCount() {
      if (valuesBuilder_ == null) {
        return values_.size();
      } else {
        return valuesBuilder_.getCount();
      }
    }
    /**
     * <pre>
     * Array of values. The array may be empty (contain 0 elements).
     * </pre>
     *
     * <code>repeated .opentelemetry.proto.common.v1.AnyValue values = 1;</code>
     */
    public io.opentelemetry.proto.common.v1.AnyValue getValues(int index) {
      if (valuesBuilder_ == null) {
        return values_.get(index);
      } else {
        return valuesBuilder_.getMessage(index);
      }
    }
    /**
     * <pre>
     * Array of values. The array may be empty (contain 0 elements).
     * </pre>
     *
     * <code>repeated .opentelemetry.proto.common.v1.AnyValue values = 1;</code>
     */
    public Builder setValues(
        int index, io.opentelemetry.proto.common.v1.AnyValue value) {
      if (valuesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureValuesIsMutable();
        values_.set(index, value);
        onChanged();
      } else {
        valuesBuilder_.setMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     * Array of values. The array may be empty (contain 0 elements).
     * </pre>
     *
     * <code>repeated .opentelemetry.proto.common.v1.AnyValue values = 1;</code>
     */
    public Builder setValues(
        int index, io.opentelemetry.proto.common.v1.AnyValue.Builder builderForValue) {
      if (valuesBuilder_ == null) {
        ensureValuesIsMutable();
        values_.set(index, builderForValue.build());
        onChanged();
      } else {
        valuesBuilder_.setMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * Array of values. The array may be empty (contain 0 elements).
     * </pre>
     *
     * <code>repeated .opentelemetry.proto.common.v1.AnyValue values = 1;</code>
     */
    public Builder addValues(io.opentelemetry.proto.common.v1.AnyValue value) {
      if (valuesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureValuesIsMutable();
        values_.add(value);
        onChanged();
      } else {
        valuesBuilder_.addMessage(value);
      }
      return this;
    }
    /**
     * <pre>
     * Array of values. The array may be empty (contain 0 elements).
     * </pre>
     *
     * <code>repeated .opentelemetry.proto.common.v1.AnyValue values = 1;</code>
     */
    public Builder addValues(
        int index, io.opentelemetry.proto.common.v1.AnyValue value) {
      if (valuesBuilder_ == null) {
        if (value == null) {
          throw new NullPointerException();
        }
        ensureValuesIsMutable();
        values_.add(index, value);
        onChanged();
      } else {
        valuesBuilder_.addMessage(index, value);
      }
      return this;
    }
    /**
     * <pre>
     * Array of values. The array may be empty (contain 0 elements).
     * </pre>
     *
     * <code>repeated .opentelemetry.proto.common.v1.AnyValue values = 1;</code>
     */
    public Builder addValues(
        io.opentelemetry.proto.common.v1.AnyValue.Builder builderForValue) {
      if (valuesBuilder_ == null) {
        ensureValuesIsMutable();
        values_.add(builderForValue.build());
        onChanged();
      } else {
        valuesBuilder_.addMessage(builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * Array of values. The array may be empty (contain 0 elements).
     * </pre>
     *
     * <code>repeated .opentelemetry.proto.common.v1.AnyValue values = 1;</code>
     */
    public Builder addValues(
        int index, io.opentelemetry.proto.common.v1.AnyValue.Builder builderForValue) {
      if (valuesBuilder_ == null) {
        ensureValuesIsMutable();
        values_.add(index, builderForValue.build());
        onChanged();
      } else {
        valuesBuilder_.addMessage(index, builderForValue.build());
      }
      return this;
    }
    /**
     * <pre>
     * Array of values. The array may be empty (contain 0 elements).
     * </pre>
     *
     * <code>repeated .opentelemetry.proto.common.v1.AnyValue values = 1;</code>
     */
    public Builder addAllValues(
        java.lang.Iterable<? extends io.opentelemetry.proto.common.v1.AnyValue> values) {
      if (valuesBuilder_ == null) {
        ensureValuesIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, values_);
        onChanged();
      } else {
        valuesBuilder_.addAllMessages(values);
      }
      return this;
    }
    /**
     * <pre>
     * Array of values. The array may be empty (contain 0 elements).
     * </pre>
     *
     * <code>repeated .opentelemetry.proto.common.v1.AnyValue values = 1;</code>
     */
    public Builder clearValues() {
      if (valuesBuilder_ == null) {
        values_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
      } else {
        valuesBuilder_.clear();
      }
      return this;
    }
    /**
     * <pre>
     * Array of values. The array may be empty (contain 0 elements).
     * </pre>
     *
     * <code>repeated .opentelemetry.proto.common.v1.AnyValue values = 1;</code>
     */
    public Builder removeValues(int index) {
      if (valuesBuilder_ == null) {
        ensureValuesIsMutable();
        values_.remove(index);
        onChanged();
      } else {
        valuesBuilder_.remove(index);
      }
      return this;
    }
    /**
     * <pre>
     * Array of values. The array may be empty (contain 0 elements).
     * </pre>
     *
     * <code>repeated .opentelemetry.proto.common.v1.AnyValue values = 1;</code>
     */
    public io.opentelemetry.proto.common.v1.AnyValue.Builder getValuesBuilder(
        int index) {
      return getValuesFieldBuilder().getBuilder(index);
    }
    /**
     * <pre>
     * Array of values. The array may be empty (contain 0 elements).
     * </pre>
     *
     * <code>repeated .opentelemetry.proto.common.v1.AnyValue values = 1;</code>
     */
    public io.opentelemetry.proto.common.v1.AnyValueOrBuilder getValuesOrBuilder(
        int index) {
      if (valuesBuilder_ == null) {
        return values_.get(index);  } else {
        return valuesBuilder_.getMessageOrBuilder(index);
      }
    }
    /**
     * <pre>
     * Array of values. The array may be empty (contain 0 elements).
     * </pre>
     *
     * <code>repeated .opentelemetry.proto.common.v1.AnyValue values = 1;</code>
     */
    public java.util.List<? extends io.opentelemetry.proto.common.v1.AnyValueOrBuilder> 
         getValuesOrBuilderList() {
      if (valuesBuilder_ != null) {
        return valuesBuilder_.getMessageOrBuilderList();
      } else {
        return java.util.Collections.unmodifiableList(values_);
      }
    }
    /**
     * <pre>
     * Array of values. The array may be empty (contain 0 elements).
     * </pre>
     *
     * <code>repeated .opentelemetry.proto.common.v1.AnyValue values = 1;</code>
     */
    public io.opentelemetry.proto.common.v1.AnyValue.Builder addValuesBuilder() {
      return getValuesFieldBuilder().addBuilder(
          io.opentelemetry.proto.common.v1.AnyValue.getDefaultInstance());
    }
    /**
     * <pre>
     * Array of values. The array may be empty (contain 0 elements).
     * </pre>
     *
     * <code>repeated .opentelemetry.proto.common.v1.AnyValue values = 1;</code>
     */
    public io.opentelemetry.proto.common.v1.AnyValue.Builder addValuesBuilder(
        int index) {
      return getValuesFieldBuilder().addBuilder(
          index, io.opentelemetry.proto.common.v1.AnyValue.getDefaultInstance());
    }
    /**
     * <pre>
     * Array of values. The array may be empty (contain 0 elements).
     * </pre>
     *
     * <code>repeated .opentelemetry.proto.common.v1.AnyValue values = 1;</code>
     */
    public java.util.List<io.opentelemetry.proto.common.v1.AnyValue.Builder> 
         getValuesBuilderList() {
      return getValuesFieldBuilder().getBuilderList();
    }
    private com.google.protobuf.RepeatedFieldBuilder<
        io.opentelemetry.proto.common.v1.AnyValue, io.opentelemetry.proto.common.v1.AnyValue.Builder, io.opentelemetry.proto.common.v1.AnyValueOrBuilder> 
        getValuesFieldBuilder() {
      if (valuesBuilder_ == null) {
        valuesBuilder_ = new com.google.protobuf.RepeatedFieldBuilder<
            io.opentelemetry.proto.common.v1.AnyValue, io.opentelemetry.proto.common.v1.AnyValue.Builder, io.opentelemetry.proto.common.v1.AnyValueOrBuilder>(
                values_,
                ((bitField0_ & 0x00000001) != 0),
                getParentForChildren(),
                isClean());
        values_ = null;
      }
      return valuesBuilder_;
    }

    // @@protoc_insertion_point(builder_scope:opentelemetry.proto.common.v1.ArrayValue)
  }

  // @@protoc_insertion_point(class_scope:opentelemetry.proto.common.v1.ArrayValue)
  private static final io.opentelemetry.proto.common.v1.ArrayValue DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new io.opentelemetry.proto.common.v1.ArrayValue();
  }

  public static io.opentelemetry.proto.common.v1.ArrayValue getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<ArrayValue>
      PARSER = new com.google.protobuf.AbstractParser<ArrayValue>() {
    @java.lang.Override
    public ArrayValue parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      Builder builder = newBuilder();
      try {
        builder.mergeFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(builder.buildPartial());
      } catch (com.google.protobuf.UninitializedMessageException e) {
        throw e.asInvalidProtocolBufferException().setUnfinishedMessage(builder.buildPartial());
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(e)
            .setUnfinishedMessage(builder.buildPartial());
      }
      return builder.buildPartial();
    }
  };

  public static com.google.protobuf.Parser<ArrayValue> parser() {
    return PARSER;
  }

  @java.lang.Override
  public com.google.protobuf.Parser<ArrayValue> getParserForType() {
    return PARSER;
  }

  @java.lang.Override
  public io.opentelemetry.proto.common.v1.ArrayValue getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

