(ns bank-account)

(defn open-account []
  (atom {:balance 0}))

(defn close-account [account]
  (swap! account assoc :closed true))

(defn update-balance [account amount]
  (swap! account update-in [:balance] #(+ % amount))
  (get-balance account))

(defn get-balance [account]
  (:balance @account))
