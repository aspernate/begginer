package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    Solution(){}
    Solution(short a){}
    Solution(int a){}
    private Solution(double a){}
    private Solution(long a){}
    private Solution(float a){}
    public Solution(String a){}
    public Solution(char a){}
    public Solution(Integer a){}
    protected Solution(int a, String b){}
    protected Solution(short a, String b){}
    protected Solution(byte a, String b){}
}

