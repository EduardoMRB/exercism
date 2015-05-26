local HelloWorld = {}

function HelloWorld.hello(subject)
  if subject == nil then
    subject = "world"
  end

  return "Hello, " .. subject .. "!"
end

return HelloWorld
