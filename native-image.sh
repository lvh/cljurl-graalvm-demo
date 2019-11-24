NI="${GRAALVM_HOME}/bin/native-image"
"${NI}" --verbose \
        --no-fallback \
        -Dclojure.compiler.direct-linking=true \
        -H:+ReportExceptionStackTraces \
        --report-unsupported-elements-at-runtime \
        --initialize-at-build-time \
        --allow-incomplete-classpath \ # see project.clj for details
        --enable-https \
        $@
