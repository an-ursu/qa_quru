public class LessonJava {
    public static void main(String[] args) {
        //арифметические операций ( + , -, * , /)

        int a = 21;
        int b = 3;

        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);

        // арифметические операций над int и double в одном выражении

        int c = 10;
        double d = 5.5;

        System.out.println(c + d);
        System.out.println(c - d);
        System.out.println(c / d);

        // логические операций ( < , >, >=, <= )

        int n = 15;
        int m = 21;

        System.out.println(n < m);
        System.out.println(n > m);
        System.out.println(n >= m);
        System.out.println(n <= m);


        //получить переполнение при арифметической операции

        int maxInt = Integer.MAX_VALUE;
        System.out.println(maxInt + 1);
    }
}
