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






;; problem 42 (Easy)
(defn factorial-fun-solution
  [argn] ;; update args as needed
  ;; Write a function which calculates factorials.

  (letfn [( facseq [n fact]
            (cons fact
                  (lazy-seq
                    (facseq
                      (inc n)
                      (* (inc n) fact)))) )]

    (last (take argn (facseq 1 1))))
  )

(defn factorial-fun-solution-rec
  [n] ;; update args as needed
  ;; Write a function which calculates factorials.
  (loop [iter 1 acc 1]
         (if (= iter n)
           acc
         (recur
           (inc iter )
           (* (inc iter) acc))))

  )


(factorial-fun-solution-rec 5)

;; problem 66 (Easy)
(defn greatest-common-divisor-solution
  [ain bin] ;; update args as needed
  ;; Given two integers, write a function which
  ;; returns the greatest common divisor.

  (loop [a ain b bin]
    (if (= b 0)
      a
      (recur
        b
        (mod a b))))
  )


;; problem 83 (Easy)
(defn a-half-truth-solution
  [& args] ;; update args as needed
  ;; Write a function which takes a variable number of booleans. Your function should return true if some of the parameters are true, but not all of the parameters are true. Otherwise your function should return false.
  (let [bcount (count (filter identity args)) totlacount (count args)]
    (and (> bcount 0) (not= bcount totlacount))))


;; problem 88 (Easy)
(defn symmetric-difference-solution
  [s1 s2] ;; update args as needed
  ;; Write a function which returns the symmetric difference of two sets. The symmetric difference is the set of items belonging to one but not both of the two sets.
  (clojure.set/select
    #(not ((clojure.set/intersection s1 s2) %))
    (clojure.set/union s1 s2)))

(symmetric-difference-solution #{1 2 3} #{1 4})


;; problem 90 (Easy)
(defn cartesian-product-solution2
  [a b] ;; update args as needed
  ;; Write a function which calculates the Cartesian product of two sets.
  (letfn [
          (carhelper [el] (
                            map #(vector el %) b
                            ))]
    (set (mapcat carhelper a))))


(defn cartesian-product-solution
  [a b] ;; update args as needed
  ;; Write a function which calculates the Cartesian product of two sets.
  (set (for [ai a bi b ]
    [ai bi]))
  )

(cartesian-product-solution #{1 2} #{3 4 5})

;; problem 107 (Easy)
(defn simple-closures-solution
  [n] ;; update args as needed
  ;; Lexical scope and first-class functions are two of the most basic building blocks of a functional language like Clojure. When you combine the two together, you get something very powerful called lexical closures. With these, you can exercise a great deal of control over the lifetime of your local bindings, saving their values for use later, long after the code you're running now has finished.
  ;;  It can be hard to follow in the abstract, so let's build a simple closure. Given a positive integer n, return a function (f x) which computes xn. Observe that the effect of this is to preserve the value of n for use outside the scope in which it is defined.

  (fn [x] (reduce * (repeat n x))))




