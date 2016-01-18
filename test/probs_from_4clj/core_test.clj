(ns probs-from-4clj.core-test
  (:require [clojure.test :refer :all]
            [probs-from-4clj.core :refer :all]))


;; problem 2
(deftest can-simple-math
  (is (= (- 10 (* 2 3)) (simple-math-solution))))


;; problem 3
(deftest can-intro-to-strings
  (is (= (intro-to-strings-solution) (.toUpperCase "hello world"))))


;; problem 26
(deftest can-fibonacci-sequence
  (is (= (fibonacci-sequence-solution 3) '(1 1 2)))
  (is (= (fibonacci-sequence-solution 6) '(1 1 2 3 5 8)))
  (is (= (fibonacci-sequence-solution 8) '(1 1 2 3 5 8 13 21))))


;; problem 29
(deftest can-get-the-caps
  (is (= (get-the-caps-solution "HeLlO, WoRlD!") "HLOWRD"))
  (is (empty? (get-the-caps-solution "nothing")))
  (is (= (get-the-caps-solution "$#A(*&987Zf") "AZ")))


;; problem 30
(deftest can-compress-a-sequence
  (is (= (apply str (compress-a-sequence-solution "Leeeeeerrroyyy")) "Leroy"))
  (is (= (compress-a-sequence-solution [1 1 2 3 3 2 2 3]) '(1 2 3 2 3)))
  (is (= (compress-a-sequence-solution [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))))


;; problem 32
(deftest can-duplicate-a-sequence
  (is (= (duplicate-a-sequence-solution [1 2 3]) '(1 1 2 2 3 3)))
  (is (= (duplicate-a-sequence-solution [:a :a :b :b]) '(:a :a :a :a :b :b :b :b)))
  (is (= (duplicate-a-sequence-solution [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4])))
  (is (= (duplicate-a-sequence-solution [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))))

;; problem 41
(deftest can-drop-every-nth-item
  (is (= (drop-every-nth-item-solution [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8]))
  (is (= (drop-every-nth-item-solution [:a :b :c :d :e :f] 2) [:a :c :e]))
  (is (= (drop-every-nth-item-solution [1 2 3 4 5 6] 4) [1 2 3 5 6])))


;; problem 42
(deftest can-factorial-fun
  (is (= (factorial-fun-solution 1) 1))
  (is (= (factorial-fun-solution 3) 6))
  (is (= (factorial-fun-solution 5) 120))
  (is (= (factorial-fun-solution 8) 40320)))

;; problem 43
(deftest can-reverse-interleave
  (is (= (reverse-interleave-solution [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6))))
  (is (= (reverse-interleave-solution (range 9) 3) '((0 3 6) (1 4 7) (2 5 8))))
  (is (= (reverse-interleave-solution (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))))

;; problem 44
(deftest can-rotate-sequence
  (is (= (rotate-sequence-solution 2 [1 2 3 4 5]) '(3 4 5 1 2)))
  (is (= (rotate-sequence-solution -2 [1 2 3 4 5]) '(4 5 1 2 3)))
  (is (= (rotate-sequence-solution 6 [1 2 3 4 5]) '(2 3 4 5 1)))
  (is (= (rotate-sequence-solution 1 '(:a :b :c)) '(:b :c :a)))
  (is (= (rotate-sequence-solution -4 '(:a :b :c)) '(:c :a :b))))

;; problem 46
(deftest can-flipping-out
  (is (= 3 ((flipping-out-solution nth) 2 [1 2 3 4 5])))
  (is (= true ((flipping-out-solution >) 7 8)))
  (is (= 4 ((flipping-out-solution quot) 2 8)))
  (is (= [1 2 3] ((flipping-out-solution take) [1 2 3 4 5] 3))))

;; problem 66
(deftest can-greatest-common-divisor
  (is (= (greatest-common-divisor-solution 2 4) 2))
  (is (= (greatest-common-divisor-solution 10 5) 5))
  (is (= (greatest-common-divisor-solution 5 7) 1))
  (is (= (greatest-common-divisor-solution 1023 858) 33)))


;; problem 83
(deftest can-a-half-truth
  (is (= false (a-half-truth-solution false false)))
  (is (= true (a-half-truth-solution true false)))
  (is (= false (a-half-truth-solution true)))
  (is (= true (a-half-truth-solution false true false)))
  (is (= false (a-half-truth-solution true true true)))
  (is (= true (a-half-truth-solution true true true false))))


;; problem 88
(deftest can-symmetric-difference
  (is (= (symmetric-difference-solution #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7}))
  (is (= (symmetric-difference-solution #{:a :b :c} #{}) #{:a :b :c}))
  (is (= (symmetric-difference-solution #{} #{4 5 6}) #{4 5 6}))
  (is (= (symmetric-difference-solution #{[1 2] [2 3]} #{[2 3] [3 4]}) #{[1 2] [3 4]})))


;; problem 90
(deftest can-cartesian-product
  (is (= (cartesian-product-solution #{"ace" "king" "queen"} #{"&#9824;" "&#9829;" "&#9830;" "&#9827;"})
         #{["ace"   "&#9824;"] ["ace"   "&#9829;"] ["ace"   "&#9830;"] ["ace"   "&#9827;"]
           ["king"  "&#9824;"] ["king"  "&#9829;"] ["king"  "&#9830;"] ["king"  "&#9827;"]
           ["queen" "&#9824;"] ["queen" "&#9829;"] ["queen" "&#9830;"] ["queen" "&#9827;"]}))
  (is (= (cartesian-product-solution #{1 2 3} #{4 5})
         #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]}))
  (is (= 300 (count (cartesian-product-solution (into #{} (range 10))
                                                (into #{} (range 30)))))))


;; problem 95
(deftest can-to-tree-or-not-to-tree
  (is (= (to-tree-or-not-to-tree-solution '(:a (:b nil nil) nil))
         true))
  (is (= (to-tree-or-not-to-tree-solution '(:a (:b nil nil)))
         false))
  (is (= (to-tree-or-not-to-tree-solution [1 nil [2 [3 nil nil] [4 nil nil]]])
         true))
  (is (= (to-tree-or-not-to-tree-solution [1 [2 nil nil] [3 nil nil] [4 nil nil]])
         false))
  (is (= (to-tree-or-not-to-tree-solution [1 [2 [3 [4 nil nil] nil] nil] nil])
         true))
  (is (= (to-tree-or-not-to-tree-solution [1 [2 [3 [4 false nil] nil] nil] nil])
         false))
  (is (= (to-tree-or-not-to-tree-solution '(:a nil ()))
         false))
  )


;; problem 96
(deftest can-beauty-is-symmetry
  (is (= (beauty-is-symmetry-solution '(:a (:b nil nil) (:b nil nil))) true))
  (is (= (beauty-is-symmetry-solution '(:a (:b nil nil) nil)) false))
  (is (= (beauty-is-symmetry-solution '(:a (:b nil nil) (:c nil nil))) false))
  (is (= (beauty-is-symmetry-solution [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                                       [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]])
         true))
  (is (= (beauty-is-symmetry-solution [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                                       [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil]])
         false))
  (is (= (beauty-is-symmetry-solution [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
                                       [2 [3 nil [4 [6 nil nil] nil]] nil]])
         false))

  )

;; problem 97
(deftest can-pascal-s-triangle
  (is (= (pascal-s-triangle-solution 1) [1]))
  (is (= (map pascal-s-triangle-solution (range 1 6))
         [     [1]
          [1 1]
          [1 2 1]
          [1 3 3 1]
          [1 4 6 4 1]]))
  (is (= (pascal-s-triangle-solution 11)
         [1 10 45 120 210 252 210 120 45 10 1])))

;; problem 100
(deftest can-least-common-multiple
  (is (== (least-common-multiple-solution 2 3) 6))
  (is (== (least-common-multiple-solution 5 3 7) 105))
  (is (== (least-common-multiple-solution 1/3 2/5) 2))
  (is (== (least-common-multiple-solution 3/4 1/6) 3/2))
  (is (== (least-common-multiple-solution 7 5/7 2 3/5) 210)))

;; problem 107
(deftest can-simple-closures
  (is (= 256 ((simple-closures-solution 2) 16),
       ((simple-closures-solution 8) 2)))
  (is (= [1 8 27 64] (map (simple-closures-solution 3) [1 2 3 4])))
  (is (= [1 2 4 8 16] (map #((simple-closures-solution %) 2) [0 1 2 3 4]))))


















