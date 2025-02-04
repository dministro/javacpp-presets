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


@Namespace("arrow") @Properties(inherit = org.bytedeco.arrow.presets.arrow_dataset.class)
public class TransformFinish extends Pointer {
    static { Loader.load(); }
    /** Default native constructor. */
    public TransformFinish() { super((Pointer)null); allocate(); }
    /** Native array allocator. Access with {@link Pointer#position(long)}. */
    public TransformFinish(long size) { super((Pointer)null); allocateArray(size); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public TransformFinish(Pointer p) { super(p); }
    private native void allocate();
    private native void allocateArray(long size);
    @Override public TransformFinish position(long position) {
        return (TransformFinish)super.position(position);
    }
    @Override public TransformFinish getPointer(long i) {
        return new TransformFinish((Pointer)this).offsetAddress(i);
    }

  
}
