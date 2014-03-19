;;
;; Main part of repl workflow.
;;
;; M-x nrepl-jack-in
;;
;; user> (load-file "doc/repl.clj")
;; "ready."
;; user> (util/dt-now)
;; #<DateTime 2013-12-19T19:41:05.074Z>
;; --- do some stuff in the files --
;; user> (re)
;; "ready."
;;


(require '[clj-json.core :as json] :reload)
(require '[clojure.core.memoize] :reload)
(require '[clojure.string :as str] :reload)
(require '[clojure.tools.logging :as log] :reload)

(require '[myproject.lib.mail :as mail] :reload)
(require '[myproject.lib.db :as db] :reload)
;(require '[myproject.lib.sentiment :as sentiment] :reload)
(require '[myproject.lib.util :as util] :reload)

(use '[korma.db])
(use '[korma.core])
(use '[clojure.pprint])

(require '[clojure.reflect :as reflect])

(require '[myproject.controller.common :as common] :reload)
(require '[myproject.controller.userc :as userc] :reload)
(require '[myproject.controller.sitec :as sitec] :reload)
(require '[myproject.model.user :as user] :reload)

(defonce ignored-namespaces (atom #{}))

(defn re []
  (load-file "doc/repl.clj")(load-file "doc/repl.clj")
  ;(doseq [n (remove (comp @ignored-namespaces ns-name) (all-ns))] (require (ns-name n) :reload ))
  )

(defn conn []
  (db/connect-db "postgresql://myproject:myproject@localhost:5432/myproject"))

(defn obj-methods [o]
  (print-table (:members (reflect/reflect o)))
  )

"ready."
