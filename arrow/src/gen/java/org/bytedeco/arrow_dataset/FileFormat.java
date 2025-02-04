// Targeted by JavaCPP version 1.5.7-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow_dataset;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;
import org.bytedeco.parquet.*;
import static org.bytedeco.arrow.global.parquet.*;

import static org.bytedeco.arrow.global.arrow_dataset.*;


/** \brief Base class for file format implementation */
@Namespace("arrow::dataset") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow_dataset.class)
public class FileFormat extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public FileFormat(Pointer p) { super(p); }

  /** Options affecting how this format is scanned.
   * 
   *  The options here can be overridden at scan time. */
  public native @SharedPtr FragmentScanOptions default_fragment_scan_options(); public native FileFormat default_fragment_scan_options(FragmentScanOptions setter);

  /** \brief The name identifying the kind of file format */
  public native @StdString String type_name();

  public native @Cast("bool") boolean Equals(@Const @ByRef FileFormat other);

  /** \brief Indicate if the FileSource is supported/readable by this format. */
  public native @ByVal BoolResult IsSupported(@Const @ByRef FileSource source);

  /** \brief Return the schema of the file if possible. */
  public native @ByVal SchemaResult Inspect(@Const @ByRef FileSource source);

  /** \brief Open a FileFragment for scanning.
   *  May populate lazy properties of the FileFragment. */
  public native @ByVal ScanTaskIteratorResult ScanFile(
        @SharedPtr ScanOptions options,
        @Const @SharedPtr @ByRef FileFragment file);

  public native @ByVal RecordBatchGeneratorResult ScanBatchesAsync(
        @SharedPtr ScanOptions options,
        @Const @SharedPtr @ByRef FileFragment file);
  public native @ByVal LongOptionalFuture CountRows(
        @Const @SharedPtr @ByRef FileFragment file, @ByVal Expression predicate,
        @SharedPtr ScanOptions options);

  /** \brief Open a fragment */
  public native @ByVal FileFragmentResult MakeFragment(
        @ByVal FileSource source, @ByVal Expression partition_expression,
        @SharedPtr @ByVal Schema physical_schema);

  /** \brief Create a FileFragment for a FileSource. */
  public native @ByVal FileFragmentResult MakeFragment(
        @ByVal FileSource source, @ByVal Expression partition_expression);

  /** \brief Create a FileFragment for a FileSource. */
  public native @ByVal FileFragmentResult MakeFragment(
        @ByVal FileSource source, @SharedPtr @ByVal(nullValue = "std::shared_ptr<arrow::Schema>(nullptr)") Schema physical_schema);
  public native @ByVal FileFragmentResult MakeFragment(
        @ByVal FileSource source);

  /** \brief Create a writer for this format. */
  public native @ByVal FileWriterResult MakeWriter(
        @SharedPtr OutputStream destination, @SharedPtr @ByVal Schema schema,
        @SharedPtr FileWriteOptions options,
        @ByVal FileLocator destination_locator);

  /** \brief Get default write options for this format. */
  public native @SharedPtr FileWriteOptions DefaultWriteOptions();
}
