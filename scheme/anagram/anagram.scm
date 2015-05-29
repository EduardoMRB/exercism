(define-module (anagram)
  #:export (anagrams-for))

(define (anagrams-for word candidates)
  (filter (lambda (candidate)
            (= (sort-string word)
               (sort-string candidate)))
          candidates))


(define (sort-string str)
  (let ((string-list (string->list str)))
    (apply string (map integer->char
                       (sort (map char->integer string-list)
                             <)))))
