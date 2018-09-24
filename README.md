### AOPVerify

Q: Spring 中 的AOP的通知有几种类型，对每种Advice写至少一个Test Case来验证它们的工作机制。
  
  AOP : Aspect Oriented Programming 面向切面编程
  - before 在连接点前面执行，前置通知不会影响连接点的执行，除非此处抛出异常。 
  - after 在连接点正常执行完成后执行，如果连接点抛出异常，则不会执行。
  - around 环绕通知围绕在连接点前后，比如一个方法调用的前后。这是最强大的通知类型，能在方法调用前后自定义一些操作。
  - afterThrow 在连接点抛出异常后执行。
  - afterReturning 在连接点执行完成后执行，不管是正常执行完成，还是抛出异常，都会执行返回通知中的内容。 
