(defproject cljurl-graalvm-demo "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [org.martinklepsch/clj-http-lite "0.4.1"]]
  :main ^:skip-aot cljurl-graalvm-demo.core
  :target-path "target/%s"
  :plugins [[io.taylorwood/lein-native-image "0.3.0"]]
  :native-image {:opts ["--verbose"
                        "--no-fallback"
                        "-Dclojure.compiler.direct-linking=true"
                        "-H:+ReportExceptionStackTraces"
                        "--report-unsupported-elements-at-runtime"
                        "--initialize-at-build-time"
                        "--allow-incomplete-classpath"
                        ;; re: --allow-incomplete-classpath: see
                        ;; https://github.com/martinklepsch/clj-http-lite/commit/3f41fc53a1b692549c88a8602e753cfb887330ae
                        ;; the original java.xml.bind.DatatypeConverter never
                        ;; actually gets used on JDK11, but it's still
                        ;; referenced as part of a backwards compatibility trial
                        ;; import, which graal complains about. There's a Graal
                        ;; ticket to make this flag more precise so you don't
                        ;; have to disable classpath completeness checks
                        ;; entirely: https://github.com/oracle/graal/issues/1664
                        "--enable-https"]}
  :profiles {:uberjar {:aot :all}})
