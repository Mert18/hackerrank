package dev.m2t.problems;

import java.util.*;

class JavaMap{
    public static void main(String []argh)
    {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        Map<String, Integer> phoneBook = new HashMap<>();
        List<String> searched = new ArrayList();
        for(int i=0;i<n;i++)
        {
            String name=in.nextLine();
            int phone=in.nextInt();
            phoneBook.put(name, phone);
            in.nextLine();
        }
        while(in.hasNext())
        {
            String s=in.nextLine();
            searched.add(s);
        }

        for(int i=0; i<searched.size(); i++) {
            Integer number = phoneBook.get(searched.get(i));
            if(number != null) {
                System.out.println(searched.get(i) + "=" + number);
            }else {
                System.out.println("Not found");
            }
        }
    }
}
