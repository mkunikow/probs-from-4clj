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

;; problem 46 (Medium)
(defn flipping-out-solution
  [in-fn] ;; update args as needed
  ;; Write a higher-order function which flips the order of the arguments of an input function.
  (fn [a b]
    (in-fn b a)))

((flipping-out-solution nth) 2 [1 2 3 4 5])



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


;; problem 95 (Easy)
(defn to-tree-or-not-to-tree-solution
  [tree] ;; update args as needed
  ;; Write a predicate which checks whether or not a given sequence represents a binary tree. Each node in the tree must have a value, a left child, and a right child.
  (letfn [(is-b-tree? [tree]
          (if (sequential? tree)
            (if (= (count tree) 3)
              (reduce #(and (is-b-tree? %1) (is-b-tree? %2)) tree)
              false)
            (not(false? tree))))
          ]
    (if (not (or (seq? tree) (vector? tree)))
      false
      (is-b-tree? tree))))


(defn is-b-tree? [tree]
  ;(println (str "tree: " tree))
  (if (or (seq? tree) (vector? tree))
    (if (= (count tree) 3)
      (reduce #(and (is-b-tree? %1) (is-b-tree? %2)) tree)
      false)
    true))


(is-b-tree? [1 nil [2 [3 nil nil] [4 nil nil]]])
(is-b-tree? [1 2 3])
(to-tree-or-not-to-tree-solution [1 [2 [3 [4 false nil] nil] nil] nil])
(to-tree-or-not-to-tree-solution '(:a (:b nil nil) nil))






;; problem 96 (Easy)
(defn beauty-is-symmetry-solution
  [tree] ;; update args as needed
  ;; Let us define a binary tree as "symmetric" if the left half of the tree is the mirror image of the right half of the tree. Write a predicate to determine whether or not a given binary tree is symmetric. (see To Tree, or not to Tree for a reminder on the tree representation we're using).
  (letfn [ (is-b-tree-node-val? [node] (not (or (seq? node) (vector? node))))
          (is-b-tree-valid? [tree]
            (cond
              (not (sequential?  tree)) false
              (not= (count tree) 3) false
              :else
              (let [[root _ _] tree]
                (is-b-tree-node-val? root))
              )
            )

          (is-b-tree-nodes-symetric? [node-left node-right]
            ;(println (str "left" node-left " right" node-right))
            (cond
              (and (nil? node-left) (nil? node-right)) true
              (or (nil? node-left) (nil? node-right)) false
              (and (is-b-tree-node-val? node-left) (is-b-tree-node-val? node-right)) (= node-left node-right)
              (or (is-b-tree-node-val? node-left) (is-b-tree-node-val? node-right)) false
              :else
              (let [[node-left-root node-left-left node-left-right] node-left
                    [node-right-root node-right-left node-right-right] node-right ]
                (and
                  (is-b-tree-node-val? node-left-root)
                  (is-b-tree-node-val? node-right-root)
                  (= node-left-root node-right-root)
                  (is-b-tree-nodes-symetric? node-left-left node-right-right)
                  (is-b-tree-nodes-symetric? node-left-right node-right-left)

                  ))
              )
            )

          (is-b-tree-symetric? [tree]
            (if (is-b-tree-valid? tree)
              (let [[_ left right] tree]
                (is-b-tree-nodes-symetric? left right))
              false))

          ]
    (is-b-tree-symetric? tree)))

;; problem 97 (Easy)
(defn pascal-s-triangle-solution
  [row] ;; update args as needed
  ;; Pascal's triangle is a triangle of numbers computed using the following rules:
  ;;  - The first row is 1. - Each successive row is computed by adding together adjacent numbers in the row above, and adding a 1 to the beginning and end of the row.
  ;;
  ;; Write a function which returns the nth row of Pascal's Triangle.
  ;;
  (letfn [(pascal-triangle-row-zip [rowvec] (map vector rowvec (rest rowvec)))
          (pascal-triiangle-reduce-nest-col [col] (map #(reduce + %) col))
          (pascal-triangle-next-row [row]
            (-> row
                (pascal-triangle-row-zip)
                (pascal-triiangle-reduce-nest-col)
                (conj 1)
                (vec)
                (conj 1)))
          (pascal-triangle [row]
            (loop [row-no row acc [1]]
              (if (= row-no 1)
                acc
                (recur
                  (dec row-no)
                  (pascal-triangle-next-row acc)))))]
    (pascal-triangle row)))


(pascal-s-triangle-solution 5)

(defn pascal-triangle-row-zip [rowvec] (map vector rowvec (rest rowvec)))
(pascal-triangle-row-zip [1 3 3 1])

(defn pascal-triiangle-reduce-nest-col [col] (map #(reduce + %) col))
(pascal-triiangle-reduce-nest-col '([1 3] [3 3] [3 1]))

(defn pascal-triangle-next-row [row]
  (-> row
      (pascal-triangle-row-zip)
      (pascal-triiangle-reduce-nest-col)
      (conj 1)
      (vec)
      (conj 1)))

(pascal-triangle-next-row [1 3 3 1])

(defn pascal-triangle [row]
  (loop [row-no row acc [1]]
  (if (= row-no 1)
    acc
    (recur
      (dec row-no)
      (pascal-triangle-next-row acc)))))

(pascal-triangle 5)






;; problem 100 (Easy)
(defn least-common-multiple-solution
  [& args] ;; update args as needed
  ;; Write a function which calculates the least common multiple. Your function should accept a variable number of positive integers or ratios.
  (letfn [(gdc
              [ain bin]
              (loop [a ain b bin]
                (if (= b 0)
                  a
                  (recur
                    b
                    (mod a b)))))
          (lcm
            [a b]
            (/ (* a b ) (gdc a b)))]
    (reduce lcm args)))

(least-common-multiple-solution 7 5/7 2 3/5)


;; problem 107 (Easy)
(defn simple-closures-solution
  [n] ;; update args as needed
  ;; Lexical scope and first-class functions are two of the most basic building blocks of a functional language like Clojure. When you combine the two together, you get something very powerful called lexical closures. With these, you can exercise a great deal of control over the lifetime of your local bindings, saving their values for use later, long after the code you're running now has finished.
  ;;  It can be hard to follow in the abstract, so let's build a simple closure. Given a positive integer n, return a function (f x) which computes xn. Observe that the effect of this is to preserve the value of n for use outside the scope in which it is defined.

  (fn [x] (reduce * (repeat n x))))








