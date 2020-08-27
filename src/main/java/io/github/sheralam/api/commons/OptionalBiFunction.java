package io.github.sheralam.api.commons;

import java.util.Optional;
import java.util.function.Function;

public interface OptionalBiFunction<PayloadT, ReturnT> extends Function<PayloadT, Optional<ReturnT>> {
}
