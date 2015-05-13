class HelloWorld
  def self.hello(subject)
    subject = "world" if subject.empty?
    "Hello, #{subject}!"
  end
end
