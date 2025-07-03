import java.util.*;import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        Person[] p = new Person[n];
        for(int i=0; i<n; i++){
            p[i]=new Person(sc.nextInt(), sc.next());
        }
        Arrays.sort(p, new Comparator<Person>(){
            @Override
            public int compare(Person o1, Person o2){
                return o1.age-o2.age;
            }
        });
            
        StringBuilder sbb= new StringBuilder();
        for(int i=0; i<n; i++) sbb.append(p[i]);
        System.out.println(sbb);
    }
    public static class Person{
        private int age;
        private String name;
        public Person(int age, String name){
        this.age= age;
        this.name = name;
        }
        @Override
        public String toString(){
            return age+" "+name+"\n";
        }
    }
}
