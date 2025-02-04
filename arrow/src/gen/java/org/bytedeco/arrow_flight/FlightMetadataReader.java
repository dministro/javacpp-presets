// Targeted by JavaCPP version 1.5.7-SNAPSHOT: DO NOT EDIT THIS FILE

package org.bytedeco.arrow_flight;

import java.nio.*;
import org.bytedeco.javacpp.*;
import org.bytedeco.javacpp.annotation.*;

import static org.bytedeco.javacpp.presets.javacpp.*;
import org.bytedeco.arrow.*;
import static org.bytedeco.arrow.global.arrow.*;

import static org.bytedeco.arrow.global.arrow_flight.*;

// #endif

/** \brief A reader for application-specific metadata sent back to the
 *  client during an upload. */
@Namespace("arrow::flight") @Properties(inherit = org.bytedeco.arrow.presets.arrow_flight.class)
public class FlightMetadataReader extends Pointer {
    static { Loader.load(); }
    /** Pointer cast constructor. Invokes {@link Pointer#Pointer(Pointer)}. */
    public FlightMetadataReader(Pointer p) { super(p); }

  /** \brief Read a message from the server. */
  public native @ByVal Status ReadMetadata(@SharedPtr @Cast({"", "std::shared_ptr<arrow::Buffer>*"}) ArrowBuffer out);
}
