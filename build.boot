(set-env!
 :source-paths #{"src" "test"}
 :resource-paths #{"html" "build"}
 :dependencies '[
                 ;; React wrapper
                 [reagent "0.5.1"]

                 ;; Dev tools
                 [adzerk/boot-cljs "1.7.48-6" :scope "test"]
                 [adzerk/boot-cljs-repl "0.2.0" :scope "test"]
                 [adzerk/boot-reload "0.4.1" :scope "test"]
                 [pandeiro/boot-http "0.7.0" :scope "test"]
                 [org.clojure/tools.namespace "0.2.11" :scope "test"]

                 ;; Clojure, ClojureScript
                 [org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.145"]])

(require
 '[adzerk.boot-cljs :refer [cljs]]
 '[adzerk.boot-cljs-repl :refer [cljs-repl start-repl]]
 '[adzerk.boot-reload :refer [reload]]
 '[pandeiro.boot-http :refer [serve]])

(deftask dev []
  (comp (serve :dir "target/")
        (watch)
        (speak)
        (reload :on-jsload 'com.aztrana.webclient.dev/reload)
        (cljs-repl)
        (cljs :source-map true :optimizations :none)))

(deftask build []
  (comp (cljs :optimizations :advanced)))
