(define-module (anagram)
  #:export (anagrams-for))

(define (anagrams-for word candidates)
  (filter (lambda (candidate)
            (let ((word (string-downcase word))
                  (candidate (string-downcase candidate)))
              (and (equal? (sort-string word)
                           (sort-string candidate))
                   (not (equal? candidate word)))))
          candidates))


(define (sort-string str)
  (let ((string-list (string->list str)))
    (apply string
           (map integer->char
                (sort (map char->integer string-list)
                      <)))))
