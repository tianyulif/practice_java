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

chapter6 interface&inner class
1. 接口中不能包含实例域或静态方法，但是可以包含静态常量;与接口中的方法都自动设置为public一样，接口中的域自动设为public static final。
2. 接口与回调 ？
3. 内部类是定义在另一个类中的类。为什么需要使用内部类？主要原因有下面三点：
    ·内部类方法可以访问该类定义所在的作用域中的数据，包括私有数据。
    ·内部类可以对同一个包中的其它类隐藏起来
    ·当想要定义一个回调函数且不想编写大量代码时，使用匿名（anonymous）内部类比较便捷。

chapter11 exception、asset&
1. java语言规范将派生于Error类或RuntimeException类的所有异常称为未检查（unchecked）异常，所有其他的异常称为已检查（checked）异常

chapter12 Generic programming
1. T extends Comparable & Serializable extends只是表示T应该是绑定类型的子类型
2. 无论何时定义一个泛型类型，都自动提供了一个相应的原始类型（raw type）。原始类型的名字就是删去类型参数后的泛型类型名。擦除（erased）类型变量，并替换为限定（无限定的变量用Object）。

chapter13 Collection

chapter14 multithreaded


           core java II
chapter1  Stream&File
1. 在Java API中，可以从其中读入一个字节序列的对象称做输入流，而可以向其中写入一个字节序列的对象称为输出流。抽象类InputStream和OutputStream构成了输入输出类的层次机构基础。







