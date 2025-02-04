// Targeted by JavaCPP version 1.5.7-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.parquet;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;

import static org.bytedeco.arrow.global.parquet.*;


@Namespace("parquet") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.parquet.class)
public class ArrowWriterProperties extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public ArrowWriterProperties(Pointer p) { super(p); }

  public enum EngineVersion {
    V1(0),  // Supports only nested lists.
    V2(1);  // Full support for all nesting combinations

      public final int value;
      private EngineVersion(int v) { this.value = v; }
      private EngineVersion(EngineVersion e) { this.value = e.value; }
      public EngineVersion intern() { for (EngineVersion e : values()) if (e.value == value) return e; return this; }
      @Override public String toString() { return intern().name(); }
  }
  @NoOffset public static class Builder extends Pointer {
      static { Loader.load(); }
      /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
      public Builder(Pointer p) { super(p); }
      /** Native array allocator. Access with {@link Pointer#position(long)}. */
      public Builder(long size) { super((Pointer)null); allocateArray(size); }
      private native void allocateArray(long size);
      @Override public Builder position(long position) {
          return (Builder)super.position(position);
      }
      @Override public Builder getPointer(long i) {
          return new Builder((Pointer)this).offsetAddress(i);
      }
  
    public Builder() { super((Pointer)null); allocate(); }
    private native void allocate();

    public native Builder disable_deprecated_int96_timestamps();

    public native Builder enable_deprecated_int96_timestamps();

    public native Builder coerce_timestamps(TimeUnit.type unit);
    public native Builder coerce_timestamps(@Cast("arrow::TimeUnit::type") int unit);

    public native Builder allow_truncated_timestamps();

    public native Builder disallow_truncated_timestamps();

    /** \brief EXPERIMENTAL: Write binary serialized Arrow schema to the file,
     *  to enable certain read options (like "read_dictionary") to be set
     *  automatically */
    public native Builder store_schema();

    public native Builder enable_compliant_nested_types();

    public native Builder disable_compliant_nested_types();

    public native Builder set_engine_version(EngineVersion version);
    public native Builder set_engine_version(@Cast("parquet::ArrowWriterProperties::EngineVersion") int version);

    public native @SharedPtr ArrowWriterProperties build();
  }

  public native @Cast("bool") boolean support_deprecated_int96_timestamps();

  public native @Cast("bool") boolean coerce_timestamps_enabled();
  public native TimeUnit.type coerce_timestamps_unit();

  public native @Cast("bool") boolean truncated_timestamps_allowed();

  
  ///
  public native @Cast("bool") boolean store_schema();

  /** \brief Enable nested type naming according to the parquet specification.
   * 
   *  Older versions of arrow wrote out field names for nested lists based on the name
   *  of the field.  According to the parquet specification they should always be
   *  "element". */
  
  ///
  public native @Cast("bool") boolean compliant_nested_types();

  /** \brief The underlying engine version to use when writing Arrow data.
   * 
   *  V2 is currently the latest V1 is considered deprecated but left in
   *  place in case there are bugs detected in V2. */
  public native EngineVersion engine_version();
}
