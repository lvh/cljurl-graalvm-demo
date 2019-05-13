NI="${GRAALVM_HOME}/bin/native-image"
"${NI}" --verbose \
        --no-fallback \
        -Dclojure.compiler.direct-linking=true \
        -H:+ReportExceptionStackTraces \
        -H:+PrintClassInitialization \
        --report-unsupported-elements-at-runtime \
        --initialize-at-build-time \
        --enable-https \
        $@