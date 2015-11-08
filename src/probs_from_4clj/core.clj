(ns probs-from-4clj.core)

(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))


;; problem 2 (Elementary)
(defn simple-math-solution
  [& args] ;; update args as needed
  ;; If you are not familiar with polish notation, simple arithmetic might seem confusing. Note: Enter only enough to fill in the blank (in this case, a single number) - do not retype the whole problem.
  4)


;; problem 3 (Elementary)
(defn intro-to-strings-solution
  [& args] ;; update args as needed
  ;; Clojure strings are Java strings. This means that you can use any of the Java string methods on Clojure strings.
  "HELLO WORLD")

;; problem 26 (Easy)
(defn fibonacci-sequence-solution
  [n] ;; update args as needed
  ;; Write a function which returns the first X fibonacci numbers.
  (letfn [( fib [a b]
              (cons a
                    (lazy-seq (fib b (+ a b)))) )]
  (take n (fib 1 1)))
  )


;; problem 29 (Easy)
(defn get-the-caps-solution
  [arg] ;; update args as needed
  ;; Write a function which takes a string and returns a new string containing only the capital letters.
  (apply str
         (filter
           #(re-matches
             #"[A-Z]"
             (str %))
           arg)))

;; problem 30 (Easy)
(defn compress-a-sequence-solution
  [arg] ;; update args as needed
  ;; Write a function which removes consecutive duplicates from a sequence.
  (map first (partition-by identity arg )))

;; problem 32 (Easy)
(defn duplicate-a-sequence-solution
  [argseq] ;; update args as needed
  ;; Write a function which duplicates each element of a sequence.
  (mapcat #(vector % %) argseq))


;; problem 41 (Easy)
(defn drop-every-nth-item-solution
  [argcol argnth] ;; update args as needed
  ;; Write a function which drops every Nth item from a sequence.
  (keep-indexed #(if (not= 0 (mod (+ %1 1) argnth)) %2) argcol))




