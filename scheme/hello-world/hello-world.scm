(define-module (hello-world)
  #:export (hello))

(define (hello . args)
  (if (null? args)
      "Hello, world!"
      (string-append "Hello, " (car args) "!")))
