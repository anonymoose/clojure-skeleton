;;
;; Compojure Routing
;;

(ns myproject.controller.routes
  (:use
   [compojure.core]
   [myproject.lib.web]
   )
  (:require
   [compojure.route :as route]
   [clojure.tools.logging :as log]
   [myproject.controller.sitec]
   [myproject.controller.userc]
   ))


(defroutes app-routes

  (GET "/" [] (myproject.controller.sitec/index))

  ;; (GET "/sign-out" []
  ;;      (myproject.controller.userc/sign-out))

  (GET "/sign-up" []
       (myproject.controller.userc/sign-up))

  (POST "/sign-up" [fname lname email password]
        (myproject.controller.userc/sign-up {
                                         :fname fname
                                         :lname lname
                                         :email email
                                         :password password
                                         }))

  (POST "/add-kid" [name]
        (logged-in? #(myproject.controller.userc/add-kid name)))

  (POST "/remove-kid" [kid_id]
       (logged-in? #(myproject.controller.userc/remove-kid kid_id)))

  (GET "/dashboard" {query-params :query-params}
       (logged-in? #(myproject.controller.userc/dashboard query-params)))

  (GET "/sign-in" [] (myproject.controller.userc/sign-in false))
  (GET "/sign-in/deny" [] (myproject.controller.userc/sign-in true))
  (POST "/sign-in" [email password] (myproject.controller.userc/sign-in email password))

  (GET "/sign-out" [] (myproject.controller.userc/sign-out))
  ;; (GET "/forgot-password" [] (myproject.controller.userc/forgot-password))
  ;; (POST "/forgot-password" [email] (myproject.controller.userc/forgot-password email))

  (GET "/account" [] (myproject.controller.userc/account false))
  (GET "/account/deny" [] (myproject.controller.userc/account true))
  (GET "/account/saved" [] (myproject.controller.userc/account-saved))
  (POST "/account/:id" {{id :id} :params
                        form-params :form-params}
        (logged-in? id #(myproject.controller.userc/account id form-params)))

  (POST "/change-password" {form-params :form-params}
        (logged-in? #(myproject.controller.userc/change-password form-params)))

  (POST "/event-save" {form-params :form-params}
        (logged-in? #(myproject.controller.userc/event-save
                      (form-params "users_id")
                      (form-params "kid_id")
                      form-params)))

  (GET "/event-report" []
       (logged-in? #(myproject.controller.userc/event-report)))

  (GET "/event-view/:id" {{id :id} :params}
       (logged-in? #(myproject.controller.userc/event-view id)))

  (GET "/event/:pg" {{pg :pg} :params}
       (logged-in? #(myproject.controller.userc/event-entry pg))
       )

  (GET "/:pg" [pg] (myproject.controller.sitec/show-page pg))

  ; housekeeping routes
  (route/resources "/")
  ; (route/not-found (myproject.controller.sitec/four-oh-four))
  )
