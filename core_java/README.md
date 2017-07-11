              core java I
chapter5 inheritance
1. 已存在的类称超类（superclass）、基类（baseclass）和父类（parent class）;新类称为子类（subclass）、派生类（derived class）或孩子类（child class）。
2. this两个用途：一是引用隐式参数，二是调用该类其他构造函数。同样，super也有两个用途：
一是调用超类的方法，二是调用超类的构造器。调用构造器只能第一句。
3. 一个对象变量可以指示多种实际类型的现象被称为多态（polymorphism）。运行时能够自动地选择调用
哪个方法的现象称为动态绑定（dynamic binding）。
4. 继承关系---is-a 阻止继承：final类和方法
5. String的hashCode根据值算出来，值相等，hashCode一样。Equals与hashCode的定义必须一致：如果x.equals(y),那么x.hashCode()就必与y.hashCode()具有相同的值。Arrays.toString().
6. 基本数据类型数组如int[],double[]是不能强制转换为Object[]，必须使用包装类，Object数组也不能强制转换为其它类型数组。



