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


/** \addtogroup dataset-implementations
 * 
 *  \{
 <p>
 *  \brief A Source which yields fragments wrapping a stream of record batches.
 * 
 *  The record batches must match the schema provided to the source at construction. */
@Namespace("arrow::dataset") @NoOffset @Properties(inherit = org.bytedeco.arrow.presets.arrow_dataset.class)
public class InMemoryDataset extends Dataset {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public InMemoryDataset(Pointer p) { super(p); }

  public static class RecordBatchGenerator extends Pointer {
      static { Loader.load(); }
      /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
      public RecordBatchGenerator(Pointer p) { super(p); }
  
    public native @ByVal RecordBatchIterator Get();
  }

  /** Construct a dataset from a schema and a factory of record batch iterators. */
  public InMemoryDataset(@SharedPtr @ByVal Schema schema,
                    @SharedPtr RecordBatchGenerator get_batches) { super((Pointer)null); allocate(schema, get_batches); }
  private native void allocate(@SharedPtr @ByVal Schema schema,
                    @SharedPtr RecordBatchGenerator get_batches);

  /** Convenience constructor taking a fixed list of batches */
  public InMemoryDataset(@SharedPtr @ByVal Schema schema, @ByVal RecordBatchVector batches) { super((Pointer)null); allocate(schema, batches); }
  private native void allocate(@SharedPtr @ByVal Schema schema, @ByVal RecordBatchVector batches);

  /** Convenience constructor taking a Table */
  public InMemoryDataset(@SharedPtr @Cast({"", "std::shared_ptr<arrow::Table>"}) Table table) { super((Pointer)null); allocate(table); }
  private native void allocate(@SharedPtr @Cast({"", "std::shared_ptr<arrow::Table>"}) Table table);

  public native @StdString String type_name();

  public native @ByVal DatasetResult ReplaceSchema(
        @SharedPtr @ByVal Schema schema);
}
